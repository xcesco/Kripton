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
package sqlite.feature.typeadapter.update.err2;

import com.abubusoft.kripton.android.annotation.BindDao;
import com.abubusoft.kripton.android.annotation.BindSqlParam;
import com.abubusoft.kripton.android.annotation.BindSqlUpdate;

import sqlite.feature.typeadapter.Contact;
import sqlite.feature.typeadapter.PasswordAdapterType;


/**
 * The Interface ErrContactDao.
 */
@BindDao(Contact.class)
public interface ErrContactDao {
	
	/**
	 * Update compact bean.
	 *
	 * @param bean the bean
	 * @return the long
	 */
	@BindSqlUpdate(fields={"id", "type"}, where = "id=${bean.id}  and password=${bean.password} and type=${bean.type}")
	long updateCompactBean(@BindSqlParam(adapter=PasswordAdapterType.class) Contact bean);
	
}
