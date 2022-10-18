package shared.kripton47;

import com.abubusoft.kripton.AbstractMapper;
import com.abubusoft.kripton.BinderUtils;
import com.abubusoft.kripton.annotation.BindMap;
import com.abubusoft.kripton.escape.StringEscapeUtils;
import com.abubusoft.kripton.xml.EventType;
import com.abubusoft.kripton.xml.XMLParser;
import com.abubusoft.kripton.xml.XMLSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * This class is binder map for Security47
 *
 * @see Security47
 */
@BindMap(Security47.class)
public class Security47BindMap extends AbstractMapper<Security47> {
  /**
   * binder for type DeviceAccessToken
   */
  private DeviceAccessTokenBindMap deviceAccessTokenBindMap;

  /**
   * binder for type UserIdentity
   */
  private UserIdentityBindMap userIdentityBindMap;

  @Override
  public int serializeOnJackson(Security47 object, JsonGenerator jacksonSerializer) throws
      Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field authorizationToken (mapped with "authorizationToken")
    if (object.authorizationToken!=null)  {
      fieldCount++;
      jacksonSerializer.writeFieldName("authorizationToken");
      deviceAccessTokenBindMap.serializeOnJackson(object.authorizationToken, jacksonSerializer);
    }

    // field deviceUid (mapped with "deviceUid")
    if (object.deviceUid!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("deviceUid", object.deviceUid);
    }

    // field fcmId (mapped with "fcmId")
    if (object.fcmId!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("fcmId", object.fcmId);
    }

    // field userIdentity (mapped with "userIdentity")
    if (object.userIdentity!=null)  {
      fieldCount++;
      jacksonSerializer.writeFieldName("userIdentity");
      userIdentityBindMap.serializeOnJackson(object.userIdentity, jacksonSerializer);
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  @Override
  public int serializeOnJacksonAsString(Security47 object, JsonGenerator jacksonSerializer) throws
      Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field authorizationToken (mapped with "authorizationToken")
    if (object.authorizationToken!=null)  {
      fieldCount++;
      jacksonSerializer.writeFieldName("authorizationToken");
      if (deviceAccessTokenBindMap.serializeOnJacksonAsString(object.authorizationToken, jacksonSerializer)==0) {
        jacksonSerializer.writeNullField("authorizationToken");
      }
    }

    // field deviceUid (mapped with "deviceUid")
    if (object.deviceUid!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("deviceUid", object.deviceUid);
    }

    // field fcmId (mapped with "fcmId")
    if (object.fcmId!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("fcmId", object.fcmId);
    }

    // field userIdentity (mapped with "userIdentity")
    if (object.userIdentity!=null)  {
      fieldCount++;
      jacksonSerializer.writeFieldName("userIdentity");
      if (userIdentityBindMap.serializeOnJacksonAsString(object.userIdentity, jacksonSerializer)==0) {
        jacksonSerializer.writeNullField("userIdentity");
      }
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /**
   * method for xml serialization
   */
  @Override
  public void serializeOnXml(Security47 object, XMLSerializer xmlSerializer,
      EventType currentEventType) throws Exception {
    if (currentEventType == EventType.START_DOCUMENT) {
      xmlSerializer.writeStartElement("security47");
    }

    // Persisted fields:

    // field authorizationToken (mapped with "authorizationToken")
    if (object.authorizationToken!=null)  {
      xmlSerializer.writeStartElement("authorizationToken");
      deviceAccessTokenBindMap.serializeOnXml(object.authorizationToken, xmlSerializer, EventType.START_TAG);
      xmlSerializer.writeEndElement();
    }

    // field deviceUid (mapped with "deviceUid")
    if (object.deviceUid!=null) {
      xmlSerializer.writeStartElement("deviceUid");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.deviceUid));
      xmlSerializer.writeEndElement();
    }

    // field fcmId (mapped with "fcmId")
    if (object.fcmId!=null) {
      xmlSerializer.writeStartElement("fcmId");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.fcmId));
      xmlSerializer.writeEndElement();
    }

    // field userIdentity (mapped with "userIdentity")
    if (object.userIdentity!=null)  {
      xmlSerializer.writeStartElement("userIdentity");
      userIdentityBindMap.serializeOnXml(object.userIdentity, xmlSerializer, EventType.START_TAG);
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
  public Security47 parseOnJackson(JsonParser jacksonParser) throws Exception {
    Security47 instance = new Security47();
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
          case "authorizationToken":
            // field authorizationToken (mapped with "authorizationToken")
            if (jacksonParser.currentToken()==JsonToken.START_OBJECT) {
              instance.authorizationToken=deviceAccessTokenBindMap.parseOnJackson(jacksonParser);
            }
          break;
          case "deviceUid":
            // field deviceUid (mapped with "deviceUid")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.deviceUid=jacksonParser.getText();
            }
          break;
          case "fcmId":
            // field fcmId (mapped with "fcmId")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.fcmId=jacksonParser.getText();
            }
          break;
          case "userIdentity":
            // field userIdentity (mapped with "userIdentity")
            if (jacksonParser.currentToken()==JsonToken.START_OBJECT) {
              instance.userIdentity=userIdentityBindMap.parseOnJackson(jacksonParser);
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
  public Security47 parseOnJacksonAsString(JsonParser jacksonParser) throws Exception {
    Security47 instance = new Security47();
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
          case "authorizationToken":
            // field authorizationToken (mapped with "authorizationToken")
            if (jacksonParser.currentToken()==JsonToken.START_OBJECT || jacksonParser.currentToken()==JsonToken.VALUE_STRING) {
              instance.authorizationToken=deviceAccessTokenBindMap.parseOnJacksonAsString(jacksonParser);
            }
          break;
          case "deviceUid":
            // field deviceUid (mapped with "deviceUid")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.deviceUid=jacksonParser.getText();
            }
          break;
          case "fcmId":
            // field fcmId (mapped with "fcmId")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.fcmId=jacksonParser.getText();
            }
          break;
          case "userIdentity":
            // field userIdentity (mapped with "userIdentity")
            if (jacksonParser.currentToken()==JsonToken.START_OBJECT || jacksonParser.currentToken()==JsonToken.VALUE_STRING) {
              instance.userIdentity=userIdentityBindMap.parseOnJacksonAsString(jacksonParser);
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
  public Security47 parseOnXml(XMLParser xmlParser, EventType currentEventType) throws Exception {
    Security47 instance = new Security47();
    EventType eventType = currentEventType;
    boolean read=true;

    if (currentEventType == EventType.START_DOCUMENT) {
      eventType = xmlParser.next();
    } else {
      eventType = xmlParser.getEventType();
    }
    String currentTag = xmlParser.getName();
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
            currentTag = xmlParser.getName();
            switch(currentTag) {
                case "authorizationToken":
                  // property authorizationToken (mapped on "authorizationToken")
                  instance.authorizationToken=deviceAccessTokenBindMap.parseOnXml(xmlParser, eventType);
                break;
                case "deviceUid":
                  // property deviceUid (mapped on "deviceUid")
                  instance.deviceUid=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                break;
                case "fcmId":
                  // property fcmId (mapped on "fcmId")
                  instance.fcmId=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                break;
                case "userIdentity":
                  // property userIdentity (mapped on "userIdentity")
                  instance.userIdentity=userIdentityBindMap.parseOnXml(xmlParser, eventType);
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
      // if document is empty, the element is null
      if (currentEventType == EventType.START_DOCUMENT && eventType == EventType.END_DOCUMENT) {
          return null;
        } else {
          return instance;
        }
      }

      @Override
      public void init() {
        // binding maps initialization 
        deviceAccessTokenBindMap=BinderUtils.mapperFor(DeviceAccessToken.class);
        userIdentityBindMap=BinderUtils.mapperFor(UserIdentity.class);
      }
    }
