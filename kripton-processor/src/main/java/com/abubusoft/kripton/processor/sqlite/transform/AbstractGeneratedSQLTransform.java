/*******************************************************************************
 * Copyright 2015, 2016 Francesco Benincasa (info@abubusoft.com).
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
package com.abubusoft.kripton.processor.sqlite.transform;

import static com.abubusoft.kripton.processor.core.reflect.PropertyUtility.getter;
import static com.abubusoft.kripton.processor.core.reflect.PropertyUtility.setter;

import com.abubusoft.kripton.android.ColumnAffinityType;
import com.abubusoft.kripton.processor.core.ModelProperty;
import com.abubusoft.kripton.processor.core.reflect.TypeUtility;
import com.abubusoft.kripton.processor.sqlite.model.SQLiteDaoDefinition;
import com.abubusoft.kripton.processor.sqlite.model.SQLiteModelMethod;
import com.squareup.javapoet.MethodSpec.Builder;
import com.squareup.javapoet.TypeName;


/**
 * <p>
 * Transform for complex data type like list, set and POJO.
 * </p>
 *
 */
public abstract class AbstractGeneratedSQLTransform extends AbstractSQLTransform {

	/* (non-Javadoc)
	 * @see com.abubusoft.kripton.processor.sqlite.transform.SQLTransform#generateWriteProperty2ContentValues(com.squareup.javapoet.MethodSpec.Builder, java.lang.String, com.squareup.javapoet.TypeName, com.abubusoft.kripton.processor.core.ModelProperty)
	 */
	@Override
	public void generateWriteProperty2ContentValues(Builder methodBuilder, String beanName, TypeName beanClass, ModelProperty property) {
		methodBuilder.addCode("$T.serialize$L($L)", TypeUtility.mergeTypeNameWithSuffix(beanClass, "Table"), formatter.convert(property.getName()), getter(beanName, beanClass, property));
	}
	
	/* (non-Javadoc)
	 * @see com.abubusoft.kripton.processor.sqlite.transform.AbstractSQLTransform#generateWriteParam2ContentValues(com.squareup.javapoet.MethodSpec.Builder, com.abubusoft.kripton.processor.sqlite.model.SQLiteModelMethod, java.lang.String, com.squareup.javapoet.TypeName, com.abubusoft.kripton.processor.core.ModelProperty)
	 */
	@Override
	public void generateWriteParam2ContentValues(Builder methodBuilder, SQLiteModelMethod method, String paramName, TypeName paramTypeName, ModelProperty property) {	
		String methodName = method.getParent().generateJava2ContentSerializer(paramTypeName);

		methodBuilder.addCode("$L($L)", methodName, paramName);
	}

	/* (non-Javadoc)
	 * @see com.abubusoft.kripton.processor.sqlite.transform.SQLTransform#generateWriteParam2WhereCondition(com.squareup.javapoet.MethodSpec.Builder, com.abubusoft.kripton.processor.sqlite.model.SQLiteModelMethod, java.lang.String, com.squareup.javapoet.TypeName)
	 */
	@Override
	public void generateWriteParam2WhereCondition(Builder methodBuilder, SQLiteModelMethod method, String paramName, TypeName paramTypeName) {
		String methodName = method.getParent().generateJava2ContentSerializer(paramTypeName);

		methodBuilder.addCode("$L($L)", methodName, paramName);
	}

	/* (non-Javadoc)
	 * @see com.abubusoft.kripton.processor.sqlite.transform.AbstractSQLTransform#generateReadValueFromCursor(com.squareup.javapoet.MethodSpec.Builder, com.abubusoft.kripton.processor.sqlite.model.SQLiteDaoDefinition, com.squareup.javapoet.TypeName, java.lang.String, java.lang.String)
	 */
	@Override
	public void generateReadValueFromCursor(Builder methodBuilder, SQLiteDaoDefinition daoDefinition, TypeName paramTypeName, String cursorName, String indexName) {
		String methodName = daoDefinition.generateJava2ContentParser(paramTypeName);

		methodBuilder.addCode("$L($L.getBlob($L))", methodName, cursorName, indexName);
	}

	/* (non-Javadoc)
	 * @see com.abubusoft.kripton.processor.sqlite.transform.SQLTransform#generateReadPropertyFromCursor(com.squareup.javapoet.MethodSpec.Builder, com.squareup.javapoet.TypeName, java.lang.String, com.abubusoft.kripton.processor.core.ModelProperty, java.lang.String, java.lang.String)
	 */
	@Override
	public void generateReadPropertyFromCursor(Builder methodBuilder, TypeName beanClass, String beanName, ModelProperty property, String cursorName, String indexName) {
		methodBuilder.addCode(setter(beanClass, beanName, property, "$T.parse$L($L.getBlob($L))"), TypeUtility.mergeTypeNameWithSuffix(beanClass, "Table"), formatter.convert(property.getName()), cursorName,
				indexName);
	}

	/* (non-Javadoc)
	 * @see com.abubusoft.kripton.processor.sqlite.transform.SQLTransform#generateResetProperty(com.squareup.javapoet.MethodSpec.Builder, com.squareup.javapoet.TypeName, java.lang.String, com.abubusoft.kripton.processor.core.ModelProperty, java.lang.String, java.lang.String)
	 */
	@Override
	public void generateResetProperty(Builder methodBuilder, TypeName beanClass, String beanName, ModelProperty property, String cursorName, String indexName) {
		methodBuilder.addCode(setter(beanClass, beanName, property, "null"));
	}

	/* (non-Javadoc)
	 * @see com.abubusoft.kripton.processor.sqlite.transform.SQLTransform#getColumnType()
	 */
	@Override
	public ColumnAffinityType getColumnType() {
		return ColumnAffinityType.BLOB;
	}

}
