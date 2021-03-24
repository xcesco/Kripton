package bind.kripton70;

import com.abubusoft.kripton.AbstractMapper;
import com.abubusoft.kripton.annotation.BindMap;
import com.abubusoft.kripton.escape.StringEscapeUtils;
import com.abubusoft.kripton.xml.EventType;
import com.abubusoft.kripton.xml.XMLParser;
import com.abubusoft.kripton.xml.XMLSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * This class is binder map for Bean70A
 *
 * @see Bean70A
 */
@BindMap(Bean70A.class)
public class Bean70ABindMap extends AbstractMapper<Bean70A> {
  /**
   * Bean70ABindMap */
  private Bean70ABindMap bean70ABindMap = this;

  @Override
  public int serializeOnJackson(Bean70A object, JsonGenerator jacksonSerializer) throws Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field valueBean (mapped with "valueBean")
    if (object.valueBean!=null)  {
      fieldCount++;
      jacksonSerializer.writeFieldName("valueBean");
      bean70ABindMap.serializeOnJackson(object.valueBean, jacksonSerializer);
    }

    // field valueString (mapped with "valueString")
    if (object.valueString!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("valueString", object.valueString);
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  @Override
  public int serializeOnJacksonAsString(Bean70A object, JsonGenerator jacksonSerializer) throws
      Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field valueBean (mapped with "valueBean")
    if (object.valueBean!=null)  {
      fieldCount++;
      jacksonSerializer.writeFieldName("valueBean");
      if (bean70ABindMap.serializeOnJacksonAsString(object.valueBean, jacksonSerializer)==0) {
        jacksonSerializer.writeNullField("valueBean");
      }
    }

    // field valueString (mapped with "valueString")
    if (object.valueString!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("valueString", object.valueString);
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /**
   * method for xml serialization
   */
  @Override
  public void serializeOnXml(Bean70A object, XMLSerializer xmlSerializer,
      EventType currentEventType) throws Exception {
    if (currentEventType == EventType.START_DOCUMENT) {
      xmlSerializer.writeStartElement("root");
    }

    // Persisted fields:

    // field valueBean (mapped with "valueBean")
    if (object.valueBean!=null)  {
      xmlSerializer.writeStartElement("valueBean");
      bean70ABindMap.serializeOnXml(object.valueBean, xmlSerializer, EventType.START_TAG);
      xmlSerializer.writeEndElement();
    }

    // field valueString (mapped with "valueString")
    if (object.valueString!=null) {
      xmlSerializer.writeStartElement("valueString");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.valueString));
      xmlSerializer.writeEndElement();
    }

    if (currentEventType == EventType.START_DOCUMENT) {
      xmlSerializer.writeEndElement();
    }
  }

  /**
   * parse with jackson
   */
  @Override
  public Bean70A parseOnJackson(JsonParser jacksonParser) throws Exception {
    Bean70A instance = new Bean70A();
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
          case "valueBean":
            // field valueBean (mapped with "valueBean")
            if (jacksonParser.currentToken()==JsonToken.START_OBJECT) {
              instance.valueBean=bean70ABindMap.parseOnJackson(jacksonParser);
            }
          break;
          case "valueString":
            // field valueString (mapped with "valueString")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.valueString=jacksonParser.getText();
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
  public Bean70A parseOnJacksonAsString(JsonParser jacksonParser) throws Exception {
    Bean70A instance = new Bean70A();
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
          case "valueBean":
            // field valueBean (mapped with "valueBean")
            if (jacksonParser.currentToken()==JsonToken.START_OBJECT || jacksonParser.currentToken()==JsonToken.VALUE_STRING) {
              instance.valueBean=bean70ABindMap.parseOnJacksonAsString(jacksonParser);
            }
          break;
          case "valueString":
            // field valueString (mapped with "valueString")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.valueString=jacksonParser.getText();
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
  public Bean70A parseOnXml(XMLParser xmlParser, EventType currentEventType) throws Exception {
    Bean70A instance = new Bean70A();
    EventType eventType = currentEventType;
    boolean read=true;

    if (currentEventType == EventType.START_DOCUMENT) {
      eventType = xmlParser.next();
    } else {
      eventType = xmlParser.getEventType();
    }
    String currentTag = xmlParser.getName().toString();
    String elementName = currentTag;
    // No attributes found

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
                case "valueBean":
                  // property valueBean (mapped on "valueBean")
                  instance.valueBean=bean70ABindMap.parseOnXml(xmlParser, eventType);
                break;
                case "valueString":
                  // property valueString (mapped on "valueString")
                  instance.valueString=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
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
              // no property is binded to VALUE o CDATA break;
            default:
            break;
        }
      }
      return instance;
    }

    @Override
    public void init() {
      // binding maps initialization 
    }
  }
