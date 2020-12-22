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
package bind.kripton81exceptioncoverage;

import com.abubusoft.kripton.android.ColumnType;
import com.abubusoft.kripton.android.annotation.BindSqlColumn;
import com.abubusoft.kripton.annotation.BindDisabled;
import com.abubusoft.kripton.annotation.BindType;


/**
 * The Class Error7Bean.
 */
@BindType
public class Error7Bean {

	/** The id. */
	@BindSqlColumn(columnType = ColumnType.PRIMARY_KEY)
	public long id;

	/** The ignore. */
	@BindDisabled
	@BindSqlColumn
	public String ignore;

	/** The ignore 2. */
	@BindSqlColumn(enabled = false)
	public String ignore2;

	/** The foreign. */
	@BindSqlColumn(parentEntity = Error7_1Bean.class)
	public Error7_1Bean foreign2;
}
