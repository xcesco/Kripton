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
package sqlite.kripton41;

import com.abubusoft.kripton.android.annotation.BindDao;
import com.abubusoft.kripton.android.annotation.BindSqlDelete;


/**
 * The Interface DaoBeanDeleteERR.
 */
@BindDao(Bean01.class)
public interface DaoBeanDeleteERR  {
	/*
	@BindSelect(value="count(*)>1")
	Boolean selectDistance(long id, double value);
	*/
	/*
	@BindInsert
	boolean insertDistance(Long id, double value);
	
	
	@BindUpdate
	boolean updateDistance(long id, Double value, long test);*/
	
	/**
	 * Delete distance.
	 *
	 * @param id the id
	 * @param value the value
	 * @return true, if successful
	 */
	@BindSqlDelete
	boolean deleteDistance(long id, double value);
	
	
}