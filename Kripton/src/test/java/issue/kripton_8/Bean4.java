package issue.kripton_8;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Time;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.namespace.QName;

import com.abubusoft.kripton.annotation.Bind;
import com.abubusoft.kripton.annotation.BindType;
import com.abubusoft.kripton.annotation.BindXml;
import com.abubusoft.kripton.binder.xml.XmlType;

@BindType
public class Bean4 extends Bean0 {

	public enum BeanType 
	
	{
		TEST_1,
		TEST_2;
	}
	
	@Bind
	@BindXml(value=XmlType.VALUE_CDATA)
	BeanType fieldEnum;
	
	@Bind
	@BindXml(value=XmlType.ATTRIBUTE)
	BeanType fieldEnum2;
	
	Locale fieldLocale;
	
	QName fieldQName;
	
	Calendar fieldCalendar;
	
	Character fieldChar;
	
	Date fieldDate;
	
	BigDecimal fieldBigDecimal;
	
	URL fieldUrl;
		
	Boolean fieldBoolean;
	
	Byte fieldByte;
	
	Currency fieldCurrency;
	
	Double fieldDouble;
	
	Float fieldFloat;
	
	Long fieldLong;
	
	Short fieldShort;
	
	Time fieldTime;
	
	TimeZone fieldTimeZone;
	
	Integer fieldInteger;
	
	String fieldString;

	public BigInteger fieldBigInteger;
}
