/**
 * Copyright 2015, 2017 Francesco Benincasa (info@abubusoft.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 */
package com.abubusoft.kripton.processor.sqlite;

import com.abubusoft.kripton.processor.core.AssertKripton;
import com.abubusoft.kripton.processor.core.reflect.TypeUtility;
import com.abubusoft.kripton.processor.sqlite.grammars.jql.JQLProjection;
import com.abubusoft.kripton.processor.sqlite.model.SQLiteModelMethod;
import com.abubusoft.kripton.processor.sqlite.transform.SQLTransform;
import com.abubusoft.kripton.processor.sqlite.transform.SQLTransformer;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.util.Optional;
import java.util.Set;


/**
 * Manage query with only one value.
 *
 * @author Francesco Benincasa (info@abubusoft.com)
 * @since 17/mag/2016
 */
public class SelectScalarHelper extends AbstractSelectCodeGenerator {

  /*
   * (non-Javadoc)
   *
   * @see com.abubusoft.kripton.processor.sqlite.SQLiteSelectBuilder.
   * SelectCodeGenerator#generate(com.squareup.javapoet.MethodSpec.Builder)
   */
  @Override
  public void generateSpecializedPart(SQLiteModelMethod method, TypeSpec.Builder classBuilder, MethodSpec.Builder methodBuilder, Set<JQLProjection> fieldList, boolean mapFields) {
    // if optional, return the result type inside optional
  	TypeName returnTypeName = method.getOptionalReturnClass();

    //ASSERT: returnType is a supported type

    // no column or too many columns
    AssertKripton.assertTrueOrInvalidMethodSignException(fieldList.size() == 1, method, "no way to understand which field is the result for this method");

    SQLTransform t = SQLTransformer.lookup(returnTypeName);

    methodBuilder.addCode("$T result=", returnTypeName);
    t.generateDefaultValue(methodBuilder);
    methodBuilder.addCode(";\n");

    methodBuilder.addCode("\n");
    // methodBuilder.beginControlFlow("try");
    methodBuilder.beginControlFlow("if (_cursor.moveToFirst())");

    // generate index from columns
    methodBuilder.addCode("\n");

    if (TypeUtility.isNullable(returnTypeName)) {
      if (method.hasOptionalResult()) {
        methodBuilder.addCode("if (_cursor.isNull(0)) { return $T.empty();}\n", Optional.class);
      } else {
        methodBuilder.addCode("if (_cursor.isNull(0)) { return null; }\n");
      }
    } else {
      methodBuilder.addCode("if (_cursor.isNull(0)) { return ");
      t.generateDefaultValue(methodBuilder);
      methodBuilder.addCode("; }\n", t);
    }
    methodBuilder.addCode("result=");
    t.generateReadValueFromCursor(methodBuilder, method.getParent(), returnTypeName, "_cursor", "0");
    methodBuilder.addCode(";\n");

    // end cursor
    methodBuilder.endControlFlow();

    if (method.hasOptionalResult()) {
      methodBuilder.addCode("return $T.ofNullable(result);\n", Optional.class);
    } else {
      methodBuilder.addCode("return result;\n");
    }

    // end method
    methodBuilder.endControlFlow();
  }

}
