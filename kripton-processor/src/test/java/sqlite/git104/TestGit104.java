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
package sqlite.git104;

import java.io.IOException;

import org.junit.Test;

import sqlite.AbstractBindSQLiteProcessorTest;

/**
 * The TestGit104.
 *
 * @author xcesco
 * 
 * https://github.com/xcesco/kripton/issues/104
 */
public class TestGit104 extends AbstractBindSQLiteProcessorTest {

	/**
	 * Test compile.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	@Test
	public void testCompile() throws IOException, InstantiationException, IllegalAccessException {		
		//this.expectedException(KriptonProcessorException.class, "Table name 'director' is mapped to entities 'sqlite.git12.Movie' and 'sqlite.git12.Director'");
		buildDataSourceProcessorTest(AbstractBean.class,
				AbstractDao.class,
				AppDataSource.class,			
				Document.class,
				DocumentDao.class,
				DocumentInfo.class,
				FileInfo.class				
				);
	}

}
