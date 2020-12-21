/*******************************************************************************
 * Copyright 2015, 2017 Francesco Benincasa (info@abubusoft.com).
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
package com.abubusoft.kripton.processor.exceptions;

import com.abubusoft.kripton.processor.sqlite.model.SQLiteModelMethod;


/**
 * The Class MethodParameterNotFoundException.
 */
public class MethodParameterNotFoundException extends KriptonProcessorException {

	/**
	 * Instantiates a new method parameter not found exception.
	 *
	 * @param method the method
	 * @param paramName the param name
	 */
	public MethodParameterNotFoundException(SQLiteModelMethod method, String paramName) {
		super(String.format("In class '%s', annotation of method '%s' uses method parameter '%s' that does not exists", method.getParent().getName(), method.getName(), paramName));
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8862365033337349246L;

}
