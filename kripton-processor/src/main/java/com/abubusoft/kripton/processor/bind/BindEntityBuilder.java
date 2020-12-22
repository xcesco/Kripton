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
package com.abubusoft.kripton.processor.bind;

import java.util.List;
import java.util.Map;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import com.abubusoft.kripton.android.annotation.BindSqlType;
import com.abubusoft.kripton.annotation.Bind;
import com.abubusoft.kripton.annotation.BindAdapter;
import com.abubusoft.kripton.annotation.BindDisabled;
import com.abubusoft.kripton.annotation.BindType;
import com.abubusoft.kripton.annotation.BindXml;
import com.abubusoft.kripton.annotation.BindXmlType;
import com.abubusoft.kripton.common.CaseFormat;
import com.abubusoft.kripton.common.Converter;
import com.abubusoft.kripton.common.Pair;
import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.processor.BaseProcessor;
import com.abubusoft.kripton.processor.bind.model.BindEntity;
import com.abubusoft.kripton.processor.bind.model.BindModel;
import com.abubusoft.kripton.processor.bind.model.BindProperty;
import com.abubusoft.kripton.processor.bind.transform.BindTransform;
import com.abubusoft.kripton.processor.bind.transform.BindTransformer;
import com.abubusoft.kripton.processor.bind.transform.ByteArrayBindTransform;
import com.abubusoft.kripton.processor.bind.transform.ObjectBindTransform;
import com.abubusoft.kripton.processor.core.AnnotationAttributeType;
import com.abubusoft.kripton.processor.core.ImmutableUtility;
import com.abubusoft.kripton.processor.core.ModelAnnotation;
import com.abubusoft.kripton.processor.core.reflect.AnnotationUtility;
import com.abubusoft.kripton.processor.core.reflect.AnnotationUtility.AnnotationFilter;
import com.abubusoft.kripton.processor.core.reflect.PropertyFactory;
import com.abubusoft.kripton.processor.core.reflect.PropertyUtility;
import com.abubusoft.kripton.processor.core.reflect.PropertyUtility.PropertyCreatedListener;
import com.abubusoft.kripton.processor.core.reflect.TypeUtility;
import com.abubusoft.kripton.processor.exceptions.IncompatibleAnnotationException;
import com.abubusoft.kripton.processor.exceptions.IncompatibleAttributesInAnnotationException;
import com.abubusoft.kripton.processor.exceptions.InvalidDefinition;
import com.abubusoft.kripton.xml.MapEntryType;
import com.abubusoft.kripton.xml.XmlType;


/**
 * The Class BindEntityBuilder.
 */
public abstract class BindEntityBuilder {

	/**
	 * The Class InnerCounter.
	 */
	public static class InnerCounter {
		
		/** The counter. */
		int counter;

		/**
		 * Inc.
		 */
		public void inc() {
			counter++;
		}

		/**
		 * Value.
		 *
		 * @return the int
		 */
		public int value() {
			return counter;
		}

	}

	/** The class annotation filter. */
	private static AnnotationFilter classAnnotationFilter = AnnotationFilter.builder().add(BindType.class).add(BindSqlType.class).build();

	/** The property annotation filter. */
	private static AnnotationFilter propertyAnnotationFilter = AnnotationFilter.builder().add(Bind.class).add(BindXml.class).add(BindDisabled.class).add(BindAdapter.class).build();

	/**
	 * Parses the.
	 *
	 * @param model the model
	 * @param element the element
	 * @return the bind entity
	 */
	public static BindEntity parse(final BindModel model, TypeElement element) {
		final Elements elementUtils = BaseProcessor.elementUtils;

		final InnerCounter counterPropertyInValue = new InnerCounter();
		final Converter<String, String> typeNameConverter = CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.LOWER_CAMEL);
		final TypeElement beanElement = element;
				
		final BindEntity currentEntity = new BindEntity(beanElement.getSimpleName().toString(), beanElement, AnnotationUtility.buildAnnotationList(element, classAnnotationFilter));

		// tag typeName
		String tagName = AnnotationUtility.extractAsString(beanElement, BindType.class, AnnotationAttributeType.VALUE);
		if (StringUtils.hasText(tagName)) {
			currentEntity.xmlInfo.label = tagName;
		} else {
			currentEntity.xmlInfo.label = typeNameConverter.convert(beanElement.getSimpleName().toString());
		}
		
		// esamine namespaces
		if (element.getAnnotation(BindXmlType.class) != null) {
			FindXmlNamespaceVisitor visitor = new FindXmlNamespaceVisitor();

			for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
				Map<? extends ExecutableElement, ? extends AnnotationValue> elementValues = annotationMirror.getElementValues();

				if (BindXmlType.class.getName().equals(annotationMirror.getAnnotationType().toString())) {
					for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : elementValues.entrySet()) {
						String key = entry.getKey().getSimpleName().toString();

						entry.getValue().accept(visitor, key);
					}
					List<Pair<String, String>> namespaces = visitor.getNamespace();
					currentEntity.xmlInfo.namespaces = namespaces;

					break;
				}
			}
		}
		
		
		final boolean bindAllFields = AnnotationUtility.getAnnotationAttributeAsBoolean(currentEntity, BindType.class, AnnotationAttributeType.ALL_FIELDS, Boolean.TRUE);
				
		PropertyUtility.buildProperties(elementUtils, currentEntity, new PropertyFactory<BindEntity, BindProperty>() {

			@Override
			public BindProperty createProperty(BindEntity entity, Element propertyElement) {
				return new BindProperty(currentEntity, propertyElement, AnnotationUtility.buildAnnotationList(propertyElement));
			}

		}, propertyAnnotationFilter, new PropertyCreatedListener<BindEntity, BindProperty>() {

			@Override
			public boolean onProperty(BindEntity entity, BindProperty property) {
				// if we are build Map, the model are not null
				boolean contextExternal = (model == null);

				// if @BindDisabled is present, exit immediately
				if (property.hasAnnotation(BindDisabled.class)) {
					if (bindAllFields) {
						return false;
					} else {											
						throw new InvalidDefinition(String.format("In class '%s', @%s can not be used with @%s(allField=false)", property.getParent().getElement().asType().toString(), BindDisabled.class.getSimpleName(), BindType.class.getSimpleName()));
					}
				}

				boolean enabled = bindAllFields;
				ModelAnnotation annotationBind = property.getAnnotation(Bind.class);
				enabled = enabled || (annotationBind != null && AnnotationUtility.extractAsBoolean(property, annotationBind, AnnotationAttributeType.ENABLED));

				// if we are not in external context and element is not enabled,
				// we have to analyze in every case.
				if (!enabled && !contextExternal) {
					return false;
				}

				ModelAnnotation annotationBindXml = property.getAnnotation(BindXml.class);

				property.order = 0;
				property.mapKeyName = Bind.MAP_KEY_DEFAULT;
				property.mapValueName = Bind.MAP_VALUE_DEFAULT;
				// label for item and collection elements are the same for
				// default
				property.label = typeNameConverter.convert(property.getName());
				property.xmlInfo.labelItem = property.label;
				property.xmlInfo.wrappedCollection = false;
				property.xmlInfo.xmlType = XmlType.valueOf(XmlType.TAG.toString());
				property.xmlInfo.mapEntryType = MapEntryType.valueOf(MapEntryType.TAG.toString());
												
				// check if there is an adapter
				if ((property.getAnnotation(BindAdapter.class)!= null)) {
					BindTransform transform = BindTransformer.lookup(TypeUtility.typeName(property.typeAdapter.dataType));

					if (!transform.isTypeAdapterSupported()) {
						String msg = String.format("In class '%s', property '%s' uses @BindAdapter with unsupported 'dataType' '%s'", beanElement.asType().toString(), property.getName(),
								property.typeAdapter.dataType);
						throw (new IncompatibleAnnotationException(msg));
					}

					if (property.getPropertyType().isPrimitive()) {
						String msg = String.format("In class '%s', property '%s' is primitive of type '%s' and it can not be annotated with @BindAdapter", beanElement.asType().toString(),
								property.getName(), property.getPropertyType().getTypeName());
						throw (new IncompatibleAnnotationException(msg));
					}
				}

				// @Bind management
				if (annotationBind != null) {
					int order = AnnotationUtility.extractAsInt(property.getElement(), Bind.class, AnnotationAttributeType.ORDER);
					property.order = order;

					String tempName = AnnotationUtility.extractAsString(property.getElement(), Bind.class, AnnotationAttributeType.VALUE);
					if (StringUtils.hasText(tempName)) {
						// for the moment are the same
						property.label = tempName;
						property.xmlInfo.labelItem = property.label;
					}

					// map info
					String mapKeyName = AnnotationUtility.extractAsString(property.getElement(), Bind.class, AnnotationAttributeType.MAP_KEY_NAME);
					if (StringUtils.hasText(mapKeyName))
						property.mapKeyName = mapKeyName;

					String mapValueName = AnnotationUtility.extractAsString(property.getElement(), Bind.class, AnnotationAttributeType.MAP_VALUE_NAME);
					if (StringUtils.hasText(mapValueName))
						property.mapValueName = mapValueName;
				}

				// @BindXml management
				if (annotationBindXml != null) {
					String mapEntryType = AnnotationUtility.extractAsEnumerationValue(property.getElement(), BindXml.class, AnnotationAttributeType.MAP_ENTRY_TYPE);
					if (StringUtils.hasText(mapEntryType))
						property.xmlInfo.mapEntryType = MapEntryType.valueOf(mapEntryType);

					// define element tag typeName
					String tempElementName = AnnotationUtility.extractAsString(property.getElement(), BindXml.class, AnnotationAttributeType.XML_ELEMENT_TAG);
					if (StringUtils.hasText(tempElementName)) {
						property.xmlInfo.labelItem = tempElementName;
						property.xmlInfo.wrappedCollection = true;
					}

					String xmlType = AnnotationUtility.extractAsEnumerationValue(property.getElement(), BindXml.class, AnnotationAttributeType.XML_TYPE);
					if (StringUtils.hasText(xmlType)) {
						property.xmlInfo.xmlType = XmlType.valueOf(xmlType);
					}
					
					// add namespace to name  
					String namespace= annotationBindXml.getAttribute(AnnotationAttributeType.NAMESPACE);					
					if (StringUtils.hasText(namespace)) {
						if (property.xmlInfo.xmlType == XmlType.VALUE || property.xmlInfo.xmlType == XmlType.VALUE_CDATA) {
							String msg = String.format("In class '%s', property '%s', defined as xml value, can not be used with a namespace", beanElement.asType().toString(), property.getName());
							throw (new IncompatibleAttributesInAnnotationException(msg));
						}
						property.xmlInfo.namespace=namespace;											
					}										
				}

				if (property.xmlInfo.xmlType == XmlType.ATTRIBUTE) {
					BindTransform transform = BindTransformer.lookup(property.getPropertyType().getTypeName());

					// check if property is a array
					if (property.isBindedArray() && !(transform instanceof ByteArrayBindTransform)) {
						String msg = String.format("In class '%s', property '%s' is an array and it can not be mapped in a xml attribute", beanElement.asType().toString(), property.getName());
						throw (new IncompatibleAttributesInAnnotationException(msg));
					}

					// check if property is a collection
					if (property.isBindedCollection()) {
						String msg = String.format("In class '%s', property '%s' is a collection and it can not be mapped in a xml attribute", beanElement.asType().toString(), property.getName());
						throw (new IncompatibleAttributesInAnnotationException(msg));
					}

					// check if property is a map
					if (property.isBindedMap()) {
						String msg = String.format("In class '%s', property '%s' is an map and it can not be mapped in a xml attribute", beanElement.asType().toString(), property.getName());
						throw (new IncompatibleAttributesInAnnotationException(msg));
					}

					if (transform != null && transform instanceof ObjectBindTransform) {
						String msg = String.format("In class '%s', property '%s' is an object and it can not be mapped in a xml attribute", beanElement.asType().toString(), property.getName());
						throw (new IncompatibleAttributesInAnnotationException(msg));
					}
				}

				if (property.xmlInfo.xmlType == XmlType.VALUE || property.xmlInfo.xmlType == XmlType.VALUE_CDATA) {
					counterPropertyInValue.inc();									

					BindTransform transform = BindTransformer.lookup(property.getPropertyType().getTypeName());

					// check if property is a array
					if (property.isBindedArray() && !(transform instanceof ByteArrayBindTransform)) {
						String msg = String.format("In class '%s', property '%s' is an array and it can not be mapped in a xml value", beanElement.asType().toString(), property.getName());
						throw (new IncompatibleAttributesInAnnotationException(msg));
					}

					// check if property is a collection
					if (property.isBindedCollection()) {
						String msg = String.format("In class '%s', property '%s' is a collection and it can not be mapped in a xml value", beanElement.asType().toString(), property.getName());
						throw (new IncompatibleAttributesInAnnotationException(msg));
					}

					// check if property is a map
					if (property.isBindedMap()) {
						String msg = String.format("In class '%s', property '%s' is a map and it can not be mapped in a xml value", beanElement.asType().toString(), property.getName());
						throw (new IncompatibleAttributesInAnnotationException(msg));
					}

					if (transform != null && transform instanceof ObjectBindTransform) {
						String msg = String.format("In class '%s', property '%s' is an object and it can not be mapped in a xml value", beanElement.asType().toString(), property.getName());
						throw (new IncompatibleAttributesInAnnotationException(msg));
					}
				}

				if (counterPropertyInValue.value() > 1) {
					String msg = String.format("In class '%s', property '%s' and other properties are mapped in a xml value, but only one property for class can be a xml value",
							beanElement.asType().toString(), property.getName());
					throw (new IncompatibleAttributesInAnnotationException(msg));
				}

				property.bindedObject = BindTransformer.isBindedObject(property);

				// if it's an object, we need to avoid to print field typeName
				// (like
				// object transform usually do).
				// set inCollection to true, permits this.
				if (property.bindedObject && contextExternal) {
					property.inCollection = true;
				}

				return true;

			}

		});
		
		ImmutableUtility.buildConstructors(elementUtils, currentEntity);

		// if we don't have model, we dont save bean definition
		if (model != null) {
			model.entityAdd(currentEntity);
		}
		return currentEntity;
	}
}
