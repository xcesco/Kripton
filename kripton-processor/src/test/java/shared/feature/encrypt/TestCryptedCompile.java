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
package shared.feature.encrypt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import shared.AbstractBindSharedPreferenceProcessorTest;
import shared.feature.encrypt.case1.AppPreferences;
import shared.feature.encrypt.case1.NamedAppPreferences;
import shared.feature.encrypt.case1.SimpleAppPreferences;
import shared.feature.encrypt.case1.SimpleNamedAppPreferences;

import java.io.IOException;

/**
 * The Class Test45Compile.
 */
@RunWith(JUnit4.class)
public class TestCryptedCompile extends AbstractBindSharedPreferenceProcessorTest {

	/**
	 * Test compile.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	@Test
	public void testCryptedCompile() throws IOException, InstantiationException, IllegalAccessException {
		buildSharedPreferencesProcessorTest(AppPreferences.class);
	}

	@Test
	public void testCrypedCompileName() throws IOException, InstantiationException, IllegalAccessException {
		buildSharedPreferencesProcessorTest(NamedAppPreferences.class);
	}

	@Test
	public void testCompile() throws IOException, InstantiationException, IllegalAccessException {
		buildSharedPreferencesProcessorTest(SimpleAppPreferences.class);
	}

	@Test
	public void testCompileName() throws IOException, InstantiationException, IllegalAccessException {
		buildSharedPreferencesProcessorTest(SimpleNamedAppPreferences.class);
	}

}
