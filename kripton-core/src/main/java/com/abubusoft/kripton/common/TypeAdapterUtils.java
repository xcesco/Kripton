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

import com.abubusoft.kripton.TypeAdapter;
import com.abubusoft.kripton.exception.KriptonRuntimeException;


/**
 * The Class TypeAdapterUtils.
 */
public abstract class TypeAdapterUtils {

	/** The lock. */
	static ReentrantLock lock = new ReentrantLock();

	/** The cache. */
	@SuppressWarnings("rawtypes")
	private static HashMap<Class<? extends TypeAdapter>, TypeAdapter> cache = new HashMap<>();

	/**
	 * To java.
	 *
	 * @param <D> the generic type
	 * @param <J> the generic type
	 * @param clazz the clazz
	 * @param value the value
	 * @return the j
	 */
	@SuppressWarnings("unchecked")
	public static <D, J> J toJava(Class<? extends TypeAdapter<J, D>> clazz, D value) {
		TypeAdapter<J, D> adapter = cache.get(clazz);

		if (adapter == null) {
			adapter = generateAdapter(cache, lock, clazz);
		}

		return adapter.toJava(value);
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
	public static <D, J> D toData(Class<? extends TypeAdapter<J, D>> clazz, J javaValue) {
		TypeAdapter<J, D> adapter = cache.get(clazz);

		if (adapter == null) {
			adapter = generateAdapter(cache, lock, clazz);
		}

		return adapter.toData(javaValue);
	}

	/**
	 * Generate adapter.
	 *
	 * @param <D> the generic type
	 * @param cache the cache
	 * @param lock the lock
	 * @param clazz the clazz
	 * @return the d
	 */
	@SuppressWarnings("rawtypes")
	static <D extends TypeAdapter> D generateAdapter(HashMap<Class<? extends TypeAdapter>, TypeAdapter> cache, ReentrantLock lock, Class<D> clazz) {
		D adapter = null;
		try {
			lock.lock();
			adapter = clazz.newInstance();
			cache.put(clazz, adapter);
		} catch (Throwable e) {
			throw (new KriptonRuntimeException(e));
		} finally {
			lock.unlock();			
		}
		return adapter;
	}
}
