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
package shared;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import shared.feature.immutable.livedata.TesLiveDataCase1Runtime;
import shared.feature.livedata.TestSharedLiveDataSuite;
import shared.feature.rx.TestSharedRxSuite;
import shared.feature.time.TestTimeSharedPrefsSuite;
import shared.feature.typeadapter.TestTypeAdapterCase2Runtime;
import shared.kripton45.Test45Suite;
import shared.kripton47.Test47Suite;

/**
 * The Class SharedRuntimeTestSuite.
 */
@RunWith(Suite.class)
// @formatter:off
@Suite.SuiteClasses({
        Test45Suite.class,
        Test47Suite.class,

        TestTypeAdapterCase2Runtime.class,
        TestSharedRxSuite.class,
        TestSharedLiveDataSuite.class,

        TesLiveDataCase1Runtime.class,
        TestTimeSharedPrefsSuite.class
})
// @formatter:on
public class SharedRuntimeTestSuite {

}
