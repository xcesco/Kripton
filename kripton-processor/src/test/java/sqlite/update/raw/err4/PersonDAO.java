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
package sqlite.update.raw.err4;

import java.util.Date;
import java.util.List;

import com.abubusoft.kripton.android.annotation.BindDao;
import com.abubusoft.kripton.android.annotation.BindSqlDelete;
import com.abubusoft.kripton.android.annotation.BindSqlSelect;


/**
 * The Interface PersonDAO.
 */
@BindDao(Person.class)
public interface PersonDAO {

	/**
	 * Select by birthday.
	 *
	 * @param birthDay the birth day
	 * @return the list
	 */
	@BindSqlSelect(where="birthDate=${birthDay}")
	public List<Person> selectByBirthday(Date birthDay);
	
	@BindSqlDelete(where="names=:names")
	public void update(String names);
}
