package sqlite.kripton63;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.abubusoft.kripton.KriptonBinder;
import com.abubusoft.kripton.KriptonJsonContext;
import com.abubusoft.kripton.android.KriptonLibrary;
import com.abubusoft.kripton.android.sharedprefs.AbstractSharedPreference;
import com.abubusoft.kripton.common.KriptonByteArrayOutputStream;
import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.exception.KriptonRuntimeException;
import com.abubusoft.kripton.persistence.JacksonWrapperParser;
import com.abubusoft.kripton.persistence.JacksonWrapperSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is the shared preference binder defined for Bean63
 *
 * @see Bean63
 */
public class BindBean63SharedPreferences extends AbstractSharedPreference {
  /**
   * instance of shared preferences
   */
  private static BindBean63SharedPreferences instance;

  /**
   * working instance of bean
   */
  private final Bean63 defaultBean;

  /**
   * subject for field id - shared pref id
   */
  private Subject<Long> idSubject = BehaviorSubject.create();

  /**
   * subject for field value - shared pref value
   */
  private Subject<String> valueSubject = BehaviorSubject.create();

  /**
   * subject for field valueMapStringByte - shared pref value_map_string_byte
   */
  private Subject<Map<String, Byte>> valueMapStringByteSubject = BehaviorSubject.create();

  /**
   * subject for field valueMapEnumByte - shared pref value_map_enum_byte
   */
  private Subject<HashMap<EnumType, Byte>> valueMapEnumByteSubject = BehaviorSubject.create();

  /**
   * List of tables compose datasource
   */
  private SharedPreferences.OnSharedPreferenceChangeListener prefsListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
      switch (key) {
        // id - id
        case "id": {
        long _value=sharedPreferences.getLong("id", defaultBean.id);
        idSubject.onNext(_value); return;
        }
        // value - value
        case "value": {
        String _value=sharedPreferences.getString("value", defaultBean.value);
        valueSubject.onNext(_value); return;
        }
        // value_map_string_byte - valueMapStringByte
        case "value_map_string_byte": {
        String temp=sharedPreferences.getString("value_map_string_byte", null);
        Map<String, Byte> _value=StringUtils.hasText(temp) ? parseValueMapStringByte(temp): defaultBean.valueMapStringByte;

        valueMapStringByteSubject.onNext(_value); return;
        }
        // value_map_enum_byte - valueMapEnumByte
        case "value_map_enum_byte": {
        String temp=sharedPreferences.getString("value_map_enum_byte", null);
        HashMap<EnumType, Byte> _value=StringUtils.hasText(temp) ? parseValueMapEnumByte(temp): defaultBean.valueMapEnumByte;

        valueMapEnumByteSubject.onNext(_value); return;
        }
        default: return;
      }
    }
  };

  /**
   * constructor
   */
  private BindBean63SharedPreferences() {
    createPrefs();
    defaultBean=new Bean63();
  }

  /**
   * create an editor to modify shared preferences
   */
  public BindEditor edit() {
    return new BindEditor();
  }

  /**
   * create prefs
   */
  private void createPrefs() {
    // no typeName specified, using default shared preferences
    prefs=PreferenceManager.getDefaultSharedPreferences(KriptonLibrary.getContext());
    prefs.registerOnSharedPreferenceChangeListener(prefsListener);
  }

  /**
   * force to refresh values
   */
  public BindBean63SharedPreferences refresh() {
    createPrefs();
    return this;
  }

  /**
   * Obtains an observable to <code>id</code> property
   *
   * @return
   * an observable to <code>id</code> property
   */
  public Subject<Long> getIdAsObservable() {
    return idSubject;
  }

  /**
   * Obtains an observable to <code>value</code> property
   *
   * @return
   * an observable to <code>value</code> property
   */
  public Subject<String> getValueAsObservable() {
    return valueSubject;
  }

  /**
   * Obtains an observable to <code>valueMapStringByte</code> property
   *
   * @return
   * an observable to <code>valueMapStringByte</code> property
   */
  public Subject<Map<String, Byte>> getValueMapStringByteAsObservable() {
    return valueMapStringByteSubject;
  }

  /**
   * Obtains an observable to <code>valueMapEnumByte</code> property
   *
   * @return
   * an observable to <code>valueMapEnumByte</code> property
   */
  public Subject<HashMap<EnumType, Byte>> getValueMapEnumByteAsObservable() {
    return valueMapEnumByteSubject;
  }

  /**
   * reset shared preferences
   */
  public void reset() {
    Bean63 bean=new Bean63();
    write(bean);
  }

  /**
   * read bean entirely
   *
   * @return read bean
   */
  public Bean63 read() {
    Bean63 bean=new Bean63();
    bean.id=prefs.getLong("id", bean.id);
    bean.value=prefs.getString("value", bean.value);
     {
      String temp=prefs.getString("value_map_string_byte", null);
      bean.valueMapStringByte=StringUtils.hasText(temp) ? parseValueMapStringByte(temp): defaultBean.valueMapStringByte;
    }

     {
      String temp=prefs.getString("value_map_enum_byte", null);
      bean.valueMapEnumByte=StringUtils.hasText(temp) ? parseValueMapEnumByte(temp): defaultBean.valueMapEnumByte;
    }


    return bean;
  }

  /**
   * write bean entirely
   *
   * @param bean bean to entirely write
   */
  public void write(Bean63 bean) {
    SharedPreferences.Editor editor=prefs.edit();
    editor.putLong("id",bean.id);

    editor.putString("value",bean.value);

    if (bean.valueMapStringByte!=null)  {
      String temp=serializeValueMapStringByte(bean.valueMapStringByte);
      editor.putString("value_map_string_byte",temp);
    }  else  {
      editor.remove("value_map_string_byte");
    }

    if (bean.valueMapEnumByte!=null)  {
      String temp=serializeValueMapEnumByte(bean.valueMapEnumByte);
      editor.putString("value_map_enum_byte",temp);
    }  else  {
      editor.remove("value_map_enum_byte");
    }


    editor.commit();
  }

  /**
   * read property id
   *
   * @return property id value
   */
  public long getId() {
    return prefs.getLong("id", defaultBean.id);}

  /**
   * read property value
   *
   * @return property value value
   */
  public String getValue() {
    return prefs.getString("value", defaultBean.value);}

  /**
   * read property valueMapStringByte
   *
   * @return property valueMapStringByte value
   */
  public Map<String, Byte> getValueMapStringByte() {
    String temp=prefs.getString("value_map_string_byte", null);
    return StringUtils.hasText(temp) ? parseValueMapStringByte(temp): defaultBean.valueMapStringByte;
  }

  /**
   * read property valueMapEnumByte
   *
   * @return property valueMapEnumByte value
   */
  public HashMap<EnumType, Byte> getValueMapEnumByte() {
    String temp=prefs.getString("value_map_enum_byte", null);
    return StringUtils.hasText(temp) ? parseValueMapEnumByte(temp): defaultBean.valueMapEnumByte;
  }

  /**
   * for attribute valueMapStringByte serialization
   */
  protected String serializeValueMapStringByte(Map<String, Byte> value) {
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
          jacksonSerializer.writeFieldName("valueMapStringByte");
          jacksonSerializer.writeStartArray();
          for (Map.Entry<String, Byte> item: value.entrySet()) {
            jacksonSerializer.writeStartObject();
            jacksonSerializer.writeStringField("key", item.getKey());
            if (item.getValue()==null) {
              jacksonSerializer.writeNullField("value");
            } else {
              jacksonSerializer.writeNumberField("value", item.getValue());
            }
            jacksonSerializer.writeEndObject();
          }
          jacksonSerializer.writeEndArray();
        } else {
          jacksonSerializer.writeNullField("valueMapStringByte");
        }
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toString();
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueMapStringByte parsing
   */
  protected Map<String, Byte> parseValueMapStringByte(String input) {
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
      Map<String, Byte> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        HashMap<String, Byte> collection=new HashMap<>();
        String key=null;
        Byte value=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          jacksonParser.nextValue();
          key=jacksonParser.getText();
          jacksonParser.nextValue();
          if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
            value=jacksonParser.getByteValue();
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
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueMapEnumByte serialization
   */
  protected String serializeValueMapEnumByte(HashMap<EnumType, Byte> value) {
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
          jacksonSerializer.writeFieldName("valueMapEnumByte");
          jacksonSerializer.writeStartArray();
          for (Map.Entry<EnumType, Byte> item: value.entrySet()) {
            jacksonSerializer.writeStartObject();
            jacksonSerializer.writeStringField("key", item.getKey().toString());
            if (item.getValue()==null) {
              jacksonSerializer.writeNullField("value");
            } else {
              jacksonSerializer.writeNumberField("value", item.getValue());
            }
            jacksonSerializer.writeEndObject();
          }
          jacksonSerializer.writeEndArray();
        } else {
          jacksonSerializer.writeNullField("valueMapEnumByte");
        }
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toString();
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueMapEnumByte parsing
   */
  protected HashMap<EnumType, Byte> parseValueMapEnumByte(String input) {
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
      HashMap<EnumType, Byte> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        HashMap<EnumType, Byte> collection=new HashMap<>();
        EnumType key=null;
        Byte value=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          jacksonParser.nextValue();
           {
            String tempEnum=jacksonParser.getText();
            key=StringUtils.hasText(tempEnum)?EnumType.valueOf(tempEnum):null;
          }
          jacksonParser.nextValue();
          if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
            value=jacksonParser.getByteValue();
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
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * get instance of shared preferences
   */
  public static synchronized BindBean63SharedPreferences instance() {
    if (instance==null) {
      instance=new BindBean63SharedPreferences();
    }
    return instance;
  }

  /**
   * editor class for shared preferences
   */
  public class BindEditor extends AbstractEditor {
    private BindEditor() {
    }

    /**
     * modifier for property id
     */
    public BindEditor putId(long value) {
      editor.putLong("id",value);

      return this;
    }

    /**
     * modifier for property value
     */
    public BindEditor putValue(String value) {
      editor.putString("value",value);

      return this;
    }

    /**
     * modifier for property valueMapStringByte
     */
    public BindEditor putValueMapStringByte(Map<String, Byte> value) {
      if (value!=null)  {
        String temp=serializeValueMapStringByte(value);
        editor.putString("value_map_string_byte",temp);
      }  else  {
        editor.remove("value_map_string_byte");
      }

      return this;
    }

    /**
     * modifier for property valueMapEnumByte
     */
    public BindEditor putValueMapEnumByte(HashMap<EnumType, Byte> value) {
      if (value!=null)  {
        String temp=serializeValueMapEnumByte(value);
        editor.putString("value_map_enum_byte",temp);
      }  else  {
        editor.remove("value_map_enum_byte");
      }

      return this;
    }
  }
}
