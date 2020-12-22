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
package sqlite.feature.contentprovider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import sqlite.AbstractBindSQLiteProcessorTest;
import sqlite.feature.contentprovider.case1.Album;
import sqlite.feature.contentprovider.case1.AlbumDao;
import sqlite.feature.contentprovider.case1.Artist;
import sqlite.feature.contentprovider.case1.ArtistDao;
import sqlite.feature.contentprovider.case1.ArtistsDataSource;
import sqlite.feature.contentprovider.case1.BaseDao;
import sqlite.feature.contentprovider.case1.Entity;


/**
 * The Class ContentProviderCompilerTest.
 */
@RunWith(JUnit4.class)
public class ContentProviderCase1CompilerTest extends AbstractBindSQLiteProcessorTest {

	/**
	 * Test 01.
	 *
	 * @throws Throwable the throwable
	 */
	@Test
	public void test01() throws Throwable {
		buildDataSourceProcessorTest(Artist.class, ArtistDao.class, Album.class, AlbumDao.class, ArtistsDataSource.class, BaseDao.class, Entity.class);
	}

}
