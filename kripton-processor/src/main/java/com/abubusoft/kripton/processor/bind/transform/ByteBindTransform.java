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
package com.abubusoft.kripton.processor.bind.transform;



/**
 * Transformer between a string and a Java Byte object.
 *
 * @author xcesco
 */
class ByteBindTransform extends AbstractPrimitiveBindTransform {

	/**
	 * Instantiates a new byte bind transform.
	 *
	 * @param nullable the nullable
	 */
	public ByteBindTransform(boolean nullable) {
		super(nullable);
		
		PRIMITIVE_UTILITY_TYPE="Byte";
		
		XML_TYPE = "Int";	
		XML_CAST_TYPE="(byte)";
		
		if (!nullable)
		{
			DEFAULT_VALUE="(byte)0";
		}
		
		JSON_TYPE = "Number";
		JSON_PARSER_METHOD="getByteValue";
		
		XML_ATTRIBUTE_METHOD_PRE="Integer";
		XML_ATTRIBUTE_METHOD_POST=".byteValue()";
	}

}
