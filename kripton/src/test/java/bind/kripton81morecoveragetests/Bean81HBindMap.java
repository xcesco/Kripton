package bind.kripton81morecoveragetests;

import com.abubusoft.kripton.AbstractMapper;
import com.abubusoft.kripton.annotation.BindMap;
import com.abubusoft.kripton.common.BigDecimalUtils;
import com.abubusoft.kripton.common.BigIntegerUtils;
import com.abubusoft.kripton.common.PrimitiveUtils;
import com.abubusoft.kripton.escape.StringEscapeUtils;
import com.abubusoft.kripton.xml.EventType;
import com.abubusoft.kripton.xml.XMLParser;
import com.abubusoft.kripton.xml.XMLSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * This class is binder map for Bean81H
 *
 * @see Bean81H
 */
@BindMap(Bean81H.class)
public class Bean81HBindMap extends AbstractMapper<Bean81H> {
  @Override
  public int serializeOnJackson(Bean81H object, JsonGenerator jacksonSerializer) throws Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field id (mapped with "id")
    fieldCount++;
    jacksonSerializer.writeNumberField("id", object.id);

    // field valueBigDecimal (mapped with "valueBigDecimal")
    if (object.valueBigDecimal!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("valueBigDecimal", BigDecimalUtils.write(object.valueBigDecimal));
    }

    // field valueBigInteger (mapped with "valueBigInteger")
    if (object.valueBigInteger!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("valueBigInteger", BigIntegerUtils.write(object.valueBigInteger));
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  @Override
  public int serializeOnJacksonAsString(Bean81H object, JsonGenerator jacksonSerializer) throws
      Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field id (mapped with "id")
    jacksonSerializer.writeStringField("id", PrimitiveUtils.writeLong(object.id));

    // field valueBigDecimal (mapped with "valueBigDecimal")
    if (object.valueBigDecimal!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("valueBigDecimal", BigDecimalUtils.write(object.valueBigDecimal));
    }

    // field valueBigInteger (mapped with "valueBigInteger")
    if (object.valueBigInteger!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("valueBigInteger", BigIntegerUtils.write(object.valueBigInteger));
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /**
   * method for xml serialization
   */
  @Override
  public void serializeOnXml(Bean81H object, XMLSerializer xmlSerializer,
      EventType currentEventType) throws Exception {
    if (currentEventType == EventType.START_DOCUMENT) {
      xmlSerializer.writeStartElement("bean81H");
    }

    // Persisted fields:

    // field valueBigInteger (mapped with "valueBigInteger")
    if (object.valueBigInteger!=null)  {
      xmlSerializer.writeIntegerAttribute(null, null,"valueBigInteger", object.valueBigInteger);
    }

    // field id (mapped with "id")
    xmlSerializer.writeStartElement("id");
    xmlSerializer.writeLong(object.id);
    xmlSerializer.writeEndElement();

    // field valueBigDecimal (mapped with "valueBigDecimal")
    if (object.valueBigDecimal!=null)  {
      xmlSerializer.writeCData(StringEscapeUtils.escapeXml10(BigDecimalUtils.write(object.valueBigDecimal)));
    }

    if (currentEventType == EventType.START_DOCUMENT) {
      xmlSerializer.writeEndElement();
    }
  }

  /**
   * parse with jackson
   */
  @Override
  public Bean81H parseOnJackson(JsonParser jacksonParser) throws Exception {
    Bean81H instance = new Bean81H();
    String fieldName;
    if (jacksonParser.currentToken() == null) {
      jacksonParser.nextToken();
    }
    if (jacksonParser.currentToken() != JsonToken.START_OBJECT) {
      jacksonParser.skipChildren();
      return instance;
    }
    while (jacksonParser.nextToken() != JsonToken.END_OBJECT) {
      fieldName = jacksonParser.getCurrentName();
      jacksonParser.nextToken();

      // Parse fields:
      switch (fieldName) {
          case "valueBigInteger":
            // field valueBigInteger (mapped with "valueBigInteger")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.valueBigInteger=BigIntegerUtils.read(jacksonParser.getText());
            }
          break;
          case "id":
            // field id (mapped with "id")
            instance.id=jacksonParser.getLongValue();
          break;
          case "valueBigDecimal":
            // field valueBigDecimal (mapped with "valueBigDecimal")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.valueBigDecimal=BigDecimalUtils.read(jacksonParser.getText());
            }
          break;
          default:
            jacksonParser.skipChildren();
          break;}
    }
    return instance;
  }

  /**
   * parse with jackson
   */
  @Override
  public Bean81H parseOnJacksonAsString(JsonParser jacksonParser) throws Exception {
    Bean81H instance = new Bean81H();
    String fieldName;
    if (jacksonParser.getCurrentToken() == null) {
      jacksonParser.nextToken();
    }
    if (jacksonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      jacksonParser.skipChildren();
      return instance;
    }
    while (jacksonParser.nextToken() != JsonToken.END_OBJECT) {
      fieldName = jacksonParser.getCurrentName();
      jacksonParser.nextToken();

      // Parse fields:
      switch (fieldName) {
          case "valueBigInteger":
            // field valueBigInteger (mapped with "valueBigInteger")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.valueBigInteger=BigIntegerUtils.read(jacksonParser.getText());
            }
          break;
          case "id":
            // field id (mapped with "id")
            instance.id=PrimitiveUtils.readLong(jacksonParser.getText(), 0L);
          break;
          case "valueBigDecimal":
            // field valueBigDecimal (mapped with "valueBigDecimal")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.valueBigDecimal=BigDecimalUtils.read(jacksonParser.getText());
            }
          break;
          default:
            jacksonParser.skipChildren();
          break;}
    }
    return instance;
  }

  /**
   * parse xml
   */
  @Override
  public Bean81H parseOnXml(XMLParser xmlParser, EventType currentEventType) throws Exception {
    Bean81H instance = new Bean81H();
    EventType eventType = currentEventType;
    boolean read=true;

    if (currentEventType == EventType.START_DOCUMENT) {
      eventType = xmlParser.next();
    } else {
      eventType = xmlParser.getEventType();
    }
    String currentTag = xmlParser.getName().toString();
    String elementName = currentTag;

    // attributes 
    String attributeName = null;
    int attributesCount = xmlParser.getAttributeCount();;
    for (int attributeIndex = 0; attributeIndex < attributesCount; attributeIndex++) {
      attributeName = xmlParser.getAttributeName(attributeIndex);
      switch(attributeName) {
          case "valueBigInteger":
            // field valueBigInteger (mapped by "valueBigInteger")
            instance.valueBigInteger=xmlParser.getAttributeAsInteger(attributeIndex);
          break;
          default:
          break;
      }
    }

    //sub-elements
    while (xmlParser.hasNext() && elementName!=null) {
      if (read) {
        eventType = xmlParser.next();
      } else {
        eventType = xmlParser.getEventType();
      }
      read=true;
      switch(eventType) {
          case START_TAG:
            currentTag = xmlParser.getName().toString();
            switch(currentTag) {
                case "id":
                  // property id (mapped on "id")
                  instance.id=PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L);
                break;
                default:
                  xmlParser.skipChildren();
                break;
              }
            break;
            case END_TAG:
              if (elementName.equals(xmlParser.getName())) {
                currentTag = elementName;
                elementName = null;
              }
            break;
            case CDSECT:
            case TEXT:
              if (elementName!=null && xmlParser.hasText()) {
                // property valueBigDecimal
                instance.valueBigDecimal=BigDecimalUtils.read(StringEscapeUtils.unescapeXml(xmlParser.getText()));
              }
            break;
            default:
            break;
        }
      }
      return instance;
    }
  }
