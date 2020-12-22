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
package com.abubusoft.kripton.processor.sqlite.grammars.uri;


/**
 * The Class ContentUriPlaceHolder.
 */
public class ContentUriPlaceHolder {
	
	/** The path segment index. */
	public int pathSegmentIndex;
	
	/** The value. */
	public String value;
	
	/** The composed. */
	public boolean composed;
	
	/**
	 * Instantiates a new content uri place holder.
	 *
	 * @param pathIndex the path index
	 * @param value the value
	 */
	public ContentUriPlaceHolder(int pathIndex, String value) {
		this.pathSegmentIndex=pathIndex;
		this.value=value;
		this.composed=value.indexOf(".")>=0;	
	}
	
}
