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
package sqlite.feature.contentprovider.kripton35.nolog;

import com.abubusoft.kripton.android.annotation.BindContentProviderEntry;
import com.abubusoft.kripton.android.annotation.BindContentProviderPath;
import com.abubusoft.kripton.android.annotation.BindDao;
import com.abubusoft.kripton.android.annotation.BindSqlInsert;
import com.abubusoft.kripton.android.annotation.BindSqlSelect;

import sqlite.feature.contentprovider.kripton35.entities.City;


/**
 * The Interface City2DAO.
 */
@BindContentProviderPath(path = "cities")
@BindDao(City.class)
public interface City2DAO {

	/**
	 * Insert bean.
	 *
	 * @param bean the bean
	 */
	@BindContentProviderEntry
	@BindSqlInsert
	void insertBean(City bean);
	
	/**
	 * Select city from person.
	 *
	 * @param personId the person id
	 * @return the city
	 */
	@BindContentProviderEntry(path="person/${personId}")
	@BindSqlSelect(jql="select * from City where id = (select id from Person where id=${personId} )")
	City selectCityFromPerson(long personId);
}