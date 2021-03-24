package sqlite.kripton64;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.abubusoft.kripton.BinderUtils;
import com.abubusoft.kripton.KriptonBinder;
import com.abubusoft.kripton.KriptonJsonContext;
import com.abubusoft.kripton.android.Logger;
import com.abubusoft.kripton.android.sqlite.Dao;
import com.abubusoft.kripton.android.sqlite.KriptonContentValues;
import com.abubusoft.kripton.android.sqlite.KriptonDatabaseHelper;
import com.abubusoft.kripton.android.sqlite.OnReadBeanListener;
import com.abubusoft.kripton.android.sqlite.OnReadCursorListener;
import com.abubusoft.kripton.common.CalendarUtils;
import com.abubusoft.kripton.common.CollectionUtils;
import com.abubusoft.kripton.common.CurrencyUtils;
import com.abubusoft.kripton.common.DateUtils;
import com.abubusoft.kripton.common.EnumUtils;
import com.abubusoft.kripton.common.KriptonByteArrayOutputStream;
import com.abubusoft.kripton.common.LocaleUtils;
import com.abubusoft.kripton.common.SQLTimeUtils;
import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.common.TimeZoneUtils;
import com.abubusoft.kripton.common.Triple;
import com.abubusoft.kripton.common.UrlUtils;
import com.abubusoft.kripton.exception.KriptonRuntimeException;
import com.abubusoft.kripton.persistence.JacksonWrapperParser;
import com.abubusoft.kripton.persistence.JacksonWrapperSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

/**
 * <p>
 * DAO implementation for entity <code>Bean64</code>, based on interface <code>Bean64Dao</code>
 * </p>
 *
 *  @see Bean64
 *  @see Bean64Dao
 *  @see Bean64Table
 */
public class Bean64DaoImpl extends Dao implements Bean64Dao {
  private static SupportSQLiteStatement deletePreparedStatement0;

  private static SupportSQLiteStatement deletePreparedStatement1;

  private static SupportSQLiteStatement deletePreparedStatement2;

  private static SupportSQLiteStatement deletePreparedStatement3;

  private static SupportSQLiteStatement deleteArrayBeanTypePreparedStatement4;

  private static SupportSQLiteStatement deleteArrayLongPreparedStatement5;

  private static SupportSQLiteStatement deleteArrayLongTypePreparedStatement6;

  private static SupportSQLiteStatement deleteBytePreparedStatement7;

  private static SupportSQLiteStatement deleteByteTypePreparedStatement8;

  private static SupportSQLiteStatement deleteCalendarPreparedStatement9;

  private static SupportSQLiteStatement deleteCharPreparedStatement10;

  private static SupportSQLiteStatement deleteCharTypePreparedStatement11;

  private static SupportSQLiteStatement deleteCurrencyPreparedStatement12;

  private static SupportSQLiteStatement deleteDatePreparedStatement13;

  private static SupportSQLiteStatement deleteDoublePreparedStatement14;

  private static SupportSQLiteStatement deleteDoubleTypePreparedStatement15;

  private static SupportSQLiteStatement deleteEnumTypePreparedStatement16;

  private static SupportSQLiteStatement deleteFloatPreparedStatement17;

  private static SupportSQLiteStatement deleteFloatTypePreparedStatement18;

  private static SupportSQLiteStatement deleteIntPreparedStatement19;

  private static SupportSQLiteStatement deleteIntTypePreparedStatement20;

  private static SupportSQLiteStatement deleteListLongPreparedStatement21;

  private static SupportSQLiteStatement deleteLocalePreparedStatement22;

  private static SupportSQLiteStatement deleteLongPreparedStatement23;

  private static SupportSQLiteStatement deleteLongTypePreparedStatement24;

  private static SupportSQLiteStatement deleteShortPreparedStatement25;

  private static SupportSQLiteStatement deleteShortTypePreparedStatement26;

  private static SupportSQLiteStatement deleteStringPreparedStatement27;

  private static SupportSQLiteStatement deleteTimePreparedStatement28;

  private static SupportSQLiteStatement deleteTimeZonePreparedStatement29;

  private static SupportSQLiteStatement deleteURLPreparedStatement30;

  private static SupportSQLiteStatement insertPreparedStatement31;

  private static SupportSQLiteStatement insertPreparedStatement32;

  private static SupportSQLiteStatement insertPreparedStatement33;

  private static SupportSQLiteStatement insertPreparedStatement34;

  private static SupportSQLiteStatement insertPreparedStatement35;

  private static SupportSQLiteStatement insertArrayBeanTypePreparedStatement36;

  private static SupportSQLiteStatement insertArrayLongPreparedStatement37;

  private static SupportSQLiteStatement insertArrayLongTypePreparedStatement38;

  private static SupportSQLiteStatement insertBytePreparedStatement39;

  private static SupportSQLiteStatement insertByteTypePreparedStatement40;

  private static SupportSQLiteStatement insertCalendarPreparedStatement41;

  private static SupportSQLiteStatement insertCharPreparedStatement42;

  private static SupportSQLiteStatement insertCharTypePreparedStatement43;

  private static SupportSQLiteStatement insertCurrencyPreparedStatement44;

  private static SupportSQLiteStatement insertDatePreparedStatement45;

  private static SupportSQLiteStatement insertDoublePreparedStatement46;

  private static SupportSQLiteStatement insertDoubleTypePreparedStatement47;

  private static SupportSQLiteStatement insertEnumTypePreparedStatement48;

  private static SupportSQLiteStatement insertFloatPreparedStatement49;

  private static SupportSQLiteStatement insertFloatTypePreparedStatement50;

  private static SupportSQLiteStatement insertIntPreparedStatement51;

  private static SupportSQLiteStatement insertIntTypePreparedStatement52;

  private static SupportSQLiteStatement insertListLongPreparedStatement53;

  private static SupportSQLiteStatement insertLocalePreparedStatement54;

  private static SupportSQLiteStatement insertLongPreparedStatement55;

  private static SupportSQLiteStatement insertLongTypePreparedStatement56;

  private static SupportSQLiteStatement insertShortPreparedStatement57;

  private static SupportSQLiteStatement insertShortTypePreparedStatement58;

  private static SupportSQLiteStatement insertStringPreparedStatement59;

  private static SupportSQLiteStatement insertTimePreparedStatement60;

  private static SupportSQLiteStatement insertTimeZonePreparedStatement61;

  private static SupportSQLiteStatement insertURLPreparedStatement62;

  /**
   * SQL definition for method selectList
   */
  private static final String SELECT_LIST_SQL1 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE id = ?";

  /**
   * SQL definition for method selectOne
   */
  private static final String SELECT_ONE_SQL2 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64";

  /**
   * SQL definition for method selectOne
   */
  private static final String SELECT_ONE_SQL3 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_big_decimal=?";

  /**
   * SQL definition for method selectOne
   */
  private static final String SELECT_ONE_SQL4 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_big_decimal=?";

  /**
   * SQL definition for method selectOne
   */
  private static final String SELECT_ONE_SQL5 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_bool_type=?";

  /**
   * SQL definition for method selectOne
   */
  private static final String SELECT_ONE_SQL6 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_bool=?";

  /**
   * SQL definition for method selectOne
   */
  private static final String SELECT_ONE_SQL7 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE id = ?";

  /**
   * SQL definition for method selectOne
   */
  private static final String SELECT_ONE_SQL8 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE id = ?";

  /**
   * SQL definition for method selectOneArrayBeanType
   */
  private static final String SELECT_ONE_ARRAY_BEAN_TYPE_SQL9 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_bean_array=?";

  /**
   * SQL definition for method selectOneArrayLong
   */
  private static final String SELECT_ONE_ARRAY_LONG_SQL10 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_long_array=?";

  /**
   * SQL definition for method selectOneArrayLongType
   */
  private static final String SELECT_ONE_ARRAY_LONG_TYPE_SQL11 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_long_type_array=?";

  /**
   * SQL definition for method selectOneByte
   */
  private static final String SELECT_ONE_BYTE_SQL12 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_byte=?";

  /**
   * SQL definition for method selectOneByteType
   */
  private static final String SELECT_ONE_BYTE_TYPE_SQL13 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_byte_type=?";

  /**
   * SQL definition for method selectOneCalendar
   */
  private static final String SELECT_ONE_CALENDAR_SQL14 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_calendar=?";

  /**
   * SQL definition for method selectOneChar
   */
  private static final String SELECT_ONE_CHAR_SQL15 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_char_type=?";

  /**
   * SQL definition for method selectOneCharType
   */
  private static final String SELECT_ONE_CHAR_TYPE_SQL16 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_char_type=?";

  /**
   * SQL definition for method selectOneCurrencye
   */
  private static final String SELECT_ONE_CURRENCYE_SQL17 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_currency=?";

  /**
   * SQL definition for method selectOneDate
   */
  private static final String SELECT_ONE_DATE_SQL18 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_date=?";

  /**
   * SQL definition for method selectOneDouble
   */
  private static final String SELECT_ONE_DOUBLE_SQL19 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_double=?";

  /**
   * SQL definition for method selectOneDoubleType
   */
  private static final String SELECT_ONE_DOUBLE_TYPE_SQL20 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_double_type=?";

  /**
   * SQL definition for method selectOneEnumType
   */
  private static final String SELECT_ONE_ENUM_TYPE_SQL21 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_enum_type=?";

  /**
   * SQL definition for method selectOneFloat
   */
  private static final String SELECT_ONE_FLOAT_SQL22 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_float=?";

  /**
   * SQL definition for method selectOneFloatType
   */
  private static final String SELECT_ONE_FLOAT_TYPE_SQL23 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_float_type=?";

  /**
   * SQL definition for method selectOneInt
   */
  private static final String SELECT_ONE_INT_SQL24 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_int=?";

  /**
   * SQL definition for method selectOneIntType
   */
  private static final String SELECT_ONE_INT_TYPE_SQL25 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_int_type=?";

  /**
   * SQL definition for method selectOneListLong
   */
  private static final String SELECT_ONE_LIST_LONG_SQL26 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_long_list=?";

  /**
   * SQL definition for method selectOneLocale
   */
  private static final String SELECT_ONE_LOCALE_SQL27 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_locale=?";

  /**
   * SQL definition for method selectOneLong
   */
  private static final String SELECT_ONE_LONG_SQL28 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_long=?";

  /**
   * SQL definition for method selectOneLongType
   */
  private static final String SELECT_ONE_LONG_TYPE_SQL29 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_long_type=?";

  /**
   * SQL definition for method selectOneShort
   */
  private static final String SELECT_ONE_SHORT_SQL30 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_short=?";

  /**
   * SQL definition for method selectOneShortType
   */
  private static final String SELECT_ONE_SHORT_TYPE_SQL31 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_short_type=?";

  /**
   * SQL definition for method selectOneString
   */
  private static final String SELECT_ONE_STRING_SQL32 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_string=?";

  /**
   * SQL definition for method selectOneTime
   */
  private static final String SELECT_ONE_TIME_SQL33 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_time=?";

  /**
   * SQL definition for method selectOneTimeZone
   */
  private static final String SELECT_ONE_TIME_ZONE_SQL34 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_time_zone=?";

  /**
   * SQL definition for method selectOneURL
   */
  private static final String SELECT_ONE_U_R_L_SQL35 = "SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_url=?";

  /**
   * SQL definition for method selectValueBool
   */
  private static final String SELECT_VALUE_BOOL_SQL36 = "SELECT value_bool FROM bean64";

  /**
   * SQL definition for method selectValueBoolType
   */
  private static final String SELECT_VALUE_BOOL_TYPE_SQL37 = "SELECT value_bool_type FROM bean64";

  /**
   * SQL definition for method selectValueByte
   */
  private static final String SELECT_VALUE_BYTE_SQL38 = "SELECT value_byte FROM bean64";

  /**
   * SQL definition for method selectValueByteType
   */
  private static final String SELECT_VALUE_BYTE_TYPE_SQL39 = "SELECT value_byte_type FROM bean64";

  /**
   * SQL definition for method selectValueChar
   */
  private static final String SELECT_VALUE_CHAR_SQL40 = "SELECT value_char FROM bean64";

  /**
   * SQL definition for method selectValueCharType
   */
  private static final String SELECT_VALUE_CHAR_TYPE_SQL41 = "SELECT value_char_type FROM bean64";

  /**
   * SQL definition for method selectValueDouble
   */
  private static final String SELECT_VALUE_DOUBLE_SQL42 = "SELECT value_double FROM bean64";

  /**
   * SQL definition for method selectValueDoubleType
   */
  private static final String SELECT_VALUE_DOUBLE_TYPE_SQL43 = "SELECT value_double_type FROM bean64";

  /**
   * SQL definition for method selectValueFloat
   */
  private static final String SELECT_VALUE_FLOAT_SQL44 = "SELECT value_float FROM bean64";

  /**
   * SQL definition for method selectValueFloatType
   */
  private static final String SELECT_VALUE_FLOAT_TYPE_SQL45 = "SELECT value_float_type FROM bean64";

  /**
   * SQL definition for method selectValueInt
   */
  private static final String SELECT_VALUE_INT_SQL46 = "SELECT value_int FROM bean64";

  /**
   * SQL definition for method selectValueIntType
   */
  private static final String SELECT_VALUE_INT_TYPE_SQL47 = "SELECT value_int_type FROM bean64";

  /**
   * SQL definition for method selectValueLong
   */
  private static final String SELECT_VALUE_LONG_SQL48 = "SELECT value_long FROM bean64";

  /**
   * SQL definition for method selectValueLongType
   */
  private static final String SELECT_VALUE_LONG_TYPE_SQL49 = "SELECT value_long_type FROM bean64";

  /**
   * SQL definition for method selectValueShort
   */
  private static final String SELECT_VALUE_SHORT_SQL50 = "SELECT value_short FROM bean64";

  /**
   * SQL definition for method selectValueShortType
   */
  private static final String SELECT_VALUE_SHORT_TYPE_SQL51 = "SELECT value_short_type FROM bean64";

  /**
   * SQL definition for method selectValueString
   */
  private static final String SELECT_VALUE_STRING_SQL52 = "SELECT value_string FROM bean64";

  private static SupportSQLiteStatement updateOnePreparedStatement63;

  private static SupportSQLiteStatement updateOnePreparedStatement64;

  private static SupportSQLiteStatement updateOnePreparedStatement65;

  private static SupportSQLiteStatement updateOnePreparedStatement66;

  private static SupportSQLiteStatement updateOnePreparedStatement67;

  private static SupportSQLiteStatement updateOnePreparedStatement68;

  private static SupportSQLiteStatement updateOneArrayBeanPreparedStatement69;

  private static SupportSQLiteStatement updateOneArrayLongPreparedStatement70;

  private static SupportSQLiteStatement updateOneArrayLongTypePreparedStatement71;

  private static SupportSQLiteStatement updateOneBytePreparedStatement72;

  private static SupportSQLiteStatement updateOneByteTypePreparedStatement73;

  private static SupportSQLiteStatement updateOneCalendarPreparedStatement74;

  private static SupportSQLiteStatement updateOneCharPreparedStatement75;

  private static SupportSQLiteStatement updateOneCharTypePreparedStatement76;

  private static SupportSQLiteStatement updateOneCurrencyPreparedStatement77;

  private static SupportSQLiteStatement updateOneDatePreparedStatement78;

  private static SupportSQLiteStatement updateOneDoublePreparedStatement79;

  private static SupportSQLiteStatement updateOneDoubleTypePreparedStatement80;

  private static SupportSQLiteStatement updateOneEnumTypePreparedStatement81;

  private static SupportSQLiteStatement updateOneFloatPreparedStatement82;

  private static SupportSQLiteStatement updateOneFloatTypePreparedStatement83;

  private static SupportSQLiteStatement updateOneIntPreparedStatement84;

  private static SupportSQLiteStatement updateOneIntTypePreparedStatement85;

  private static SupportSQLiteStatement updateOneListLongPreparedStatement86;

  private static SupportSQLiteStatement updateOneLocalePreparedStatement87;

  private static SupportSQLiteStatement updateOneLongPreparedStatement88;

  private static SupportSQLiteStatement updateOneLongTypePreparedStatement89;

  private static SupportSQLiteStatement updateOneShortPreparedStatement90;

  private static SupportSQLiteStatement updateOneShortTypePreparedStatement91;

  private static SupportSQLiteStatement updateOneStringPreparedStatement92;

  private static SupportSQLiteStatement updateOneTimePreparedStatement93;

  private static SupportSQLiteStatement updateOneTimeZonePreparedStatement94;

  private static SupportSQLiteStatement updateOneURLPreparedStatement95;

  /**
   * binder for type Bean64
   */
  private static Bean64BindMap bean64BindMap = BinderUtils.mapperFor(Bean64.class);

  public Bean64DaoImpl(BindBean64DaoFactory daoFactory) {
    super(daoFactory.getContext());
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_big_decimal=:valueBigDecimal</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueBigDecimal</dt><dd>is mapped to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>
   *
   * @param valueBigDecimal
   * 	is used as where parameter <strong>:valueBigDecimal</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long delete(BigDecimal valueBigDecimal) {
    if (deletePreparedStatement0==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_big_decimal=?";
      deletePreparedStatement0 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deletePreparedStatement0);
    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toPlainString()));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_big_decimal=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deletePreparedStatement0, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_big_decimal=:valueBigDecimal</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueBigDecimal</dt><dd>is mapped to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>
   *
   * @param valueBigDecimal
   * 	is used as where parameter <strong>:valueBigDecimal</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long delete(BigInteger valueBigDecimal) {
    if (deletePreparedStatement1==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_big_decimal=?";
      deletePreparedStatement1 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deletePreparedStatement1);
    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toString()));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_big_decimal=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deletePreparedStatement1, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_bool_type=:valueBoolType</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueBoolType</dt><dd>is mapped to method's parameter <strong>valueBoolType</strong></dd>
   * </dl>
   *
   * @param valueBoolType
   * 	is used as where parameter <strong>:valueBoolType</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long delete(boolean valueBoolType) {
    if (deletePreparedStatement2==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_bool_type=?";
      deletePreparedStatement2 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deletePreparedStatement2);
    _contentValues.addWhereArgs(String.valueOf(valueBoolType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_bool_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deletePreparedStatement2, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_bool=:valueBool</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueBool</dt><dd>is mapped to method's parameter <strong>valueBool</strong></dd>
   * </dl>
   *
   * @param valueBool
   * 	is used as where parameter <strong>:valueBool</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long delete(Boolean valueBool) {
    if (deletePreparedStatement3==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_bool=?";
      deletePreparedStatement3 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deletePreparedStatement3);
    _contentValues.addWhereArgs((valueBool==null?"":String.valueOf(valueBool)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_bool=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deletePreparedStatement3, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_bean_array=:valueBeanArray</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueBeanArray</dt><dd>is mapped to method's parameter <strong>valueBeanArray</strong></dd>
   * </dl>
   *
   * @param valueBeanArray
   * 	is used as where parameter <strong>:valueBeanArray</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteArrayBeanType(Bean64[] valueBeanArray) {
    if (deleteArrayBeanTypePreparedStatement4==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_bean_array=?";
      deleteArrayBeanTypePreparedStatement4 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteArrayBeanTypePreparedStatement4);
    _contentValues.addWhereArgs((valueBeanArray==null?"":new String(serializer1(valueBeanArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_bean_array=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteArrayBeanTypePreparedStatement4, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_long_array=:valueLongArray</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLongArray</dt><dd>is mapped to method's parameter <strong>valueLongArray</strong></dd>
   * </dl>
   *
   * @param valueLongArray
   * 	is used as where parameter <strong>:valueLongArray</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteArrayLong(Long[] valueLongArray) {
    if (deleteArrayLongPreparedStatement5==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_long_array=?";
      deleteArrayLongPreparedStatement5 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteArrayLongPreparedStatement5);
    _contentValues.addWhereArgs((valueLongArray==null?"":new String(serializer2(valueLongArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_long_array=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteArrayLongPreparedStatement5, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_long_type_array=:valueLongTypeArray</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLongTypeArray</dt><dd>is mapped to method's parameter <strong>valueLongTypeArray</strong></dd>
   * </dl>
   *
   * @param valueLongTypeArray
   * 	is used as where parameter <strong>:valueLongTypeArray</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteArrayLongType(long[] valueLongTypeArray) {
    if (deleteArrayLongTypePreparedStatement6==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_long_type_array=?";
      deleteArrayLongTypePreparedStatement6 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteArrayLongTypePreparedStatement6);
    _contentValues.addWhereArgs((valueLongTypeArray==null?"":new String(serializer3(valueLongTypeArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_long_type_array=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteArrayLongTypePreparedStatement6, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_byte=:valueByte</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueByte</dt><dd>is mapped to method's parameter <strong>valueByte</strong></dd>
   * </dl>
   *
   * @param valueByte
   * 	is used as where parameter <strong>:valueByte</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteByte(Byte valueByte) {
    if (deleteBytePreparedStatement7==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_byte=?";
      deleteBytePreparedStatement7 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteBytePreparedStatement7);
    _contentValues.addWhereArgs((valueByte==null?"":String.valueOf(valueByte)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_byte=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteBytePreparedStatement7, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_byte_type=:valueByteType</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueByteType</dt><dd>is mapped to method's parameter <strong>valueByteType</strong></dd>
   * </dl>
   *
   * @param valueByteType
   * 	is used as where parameter <strong>:valueByteType</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteByteType(boolean valueByteType) {
    if (deleteByteTypePreparedStatement8==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_byte_type=?";
      deleteByteTypePreparedStatement8 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteByteTypePreparedStatement8);
    _contentValues.addWhereArgs(String.valueOf(valueByteType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_byte_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteByteTypePreparedStatement8, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_calendar=:valueCalendar</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueCalendar</dt><dd>is mapped to method's parameter <strong>valueCalendar</strong></dd>
   * </dl>
   *
   * @param valueCalendar
   * 	is used as where parameter <strong>:valueCalendar</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteCalendar(Date valueCalendar) {
    if (deleteCalendarPreparedStatement9==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_calendar=?";
      deleteCalendarPreparedStatement9 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteCalendarPreparedStatement9);
    _contentValues.addWhereArgs((valueCalendar==null?"":DateUtils.write(valueCalendar)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_calendar=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteCalendarPreparedStatement9, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_char_type=:valueChar</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueChar</dt><dd>is mapped to method's parameter <strong>valueChar</strong></dd>
   * </dl>
   *
   * @param valueChar
   * 	is used as where parameter <strong>:valueChar</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteChar(Character valueChar) {
    if (deleteCharPreparedStatement10==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_char_type=?";
      deleteCharPreparedStatement10 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteCharPreparedStatement10);
    _contentValues.addWhereArgs((valueChar==null?"":String.valueOf(valueChar)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_char_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteCharPreparedStatement10, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_char_type=:valueCharType</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueCharType</dt><dd>is mapped to method's parameter <strong>valueCharType</strong></dd>
   * </dl>
   *
   * @param valueCharType
   * 	is used as where parameter <strong>:valueCharType</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteCharType(char valueCharType) {
    if (deleteCharTypePreparedStatement11==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_char_type=?";
      deleteCharTypePreparedStatement11 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteCharTypePreparedStatement11);
    _contentValues.addWhereArgs(String.valueOf(valueCharType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_char_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteCharTypePreparedStatement11, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_currency=:valueCurrency</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueCurrency</dt><dd>is mapped to method's parameter <strong>valueCurrency</strong></dd>
   * </dl>
   *
   * @param valueCurrency
   * 	is used as where parameter <strong>:valueCurrency</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteCurrency(Currency valueCurrency) {
    if (deleteCurrencyPreparedStatement12==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_currency=?";
      deleteCurrencyPreparedStatement12 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteCurrencyPreparedStatement12);
    _contentValues.addWhereArgs((valueCurrency==null?"":CurrencyUtils.write(valueCurrency)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_currency=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteCurrencyPreparedStatement12, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_date=:valueDate</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueDate</dt><dd>is mapped to method's parameter <strong>valueDate</strong></dd>
   * </dl>
   *
   * @param valueDate
   * 	is used as where parameter <strong>:valueDate</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteDate(Date valueDate) {
    if (deleteDatePreparedStatement13==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_date=?";
      deleteDatePreparedStatement13 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteDatePreparedStatement13);
    _contentValues.addWhereArgs((valueDate==null?"":DateUtils.write(valueDate)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_date=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteDatePreparedStatement13, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_double=:valueDouble</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueDouble</dt><dd>is mapped to method's parameter <strong>valueDouble</strong></dd>
   * </dl>
   *
   * @param valueDouble
   * 	is used as where parameter <strong>:valueDouble</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteDouble(Double valueDouble) {
    if (deleteDoublePreparedStatement14==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_double=?";
      deleteDoublePreparedStatement14 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteDoublePreparedStatement14);
    _contentValues.addWhereArgs((valueDouble==null?"":String.valueOf(valueDouble)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_double=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteDoublePreparedStatement14, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_double_type=:valueDoubleType</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueDoubleType</dt><dd>is mapped to method's parameter <strong>valueDoubleType</strong></dd>
   * </dl>
   *
   * @param valueDoubleType
   * 	is used as where parameter <strong>:valueDoubleType</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteDoubleType(double valueDoubleType) {
    if (deleteDoubleTypePreparedStatement15==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_double_type=?";
      deleteDoubleTypePreparedStatement15 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteDoubleTypePreparedStatement15);
    _contentValues.addWhereArgs(String.valueOf(valueDoubleType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_double_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteDoubleTypePreparedStatement15, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_enum_type=:valueEnumType</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueEnumType</dt><dd>is mapped to method's parameter <strong>valueEnumType</strong></dd>
   * </dl>
   *
   * @param valueEnumType
   * 	is used as where parameter <strong>:valueEnumType</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteEnumType(EnumType valueEnumType) {
    if (deleteEnumTypePreparedStatement16==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_enum_type=?";
      deleteEnumTypePreparedStatement16 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteEnumTypePreparedStatement16);
    _contentValues.addWhereArgs((valueEnumType==null?"":EnumUtils.write(valueEnumType)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_enum_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteEnumTypePreparedStatement16, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_float=:valueFloat</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueFloat</dt><dd>is mapped to method's parameter <strong>valueFloat</strong></dd>
   * </dl>
   *
   * @param valueFloat
   * 	is used as where parameter <strong>:valueFloat</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteFloat(Float valueFloat) {
    if (deleteFloatPreparedStatement17==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_float=?";
      deleteFloatPreparedStatement17 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteFloatPreparedStatement17);
    _contentValues.addWhereArgs((valueFloat==null?"":String.valueOf(valueFloat)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_float=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteFloatPreparedStatement17, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_float_type=:valueFloatType</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueFloatType</dt><dd>is mapped to method's parameter <strong>valueFloatType</strong></dd>
   * </dl>
   *
   * @param valueFloatType
   * 	is used as where parameter <strong>:valueFloatType</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteFloatType(float valueFloatType) {
    if (deleteFloatTypePreparedStatement18==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_float_type=?";
      deleteFloatTypePreparedStatement18 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteFloatTypePreparedStatement18);
    _contentValues.addWhereArgs(String.valueOf(valueFloatType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_float_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteFloatTypePreparedStatement18, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_int=:valueInt</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueInt</dt><dd>is mapped to method's parameter <strong>valueInt</strong></dd>
   * </dl>
   *
   * @param valueInt
   * 	is used as where parameter <strong>:valueInt</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteInt(Integer valueInt) {
    if (deleteIntPreparedStatement19==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_int=?";
      deleteIntPreparedStatement19 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteIntPreparedStatement19);
    _contentValues.addWhereArgs((valueInt==null?"":String.valueOf(valueInt)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_int=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteIntPreparedStatement19, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_int_type=:valueIntType</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueIntType</dt><dd>is mapped to method's parameter <strong>valueIntType</strong></dd>
   * </dl>
   *
   * @param valueIntType
   * 	is used as where parameter <strong>:valueIntType</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteIntType(int valueIntType) {
    if (deleteIntTypePreparedStatement20==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_int_type=?";
      deleteIntTypePreparedStatement20 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteIntTypePreparedStatement20);
    _contentValues.addWhereArgs(String.valueOf(valueIntType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_int_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteIntTypePreparedStatement20, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_long_list=:valueLongList</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLongList</dt><dd>is mapped to method's parameter <strong>valueLongList</strong></dd>
   * </dl>
   *
   * @param valueLongList
   * 	is used as where parameter <strong>:valueLongList</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteListLong(LinkedList<Long> valueLongList) {
    if (deleteListLongPreparedStatement21==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_long_list=?";
      deleteListLongPreparedStatement21 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteListLongPreparedStatement21);
    _contentValues.addWhereArgs((valueLongList==null?"":new String(serializer4(valueLongList),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_long_list=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteListLongPreparedStatement21, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_locale=:valueLocale</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLocale</dt><dd>is mapped to method's parameter <strong>valueLocale</strong></dd>
   * </dl>
   *
   * @param valueLocale
   * 	is used as where parameter <strong>:valueLocale</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteLocale(Date valueLocale) {
    if (deleteLocalePreparedStatement22==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_locale=?";
      deleteLocalePreparedStatement22 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteLocalePreparedStatement22);
    _contentValues.addWhereArgs((valueLocale==null?"":DateUtils.write(valueLocale)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_locale=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteLocalePreparedStatement22, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_long=:valueLong</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLong</dt><dd>is mapped to method's parameter <strong>valueLong</strong></dd>
   * </dl>
   *
   * @param valueLong
   * 	is used as where parameter <strong>:valueLong</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteLong(Long valueLong) {
    if (deleteLongPreparedStatement23==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_long=?";
      deleteLongPreparedStatement23 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteLongPreparedStatement23);
    _contentValues.addWhereArgs((valueLong==null?"":String.valueOf(valueLong)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_long=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteLongPreparedStatement23, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_long_type=:valueLongType</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLongType</dt><dd>is mapped to method's parameter <strong>valueLongType</strong></dd>
   * </dl>
   *
   * @param valueLongType
   * 	is used as where parameter <strong>:valueLongType</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteLongType(long valueLongType) {
    if (deleteLongTypePreparedStatement24==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_long_type=?";
      deleteLongTypePreparedStatement24 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteLongTypePreparedStatement24);
    _contentValues.addWhereArgs(String.valueOf(valueLongType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_long_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteLongTypePreparedStatement24, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_short=:valueShort</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueShort</dt><dd>is mapped to method's parameter <strong>valueShort</strong></dd>
   * </dl>
   *
   * @param valueShort
   * 	is used as where parameter <strong>:valueShort</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteShort(Short valueShort) {
    if (deleteShortPreparedStatement25==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_short=?";
      deleteShortPreparedStatement25 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteShortPreparedStatement25);
    _contentValues.addWhereArgs((valueShort==null?"":String.valueOf(valueShort)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_short=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteShortPreparedStatement25, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_short_type=:valueShortType</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueShortType</dt><dd>is mapped to method's parameter <strong>valueShortType</strong></dd>
   * </dl>
   *
   * @param valueShortType
   * 	is used as where parameter <strong>:valueShortType</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteShortType(short valueShortType) {
    if (deleteShortTypePreparedStatement26==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_short_type=?";
      deleteShortTypePreparedStatement26 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteShortTypePreparedStatement26);
    _contentValues.addWhereArgs(String.valueOf(valueShortType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_short_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteShortTypePreparedStatement26, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_string=:valueString</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueString</dt><dd>is mapped to method's parameter <strong>valueString</strong></dd>
   * </dl>
   *
   * @param valueString
   * 	is used as where parameter <strong>:valueString</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteString(String valueString) {
    if (deleteStringPreparedStatement27==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_string=?";
      deleteStringPreparedStatement27 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteStringPreparedStatement27);
    _contentValues.addWhereArgs((valueString==null?"":valueString));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_string=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteStringPreparedStatement27, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_time=:valueTime</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueTime</dt><dd>is mapped to method's parameter <strong>valueTime</strong></dd>
   * </dl>
   *
   * @param valueTime
   * 	is used as where parameter <strong>:valueTime</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteTime(Time valueTime) {
    if (deleteTimePreparedStatement28==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_time=?";
      deleteTimePreparedStatement28 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteTimePreparedStatement28);
    _contentValues.addWhereArgs((valueTime==null?"":SQLTimeUtils.write(valueTime)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_time=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteTimePreparedStatement28, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_time_zone=:valueTimeZone</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueTimeZone</dt><dd>is mapped to method's parameter <strong>valueTimeZone</strong></dd>
   * </dl>
   *
   * @param valueTimeZone
   * 	is used as where parameter <strong>:valueTimeZone</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteTimeZone(TimeZone valueTimeZone) {
    if (deleteTimeZonePreparedStatement29==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_time_zone=?";
      deleteTimeZonePreparedStatement29 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteTimeZonePreparedStatement29);
    _contentValues.addWhereArgs((valueTimeZone==null?"":TimeZoneUtils.write(valueTimeZone)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_time_zone=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteTimeZonePreparedStatement29, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean64 WHERE value_url=:valueUrl</pre>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueUrl</dt><dd>is mapped to method's parameter <strong>valueUrl</strong></dd>
   * </dl>
   *
   * @param valueUrl
   * 	is used as where parameter <strong>:valueUrl</strong>
   *
   * @return number of deleted records
   */
  @Override
  public long deleteURL(URL valueUrl) {
    if (deleteURLPreparedStatement30==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean64 WHERE value_url=?";
      deleteURLPreparedStatement30 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteURLPreparedStatement30);
    _contentValues.addWhereArgs((valueUrl==null?"":UrlUtils.write(valueUrl)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean64 WHERE value_url=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseHelper.updateDelete(deleteURLPreparedStatement30, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url) VALUES (:bean.valueBeanArray, :bean.valueBigDecimal, :bean.valueBigInteger, :bean.valueBool, :bean.valueBoolType, :bean.valueByte, :bean.valueByteArray, :bean.valueByteType, :bean.valueCalendar, :bean.valueChar, :bean.valueCharArray, :bean.valueCharList, :bean.valueCharType, :bean.valueCharTypeArray, :bean.valueCurrency, :bean.valueDate, :bean.valueDouble, :bean.valueDoubleType, :bean.valueEnumType, :bean.valueFloat, :bean.valueFloatType, :bean.valueInt, :bean.valueIntType, :bean.valueLinkedMapStringBean, :bean.valueLocale, :bean.valueLong, :bean.valueLongArray, :bean.valueLongList, :bean.valueLongType, :bean.valueLongTypeArray, :bean.valueMapStringBean, :bean.valueSetString, :bean.valueShort, :bean.valueShortType, :bean.valueStrinList, :bean.valueString, :bean.valueStringArray, :bean.valueTime, :bean.valueTimeList, :bean.valueTimeZone, :bean.valueUrl)</pre>
   *
   * <p><code>bean.id</code> is automatically updated because it is the primary key</p>
   *
   * <p><strong>Inserted columns:</strong></p>
   * <dl>
   * 	<dt>value_bean_array</dt><dd>is mapped to <strong>:bean.valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is mapped to <strong>:bean.valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is mapped to <strong>:bean.valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is mapped to <strong>:bean.valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is mapped to <strong>:bean.valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is mapped to <strong>:bean.valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is mapped to <strong>:bean.valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is mapped to <strong>:bean.valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is mapped to <strong>:bean.valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is mapped to <strong>:bean.valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is mapped to <strong>:bean.valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is mapped to <strong>:bean.valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is mapped to <strong>:bean.valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is mapped to <strong>:bean.valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is mapped to <strong>:bean.valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is mapped to <strong>:bean.valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is mapped to <strong>:bean.valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is mapped to <strong>:bean.valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is mapped to <strong>:bean.valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is mapped to <strong>:bean.valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is mapped to <strong>:bean.valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is mapped to <strong>:bean.valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is mapped to <strong>:bean.valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is mapped to <strong>:bean.valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is mapped to <strong>:bean.valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is mapped to <strong>:bean.valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is mapped to <strong>:bean.valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is mapped to <strong>:bean.valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is mapped to <strong>:bean.valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is mapped to <strong>:bean.valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is mapped to <strong>:bean.valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is mapped to <strong>:bean.valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is mapped to <strong>:bean.valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is mapped to <strong>:bean.valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is mapped to <strong>:bean.valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is mapped to <strong>:bean.valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is mapped to <strong>:bean.valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is mapped to <strong>:bean.valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is mapped to <strong>:bean.valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is mapped to <strong>:bean.valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is mapped to <strong>:bean.valueUrl</strong></dd>
   * </dl>
   *
   * @param bean
   * 	is mapped to parameter <strong>bean</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(Bean64 bean) {
    // Specialized Insert - InsertType - BEGIN
    if (insertPreparedStatement31==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      insertPreparedStatement31 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement31);
    _contentValues.put("value_bean_array", Bean64Table.serializeValueBeanArray(bean.valueBeanArray));
    _contentValues.put("value_big_decimal", bean.valueBigDecimal);
    _contentValues.put("value_big_integer", bean.valueBigInteger);
    _contentValues.put("value_bool", bean.valueBool);
    _contentValues.put("value_bool_type", bean.valueBoolType);
    _contentValues.put("value_byte", bean.valueByte);
    _contentValues.put("value_byte_array", bean.valueByteArray);
    _contentValues.put("value_byte_type", bean.valueByteType);
    _contentValues.put("value_calendar", CalendarUtils.write(bean.valueCalendar));
    _contentValues.put("value_char", bean.valueChar);
    _contentValues.put("value_char_array", Bean64Table.serializeValueCharArray(bean.valueCharArray));
    _contentValues.put("value_char_list", Bean64Table.serializeValueCharList(bean.valueCharList));
    _contentValues.put("value_char_type", bean.valueCharType);
    _contentValues.put("value_char_type_array", Bean64Table.serializeValueCharTypeArray(bean.valueCharTypeArray));
    _contentValues.put("value_currency", CurrencyUtils.write(bean.valueCurrency));
    _contentValues.put("value_date", DateUtils.write(bean.valueDate));
    _contentValues.put("value_double", bean.valueDouble);
    _contentValues.put("value_double_type", bean.valueDoubleType);
    _contentValues.put("value_enum_type", EnumUtils.write(bean.valueEnumType));
    _contentValues.put("value_float", bean.valueFloat);
    _contentValues.put("value_float_type", bean.valueFloatType);
    _contentValues.put("value_int", bean.valueInt);
    _contentValues.put("value_int_type", bean.valueIntType);
    _contentValues.put("value_linked_map_string_bean", Bean64Table.serializeValueLinkedMapStringBean(bean.valueLinkedMapStringBean));
    _contentValues.put("value_locale", LocaleUtils.write(bean.valueLocale));
    _contentValues.put("value_long", bean.valueLong);
    _contentValues.put("value_long_array", Bean64Table.serializeValueLongArray(bean.valueLongArray));
    _contentValues.put("value_long_list", Bean64Table.serializeValueLongList(bean.valueLongList));
    _contentValues.put("value_long_type", bean.valueLongType);
    _contentValues.put("value_long_type_array", Bean64Table.serializeValueLongTypeArray(bean.valueLongTypeArray));
    _contentValues.put("value_map_string_bean", Bean64Table.serializeValueMapStringBean(bean.valueMapStringBean));
    _contentValues.put("value_set_string", Bean64Table.serializeValueSetString(bean.valueSetString));
    _contentValues.put("value_short", bean.valueShort);
    _contentValues.put("value_short_type", bean.valueShortType);
    _contentValues.put("value_strin_list", Bean64Table.serializeValueStrinList(bean.valueStrinList));
    _contentValues.put("value_string", bean.valueString);
    _contentValues.put("value_string_array", Bean64Table.serializeValueStringArray(bean.valueStringArray));
    _contentValues.put("value_time", SQLTimeUtils.write(bean.valueTime));
    _contentValues.put("value_time_list", Bean64Table.serializeValueTimeList(bean.valueTimeList));
    _contentValues.put("value_time_zone", TimeZoneUtils.write(bean.valueTimeZone));
    _contentValues.put("value_url", UrlUtils.write(bean.valueUrl));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertPreparedStatement31, _contentValues);
    // if PK string, can not overwrite id (with a long) same thing if column type is UNMANAGED (user manage PK)
    bean.id=result;

    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_big_decimal) VALUES (:valueBigDecimal)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueBigDecimal</dt><dd>is binded to query's parameter <strong>:valueBigDecimal</strong> and method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>
   *
   * @param valueBigDecimal
   * 	is binded to column value <strong>value_big_decimal</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(BigDecimal valueBigDecimal) {
    // Specialized Insert - InsertType - BEGIN
    if (insertPreparedStatement32==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_big_decimal) VALUES (?)";
      insertPreparedStatement32 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement32);

    _contentValues.put("value_big_decimal", valueBigDecimal);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertPreparedStatement32, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_big_integer) VALUES (:valueBigInteger)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueBigInteger</dt><dd>is binded to query's parameter <strong>:valueBigInteger</strong> and method's parameter <strong>valueBigInteger</strong></dd>
   * </dl>
   *
   * @param valueBigInteger
   * 	is binded to column value <strong>value_big_integer</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(BigInteger valueBigInteger) {
    // Specialized Insert - InsertType - BEGIN
    if (insertPreparedStatement33==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_big_integer) VALUES (?)";
      insertPreparedStatement33 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement33);

    _contentValues.put("value_big_integer", valueBigInteger);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertPreparedStatement33, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_bool_type) VALUES (:valueBoolType)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueBoolType</dt><dd>is binded to query's parameter <strong>:valueBoolType</strong> and method's parameter <strong>valueBoolType</strong></dd>
   * </dl>
   *
   * @param valueBoolType
   * 	is binded to column value <strong>value_bool_type</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(boolean valueBoolType) {
    // Specialized Insert - InsertType - BEGIN
    if (insertPreparedStatement34==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_bool_type) VALUES (?)";
      insertPreparedStatement34 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement34);

    _contentValues.put("value_bool_type", valueBoolType);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertPreparedStatement34, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_bool) VALUES (:valueBool)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueBool</dt><dd>is binded to query's parameter <strong>:valueBool</strong> and method's parameter <strong>valueBool</strong></dd>
   * </dl>
   *
   * @param valueBool
   * 	is binded to column value <strong>value_bool</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(Boolean valueBool) {
    // Specialized Insert - InsertType - BEGIN
    if (insertPreparedStatement35==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_bool) VALUES (?)";
      insertPreparedStatement35 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement35);

    _contentValues.put("value_bool", valueBool);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertPreparedStatement35, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_bean_array) VALUES (:valueBeanArray)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueBeanArray</dt><dd>is binded to query's parameter <strong>:valueBeanArray</strong> and method's parameter <strong>valueBeanArray</strong></dd>
   * </dl>
   *
   * @param valueBeanArray
   * 	is binded to column value <strong>value_bean_array</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertArrayBeanType(Bean64[] valueBeanArray) {
    // Specialized Insert - InsertType - BEGIN
    if (insertArrayBeanTypePreparedStatement36==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_bean_array) VALUES (?)";
      insertArrayBeanTypePreparedStatement36 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertArrayBeanTypePreparedStatement36);

    _contentValues.put("value_bean_array", serializer1(valueBeanArray));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertArrayBeanTypePreparedStatement36, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_long_array) VALUES (:valueLongArray)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLongArray</dt><dd>is binded to query's parameter <strong>:valueLongArray</strong> and method's parameter <strong>valueLongArray</strong></dd>
   * </dl>
   *
   * @param valueLongArray
   * 	is binded to column value <strong>value_long_array</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertArrayLong(Long[] valueLongArray) {
    // Specialized Insert - InsertType - BEGIN
    if (insertArrayLongPreparedStatement37==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_long_array) VALUES (?)";
      insertArrayLongPreparedStatement37 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertArrayLongPreparedStatement37);

    _contentValues.put("value_long_array", serializer2(valueLongArray));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertArrayLongPreparedStatement37, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_long_type_array) VALUES (:valueLongTypeArray)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLongTypeArray</dt><dd>is binded to query's parameter <strong>:valueLongTypeArray</strong> and method's parameter <strong>valueLongTypeArray</strong></dd>
   * </dl>
   *
   * @param valueLongTypeArray
   * 	is binded to column value <strong>value_long_type_array</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertArrayLongType(long[] valueLongTypeArray) {
    // Specialized Insert - InsertType - BEGIN
    if (insertArrayLongTypePreparedStatement38==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_long_type_array) VALUES (?)";
      insertArrayLongTypePreparedStatement38 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertArrayLongTypePreparedStatement38);

    _contentValues.put("value_long_type_array", serializer3(valueLongTypeArray));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertArrayLongTypePreparedStatement38, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_byte) VALUES (:valueByte)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueByte</dt><dd>is binded to query's parameter <strong>:valueByte</strong> and method's parameter <strong>valueByte</strong></dd>
   * </dl>
   *
   * @param valueByte
   * 	is binded to column value <strong>value_byte</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertByte(Byte valueByte) {
    // Specialized Insert - InsertType - BEGIN
    if (insertBytePreparedStatement39==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_byte) VALUES (?)";
      insertBytePreparedStatement39 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertBytePreparedStatement39);

    _contentValues.put("value_byte", valueByte);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertBytePreparedStatement39, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_byte_type) VALUES (:valueByteType)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueByteType</dt><dd>is binded to query's parameter <strong>:valueByteType</strong> and method's parameter <strong>valueByteType</strong></dd>
   * </dl>
   *
   * @param valueByteType
   * 	is binded to column value <strong>value_byte_type</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertByteType(byte valueByteType) {
    // Specialized Insert - InsertType - BEGIN
    if (insertByteTypePreparedStatement40==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_byte_type) VALUES (?)";
      insertByteTypePreparedStatement40 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertByteTypePreparedStatement40);

    _contentValues.put("value_byte_type", valueByteType);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertByteTypePreparedStatement40, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_calendar) VALUES (:valueCalendar)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueCalendar</dt><dd>is binded to query's parameter <strong>:valueCalendar</strong> and method's parameter <strong>valueCalendar</strong></dd>
   * </dl>
   *
   * @param valueCalendar
   * 	is binded to column value <strong>value_calendar</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertCalendar(Calendar valueCalendar) {
    // Specialized Insert - InsertType - BEGIN
    if (insertCalendarPreparedStatement41==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_calendar) VALUES (?)";
      insertCalendarPreparedStatement41 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertCalendarPreparedStatement41);

    _contentValues.put("value_calendar", CalendarUtils.write(valueCalendar));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertCalendarPreparedStatement41, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_char) VALUES (:valueChar)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueChar</dt><dd>is binded to query's parameter <strong>:valueChar</strong> and method's parameter <strong>valueChar</strong></dd>
   * </dl>
   *
   * @param valueChar
   * 	is binded to column value <strong>value_char</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertChar(Character valueChar) {
    // Specialized Insert - InsertType - BEGIN
    if (insertCharPreparedStatement42==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_char) VALUES (?)";
      insertCharPreparedStatement42 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertCharPreparedStatement42);

    _contentValues.put("value_char", valueChar);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertCharPreparedStatement42, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_char_type) VALUES (:valueCharType)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueCharType</dt><dd>is binded to query's parameter <strong>:valueCharType</strong> and method's parameter <strong>valueCharType</strong></dd>
   * </dl>
   *
   * @param valueCharType
   * 	is binded to column value <strong>value_char_type</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertCharType(char valueCharType) {
    // Specialized Insert - InsertType - BEGIN
    if (insertCharTypePreparedStatement43==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_char_type) VALUES (?)";
      insertCharTypePreparedStatement43 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertCharTypePreparedStatement43);

    _contentValues.put("value_char_type", valueCharType);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertCharTypePreparedStatement43, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_currency) VALUES (:valueCurrency)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueCurrency</dt><dd>is binded to query's parameter <strong>:valueCurrency</strong> and method's parameter <strong>valueCurrency</strong></dd>
   * </dl>
   *
   * @param valueCurrency
   * 	is binded to column value <strong>value_currency</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertCurrency(Currency valueCurrency) {
    // Specialized Insert - InsertType - BEGIN
    if (insertCurrencyPreparedStatement44==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_currency) VALUES (?)";
      insertCurrencyPreparedStatement44 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertCurrencyPreparedStatement44);

    _contentValues.put("value_currency", CurrencyUtils.write(valueCurrency));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertCurrencyPreparedStatement44, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_date) VALUES (:valueDate)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueDate</dt><dd>is binded to query's parameter <strong>:valueDate</strong> and method's parameter <strong>valueDate</strong></dd>
   * </dl>
   *
   * @param valueDate
   * 	is binded to column value <strong>value_date</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertDate(Date valueDate) {
    // Specialized Insert - InsertType - BEGIN
    if (insertDatePreparedStatement45==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_date) VALUES (?)";
      insertDatePreparedStatement45 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertDatePreparedStatement45);

    _contentValues.put("value_date", DateUtils.write(valueDate));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertDatePreparedStatement45, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_double) VALUES (:valueDouble)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueDouble</dt><dd>is binded to query's parameter <strong>:valueDouble</strong> and method's parameter <strong>valueDouble</strong></dd>
   * </dl>
   *
   * @param valueDouble
   * 	is binded to column value <strong>value_double</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertDouble(Double valueDouble) {
    // Specialized Insert - InsertType - BEGIN
    if (insertDoublePreparedStatement46==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_double) VALUES (?)";
      insertDoublePreparedStatement46 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertDoublePreparedStatement46);

    _contentValues.put("value_double", valueDouble);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertDoublePreparedStatement46, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_double_type) VALUES (:valueDoubleType)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueDoubleType</dt><dd>is binded to query's parameter <strong>:valueDoubleType</strong> and method's parameter <strong>valueDoubleType</strong></dd>
   * </dl>
   *
   * @param valueDoubleType
   * 	is binded to column value <strong>value_double_type</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertDoubleType(double valueDoubleType) {
    // Specialized Insert - InsertType - BEGIN
    if (insertDoubleTypePreparedStatement47==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_double_type) VALUES (?)";
      insertDoubleTypePreparedStatement47 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertDoubleTypePreparedStatement47);

    _contentValues.put("value_double_type", valueDoubleType);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertDoubleTypePreparedStatement47, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_enum_type) VALUES (:valueEnumType)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueEnumType</dt><dd>is binded to query's parameter <strong>:valueEnumType</strong> and method's parameter <strong>valueEnumType</strong></dd>
   * </dl>
   *
   * @param valueEnumType
   * 	is binded to column value <strong>value_enum_type</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertEnumType(EnumType valueEnumType) {
    // Specialized Insert - InsertType - BEGIN
    if (insertEnumTypePreparedStatement48==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_enum_type) VALUES (?)";
      insertEnumTypePreparedStatement48 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertEnumTypePreparedStatement48);

    _contentValues.put("value_enum_type", EnumUtils.write(valueEnumType));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertEnumTypePreparedStatement48, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_float) VALUES (:valueFloat)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueFloat</dt><dd>is binded to query's parameter <strong>:valueFloat</strong> and method's parameter <strong>valueFloat</strong></dd>
   * </dl>
   *
   * @param valueFloat
   * 	is binded to column value <strong>value_float</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertFloat(Float valueFloat) {
    // Specialized Insert - InsertType - BEGIN
    if (insertFloatPreparedStatement49==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_float) VALUES (?)";
      insertFloatPreparedStatement49 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertFloatPreparedStatement49);

    _contentValues.put("value_float", valueFloat);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertFloatPreparedStatement49, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_float_type) VALUES (:valueFloatType)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueFloatType</dt><dd>is binded to query's parameter <strong>:valueFloatType</strong> and method's parameter <strong>valueFloatType</strong></dd>
   * </dl>
   *
   * @param valueFloatType
   * 	is binded to column value <strong>value_float_type</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertFloatType(float valueFloatType) {
    // Specialized Insert - InsertType - BEGIN
    if (insertFloatTypePreparedStatement50==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_float_type) VALUES (?)";
      insertFloatTypePreparedStatement50 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertFloatTypePreparedStatement50);

    _contentValues.put("value_float_type", valueFloatType);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertFloatTypePreparedStatement50, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_int) VALUES (:valueInt)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueInt</dt><dd>is binded to query's parameter <strong>:valueInt</strong> and method's parameter <strong>valueInt</strong></dd>
   * </dl>
   *
   * @param valueInt
   * 	is binded to column value <strong>value_int</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertInt(Integer valueInt) {
    // Specialized Insert - InsertType - BEGIN
    if (insertIntPreparedStatement51==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_int) VALUES (?)";
      insertIntPreparedStatement51 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertIntPreparedStatement51);

    _contentValues.put("value_int", valueInt);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertIntPreparedStatement51, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_int_type) VALUES (:valueIntType)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueIntType</dt><dd>is binded to query's parameter <strong>:valueIntType</strong> and method's parameter <strong>valueIntType</strong></dd>
   * </dl>
   *
   * @param valueIntType
   * 	is binded to column value <strong>value_int_type</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertIntType(int valueIntType) {
    // Specialized Insert - InsertType - BEGIN
    if (insertIntTypePreparedStatement52==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_int_type) VALUES (?)";
      insertIntTypePreparedStatement52 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertIntTypePreparedStatement52);

    _contentValues.put("value_int_type", valueIntType);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertIntTypePreparedStatement52, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_long_list) VALUES (:valueLongList)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLongList</dt><dd>is binded to query's parameter <strong>:valueLongList</strong> and method's parameter <strong>valueLongList</strong></dd>
   * </dl>
   *
   * @param valueLongList
   * 	is binded to column value <strong>value_long_list</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertListLong(LinkedList<Long> valueLongList) {
    // Specialized Insert - InsertType - BEGIN
    if (insertListLongPreparedStatement53==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_long_list) VALUES (?)";
      insertListLongPreparedStatement53 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertListLongPreparedStatement53);

    _contentValues.put("value_long_list", serializer4(valueLongList));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertListLongPreparedStatement53, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_locale) VALUES (:valueLocale)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLocale</dt><dd>is binded to query's parameter <strong>:valueLocale</strong> and method's parameter <strong>valueLocale</strong></dd>
   * </dl>
   *
   * @param valueLocale
   * 	is binded to column value <strong>value_locale</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertLocale(Locale valueLocale) {
    // Specialized Insert - InsertType - BEGIN
    if (insertLocalePreparedStatement54==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_locale) VALUES (?)";
      insertLocalePreparedStatement54 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertLocalePreparedStatement54);

    _contentValues.put("value_locale", LocaleUtils.write(valueLocale));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertLocalePreparedStatement54, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_long) VALUES (:valueLong)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLong</dt><dd>is binded to query's parameter <strong>:valueLong</strong> and method's parameter <strong>valueLong</strong></dd>
   * </dl>
   *
   * @param valueLong
   * 	is binded to column value <strong>value_long</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertLong(Long valueLong) {
    // Specialized Insert - InsertType - BEGIN
    if (insertLongPreparedStatement55==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_long) VALUES (?)";
      insertLongPreparedStatement55 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertLongPreparedStatement55);

    _contentValues.put("value_long", valueLong);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertLongPreparedStatement55, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_long_type) VALUES (:valueLongType)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLongType</dt><dd>is binded to query's parameter <strong>:valueLongType</strong> and method's parameter <strong>valueLongType</strong></dd>
   * </dl>
   *
   * @param valueLongType
   * 	is binded to column value <strong>value_long_type</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertLongType(long valueLongType) {
    // Specialized Insert - InsertType - BEGIN
    if (insertLongTypePreparedStatement56==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_long_type) VALUES (?)";
      insertLongTypePreparedStatement56 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertLongTypePreparedStatement56);

    _contentValues.put("value_long_type", valueLongType);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertLongTypePreparedStatement56, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_short) VALUES (:valueShort)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueShort</dt><dd>is binded to query's parameter <strong>:valueShort</strong> and method's parameter <strong>valueShort</strong></dd>
   * </dl>
   *
   * @param valueShort
   * 	is binded to column value <strong>value_short</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertShort(Short valueShort) {
    // Specialized Insert - InsertType - BEGIN
    if (insertShortPreparedStatement57==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_short) VALUES (?)";
      insertShortPreparedStatement57 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertShortPreparedStatement57);

    _contentValues.put("value_short", valueShort);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertShortPreparedStatement57, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_short_type) VALUES (:valueShortType)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueShortType</dt><dd>is binded to query's parameter <strong>:valueShortType</strong> and method's parameter <strong>valueShortType</strong></dd>
   * </dl>
   *
   * @param valueShortType
   * 	is binded to column value <strong>value_short_type</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertShortType(short valueShortType) {
    // Specialized Insert - InsertType - BEGIN
    if (insertShortTypePreparedStatement58==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_short_type) VALUES (?)";
      insertShortTypePreparedStatement58 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertShortTypePreparedStatement58);

    _contentValues.put("value_short_type", valueShortType);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertShortTypePreparedStatement58, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_string) VALUES (:valueString)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueString</dt><dd>is binded to query's parameter <strong>:valueString</strong> and method's parameter <strong>valueString</strong></dd>
   * </dl>
   *
   * @param valueString
   * 	is binded to column value <strong>value_string</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertString(String valueString) {
    // Specialized Insert - InsertType - BEGIN
    if (insertStringPreparedStatement59==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_string) VALUES (?)";
      insertStringPreparedStatement59 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertStringPreparedStatement59);

    _contentValues.put("value_string", valueString);

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertStringPreparedStatement59, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_time) VALUES (:valueTime)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueTime</dt><dd>is binded to query's parameter <strong>:valueTime</strong> and method's parameter <strong>valueTime</strong></dd>
   * </dl>
   *
   * @param valueTime
   * 	is binded to column value <strong>value_time</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertTime(Time valueTime) {
    // Specialized Insert - InsertType - BEGIN
    if (insertTimePreparedStatement60==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_time) VALUES (?)";
      insertTimePreparedStatement60 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertTimePreparedStatement60);

    _contentValues.put("value_time", SQLTimeUtils.write(valueTime));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertTimePreparedStatement60, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_time_zone) VALUES (:valueTimeZone)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueTimeZone</dt><dd>is binded to query's parameter <strong>:valueTimeZone</strong> and method's parameter <strong>valueTimeZone</strong></dd>
   * </dl>
   *
   * @param valueTimeZone
   * 	is binded to column value <strong>value_time_zone</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertTimeZone(TimeZone valueTimeZone) {
    // Specialized Insert - InsertType - BEGIN
    if (insertTimeZonePreparedStatement61==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_time_zone) VALUES (?)";
      insertTimeZonePreparedStatement61 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertTimeZonePreparedStatement61);

    _contentValues.put("value_time_zone", TimeZoneUtils.write(valueTimeZone));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertTimeZonePreparedStatement61, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean64 (value_url) VALUES (:valueUrl)</pre>
   *
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueUrl</dt><dd>is binded to query's parameter <strong>:valueUrl</strong> and method's parameter <strong>valueUrl</strong></dd>
   * </dl>
   *
   * @param valueUrl
   * 	is binded to column value <strong>value_url</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertURL(URL valueUrl) {
    // Specialized Insert - InsertType - BEGIN
    if (insertURLPreparedStatement62==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean64 (value_url) VALUES (?)";
      insertURLPreparedStatement62 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertURLPreparedStatement62);

    _contentValues.put("value_url", UrlUtils.write(valueUrl));

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
      Logger.info("INSERT INTO bean64 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

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
    long result = KriptonDatabaseHelper.insert(insertURLPreparedStatement62, _contentValues);
    return result;
    // Specialized Insert - InsertType - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE id = ${id}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:id</dt><dd>is binded to method's parameter <strong>id</strong></dd>
   * </dl>
   *
   * @param id
   * 	is binded to <code>:id</code>
   * @return collection of bean or empty collection.
   */
  @Override
  public List<Bean64> selectList(long id) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_LIST_SQL1;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(id));
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
      // Specialized part - SelectBeanListHelper - BEGIN

      ArrayList<Bean64> resultList=new ArrayList<Bean64>(_cursor.getCount());
      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        do
         {
          resultBean=new Bean64();

          resultBean.id=_cursor.getLong(index0);
          if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
          if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
          if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
          if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
          if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
          if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
          if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
          if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
          if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
          if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
          if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
          if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
          if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
          if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
          if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
          if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
          if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
          if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
          if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
          if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
          if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
          if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
          if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
          if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
          if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
          if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
          if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
          if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
          if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
          if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
          if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
          if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
          if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
          if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
          if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
          if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
          if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
          if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
          if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
          if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
          if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

          resultList.add(resultBean);
        } while (_cursor.moveToNext());
      }

      return resultList;
    }
    // Specialized part - SelectBeanListHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOne() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL2;
    // add where arguments
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_big_decimal=${valueBigDecimal}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueBigDecimal</dt><dd>is binded to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>
   *
   * @param valueBigDecimal
   * 	is binded to <code>:valueBigDecimal</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOne(BigDecimal valueBigDecimal) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL3;
    // add where arguments
    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toPlainString()));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_big_decimal=${valueBigDecimal}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueBigDecimal</dt><dd>is binded to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>
   *
   * @param valueBigDecimal
   * 	is binded to <code>:valueBigDecimal</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOne(BigInteger valueBigDecimal) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL4;
    // add where arguments
    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toString()));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_bool_type=${valueBoolType}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueBoolType</dt><dd>is binded to method's parameter <strong>valueBoolType</strong></dd>
   * </dl>
   *
   * @param valueBoolType
   * 	is binded to <code>:valueBoolType</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOne(boolean valueBoolType) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL5;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueBoolType));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_bool=${valueBool}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueBool</dt><dd>is binded to method's parameter <strong>valueBool</strong></dd>
   * </dl>
   *
   * @param valueBool
   * 	is binded to <code>:valueBool</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOne(Boolean valueBool) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL6;
    // add where arguments
    _contentValues.addWhereArgs((valueBool==null?"":String.valueOf(valueBool)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE id = ${id}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:id</dt><dd>is binded to method's parameter <strong>id</strong></dd>
   * </dl>
   *
   * @param id
   * 	is binded to <code>:id</code>
   * @param listener
   * 	is the Bean64 listener
   */
  @Override
  public void selectOne(int id, OnReadBeanListener<Bean64> listener) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL7;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(id));
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
      // Specialized part - SelectBeanListenerHelper - BEGIN
      Bean64 resultBean=new Bean64();
      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        int rowCount=_cursor.getCount();
        do
         {
          // reset mapping
          // id does not need reset (it will be taken from db)
          resultBean.valueBeanArray=null;
          resultBean.valueBigDecimal=null;
          resultBean.valueBigInteger=null;
          resultBean.valueBool=null;
          resultBean.valueBoolType=false;
          resultBean.valueByte=null;
          resultBean.valueByteArray=null;
          resultBean.valueByteType=0;
          resultBean.valueCalendar=null;
          resultBean.valueChar=null;
          resultBean.valueCharArray=null;
          resultBean.valueCharList=null;
          resultBean.valueCharType=0;
          resultBean.valueCharTypeArray=null;
          resultBean.valueCurrency=null;
          resultBean.valueDate=null;
          resultBean.valueDouble=null;
          resultBean.valueDoubleType=0;
          resultBean.valueEnumType=null;
          resultBean.valueFloat=null;
          resultBean.valueFloatType=0f;
          resultBean.valueInt=null;
          resultBean.valueIntType=0;
          resultBean.valueLinkedMapStringBean=null;
          resultBean.valueLocale=null;
          resultBean.valueLong=null;
          resultBean.valueLongArray=null;
          resultBean.valueLongList=null;
          resultBean.valueLongType=0L;
          resultBean.valueLongTypeArray=null;
          resultBean.valueMapStringBean=null;
          resultBean.valueSetString=null;
          resultBean.valueShort=null;
          resultBean.valueShortType=0;
          resultBean.valueStrinList=null;
          resultBean.valueString=null;
          resultBean.valueStringArray=null;
          resultBean.valueTime=null;
          resultBean.valueTimeList=null;
          resultBean.valueTimeZone=null;
          resultBean.valueUrl=null;

          // generate mapping
          resultBean.id=_cursor.getLong(index0);
          if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
          if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
          if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
          if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
          if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
          if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
          if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
          if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
          if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
          if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
          if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
          if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
          if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
          if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
          if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
          if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
          if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
          if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
          if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
          if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
          if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
          if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
          if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
          if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
          if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
          if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
          if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
          if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
          if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
          if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
          if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
          if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
          if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
          if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
          if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
          if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
          if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
          if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
          if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
          if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
          if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

          listener.onRead(resultBean, _cursor.getPosition(), rowCount);
        } while (_cursor.moveToNext());
      }
    }
    // Specialized part - SelectBeanListenerHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE id = ${id}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:id</dt><dd>is binded to method's parameter <strong>id</strong></dd>
   * </dl>
   *
   * @param id
   * 	is binded to <code>:id</code>
   * @param listener
   * 	is the cursor listener
   */
  @Override
  public void selectOne(long id, OnReadCursorListener listener) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL8;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(id));
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
      // Specialized part - SelectRawListenerHelper - BEGIN

      if (_cursor.moveToFirst()) {

        do
         {
          listener.onRead(_cursor);
        } while (_cursor.moveToNext());
      }
    }
    // Specialized part - SelectRawListenerHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_bean_array=${valueBeanArray}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueBeanArray</dt><dd>is binded to method's parameter <strong>valueBeanArray</strong></dd>
   * </dl>
   *
   * @param valueBeanArray
   * 	is binded to <code>:valueBeanArray</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneArrayBeanType(Bean64[] valueBeanArray) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_ARRAY_BEAN_TYPE_SQL9;
    // add where arguments
    _contentValues.addWhereArgs((valueBeanArray==null?"":new String(serializer1(valueBeanArray),StandardCharsets.UTF_8)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_long_array=${valueLongArray}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueLongArray</dt><dd>is binded to method's parameter <strong>valueLongArray</strong></dd>
   * </dl>
   *
   * @param valueLongArray
   * 	is binded to <code>:valueLongArray</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneArrayLong(Long[] valueLongArray) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_ARRAY_LONG_SQL10;
    // add where arguments
    _contentValues.addWhereArgs((valueLongArray==null?"":new String(serializer2(valueLongArray),StandardCharsets.UTF_8)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_long_type_array=${valueLongTypeArray}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueLongTypeArray</dt><dd>is binded to method's parameter <strong>valueLongTypeArray</strong></dd>
   * </dl>
   *
   * @param valueLongTypeArray
   * 	is binded to <code>:valueLongTypeArray</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneArrayLongType(long[] valueLongTypeArray) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_ARRAY_LONG_TYPE_SQL11;
    // add where arguments
    _contentValues.addWhereArgs((valueLongTypeArray==null?"":new String(serializer3(valueLongTypeArray),StandardCharsets.UTF_8)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_byte=${valueByte}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueByte</dt><dd>is binded to method's parameter <strong>valueByte</strong></dd>
   * </dl>
   *
   * @param valueByte
   * 	is binded to <code>:valueByte</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneByte(Byte valueByte) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_BYTE_SQL12;
    // add where arguments
    _contentValues.addWhereArgs((valueByte==null?"":String.valueOf(valueByte)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_byte_type=${valueByteType}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueByteType</dt><dd>is binded to method's parameter <strong>valueByteType</strong></dd>
   * </dl>
   *
   * @param valueByteType
   * 	is binded to <code>:valueByteType</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneByteType(boolean valueByteType) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_BYTE_TYPE_SQL13;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueByteType));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_calendar=${valueCalendar}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueCalendar</dt><dd>is binded to method's parameter <strong>valueCalendar</strong></dd>
   * </dl>
   *
   * @param valueCalendar
   * 	is binded to <code>:valueCalendar</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneCalendar(Calendar valueCalendar) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_CALENDAR_SQL14;
    // add where arguments
    _contentValues.addWhereArgs((valueCalendar==null?"":CalendarUtils.write(valueCalendar)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_char_type=${valueChar}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueChar</dt><dd>is binded to method's parameter <strong>valueChar</strong></dd>
   * </dl>
   *
   * @param valueChar
   * 	is binded to <code>:valueChar</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneChar(Character valueChar) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_CHAR_SQL15;
    // add where arguments
    _contentValues.addWhereArgs((valueChar==null?"":String.valueOf(valueChar)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_char_type=${valueCharType}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueCharType</dt><dd>is binded to method's parameter <strong>valueCharType</strong></dd>
   * </dl>
   *
   * @param valueCharType
   * 	is binded to <code>:valueCharType</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneCharType(char valueCharType) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_CHAR_TYPE_SQL16;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueCharType));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_currency=${valueCurrency}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueCurrency</dt><dd>is binded to method's parameter <strong>valueCurrency</strong></dd>
   * </dl>
   *
   * @param valueCurrency
   * 	is binded to <code>:valueCurrency</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneCurrencye(Currency valueCurrency) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_CURRENCYE_SQL17;
    // add where arguments
    _contentValues.addWhereArgs((valueCurrency==null?"":CurrencyUtils.write(valueCurrency)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_date=${valueDate}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueDate</dt><dd>is binded to method's parameter <strong>valueDate</strong></dd>
   * </dl>
   *
   * @param valueDate
   * 	is binded to <code>:valueDate</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneDate(Date valueDate) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_DATE_SQL18;
    // add where arguments
    _contentValues.addWhereArgs((valueDate==null?"":DateUtils.write(valueDate)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_double=${valueDouble}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueDouble</dt><dd>is binded to method's parameter <strong>valueDouble</strong></dd>
   * </dl>
   *
   * @param valueDouble
   * 	is binded to <code>:valueDouble</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneDouble(Double valueDouble) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_DOUBLE_SQL19;
    // add where arguments
    _contentValues.addWhereArgs((valueDouble==null?"":String.valueOf(valueDouble)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_double_type=${valueDoubleType}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueDoubleType</dt><dd>is binded to method's parameter <strong>valueDoubleType</strong></dd>
   * </dl>
   *
   * @param valueDoubleType
   * 	is binded to <code>:valueDoubleType</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneDoubleType(double valueDoubleType) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_DOUBLE_TYPE_SQL20;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueDoubleType));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_enum_type=${valueEnumType}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueEnumType</dt><dd>is binded to method's parameter <strong>valueEnumType</strong></dd>
   * </dl>
   *
   * @param valueEnumType
   * 	is binded to <code>:valueEnumType</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneEnumType(EnumType valueEnumType) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_ENUM_TYPE_SQL21;
    // add where arguments
    _contentValues.addWhereArgs((valueEnumType==null?"":EnumUtils.write(valueEnumType)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_float=${valueFloat}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueFloat</dt><dd>is binded to method's parameter <strong>valueFloat</strong></dd>
   * </dl>
   *
   * @param valueFloat
   * 	is binded to <code>:valueFloat</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneFloat(Float valueFloat) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_FLOAT_SQL22;
    // add where arguments
    _contentValues.addWhereArgs((valueFloat==null?"":String.valueOf(valueFloat)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_float_type=${valueFloatType}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueFloatType</dt><dd>is binded to method's parameter <strong>valueFloatType</strong></dd>
   * </dl>
   *
   * @param valueFloatType
   * 	is binded to <code>:valueFloatType</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneFloatType(float valueFloatType) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_FLOAT_TYPE_SQL23;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueFloatType));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_int=${valueInt}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueInt</dt><dd>is binded to method's parameter <strong>valueInt</strong></dd>
   * </dl>
   *
   * @param valueInt
   * 	is binded to <code>:valueInt</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneInt(Integer valueInt) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_INT_SQL24;
    // add where arguments
    _contentValues.addWhereArgs((valueInt==null?"":String.valueOf(valueInt)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_int_type=${valueIntType}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueIntType</dt><dd>is binded to method's parameter <strong>valueIntType</strong></dd>
   * </dl>
   *
   * @param valueIntType
   * 	is binded to <code>:valueIntType</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneIntType(int valueIntType) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_INT_TYPE_SQL25;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueIntType));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_long_list=${valueLongList}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueLongList</dt><dd>is binded to method's parameter <strong>valueLongList</strong></dd>
   * </dl>
   *
   * @param valueLongList
   * 	is binded to <code>:valueLongList</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneListLong(LinkedList<Long> valueLongList) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_LIST_LONG_SQL26;
    // add where arguments
    _contentValues.addWhereArgs((valueLongList==null?"":new String(serializer4(valueLongList),StandardCharsets.UTF_8)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_locale=${valueLocale}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueLocale</dt><dd>is binded to method's parameter <strong>valueLocale</strong></dd>
   * </dl>
   *
   * @param valueLocale
   * 	is binded to <code>:valueLocale</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneLocale(Calendar valueLocale) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_LOCALE_SQL27;
    // add where arguments
    _contentValues.addWhereArgs((valueLocale==null?"":CalendarUtils.write(valueLocale)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_long=${valueLong}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueLong</dt><dd>is binded to method's parameter <strong>valueLong</strong></dd>
   * </dl>
   *
   * @param valueLong
   * 	is binded to <code>:valueLong</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneLong(Long valueLong) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_LONG_SQL28;
    // add where arguments
    _contentValues.addWhereArgs((valueLong==null?"":String.valueOf(valueLong)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_long_type=${valueLongType}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueLongType</dt><dd>is binded to method's parameter <strong>valueLongType</strong></dd>
   * </dl>
   *
   * @param valueLongType
   * 	is binded to <code>:valueLongType</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneLongType(long valueLongType) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_LONG_TYPE_SQL29;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueLongType));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_short=${valueShort}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueShort</dt><dd>is binded to method's parameter <strong>valueShort</strong></dd>
   * </dl>
   *
   * @param valueShort
   * 	is binded to <code>:valueShort</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneShort(Short valueShort) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SHORT_SQL30;
    // add where arguments
    _contentValues.addWhereArgs((valueShort==null?"":String.valueOf(valueShort)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_short_type=${valueShortType}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueShortType</dt><dd>is binded to method's parameter <strong>valueShortType</strong></dd>
   * </dl>
   *
   * @param valueShortType
   * 	is binded to <code>:valueShortType</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneShortType(short valueShortType) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SHORT_TYPE_SQL31;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueShortType));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_string=${valueString}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueString</dt><dd>is binded to method's parameter <strong>valueString</strong></dd>
   * </dl>
   *
   * @param valueString
   * 	is binded to <code>:valueString</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneString(String valueString) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_STRING_SQL32;
    // add where arguments
    _contentValues.addWhereArgs((valueString==null?"":valueString));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_time=${valueTime}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueTime</dt><dd>is binded to method's parameter <strong>valueTime</strong></dd>
   * </dl>
   *
   * @param valueTime
   * 	is binded to <code>:valueTime</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneTime(Time valueTime) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_TIME_SQL33;
    // add where arguments
    _contentValues.addWhereArgs((valueTime==null?"":SQLTimeUtils.write(valueTime)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_time_zone=${valueTimeZone}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueTimeZone</dt><dd>is binded to method's parameter <strong>valueTimeZone</strong></dd>
   * </dl>
   *
   * @param valueTimeZone
   * 	is binded to <code>:valueTimeZone</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneTimeZone(TimeZone valueTimeZone) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_TIME_ZONE_SQL34;
    // add where arguments
    _contentValues.addWhereArgs((valueTimeZone==null?"":TimeZoneUtils.write(valueTimeZone)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT id, value_bean_array, value_big_decimal, value_big_integer, value_bool, value_bool_type, value_byte, value_byte_array, value_byte_type, value_calendar, value_char, value_char_array, value_char_list, value_char_type, value_char_type_array, value_currency, value_date, value_double, value_double_type, value_enum_type, value_float, value_float_type, value_int, value_int_type, value_linked_map_string_bean, value_locale, value_long, value_long_array, value_long_list, value_long_type, value_long_type_array, value_map_string_bean, value_set_string, value_short, value_short_type, value_strin_list, value_string, value_string_array, value_time, value_time_list, value_time_zone, value_url FROM bean64 WHERE value_url=${valueUrl}</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>:valueUrl</dt><dd>is binded to method's parameter <strong>valueUrl</strong></dd>
   * </dl>
   *
   * @param valueUrl
   * 	is binded to <code>:valueUrl</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean64 selectOneURL(URL valueUrl) {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_U_R_L_SQL35;
    // add where arguments
    _contentValues.addWhereArgs((valueUrl==null?"":UrlUtils.write(valueUrl)));
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

      Bean64 resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("id");
        int index1=_cursor.getColumnIndex("value_bean_array");
        int index2=_cursor.getColumnIndex("value_big_decimal");
        int index3=_cursor.getColumnIndex("value_big_integer");
        int index4=_cursor.getColumnIndex("value_bool");
        int index5=_cursor.getColumnIndex("value_bool_type");
        int index6=_cursor.getColumnIndex("value_byte");
        int index7=_cursor.getColumnIndex("value_byte_array");
        int index8=_cursor.getColumnIndex("value_byte_type");
        int index9=_cursor.getColumnIndex("value_calendar");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_char_array");
        int index12=_cursor.getColumnIndex("value_char_list");
        int index13=_cursor.getColumnIndex("value_char_type");
        int index14=_cursor.getColumnIndex("value_char_type_array");
        int index15=_cursor.getColumnIndex("value_currency");
        int index16=_cursor.getColumnIndex("value_date");
        int index17=_cursor.getColumnIndex("value_double");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_enum_type");
        int index20=_cursor.getColumnIndex("value_float");
        int index21=_cursor.getColumnIndex("value_float_type");
        int index22=_cursor.getColumnIndex("value_int");
        int index23=_cursor.getColumnIndex("value_int_type");
        int index24=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index25=_cursor.getColumnIndex("value_locale");
        int index26=_cursor.getColumnIndex("value_long");
        int index27=_cursor.getColumnIndex("value_long_array");
        int index28=_cursor.getColumnIndex("value_long_list");
        int index29=_cursor.getColumnIndex("value_long_type");
        int index30=_cursor.getColumnIndex("value_long_type_array");
        int index31=_cursor.getColumnIndex("value_map_string_bean");
        int index32=_cursor.getColumnIndex("value_set_string");
        int index33=_cursor.getColumnIndex("value_short");
        int index34=_cursor.getColumnIndex("value_short_type");
        int index35=_cursor.getColumnIndex("value_strin_list");
        int index36=_cursor.getColumnIndex("value_string");
        int index37=_cursor.getColumnIndex("value_string_array");
        int index38=_cursor.getColumnIndex("value_time");
        int index39=_cursor.getColumnIndex("value_time_list");
        int index40=_cursor.getColumnIndex("value_time_zone");
        int index41=_cursor.getColumnIndex("value_url");

        resultBean=new Bean64();

        resultBean.id=_cursor.getLong(index0);
        if (!_cursor.isNull(index1)) { resultBean.valueBeanArray=Bean64Table.parseValueBeanArray(_cursor.getBlob(index1)); }
        if (!_cursor.isNull(index2)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index2)); }
        if (!_cursor.isNull(index3)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index3)); }
        if (!_cursor.isNull(index4)) { resultBean.valueBool=_cursor.getInt(index4)==0?false:true; }
        if (!_cursor.isNull(index5)) { resultBean.valueBoolType=_cursor.getInt(index5)==0?false:true; }
        if (!_cursor.isNull(index6)) { resultBean.valueByte=(byte)_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueByteArray=_cursor.getBlob(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueByteType=(byte)_cursor.getInt(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index9)); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueCharArray=Bean64Table.parseValueCharArray(_cursor.getBlob(index11)); }
        if (!_cursor.isNull(index12)) { resultBean.valueCharList=Bean64Table.parseValueCharList(_cursor.getBlob(index12)); }
        if (!_cursor.isNull(index13)) { resultBean.valueCharType=(char)_cursor.getInt(index13); }
        if (!_cursor.isNull(index14)) { resultBean.valueCharTypeArray=Bean64Table.parseValueCharTypeArray(_cursor.getBlob(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index16)); }
        if (!_cursor.isNull(index17)) { resultBean.valueDouble=_cursor.getDouble(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index19)); }
        if (!_cursor.isNull(index20)) { resultBean.valueFloat=_cursor.getFloat(index20); }
        if (!_cursor.isNull(index21)) { resultBean.valueFloatType=_cursor.getFloat(index21); }
        if (!_cursor.isNull(index22)) { resultBean.valueInt=_cursor.getInt(index22); }
        if (!_cursor.isNull(index23)) { resultBean.valueIntType=_cursor.getInt(index23); }
        if (!_cursor.isNull(index24)) { resultBean.valueLinkedMapStringBean=Bean64Table.parseValueLinkedMapStringBean(_cursor.getBlob(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueLong=_cursor.getLong(index26); }
        if (!_cursor.isNull(index27)) { resultBean.valueLongArray=Bean64Table.parseValueLongArray(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueLongList=Bean64Table.parseValueLongList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongType=_cursor.getLong(index29); }
        if (!_cursor.isNull(index30)) { resultBean.valueLongTypeArray=Bean64Table.parseValueLongTypeArray(_cursor.getBlob(index30)); }
        if (!_cursor.isNull(index31)) { resultBean.valueMapStringBean=Bean64Table.parseValueMapStringBean(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueSetString=Bean64Table.parseValueSetString(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueShort=_cursor.getShort(index33); }
        if (!_cursor.isNull(index34)) { resultBean.valueShortType=_cursor.getShort(index34); }
        if (!_cursor.isNull(index35)) { resultBean.valueStrinList=Bean64Table.parseValueStrinList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueString=_cursor.getString(index36); }
        if (!_cursor.isNull(index37)) { resultBean.valueStringArray=Bean64Table.parseValueStringArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueTimeList=Bean64Table.parseValueTimeList(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index40)); }
        if (!_cursor.isNull(index41)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index41)); }

      }
      return resultBean;
    }
    // Specialized part - SelectBeanHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_bool FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public Boolean selectValueBool() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_BOOL_SQL36;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      Boolean result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getInt(0)==0?false:true;
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_bool_type FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public boolean selectValueBoolType() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_BOOL_TYPE_SQL37;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      boolean result=false;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return false; }
        result=_cursor.getInt(0)==0?false:true;
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_byte FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public Byte selectValueByte() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_BYTE_SQL38;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      Byte result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=(byte)_cursor.getInt(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_byte_type FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public byte selectValueByteType() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_BYTE_TYPE_SQL39;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      byte result=0;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0; }
        result=(byte)_cursor.getInt(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_char FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public Character selectValueChar() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_CHAR_SQL40;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      Character result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=(char)_cursor.getInt(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_char_type FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public char selectValueCharType() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_CHAR_TYPE_SQL41;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      char result=0;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0; }
        result=(char)_cursor.getInt(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_double FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public Double selectValueDouble() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_DOUBLE_SQL42;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      Double result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getDouble(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_double_type FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public double selectValueDoubleType() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_DOUBLE_TYPE_SQL43;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      double result=0;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0; }
        result=_cursor.getDouble(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_float FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public Float selectValueFloat() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_FLOAT_SQL44;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      Float result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getFloat(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_float_type FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public float selectValueFloatType() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_FLOAT_TYPE_SQL45;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      float result=0f;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0f; }
        result=_cursor.getFloat(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_int FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public Integer selectValueInt() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_INT_SQL46;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      Integer result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getInt(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_int_type FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public int selectValueIntType() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_INT_TYPE_SQL47;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      int result=0;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0; }
        result=_cursor.getInt(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_long FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public Long selectValueLong() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_LONG_SQL48;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      Long result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getLong(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_long_type FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public long selectValueLongType() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_LONG_TYPE_SQL49;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      long result=0L;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0L; }
        result=_cursor.getLong(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_short FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public Short selectValueShort() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_SHORT_SQL50;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      Short result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getShort(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_short_type FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public short selectValueShortType() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_SHORT_TYPE_SQL51;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      short result=0;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0; }
        result=_cursor.getShort(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>Select SQL:</h2>
   *
   * <pre>SELECT value_string FROM bean64</pre>
   *
   * <h2>Mapped class:</h2>
   * {@link Bean64}
   *
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * </dl>
   *
   * @return single value extracted by query.
   */
  @Override
  public String selectValueString() {
    // common part generation - BEGIN
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_STRING_SQL52;
    // add where arguments
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
      // Specialized part - SelectScalarHelper - BEGIN
      String result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getString(0);
      }
      return result;
    }
    // Specialized part - SelectScalarHelper - END
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET value_bean_array=:valueBeanArray, value_big_decimal=:valueBigDecimal, value_big_integer=:valueBigInteger, value_bool=:valueBool, value_bool_type=:valueBoolType, value_byte=:valueByte, value_byte_array=:valueByteArray, value_byte_type=:valueByteType, value_calendar=:valueCalendar, value_char=:valueChar, value_char_array=:valueCharArray, value_char_list=:valueCharList, value_char_type=:valueCharType, value_char_type_array=:valueCharTypeArray, value_currency=:valueCurrency, value_date=:valueDate, value_double=:valueDouble, value_double_type=:valueDoubleType, value_enum_type=:valueEnumType, value_float=:valueFloat, value_float_type=:valueFloatType, value_int=:valueInt, value_int_type=:valueIntType, value_linked_map_string_bean=:valueLinkedMapStringBean, value_locale=:valueLocale, value_long=:valueLong, value_long_array=:valueLongArray, value_long_list=:valueLongList, value_long_type=:valueLongType, value_long_type_array=:valueLongTypeArray, value_map_string_bean=:valueMapStringBean, value_set_string=:valueSetString, value_short=:valueShort, value_short_type=:valueShortType, value_strin_list=:valueStrinList, value_string=:valueString, value_string_array=:valueStringArray, value_time=:valueTime, value_time_list=:valueTimeList, value_time_zone=:valueTimeZone, value_url=:valueUrl WHERE id=${value.id}</pre>
   *
   * <h2>Updated columns</h2>
   * <dl>
   * 	<dt>value_bean_array</dt><dd>is mapped to <strong>:value.valueBeanArray</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is mapped to <strong>:value.valueBigDecimal</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is mapped to <strong>:value.valueBigInteger</strong></dd>
   * 	<dt>value_bool</dt><dd>is mapped to <strong>:value.valueBool</strong></dd>
   * 	<dt>value_bool_type</dt><dd>is mapped to <strong>:value.valueBoolType</strong></dd>
   * 	<dt>value_byte</dt><dd>is mapped to <strong>:value.valueByte</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is mapped to <strong>:value.valueByteArray</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is mapped to <strong>:value.valueByteType</strong></dd>
   * 	<dt>value_calendar</dt><dd>is mapped to <strong>:value.valueCalendar</strong></dd>
   * 	<dt>value_char</dt><dd>is mapped to <strong>:value.valueChar</strong></dd>
   * 	<dt>value_char_array</dt><dd>is mapped to <strong>:value.valueCharArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is mapped to <strong>:value.valueCharList</strong></dd>
   * 	<dt>value_char_type</dt><dd>is mapped to <strong>:value.valueCharType</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is mapped to <strong>:value.valueCharTypeArray</strong></dd>
   * 	<dt>value_currency</dt><dd>is mapped to <strong>:value.valueCurrency</strong></dd>
   * 	<dt>value_date</dt><dd>is mapped to <strong>:value.valueDate</strong></dd>
   * 	<dt>value_double</dt><dd>is mapped to <strong>:value.valueDouble</strong></dd>
   * 	<dt>value_double_type</dt><dd>is mapped to <strong>:value.valueDoubleType</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is mapped to <strong>:value.valueEnumType</strong></dd>
   * 	<dt>value_float</dt><dd>is mapped to <strong>:value.valueFloat</strong></dd>
   * 	<dt>value_float_type</dt><dd>is mapped to <strong>:value.valueFloatType</strong></dd>
   * 	<dt>value_int</dt><dd>is mapped to <strong>:value.valueInt</strong></dd>
   * 	<dt>value_int_type</dt><dd>is mapped to <strong>:value.valueIntType</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is mapped to <strong>:value.valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_locale</dt><dd>is mapped to <strong>:value.valueLocale</strong></dd>
   * 	<dt>value_long</dt><dd>is mapped to <strong>:value.valueLong</strong></dd>
   * 	<dt>value_long_array</dt><dd>is mapped to <strong>:value.valueLongArray</strong></dd>
   * 	<dt>value_long_list</dt><dd>is mapped to <strong>:value.valueLongList</strong></dd>
   * 	<dt>value_long_type</dt><dd>is mapped to <strong>:value.valueLongType</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is mapped to <strong>:value.valueLongTypeArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is mapped to <strong>:value.valueMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is mapped to <strong>:value.valueSetString</strong></dd>
   * 	<dt>value_short</dt><dd>is mapped to <strong>:value.valueShort</strong></dd>
   * 	<dt>value_short_type</dt><dd>is mapped to <strong>:value.valueShortType</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is mapped to <strong>:value.valueStrinList</strong></dd>
   * 	<dt>value_string</dt><dd>is mapped to <strong>:value.valueString</strong></dd>
   * 	<dt>value_string_array</dt><dd>is mapped to <strong>:value.valueStringArray</strong></dd>
   * 	<dt>value_time</dt><dd>is mapped to <strong>:value.valueTime</strong></dd>
   * 	<dt>value_time_list</dt><dd>is mapped to <strong>:value.valueTimeList</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is mapped to <strong>:value.valueTimeZone</strong></dd>
   * 	<dt>value_url</dt><dd>is mapped to <strong>:value.valueUrl</strong></dd>
   * </dl>
   *
   * <h2>Parameters used in where conditions:</h2>
   * <dl>
   * 	<dt>:value.id</dt><dd>is mapped to method's parameter <strong>value.id</strong></dd>
   * </dl>
   *
   * @param value
   * 	is used as <code>:value</code>
   *
   * @return number of updated records
   */
  @Override
  public long updateOne(Bean64 value) {
    if (updateOnePreparedStatement63==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET value_bean_array=?, value_big_decimal=?, value_big_integer=?, value_bool=?, value_bool_type=?, value_byte=?, value_byte_array=?, value_byte_type=?, value_calendar=?, value_char=?, value_char_array=?, value_char_list=?, value_char_type=?, value_char_type_array=?, value_currency=?, value_date=?, value_double=?, value_double_type=?, value_enum_type=?, value_float=?, value_float_type=?, value_int=?, value_int_type=?, value_linked_map_string_bean=?, value_locale=?, value_long=?, value_long_array=?, value_long_list=?, value_long_type=?, value_long_type_array=?, value_map_string_bean=?, value_set_string=?, value_short=?, value_short_type=?, value_strin_list=?, value_string=?, value_string_array=?, value_time=?, value_time_list=?, value_time_zone=?, value_url=? WHERE id=?";
      updateOnePreparedStatement63 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement63);
    _contentValues.put("value_bean_array", Bean64Table.serializeValueBeanArray(value.valueBeanArray));
    _contentValues.put("value_big_decimal", value.valueBigDecimal);
    _contentValues.put("value_big_integer", value.valueBigInteger);
    _contentValues.put("value_bool", value.valueBool);
    _contentValues.put("value_bool_type", value.valueBoolType);
    _contentValues.put("value_byte", value.valueByte);
    _contentValues.put("value_byte_array", value.valueByteArray);
    _contentValues.put("value_byte_type", value.valueByteType);
    _contentValues.put("value_calendar", CalendarUtils.write(value.valueCalendar));
    _contentValues.put("value_char", value.valueChar);
    _contentValues.put("value_char_array", Bean64Table.serializeValueCharArray(value.valueCharArray));
    _contentValues.put("value_char_list", Bean64Table.serializeValueCharList(value.valueCharList));
    _contentValues.put("value_char_type", value.valueCharType);
    _contentValues.put("value_char_type_array", Bean64Table.serializeValueCharTypeArray(value.valueCharTypeArray));
    _contentValues.put("value_currency", CurrencyUtils.write(value.valueCurrency));
    _contentValues.put("value_date", DateUtils.write(value.valueDate));
    _contentValues.put("value_double", value.valueDouble);
    _contentValues.put("value_double_type", value.valueDoubleType);
    _contentValues.put("value_enum_type", EnumUtils.write(value.valueEnumType));
    _contentValues.put("value_float", value.valueFloat);
    _contentValues.put("value_float_type", value.valueFloatType);
    _contentValues.put("value_int", value.valueInt);
    _contentValues.put("value_int_type", value.valueIntType);
    _contentValues.put("value_linked_map_string_bean", Bean64Table.serializeValueLinkedMapStringBean(value.valueLinkedMapStringBean));
    _contentValues.put("value_locale", LocaleUtils.write(value.valueLocale));
    _contentValues.put("value_long", value.valueLong);
    _contentValues.put("value_long_array", Bean64Table.serializeValueLongArray(value.valueLongArray));
    _contentValues.put("value_long_list", Bean64Table.serializeValueLongList(value.valueLongList));
    _contentValues.put("value_long_type", value.valueLongType);
    _contentValues.put("value_long_type_array", Bean64Table.serializeValueLongTypeArray(value.valueLongTypeArray));
    _contentValues.put("value_map_string_bean", Bean64Table.serializeValueMapStringBean(value.valueMapStringBean));
    _contentValues.put("value_set_string", Bean64Table.serializeValueSetString(value.valueSetString));
    _contentValues.put("value_short", value.valueShort);
    _contentValues.put("value_short_type", value.valueShortType);
    _contentValues.put("value_strin_list", Bean64Table.serializeValueStrinList(value.valueStrinList));
    _contentValues.put("value_string", value.valueString);
    _contentValues.put("value_string_array", Bean64Table.serializeValueStringArray(value.valueStringArray));
    _contentValues.put("value_time", SQLTimeUtils.write(value.valueTime));
    _contentValues.put("value_time_list", Bean64Table.serializeValueTimeList(value.valueTimeList));
    _contentValues.put("value_time_zone", TimeZoneUtils.write(value.valueTimeZone));
    _contentValues.put("value_url", UrlUtils.write(value.valueUrl));

    _contentValues.addWhereArgs(String.valueOf(value.id));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET value_bean_array=:value_bean_array, value_big_decimal=:value_big_decimal, value_big_integer=:value_big_integer, value_bool=:value_bool, value_bool_type=:value_bool_type, value_byte=:value_byte, value_byte_array=:value_byte_array, value_byte_type=:value_byte_type, value_calendar=:value_calendar, value_char=:value_char, value_char_array=:value_char_array, value_char_list=:value_char_list, value_char_type=:value_char_type, value_char_type_array=:value_char_type_array, value_currency=:value_currency, value_date=:value_date, value_double=:value_double, value_double_type=:value_double_type, value_enum_type=:value_enum_type, value_float=:value_float, value_float_type=:value_float_type, value_int=:value_int, value_int_type=:value_int_type, value_linked_map_string_bean=:value_linked_map_string_bean, value_locale=:value_locale, value_long=:value_long, value_long_array=:value_long_array, value_long_list=:value_long_list, value_long_type=:value_long_type, value_long_type_array=:value_long_type_array, value_map_string_bean=:value_map_string_bean, value_set_string=:value_set_string, value_short=:value_short, value_short_type=:value_short_type, value_strin_list=:value_strin_list, value_string=:value_string, value_string_array=:value_string_array, value_time=:value_time, value_time_list=:value_time_list, value_time_zone=:value_time_zone, value_url=:value_url WHERE id=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOnePreparedStatement63, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_big_decimal=:valueBigDecimal</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueBigDecimal</dt><dd>is mapped to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueBigDecimal
   * 	is used as where parameter <strong>:valueBigDecimal</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOne(long id, BigDecimal valueBigDecimal) {
    if (updateOnePreparedStatement64==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_big_decimal=?";
      updateOnePreparedStatement64 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement64);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toPlainString()));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_big_decimal=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOnePreparedStatement64, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_big_decimal=:valueBigDecimal</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueBigDecimal</dt><dd>is mapped to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueBigDecimal
   * 	is used as where parameter <strong>:valueBigDecimal</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOne(long id, BigInteger valueBigDecimal) {
    if (updateOnePreparedStatement65==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_big_decimal=?";
      updateOnePreparedStatement65 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement65);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toString()));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_big_decimal=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOnePreparedStatement65, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_bool_type=:valueBoolType</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueBoolType</dt><dd>is mapped to method's parameter <strong>valueBoolType</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueBoolType
   * 	is used as where parameter <strong>:valueBoolType</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOne(long id, boolean valueBoolType) {
    if (updateOnePreparedStatement66==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_bool_type=?";
      updateOnePreparedStatement66 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement66);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueBoolType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_bool_type=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOnePreparedStatement66, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_bool=:valueBool</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueBool</dt><dd>is mapped to method's parameter <strong>valueBool</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueBool
   * 	is used as where parameter <strong>:valueBool</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOne(long id, Boolean valueBool) {
    if (updateOnePreparedStatement67==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_bool=?";
      updateOnePreparedStatement67 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement67);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueBool==null?"":String.valueOf(valueBool)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_bool=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOnePreparedStatement67, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET value_set_string=:valueSetString WHERE id=:id</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>value_set_string</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:id</dt><dd>is mapped to method's parameter <strong>id</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as where parameter <strong>:id</strong>
   * @param valueSetString
   * 	is used as updated field <strong>valueSetString</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOne(long id, Set<String> valueSetString) {
    if (updateOnePreparedStatement68==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET value_set_string=? WHERE id=?";
      updateOnePreparedStatement68 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement68);
    _contentValues.put("value_set_string", serializer5(valueSetString));

    _contentValues.addWhereArgs(String.valueOf(id));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET value_set_string=:value_set_string WHERE id=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOnePreparedStatement68, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_bean_array=:valueBeanArray</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueBeanArray</dt><dd>is mapped to method's parameter <strong>valueBeanArray</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueBeanArray
   * 	is used as where parameter <strong>:valueBeanArray</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneArrayBean(long id, Bean64[] valueBeanArray) {
    if (updateOneArrayBeanPreparedStatement69==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_bean_array=?";
      updateOneArrayBeanPreparedStatement69 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneArrayBeanPreparedStatement69);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueBeanArray==null?"":new String(serializer1(valueBeanArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_bean_array=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneArrayBeanPreparedStatement69, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_long_array=:valueLongArray</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLongArray</dt><dd>is mapped to method's parameter <strong>valueLongArray</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueLongArray
   * 	is used as where parameter <strong>:valueLongArray</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneArrayLong(long id, Long[] valueLongArray) {
    if (updateOneArrayLongPreparedStatement70==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_long_array=?";
      updateOneArrayLongPreparedStatement70 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneArrayLongPreparedStatement70);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueLongArray==null?"":new String(serializer2(valueLongArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_long_array=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneArrayLongPreparedStatement70, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_long_type_array=:valueLongTypeArray</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLongTypeArray</dt><dd>is mapped to method's parameter <strong>valueLongTypeArray</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueLongTypeArray
   * 	is used as where parameter <strong>:valueLongTypeArray</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneArrayLongType(long id, long[] valueLongTypeArray) {
    if (updateOneArrayLongTypePreparedStatement71==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_long_type_array=?";
      updateOneArrayLongTypePreparedStatement71 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneArrayLongTypePreparedStatement71);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueLongTypeArray==null?"":new String(serializer3(valueLongTypeArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_long_type_array=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneArrayLongTypePreparedStatement71, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_byte=:valueByte</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueByte</dt><dd>is mapped to method's parameter <strong>valueByte</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueByte
   * 	is used as where parameter <strong>:valueByte</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneByte(long id, Byte valueByte) {
    if (updateOneBytePreparedStatement72==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_byte=?";
      updateOneBytePreparedStatement72 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneBytePreparedStatement72);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueByte==null?"":String.valueOf(valueByte)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_byte=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneBytePreparedStatement72, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_byte_type=:valueByteType</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueByteType</dt><dd>is mapped to method's parameter <strong>valueByteType</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueByteType
   * 	is used as where parameter <strong>:valueByteType</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneByteType(long id, boolean valueByteType) {
    if (updateOneByteTypePreparedStatement73==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_byte_type=?";
      updateOneByteTypePreparedStatement73 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneByteTypePreparedStatement73);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueByteType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_byte_type=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneByteTypePreparedStatement73, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_calendar=:valueCalendar</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueCalendar</dt><dd>is mapped to method's parameter <strong>valueCalendar</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueCalendar
   * 	is used as where parameter <strong>:valueCalendar</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneCalendar(long id, Calendar valueCalendar) {
    if (updateOneCalendarPreparedStatement74==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_calendar=?";
      updateOneCalendarPreparedStatement74 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneCalendarPreparedStatement74);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueCalendar==null?"":CalendarUtils.write(valueCalendar)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_calendar=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneCalendarPreparedStatement74, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_char_type=:valueChar</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueChar</dt><dd>is mapped to method's parameter <strong>valueChar</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueChar
   * 	is used as where parameter <strong>:valueChar</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneChar(long id, Character valueChar) {
    if (updateOneCharPreparedStatement75==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_char_type=?";
      updateOneCharPreparedStatement75 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneCharPreparedStatement75);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueChar==null?"":String.valueOf(valueChar)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_char_type=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneCharPreparedStatement75, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_char_type=:valueCharType</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueCharType</dt><dd>is mapped to method's parameter <strong>valueCharType</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueCharType
   * 	is used as where parameter <strong>:valueCharType</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneCharType(long id, char valueCharType) {
    if (updateOneCharTypePreparedStatement76==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_char_type=?";
      updateOneCharTypePreparedStatement76 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneCharTypePreparedStatement76);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueCharType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_char_type=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneCharTypePreparedStatement76, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_currency=:valueCurrency</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueCurrency</dt><dd>is mapped to method's parameter <strong>valueCurrency</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueCurrency
   * 	is used as where parameter <strong>:valueCurrency</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneCurrency(long id, Currency valueCurrency) {
    if (updateOneCurrencyPreparedStatement77==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_currency=?";
      updateOneCurrencyPreparedStatement77 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneCurrencyPreparedStatement77);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueCurrency==null?"":CurrencyUtils.write(valueCurrency)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_currency=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneCurrencyPreparedStatement77, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_date=:valueDate</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueDate</dt><dd>is mapped to method's parameter <strong>valueDate</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueDate
   * 	is used as where parameter <strong>:valueDate</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneDate(long id, Date valueDate) {
    if (updateOneDatePreparedStatement78==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_date=?";
      updateOneDatePreparedStatement78 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneDatePreparedStatement78);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueDate==null?"":DateUtils.write(valueDate)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_date=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneDatePreparedStatement78, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_double=:valueDouble</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueDouble</dt><dd>is mapped to method's parameter <strong>valueDouble</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueDouble
   * 	is used as where parameter <strong>:valueDouble</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneDouble(long id, Double valueDouble) {
    if (updateOneDoublePreparedStatement79==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_double=?";
      updateOneDoublePreparedStatement79 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneDoublePreparedStatement79);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueDouble==null?"":String.valueOf(valueDouble)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_double=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneDoublePreparedStatement79, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_double_type=:valueDoubleType</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueDoubleType</dt><dd>is mapped to method's parameter <strong>valueDoubleType</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueDoubleType
   * 	is used as where parameter <strong>:valueDoubleType</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneDoubleType(long id, double valueDoubleType) {
    if (updateOneDoubleTypePreparedStatement80==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_double_type=?";
      updateOneDoubleTypePreparedStatement80 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneDoubleTypePreparedStatement80);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueDoubleType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_double_type=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneDoubleTypePreparedStatement80, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_enum_type=:valueEnumType</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueEnumType</dt><dd>is mapped to method's parameter <strong>valueEnumType</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueEnumType
   * 	is used as where parameter <strong>:valueEnumType</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneEnumType(long id, EnumType valueEnumType) {
    if (updateOneEnumTypePreparedStatement81==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_enum_type=?";
      updateOneEnumTypePreparedStatement81 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneEnumTypePreparedStatement81);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueEnumType==null?"":EnumUtils.write(valueEnumType)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_enum_type=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneEnumTypePreparedStatement81, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_float=:valueFloat</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueFloat</dt><dd>is mapped to method's parameter <strong>valueFloat</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueFloat
   * 	is used as where parameter <strong>:valueFloat</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneFloat(long id, Float valueFloat) {
    if (updateOneFloatPreparedStatement82==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_float=?";
      updateOneFloatPreparedStatement82 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneFloatPreparedStatement82);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueFloat==null?"":String.valueOf(valueFloat)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_float=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneFloatPreparedStatement82, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_float_type=:valueFloatType</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueFloatType</dt><dd>is mapped to method's parameter <strong>valueFloatType</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueFloatType
   * 	is used as where parameter <strong>:valueFloatType</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneFloatType(long id, float valueFloatType) {
    if (updateOneFloatTypePreparedStatement83==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_float_type=?";
      updateOneFloatTypePreparedStatement83 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneFloatTypePreparedStatement83);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueFloatType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_float_type=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneFloatTypePreparedStatement83, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_int=:valueInt</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueInt</dt><dd>is mapped to method's parameter <strong>valueInt</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueInt
   * 	is used as where parameter <strong>:valueInt</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneInt(long id, Integer valueInt) {
    if (updateOneIntPreparedStatement84==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_int=?";
      updateOneIntPreparedStatement84 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneIntPreparedStatement84);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueInt==null?"":String.valueOf(valueInt)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_int=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneIntPreparedStatement84, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_int_type=:valueIntType</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueIntType</dt><dd>is mapped to method's parameter <strong>valueIntType</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueIntType
   * 	is used as where parameter <strong>:valueIntType</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneIntType(long id, int valueIntType) {
    if (updateOneIntTypePreparedStatement85==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_int_type=?";
      updateOneIntTypePreparedStatement85 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneIntTypePreparedStatement85);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueIntType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_int_type=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneIntTypePreparedStatement85, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_long_list=:valueLongList</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLongList</dt><dd>is mapped to method's parameter <strong>valueLongList</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueLongList
   * 	is used as where parameter <strong>:valueLongList</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneListLong(long id, LinkedList<Long> valueLongList) {
    if (updateOneListLongPreparedStatement86==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_long_list=?";
      updateOneListLongPreparedStatement86 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneListLongPreparedStatement86);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueLongList==null?"":new String(serializer4(valueLongList),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_long_list=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneListLongPreparedStatement86, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_locale=:valueLocale</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLocale</dt><dd>is mapped to method's parameter <strong>valueLocale</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueLocale
   * 	is used as where parameter <strong>:valueLocale</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneLocale(long id, Locale valueLocale) {
    if (updateOneLocalePreparedStatement87==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_locale=?";
      updateOneLocalePreparedStatement87 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneLocalePreparedStatement87);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueLocale==null?"":LocaleUtils.write(valueLocale)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_locale=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneLocalePreparedStatement87, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_long=:valueLong</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLong</dt><dd>is mapped to method's parameter <strong>valueLong</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueLong
   * 	is used as where parameter <strong>:valueLong</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneLong(long id, Long valueLong) {
    if (updateOneLongPreparedStatement88==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_long=?";
      updateOneLongPreparedStatement88 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneLongPreparedStatement88);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueLong==null?"":String.valueOf(valueLong)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_long=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneLongPreparedStatement88, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_long_type=:valueLongType</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueLongType</dt><dd>is mapped to method's parameter <strong>valueLongType</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueLongType
   * 	is used as where parameter <strong>:valueLongType</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneLongType(long id, long valueLongType) {
    if (updateOneLongTypePreparedStatement89==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_long_type=?";
      updateOneLongTypePreparedStatement89 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneLongTypePreparedStatement89);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueLongType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_long_type=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneLongTypePreparedStatement89, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_short=:valueShort</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueShort</dt><dd>is mapped to method's parameter <strong>valueShort</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueShort
   * 	is used as where parameter <strong>:valueShort</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneShort(long id, Short valueShort) {
    if (updateOneShortPreparedStatement90==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_short=?";
      updateOneShortPreparedStatement90 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneShortPreparedStatement90);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueShort==null?"":String.valueOf(valueShort)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_short=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneShortPreparedStatement90, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_short_type=:valueShortType</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueShortType</dt><dd>is mapped to method's parameter <strong>valueShortType</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueShortType
   * 	is used as where parameter <strong>:valueShortType</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneShortType(long id, short valueShortType) {
    if (updateOneShortTypePreparedStatement91==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_short_type=?";
      updateOneShortTypePreparedStatement91 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneShortTypePreparedStatement91);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueShortType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_short_type=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneShortTypePreparedStatement91, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_string=:valueString</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueString</dt><dd>is mapped to method's parameter <strong>valueString</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueString
   * 	is used as where parameter <strong>:valueString</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneString(long id, Double valueString) {
    if (updateOneStringPreparedStatement92==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_string=?";
      updateOneStringPreparedStatement92 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneStringPreparedStatement92);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueString==null?"":String.valueOf(valueString)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_string=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneStringPreparedStatement92, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_time=:valueTime</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueTime</dt><dd>is mapped to method's parameter <strong>valueTime</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueTime
   * 	is used as where parameter <strong>:valueTime</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneTime(long id, Time valueTime) {
    if (updateOneTimePreparedStatement93==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_time=?";
      updateOneTimePreparedStatement93 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneTimePreparedStatement93);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueTime==null?"":SQLTimeUtils.write(valueTime)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_time=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneTimePreparedStatement93, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_time_zone=:valueTimeZone</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueTimeZone</dt><dd>is mapped to method's parameter <strong>valueTimeZone</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueTimeZone
   * 	is used as where parameter <strong>:valueTimeZone</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneTimeZone(long id, TimeZone valueTimeZone) {
    if (updateOneTimeZonePreparedStatement94==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_time_zone=?";
      updateOneTimeZonePreparedStatement94 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneTimeZonePreparedStatement94);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueTimeZone==null?"":TimeZoneUtils.write(valueTimeZone)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_time_zone=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneTimeZonePreparedStatement94, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean64 SET id=:id WHERE value_url=:valueUrl</pre>
   *
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   *
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>:valueUrl</dt><dd>is mapped to method's parameter <strong>valueUrl</strong></dd>
   * </dl>
   *
   * @param id
   * 	is used as updated field <strong>id</strong>
   * @param valueUrl
   * 	is used as where parameter <strong>:valueUrl</strong>
   *
   * @return number of updated records
   */
  @Override
  public long updateOneURL(long id, URL valueUrl) {
    if (updateOneURLPreparedStatement95==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean64 SET id=? WHERE value_url=?";
      updateOneURLPreparedStatement95 = KriptonDatabaseHelper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneURLPreparedStatement95);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueUrl==null?"":UrlUtils.write(valueUrl)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean64 SET id=:id WHERE value_url=?");

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
    int result = KriptonDatabaseHelper.updateDelete(updateOneURLPreparedStatement95, _contentValues);
    return result;
  }

  /**
   * for param serializer2 serialization
   */
  private static byte[] serializer2(Long[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      jacksonSerializer.writeStartObject();
      if (value!=null)  {
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
   * for param parser2 parsing
   */
  private static Long[] parser2(byte[] input) {
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
   * for param serializer1 serialization
   */
  private static byte[] serializer1(Bean64[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      jacksonSerializer.writeStartObject();
      if (value!=null)  {
        int n=value.length;
        Bean64 item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            bean64BindMap.serializeOnJackson(item, jacksonSerializer);
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
   * for param parser1 parsing
   */
  private static Bean64[] parser1(byte[] input) {
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
      Bean64[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Bean64> collection=new ArrayList<>();
        Bean64 item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=bean64BindMap.parseOnJackson(jacksonParser);
          }
          collection.add(item);
        }
        result=CollectionUtils.asArray(collection, new Bean64[collection.size()]);
      }
      return result;
    } catch(Exception e) {
      e.printStackTrace();
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param serializer4 serialization
   */
  private static byte[] serializer4(LinkedList<Long> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      jacksonSerializer.writeStartObject();
      if (value!=null)  {
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
   * for param parser4 parsing
   */
  private static LinkedList<Long> parser4(byte[] input) {
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
   * for param serializer3 serialization
   */
  private static byte[] serializer3(long[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      jacksonSerializer.writeStartObject();
      if (value!=null)  {
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
   * for param parser3 parsing
   */
  private static long[] parser3(byte[] input) {
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
   * for param serializer5 serialization
   */
  private static byte[] serializer5(Set<String> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      jacksonSerializer.writeStartObject();
      if (value!=null)  {
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
   * for param parser5 parsing
   */
  private static Set<String> parser5(byte[] input) {
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

  public static void clearCompiledStatements() {
    try {
      if (deletePreparedStatement0!=null) {
        deletePreparedStatement0.close();
        deletePreparedStatement0=null;
      }
      if (deletePreparedStatement1!=null) {
        deletePreparedStatement1.close();
        deletePreparedStatement1=null;
      }
      if (deletePreparedStatement2!=null) {
        deletePreparedStatement2.close();
        deletePreparedStatement2=null;
      }
      if (deletePreparedStatement3!=null) {
        deletePreparedStatement3.close();
        deletePreparedStatement3=null;
      }
      if (deleteArrayBeanTypePreparedStatement4!=null) {
        deleteArrayBeanTypePreparedStatement4.close();
        deleteArrayBeanTypePreparedStatement4=null;
      }
      if (deleteArrayLongPreparedStatement5!=null) {
        deleteArrayLongPreparedStatement5.close();
        deleteArrayLongPreparedStatement5=null;
      }
      if (deleteArrayLongTypePreparedStatement6!=null) {
        deleteArrayLongTypePreparedStatement6.close();
        deleteArrayLongTypePreparedStatement6=null;
      }
      if (deleteBytePreparedStatement7!=null) {
        deleteBytePreparedStatement7.close();
        deleteBytePreparedStatement7=null;
      }
      if (deleteByteTypePreparedStatement8!=null) {
        deleteByteTypePreparedStatement8.close();
        deleteByteTypePreparedStatement8=null;
      }
      if (deleteCalendarPreparedStatement9!=null) {
        deleteCalendarPreparedStatement9.close();
        deleteCalendarPreparedStatement9=null;
      }
      if (deleteCharPreparedStatement10!=null) {
        deleteCharPreparedStatement10.close();
        deleteCharPreparedStatement10=null;
      }
      if (deleteCharTypePreparedStatement11!=null) {
        deleteCharTypePreparedStatement11.close();
        deleteCharTypePreparedStatement11=null;
      }
      if (deleteCurrencyPreparedStatement12!=null) {
        deleteCurrencyPreparedStatement12.close();
        deleteCurrencyPreparedStatement12=null;
      }
      if (deleteDatePreparedStatement13!=null) {
        deleteDatePreparedStatement13.close();
        deleteDatePreparedStatement13=null;
      }
      if (deleteDoublePreparedStatement14!=null) {
        deleteDoublePreparedStatement14.close();
        deleteDoublePreparedStatement14=null;
      }
      if (deleteDoubleTypePreparedStatement15!=null) {
        deleteDoubleTypePreparedStatement15.close();
        deleteDoubleTypePreparedStatement15=null;
      }
      if (deleteEnumTypePreparedStatement16!=null) {
        deleteEnumTypePreparedStatement16.close();
        deleteEnumTypePreparedStatement16=null;
      }
      if (deleteFloatPreparedStatement17!=null) {
        deleteFloatPreparedStatement17.close();
        deleteFloatPreparedStatement17=null;
      }
      if (deleteFloatTypePreparedStatement18!=null) {
        deleteFloatTypePreparedStatement18.close();
        deleteFloatTypePreparedStatement18=null;
      }
      if (deleteIntPreparedStatement19!=null) {
        deleteIntPreparedStatement19.close();
        deleteIntPreparedStatement19=null;
      }
      if (deleteIntTypePreparedStatement20!=null) {
        deleteIntTypePreparedStatement20.close();
        deleteIntTypePreparedStatement20=null;
      }
      if (deleteListLongPreparedStatement21!=null) {
        deleteListLongPreparedStatement21.close();
        deleteListLongPreparedStatement21=null;
      }
      if (deleteLocalePreparedStatement22!=null) {
        deleteLocalePreparedStatement22.close();
        deleteLocalePreparedStatement22=null;
      }
      if (deleteLongPreparedStatement23!=null) {
        deleteLongPreparedStatement23.close();
        deleteLongPreparedStatement23=null;
      }
      if (deleteLongTypePreparedStatement24!=null) {
        deleteLongTypePreparedStatement24.close();
        deleteLongTypePreparedStatement24=null;
      }
      if (deleteShortPreparedStatement25!=null) {
        deleteShortPreparedStatement25.close();
        deleteShortPreparedStatement25=null;
      }
      if (deleteShortTypePreparedStatement26!=null) {
        deleteShortTypePreparedStatement26.close();
        deleteShortTypePreparedStatement26=null;
      }
      if (deleteStringPreparedStatement27!=null) {
        deleteStringPreparedStatement27.close();
        deleteStringPreparedStatement27=null;
      }
      if (deleteTimePreparedStatement28!=null) {
        deleteTimePreparedStatement28.close();
        deleteTimePreparedStatement28=null;
      }
      if (deleteTimeZonePreparedStatement29!=null) {
        deleteTimeZonePreparedStatement29.close();
        deleteTimeZonePreparedStatement29=null;
      }
      if (deleteURLPreparedStatement30!=null) {
        deleteURLPreparedStatement30.close();
        deleteURLPreparedStatement30=null;
      }
      if (insertPreparedStatement31!=null) {
        insertPreparedStatement31.close();
        insertPreparedStatement31=null;
      }
      if (insertPreparedStatement32!=null) {
        insertPreparedStatement32.close();
        insertPreparedStatement32=null;
      }
      if (insertPreparedStatement33!=null) {
        insertPreparedStatement33.close();
        insertPreparedStatement33=null;
      }
      if (insertPreparedStatement34!=null) {
        insertPreparedStatement34.close();
        insertPreparedStatement34=null;
      }
      if (insertPreparedStatement35!=null) {
        insertPreparedStatement35.close();
        insertPreparedStatement35=null;
      }
      if (insertArrayBeanTypePreparedStatement36!=null) {
        insertArrayBeanTypePreparedStatement36.close();
        insertArrayBeanTypePreparedStatement36=null;
      }
      if (insertArrayLongPreparedStatement37!=null) {
        insertArrayLongPreparedStatement37.close();
        insertArrayLongPreparedStatement37=null;
      }
      if (insertArrayLongTypePreparedStatement38!=null) {
        insertArrayLongTypePreparedStatement38.close();
        insertArrayLongTypePreparedStatement38=null;
      }
      if (insertBytePreparedStatement39!=null) {
        insertBytePreparedStatement39.close();
        insertBytePreparedStatement39=null;
      }
      if (insertByteTypePreparedStatement40!=null) {
        insertByteTypePreparedStatement40.close();
        insertByteTypePreparedStatement40=null;
      }
      if (insertCalendarPreparedStatement41!=null) {
        insertCalendarPreparedStatement41.close();
        insertCalendarPreparedStatement41=null;
      }
      if (insertCharPreparedStatement42!=null) {
        insertCharPreparedStatement42.close();
        insertCharPreparedStatement42=null;
      }
      if (insertCharTypePreparedStatement43!=null) {
        insertCharTypePreparedStatement43.close();
        insertCharTypePreparedStatement43=null;
      }
      if (insertCurrencyPreparedStatement44!=null) {
        insertCurrencyPreparedStatement44.close();
        insertCurrencyPreparedStatement44=null;
      }
      if (insertDatePreparedStatement45!=null) {
        insertDatePreparedStatement45.close();
        insertDatePreparedStatement45=null;
      }
      if (insertDoublePreparedStatement46!=null) {
        insertDoublePreparedStatement46.close();
        insertDoublePreparedStatement46=null;
      }
      if (insertDoubleTypePreparedStatement47!=null) {
        insertDoubleTypePreparedStatement47.close();
        insertDoubleTypePreparedStatement47=null;
      }
      if (insertEnumTypePreparedStatement48!=null) {
        insertEnumTypePreparedStatement48.close();
        insertEnumTypePreparedStatement48=null;
      }
      if (insertFloatPreparedStatement49!=null) {
        insertFloatPreparedStatement49.close();
        insertFloatPreparedStatement49=null;
      }
      if (insertFloatTypePreparedStatement50!=null) {
        insertFloatTypePreparedStatement50.close();
        insertFloatTypePreparedStatement50=null;
      }
      if (insertIntPreparedStatement51!=null) {
        insertIntPreparedStatement51.close();
        insertIntPreparedStatement51=null;
      }
      if (insertIntTypePreparedStatement52!=null) {
        insertIntTypePreparedStatement52.close();
        insertIntTypePreparedStatement52=null;
      }
      if (insertListLongPreparedStatement53!=null) {
        insertListLongPreparedStatement53.close();
        insertListLongPreparedStatement53=null;
      }
      if (insertLocalePreparedStatement54!=null) {
        insertLocalePreparedStatement54.close();
        insertLocalePreparedStatement54=null;
      }
      if (insertLongPreparedStatement55!=null) {
        insertLongPreparedStatement55.close();
        insertLongPreparedStatement55=null;
      }
      if (insertLongTypePreparedStatement56!=null) {
        insertLongTypePreparedStatement56.close();
        insertLongTypePreparedStatement56=null;
      }
      if (insertShortPreparedStatement57!=null) {
        insertShortPreparedStatement57.close();
        insertShortPreparedStatement57=null;
      }
      if (insertShortTypePreparedStatement58!=null) {
        insertShortTypePreparedStatement58.close();
        insertShortTypePreparedStatement58=null;
      }
      if (insertStringPreparedStatement59!=null) {
        insertStringPreparedStatement59.close();
        insertStringPreparedStatement59=null;
      }
      if (insertTimePreparedStatement60!=null) {
        insertTimePreparedStatement60.close();
        insertTimePreparedStatement60=null;
      }
      if (insertTimeZonePreparedStatement61!=null) {
        insertTimeZonePreparedStatement61.close();
        insertTimeZonePreparedStatement61=null;
      }
      if (insertURLPreparedStatement62!=null) {
        insertURLPreparedStatement62.close();
        insertURLPreparedStatement62=null;
      }
      if (updateOnePreparedStatement63!=null) {
        updateOnePreparedStatement63.close();
        updateOnePreparedStatement63=null;
      }
      if (updateOnePreparedStatement64!=null) {
        updateOnePreparedStatement64.close();
        updateOnePreparedStatement64=null;
      }
      if (updateOnePreparedStatement65!=null) {
        updateOnePreparedStatement65.close();
        updateOnePreparedStatement65=null;
      }
      if (updateOnePreparedStatement66!=null) {
        updateOnePreparedStatement66.close();
        updateOnePreparedStatement66=null;
      }
      if (updateOnePreparedStatement67!=null) {
        updateOnePreparedStatement67.close();
        updateOnePreparedStatement67=null;
      }
      if (updateOnePreparedStatement68!=null) {
        updateOnePreparedStatement68.close();
        updateOnePreparedStatement68=null;
      }
      if (updateOneArrayBeanPreparedStatement69!=null) {
        updateOneArrayBeanPreparedStatement69.close();
        updateOneArrayBeanPreparedStatement69=null;
      }
      if (updateOneArrayLongPreparedStatement70!=null) {
        updateOneArrayLongPreparedStatement70.close();
        updateOneArrayLongPreparedStatement70=null;
      }
      if (updateOneArrayLongTypePreparedStatement71!=null) {
        updateOneArrayLongTypePreparedStatement71.close();
        updateOneArrayLongTypePreparedStatement71=null;
      }
      if (updateOneBytePreparedStatement72!=null) {
        updateOneBytePreparedStatement72.close();
        updateOneBytePreparedStatement72=null;
      }
      if (updateOneByteTypePreparedStatement73!=null) {
        updateOneByteTypePreparedStatement73.close();
        updateOneByteTypePreparedStatement73=null;
      }
      if (updateOneCalendarPreparedStatement74!=null) {
        updateOneCalendarPreparedStatement74.close();
        updateOneCalendarPreparedStatement74=null;
      }
      if (updateOneCharPreparedStatement75!=null) {
        updateOneCharPreparedStatement75.close();
        updateOneCharPreparedStatement75=null;
      }
      if (updateOneCharTypePreparedStatement76!=null) {
        updateOneCharTypePreparedStatement76.close();
        updateOneCharTypePreparedStatement76=null;
      }
      if (updateOneCurrencyPreparedStatement77!=null) {
        updateOneCurrencyPreparedStatement77.close();
        updateOneCurrencyPreparedStatement77=null;
      }
      if (updateOneDatePreparedStatement78!=null) {
        updateOneDatePreparedStatement78.close();
        updateOneDatePreparedStatement78=null;
      }
      if (updateOneDoublePreparedStatement79!=null) {
        updateOneDoublePreparedStatement79.close();
        updateOneDoublePreparedStatement79=null;
      }
      if (updateOneDoubleTypePreparedStatement80!=null) {
        updateOneDoubleTypePreparedStatement80.close();
        updateOneDoubleTypePreparedStatement80=null;
      }
      if (updateOneEnumTypePreparedStatement81!=null) {
        updateOneEnumTypePreparedStatement81.close();
        updateOneEnumTypePreparedStatement81=null;
      }
      if (updateOneFloatPreparedStatement82!=null) {
        updateOneFloatPreparedStatement82.close();
        updateOneFloatPreparedStatement82=null;
      }
      if (updateOneFloatTypePreparedStatement83!=null) {
        updateOneFloatTypePreparedStatement83.close();
        updateOneFloatTypePreparedStatement83=null;
      }
      if (updateOneIntPreparedStatement84!=null) {
        updateOneIntPreparedStatement84.close();
        updateOneIntPreparedStatement84=null;
      }
      if (updateOneIntTypePreparedStatement85!=null) {
        updateOneIntTypePreparedStatement85.close();
        updateOneIntTypePreparedStatement85=null;
      }
      if (updateOneListLongPreparedStatement86!=null) {
        updateOneListLongPreparedStatement86.close();
        updateOneListLongPreparedStatement86=null;
      }
      if (updateOneLocalePreparedStatement87!=null) {
        updateOneLocalePreparedStatement87.close();
        updateOneLocalePreparedStatement87=null;
      }
      if (updateOneLongPreparedStatement88!=null) {
        updateOneLongPreparedStatement88.close();
        updateOneLongPreparedStatement88=null;
      }
      if (updateOneLongTypePreparedStatement89!=null) {
        updateOneLongTypePreparedStatement89.close();
        updateOneLongTypePreparedStatement89=null;
      }
      if (updateOneShortPreparedStatement90!=null) {
        updateOneShortPreparedStatement90.close();
        updateOneShortPreparedStatement90=null;
      }
      if (updateOneShortTypePreparedStatement91!=null) {
        updateOneShortTypePreparedStatement91.close();
        updateOneShortTypePreparedStatement91=null;
      }
      if (updateOneStringPreparedStatement92!=null) {
        updateOneStringPreparedStatement92.close();
        updateOneStringPreparedStatement92=null;
      }
      if (updateOneTimePreparedStatement93!=null) {
        updateOneTimePreparedStatement93.close();
        updateOneTimePreparedStatement93=null;
      }
      if (updateOneTimeZonePreparedStatement94!=null) {
        updateOneTimeZonePreparedStatement94.close();
        updateOneTimeZonePreparedStatement94=null;
      }
      if (updateOneURLPreparedStatement95!=null) {
        updateOneURLPreparedStatement95.close();
        updateOneURLPreparedStatement95=null;
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
