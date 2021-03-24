package sqlite.kripton60;

import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.abubusoft.kripton.BinderUtils;
import com.abubusoft.kripton.KriptonBinder;
import com.abubusoft.kripton.KriptonJsonContext;
import com.abubusoft.kripton.android.KriptonLibrary;
import com.abubusoft.kripton.android.sharedprefs.AbstractSharedPreference;
import com.abubusoft.kripton.common.CalendarUtils;
import com.abubusoft.kripton.common.CollectionUtils;
import com.abubusoft.kripton.common.CurrencyUtils;
import com.abubusoft.kripton.common.DateUtils;
import com.abubusoft.kripton.common.KriptonByteArrayOutputStream;
import com.abubusoft.kripton.common.LocaleUtils;
import com.abubusoft.kripton.common.SQLTimeUtils;
import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.common.TimeZoneUtils;
import com.abubusoft.kripton.common.UrlUtils;
import com.abubusoft.kripton.exception.KriptonRuntimeException;
import com.abubusoft.kripton.persistence.JacksonWrapperParser;
import com.abubusoft.kripton.persistence.JacksonWrapperSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * This class is the shared preference binder defined for Bean2
 *
 * @see Bean2
 */
public class BindBean2SharedPreferences extends AbstractSharedPreference {
  /**
   * binder for type Bean2
   */
  private static Bean2BindMap bean2BindMap = BinderUtils.mapperFor(Bean2.class);

  /**
   * instance of shared preferences
   */
  private static BindBean2SharedPreferences instance;

  /**
   * working instance of bean
   */
  private final Bean2 defaultBean;

  /**
   * constructor
   */
  private BindBean2SharedPreferences() {
    createPrefs();
    defaultBean=new Bean2();
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
  }

  /**
   * force to refresh values
   */
  public BindBean2SharedPreferences refresh() {
    createPrefs();
    return this;
  }

  /**
   * reset shared preferences
   */
  public void reset() {
    Bean2 bean=new Bean2();
    write(bean);
  }

  /**
   * read bean entirely
   *
   * @return read bean
   */
  public Bean2 read() {
    Bean2 bean=new Bean2();
     {
      String temp=prefs.getString("value_enum_type", null);
      bean.setValueEnumType((StringUtils.hasText(temp)) ? EnumType.valueOf(temp): defaultBean.getValueEnumType());
    }

     {
      String temp=prefs.getString("value_time", null);
      bean.setValueTime((StringUtils.hasText(temp)) ? SQLTimeUtils.read(temp): defaultBean.getValueTime());}

     {
      String temp=prefs.getString("value_currency", null);
      bean.setValueCurrency((StringUtils.hasText(temp)) ? CurrencyUtils.read(temp): defaultBean.getValueCurrency());}

    bean.setValueShortType((short)prefs.getInt("value_short_type", (short)defaultBean.getValueShortType()));
     {
      String temp=prefs.getString("value_big_integer", "0");
      bean.setValueBigInteger((StringUtils.hasText(temp)) ? new BigInteger(temp): defaultBean.getValueBigInteger());
    }

    bean.setValueInt((int)prefs.getInt("value_int", (int)(defaultBean.getValueInt()==null?0:defaultBean.getValueInt())));
     {
      String temp=prefs.getString("value_strin_list", null);
      bean.setValueStrinList(StringUtils.hasText(temp) ? parseValueStrinList(temp): defaultBean.getValueStrinList());
    }

     {
      String temp=prefs.getString("value_url", null);
      bean.setValueUrl((StringUtils.hasText(temp)) ? UrlUtils.read(temp): defaultBean.getValueUrl());}

    bean.setValueByte((byte)prefs.getInt("value_byte", (byte)(defaultBean.getValueByte()==null?(byte)0:defaultBean.getValueByte())));
     {
      String temp=prefs.getString("value_char_list", null);
      bean.setValueCharList(StringUtils.hasText(temp) ? parseValueCharList(temp): defaultBean.getValueCharList());
    }

    bean.setValueFloat(prefs.getFloat("value_float", (defaultBean.getValueFloat()==null?0F:defaultBean.getValueFloat())));
    bean.setValueIntType((int)prefs.getInt("value_int_type", (int)defaultBean.getValueIntType()));
    bean.setValueLongType(prefs.getLong("value_long_type", defaultBean.getValueLongType()));
     {
      String temp=prefs.getString("value_bean", null);
      bean.setValueBean(StringUtils.hasText(temp) ? parseValueBean(temp): defaultBean.getValueBean());
    }

    bean.setValueLong(prefs.getLong("value_long", (defaultBean.getValueLong()==null?0L:defaultBean.getValueLong())));
    bean.setValueShort((short)prefs.getInt("value_short", (short)(defaultBean.getValueShort()==null?(short)0:defaultBean.getValueShort())));
     {
      String temp=prefs.getString("value_long_type_array", null);
      bean.setValueLongTypeArray(StringUtils.hasText(temp) ? parseValueLongTypeArray(temp): defaultBean.getValueLongTypeArray());
    }

     {
      String temp=prefs.getString("value_time_list", null);
      bean.setValueTimeList(StringUtils.hasText(temp) ? parseValueTimeList(temp): defaultBean.getValueTimeList());
    }

     {
      String temp=prefs.getString("value_byte_array", null);
      bean.setValueByteArray(StringUtils.hasText(temp) ? parseValueByteArray(temp): defaultBean.getValueByteArray());
    }

     {
      String temp=prefs.getString("value_double", null);
      bean.setValueDouble((StringUtils.hasText(temp)) ? Double.valueOf(temp): defaultBean.getValueDouble());
    }

    bean.setId(prefs.getLong("id", defaultBean.getId()));
     {
      String temp=prefs.getString("value_bean_array", null);
      bean.setValueBeanArray(StringUtils.hasText(temp) ? parseValueBeanArray(temp): defaultBean.getValueBeanArray());
    }

     {
      String temp=prefs.getString("value_big_decimal", "0");
      bean.setValueBigDecimal((StringUtils.hasText(temp)) ? new BigDecimal(temp): defaultBean.getValueBigDecimal());
    }

     {
      String temp=prefs.getString("value_time_zone", null);
      bean.setValueTimeZone((StringUtils.hasText(temp)) ? TimeZoneUtils.read(temp): defaultBean.getValueTimeZone());}

     {
      String temp=prefs.getString("value_char_type_array", null);
      bean.setValueCharTypeArray(StringUtils.hasText(temp) ? parseValueCharTypeArray(temp): defaultBean.getValueCharTypeArray());
    }

     {
      String temp=prefs.getString("value_double_type", null);
      bean.setValueDoubleType((StringUtils.hasText(temp)) ? Double.valueOf(temp): defaultBean.getValueDoubleType());
    }

    bean.setValueCharType((char)prefs.getInt("value_char_type", (char)defaultBean.getValueCharType()));
     {
      String temp=prefs.getString("value_date", null);
      bean.setValueDate((StringUtils.hasText(temp)) ? DateUtils.read(temp): defaultBean.getValueDate());}

    bean.setValueFloatType(prefs.getFloat("value_float_type", defaultBean.getValueFloatType()));
    bean.setValueBool((boolean)prefs.getBoolean("value_bool", (boolean)(defaultBean.getValueBool()==null?false:defaultBean.getValueBool())));
    bean.setValueBoolType((boolean)prefs.getBoolean("value_bool_type", (boolean)defaultBean.isValueBoolType()));
     {
      String temp=prefs.getString("value_char_array", null);
      bean.setValueCharArray(StringUtils.hasText(temp) ? parseValueCharArray(temp): defaultBean.getValueCharArray());
    }

    bean.setValueChar((char)prefs.getInt("value_char", (char)(defaultBean.getValueChar()==null?(char)0:defaultBean.getValueChar())));
     {
      String temp=prefs.getString("value_long_array", null);
      bean.setValueLongArray(StringUtils.hasText(temp) ? parseValueLongArray(temp): defaultBean.getValueLongArray());
    }

     {
      String temp=prefs.getString("value_string_array", null);
      bean.setValueStringArray(StringUtils.hasText(temp) ? parseValueStringArray(temp): defaultBean.getValueStringArray());
    }

    bean.setValueString(prefs.getString("value_string", defaultBean.getValueString()));
     {
      String temp=prefs.getString("value_calendar", null);
      bean.setValueCalendar((StringUtils.hasText(temp)) ? CalendarUtils.read(temp): defaultBean.getValueCalendar());}

     {
      String temp=prefs.getString("value_long_list", null);
      bean.setValueLongList(StringUtils.hasText(temp) ? parseValueLongList(temp): defaultBean.getValueLongList());
    }

    bean.setValueByteType((byte)prefs.getInt("value_byte_type", (byte)defaultBean.getValueByteType()));
     {
      String temp=prefs.getString("value_locale", null);
      bean.setValueLocale((StringUtils.hasText(temp)) ? LocaleUtils.read(temp): defaultBean.getValueLocale());}


    return bean;
  }

  /**
   * write bean entirely
   *
   * @param bean bean to entirely write
   */
  public void write(Bean2 bean) {
    SharedPreferences.Editor editor=prefs.edit();
    if (bean.getValueEnumType()!=null)  {
      editor.putString("value_enum_type",bean.getValueEnumType().toString() );
    } else {
      editor.remove("valueEnumType");
    }

    if (bean.getValueTime()!=null)  {
      editor.putString("value_time",SQLTimeUtils.write(bean.getValueTime()));
    } else {
      editor.remove("valueTime");
    }

    if (bean.getValueCurrency()!=null)  {
      editor.putString("value_currency",CurrencyUtils.write(bean.getValueCurrency()));
    } else {
      editor.remove("valueCurrency");
    }

    editor.putInt("value_short_type",(int)bean.getValueShortType());

    if (bean.getValueBigInteger()!=null) editor.putString("value_big_integer",bean.getValueBigInteger().toString() ); else editor.putString("value_big_integer", null);
    if (bean.getValueInt()!=null)  {
      editor.putInt("value_int",(int)bean.getValueInt());
    }

    if (bean.getValueStrinList()!=null)  {
      String temp=serializeValueStrinList(bean.getValueStrinList());
      editor.putString("value_strin_list",temp);
    }  else  {
      editor.remove("value_strin_list");
    }

    if (bean.getValueUrl()!=null)  {
      editor.putString("value_url",UrlUtils.write(bean.getValueUrl()));
    } else {
      editor.remove("valueUrl");
    }

    if (bean.getValueByte()!=null)  {
      editor.putInt("value_byte",(int)bean.getValueByte());
    }

    if (bean.getValueCharList()!=null)  {
      String temp=serializeValueCharList(bean.getValueCharList());
      editor.putString("value_char_list",temp);
    }  else  {
      editor.remove("value_char_list");
    }

    if (bean.getValueFloat()!=null)  {
      editor.putFloat("value_float",bean.getValueFloat());
    }

    editor.putInt("value_int_type",(int)bean.getValueIntType());

    editor.putLong("value_long_type",bean.getValueLongType());

    if (bean.getValueBean()!=null)  {
      String temp=serializeValueBean(bean.getValueBean());
      editor.putString("value_bean",temp);
    }  else  {
      editor.remove("value_bean");
    }

    if (bean.getValueLong()!=null)  {
      editor.putLong("value_long",bean.getValueLong());
    }

    if (bean.getValueShort()!=null)  {
      editor.putInt("value_short",(int)bean.getValueShort());
    }

    if (bean.getValueLongTypeArray()!=null)  {
      String temp=serializeValueLongTypeArray(bean.getValueLongTypeArray());
      editor.putString("value_long_type_array",temp);
    }  else  {
      editor.remove("value_long_type_array");
    }

    if (bean.getValueTimeList()!=null)  {
      String temp=serializeValueTimeList(bean.getValueTimeList());
      editor.putString("value_time_list",temp);
    }  else  {
      editor.remove("value_time_list");
    }

    if (bean.getValueByteArray()!=null)  {
      String temp=serializeValueByteArray(bean.getValueByteArray());
      editor.putString("value_byte_array",temp);
    }  else  {
      editor.remove("value_byte_array");
    }

    if (bean.getValueDouble()!=null)  {
      editor.putString("value_double",String.valueOf(bean.getValueDouble()));
    } else {
      editor.remove("valueDouble");
    }

    editor.putLong("id",bean.getId());

    if (bean.getValueBeanArray()!=null)  {
      String temp=serializeValueBeanArray(bean.getValueBeanArray());
      editor.putString("value_bean_array",temp);
    }  else  {
      editor.remove("value_bean_array");
    }

    if (bean.getValueBigDecimal()!=null) editor.putString("value_big_decimal",bean.getValueBigDecimal().toPlainString() ); else editor.putString("value_big_decimal", null);
    if (bean.getValueTimeZone()!=null)  {
      editor.putString("value_time_zone",TimeZoneUtils.write(bean.getValueTimeZone()));
    } else {
      editor.remove("valueTimeZone");
    }

    if (bean.getValueCharTypeArray()!=null)  {
      String temp=serializeValueCharTypeArray(bean.getValueCharTypeArray());
      editor.putString("value_char_type_array",temp);
    }  else  {
      editor.remove("value_char_type_array");
    }

    editor.putString("value_double_type",String.valueOf(bean.getValueDoubleType()));

    editor.putInt("value_char_type",(char)bean.getValueCharType());

    if (bean.getValueDate()!=null)  {
      editor.putString("value_date",DateUtils.write(bean.getValueDate()));
    } else {
      editor.remove("valueDate");
    }

    editor.putFloat("value_float_type",bean.getValueFloatType());

    if (bean.getValueBool()!=null)  {
      editor.putBoolean("value_bool",(boolean)bean.getValueBool());
    }

    editor.putBoolean("value_bool_type",(boolean)bean.isValueBoolType());

    if (bean.getValueCharArray()!=null)  {
      String temp=serializeValueCharArray(bean.getValueCharArray());
      editor.putString("value_char_array",temp);
    }  else  {
      editor.remove("value_char_array");
    }

    if (bean.getValueChar()!=null)  {
      editor.putInt("value_char",(char)bean.getValueChar());
    }

    if (bean.getValueLongArray()!=null)  {
      String temp=serializeValueLongArray(bean.getValueLongArray());
      editor.putString("value_long_array",temp);
    }  else  {
      editor.remove("value_long_array");
    }

    if (bean.getValueStringArray()!=null)  {
      String temp=serializeValueStringArray(bean.getValueStringArray());
      editor.putString("value_string_array",temp);
    }  else  {
      editor.remove("value_string_array");
    }

    editor.putString("value_string",bean.getValueString());

    if (bean.getValueCalendar()!=null)  {
      editor.putString("value_calendar",CalendarUtils.write(bean.getValueCalendar()));
    } else {
      editor.remove("valueCalendar");
    }

    if (bean.getValueLongList()!=null)  {
      String temp=serializeValueLongList(bean.getValueLongList());
      editor.putString("value_long_list",temp);
    }  else  {
      editor.remove("value_long_list");
    }

    editor.putInt("value_byte_type",(int)bean.getValueByteType());

    if (bean.getValueLocale()!=null)  {
      editor.putString("value_locale",LocaleUtils.write(bean.getValueLocale()));
    } else {
      editor.remove("valueLocale");
    }


    editor.commit();
  }

  /**
   * reads property <code>valueEnumType</code> from shared pref with key <code>value_enum_type</code>
   *
   * @return property valueEnumType value
   */
  public EnumType getValueEnumType() {
    String temp=prefs.getString("value_enum_type", null);
    return (StringUtils.hasText(temp)) ? EnumType.valueOf(temp): defaultBean.getValueEnumType();
  }

  /**
   * reads property <code>valueTime</code> from shared pref with key <code>value_time</code>
   *
   * @return property valueTime value
   */
  public Time getValueTime() {
    String temp=prefs.getString("value_time", null);
    return (StringUtils.hasText(temp)) ? SQLTimeUtils.read(temp): defaultBean.getValueTime();}

  /**
   * reads property <code>valueCurrency</code> from shared pref with key <code>value_currency</code>
   *
   * @return property valueCurrency value
   */
  public Currency getValueCurrency() {
    String temp=prefs.getString("value_currency", null);
    return (StringUtils.hasText(temp)) ? CurrencyUtils.read(temp): defaultBean.getValueCurrency();}

  /**
   * reads property <code>valueShortType</code> from shared pref with key <code>value_short_type</code>
   *
   * @return property valueShortType value
   */
  public short getValueShortType() {
    return (short)prefs.getInt("value_short_type", (short)defaultBean.getValueShortType());}

  /**
   * reads property <code>valueBigInteger</code> from shared pref with key <code>value_big_integer</code>
   *
   * @return property valueBigInteger value
   */
  public BigInteger getValueBigInteger() {
    String temp=prefs.getString("value_big_integer", "0");
    return (StringUtils.hasText(temp)) ? new BigInteger(temp): defaultBean.getValueBigInteger();
  }

  /**
   * reads property <code>valueInt</code> from shared pref with key <code>value_int</code>
   *
   * @return property valueInt value
   */
  public Integer getValueInt() {
    return (int)prefs.getInt("value_int", (int)(defaultBean.getValueInt()==null?0:defaultBean.getValueInt()));}

  /**
   * reads property <code>valueStrinList</code> from shared pref with key <code>value_strin_list</code>
   *
   * @return property valueStrinList value
   */
  public LinkedList<String> getValueStrinList() {
    String temp=prefs.getString("value_strin_list", null);
    return StringUtils.hasText(temp) ? parseValueStrinList(temp): defaultBean.getValueStrinList();
  }

  /**
   * reads property <code>valueUrl</code> from shared pref with key <code>value_url</code>
   *
   * @return property valueUrl value
   */
  public URL getValueUrl() {
    String temp=prefs.getString("value_url", null);
    return (StringUtils.hasText(temp)) ? UrlUtils.read(temp): defaultBean.getValueUrl();}

  /**
   * reads property <code>valueByte</code> from shared pref with key <code>value_byte</code>
   *
   * @return property valueByte value
   */
  public Byte getValueByte() {
    return (byte)prefs.getInt("value_byte", (byte)(defaultBean.getValueByte()==null?(byte)0:defaultBean.getValueByte()));}

  /**
   * reads property <code>valueCharList</code> from shared pref with key <code>value_char_list</code>
   *
   * @return property valueCharList value
   */
  public LinkedList<Character> getValueCharList() {
    String temp=prefs.getString("value_char_list", null);
    return StringUtils.hasText(temp) ? parseValueCharList(temp): defaultBean.getValueCharList();
  }

  /**
   * reads property <code>valueFloat</code> from shared pref with key <code>value_float</code>
   *
   * @return property valueFloat value
   */
  public Float getValueFloat() {
    return prefs.getFloat("value_float", (defaultBean.getValueFloat()==null?0F:defaultBean.getValueFloat()));}

  /**
   * reads property <code>valueIntType</code> from shared pref with key <code>value_int_type</code>
   *
   * @return property valueIntType value
   */
  public int getValueIntType() {
    return (int)prefs.getInt("value_int_type", (int)defaultBean.getValueIntType());}

  /**
   * reads property <code>valueLongType</code> from shared pref with key <code>value_long_type</code>
   *
   * @return property valueLongType value
   */
  public long getValueLongType() {
    return prefs.getLong("value_long_type", defaultBean.getValueLongType());}

  /**
   * reads property <code>valueBean</code> from shared pref with key <code>value_bean</code>
   *
   * @return property valueBean value
   */
  public Bean2 getValueBean() {
    String temp=prefs.getString("value_bean", null);
    return StringUtils.hasText(temp) ? parseValueBean(temp): defaultBean.getValueBean();
  }

  /**
   * reads property <code>valueLong</code> from shared pref with key <code>value_long</code>
   *
   * @return property valueLong value
   */
  public Long getValueLong() {
    return prefs.getLong("value_long", (defaultBean.getValueLong()==null?0L:defaultBean.getValueLong()));}

  /**
   * reads property <code>valueShort</code> from shared pref with key <code>value_short</code>
   *
   * @return property valueShort value
   */
  public Short getValueShort() {
    return (short)prefs.getInt("value_short", (short)(defaultBean.getValueShort()==null?(short)0:defaultBean.getValueShort()));}

  /**
   * reads property <code>valueLongTypeArray</code> from shared pref with key <code>value_long_type_array</code>
   *
   * @return property valueLongTypeArray value
   */
  public long[] getValueLongTypeArray() {
    String temp=prefs.getString("value_long_type_array", null);
    return StringUtils.hasText(temp) ? parseValueLongTypeArray(temp): defaultBean.getValueLongTypeArray();
  }

  /**
   * reads property <code>valueTimeList</code> from shared pref with key <code>value_time_list</code>
   *
   * @return property valueTimeList value
   */
  public List<Time> getValueTimeList() {
    String temp=prefs.getString("value_time_list", null);
    return StringUtils.hasText(temp) ? parseValueTimeList(temp): defaultBean.getValueTimeList();
  }

  /**
   * reads property <code>valueByteArray</code> from shared pref with key <code>value_byte_array</code>
   *
   * @return property valueByteArray value
   */
  public byte[] getValueByteArray() {
    String temp=prefs.getString("value_byte_array", null);
    return StringUtils.hasText(temp) ? parseValueByteArray(temp): defaultBean.getValueByteArray();
  }

  /**
   * reads property <code>valueDouble</code> from shared pref with key <code>value_double</code>
   *
   * @return property valueDouble value
   */
  public Double getValueDouble() {
    String temp=prefs.getString("value_double", null);
    return (StringUtils.hasText(temp)) ? Double.valueOf(temp): defaultBean.getValueDouble();
  }

  /**
   * reads property <code>id</code> from shared pref with key <code>id</code>
   *
   * @return property id value
   */
  public long getId() {
    return prefs.getLong("id", defaultBean.getId());}

  /**
   * reads property <code>valueBeanArray</code> from shared pref with key <code>value_bean_array</code>
   *
   * @return property valueBeanArray value
   */
  public Bean2[] getValueBeanArray() {
    String temp=prefs.getString("value_bean_array", null);
    return StringUtils.hasText(temp) ? parseValueBeanArray(temp): defaultBean.getValueBeanArray();
  }

  /**
   * reads property <code>valueBigDecimal</code> from shared pref with key <code>value_big_decimal</code>
   *
   * @return property valueBigDecimal value
   */
  public BigDecimal getValueBigDecimal() {
    String temp=prefs.getString("value_big_decimal", "0");
    return (StringUtils.hasText(temp)) ? new BigDecimal(temp): defaultBean.getValueBigDecimal();
  }

  /**
   * reads property <code>valueTimeZone</code> from shared pref with key <code>value_time_zone</code>
   *
   * @return property valueTimeZone value
   */
  public TimeZone getValueTimeZone() {
    String temp=prefs.getString("value_time_zone", null);
    return (StringUtils.hasText(temp)) ? TimeZoneUtils.read(temp): defaultBean.getValueTimeZone();}

  /**
   * reads property <code>valueCharTypeArray</code> from shared pref with key <code>value_char_type_array</code>
   *
   * @return property valueCharTypeArray value
   */
  public char[] getValueCharTypeArray() {
    String temp=prefs.getString("value_char_type_array", null);
    return StringUtils.hasText(temp) ? parseValueCharTypeArray(temp): defaultBean.getValueCharTypeArray();
  }

  /**
   * reads property <code>valueDoubleType</code> from shared pref with key <code>value_double_type</code>
   *
   * @return property valueDoubleType value
   */
  public double getValueDoubleType() {
    String temp=prefs.getString("value_double_type", null);
    return (StringUtils.hasText(temp)) ? Double.valueOf(temp): defaultBean.getValueDoubleType();
  }

  /**
   * reads property <code>valueCharType</code> from shared pref with key <code>value_char_type</code>
   *
   * @return property valueCharType value
   */
  public char getValueCharType() {
    return (char)prefs.getInt("value_char_type", (char)defaultBean.getValueCharType());}

  /**
   * reads property <code>valueDate</code> from shared pref with key <code>value_date</code>
   *
   * @return property valueDate value
   */
  public Date getValueDate() {
    String temp=prefs.getString("value_date", null);
    return (StringUtils.hasText(temp)) ? DateUtils.read(temp): defaultBean.getValueDate();}

  /**
   * reads property <code>valueFloatType</code> from shared pref with key <code>value_float_type</code>
   *
   * @return property valueFloatType value
   */
  public float getValueFloatType() {
    return prefs.getFloat("value_float_type", defaultBean.getValueFloatType());}

  /**
   * reads property <code>valueBool</code> from shared pref with key <code>value_bool</code>
   *
   * @return property valueBool value
   */
  public Boolean getValueBool() {
    return (boolean)prefs.getBoolean("value_bool", (boolean)(defaultBean.getValueBool()==null?false:defaultBean.getValueBool()));}

  /**
   * reads property <code>valueBoolType</code> from shared pref with key <code>value_bool_type</code>
   *
   * @return property valueBoolType value
   */
  public boolean getValueBoolType() {
    return (boolean)prefs.getBoolean("value_bool_type", (boolean)defaultBean.isValueBoolType());}

  /**
   * reads property <code>valueCharArray</code> from shared pref with key <code>value_char_array</code>
   *
   * @return property valueCharArray value
   */
  public Character[] getValueCharArray() {
    String temp=prefs.getString("value_char_array", null);
    return StringUtils.hasText(temp) ? parseValueCharArray(temp): defaultBean.getValueCharArray();
  }

  /**
   * reads property <code>valueChar</code> from shared pref with key <code>value_char</code>
   *
   * @return property valueChar value
   */
  public Character getValueChar() {
    return (char)prefs.getInt("value_char", (char)(defaultBean.getValueChar()==null?(char)0:defaultBean.getValueChar()));}

  /**
   * reads property <code>valueLongArray</code> from shared pref with key <code>value_long_array</code>
   *
   * @return property valueLongArray value
   */
  public Long[] getValueLongArray() {
    String temp=prefs.getString("value_long_array", null);
    return StringUtils.hasText(temp) ? parseValueLongArray(temp): defaultBean.getValueLongArray();
  }

  /**
   * reads property <code>valueStringArray</code> from shared pref with key <code>value_string_array</code>
   *
   * @return property valueStringArray value
   */
  public String[] getValueStringArray() {
    String temp=prefs.getString("value_string_array", null);
    return StringUtils.hasText(temp) ? parseValueStringArray(temp): defaultBean.getValueStringArray();
  }

  /**
   * reads property <code>valueString</code> from shared pref with key <code>value_string</code>
   *
   * @return property valueString value
   */
  public String getValueString() {
    return prefs.getString("value_string", defaultBean.getValueString());}

  /**
   * reads property <code>valueCalendar</code> from shared pref with key <code>value_calendar</code>
   *
   * @return property valueCalendar value
   */
  public Calendar getValueCalendar() {
    String temp=prefs.getString("value_calendar", null);
    return (StringUtils.hasText(temp)) ? CalendarUtils.read(temp): defaultBean.getValueCalendar();}

  /**
   * reads property <code>valueLongList</code> from shared pref with key <code>value_long_list</code>
   *
   * @return property valueLongList value
   */
  public LinkedList<Long> getValueLongList() {
    String temp=prefs.getString("value_long_list", null);
    return StringUtils.hasText(temp) ? parseValueLongList(temp): defaultBean.getValueLongList();
  }

  /**
   * reads property <code>valueByteType</code> from shared pref with key <code>value_byte_type</code>
   *
   * @return property valueByteType value
   */
  public byte getValueByteType() {
    return (byte)prefs.getInt("value_byte_type", (byte)defaultBean.getValueByteType());}

  /**
   * reads property <code>valueLocale</code> from shared pref with key <code>value_locale</code>
   *
   * @return property valueLocale value
   */
  public Locale getValueLocale() {
    String temp=prefs.getString("value_locale", null);
    return (StringUtils.hasText(temp)) ? LocaleUtils.read(temp): defaultBean.getValueLocale();}

  /**
   * for attribute valueStrinList serialization
   */
  protected String serializeValueStrinList(LinkedList<String> value) {
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
        jacksonSerializer.writeFieldName("valueStrinList");
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
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueStrinList parsing
   */
  protected LinkedList<String> parseValueStrinList(String input) {
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
   * for attribute valueCharList serialization
   */
  protected String serializeValueCharList(LinkedList<Character> value) {
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
        jacksonSerializer.writeFieldName("valueCharList");
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
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueCharList parsing
   */
  protected LinkedList<Character> parseValueCharList(String input) {
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
   * for attribute valueBean serialization
   */
  protected String serializeValueBean(Bean2 value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      if (value!=null)  {
        fieldCount++;
        bean2BindMap.serializeOnJackson(value, jacksonSerializer);
      }
      jacksonSerializer.flush();
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueBean parsing
   */
  protected Bean2 parseValueBean(String input) {
    if (input==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (JacksonWrapperParser wrapper=context.createParser(input)) {
      JsonParser jacksonParser=wrapper.jacksonParser;
      // START_OBJECT
      jacksonParser.nextToken();
      Bean2 result=null;
      if (jacksonParser.currentToken()==JsonToken.START_OBJECT) {
        result=bean2BindMap.parseOnJackson(jacksonParser);
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
  protected String serializeValueLongTypeArray(long[] value) {
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
        jacksonSerializer.writeFieldName("valueLongTypeArray");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          jacksonSerializer.writeNumber(item);
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLongTypeArray parsing
   */
  protected long[] parseValueLongTypeArray(String input) {
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
   * for attribute valueTimeList serialization
   */
  protected String serializeValueTimeList(List<Time> value) {
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
        jacksonSerializer.writeFieldName("valueTimeList");
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
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueTimeList parsing
   */
  protected List<Time> parseValueTimeList(String input) {
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
   * for attribute valueByteArray serialization
   */
  protected String serializeValueByteArray(byte[] value) {
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
        jacksonSerializer.writeBinaryField("valueByteArray", value);
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueByteArray parsing
   */
  protected byte[] parseValueByteArray(String input) {
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
      byte[] result=null;
      if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
        result=jacksonParser.getBinaryValue();
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueBeanArray serialization
   */
  protected String serializeValueBeanArray(Bean2[] value) {
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
        Bean2 item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("valueBeanArray");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            bean2BindMap.serializeOnJackson(item, jacksonSerializer);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueBeanArray parsing
   */
  protected Bean2[] parseValueBeanArray(String input) {
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
      Bean2[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Bean2> collection=new ArrayList<>();
        Bean2 item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=bean2BindMap.parseOnJackson(jacksonParser);
          }
          collection.add(item);
        }
        result=CollectionUtils.asArray(collection, new Bean2[collection.size()]);
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
  protected String serializeValueCharTypeArray(char[] value) {
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
        jacksonSerializer.writeFieldName("valueCharTypeArray");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          jacksonSerializer.writeNumber(item);
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueCharTypeArray parsing
   */
  protected char[] parseValueCharTypeArray(String input) {
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
   * for attribute valueCharArray serialization
   */
  protected String serializeValueCharArray(Character[] value) {
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
        jacksonSerializer.writeFieldName("valueCharArray");
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
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueCharArray parsing
   */
  protected Character[] parseValueCharArray(String input) {
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
   * for attribute valueLongArray serialization
   */
  protected String serializeValueLongArray(Long[] value) {
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
        jacksonSerializer.writeFieldName("valueLongArray");
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
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLongArray parsing
   */
  protected Long[] parseValueLongArray(String input) {
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
   * for attribute valueStringArray serialization
   */
  protected String serializeValueStringArray(String[] value) {
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
        jacksonSerializer.writeFieldName("valueStringArray");
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
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueStringArray parsing
   */
  protected String[] parseValueStringArray(String input) {
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
   * for attribute valueLongList serialization
   */
  protected String serializeValueLongList(LinkedList<Long> value) {
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
        jacksonSerializer.writeFieldName("valueLongList");
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
      return stream.toString();
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for attribute valueLongList parsing
   */
  protected LinkedList<Long> parseValueLongList(String input) {
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
   * get instance of shared preferences
   */
  public static synchronized BindBean2SharedPreferences getInstance() {
    if (instance==null) {
      instance=new BindBean2SharedPreferences();
      // read and write instance to sync with default values
      instance.write(instance.read());
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
     * modifier for property valueEnumType
     */
    public BindEditor putValueEnumType(EnumType value) {
      if (value!=null)  {
        editor.putString("value_enum_type",value.toString() );
      } else {
        editor.remove("valueEnumType");
      }

      return this;
    }

    /**
     * remove property valueEnumType
     */
    public BindEditor removeValueEnumType() {
      editor.remove("value_enum_type");
      return this;
    }

    /**
     * modifier for property valueTime
     */
    public BindEditor putValueTime(Time value) {
      if (value!=null)  {
        editor.putString("value_time",SQLTimeUtils.write(value));
      } else {
        editor.remove("valueTime");
      }

      return this;
    }

    /**
     * remove property valueTime
     */
    public BindEditor removeValueTime() {
      editor.remove("value_time");
      return this;
    }

    /**
     * modifier for property valueCurrency
     */
    public BindEditor putValueCurrency(Currency value) {
      if (value!=null)  {
        editor.putString("value_currency",CurrencyUtils.write(value));
      } else {
        editor.remove("valueCurrency");
      }

      return this;
    }

    /**
     * remove property valueCurrency
     */
    public BindEditor removeValueCurrency() {
      editor.remove("value_currency");
      return this;
    }

    /**
     * modifier for property valueShortType
     */
    public BindEditor putValueShortType(short value) {
      editor.putInt("value_short_type",(int)value);

      return this;
    }

    /**
     * remove property valueShortType
     */
    public BindEditor removeValueShortType() {
      editor.remove("value_short_type");
      return this;
    }

    /**
     * modifier for property valueBigInteger
     */
    public BindEditor putValueBigInteger(BigInteger value) {
      if (value!=null) editor.putString("value_big_integer",value.toString()); else editor.remove("value_big_integer");
      return this;
    }

    /**
     * remove property valueBigInteger
     */
    public BindEditor removeValueBigInteger() {
      editor.remove("value_big_integer");
      return this;
    }

    /**
     * modifier for property valueInt
     */
    public BindEditor putValueInt(Integer value) {
      if (value!=null)  {
        editor.putInt("value_int",(int)value);
      }

      return this;
    }

    /**
     * remove property valueInt
     */
    public BindEditor removeValueInt() {
      editor.remove("value_int");
      return this;
    }

    /**
     * modifier for property valueStrinList
     */
    public BindEditor putValueStrinList(LinkedList<String> value) {
      if (value!=null)  {
        String temp=serializeValueStrinList(value);
        editor.putString("value_strin_list",temp);
      }  else  {
        editor.remove("value_strin_list");
      }

      return this;
    }

    /**
     * remove property valueStrinList
     */
    public BindEditor removeValueStrinList() {
      editor.remove("value_strin_list");
      return this;
    }

    /**
     * modifier for property valueUrl
     */
    public BindEditor putValueUrl(URL value) {
      if (value!=null)  {
        editor.putString("value_url",UrlUtils.write(value));
      } else {
        editor.remove("valueUrl");
      }

      return this;
    }

    /**
     * remove property valueUrl
     */
    public BindEditor removeValueUrl() {
      editor.remove("value_url");
      return this;
    }

    /**
     * modifier for property valueByte
     */
    public BindEditor putValueByte(Byte value) {
      if (value!=null)  {
        editor.putInt("value_byte",(int)value);
      }

      return this;
    }

    /**
     * remove property valueByte
     */
    public BindEditor removeValueByte() {
      editor.remove("value_byte");
      return this;
    }

    /**
     * modifier for property valueCharList
     */
    public BindEditor putValueCharList(LinkedList<Character> value) {
      if (value!=null)  {
        String temp=serializeValueCharList(value);
        editor.putString("value_char_list",temp);
      }  else  {
        editor.remove("value_char_list");
      }

      return this;
    }

    /**
     * remove property valueCharList
     */
    public BindEditor removeValueCharList() {
      editor.remove("value_char_list");
      return this;
    }

    /**
     * modifier for property valueFloat
     */
    public BindEditor putValueFloat(Float value) {
      if (value!=null)  {
        editor.putFloat("value_float",value);
      }

      return this;
    }

    /**
     * remove property valueFloat
     */
    public BindEditor removeValueFloat() {
      editor.remove("value_float");
      return this;
    }

    /**
     * modifier for property valueIntType
     */
    public BindEditor putValueIntType(int value) {
      editor.putInt("value_int_type",(int)value);

      return this;
    }

    /**
     * remove property valueIntType
     */
    public BindEditor removeValueIntType() {
      editor.remove("value_int_type");
      return this;
    }

    /**
     * modifier for property valueLongType
     */
    public BindEditor putValueLongType(long value) {
      editor.putLong("value_long_type",value);

      return this;
    }

    /**
     * remove property valueLongType
     */
    public BindEditor removeValueLongType() {
      editor.remove("value_long_type");
      return this;
    }

    /**
     * modifier for property valueBean
     */
    public BindEditor putValueBean(Bean2 value) {
      if (value!=null)  {
        String temp=serializeValueBean(value);
        editor.putString("value_bean",temp);
      }  else  {
        editor.remove("value_bean");
      }

      return this;
    }

    /**
     * remove property valueBean
     */
    public BindEditor removeValueBean() {
      editor.remove("value_bean");
      return this;
    }

    /**
     * modifier for property valueLong
     */
    public BindEditor putValueLong(Long value) {
      if (value!=null)  {
        editor.putLong("value_long",value);
      }

      return this;
    }

    /**
     * remove property valueLong
     */
    public BindEditor removeValueLong() {
      editor.remove("value_long");
      return this;
    }

    /**
     * modifier for property valueShort
     */
    public BindEditor putValueShort(Short value) {
      if (value!=null)  {
        editor.putInt("value_short",(int)value);
      }

      return this;
    }

    /**
     * remove property valueShort
     */
    public BindEditor removeValueShort() {
      editor.remove("value_short");
      return this;
    }

    /**
     * modifier for property valueLongTypeArray
     */
    public BindEditor putValueLongTypeArray(long[] value) {
      if (value!=null)  {
        String temp=serializeValueLongTypeArray(value);
        editor.putString("value_long_type_array",temp);
      }  else  {
        editor.remove("value_long_type_array");
      }

      return this;
    }

    /**
     * remove property valueLongTypeArray
     */
    public BindEditor removeValueLongTypeArray() {
      editor.remove("value_long_type_array");
      return this;
    }

    /**
     * modifier for property valueTimeList
     */
    public BindEditor putValueTimeList(List<Time> value) {
      if (value!=null)  {
        String temp=serializeValueTimeList(value);
        editor.putString("value_time_list",temp);
      }  else  {
        editor.remove("value_time_list");
      }

      return this;
    }

    /**
     * remove property valueTimeList
     */
    public BindEditor removeValueTimeList() {
      editor.remove("value_time_list");
      return this;
    }

    /**
     * modifier for property valueByteArray
     */
    public BindEditor putValueByteArray(byte[] value) {
      if (value!=null)  {
        String temp=serializeValueByteArray(value);
        editor.putString("value_byte_array",temp);
      }  else  {
        editor.remove("value_byte_array");
      }

      return this;
    }

    /**
     * remove property valueByteArray
     */
    public BindEditor removeValueByteArray() {
      editor.remove("value_byte_array");
      return this;
    }

    /**
     * modifier for property valueDouble
     */
    public BindEditor putValueDouble(Double value) {
      if (value!=null)  {
        editor.putString("value_double",String.valueOf(value));
      } else {
        editor.remove("valueDouble");
      }

      return this;
    }

    /**
     * remove property valueDouble
     */
    public BindEditor removeValueDouble() {
      editor.remove("value_double");
      return this;
    }

    /**
     * modifier for property id
     */
    public BindEditor putId(long value) {
      editor.putLong("id",value);

      return this;
    }

    /**
     * remove property id
     */
    public BindEditor removeId() {
      editor.remove("id");
      return this;
    }

    /**
     * modifier for property valueBeanArray
     */
    public BindEditor putValueBeanArray(Bean2[] value) {
      if (value!=null)  {
        String temp=serializeValueBeanArray(value);
        editor.putString("value_bean_array",temp);
      }  else  {
        editor.remove("value_bean_array");
      }

      return this;
    }

    /**
     * remove property valueBeanArray
     */
    public BindEditor removeValueBeanArray() {
      editor.remove("value_bean_array");
      return this;
    }

    /**
     * modifier for property valueBigDecimal
     */
    public BindEditor putValueBigDecimal(BigDecimal value) {
      if (value!=null) editor.putString("value_big_decimal",value.toPlainString()); else editor.remove("value_big_decimal");
      return this;
    }

    /**
     * remove property valueBigDecimal
     */
    public BindEditor removeValueBigDecimal() {
      editor.remove("value_big_decimal");
      return this;
    }

    /**
     * modifier for property valueTimeZone
     */
    public BindEditor putValueTimeZone(TimeZone value) {
      if (value!=null)  {
        editor.putString("value_time_zone",TimeZoneUtils.write(value));
      } else {
        editor.remove("valueTimeZone");
      }

      return this;
    }

    /**
     * remove property valueTimeZone
     */
    public BindEditor removeValueTimeZone() {
      editor.remove("value_time_zone");
      return this;
    }

    /**
     * modifier for property valueCharTypeArray
     */
    public BindEditor putValueCharTypeArray(char[] value) {
      if (value!=null)  {
        String temp=serializeValueCharTypeArray(value);
        editor.putString("value_char_type_array",temp);
      }  else  {
        editor.remove("value_char_type_array");
      }

      return this;
    }

    /**
     * remove property valueCharTypeArray
     */
    public BindEditor removeValueCharTypeArray() {
      editor.remove("value_char_type_array");
      return this;
    }

    /**
     * modifier for property valueDoubleType
     */
    public BindEditor putValueDoubleType(double value) {
      editor.putString("value_double_type",String.valueOf(value));

      return this;
    }

    /**
     * remove property valueDoubleType
     */
    public BindEditor removeValueDoubleType() {
      editor.remove("value_double_type");
      return this;
    }

    /**
     * modifier for property valueCharType
     */
    public BindEditor putValueCharType(char value) {
      editor.putInt("value_char_type",(char)value);

      return this;
    }

    /**
     * remove property valueCharType
     */
    public BindEditor removeValueCharType() {
      editor.remove("value_char_type");
      return this;
    }

    /**
     * modifier for property valueDate
     */
    public BindEditor putValueDate(Date value) {
      if (value!=null)  {
        editor.putString("value_date",DateUtils.write(value));
      } else {
        editor.remove("valueDate");
      }

      return this;
    }

    /**
     * remove property valueDate
     */
    public BindEditor removeValueDate() {
      editor.remove("value_date");
      return this;
    }

    /**
     * modifier for property valueFloatType
     */
    public BindEditor putValueFloatType(float value) {
      editor.putFloat("value_float_type",value);

      return this;
    }

    /**
     * remove property valueFloatType
     */
    public BindEditor removeValueFloatType() {
      editor.remove("value_float_type");
      return this;
    }

    /**
     * modifier for property valueBool
     */
    public BindEditor putValueBool(Boolean value) {
      if (value!=null)  {
        editor.putBoolean("value_bool",(boolean)value);
      }

      return this;
    }

    /**
     * remove property valueBool
     */
    public BindEditor removeValueBool() {
      editor.remove("value_bool");
      return this;
    }

    /**
     * modifier for property valueBoolType
     */
    public BindEditor putValueBoolType(boolean value) {
      editor.putBoolean("value_bool_type",(boolean)value);

      return this;
    }

    /**
     * remove property valueBoolType
     */
    public BindEditor removeValueBoolType() {
      editor.remove("value_bool_type");
      return this;
    }

    /**
     * modifier for property valueCharArray
     */
    public BindEditor putValueCharArray(Character[] value) {
      if (value!=null)  {
        String temp=serializeValueCharArray(value);
        editor.putString("value_char_array",temp);
      }  else  {
        editor.remove("value_char_array");
      }

      return this;
    }

    /**
     * remove property valueCharArray
     */
    public BindEditor removeValueCharArray() {
      editor.remove("value_char_array");
      return this;
    }

    /**
     * modifier for property valueChar
     */
    public BindEditor putValueChar(Character value) {
      if (value!=null)  {
        editor.putInt("value_char",(char)value);
      }

      return this;
    }

    /**
     * remove property valueChar
     */
    public BindEditor removeValueChar() {
      editor.remove("value_char");
      return this;
    }

    /**
     * modifier for property valueLongArray
     */
    public BindEditor putValueLongArray(Long[] value) {
      if (value!=null)  {
        String temp=serializeValueLongArray(value);
        editor.putString("value_long_array",temp);
      }  else  {
        editor.remove("value_long_array");
      }

      return this;
    }

    /**
     * remove property valueLongArray
     */
    public BindEditor removeValueLongArray() {
      editor.remove("value_long_array");
      return this;
    }

    /**
     * modifier for property valueStringArray
     */
    public BindEditor putValueStringArray(String[] value) {
      if (value!=null)  {
        String temp=serializeValueStringArray(value);
        editor.putString("value_string_array",temp);
      }  else  {
        editor.remove("value_string_array");
      }

      return this;
    }

    /**
     * remove property valueStringArray
     */
    public BindEditor removeValueStringArray() {
      editor.remove("value_string_array");
      return this;
    }

    /**
     * modifier for property valueString
     */
    public BindEditor putValueString(String value) {
      editor.putString("value_string",value);

      return this;
    }

    /**
     * remove property valueString
     */
    public BindEditor removeValueString() {
      editor.remove("value_string");
      return this;
    }

    /**
     * modifier for property valueCalendar
     */
    public BindEditor putValueCalendar(Calendar value) {
      if (value!=null)  {
        editor.putString("value_calendar",CalendarUtils.write(value));
      } else {
        editor.remove("valueCalendar");
      }

      return this;
    }

    /**
     * remove property valueCalendar
     */
    public BindEditor removeValueCalendar() {
      editor.remove("value_calendar");
      return this;
    }

    /**
     * modifier for property valueLongList
     */
    public BindEditor putValueLongList(LinkedList<Long> value) {
      if (value!=null)  {
        String temp=serializeValueLongList(value);
        editor.putString("value_long_list",temp);
      }  else  {
        editor.remove("value_long_list");
      }

      return this;
    }

    /**
     * remove property valueLongList
     */
    public BindEditor removeValueLongList() {
      editor.remove("value_long_list");
      return this;
    }

    /**
     * modifier for property valueByteType
     */
    public BindEditor putValueByteType(byte value) {
      editor.putInt("value_byte_type",(int)value);

      return this;
    }

    /**
     * remove property valueByteType
     */
    public BindEditor removeValueByteType() {
      editor.remove("value_byte_type");
      return this;
    }

    /**
     * modifier for property valueLocale
     */
    public BindEditor putValueLocale(Locale value) {
      if (value!=null)  {
        editor.putString("value_locale",LocaleUtils.write(value));
      } else {
        editor.remove("valueLocale");
      }

      return this;
    }

    /**
     * remove property valueLocale
     */
    public BindEditor removeValueLocale() {
      editor.remove("value_locale");
      return this;
    }

    /**
     * clear all properties
     */
    public BindEditor clear() {
      editor.clear();
      return this;
    }
  }
}
