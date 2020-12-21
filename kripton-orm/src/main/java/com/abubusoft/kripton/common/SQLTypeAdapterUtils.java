/*******************************************************************************
 * Copyright 2015, 2017 Francesco Benincasa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.abubusoft.kripton.common;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

import com.abubusoft.kripton.android.SqlTypeAdapter;
import com.abubusoft.kripton.exception.KriptonRuntimeException;


/**
 * The Class SQLTypeAdapterUtils.
 */
public abstract class SQLTypeAdapterUtils {

	/** The lock. */
	static ReentrantLock lock = new ReentrantLock();

	/** The cache. */
	@SuppressWarnings("rawtypes")
	private static HashMap<Class<? extends SqlTypeAdapter>, SqlTypeAdapter> cache = new HashMap<>();
	
	/**
	 * Gets the adapter.
	 *
	 * @param <E> the element type
	 * @param clazz the clazz
	 * @return the adapter
	 */
	public static <E extends SqlTypeAdapter<?, ?>> E getAdapter(Class<E> clazz) {
		@SuppressWarnings("unchecked")
		E adapter = (E) cache.get(clazz);

		if (adapter == null) {
			try {
				lock.lock();
				adapter = clazz.newInstance();
				cache.put(clazz, adapter);
			} catch(Throwable e) {
				throw(new KriptonRuntimeException(e));
			} finally {
				lock.unlock();
			}
		}

		return adapter;
	}

	/**
	 * To data.
	 *
	 * @param <D> the generic type
	 * @param <J> the generic type
	 * @param clazz the clazz
	 * @param javaValue the java value
	 * @return the d
	 */
	@SuppressWarnings("unchecked")
	public static <D, J> D toData(Class<? extends SqlTypeAdapter<J, D>> clazz, J javaValue) {
		SqlTypeAdapter<J, D> adapter = cache.get(clazz);

		if (adapter == null) {
			try {
				lock.lock();
				adapter = clazz.newInstance();
				cache.put(clazz, adapter);
			} catch(Throwable e) {
				throw(new KriptonRuntimeException(e));
			} finally {
				lock.unlock();
			}
		}

		return adapter.toData(javaValue);
	}
	
	/**
	 * To string.
	 *
	 * @param <D> the generic type
	 * @param <J> the generic type
	 * @param clazz the clazz
	 * @param javaValue the java value
	 * @return the string
	 */
	@SuppressWarnings("unchecked")
	public static <D, J> String toString(Class<? extends SqlTypeAdapter<J, D>> clazz, J javaValue) {
		SqlTypeAdapter<J, D> adapter = cache.get(clazz);

		if (adapter == null) {
			try {
				lock.lock();
				adapter = clazz.newInstance();
				cache.put(clazz, adapter);
			} catch(Throwable e) {
				throw(new KriptonRuntimeException(e));
			} finally {
				lock.unlock();
			}
		}

		String value=adapter.toString(javaValue);
		return value==null ? "" : value;
	}
}
