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
package shared.feature.time;

import org.junit.Test;
import shared.AbstractBindSharedPreferenceProcessorTest;
import shared.feature.time.case1.Bean;
import shared.feature.time.case1.BeanImmutable;
import shared.feature.time.case1.BeanWithAccessors;

import java.io.IOException;

public class TimeSharedPrefsCompileTest extends AbstractBindSharedPreferenceProcessorTest {
	@Test
	public void testSimpleCompile() throws IOException, InstantiationException, IllegalAccessException {
		buildSharedPreferencesProcessorTest(Bean.class);
	}

	@Test
	public void testImmutableCompile() throws IOException, InstantiationException, IllegalAccessException {
		buildSharedPreferencesProcessorTest(BeanImmutable.class);
	}

	@Test
	public void testWithAccessorCompile() throws IOException, InstantiationException, IllegalAccessException {
		buildSharedPreferencesProcessorTest(BeanWithAccessors.class);
	}

}
