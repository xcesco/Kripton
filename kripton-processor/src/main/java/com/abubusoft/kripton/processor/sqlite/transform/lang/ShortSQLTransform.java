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
package com.abubusoft.kripton.processor.sqlite.transform.lang;

import com.abubusoft.kripton.android.ColumnAffinityType;
import com.abubusoft.kripton.processor.sqlite.transform.WrappedSQLTransformation;
import com.squareup.javapoet.MethodSpec.Builder;


/**
 * <p>Transformer between a string and a Java Short object.</p>
 * 
 * @author Francesco Benincasa (info@abubusoft.com)
 *
 */
public class ShortSQLTransform extends WrappedSQLTransformation {

	public ShortSQLTransform()
	{
		this(true);
	}

	/**
	 * Instantiates a new short SQL transform.
	 *
	 * @param nullable the nullable
	 */
	public ShortSQLTransform(boolean nullable) {
		super(nullable);
		defaultValue = "0";
		if (nullable) {
			defaultValue = "null";
		}

		this.READ_FROM_CURSOR = "$L.getShort($L)";
		this.WRITE_COSTANT="";
	}

	/* (non-Javadoc)
	 * @see com.abubusoft.kripton.processor.sqlite.transform.AbstractSQLTransform#generateDefaultValue(com.squareup.javapoet.MethodSpec.Builder)
	 */
	@Override
	public void generateDefaultValue(Builder methodBuilder) {
		methodBuilder.addCode(defaultValue);
	}

	/* (non-Javadoc)
	 * @see com.abubusoft.kripton.processor.sqlite.transform.SQLTransform#getColumnType()
	 */
	@Override
	public ColumnAffinityType getColumnType() {
		return ColumnAffinityType.INTEGER;
	}

}
