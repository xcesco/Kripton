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
package sqlite.feature.schema.error1;

import com.abubusoft.kripton.android.annotation.BindDaoMany2Many;
import com.abubusoft.kripton.android.annotation.BindGeneratedDao;
import com.abubusoft.kripton.android.annotation.BindSqlDelete;
import com.abubusoft.kripton.android.annotation.BindSqlInsert;
import com.abubusoft.kripton.android.annotation.BindSqlParam;
import com.abubusoft.kripton.android.annotation.BindSqlSelect;

import sqlite.feature.many2many.entity.PersonCityOk1;

import java.util.List;


/**
 * The Interface PersonCityDaoGeneratedPart.
 */
@BindGeneratedDao(dao = PersonCityDao.class)
@BindDaoMany2Many(entity1 =  PersonCityOk1.class, entity2 =  PersonCityOk1.class)
public interface PersonCityDaoGeneratedPart {
	
	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the person city
	 */
	@BindSqlSelect(where = "id=${id}")
	PersonCity selectById(@BindSqlParam("id") long id);

	/**
	 * Select by person id.
	 *
	 * @param personId the person id
	 * @return the list
	 */
	@BindSqlSelect(where = "personId=${personId}")
	List<PersonCity> selectByPersonId(@BindSqlParam("personId") long personId);

	/**
	 * Select by city id.
	 *
	 * @param cityId the city id
	 * @return the list
	 */
	@BindSqlSelect(where = "cityId=${cityId}")
	List<PersonCity> selectByCityId(@BindSqlParam("cityId") long cityId);

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the int
	 */
	@BindSqlDelete(where = "id=${id}")
	int deleteById(@BindSqlParam("id") long id);

	/**
	 * Delete by person id.
	 *
	 * @param personId the person id
	 * @return the int
	 */
	@BindSqlDelete(where = "personId=${personId}")
	int deleteByPersonId(@BindSqlParam("personId") long personId);

	/**
	 * Delete by city id.
	 *
	 * @param cityId the city id
	 * @return the int
	 */
	@BindSqlDelete(where = "cityId=${cityId}")
	int deleteByCityId(@BindSqlParam("cityId") long cityId);

	/**
	 * Insert.
	 *
	 * @param bean the bean
	 * @return the int
	 */
	@BindSqlInsert
	int insert(@BindSqlParam("bean") PersonCity bean);
}
