package sqlite.kripton60;

import com.abubusoft.kripton.BinderUtils;
import com.abubusoft.kripton.KriptonBinder;
import com.abubusoft.kripton.KriptonJsonContext;
import com.abubusoft.kripton.android.sqlite.SQLiteTable;
import com.abubusoft.kripton.common.CollectionUtils;
import com.abubusoft.kripton.common.KriptonByteArrayOutputStream;
import com.abubusoft.kripton.common.SQLTimeUtils;
import com.abubusoft.kripton.exception.KriptonRuntimeException;
import com.abubusoft.kripton.persistence.JacksonWrapperParser;
import com.abubusoft.kripton.persistence.JacksonWrapperSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * Entity <code>Bean</code> is associated to table <code>bean</code>
 * This class represents table associated to entity.
 * </p>
 *  @see Bean
 */
public class BeanTable implements SQLiteTable {
  /**
   * Costant represents typeName of table bean
   */
  public static final String TABLE_NAME = "bean";

  /**
   * <p>
   * DDL to create table bean
   * </p>
   *
   * <pre>CREATE TABLE bean (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, value_bean_array BLOB, value_big_decimal TEXT, value_big_integer TEXT, value_bool INTEGER, value_bool_type INTEGER, value_byte INTEGER, value_byte_array BLOB, value_byte_type INTEGER, value_calendar TEXT, value_char INTEGER, value_char_array BLOB, value_char_list BLOB, value_char_type INTEGER, value_char_type_array BLOB, value_currency TEXT, value_date TEXT, value_double REAL, value_double_type REAL, value_enum_type TEXT, value_float REAL, value_float_type REAL, value_int INTEGER, value_int_type INTEGER, value_linked_map_string_bean BLOB, value_locale TEXT, value_long INTEGER, value_long_array BLOB, value_long_list BLOB, value_long_type INTEGER, value_long_type_array BLOB, value_map_string_bean BLOB, value_set_string BLOB, value_short INTEGER, value_short_type INTEGER, value_strin_list BLOB, value_string TEXT, value_string_array BLOB, value_time TEXT, value_time_list BLOB, value_time_zone TEXT, value_url TEXT);</pre>
   */
  public static final String CREATE_TABLE_SQL = "CREATE TABLE bean (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, value_bean_array BLOB, value_big_decimal TEXT, value_big_integer TEXT, value_bool INTEGER, value_bool_type INTEGER, value_byte INTEGER, value_byte_array BLOB, value_byte_type INTEGER, value_calendar TEXT, value_char INTEGER, value_char_array BLOB, value_char_list BLOB, value_char_type INTEGER, value_char_type_array BLOB, value_currency TEXT, value_date TEXT, value_double REAL, value_double_type REAL, value_enum_type TEXT, value_float REAL, value_float_type REAL, value_int INTEGER, value_int_type INTEGER, value_linked_map_string_bean BLOB, value_locale TEXT, value_long INTEGER, value_long_array BLOB, value_long_list BLOB, value_long_type INTEGER, value_long_type_array BLOB, value_map_string_bean BLOB, value_set_string BLOB, value_short INTEGER, value_short_type INTEGER, value_strin_list BLOB, value_string TEXT, value_string_array BLOB, value_time TEXT, value_time_list BLOB, value_time_zone TEXT, value_url TEXT);";

  /**
   * <p>
   * DDL to drop table bean
   * </p>
   *
   * <pre>DROP TABLE IF EXISTS bean;</pre>
   */
  public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS bean;";

  /**
   * Entity's property <code>id</code> is associated to table column <code>id</code>. This costant represents column name.
   *
   *  @see Bean#id
   */
  public static final String COLUMN_ID = "id";

  /**
   * Entity's property <code>valueBeanArray</code> is associated to table column <code>value_bean_array</code>. This costant represents column name.
   *
   *  @see Bean#valueBeanArray
   */
  public static final String COLUMN_VALUE_BEAN_ARRAY = "value_bean_array";

  /**
   * Entity's property <code>valueBigDecimal</code> is associated to table column <code>value_big_decimal</code>. This costant represents column name.
   *
   *  @see Bean#valueBigDecimal
   */
  public static final String COLUMN_VALUE_BIG_DECIMAL = "value_big_decimal";

  /**
   * Entity's property <code>valueBigInteger</code> is associated to table column <code>value_big_integer</code>. This costant represents column name.
   *
   *  @see Bean#valueBigInteger
   */
  public static final String COLUMN_VALUE_BIG_INTEGER = "value_big_integer";

  /**
   * Entity's property <code>valueBool</code> is associated to table column <code>value_bool</code>. This costant represents column name.
   *
   *  @see Bean#valueBool
   */
  public static final String COLUMN_VALUE_BOOL = "value_bool";

  /**
   * Entity's property <code>valueBoolType</code> is associated to table column <code>value_bool_type</code>. This costant represents column name.
   *
   *  @see Bean#valueBoolType
   */
  public static final String COLUMN_VALUE_BOOL_TYPE = "value_bool_type";

  /**
   * Entity's property <code>valueByte</code> is associated to table column <code>value_byte</code>. This costant represents column name.
   *
   *  @see Bean#valueByte
   */
  public static final String COLUMN_VALUE_BYTE = "value_byte";

  /**
   * Entity's property <code>valueByteArray</code> is associated to table column <code>value_byte_array</code>. This costant represents column name.
   *
   *  @see Bean#valueByteArray
   */
  public static final String COLUMN_VALUE_BYTE_ARRAY = "value_byte_array";

  /**
   * Entity's property <code>valueByteType</code> is associated to table column <code>value_byte_type</code>. This costant represents column name.
   *
   *  @see Bean#valueByteType
   */
  public static final String COLUMN_VALUE_BYTE_TYPE = "value_byte_type";

  /**
   * Entity's property <code>valueCalendar</code> is associated to table column <code>value_calendar</code>. This costant represents column name.
   *
   *  @see Bean#valueCalendar
   */
  public static final String COLUMN_VALUE_CALENDAR = "value_calendar";

  /**
   * Entity's property <code>valueChar</code> is associated to table column <code>value_char</code>. This costant represents column name.
   *
   *  @see Bean#valueChar
   */
  public static final String COLUMN_VALUE_CHAR = "value_char";

  /**
   * Entity's property <code>valueCharArray</code> is associated to table column <code>value_char_array</code>. This costant represents column name.
   *
   *  @see Bean#valueCharArray
   */
  public static final String COLUMN_VALUE_CHAR_ARRAY = "value_char_array";

  /**
   * Entity's property <code>valueCharList</code> is associated to table column <code>value_char_list</code>. This costant represents column name.
   *
   *  @see Bean#valueCharList
   */
  public static final String COLUMN_VALUE_CHAR_LIST = "value_char_list";

  /**
   * Entity's property <code>valueCharType</code> is associated to table column <code>value_char_type</code>. This costant represents column name.
   *
   *  @see Bean#valueCharType
   */
  public static final String COLUMN_VALUE_CHAR_TYPE = "value_char_type";

  /**
   * Entity's property <code>valueCharTypeArray</code> is associated to table column <code>value_char_type_array</code>. This costant represents column name.
   *
   *  @see Bean#valueCharTypeArray
   */
  public static final String COLUMN_VALUE_CHAR_TYPE_ARRAY = "value_char_type_array";

  /**
   * Entity's property <code>valueCurrency</code> is associated to table column <code>value_currency</code>. This costant represents column name.
   *
   *  @see Bean#valueCurrency
   */
  public static final String COLUMN_VALUE_CURRENCY = "value_currency";

  /**
   * Entity's property <code>valueDate</code> is associated to table column <code>value_date</code>. This costant represents column name.
   *
   *  @see Bean#valueDate
   */
  public static final String COLUMN_VALUE_DATE = "value_date";

  /**
   * Entity's property <code>valueDouble</code> is associated to table column <code>value_double</code>. This costant represents column name.
   *
   *  @see Bean#valueDouble
   */
  public static final String COLUMN_VALUE_DOUBLE = "value_double";

  /**
   * Entity's property <code>valueDoubleType</code> is associated to table column <code>value_double_type</code>. This costant represents column name.
   *
   *  @see Bean#valueDoubleType
   */
  public static final String COLUMN_VALUE_DOUBLE_TYPE = "value_double_type";

  /**
   * Entity's property <code>valueEnumType</code> is associated to table column <code>value_enum_type</code>. This costant represents column name.
   *
   *  @see Bean#valueEnumType
   */
  public static final String COLUMN_VALUE_ENUM_TYPE = "value_enum_type";

  /**
   * Entity's property <code>valueFloat</code> is associated to table column <code>value_float</code>. This costant represents column name.
   *
   *  @see Bean#valueFloat
   */
  public static final String COLUMN_VALUE_FLOAT = "value_float";

  /**
   * Entity's property <code>valueFloatType</code> is associated to table column <code>value_float_type</code>. This costant represents column name.
   *
   *  @see Bean#valueFloatType
   */
  public static final String COLUMN_VALUE_FLOAT_TYPE = "value_float_type";

  /**
   * Entity's property <code>valueInt</code> is associated to table column <code>value_int</code>. This costant represents column name.
   *
   *  @see Bean#valueInt
   */
  public static final String COLUMN_VALUE_INT = "value_int";

  /**
   * Entity's property <code>valueIntType</code> is associated to table column <code>value_int_type</code>. This costant represents column name.
   *
   *  @see Bean#valueIntType
   */
  public static final String COLUMN_VALUE_INT_TYPE = "value_int_type";

  /**
   * Entity's property <code>valueLinkedMapStringBean</code> is associated to table column <code>value_linked_map_string_bean</code>. This costant represents column name.
   *
   *  @see Bean#valueLinkedMapStringBean
   */
  public static final String COLUMN_VALUE_LINKED_MAP_STRING_BEAN = "value_linked_map_string_bean";

  /**
   * Entity's property <code>valueLocale</code> is associated to table column <code>value_locale</code>. This costant represents column name.
   *
   *  @see Bean#valueLocale
   */
  public static final String COLUMN_VALUE_LOCALE = "value_locale";

  /**
   * Entity's property <code>valueLong</code> is associated to table column <code>value_long</code>. This costant represents column name.
   *
   *  @see Bean#valueLong
   */
  public static final String COLUMN_VALUE_LONG = "value_long";

  /**
   * Entity's property <code>valueLongArray</code> is associated to table column <code>value_long_array</code>. This costant represents column name.
   *
   *  @see Bean#valueLongArray
   */
  public static final String COLUMN_VALUE_LONG_ARRAY = "value_long_array";

  /**
   * Entity's property <code>valueLongList</code> is associated to table column <code>value_long_list</code>. This costant represents column name.
   *
   *  @see Bean#valueLongList
   */
  public static final String COLUMN_VALUE_LONG_LIST = "value_long_list";

  /**
   * Entity's property <code>valueLongType</code> is associated to table column <code>value_long_type</code>. This costant represents column name.
   *
   *  @see Bean#valueLongType
   */
  public static final String COLUMN_VALUE_LONG_TYPE = "value_long_type";

  /**
   * Entity's property <code>valueLongTypeArray</code> is associated to table column <code>value_long_type_array</code>. This costant represents column name.
   *
   *  @see Bean#valueLongTypeArray
   */
  public static final String COLUMN_VALUE_LONG_TYPE_ARRAY = "value_long_type_array";

  /**
   * Entity's property <code>valueMapStringBean</code> is associated to table column <code>value_map_string_bean</code>. This costant represents column name.
   *
   *  @see Bean#valueMapStringBean
   */
  public static final String COLUMN_VALUE_MAP_STRING_BEAN = "value_map_string_bean";

  /**
   * Entity's property <code>valueSetString</code> is associated to table column <code>value_set_string</code>. This costant represents column name.
   *
   *  @see Bean#valueSetString
   */
  public static final String COLUMN_VALUE_SET_STRING = "value_set_string";

  /**
   * Entity's property <code>valueShort</code> is associated to table column <code>value_short</code>. This costant represents column name.
   *
   *  @see Bean#valueShort
   */
  public static final String COLUMN_VALUE_SHORT = "value_short";

  /**
   * Entity's property <code>valueShortType</code> is associated to table column <code>value_short_type</code>. This costant represents column name.
   *
   *  @see Bean#valueShortType
   */
  public static final String COLUMN_VALUE_SHORT_TYPE = "value_short_type";

  /**
   * Entity's property <code>valueStrinList</code> is associated to table column <code>value_strin_list</code>. This costant represents column name.
   *
   *  @see Bean#valueStrinList
   */
  public static final String COLUMN_VALUE_STRIN_LIST = "value_strin_list";

  /**
   * Entity's property <code>valueString</code> is associated to table column <code>value_string</code>. This costant represents column name.
   *
   *  @see Bean#valueString
   */
  public static final String COLUMN_VALUE_STRING = "value_string";

  /**
   * Entity's property <code>valueStringArray</code> is associated to table column <code>value_string_array</code>. This costant represents column name.
   *
   *  @see Bean#valueStringArray
   */
  public static final String COLUMN_VALUE_STRING_ARRAY = "value_string_array";

  /**
   * Entity's property <code>valueTime</code> is associated to table column <code>value_time</code>. This costant represents column name.
   *
   *  @see Bean#valueTime
   */
  public static final String COLUMN_VALUE_TIME = "value_time";

  /**
   * Entity's property <code>valueTimeList</code> is associated to table column <code>value_time_list</code>. This costant represents column name.
   *
   *  @see Bean#valueTimeList
   */
  public static final String COLUMN_VALUE_TIME_LIST = "value_time_list";

  /**
   * Entity's property <code>valueTimeZone</code> is associated to table column <code>value_time_zone</code>. This costant represents column name.
   *
   *  @see Bean#valueTimeZone
   */
  public static final String COLUMN_VALUE_TIME_ZONE = "value_time_zone";

  /**
   * Entity's property <code>valueUrl</code> is associated to table column <code>value_url</code>. This costant represents column name.
   *
   *  @see Bean#valueUrl
   */
  public static final String COLUMN_VALUE_URL = "value_url";

  /**
   * binder for type Bean
   */
  private static BeanBindMap beanBindMap = BinderUtils.mapperFor(Bean.class);

  /**
   * Columns array
   */
  private static final String[] COLUMNS = {COLUMN_ID, COLUMN_VALUE_BEAN_ARRAY, COLUMN_VALUE_BIG_DECIMAL, COLUMN_VALUE_BIG_INTEGER, COLUMN_VALUE_BOOL, COLUMN_VALUE_BOOL_TYPE, COLUMN_VALUE_BYTE, COLUMN_VALUE_BYTE_ARRAY, COLUMN_VALUE_BYTE_TYPE, COLUMN_VALUE_CALENDAR, COLUMN_VALUE_CHAR, COLUMN_VALUE_CHAR_ARRAY, COLUMN_VALUE_CHAR_LIST, COLUMN_VALUE_CHAR_TYPE, COLUMN_VALUE_CHAR_TYPE_ARRAY, COLUMN_VALUE_CURRENCY, COLUMN_VALUE_DATE, COLUMN_VALUE_DOUBLE, COLUMN_VALUE_DOUBLE_TYPE, COLUMN_VALUE_ENUM_TYPE, COLUMN_VALUE_FLOAT, COLUMN_VALUE_FLOAT_TYPE, COLUMN_VALUE_INT, COLUMN_VALUE_INT_TYPE, COLUMN_VALUE_LINKED_MAP_STRING_BEAN, COLUMN_VALUE_LOCALE, COLUMN_VALUE_LONG, COLUMN_VALUE_LONG_ARRAY, COLUMN_VALUE_LONG_LIST, COLUMN_VALUE_LONG_TYPE, COLUMN_VALUE_LONG_TYPE_ARRAY, COLUMN_VALUE_MAP_STRING_BEAN, COLUMN_VALUE_SET_STRING, COLUMN_VALUE_SHORT, COLUMN_VALUE_SHORT_TYPE, COLUMN_VALUE_STRIN_LIST, COLUMN_VALUE_STRING, COLUMN_VALUE_STRING_ARRAY, COLUMN_VALUE_TIME, COLUMN_VALUE_TIME_LIST, COLUMN_VALUE_TIME_ZONE, COLUMN_VALUE_URL};

  /**
   * for attribute valueBeanArray serialization
   */
  public static byte[] serializeValueBeanArray(Bean[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        int n=value.length;
        Bean item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            beanBindMap.serializeOnJackson(item, jacksonSerializer);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueBeanArray parsing
   */
  public static Bean[] parseValueBeanArray(byte[] input) {
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
      Bean[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Bean> collection=new ArrayList<>();
        Bean item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=beanBindMap.parseOnJackson(jacksonParser);
          }
          collection.add(item);
        }
        result=CollectionUtils.asArray(collection, new Bean[collection.size()]);
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueByteArray serialization
   */
  public static byte[] serializeValueByteArray(byte[] value) {
    return value;
  }

  /**
   * for attribute valueByteArray parsing
   */
  public static byte[] parseValueByteArray(byte[] input) {
    return input;
  }

  /**
   * for attribute valueCharArray serialization
   */
  public static byte[] serializeValueCharArray(Character[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        int n=value.length;
        Character item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeNumber(item);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueCharArray parsing
   */
  public static Character[] parseValueCharArray(byte[] input) {
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
      Character[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Character> collection=new ArrayList<>();
        Character item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=Character.valueOf((char)jacksonParser.getIntValue());
          }
          collection.add(item);
        }
        result=CollectionUtils.asCharacterArray(collection);
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueCharList serialization
   */
  public static byte[] serializeValueCharList(LinkedList<Character> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        int n=value.size();
        Character item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value.get(i);
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeNumber(item);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueCharList parsing
   */
  public static LinkedList<Character> parseValueCharList(byte[] input) {
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
      LinkedList<Character> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        LinkedList<Character> collection=new LinkedList<>();
        Character item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=Character.valueOf((char)jacksonParser.getIntValue());
          }
          collection.add(item);
        }
        result=collection;
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueCharTypeArray serialization
   */
  public static byte[] serializeValueCharTypeArray(char[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        int n=value.length;
        char item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          jacksonSerializer.writeNumber(item);
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueCharTypeArray parsing
   */
  public static char[] parseValueCharTypeArray(byte[] input) {
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
      char[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Character> collection=new ArrayList<>();
        Character item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=Character.valueOf((char)jacksonParser.getIntValue());
          }
          collection.add(item);
        }
        result=CollectionUtils.asCharacterTypeArray(collection);
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLinkedMapStringBean serialization
   */
  public static byte[] serializeValueLinkedMapStringBean(LinkedHashMap<String, Bean> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        // write wrapper tag
        if (value.size()>0) {
          jacksonSerializer.writeFieldName("element");
          jacksonSerializer.writeStartArray();
          for (Map.Entry<String, Bean> item: value.entrySet()) {
            jacksonSerializer.writeStartObject();
            jacksonSerializer.writeStringField("key", item.getKey());
            if (item.getValue()==null) {
              jacksonSerializer.writeNullField("value");
            } else {
              jacksonSerializer.writeFieldName("value");
              beanBindMap.serializeOnJackson(item.getValue(), jacksonSerializer);
            }
            jacksonSerializer.writeEndObject();
          }
          jacksonSerializer.writeEndArray();
        } else {
          jacksonSerializer.writeNullField("element");
        }
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLinkedMapStringBean parsing
   */
  public static LinkedHashMap<String, Bean> parseValueLinkedMapStringBean(byte[] input) {
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
      LinkedHashMap<String, Bean> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        LinkedHashMap<String, Bean> collection=new LinkedHashMap<>();
        String key=null;
        Bean value=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          jacksonParser.nextValue();
          key=jacksonParser.getText();
          jacksonParser.nextValue();
          if (jacksonParser.currentToken()==JsonToken.START_OBJECT) {
            value=beanBindMap.parseOnJackson(jacksonParser);
          }
          collection.put(key, value);
          key=null;
          value=null;
          jacksonParser.nextToken();
        }
        result=collection;
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLongArray serialization
   */
  public static byte[] serializeValueLongArray(Long[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        int n=value.length;
        Long item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeNumber(item);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLongArray parsing
   */
  public static Long[] parseValueLongArray(byte[] input) {
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
      Long[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Long> collection=new ArrayList<>();
        Long item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=jacksonParser.getLongValue();
          }
          collection.add(item);
        }
        result=CollectionUtils.asLongArray(collection);
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLongList serialization
   */
  public static byte[] serializeValueLongList(LinkedList<Long> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        int n=value.size();
        Long item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value.get(i);
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeNumber(item);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLongList parsing
   */
  public static LinkedList<Long> parseValueLongList(byte[] input) {
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
      LinkedList<Long> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        LinkedList<Long> collection=new LinkedList<>();
        Long item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=jacksonParser.getLongValue();
          }
          collection.add(item);
        }
        result=collection;
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLongTypeArray serialization
   */
  public static byte[] serializeValueLongTypeArray(long[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        int n=value.length;
        long item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          jacksonSerializer.writeNumber(item);
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLongTypeArray parsing
   */
  public static long[] parseValueLongTypeArray(byte[] input) {
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
      long[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Long> collection=new ArrayList<>();
        Long item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=jacksonParser.getLongValue();
          }
          collection.add(item);
        }
        result=CollectionUtils.asLongTypeArray(collection);
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueMapStringBean serialization
   */
  public static byte[] serializeValueMapStringBean(Map<String, Bean> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        // write wrapper tag
        if (value.size()>0) {
          jacksonSerializer.writeFieldName("element");
          jacksonSerializer.writeStartArray();
          for (Map.Entry<String, Bean> item: value.entrySet()) {
            jacksonSerializer.writeStartObject();
            jacksonSerializer.writeStringField("key", item.getKey());
            if (item.getValue()==null) {
              jacksonSerializer.writeNullField("value");
            } else {
              jacksonSerializer.writeFieldName("value");
              beanBindMap.serializeOnJackson(item.getValue(), jacksonSerializer);
            }
            jacksonSerializer.writeEndObject();
          }
          jacksonSerializer.writeEndArray();
        } else {
          jacksonSerializer.writeNullField("element");
        }
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueMapStringBean parsing
   */
  public static Map<String, Bean> parseValueMapStringBean(byte[] input) {
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
      Map<String, Bean> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        HashMap<String, Bean> collection=new HashMap<>();
        String key=null;
        Bean value=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          jacksonParser.nextValue();
          key=jacksonParser.getText();
          jacksonParser.nextValue();
          if (jacksonParser.currentToken()==JsonToken.START_OBJECT) {
            value=beanBindMap.parseOnJackson(jacksonParser);
          }
          collection.put(key, value);
          key=null;
          value=null;
          jacksonParser.nextToken();
        }
        result=collection;
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueSetString serialization
   */
  public static byte[] serializeValueSetString(Set<String> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (String item: value) {
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeString(item);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueSetString parsing
   */
  public static Set<String> parseValueSetString(byte[] input) {
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
      Set<String> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        HashSet<String> collection=new HashSet<>();
        String item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=jacksonParser.getText();
          }
          collection.add(item);
        }
        result=collection;
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueStrinList serialization
   */
  public static byte[] serializeValueStrinList(LinkedList<String> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        int n=value.size();
        String item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value.get(i);
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeString(item);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueStrinList parsing
   */
  public static LinkedList<String> parseValueStrinList(byte[] input) {
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
      LinkedList<String> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        LinkedList<String> collection=new LinkedList<>();
        String item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=jacksonParser.getText();
          }
          collection.add(item);
        }
        result=collection;
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueStringArray serialization
   */
  public static byte[] serializeValueStringArray(String[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        int n=value.length;
        String item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeString(item);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueStringArray parsing
   */
  public static String[] parseValueStringArray(byte[] input) {
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
      String[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<String> collection=new ArrayList<>();
        String item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=jacksonParser.getText();
          }
          collection.add(item);
        }
        result=CollectionUtils.asArray(collection, new String[collection.size()]);
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueTimeList serialization
   */
  public static byte[] serializeValueTimeList(List<Time> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      jacksonSerializer.writeStartObject();
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        int n=value.size();
        Time item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value.get(i);
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeString(SQLTimeUtils.write(item));
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueTimeList parsing
   */
  public static List<Time> parseValueTimeList(byte[] input) {
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
      List<Time> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Time> collection=new ArrayList<>();
        Time item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=SQLTimeUtils.read(jacksonParser.getText());
          }
          collection.add(item);
        }
        result=collection;
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * Columns array
   */
  @Override
  public String[] columns() {
    return COLUMNS;
  }

  /**
   * table name
   */
  @Override
  public String name() {
    return TABLE_NAME;
  }
}
