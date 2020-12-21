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
package sqlite.feature.paginatedresult.error4;

import java.util.Date;

import com.abubusoft.kripton.android.annotation.BindDao;
import com.abubusoft.kripton.android.annotation.BindSqlInsert;
import com.abubusoft.kripton.android.annotation.BindSqlSelect;
import com.abubusoft.kripton.android.sqlite.PagedResultImpl;


/**
 * The Interface Err4PersonDAO.
 */
@BindDao(Err4Person.class)
public interface Err4PersonDAO {
	
	/**
	 * Select paged static 1.
	 *
	 * @return the paginated result
	 */
	@BindSqlSelect(orderBy="name", pageSize=20)
	PagedResultImpl<Err4Person> selectPagedStatic1();
	
	/**
	 * Select paged static 2.
	 *
	 * @param name the name
	 * @return the paginated result
	 */
	@BindSqlSelect(where="name=${name}" ,orderBy="name", pageSize=-20)
	PagedResultImpl<Err4Person> selectPagedStatic2(String name);
	
	
	/**
	 * Insert one.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @param birthCity the birth city
	 * @param birthDay the birth day
	 */
	@BindSqlInsert
	void insertOne(String name, String surname, String birthCity, Date birthDay);
/*
	@BindSqlSelect(orderBy="typeName")
	List<Person> selectAll();
	
	@BindSqlSelect(where="typeName like ${nameTemp} || '%'")
	List<Person> selectOne(@BindSqlParam("nameTemp") String nameValue, @BindSqlWhere String where, @BindSqlOrderBy String orderBy);
	
	@BindSqlSelect(orderBy="typeName")
	void selectBeanListener(OnReadBeanListener<Person> beanListener, @BindSqlOrderBy String orderBy);*/
	
}