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
package sqlite.kripton205;

import java.io.IOException;

import org.junit.Test;

import sqlite.AbstractBindSQLiteProcessorTest;


/**
 * The Class Test205.
 *
 * @author xcesco
 */
public class Test205 extends AbstractBindSQLiteProcessorTest {

	/**
	 * Test compile. Since 4.1.0 works.
	 *
	 */
	@Test
	public void testCompile() throws IOException, InstantiationException, IllegalAccessException {
		//this.expectedException(SQLPrimaryKeyNotFoundException.class);
		buildDataSourceProcessorTest(Bean96DataSource.class, Bean205Dao.class, Bean205.class, BaseBean205.class);
	}

}
