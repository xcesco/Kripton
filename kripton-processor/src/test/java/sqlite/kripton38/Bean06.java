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
package sqlite.kripton38;

import com.abubusoft.kripton.android.ColumnType;
import com.abubusoft.kripton.android.annotation.BindSqlColumn;
import com.abubusoft.kripton.annotation.Bind;
import com.abubusoft.kripton.annotation.BindType;


/**
 * The Class Bean06.
 */
@BindType
public class Bean06 {

	/** The pk. */
	@Bind
	@BindSqlColumn(columnType=ColumnType.PRIMARY_KEY)
	protected long pk;

	/**
	 * Gets the pk.
	 *
	 * @return the pk
	 */
	public long getPk() {
		return pk;
	}

	/**
	 * Sets the pk.
	 *
	 * @param pk the pk to set
	 */
	public void setPk(long pk) {
		this.pk = pk;
	}

	/** The text. */
	@Bind
	@BindSqlColumn
	protected String text;

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
