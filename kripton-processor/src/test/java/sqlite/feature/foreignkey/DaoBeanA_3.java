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
package sqlite.feature.foreignkey;

import java.util.List;

import com.abubusoft.kripton.android.annotation.BindDao;
import com.abubusoft.kripton.android.annotation.BindSqlInsert;
import com.abubusoft.kripton.android.annotation.BindSqlParam;
import com.abubusoft.kripton.android.annotation.BindSqlSelect;
import com.abubusoft.kripton.android.annotation.BindSqlUpdate;

import sqlite.feature.foreignkey.BeanA_3;


/**
 * The Interface DaoBeanA_3.
 */
@BindDao(BeanA_3.class)
public interface DaoBeanA_3 {
	
	/**
	 * Select all.
	 *
	 * @return the list
	 */
	@BindSqlSelect
	List<BeanA_3> selectAll();
	
	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the list
	 */
	@BindSqlSelect(where="id=${id}")
	List<BeanA_3> selectById(long id);
	
	/**
	 * Select by string.
	 *
	 * @param value the value
	 * @return the list
	 */
	@BindSqlSelect(fields="id",where="valueString2=${dummy}")
	List<BeanA_3> selectByString(@BindSqlParam("dummy") String value);
	
	/**
	 * Insert.
	 *
	 * @param bean the bean
	 * @return the int
	 */
	@BindSqlInsert
	int insert(BeanA_3 bean);
	
	/**
	 * Update.
	 *
	 * @param bean the bean
	 * @return the int
	 */
	@BindSqlUpdate(where="valueString2=${bean.valueString2}")
	int update(BeanA_3 bean);
}
