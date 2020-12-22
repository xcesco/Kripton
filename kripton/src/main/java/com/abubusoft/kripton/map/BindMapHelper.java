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
package com.abubusoft.kripton.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.abubusoft.kripton.AbstractContext;
import com.abubusoft.kripton.exception.KriptonRuntimeException;
import com.abubusoft.kripton.persistence.JacksonWrapperParser;
import com.abubusoft.kripton.persistence.ParserWrapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;


/**
 * Bind map helper.
 *
 * @author Francesco Benincasa (info@abubusoft.com)
 */
public abstract class BindMapHelper {

	/**
	 * Parse a map.
	 *
	 * @param context the context
	 * @param parserWrapper the parser wrapper
	 * @param map the map
	 * @return map
	 */
	public static Map<String, Object> parseMap(AbstractContext context, ParserWrapper parserWrapper, Map<String, Object> map) {
		switch (context.getSupportedFormat()) {
		case XML:
			throw (new KriptonRuntimeException(context.getSupportedFormat() + " context does not support parse direct map parsing"));
		default:
			JacksonWrapperParser wrapperParser = (JacksonWrapperParser) parserWrapper;
			JsonParser parser = wrapperParser.jacksonParser;

			map.clear();
			return parseMap(context, parser, map, false);
		}
	}

	/**
	 * Parse map.
	 *
	 * @param context the context
	 * @param parser the parser
	 * @param map the map
	 * @param skipRead the skip read
	 * @return the map
	 */
	static Map<String, Object> parseMap(AbstractContext context, JsonParser parser, Map<String, Object> map, boolean skipRead) {
		try {
			String key;
			Object value;

			if (!skipRead) {
				parser.nextToken();
			}

			if (parser.currentToken() != JsonToken.START_OBJECT) {
				throw (new KriptonRuntimeException("Invalid input format"));
			}

			skipRead = false;

			do {

				if (skipRead) {
					key = parser.getCurrentName();
				} else {
					key = parser.nextFieldName();
					skipRead = true;
				}

				JsonToken token = parser.nextToken();
				switch (token) {
				case START_ARRAY:
					// parse array
					value = parseList(context, parser, new ArrayList<>(), true);
					break;
				case VALUE_EMBEDDED_OBJECT:
					// parse submap
					value = parseMap(context, parser, new LinkedHashMap<>(), true);
					break;
				default:
					// parser.nextValue();
					value = parser.getValueAsString();
				}
				// value = parser.getText();
				map.put(key, value);
			} while (parser.nextToken() != JsonToken.END_OBJECT);
			return map;
		} catch (IOException e) {
			e.printStackTrace();
			throw (new KriptonRuntimeException(e));
		}
	}

	/**
	 * Parse a list.
	 *
	 * @param context the context
	 * @param parser the parser
	 * @param list the list
	 * @param skipRead the skip read
	 * @return the list
	 */
	static List<Object> parseList(AbstractContext context, JsonParser parser, List<Object> list, boolean skipRead) {
		try {
			if (!skipRead) {
				parser.nextToken();
			}

			if (parser.currentToken() != JsonToken.START_ARRAY) {
				throw (new KriptonRuntimeException("Invalid input format"));
			}

			skipRead = false;

			JsonToken token;
			do {
				if (skipRead) {
					token = parser.getCurrentToken();
				} else {
					token = parser.nextToken();
					skipRead = true;
				}
				switch (token) {
				case VALUE_FALSE:
				case VALUE_TRUE:
				case VALUE_NUMBER_FLOAT:
				case VALUE_NUMBER_INT:
				case VALUE_STRING:
					list.add(parser.getText());
					break;
				case VALUE_NULL:
					list.add(null);
					break;
				case VALUE_EMBEDDED_OBJECT:
					// parse submap
					list.add(parseMap(context, parser, new LinkedHashMap<String, Object>(), true));
					break;
				case START_ARRAY:
					list.add(parseList(context, parser, list, true));
					break;
				default:
					break;
				}
			} while (parser.nextToken() != JsonToken.END_ARRAY);
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			throw (new KriptonRuntimeException(e));
		}
	}
}
