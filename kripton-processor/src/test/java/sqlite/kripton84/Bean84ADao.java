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
package sqlite.kripton84;

import java.util.List;
import java.util.Map;

import com.abubusoft.kripton.android.annotation.BindDao;
import com.abubusoft.kripton.android.annotation.BindSqlDelete;
import com.abubusoft.kripton.android.annotation.BindSqlInsert;
import com.abubusoft.kripton.android.annotation.BindSqlParam;
import com.abubusoft.kripton.android.annotation.BindSqlSelect;
import com.abubusoft.kripton.android.annotation.BindSqlUpdate;


/**
 * The Interface Bean84ADao.
 */
@BindDao(Bean84A.class)
public interface Bean84ADao {

	/**
	 * Select all.
	 *
	 * @return the list
	 */
	@BindSqlSelect
	List<Bean84A> selectAll();
	
	/**
	 * Select by id.
	 *
	 * @param uid the uid
	 * @return the list
	 */
	@BindSqlSelect(where="id=${id}")
	List<Bean84A> selectById(@BindSqlParam("id") long uid);
	
	/**
	 * Select where.
	 *
	 * @param param1 the param 1
	 * @param param2 the param 2
	 * @param param3 the param 3
	 * @param param4 the param 4
	 * @return the list
	 */
	@BindSqlSelect(where="columnListString=${param1} and columnMapIntegerString=${param2} and columnArrayChar=${param3}  and columnArrayCharType=${param4}")
	List<Bean84A> selectWhere(List<String> param1, Map<Integer, String> param2, Character[] param3, char[] param4);
	
	/**
	 * Insert all.
	 *
	 * @param bean the bean
	 * @return true, if successful
	 */
	@BindSqlInsert
	boolean insertAll(Bean84A bean);
	
	/**
	 * Insert.
	 *
	 * @param param1 the param 1
	 * @return true, if successful
	 */
	@BindSqlInsert
	boolean insert(@BindSqlParam("columnListString") List<String> param1);
	
	/**
	 * Update all.
	 *
	 * @param bean the bean
	 * @return true, if successful
	 */
	@BindSqlUpdate
	boolean updateAll(Bean84A bean);
	
	/**
	 * Delete all.
	 *
	 * @param bean the bean
	 * @return true, if successful
	 */
	@BindSqlDelete
	boolean deleteAll(Bean84A bean);
}