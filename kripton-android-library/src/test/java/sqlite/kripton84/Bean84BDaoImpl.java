package sqlite.kripton84;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.abubusoft.kripton.BinderUtils;
import com.abubusoft.kripton.KriptonBinder;
import com.abubusoft.kripton.KriptonJsonContext;
import com.abubusoft.kripton.android.Logger;
import com.abubusoft.kripton.android.sqlite.Dao;
import com.abubusoft.kripton.android.sqlite.KriptonContentValues;
import com.abubusoft.kripton.android.sqlite.KriptonDatabaseHelper;
import com.abubusoft.kripton.common.KriptonByteArrayOutputStream;
import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.common.Triple;
import com.abubusoft.kripton.exception.KriptonRuntimeException;
import com.abubusoft.kripton.persistence.JacksonWrapperParser;
import com.abubusoft.kripton.persistence.JacksonWrapperSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * DAO implementation for entity <code>Bean84B</code>, based on interface <code>Bean84BDao</code>
 * </p>
 *
 *  @see Bean84B
 *  @see Bean84BDao
 *  @see Bean84BTable
 */
public class Bean84BDaoImpl extends Dao implements Bean84BDao {
  /**
   * SQL definition for method selectById
   */
  private static final String SELECT_BY_ID_SQL1 = "SELECT id, column_bean FROM bean84_b WHERE id = ?";

  /**
   * SQL definition for method selectByBean
   */
  private static final String SELECT_BY_BEAN_SQL2 = "SELECT id, column_bean FROM bean84_b WHERE cast(column_bean as TEXT) = ?";

  private static SupportSQLiteStatement insertPreparedStatement0;

  private static SupportSQLiteStatement updateAllPreparedStatement1;

  private static SupportSQLiteStatement deleteAllPreparedStatement2;

  /**
   * binder for type Bean84B2
   */
  private static Bean84B2BindMap bean84B2BindMap = BinderUtils.mapperFor(Bean84B2.class);

  public Bean84BDaoImpl(BindBean84BDaoFactory daoFactory) {
    super(daoFactory.getContext());
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, column_bean FROM bean84_b WHERE id = ${id}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean84B}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>column_bean</dt><dd>is associated to bean's property <strong>columnBean</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:id</dt><dd>is binded to method's parameter <strong>param1</strong></dd>
   * </dl>
   *
   * @param param1
   * 	is binded to <code>:id</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean84B selectById(long param1) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_BY_ID_SQL1;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(param1));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section for select BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section for select END
    try (Cursor _cursor = getDatabase().query(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      // common part generation - END
      // Specialized part - SelectBeanHelper - BEGIN

      Bean84B resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("column_bean");

        resultBean=new Bean84B();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.columnBean=Bean84BTable.parseColumnBean(_cursor.getBlob(index1)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, column_bean FROM bean84_b WHERE cast(column_bean as TEXT) = ${param1}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean84B}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>column_bean</dt><dd>is associated to bean's property <strong>columnBean</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:param1</dt><dd>is binded to method's parameter <strong>param1</strong></dd>
   * </dl>
   *
   * @param param1
   * 	is binded to <code>:param1</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean84B selectByBean(Bean84B2 param1) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_BY_BEAN_SQL2;
    // add where arguments
    _contentValues.addWhereArgs((param1==null?"":new String(serializer1(param1),StandardCharsets.UTF_8)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section for select BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section for select END
    try (Cursor _cursor = getDatabase().query(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      // common part generation - END
      // Specialized part - SelectBeanHelper - BEGIN

      Bean84B resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("column_bean");

        resultBean=new Bean84B();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.columnBean=Bean84BTable.parseColumnBean(_cursor.getBlob(index1)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean84_b (column_bean) VALUES (:bean.columnBean)</pre>
   *
   * <p><code>bean.id</code> is automatically updated because it is the primary key</p>
   *
   * <p><strong>Inserted columns:</strong></p>
   * <dl>
   * 	<dt>column_bean</dt><dd>is mapped to <strong>:bean.columnBean</strong></dd>
   * </dl>
   *
   * @param bean
   * 	is mapped to parameter <strong>bean</strong>
   *
   * @return <code>true</code> if record is inserted, <code>false</code> otherwise
   */
  @Override
  public boolean insert(Bean84B bean) {
    // Specialized Insert - InsertType - BEGIN
    if (insertPreparedStatement0==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean84_b (column_bean) VALUES (?)";
      insertPreparedStatement0 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement0);
    _contentValues.put("column_bean", Bean84BTable.serializeColumnBean(bean.columnBean));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean84_b (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseHelper.insert(insertPreparedStatement0, _contentValues);
    // if PK string, can not overwrite id (with a long) same thing if column type is UNMANAGED (user manage PK)
    bean.id=result;

    return result!=-1;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean84_b SET column_bean=:columnBean</pre>
   *
   * <h2>Updated columns</h2>
   * <dl>
   * 	<dt>column_bean</dt><dd>is mapped to <strong>:bean.columnBean</strong></dd>
   * </dl>
   *
   * @param bean
   * 	is used as <code>:bean</code>
   *
   * @return <code>true</code> if record is updated, <code>false</code> otherwise
   */
  @Override
  public boolean updateAll(Bean84B bean) {
    if (updateAllPreparedStatement1==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean84_b SET column_bean=?";
      updateAllPreparedStatement1 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateAllPreparedStatement1);
    _contentValues.put("column_bean", Bean84BTable.serializeColumnBean(bean.columnBean));


    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean84_b SET column_bean=:column_bean");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(updateAllPreparedStatement1, _contentValues);
    return result!=0;
  }

  /**
   * <h2>SQL delete:</h2>
   * <pre>DELETE FROM bean84_b</pre>
   *
   * @param bean
   * 	is used as <code>:bean</code>
   *
   * @return <code>true</code> if record is deleted, <code>false</code> otherwise
   */
  @Override
  public boolean deleteAll(Bean84B bean) {
    if (deleteAllPreparedStatement2==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean84_b";
      deleteAllPreparedStatement2 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteAllPreparedStatement2);

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean84_b");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteAllPreparedStatement2, _contentValues);
    return result!=0;
  }

  /**
   * for param serializer1 serialization
   */
  private static byte[] serializer1(Bean84B2 value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      if (value!=null)  {
        bean84B2BindMap.serializeOnJackson(value, jacksonSerializer);
      }
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param parser1 parsing
   */
  private static Bean84B2 parser1(byte[] input) {
    if (input==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (JacksonWrapperParser wrapper=context.createParser(input)) {
      JsonParser jacksonParser=wrapper.jacksonParser;
      // START_OBJECT
      jacksonParser.nextToken();
      // value of "element"
      jacksonParser.nextValue();
      Bean84B2 result=null;
      if (jacksonParser.currentToken()==JsonToken.START_OBJECT) {
        result=bean84B2BindMap.parseOnJackson(jacksonParser);
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  public static void clearCompiledStatements() {
    try {
      if (insertPreparedStatement0!=null) {
        insertPreparedStatement0.close();
        insertPreparedStatement0=null;
      }
      if (updateAllPreparedStatement1!=null) {
        updateAllPreparedStatement1.close();
        updateAllPreparedStatement1=null;
      }
      if (deleteAllPreparedStatement2!=null) {
        deleteAllPreparedStatement2.close();
        deleteAllPreparedStatement2=null;
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
