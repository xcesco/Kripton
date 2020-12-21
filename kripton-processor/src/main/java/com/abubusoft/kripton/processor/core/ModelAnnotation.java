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
package com.abubusoft.kripton.processor.core;

import java.util.List;
import java.util.Map;

import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.processor.core.reflect.AnnotationUtility;


/**
 * The Class ModelAnnotation.
 */
public class ModelAnnotation {

	/** The name. */
	protected String name;

	/**
	 * Gets the name.
	 *
	 * @return the typeName
	 */
	public String getName() {
		return name;
	}

	/** The attributes. */
	protected Map<String, String> attributes;

	/**
	 * Instantiates a new model annotation.
	 *
	 * @param name the name
	 * @param attributes the attributes
	 */
	public ModelAnnotation(String name, Map<String, String> attributes) {
		this.name = name;
		this.attributes = attributes;
	}

	/**
	 * Gets the attribute.
	 *
	 * @param attribute the attribute
	 * @return the attribute
	 */
	public String getAttribute(AnnotationAttributeType attribute) {
		return attributes.get(attribute.getValue());
	}

	/**
	 * Gets the attribute count.
	 *
	 * @return the attribute count
	 */
	public int getAttributeCount() {
		return attributes.size();
	}

	/**
	 * Gets the simple name.
	 *
	 * @return the simple name
	 */
	public String getSimpleName() {
		return name.substring(name.lastIndexOf(".") + 1);
	}

	/**
	 * Gets the attribute as class name.
	 *
	 * @param attribute the attribute
	 * @return the attribute as class name
	 */
	public String getAttributeAsClassName(AnnotationAttributeType attribute) {
		String temp = attributes.get(attribute.getValue());

		if (StringUtils.hasText(temp)) {
			temp = temp.replace(".class", "");
		}

		return temp;
	}

	/**
	 * Gets the attribute as boolean.
	 *
	 * @param attribute the attribute
	 * @return the attribute as boolean
	 */
	public boolean getAttributeAsBoolean(AnnotationAttributeType attribute) {
		String temp = attributes.get(attribute.getValue());

		return Boolean.parseBoolean(temp);
	}

	/**
	 * Gets the attribute as array.
	 *
	 * @param attribute the attribute
	 * @return the attribute as array
	 */
	public List<String> getAttributeAsArray(AnnotationAttributeType attribute) {
		String temp = attributes.get(attribute.getValue());

		return AnnotationUtility.extractAsArrayOfString(temp);
	}

	/**
	 * Gets the attribute as int.
	 *
	 * @param attribute the attribute
	 * @return the attribute as int
	 */
	public int getAttributeAsInt(AnnotationAttributeType attribute) {
		String temp = attributes.get(attribute.getValue());

		return Integer.parseInt(temp);
	}

}
