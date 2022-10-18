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
package bind.emptystream;

import bind.AbstractBindTypeProcessorTest;
import bind.bindenum.*;
import com.abubusoft.kripton.processor.exceptions.InvalidKindForAnnotationException;
import org.junit.Test;

import java.io.IOException;


/**
 * Test bean field.
 *
 * @author Francesco Benincasa (info@abubusoft.com)
 */
public class TestEmptyString extends AbstractBindTypeProcessorTest {

    /**
     * Test compile.
     *
     * @throws IOException            Signals that an I/O exception has occurred.
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     */
    @Test
    public void testCompileRifornimento() throws IOException, InstantiationException, IllegalAccessException {
        buildBindProcessorTest(Rifornimento.class, SimpleRifornimento.class);
    }


}
