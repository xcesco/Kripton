package sqlite.kripton84;

import com.abubusoft.kripton.BinderUtils;
import com.abubusoft.kripton.KriptonBinder;
import com.abubusoft.kripton.KriptonJsonContext;
import com.abubusoft.kripton.android.sqlite.SQLiteTable;
import com.abubusoft.kripton.common.CollectionUtils;
import com.abubusoft.kripton.common.KriptonByteArrayOutputStream;
import com.abubusoft.kripton.exception.KriptonRuntimeException;
import com.abubusoft.kripton.persistence.JacksonWrapperParser;
import com.abubusoft.kripton.persistence.JacksonWrapperSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Entity <code>Bean84A</code> is associated to table <code>bean84_a</code>
 * This class represents table associated to entity.
 * </p>
 *  @see Bean84A
 */
public class Bean84ATable implements SQLiteTable {
  /**
   * Costant represents typeName of table bean84_a
   */
  public static final String TABLE_NAME = "bean84_a";

  /**
   * <p>
   * DDL to create table bean84_a
   * </p>
   *
   * <pre>CREATE TABLE bean84_a (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, column_array_byte_type BLOB, column_array_char BLOB, column_array_char_type BLOB, column_bean BLOB, column_list_string BLOB, column_map_integer_string BLOB, param1 TEXT, param2 TEXT, param3 TEXT, param4 TEXT, value_string TEXT);</pre>
   */
  public static final String CREATE_TABLE_SQL = "CREATE TABLE bean84_a (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, column_array_byte_type BLOB, column_array_char BLOB, column_array_char_type BLOB, column_bean BLOB, column_list_string BLOB, column_map_integer_string BLOB, param1 TEXT, param2 TEXT, param3 TEXT, param4 TEXT, value_string TEXT);";

  /**
   * <p>
   * DDL to drop table bean84_a
   * </p>
   *
   * <pre>DROP TABLE IF EXISTS bean84_a;</pre>
   */
  public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS bean84_a;";

  /**
   * Entity's property <code>id</code> is associated to table column <code>id</code>. This costant represents column name.
   *
   *  @see Bean84A#id
   */
  public static final String COLUMN_ID = "id";

  /**
   * Entity's property <code>columnArrayByteType</code> is associated to table column <code>column_array_byte_type</code>. This costant represents column name.
   *
   *  @see Bean84A#columnArrayByteType
   */
  public static final String COLUMN_COLUMN_ARRAY_BYTE_TYPE = "column_array_byte_type";

  /**
   * Entity's property <code>columnArrayChar</code> is associated to table column <code>column_array_char</code>. This costant represents column name.
   *
   *  @see Bean84A#columnArrayChar
   */
  public static final String COLUMN_COLUMN_ARRAY_CHAR = "column_array_char";

  /**
   * Entity's property <code>columnArrayCharType</code> is associated to table column <code>column_array_char_type</code>. This costant represents column name.
   *
   *  @see Bean84A#columnArrayCharType
   */
  public static final String COLUMN_COLUMN_ARRAY_CHAR_TYPE = "column_array_char_type";

  /**
   * Entity's property <code>columnBean</code> is associated to table column <code>column_bean</code>. This costant represents column name.
   *
   *  @see Bean84A#columnBean
   */
  public static final String COLUMN_COLUMN_BEAN = "column_bean";

  /**
   * Entity's property <code>columnListString</code> is associated to table column <code>column_list_string</code>. This costant represents column name.
   *
   *  @see Bean84A#columnListString
   */
  public static final String COLUMN_COLUMN_LIST_STRING = "column_list_string";

  /**
   * Entity's property <code>columnMapIntegerString</code> is associated to table column <code>column_map_integer_string</code>. This costant represents column name.
   *
   *  @see Bean84A#columnMapIntegerString
   */
  public static final String COLUMN_COLUMN_MAP_INTEGER_STRING = "column_map_integer_string";

  /**
   * Entity's property <code>param1</code> is associated to table column <code>param1</code>. This costant represents column name.
   *
   *  @see Bean84A#param1
   */
  public static final String COLUMN_PARAM1 = "param1";

  /**
   * Entity's property <code>param2</code> is associated to table column <code>param2</code>. This costant represents column name.
   *
   *  @see Bean84A#param2
   */
  public static final String COLUMN_PARAM2 = "param2";

  /**
   * Entity's property <code>param3</code> is associated to table column <code>param3</code>. This costant represents column name.
   *
   *  @see Bean84A#param3
   */
  public static final String COLUMN_PARAM3 = "param3";

  /**
   * Entity's property <code>param4</code> is associated to table column <code>param4</code>. This costant represents column name.
   *
   *  @see Bean84A#param4
   */
  public static final String COLUMN_PARAM4 = "param4";

  /**
   * Entity's property <code>valueString</code> is associated to table column <code>value_string</code>. This costant represents column name.
   *
   *  @see Bean84A#valueString
   */
  public static final String COLUMN_VALUE_STRING = "value_string";

  /**
   * binder for type Bean84A
   */
  private static Bean84ABindMap bean84ABindMap = BinderUtils.mapperFor(Bean84A.class);

  /**
   * Columns array
   */
  private static final String[] COLUMNS = {COLUMN_ID, COLUMN_COLUMN_ARRAY_BYTE_TYPE, COLUMN_COLUMN_ARRAY_CHAR, COLUMN_COLUMN_ARRAY_CHAR_TYPE, COLUMN_COLUMN_BEAN, COLUMN_COLUMN_LIST_STRING, COLUMN_COLUMN_MAP_INTEGER_STRING, COLUMN_PARAM1, COLUMN_PARAM2, COLUMN_PARAM3, COLUMN_PARAM4, COLUMN_VALUE_STRING};

  /**
   * for attribute columnArrayByteType serialization
   */
  public static byte[] serializeColumnArrayByteType(byte[] value) {
    return value;
  }

  /**
   * for attribute columnArrayByteType parsing
   */
  public static byte[] parseColumnArrayByteType(byte[] input) {
    return input;
  }

  /**
   * for attribute columnArrayChar serialization
   */
  public static byte[] serializeColumnArrayChar(Character[] value) {
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
   * for attribute columnArrayChar parsing
   */
  public static Character[] parseColumnArrayChar(byte[] input) {
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
   * for attribute columnArrayCharType serialization
   */
  public static byte[] serializeColumnArrayCharType(char[] value) {
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
   * for attribute columnArrayCharType parsing
   */
  public static char[] parseColumnArrayCharType(byte[] input) {
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
   * for attribute columnBean serialization
   */
  public static byte[] serializeColumnBean(Bean84A value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        bean84ABindMap.serializeOnJackson(value, jacksonSerializer);
      }
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute columnBean parsing
   */
  public static Bean84A parseColumnBean(byte[] input) {
    if (input==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (JacksonWrapperParser wrapper=context.createParser(input)) {
      JsonParser jacksonParser=wrapper.jacksonParser;
      // START_OBJECT
      jacksonParser.nextToken();
      Bean84A result=null;
      if (jacksonParser.currentToken()==JsonToken.START_OBJECT) {
        result=bean84ABindMap.parseOnJackson(jacksonParser);
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute columnListString serialization
   */
  public static byte[] serializeColumnListString(List<String> value) {
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
   * for attribute columnListString parsing
   */
  public static List<String> parseColumnListString(byte[] input) {
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
      List<String> result=null;
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
        result=collection;
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute columnMapIntegerString serialization
   */
  public static byte[] serializeColumnMapIntegerString(Map<Integer, String> value) {
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
          for (Map.Entry<Integer, String> item: value.entrySet()) {
            jacksonSerializer.writeStartObject();
            jacksonSerializer.writeNumberField("key", item.getKey());
            if (item.getValue()==null) {
              jacksonSerializer.writeNullField("value");
            } else {
              jacksonSerializer.writeStringField("value", item.getValue());
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
   * for attribute columnMapIntegerString parsing
   */
  public static Map<Integer, String> parseColumnMapIntegerString(byte[] input) {
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
      Map<Integer, String> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        HashMap<Integer, String> collection=new HashMap<>();
        Integer key=null;
        String value=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          jacksonParser.nextValue();
          key=jacksonParser.getIntValue();
          jacksonParser.nextValue();
          if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
            value=jacksonParser.getText();
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
