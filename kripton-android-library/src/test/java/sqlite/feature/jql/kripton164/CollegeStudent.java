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
package sqlite.feature.jql.kripton164;

import com.abubusoft.kripton.android.annotation.BindSqlType;
import com.abubusoft.kripton.annotation.BindType;


/**
 * The Class CollegeStudent.
 */
@BindType
@BindSqlType(name="students")
public class CollegeStudent {
    
    /** The first name. */
    public String firstName;

    /** The surname. */
    public String surname;

    /** The id. */
    public long id;
}
