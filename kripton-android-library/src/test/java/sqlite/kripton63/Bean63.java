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
package sqlite.kripton63;

import java.util.HashMap;
import java.util.Map;

import com.abubusoft.kripton.annotation.BindType;


/**
 * The Class Bean63.
 */
@BindType
// @BindSharedPreferences
public class Bean63 {

	/** The id. */
	public long id;

	/** The value. */
	public String value;

	/** The value map string byte. */
	public Map<String, Byte> valueMapStringByte;

	/** The value map enum byte. */
	public HashMap<EnumType, Byte> valueMapEnumByte;

	/*
	 * public HashSet<Short> valueShortSet;
	 * 
	 * public LinkedHashSet<Integer> valueIntegerSet;
	 * 
	 * public HashSet<String> valueStringSet;
	 * 
	 * public Set<Character> valueCharacterSet;
	 * 
	 * public HashSet<Float> valueFloatSet;
	 * 
	 * public HashSet<Double> valueDoubleSet;
	 * 
	 * public HashSet<BigDecimal> valueBigDecimalSet;
	 * 
	 * public LinkedHashSet<Bean> valueBeanSet;
	 * 
	 * public HashSet<EnumType> valueEnumTypeSet;
	 */

}
