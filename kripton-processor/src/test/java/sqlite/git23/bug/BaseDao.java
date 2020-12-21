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
package sqlite.git23.bug;

import com.abubusoft.kripton.android.annotation.BindContentProviderEntry;
import com.abubusoft.kripton.android.annotation.BindSqlSelect;


/**
 * Created by xcesco on 02/10/2017.
 *
 * @param <E> the element type
 */

public interface BaseDao<E> {
	
	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the e
	 */
	@BindContentProviderEntry(path = "${id}")
	@BindSqlSelect(where = "id=${id}")
	E selectById(long id);
	
}
