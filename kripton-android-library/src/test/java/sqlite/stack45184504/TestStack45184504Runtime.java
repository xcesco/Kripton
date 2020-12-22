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
package sqlite.stack45184504;

import org.junit.Test;

import base.BaseAndroidTest;


/**
 * The Class TestStack45184504Runtime.
 *
 * @author Francesco Benincasa (info@abubusoft.com)
 */
public class TestStack45184504Runtime extends BaseAndroidTest {

	/**
	 * Test.
	 */
	@Test
	public void test() {
		// example of file content
		byte[] content="this a simple content!".getBytes();
		
		// part 1 - open database
		BindExampleDataSource dataSource=BindExampleDataSource.getInstance();		
		dataSource.openWritableDatabase();
		
		FileBeanDaoImpl dao = dataSource.getFileBeanDao();
		
		// part 2 - directly insert columns
		long id1=dao.insert("simple.txt", "text/plain" , content);
		
		// part 3 - insert with a bean
		FileBean bean=new FileBean();
		bean.content="<html><body>Hello world!</body></html>".getBytes();
		bean.contentType="text/html";
		dao.insert(bean);
		
		// part 4 - select record by its id
		dao.selectById(id1);
		
		// part 5 - close database
		dataSource.close();
	}

}
