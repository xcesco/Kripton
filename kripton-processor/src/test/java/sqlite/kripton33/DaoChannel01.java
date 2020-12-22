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
package sqlite.kripton33;

import java.util.List;

import android.database.Cursor;

import com.abubusoft.kripton.android.annotation.BindDao;
import com.abubusoft.kripton.android.annotation.BindSqlSelect;


/**
 * The Interface DaoChannel01.
 */
@BindDao(Channel.class)
public interface DaoChannel01 {
	
	/**
	 * Select.
	 *
	 * @param updateTimeA the update time A
	 * @return the list
	 */
	@BindSqlSelect(where = "updateTime=${updateTimeB}")
	List<Channel> select(long updateTimeA);
	
	/**
	 * Select cursor.
	 *
	 * @param updateTimeA the update time A
	 * @return the cursor
	 */
	@BindSqlSelect(where = "updateTime=${updateTimeB}")
	Cursor selectCursor(long updateTimeA);

}
