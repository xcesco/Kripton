package sqlite.feature.contentprovider.kripton35.entities;

import com.abubusoft.kripton.AbstractMapper;
import com.abubusoft.kripton.annotation.BindMap;
import com.abubusoft.kripton.common.DateUtils;
import com.abubusoft.kripton.common.PrimitiveUtils;
import com.abubusoft.kripton.escape.StringEscapeUtils;
import com.abubusoft.kripton.xml.EventType;
import com.abubusoft.kripton.xml.XMLParser;
import com.abubusoft.kripton.xml.XMLSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * This class is binder map for Person
 *
 * @see Person
 */
@BindMap(Person.class)
public class PersonBindMap extends AbstractMapper<Person> {
  @Override
  public int serializeOnJackson(Person object, JsonGenerator jacksonSerializer) throws Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field birthCity (mapped with "birthCity")
    if (object.birthCity!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("birthCity", object.birthCity);
    }

    // field birthDay (mapped with "birthDay")
    if (object.birthDay!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("birthDay", DateUtils.write(object.birthDay));
    }

    // field city (mapped with "city")
    fieldCount++;
    jacksonSerializer.writeNumberField("city", object.city);

    // field id (mapped with "id")
    fieldCount++;
    jacksonSerializer.writeNumberField("id", object.id);

    // field name (mapped with "name")
    if (object.getName()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("name", object.getName());
    }

    // field parentId (mapped with "parentId")
    fieldCount++;
    jacksonSerializer.writeNumberField("parentId", object.parentId);

    // field surname (mapped with "surname")
    if (object.getSurname()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("surname", object.getSurname());
    }

    // field value (mapped with "value")
    fieldCount++;
    jacksonSerializer.writeNumberField("value", object.value);

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  @Override
  public int serializeOnJacksonAsString(Person object, JsonGenerator jacksonSerializer) throws
      Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field birthCity (mapped with "birthCity")
    if (object.birthCity!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("birthCity", object.birthCity);
    }

    // field birthDay (mapped with "birthDay")
    if (object.birthDay!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("birthDay", DateUtils.write(object.birthDay));
    }

    // field city (mapped with "city")
    jacksonSerializer.writeStringField("city", PrimitiveUtils.writeLong(object.city));

    // field id (mapped with "id")
    jacksonSerializer.writeStringField("id", PrimitiveUtils.writeLong(object.id));

    // field name (mapped with "name")
    if (object.getName()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("name", object.getName());
    }

    // field parentId (mapped with "parentId")
    jacksonSerializer.writeStringField("parentId", PrimitiveUtils.writeLong(object.parentId));

    // field surname (mapped with "surname")
    if (object.getSurname()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("surname", object.getSurname());
    }

    // field value (mapped with "value")
    jacksonSerializer.writeStringField("value", PrimitiveUtils.writeLong(object.value));

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /**
   * method for xml serialization
   */
  @Override
  public void serializeOnXml(Person object, XMLSerializer xmlSerializer, EventType currentEventType)
      throws Exception {
    if (currentEventType == EventType.START_DOCUMENT) {
      xmlSerializer.writeStartElement("person");
    }

    // Persisted fields:

    // field birthCity (mapped with "birthCity")
    if (object.birthCity!=null) {
      xmlSerializer.writeStartElement("birthCity");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.birthCity));
      xmlSerializer.writeEndElement();
    }

    // field birthDay (mapped with "birthDay")
    if (object.birthDay!=null)  {
      xmlSerializer.writeStartElement("birthDay");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(DateUtils.write(object.birthDay)));
      xmlSerializer.writeEndElement();
    }

    // field city (mapped with "city")
    xmlSerializer.writeStartElement("city");
    xmlSerializer.writeLong(object.city);
    xmlSerializer.writeEndElement();

    // field id (mapped with "id")
    xmlSerializer.writeStartElement("id");
    xmlSerializer.writeLong(object.id);
    xmlSerializer.writeEndElement();

    // field name (mapped with "name")
    if (object.getName()!=null) {
      xmlSerializer.writeStartElement("name");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.getName()));
      xmlSerializer.writeEndElement();
    }

    // field parentId (mapped with "parentId")
    xmlSerializer.writeStartElement("parentId");
    xmlSerializer.writeLong(object.parentId);
    xmlSerializer.writeEndElement();

    // field surname (mapped with "surname")
    if (object.getSurname()!=null) {
      xmlSerializer.writeStartElement("surname");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.getSurname()));
      xmlSerializer.writeEndElement();
    }

    // field value (mapped with "value")
    xmlSerializer.writeStartElement("value");
    xmlSerializer.writeLong(object.value);
    xmlSerializer.writeEndElement();

    if (currentEventType == EventType.START_DOCUMENT) {
      xmlSerializer.writeEndElement();
    }
  }

  /**
   * parse with jackson
   */
  @Override
  public Person parseOnJackson(JsonParser jacksonParser) throws Exception {
    Person instance = new Person();
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
          case "birthCity":
            // field birthCity (mapped with "birthCity")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.birthCity=jacksonParser.getText();
            }
          break;
          case "birthDay":
            // field birthDay (mapped with "birthDay")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.birthDay=DateUtils.read(jacksonParser.getText());
            }
          break;
          case "city":
            // field city (mapped with "city")
            instance.city=jacksonParser.getLongValue();
          break;
          case "id":
            // field id (mapped with "id")
            instance.id=jacksonParser.getLongValue();
          break;
          case "name":
            // field name (mapped with "name")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setName(jacksonParser.getText());
            }
          break;
          case "parentId":
            // field parentId (mapped with "parentId")
            instance.parentId=jacksonParser.getLongValue();
          break;
          case "surname":
            // field surname (mapped with "surname")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setSurname(jacksonParser.getText());
            }
          break;
          case "value":
            // field value (mapped with "value")
            instance.value=jacksonParser.getLongValue();
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
  public Person parseOnJacksonAsString(JsonParser jacksonParser) throws Exception {
    Person instance = new Person();
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
          case "birthCity":
            // field birthCity (mapped with "birthCity")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.birthCity=jacksonParser.getText();
            }
          break;
          case "birthDay":
            // field birthDay (mapped with "birthDay")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.birthDay=DateUtils.read(jacksonParser.getText());
            }
          break;
          case "city":
            // field city (mapped with "city")
            instance.city=PrimitiveUtils.readLong(jacksonParser.getText(), 0L);
          break;
          case "id":
            // field id (mapped with "id")
            instance.id=PrimitiveUtils.readLong(jacksonParser.getText(), 0L);
          break;
          case "name":
            // field name (mapped with "name")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setName(jacksonParser.getText());
            }
          break;
          case "parentId":
            // field parentId (mapped with "parentId")
            instance.parentId=PrimitiveUtils.readLong(jacksonParser.getText(), 0L);
          break;
          case "surname":
            // field surname (mapped with "surname")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setSurname(jacksonParser.getText());
            }
          break;
          case "value":
            // field value (mapped with "value")
            instance.value=PrimitiveUtils.readLong(jacksonParser.getText(), 0L);
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
  public Person parseOnXml(XMLParser xmlParser, EventType currentEventType) throws Exception {
    Person instance = new Person();
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
                case "birthCity":
                  // property birthCity (mapped on "birthCity")
                  instance.birthCity=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                break;
                case "birthDay":
                  // property birthDay (mapped on "birthDay")
                  instance.birthDay=DateUtils.read(StringEscapeUtils.unescapeXml(xmlParser.getElementText()));
                break;
                case "city":
                  // property city (mapped on "city")
                  instance.city=PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L);
                break;
                case "id":
                  // property id (mapped on "id")
                  instance.id=PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L);
                break;
                case "name":
                  // property name (mapped on "name")
                  instance.setName(StringEscapeUtils.unescapeXml(xmlParser.getElementText()));
                break;
                case "parentId":
                  // property parentId (mapped on "parentId")
                  instance.parentId=PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L);
                break;
                case "surname":
                  // property surname (mapped on "surname")
                  instance.setSurname(StringEscapeUtils.unescapeXml(xmlParser.getElementText()));
                break;
                case "value":
                  // property value (mapped on "value")
                  instance.value=PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L);
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
