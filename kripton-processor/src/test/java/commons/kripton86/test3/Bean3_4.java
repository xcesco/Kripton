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
package commons.kripton86.test3;

import java.util.Set;

import com.abubusoft.kripton.annotation.BindType;
import com.abubusoft.kripton.annotation.BindXml;
import com.abubusoft.kripton.xml.XmlType;


/**
 * The Class Bean3_4.
 */
@BindType
public class Bean3_4 {

	/** The value long set 1. */
	@BindXml(xmlType=XmlType.VALUE)
	public Set<Long> valueLongSet1;
	
	/** The value long set. */
	@BindXml(xmlType=XmlType.VALUE)
	public Set<Long> valueLongSet;
}
