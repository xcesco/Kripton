/*******************************************************************************
 * Copyright 2016-2019 Francesco Benincasa (info@abubusoft.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.abubusoft.kripton.common;

import java.sql.Date;

/**
 * The Class SQLDateUtils.
 */
public abstract class SQLDateUtils {
	private SQLDateUtils() {

	}

	/**
	 * Write.
	 *
	 * @param value
	 *            the value
	 * @return the string
	 */
	public static String write(Date value) {
		if (value == null)
			return null;

		return value.toString();
	}

	/**
	 * Convert a string to relative locale.
	 *
	 * @param value
	 *            the string
	 * @return the date
	 */
	public static Date read(String value) {
		if (value == null)
			return null;
		return Date.valueOf(value);
	}
}
