/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.arch.lifecycle;

import static android.arch.lifecycle.Lifecycle.State.DESTROYED;
import static android.arch.lifecycle.Lifecycle.State.STARTED;

import java.util.Iterator;
import java.util.Map;

import android.arch.core.executor.ArchTaskExecutor;
import android.arch.core.internal.SafeIterableMap;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * LiveData is a data holder class that can be observed within a given lifecycle.
 * This means that an {@link Observer} can be added in a pair with a {@link LifecycleOwner}, and
 * this observer will be notified about modifications of the wrapped data only if the paired
 * LifecycleOwner is in active state. LifecycleOwner is considered as active, if its state is
 * {@link Lifecycle.State#STARTED} or {@link Lifecycle.State#RESUMED}. An observer added via
 * {@link #observeForever(Observer)} is considered as always active and thus will be always notified
 * about modifications. For those observers, you should manually call
 * {@link #removeObserver(Observer)}.
 *
 * <p> An observer added with a Lifecycle will be automatically removed if the corresponding
 * Lifecycle moves to {@link Lifecycle.State#DESTROYED} state. This is especially useful for
 * activities and fragments where they can safely observe LiveData and not worry about leaks:
 * they will be instantly unsubscribed when they are destroyed.
 *
 * <p>
 * In addition, LiveData has {@link LiveData#onActive()} and {@link LiveData#onInactive()} methods
 * to get notified when number of active {@link Observer}s change between 0 and 1.
 * This allows LiveData to release any heavy resources when it does not have any Observers that
 * are actively observing.
 * <p>
 * This class is designed to hold individual data fields of ViewModel,
 * but can also be used for sharing data between different modules in your application
 * in a decoupled fashion.
 *
 * @param <T> The type of data held by this instance
 * 
 */
public abstract class LiveData<T> {
    
    /** The m data lock. */
    private final Object mDataLock = new Object();
    
    /** The Constant START_VERSION. */
    static final int START_VERSION = -1;
    
    /** The Constant NOT_SET. */
    private static final Object NOT_SET = new Object();

    /** The m observers. */
    private SafeIterableMap<Observer<T>, ObserverWrapper> mObservers =
            new SafeIterableMap<>();

    /** The m active count. */
    // how many observers are in active state
    private int mActiveCount = 0;
    
    /** The m data. */
    private volatile Object mData = NOT_SET;
    // when setData is called, we set the pending data and actual data swap happens on the main
    /** The m pending data. */
    // thread
    private volatile Object mPendingData = NOT_SET;
    
    /** The m version. */
    private int mVersion = START_VERSION;

    /** The m dispatching value. */
    private boolean mDispatchingValue;
    
    /** The m dispatch invalidated. */
    @SuppressWarnings("FieldCanBeLocal")
    private boolean mDispatchInvalidated;
    
    /** The m post value runnable. */
    private final Runnable mPostValueRunnable = new Runnable() {
        @Override
        public void run() {
            Object newValue;
            synchronized (mDataLock) {
                newValue = mPendingData;
                mPendingData = NOT_SET;
            }
            //noinspection unchecked
            setValue((T) newValue);
        }
    };

    /**
     * Consider notify.
     *
     * @param observer the observer
     */
    private void considerNotify(ObserverWrapper observer) {
        if (!observer.mActive) {
            return;
        }
        // Check latest state b4 dispatch. Maybe it changed state but we didn't get the event yet.
        //
        // we still first check observer.active to keep it as the entrance for events. So even if
        // the observer moved to an active state, if we've not received that event, we better not
        // notify for a more predictable notification order.
        if (!observer.shouldBeActive()) {
            observer.activeStateChanged(false);
            return;
        }
        if (observer.mLastVersion >= mVersion) {
            return;
        }
        observer.mLastVersion = mVersion;
        //noinspection unchecked
        observer.mObserver.onChanged((T) mData);
    }

    /**
     * Dispatching value.
     *
     * @param initiator the initiator
     */
    private void dispatchingValue(@Nullable ObserverWrapper initiator) {
        if (mDispatchingValue) {
            mDispatchInvalidated = true;
            return;
        }
        mDispatchingValue = true;
        do {
            mDispatchInvalidated = false;
            if (initiator != null) {
                considerNotify(initiator);
                initiator = null;
            } else {
                for (Iterator<Map.Entry<Observer<T>, ObserverWrapper>> iterator =
                        mObservers.iteratorWithAdditions(); iterator.hasNext(); ) {
                    considerNotify(iterator.next().getValue());
                    if (mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (mDispatchInvalidated);
        mDispatchingValue = false;
    }

    /**
     * Adds the given observer to the observers list within the lifespan of the given
     * owner. The events are dispatched on the main thread. If LiveData already has data
     * set, it will be delivered to the observer.
     * <p>
     * The observer will only receive events if the owner is in {@link Lifecycle.State#STARTED}
     * or {@link Lifecycle.State#RESUMED} state (active).
     * <p>
     * If the owner moves to the {@link Lifecycle.State#DESTROYED} state, the observer will
     * automatically be removed.
     * <p>
     * When data changes while the {@code owner} is not active, it will not receive any updates.
     * If it becomes active again, it will receive the last available data automatically.
     * <p>
     * LiveData keeps a strong reference to the observer and the owner as long as the
     * given LifecycleOwner is not destroyed. When it is destroyed, LiveData removes references to
     * the observer &amp; the owner.
     * <p>
     * If the given owner is already in {@link Lifecycle.State#DESTROYED} state, LiveData
     * ignores the call.
     * <p>
     * If the given owner, observer tuple is already in the list, the call is ignored.
     * If the observer is already in the list with another owner, LiveData throws an
     * {@link IllegalArgumentException}.
     *
     * @param owner    The LifecycleOwner which controls the observer
     * @param observer The observer that will receive the events
     */
    @MainThread
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<T> observer) {
        if (owner.getLifecycle().getCurrentState() == DESTROYED) {
            // ignore
            return;
        }
        LifecycleBoundObserver wrapper = new LifecycleBoundObserver(owner, observer);
        ObserverWrapper existing = mObservers.putIfAbsent(observer, wrapper);
        if (existing != null && !existing.isAttachedTo(owner)) {
            throw new IllegalArgumentException("Cannot add the same observer"
                    + " with different lifecycles");
        }
        if (existing != null) {
            return;
        }
        owner.getLifecycle().addObserver(wrapper);
    }

    /**
     * Adds the given observer to the observers list. This call is similar to
     * {@link LiveData#observe(LifecycleOwner, Observer)} with a LifecycleOwner, which
     * is always active. This means that the given observer will receive all events and will never
     * be automatically removed. You should manually call {@link #removeObserver(Observer)} to stop
     * observing this LiveData.
     * While LiveData has one of such observers, it will be considered
     * as active.
     * <p>
     * If the observer was already added with an owner to this LiveData, LiveData throws an
     * {@link IllegalArgumentException}.
     *
     * @param observer The observer that will receive the events
     */
    @MainThread
    public void observeForever(@NonNull Observer<T> observer) {
        AlwaysActiveObserver wrapper = new AlwaysActiveObserver(observer);
        ObserverWrapper existing = mObservers.putIfAbsent(observer, wrapper);
        if (existing != null && existing instanceof LiveData.LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer"
                    + " with different lifecycles");
        }
        if (existing != null) {
            return;
        }
        wrapper.activeStateChanged(true);
    }

    /**
     * Removes the given observer from the observers list.
     *
     * @param observer The Observer to receive events.
     */
    @MainThread
    public void removeObserver(@NonNull final Observer<T> observer) {
        assertMainThread("removeObserver");
        ObserverWrapper removed = mObservers.remove(observer);
        if (removed == null) {
            return;
        }
        removed.detachObserver();
        removed.activeStateChanged(false);
    }

    /**
     * Removes all observers that are tied to the given {@link LifecycleOwner}.
     *
     * @param owner The {@code LifecycleOwner} scope for the observers to be removed.
     */
    @SuppressWarnings("WeakerAccess")
    @MainThread
    public void removeObservers(@NonNull final LifecycleOwner owner) {
        assertMainThread("removeObservers");
        for (Map.Entry<Observer<T>, ObserverWrapper> entry : mObservers) {
            if (entry.getValue().isAttachedTo(owner)) {
                removeObserver(entry.getKey());
            }
        }
    }

    /**
     * Posts a task to a main thread to set the given value. So if you have a following code
     * executed in the main thread:
     * <pre class="prettyprint">
     * liveData.postValue("a");
     * liveData.setValue("b");
     * </pre>
     * The value "b" would be set at first and later the main thread would override it with
     * the value "a".
     * <p>
     * If you called this method multiple times before a main thread executed a posted task, only
     * the last value would be dispatched.
     *
     * @param value The new value
     */
    protected void postValue(T value) {
        boolean postTask;
        synchronized (mDataLock) {
            postTask = mPendingData == NOT_SET;
            mPendingData = value;
        }
        if (!postTask) {
            return;
        }
        ArchTaskExecutor.getInstance().postToMainThread(mPostValueRunnable);
    }

    /**
     * Sets the value. If there are active observers, the value will be dispatched to them.
     * <p>
     * This method must be called from the main thread. If you need set a value from a background
     * thread, you can use {@link #postValue(Object)}
     *
     * @param value The new value
     */
    @MainThread
    protected void setValue(T value) {
        assertMainThread("setValue");
        mVersion++;
        mData = value;
        dispatchingValue(null);
    }

    /**
     * Returns the current value.
     * Note that calling this method on a background thread does not guarantee that the latest
     * value set will be received.
     *
     * @return the current value
     */
    @Nullable
    public T getValue() {
        Object data = mData;
        if (data != NOT_SET) {
            //noinspection unchecked
            return (T) data;
        }
        return null;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    int getVersion() {
        return mVersion;
    }

    /**
     * Called when the number of active observers change to 1 from 0.
     * <p>
     * This callback can be used to know that this LiveData is being used thus should be kept
     * up to date.
     */
    protected void onActive() {

    }

    /**
     * Called when the number of active observers change from 1 to 0.
     * <p>
     * This does not mean that there are no observers left, there may still be observers but their
     * lifecycle states aren't {@link Lifecycle.State#STARTED} or {@link Lifecycle.State#RESUMED}
     * (like an Activity in the back stack).
     * <p>
     * You can check if there are observers via {@link #hasObservers()}.
     */
    protected void onInactive() {

    }

    /**
     * Returns true if this LiveData has observers.
     *
     * @return true if this LiveData has observers
     */
    @SuppressWarnings("WeakerAccess")
    public boolean hasObservers() {
        return mObservers.size() > 0;
    }

    /**
     * Returns true if this LiveData has active observers.
     *
     * @return true if this LiveData has active observers
     */
    @SuppressWarnings("WeakerAccess")
    public boolean hasActiveObservers() {
        return mActiveCount > 0;
    }

    /**
     * An asynchronous update interface for receiving notifications
     * about LifecycleBound information as the LifecycleBound is constructed.
     */
    class LifecycleBoundObserver extends ObserverWrapper implements GenericLifecycleObserver {
        
        /** The m owner. */
        @NonNull final LifecycleOwner mOwner;

        /**
         * This method is called when information about an LifecycleBound
         * which was previously requested using an asynchronous
         * interface becomes available.
         *
         * @param owner the owner
         * @param observer the observer
         */
        LifecycleBoundObserver(@NonNull LifecycleOwner owner, Observer<T> observer) {
            super(observer);
            mOwner = owner;
        }

        /* (non-Javadoc)
         * @see android.arch.lifecycle.LiveData.ObserverWrapper#shouldBeActive()
         */
        @Override
        boolean shouldBeActive() {
            return mOwner.getLifecycle().getCurrentState().isAtLeast(STARTED);
        }

        /* (non-Javadoc)
         * @see android.arch.lifecycle.GenericLifecycleObserver#onStateChanged(android.arch.lifecycle.LifecycleOwner, android.arch.lifecycle.Lifecycle.Event)
         */
        @Override
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            if (mOwner.getLifecycle().getCurrentState() == DESTROYED) {
                removeObserver(mObserver);
                return;
            }
            activeStateChanged(shouldBeActive());
        }

        /* (non-Javadoc)
         * @see android.arch.lifecycle.LiveData.ObserverWrapper#isAttachedTo(android.arch.lifecycle.LifecycleOwner)
         */
        @Override
        boolean isAttachedTo(LifecycleOwner owner) {
            return mOwner == owner;
        }

        /* (non-Javadoc)
         * @see android.arch.lifecycle.LiveData.ObserverWrapper#detachObserver()
         */
        @Override
        void detachObserver() {
            mOwner.getLifecycle().removeObserver(this);
        }
    }

    /**
     * The Class ObserverWrapper.
     */
    private abstract class ObserverWrapper {
        
        /** The m observer. */
        final Observer<T> mObserver;
        
        /** The m active. */
        boolean mActive;
        
        /** The m last version. */
        int mLastVersion = START_VERSION;

        /**
         * Instantiates a new observer wrapper.
         *
         * @param observer the observer
         */
        ObserverWrapper(Observer<T> observer) {
            mObserver = observer;
        }

        /**
         * Should be active.
         *
         * @return true, if successful
         */
        abstract boolean shouldBeActive();

        /**
         * Checks if is attached to.
         *
         * @param owner the owner
         * @return true, if is attached to
         */
        boolean isAttachedTo(LifecycleOwner owner) {
            return false;
        }

        /**
         * Detach observer.
         */
        void detachObserver() {
        }

        /**
         * Active state changed.
         *
         * @param newActive the new active
         */
        void activeStateChanged(boolean newActive) {
            if (newActive == mActive) {
                return;
            }
            // immediately set active state, so we'd never dispatch anything to inactive
            // owner
            mActive = newActive;
            boolean wasInactive = LiveData.this.mActiveCount == 0;
            LiveData.this.mActiveCount += mActive ? 1 : -1;
            if (wasInactive && mActive) {
                onActive();
            }
            if (LiveData.this.mActiveCount == 0 && !mActive) {
                onInactive();
            }
            if (mActive) {
                dispatchingValue(this);
            }
        }
    }

    /**
     * An asynchronous update interface for receiving notifications
     * about AlwaysActive information as the AlwaysActive is constructed.
     */
    private class AlwaysActiveObserver extends ObserverWrapper {

        /**
         * This method is called when information about an AlwaysActive
         * which was previously requested using an asynchronous
         * interface becomes available.
         *
         * @param observer the observer
         */
        AlwaysActiveObserver(Observer<T> observer) {
            super(observer);
        }

        /* (non-Javadoc)
         * @see android.arch.lifecycle.LiveData.ObserverWrapper#shouldBeActive()
         */
        @Override
        boolean shouldBeActive() {
            return true;
        }
    }

    /**
     * Assert main thread.
     *
     * @param methodName the method name
     */
    private static void assertMainThread(String methodName) {
        if (!ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException("Cannot invoke " + methodName + " on a background"
                    + " thread");
        }
    }
}
