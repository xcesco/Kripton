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

import com.abubusoft.kripton.map.BindMapVisitor.VisitorStatusType;


/**
 * The listener interface for receiving bindMap events. The class that is
 * interested in processing a bindMap event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addBindMapListener</code> method. When the bindMap event
 * occurs, that object's appropriate method is invoked.
 *
 * @author Francesco Benincasa (info@abubusoft.com)
 */
public interface BindMapListener {

	/**
	 * On field.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @param status
	 *            the status
	 */
	void onField(String name, String value, VisitorStatusType status);

}
