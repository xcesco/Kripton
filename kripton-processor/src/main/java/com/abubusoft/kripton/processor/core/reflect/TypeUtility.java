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
package com.abubusoft.kripton.processor.core.reflect;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleTypeVisitor7;
import javax.lang.model.util.Types;

import com.abubusoft.kripton.common.Pair;
import com.abubusoft.kripton.processor.BindTypeSubProcessor;
import com.abubusoft.kripton.processor.core.ModelClass;
import com.abubusoft.kripton.processor.core.ModelProperty;
import com.abubusoft.kripton.processor.exceptions.InvalidMethodSignException;
import com.abubusoft.kripton.processor.sqlite.model.SQLiteModelMethod;
import com.abubusoft.kripton.processor.sqlite.transform.SQLTransform;
import com.abubusoft.kripton.processor.sqlite.transform.SQLTransformer;
import com.abubusoft.kripton.processor.utils.LiteralType;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec.Builder;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;


/**
 * The Class TypeUtility.
 */
public abstract class TypeUtility {

	/**
	 * Checks if is type included in.
	 *
	 * @param value
	 *            the value
	 * @param types
	 *            the types
	 * @return true, if is type included in
	 */
	public static boolean isTypeIncludedIn(TypeName value, Type... types) {
		for (Type item : types) {
			if (value.equals(typeName(item))) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if is type equals.
	 *
	 * @param value
	 *            the value
	 * @param value2
	 *            the value 2
	 * @return true, if is type equals
	 */
	public static boolean isTypeEquals(TypeName value, TypeName value2) {
		return value.equals(value2);
	}

	/**
	 * Checks if is type primitive.
	 *
	 * @param value
	 *            the value
	 * @return true, if is type primitive
	 */
	public static boolean isTypePrimitive(TypeName value) {
		return isTypeIncludedIn(value, Byte.TYPE, Character.TYPE, Boolean.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE,
				Float.TYPE, Double.TYPE);
	}

	/**
	 * Checks if is type wrapped primitive.
	 *
	 * @param value
	 *            the value
	 * @return true, if is type wrapped primitive
	 */
	public static boolean isTypeWrappedPrimitive(TypeName value) {
		return isTypeIncludedIn(value, Byte.class, Character.class, Boolean.class, Short.class, Integer.class,
				Long.class, Float.class, Double.class);
	}

	/**
	 * Checks if is equals.
	 *
	 * @param value
	 *            the value
	 * @param className
	 *            the class name
	 * @return true, if is equals
	 */
	public static boolean isEquals(TypeName value, String className) {
		return isEquals(value, typeName(className));
	}

	/**
	 * Check if its type is byte[].
	 *
	 * @param value
	 *            the value
	 * @return true if it is byte[]
	 */
	public static boolean isByteArray(TypeName value) {
		return value.toString().equals(Byte.TYPE.getCanonicalName() + "[]");
	}

	/**
	 * Check if its type is String.
	 *
	 * @param value
	 *            the value
	 * @return true if it is String
	 */
	public static boolean isString(TypeName value) {
		return value.toString().equals(String.class.getCanonicalName());
	}

	/**
	 * Checks if is nullable.
	 *
	 * @param value
	 *            the value
	 * @return true, if is nullable
	 */
	public static boolean isNullable(TypeName value) {
		return !isTypePrimitive(value);
	}

	/**
	 * Check if class that is rapresented by value has same typeName of entity parameter.
	 *
	 * @param value
	 *            the value
	 * @param entity
	 *            the entity
	 * @return true if value is equals to className.
	 */
	public static boolean isEquals(TypeName value, ModelClass<?> entity) {
		return isEquals(value, entity.getName());
	}

	/**
	 * Check if class that is rapresented by value has same typeName of entity parameter.
	 *
	 * @param value
	 *            the value
	 * @param kindOfParameter
	 *            the kind of parameter
	 * @return true if value is equals to className.
	 */
	public static boolean isEquals(TypeName value, TypeName kindOfParameter) {
		return value.toString().equals(kindOfParameter.toString());
	}

	/**
	 * Generate class typeName.
	 *
	 * @param packageName
	 *            the package name
	 * @param className
	 *            the class name
	 * @param suffix
	 *            the suffix
	 * @return class typeName generated
	 */
	public static ClassName classNameWithSuffix(String packageName, String className, String suffix) {
		return ClassName.get(packageName, className + suffix);
	}

	/**
	 * Generate class typeName.
	 *
	 * @param className
	 *            the class name
	 * @return class typeName generated
	 */
	public static ClassName className(String className) {
		int index = className.lastIndexOf(".");
		if (index > 0) {
			return classNameWithSuffix(className.substring(0, index), className.substring(index + 1), "");
		}
		return ClassName.get("", className);

	}

	/**
	 * Convert a class in a classname.
	 *
	 * @param clazz
	 *            the clazz
	 * @return typeName
	 */
	public static ClassName className(Class<?> clazz) {
		return ClassName.get(clazz);
	}

	/**
	 * Convert a type in a typeName.
	 *
	 * @param type
	 *            the type
	 * @return typeName
	 */
	public static TypeName typeName(Type type) {
		return TypeName.get(type);
	}

	/**
	 * Convert a TypeMirror in a typeName.
	 *
	 * @param typeMirror
	 *            the type mirror
	 * @return typeName
	 */
	public static TypeName typeName(TypeMirror typeMirror) {
		LiteralType literalType = LiteralType.of(typeMirror.toString());

		if (literalType.isArray()) {
			return ArrayTypeName.of(typeName(literalType.getRawType()));
		} else if (literalType.isCollection()) {
			return ParameterizedTypeName.get(TypeUtility.className(literalType.getRawType()),
					typeName(literalType.getTypeParameter()));
		}

		TypeName[] values = { TypeName.BOOLEAN, TypeName.BYTE, TypeName.CHAR, TypeName.DOUBLE, TypeName.FLOAT,
				TypeName.INT, TypeName.LONG, TypeName.SHORT, TypeName.VOID };

		for (TypeName item : values) {
			if (typeMirror.toString().equals(item.toString())) {
				return item;
			}
		}

		return TypeName.get(typeMirror);
	}

	/**
	 * Convert a TypeMirror in a typeName.
	 *
	 * @param packageName
	 *            the package name
	 * @param typeName
	 *            the type name
	 * @return typeName
	 */
	public static TypeName typeName(String packageName, String typeName) {
		return classNameWithSuffix(packageName, typeName, "");
	}

	/**
	 * Merge type name with suffix.
	 *
	 * @param typeName
	 *            the type name
	 * @param typeNameSuffix
	 *            the type name suffix
	 * @return the class name
	 */
	public static ClassName mergeTypeNameWithSuffix(TypeName typeName, String typeNameSuffix) {
		ClassName className = className(typeName.toString());

		return classNameWithSuffix(className.packageName(), className.simpleName(), typeNameSuffix);
	}

	/**
	 * Convert a TypeMirror in a typeName, or classname or whatever.
	 *
	 * @param typeName
	 *            the type name
	 * @return typeName
	 */
	public static TypeName typeName(String typeName) {
		TypeName[] values = { TypeName.BOOLEAN, TypeName.BYTE, TypeName.CHAR, TypeName.DOUBLE, TypeName.FLOAT,
				TypeName.INT, TypeName.LONG, TypeName.SHORT, TypeName.VOID };

		for (TypeName item : values) {
			if (item.toString().equals(typeName)) {
				return item;
			}
		}

		LiteralType literalName = LiteralType.of(typeName);
		if (literalName.isParametrizedType()) {
			return ParameterizedTypeName.get(className(literalName.getRawType()),
					typeName(literalName.getTypeParameter()));
		}
		if (literalName.isArray()) {
			return ArrayTypeName.of(typeName(literalName.getRawType()));
		}

		return ClassName.bestGuess(typeName);
	}

	/**
	 * Convert a TypeMirror in a typeName.
	 *
	 * @param element
	 *            the element
	 * @return typeName
	 */
	public static TypeName typeName(Element element) {
		return TypeName.get(element.asType());
	}

	/**
	 * Checks if is nullable.
	 *
	 * @param property
	 *            the property
	 * @return true, if is nullable
	 */
	public static boolean isNullable(ModelProperty property) {
		return isNullable(property.getPropertyType().getTypeName());
	}


	/**
	 * Check if type if compatibility.
	 *
	 * @param method
	 *            the method
	 * @param item
	 *            the item
	 * @param property
	 *            the property
	 */
	public static void checkTypeCompatibility(SQLiteModelMethod method, Pair<String, TypeName> item,
			ModelProperty property) {
		if (!TypeUtility.isEquals(item.value1, property.getPropertyType().getTypeName())) {
			// ASSERT: property is not nullable but method yes, so we throw an
			// exception
			throw (new InvalidMethodSignException(method,
					String.format(
							"property '%s' is type '%s' and method parameter '%s' is type '%s': they must have same type",
							property.getName(), property.getPropertyType().getTypeName(), item.value0,
							item.value1.toString())));
		}
	}

	/**
	 * generate begin string to translate in code to used in content value or parameter need to be converted in string through String.valueOf
	 *
	 * @param methodBuilder
	 *            the method builder
	 * @param property
	 *            the property
	 */
	public static void beginStringConversion(Builder methodBuilder, ModelProperty property) {
		TypeName modelType = typeName(property.getElement().asType());

		beginStringConversion(methodBuilder, modelType);
	}

	/**
	 * generate begin string to translate in code to used in content value or parameter need to be converted in string through String.valueOf
	 *
	 * @param methodBuilder
	 *            the method builder
	 * @param typeMirror
	 *            the type mirror
	 */
	public static void beginStringConversion(Builder methodBuilder, TypeName typeMirror) {
		SQLTransform transform = SQLTransformer.lookup(typeMirror);

		switch (transform.getColumnType()) {
		case TEXT:
			return;
		case BLOB:
			methodBuilder.addCode("new String(");
			break;
		case INTEGER:
		case REAL:
			methodBuilder.addCode("String.valueOf(");
			break;
		default:
			break;
		}

	}

	/**
	 * generate end string to translate in code to used in content value or parameter need to be converted in string through String.valueOf
	 *
	 * @param methodBuilder
	 *            the method builder
	 * @param property
	 *            the property
	 */
	public static void endStringConversion(Builder methodBuilder, ModelProperty property) {
		TypeName modelType = typeName(property.getElement().asType());

		endStringConversion(methodBuilder, modelType);
	}

	/**
	 * generate end string to translate in code to used in content value or parameter need to be converted in string through String.valueOf
	 *
	 * @param methodBuilder
	 *            the method builder
	 * @param typeMirror
	 *            the type mirror
	 */
	public static void endStringConversion(Builder methodBuilder, TypeName typeMirror) {
		SQLTransform transform = SQLTransformer.lookup(typeMirror);

		switch (transform.getColumnType()) {
		case TEXT:
			return;
		case BLOB:
			methodBuilder.addCode(",$T.UTF_8)", StandardCharsets.class);
			break;
		case INTEGER:
		case REAL:
			methodBuilder.addCode(")");
			break;
		default:
			break;
		}
	}

	/**
	 * Checks if is array.
	 *
	 * @param typeName
	 *            the type name
	 * @return true, if is array
	 */
	public static boolean isArray(TypeName typeName) {
		if (typeName instanceof ArrayTypeName) {
			return true;
		}

		return false;
	}

	/**
	 * Checks if is array.
	 *
	 * @param typeName
	 *            the type name
	 * @return true, if is array
	 */
//	public static boolean isArrayOfType(TypeName typeName, TypeName elementTypeName) {
//		if (typeName instanceof ArrayTypeName && isEquals(((ArrayTypeName) typeName).componentType, elementTypeName)) {
//			return true;
//		}
//
//		return false;
//	}

	/**
	 * Type name.
	 *
	 * @param element
	 *            the element
	 * @param suffix
	 *            the suffix
	 * @return the type name
	 */
	public static TypeName typeName(TypeElement element, String suffix) {
		String fullName = element.getQualifiedName().toString() + suffix;

		int lastIndex = fullName.lastIndexOf(".");

		String packageName = fullName.substring(0, lastIndex);
		String className = fullName.substring(lastIndex + 1);

		return typeName(packageName, className);
	}

	/**
	 * Class name.
	 *
	 * @param packageName
	 *            the package name
	 * @param className
	 *            the class name
	 * @return the class name
	 */
	public static ClassName className(String packageName, String className) {
		return classNameWithSuffix(packageName, className, "");
	}

	/**
	 * Parameterized type name.
	 *
	 * @param rawClass
	 *            the raw class
	 * @param paramClass
	 *            the param class
	 * @return the type name
	 */
	public static TypeName parameterizedTypeName(ClassName rawClass, TypeName paramClass) {
		return ParameterizedTypeName.get(rawClass, paramClass);
	}

	/**
	 * Return simple typeName of class.
	 *
	 * @param clazzName
	 *            the clazz name
	 * @return the string
	 */
	public static String simpleName(TypeName clazzName) {
		String clazz = clazzName.toString();
		int index = clazz.lastIndexOf(".");
		if (index > 0) {
			clazz=clazz.substring(index + 1);
		}
		return clazz;
	}

	/**
	 * Array type name.
	 *
	 * @param type
	 *            the type
	 * @return the array type name
	 */
	public static ArrayTypeName arrayTypeName(Type type) {
		return ArrayTypeName.of(type);
	}

	/**
	 * Given an element, return true if it is a Enum class.
	 *
	 * @param typeName
	 *            the type name
	 * @return true, if is enum
	 */
	public static boolean isEnum(TypeName typeName) {
		return isEnum(typeName.toString());
	}

	/** The Constant JAVA_LANG_ENUM. */
	private static final String JAVA_LANG_ENUM = "java.lang.Enum<?>";

	/**
	 * Checks if is enum.
	 *
	 * @param className
	 *            the class name
	 * @return true, if is enum
	 */
	public static boolean isEnum(String className) {
		try {
			// is it an enum?
			TypeElement element = BindTypeSubProcessor.elementUtils.getTypeElement(className);
			if (element instanceof TypeElement) {
				TypeElement typeElement = element;
				TypeMirror superclass = typeElement.getSuperclass();
				if (superclass instanceof DeclaredType) {
					DeclaredType superclassDeclaredType = (DeclaredType) superclass;

					if (JAVA_LANG_ENUM.equals(getCanonicalTypeName(superclassDeclaredType))) {
						return true;
					}
				}
			}
			return false;
		} catch (Throwable e) {
			return false;
		}
	}

	/**
	 * Convert.
	 *
	 * @param input
	 *            the input
	 * @return the list
	 */
	private static List<TypeName> convert(List<? extends TypeMirror> input) {
		List<TypeName> result = new ArrayList<TypeName>();

		for (TypeMirror item : input) {
			result.add(TypeUtility.typeName(item));
		}

		return result;
	}

	/**
	 * <p>
	 * Retrieve parametrized type of element (from its parent).
	 * </p>
	 *
	 * @param element
	 *            the element
	 * @return list of typemirror or empty list
	 */
	public static List<TypeName> getTypeArguments(TypeElement element) {
		final List<TypeName> result = new ArrayList<>();

		if (element.getKind() == ElementKind.CLASS) {
			if (element.getSuperclass() instanceof DeclaredType) {
				result.addAll(convert(((DeclaredType) element.getSuperclass()).getTypeArguments()));
			}
		} else if (element.getKind() == ElementKind.INTERFACE) {

			List<? extends TypeMirror> interfaces = element.getInterfaces();

			for (TypeMirror item : interfaces) {
				item.accept(new SimpleTypeVisitor7<Void, Void>() {

					@Override
					public Void visitDeclared(DeclaredType t, Void p) {
						result.addAll(convert(t.getTypeArguments()));
						return null;
					}

				}, null);

			}
		}

		return result;
	}

	/**
	 * Returns a string with type parameters replaced with wildcards. This is slightly different from {@link Types#erasure(javax.lang.model.type.TypeMirror)}, which removes all
	 * type parameter data.
	 * 
	 * For instance, if there is a field with type List&lt;String&gt;, this returns a string List&lt;?&gt;.
	 *
	 * @param declaredType
	 *            the declared type
	 * @return the canonical type name
	 */
	private static String getCanonicalTypeName(DeclaredType declaredType) {
		List<? extends TypeMirror> typeArguments = declaredType.getTypeArguments();
		if (!typeArguments.isEmpty()) {
			StringBuilder typeString = new StringBuilder(declaredType.asElement().toString());
			typeString.append('<');
			for (int i = 0; i < typeArguments.size(); i++) {
				if (i > 0) {
					typeString.append(',');
				}
				typeString.append('?');
			}
			typeString.append('>');

			return typeString.toString();
		} else {
			return declaredType.toString();
		}
	}

	/**
	 * Checks if is collection.
	 *
	 * @param typeName
	 *            the type name
	 * @return true, if is collection
	 */
	public static boolean isCollection(TypeName typeName) {
		return isAssignable(typeName, Collection.class);
	}

	/**
	 * Checks if is collection and if element type is the one passed as parameter.
	 *
	 * @param typeName
	 *            the type name
	 * @param elementTypeName
	 *            the element type name
	 * @return true, if is collection
	 */
	public static boolean isCollectionOfType(TypeName typeName, TypeName elementTypeName) {
		return isAssignable(typeName, Collection.class)
				&& isEquals(((ParameterizedTypeName) typeName).typeArguments.get(0), elementTypeName);
	}

	/**
	 * Checks if is list.
	 *
	 * @param typeName
	 *            the type name
	 * @return true, if is list
	 */
	public static boolean isList(TypeName typeName) {
		return isAssignable(typeName, List.class);
	}

	/**
	 * Checks if is sets the.
	 *
	 * @param typeName
	 *            the type name
	 * @return true, if is sets the
	 */
	public static boolean isSet(TypeName typeName) {
		return isAssignable(typeName, Set.class);
	}

	/**
	 * Checks if is map.
	 *
	 * @param typeName
	 *            the type name
	 * @return true, if is map
	 */
	public static boolean isMap(TypeName typeName) {
		return isAssignable(typeName, Map.class);
	}

	/**
	 * Checks if is assignable.
	 *
	 * @param typeName
	 *            the type name
	 * @param assignableClazz
	 *            the assignable clazz
	 * @return true, if is assignable
	 */
	public static boolean isAssignable(TypeName typeName, Class<?> assignableClazz) {
		try {
			if (typeName instanceof ParameterizedTypeName) {
				typeName = ((ParameterizedTypeName) typeName).rawType;
			} else if (typeName instanceof ArrayTypeName) {
				typeName = ((ArrayTypeName) typeName).componentType;
			}

			Class<?> resolvedType = Class.forName(typeName.toString());
			return assignableClazz.isAssignableFrom(resolvedType);
		} catch (ClassNotFoundException e) {
			return false;
		}
	}


	/**
	 * Extract package name.
	 *
	 * @param element
	 *            the element
	 * @return the string
	 */
	public static String extractPackageName(TypeElement element) {
		String fullName = element.getQualifiedName().toString();

		if (fullName.lastIndexOf(".") > 0) {
			return fullName.substring(0, fullName.lastIndexOf("."));
		}
		return "";
	}

	public static String getDefaultValue(TypeName value) {
		if (!isTypePrimitive(value)) {
			return null;
		} else {
			if (value == TypeName.BOOLEAN) {
				return "false";
			} else if (value == TypeName.BYTE) {
				return "(byte)0";
			} else if (value == TypeName.CHAR) {
				return "(char)0";
			} else if (value == TypeName.DOUBLE) {
				return "0.0";
			} else if (value == TypeName.FLOAT) {
				return "0.0f";
			} else if (value == TypeName.INT) {
				return "0";
			} else if (value == TypeName.LONG) {
				return "0";
			} else if (value == TypeName.SHORT) {
				return "(short)0";
			} else {
				return "0";
			}
		}
	}

}
