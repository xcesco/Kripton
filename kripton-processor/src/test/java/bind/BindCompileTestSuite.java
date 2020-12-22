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
package bind;

import bind.bindenum.TestEnumSuite;
import bind.bugs.TestBugsCompileSuite;
import bind.directmap.TestDirectMapSuite;
import bind.feature.generichierarchy.TestGenericHierarchySuite;
import bind.feature.generichierarchy.kripton109.Test109CompileSuite;
import bind.feature.git45.TestGit43Suite;
import bind.feature.immutable.TestImmutableCompileSuite;
import bind.feature.kotlin.TestBindTypeKotlinCompileSuite;
import bind.feature.namespace.CompileNamespaceTestSuite;
import bind.feature.typeadapter.kripton87.Test87CompileSuite;
import bind.git18.TestCompileGit18;
import bind.git49.TestCompileGit49;
import bind.git80.TestCompileGit80;
import bind.kripton110.TestCompile110;
import bind.kripton42faster.Test42CompileSuite;
import bind.kripton70.Test70CompileSuite;
import bind.kripton71list.Test71CompileSuite;
import bind.kripton72.Test72CompileSuite;
import bind.kripton73array.Test73CompileSuite;
import bind.kripton74map.Test74CompileSuite;
import bind.kripton75bytearray.Test75CompileSuite;
import bind.kripton76errors.Test76CompileSuite;
import bind.kripton77.Test77;
import bind.kripton78.Test78CompileSuite;
import bind.kripton80contextcollection.Test80CompileSuite;
import bind.kripton81morecoveragetests.Test81CompileSuite;
import bind.retrofit.film.model.TestFilmCompile;
import bind.rss.TestRSSCompile;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The Class BindCompileTestSuite.
 */
@RunWith(Suite.class)
//@formatter:off
@Suite.SuiteClasses(
        {
                // feature
                TestImmutableCompileSuite.class,
                TestBindTypeKotlinCompileSuite.class,
                TestGit43Suite.class,

                // bugs
                TestBugsCompileSuite.class,

                // improvemens
                TestCompileGit49.class,

                Test42CompileSuite.class,
                Test70CompileSuite.class,
                Test71CompileSuite.class,
                Test72CompileSuite.class,
                Test73CompileSuite.class,
                Test74CompileSuite.class,
                Test75CompileSuite.class,
                Test76CompileSuite.class,
                Test77.class,
                TestRSSCompile.class,
                Test78CompileSuite.class,
                Test80CompileSuite.class,
                Test81CompileSuite.class,
                Test87CompileSuite.class,
                TestEnumSuite.class,
                TestGenericHierarchySuite.class,
                TestDirectMapSuite.class,
                Test109CompileSuite.class,
                TestCompile110.class,
                TestFilmCompile.class,

                TestCompileGit18.class,
                TestCompileGit80.class,

                // features
                CompileNamespaceTestSuite.class,
        })
//@formatter:on
public class BindCompileTestSuite {

}
