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
package sqlite.kripton64;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.abubusoft.kripton.android.sqlite.TransactionResult;

import base.BaseAndroidTest;
import sqlite.kripton64.BindBean64DataSource.Transaction;


/**
 * The Class Test64Runtime.
 *
 * @author Francesco Benincasa (info@abubusoft.com)
 */
public class Test64Runtime extends BaseAndroidTest {

	/**
	 * Test run sqlite.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	@Test
	public void testRunSqlite() throws IOException, InstantiationException, IllegalAccessException {
		BindBean64DataSource dataSource = BindBean64DataSource.getInstance();

		dataSource.execute(new Transaction() {

			@Override
			public TransactionResult onExecute(BindBean64DaoFactory daoFactory) {
				Bean64DaoImpl dao = daoFactory.getBean64Dao();

				Bean64 bean = new Bean64();
				bean.valueString = "hello";
				bean.valueMapStringBean = new HashMap<>();
				bean.valueMapStringBean.put("key1", new Bean64());
				bean.valueSetString = new HashSet<String>();
				bean.valueSetString.add("hello");

				dao.insert(bean);
				List<Bean64> list = dao.selectList(bean.id);
				Assert.assertEquals("not list ", 1, list.size());

				Assert.assertEquals("not set", 1, list.get(0).valueSetString.size());

				// Assert.assertEquals("not set", 1,
				// list.get(0).valueSetString.size());

				return TransactionResult.COMMIT;
			}
			

		});

	}
	
	// @Test
	// public void testRunSharedPreferences() throws IOException,
	// InstantiationException, IllegalAccessException {
	// BindBeanSharedPreferences shared = BindBeanSharedPreferences.instance();
	//
	// shared.registerOnSharedPreferenceChangeListener(new
	// OnSharedPreferenceChangeListener() {
	//
	// @Override
	// public void onSharedPreferenceChanged(SharedPreferences
	// sharedPreferences, String key) {
	// Log.i("TAG", "change "+key);
	// }
	// });
	//
	// Calendar c=Calendar.getInstance();
	// Date d=new Date();
	//
	// shared.edit()
	// .putValueBool(true)
	// .putValueBoolType(true)
	// .putValueBigDecimal(new BigDecimal(10))
	// .putValueBigInteger(BigInteger.valueOf(20))
	// .putValueByte((byte)34)
	// .putValueByteType((byte)34)
	// .putValueCalendar(c)
	// .putValueChar((char)3)
	// .putValueCurrency(Currency.getInstance(Locale.ITALY))
	// .putValueDate(d)
	// .putValueDouble(34.0)
	// .putValueDoubleType(34.0)
	// .putValueEnumType(EnumType.VALUE_2)
	// .putValueFloat(2f)
	// .putValueFloatType(2f)
	// .putValueLocale(Locale.JAPAN)
	// .putValueLong(2L)
	// .putValueLongType(2L)
	// .putValueString("hello")
	//
	// .commit();
	//
	// Assert.assertEquals(true, shared.valueBool());
	// Assert.assertEquals(true, shared.valueBoolType());
	// Assert.assertEquals(new BigDecimal(10), shared.valueBigDecimal());
	// Assert.assertEquals(BigInteger.valueOf(20), shared.valueBigInteger());
	// Assert.assertTrue((byte)34==shared.valueByte());
	// Assert.assertEquals((byte)34, shared.valueByteType());
	// Assert.assertEquals(c, shared.valueCalendar());
	// Assert.assertTrue((char)3==shared.valueChar());
	// Assert.assertEquals(Currency.getInstance(Locale.ITALY),
	// shared.valueCurrency());
	// Assert.assertEquals(d, shared.valueDate());
	// Assert.assertTrue(34.0==shared.valueDouble());
	// Assert.assertTrue(34.0==shared.valueDoubleType());
	// Assert.assertEquals(EnumType.VALUE_2, shared.valueEnumType());
	// Assert.assertTrue(2.0f==shared.valueFloat());
	// Assert.assertTrue(2.0f==shared.valueFloatType());
	// Assert.assertEquals(Locale.JAPAN, shared.valueLocale());
	// Assert.assertTrue(2L==shared.valueLong());
	// Assert.assertTrue(2L==shared.valueLongType());
	// Assert.assertEquals("hello", shared.valueString());
	// }

}
