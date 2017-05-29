/*******************************************************************************
 * Copyright 2015, 2016 Francesco Benincasa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package sqlite.sqlchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.abubusoft.kripton.processor.sqlite.grammar.JQL;
import com.abubusoft.kripton.processor.sqlite.grammar.JQLChecker;
import com.abubusoft.kripton.processor.sqlite.grammar.JQLChecker.JSQLPlaceHolderReplacerListener;
import com.abubusoft.kripton.processor.sqlite.grammar.JQLPlaceHolder;
import com.abubusoft.kripton.processor.sqlite.grammar.JQLPlaceHolder.JQLPlaceHolderType;
import com.abubusoft.kripton.processor.sqlite.grammar.JQLProjection;
import com.abubusoft.kripton.processor.sqlite.grammar.JQLProjection.ProjectionType;
import com.abubusoft.kripton.processor.sqlite.grammar.SQLiteBaseListener;
import com.abubusoft.kripton.processor.sqlite.grammar.SQLiteParser.Bind_dynamic_sqlContext;
import com.abubusoft.kripton.processor.sqlite.grammar.SQLiteParser.Bind_parameterContext;

import base.BaseProcessorTest;

@RunWith(JUnit4.class)
public class TestSqlChecker extends BaseProcessorTest {

	/**
	 * <p>
	 * OK
	 * </p>
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testOK() throws Throwable {				
		String sql = "SELECT id, action, number, countryCode, contactName, contactId FROM phone_number WHERE number = ${bean.number} and number = ${bean.number} and #{dynamicWhere} and #{dynamicWhere}";
		JQL jql=new JQL();
		jql.value=sql;

		JQLChecker jsqChecker = JQLChecker.getInstance();
		jsqChecker.analyze(jql, new SQLiteBaseListener() {

			@Override
			public void enterBind_parameter(Bind_parameterContext ctx) {
				TestSqlChecker.this.log("xx parameter name %s", ctx.bind_parameter_name().getText());
			}

			@Override
			public void enterBind_dynamic_sql(Bind_dynamic_sqlContext ctx) {
				TestSqlChecker.this.log("xx dynamic %s", ctx.bind_parameter_name().getText());
			}

		});

		jsqChecker.extractPlaceHoldersAsList(jql);
		log("replaced " + jsqChecker.replacePlaceHolders(jql, new JSQLPlaceHolderReplacerListener() {

			@Override
			public String onParameter(String value) {
				return "?";
			}

			@Override
			public String onDynamicSQL(String text) {
				return String.format("\"+%s+\"", text);
			}
		}));

		log("aa");
	}

	@Test
	public void testProjectColumn() {
		String sql = "select count(*) as pippo ,fieldName1, composed.fieldName2 from table where id = ${bean.id}";
		JQL jql=new JQL();
		jql.value=sql;

		JQLChecker.getInstance().extractProjections(jql);
	}

	@Test
	public void testDelet1() {
		String sql = "DELETE channel WHERE ownerUid=${field1} and ownerUid=${bean.field2} and ownerUid=${bean.field3} and ownerUid=${field5}";
		JQL jql=new JQL();
		jql.value=sql;
		
		
		JQLChecker checker = JQLChecker.getInstance();

		// verify sql
		checker.verify(jql);

		// check bind parameters
		{
			List<JQLPlaceHolder> aspected = new ArrayList<>();
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "field1"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field2"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field3"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "field5"));
			List<JQLPlaceHolder> actual = checker.extractPlaceHoldersAsList(jql);

			checkCollectionExactly(actual, aspected);
		}

	}

	/**
	 * extract projections from a select
	 */
	@Test
	public void testSelect01() {
		// String sql="SELECT count(*) FROM channel WHERE
		// updateTime=${bean.updateTime}";
		String sql = "SELECT count(*) as alias1, field2, field3 as alias3, table1.field3 as alias3, table2.field4 as alias4 FROM channel WHERE updateTime=${ bean.field1 } and field=${ field2  } and #{dynamicWhere1}";

		String logSql = "SELECT count(*) as alias1, field2, field3 as alias3, table1.field3 as alias3, table2.field4 as alias4 FROM channel WHERE updateTime=? and field=? and \"+dynamicWhere1+\"";
		// String usedSql = "SELECT count(*) FROM channel WHERE
		// updateTime=${bean.updateTime}";
		JQL jql=new JQL();
		jql.value=sql;


		JQLChecker checker = JQLChecker.getInstance();

		// verify sql
		checker.verify(jql);

		// check projections
		Set<JQLProjection> projections = checker.extractProjections(jql);
		{
			LinkedHashSet<JQLProjection> aspected = new LinkedHashSet<>();
			aspected.add(JQLProjection.ProjectionBuilder.create().type(ProjectionType.COMPLEX).expression("count(*)")
					.alias("alias1").build());
			aspected.add(JQLProjection.ProjectionBuilder.create().type(ProjectionType.COLUMN).column("field2").build());
			aspected.add(JQLProjection.ProjectionBuilder.create().type(ProjectionType.COLUMN).column("field3")
					.alias("alias3").build());
			aspected.add(JQLProjection.ProjectionBuilder.create().type(ProjectionType.COLUMN).table("table1")
					.column("field3").alias("alias3").build());
			aspected.add(JQLProjection.ProjectionBuilder.create().type(ProjectionType.COLUMN).table("table2")
					.column("field4").alias("alias4").build());
			checkCollectionExactly(projections, aspected);
		}

		// check bind parameters
		{
			List<JQLPlaceHolder> aspected = new ArrayList<>();
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field1"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "field2"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.DYNAMIC_SQL, "dynamicWhere1"));
			List<JQLPlaceHolder> actual = checker.extractPlaceHoldersAsList(jql);

			checkCollectionExactly(actual, aspected);
		}

		// prepare for log
		String sqlLogResult = checker.replacePlaceHolders(jql, new JSQLPlaceHolderReplacerListener() {

			@Override
			public String onParameter(String placeHolder) {
				return "?";
			}

			@Override
			public String onDynamicSQL(String placeHolder) {
				return String.format("\"+%s+\"", placeHolder);
			}
		});
		assertEquals("sql for log generation failed", logSql, sqlLogResult);
	}

	@Test
	public void testInsert01() {
		String sql = "INSERT INTO channel (uid, owner_uid, update_time, name, field) VALUES (${bean.field1}, ${bean.field2}, ${bean.field3}, ${bean.field4}, ${field5})";
		JQL jql=new JQL();
		jql.value=sql;

		JQLChecker checker = JQLChecker.getInstance();

		// verify sql
		checker.verify(jql);

		// check bind parameters
		{
			List<JQLPlaceHolder> aspected = new ArrayList<>();
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field1"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field2"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field3"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field4"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.DYNAMIC_SQL, "field5"));
			List<JQLPlaceHolder> actual = checker.extractPlaceHoldersAsList(jql);

			checkCollectionExactly(actual, aspected);
		}

	}

	@Test
	public void testUpdate01() {
		String sql = "UPDATE channel SET uid=${ bean.field1}, owner_uid=${bean.field2}, update_time=${bean.field3}, name=${field4} WHERE id=${bean.field1}";
		String sqlForLog = "UPDATE channel SET uid=?, owner_uid=?, update_time=?, name=? WHERE id=?";
		
		JQL jql=new JQL();
		jql.value=sql;


		JQLChecker checker = JQLChecker.getInstance();

		// verify sql
		checker.verify(jql);

		// check bind parameters
		{
			List<JQLPlaceHolder> aspected = new ArrayList<>();
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field1"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field2"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field3"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "field4"));
			aspected.add(new JQLPlaceHolder(JQLPlaceHolderType.PARAMETER, "bean.field1"));
			List<JQLPlaceHolder> actual = checker.extractPlaceHoldersAsList(jql);

			checkCollectionExactly(actual, aspected);
		}

		// prepare for log
		String sqlLogResult = checker.replacePlaceHolders(jql, new JSQLPlaceHolderReplacerListener() {

			@Override
			public String onParameter(String placeHolder) {
				return "?";
			}

			@Override
			public String onDynamicSQL(String placeHolder) {
				return String.format("\"+%s+\"", placeHolder);
			}
		});
		assertEquals("sql for log generation failed", sqlForLog, sqlLogResult);

	}

}
