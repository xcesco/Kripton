package bind.kripton81morecoveragetests;

import com.abubusoft.kripton.AbstractMapper;
import com.abubusoft.kripton.annotation.BindMap;
import com.abubusoft.kripton.common.CollectionUtils;
import com.abubusoft.kripton.common.PrimitiveUtils;
import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.escape.StringEscapeUtils;
import com.abubusoft.kripton.xml.EventType;
import com.abubusoft.kripton.xml.XMLParser;
import com.abubusoft.kripton.xml.XMLSerializer;
import com.abubusoft.kripton.xml.XmlAttributeUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is binder map for Bean81V4
 *
 * @see Bean81V4
 */
@BindMap(Bean81V4.class)
public class Bean81V4BindMap extends AbstractMapper<Bean81V4> {
  @Override
  public int serializeOnJackson(Bean81V4 object, JsonGenerator jacksonSerializer) throws Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field id (mapped with "id")
    fieldCount++;
    jacksonSerializer.writeNumberField("id", object.id);

    // field valueByteArray (mapped with "valueByteArray")
    if (object.valueByteArray!=null)  {
      fieldCount++;
      int n=object.valueByteArray.length;
      Byte item;
      // write wrapper tag
      jacksonSerializer.writeFieldName("valueByteArray");
      jacksonSerializer.writeStartArray();
      for (int i=0; i<n; i++) {
        item=object.valueByteArray[i];
        if (item==null) {
          jacksonSerializer.writeNull();
        } else {
          jacksonSerializer.writeNumber(item);
        }
      }
      jacksonSerializer.writeEndArray();
    }

    // field valueIntegerList (mapped with "valueIntegerList")
    if (object.valueIntegerList!=null)  {
      fieldCount++;
      int n=object.valueIntegerList.size();
      Integer item;
      // write wrapper tag
      jacksonSerializer.writeFieldName("valueIntegerList");
      jacksonSerializer.writeStartArray();
      for (int i=0; i<n; i++) {
        item=object.valueIntegerList.get(i);
        if (item==null) {
          jacksonSerializer.writeNull();
        } else {
          jacksonSerializer.writeNumber(item);
        }
      }
      jacksonSerializer.writeEndArray();
    }

    // field valueMapStringInteger (mapped with "valueMapStringInteger")
    if (object.valueMapStringInteger!=null)  {
      fieldCount++;
      // write wrapper tag
      if (object.valueMapStringInteger.size()>0) {
        jacksonSerializer.writeFieldName("valueMapStringInteger");
        jacksonSerializer.writeStartArray();
        for (Map.Entry<String, Integer> item: object.valueMapStringInteger.entrySet()) {
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
        jacksonSerializer.writeNullField("valueMapStringInteger");
      }
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  @Override
  public int serializeOnJacksonAsString(Bean81V4 object, JsonGenerator jacksonSerializer) throws
      Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field id (mapped with "id")
    jacksonSerializer.writeStringField("id", PrimitiveUtils.writeLong(object.id));

    // field valueByteArray (mapped with "valueByteArray")
    if (object.valueByteArray!=null)  {
      fieldCount++;
      int n=object.valueByteArray.length;
      Byte item;
      // write wrapper tag
      jacksonSerializer.writeFieldName("valueByteArray");
      if (n>0) {
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=object.valueByteArray[i];
          if (item==null) {
            jacksonSerializer.writeString("null");
          } else {
            jacksonSerializer.writeString(PrimitiveUtils.writeByte(item));
          }
        }
        jacksonSerializer.writeEndArray();
      } else {
        jacksonSerializer.writeString("");
      }
    }

    // field valueIntegerList (mapped with "valueIntegerList")
    if (object.valueIntegerList!=null)  {
      fieldCount++;
      int n=object.valueIntegerList.size();
      Integer item;
      // write wrapper tag
      jacksonSerializer.writeFieldName("valueIntegerList");
      if (n>0) {
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=object.valueIntegerList.get(i);
          if (item==null) {
            jacksonSerializer.writeString("null");
          } else {
            jacksonSerializer.writeString(PrimitiveUtils.writeInteger(item));
          }
        }
        jacksonSerializer.writeEndArray();
      } else {
        jacksonSerializer.writeString("");
      }
    }

    // field valueMapStringInteger (mapped with "valueMapStringInteger")
    if (object.valueMapStringInteger!=null)  {
      fieldCount++;
      // write wrapper tag
      if (object.valueMapStringInteger.size()>0) {
        jacksonSerializer.writeFieldName("valueMapStringInteger");
        jacksonSerializer.writeStartArray();
        for (Map.Entry<String, Integer> item: object.valueMapStringInteger.entrySet()) {
          jacksonSerializer.writeStartObject();
          jacksonSerializer.writeStringField("key", item.getKey());
          if (item.getValue()==null) {
            jacksonSerializer.writeStringField("value", "null");
          } else {
            jacksonSerializer.writeStringField("value", PrimitiveUtils.writeInteger(item.getValue()));
          }
          jacksonSerializer.writeEndObject();
        }
        jacksonSerializer.writeEndArray();
      } else {
        jacksonSerializer.writeStringField("valueMapStringInteger", "null");
      }
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /**
   * method for xml serialization
   */
  @Override
  public void serializeOnXml(Bean81V4 object, XMLSerializer xmlSerializer,
      EventType currentEventType) throws Exception {
    if (currentEventType == EventType.START_DOCUMENT) {
      xmlSerializer.writeStartElement("bean81V4");
    }

    // Persisted fields:

    // field id (mapped with "id")
    xmlSerializer.writeStartElement("id");
    xmlSerializer.writeLong(object.id);
    xmlSerializer.writeEndElement();

    // field valueByteArray (mapped with "valueByteArray")
    if (object.valueByteArray!=null)  {
      int n=object.valueByteArray.length;
      Byte item;
      for (int i=0; i<n; i++) {
        item=object.valueByteArray[i];
        if (item==null) {
          xmlSerializer.writeEmptyElement("valueByteArray");
        } else {
          xmlSerializer.writeStartElement("valueByteArray");
          xmlSerializer.writeInt(item);
          xmlSerializer.writeEndElement();
        }
      }
      // to distinguish between first empty element and empty collection, we write an attribute emptyCollection
      if (n==0) {
        xmlSerializer.writeStartElement("valueByteArray");
        xmlSerializer.writeAttribute("emptyCollection", "true");
        xmlSerializer.writeEndElement();
      }
    }

    // field valueIntegerList (mapped with "valueIntegerList")
    if (object.valueIntegerList!=null)  {
      int n=object.valueIntegerList.size();
      Integer item;
      for (int i=0; i<n; i++) {
        item=object.valueIntegerList.get(i);
        if (item==null) {
          xmlSerializer.writeEmptyElement("valueIntegerList");
        } else {
          xmlSerializer.writeStartElement("valueIntegerList");
          xmlSerializer.writeInt(item);
          xmlSerializer.writeEndElement();
        }
      }
      // to distinguish between first empty element and empty collection, we write an attribute emptyCollection
      if (n==0) {
        xmlSerializer.writeStartElement("valueIntegerList");
        xmlSerializer.writeAttribute("emptyCollection", "true");
        xmlSerializer.writeEndElement();
      }
    }

    // field valueMapStringInteger (mapped with "valueMapStringInteger")
    if (object.valueMapStringInteger!=null)  {
      for (Map.Entry<String, Integer> item: object.valueMapStringInteger.entrySet()) {
        xmlSerializer.writeStartElement("valueMapStringInteger");
          if (item.getKey()!=null) {
            xmlSerializer.writeStartElement("key");
            xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(item.getKey()));
            xmlSerializer.writeEndElement();
          }
          if (item.getValue()==null) {
            xmlSerializer.writeEmptyElement("value");
          } else {
            if (item.getValue()!=null)  {
              xmlSerializer.writeStartElement("value");
              xmlSerializer.writeInt(item.getValue());
              xmlSerializer.writeEndElement();
            }
          }
        xmlSerializer.writeEndElement();
      }
    }

    if (currentEventType == EventType.START_DOCUMENT) {
      xmlSerializer.writeEndElement();
    }
  }

  /**
   * parse with jackson
   */
  @Override
  public Bean81V4 parseOnJackson(JsonParser jacksonParser) throws Exception {
    Bean81V4 instance = new Bean81V4();
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
          case "id":
            // field id (mapped with "id")
            instance.id=jacksonParser.getLongValue();
          break;
          case "valueByteArray":
            // field valueByteArray (mapped with "valueByteArray")
            if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
              ArrayList<Byte> collection=new ArrayList<>();
              Byte item=null;
              while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
                if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
                  item=null;
                } else {
                  item=jacksonParser.getByteValue();
                }
                collection.add(item);
              }
              instance.valueByteArray=CollectionUtils.asByteArray(collection);
            }
          break;
          case "valueIntegerList":
            // field valueIntegerList (mapped with "valueIntegerList")
            if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
              ArrayList<Integer> collection=new ArrayList<>();
              Integer item=null;
              while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
                if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
                  item=null;
                } else {
                  item=jacksonParser.getIntValue();
                }
                collection.add(item);
              }
              instance.valueIntegerList=collection;
            }
          break;
          case "valueMapStringInteger":
            // field valueMapStringInteger (mapped with "valueMapStringInteger")
            if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
              HashMap<String, Integer> collection=new HashMap<>();
              String key=null;
              Integer value=null;
              while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
                jacksonParser.nextValue();
                key=jacksonParser.getText();
                jacksonParser.nextValue();
                if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
                  value=jacksonParser.getIntValue();
                }
                collection.put(key, value);
                key=null;
                value=null;
                jacksonParser.nextToken();
              }
              instance.valueMapStringInteger=collection;
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
  public Bean81V4 parseOnJacksonAsString(JsonParser jacksonParser) throws Exception {
    Bean81V4 instance = new Bean81V4();
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
          case "id":
            // field id (mapped with "id")
            instance.id=PrimitiveUtils.readLong(jacksonParser.getText(), 0L);
          break;
          case "valueByteArray":
            // field valueByteArray (mapped with "valueByteArray")
            if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
              ArrayList<Byte> collection=new ArrayList<>();
              Byte item=null;
              String tempValue=null;
              while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
                tempValue=jacksonParser.getValueAsString();
                if (jacksonParser.currentToken()==JsonToken.VALUE_STRING && "null".equals(tempValue)) {
                  item=null;
                } else {
                  item=PrimitiveUtils.readByte(jacksonParser.getText(), null);
                }
                collection.add(item);
              }
              instance.valueByteArray=CollectionUtils.asByteArray(collection);
            } else if (jacksonParser.currentToken()==JsonToken.VALUE_STRING && !StringUtils.hasText(jacksonParser.getValueAsString())) {
              ArrayList<Byte> collection=new ArrayList<>();
              instance.valueByteArray=CollectionUtils.asByteArray(collection);
            }
          break;
          case "valueIntegerList":
            // field valueIntegerList (mapped with "valueIntegerList")
            if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
              ArrayList<Integer> collection=new ArrayList<>();
              Integer item=null;
              String tempValue=null;
              while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
                tempValue=jacksonParser.getValueAsString();
                if (jacksonParser.currentToken()==JsonToken.VALUE_STRING && "null".equals(tempValue)) {
                  item=null;
                } else {
                  item=PrimitiveUtils.readInteger(jacksonParser.getText(), null);
                }
                collection.add(item);
              }
              instance.valueIntegerList=collection;
            } else if (jacksonParser.currentToken()==JsonToken.VALUE_STRING && !StringUtils.hasText(jacksonParser.getValueAsString())) {
              ArrayList<Integer> collection=new ArrayList<>();
              instance.valueIntegerList=collection;
            }
          break;
          case "valueMapStringInteger":
            // field valueMapStringInteger (mapped with "valueMapStringInteger")
            if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
              HashMap<String, Integer> collection=new HashMap<>();
              String key=null;
              Integer value=null;
              JsonToken current;
              String tempValue=null;
              while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
                current=jacksonParser.currentToken();
                for (int i=0; i<2 ;i++) {
                  while (current != JsonToken.FIELD_NAME) {
                    current=jacksonParser.nextToken();
                  }
                  jacksonParser.nextValue();
                  switch(jacksonParser.getCurrentName()) {
                  case "key":
                    if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
                      key=jacksonParser.getText();
                    }
                  break;
                  case "value":
                    tempValue=jacksonParser.getValueAsString();
                    if (jacksonParser.currentToken()==JsonToken.VALUE_STRING && "null".equals(tempValue)) {
                      value=null;
                    } else {
                      if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
                        value=PrimitiveUtils.readInteger(jacksonParser.getText(), null);
                      }
                    }
                  break;
                  }
                }
                collection.put(key, value);
                key=null;
                value=null;
                jacksonParser.nextToken();
              }
              instance.valueMapStringInteger=collection;
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
  public Bean81V4 parseOnXml(XMLParser xmlParser, EventType currentEventType) throws Exception {
    Bean81V4 instance = new Bean81V4();
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
                case "id":
                  // property id (mapped on "id")
                  instance.id=PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L);
                break;
                case "valueByteArray":
                  // property valueByteArray (mapped on "valueByteArray")
                   {
                    ArrayList<Byte> collection=CollectionUtils.merge(new ArrayList<>(), instance.valueByteArray);
                    Byte item;
                    // add first element
                    item=null;
                    if (XmlAttributeUtils.isEmptyTag(xmlParser)) {
                      // if there's a an empty collection it marked with attribute emptyCollection
                      if (XmlAttributeUtils.getAttributeAsBoolean(xmlParser, "emptyCollection", false)==false) {
                        collection.add(item);
                      }
                      xmlParser.nextTag();
                    } else {
                      item=(byte)PrimitiveUtils.readByte(xmlParser.getElementAsInt(), null);
                      collection.add(item);
                    }
                    while (xmlParser.nextTag() != EventType.END_TAG && xmlParser.getName().toString().equals("valueByteArray")) {
                      if (XmlAttributeUtils.isEmptyTag(xmlParser)) {
                        item=null;
                        xmlParser.nextTag();
                      } else {
                        item=(byte)PrimitiveUtils.readByte(xmlParser.getElementAsInt(), null);
                      }
                      collection.add(item);
                    }
                    instance.valueByteArray=CollectionUtils.asByteArray(collection);
                    read=false;
                  }
                break;
                case "valueIntegerList":
                  // property valueIntegerList (mapped on "valueIntegerList")
                   {
                    ArrayList<Integer> collection=CollectionUtils.merge(new ArrayList<>(), instance.valueIntegerList);
                    Integer item;
                    // add first element
                    item=null;
                    if (XmlAttributeUtils.isEmptyTag(xmlParser)) {
                      // if there's a an empty collection it marked with attribute emptyCollection
                      if (XmlAttributeUtils.getAttributeAsBoolean(xmlParser, "emptyCollection", false)==false) {
                        collection.add(item);
                      }
                      xmlParser.nextTag();
                    } else {
                      item=PrimitiveUtils.readInteger(xmlParser.getElementAsInt(), null);
                      collection.add(item);
                    }
                    while (xmlParser.nextTag() != EventType.END_TAG && xmlParser.getName().toString().equals("valueIntegerList")) {
                      if (XmlAttributeUtils.isEmptyTag(xmlParser)) {
                        item=null;
                        xmlParser.nextTag();
                      } else {
                        item=PrimitiveUtils.readInteger(xmlParser.getElementAsInt(), null);
                      }
                      collection.add(item);
                    }
                    instance.valueIntegerList=collection;
                    read=false;
                  }
                break;
                case "valueMapStringInteger":
                  // property valueMapStringInteger (mapped on "valueMapStringInteger")
                   {
                    HashMap<String, Integer> collection=new HashMap<>();
                    String key;
                    Integer value;
                    // add first element
                    xmlParser.nextTag();
                    key=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                    xmlParser.nextTag();
                    if (xmlParser.isEmptyElement()) {
                      value=null;
                      xmlParser.nextTag();
                    } else {
                      value=PrimitiveUtils.readInteger(xmlParser.getElementAsInt(), null);
                    }
                    xmlParser.nextTag();
                    collection.put(key, value);
                    while (xmlParser.nextTag() != EventType.END_TAG && xmlParser.getName().toString().equals("valueMapStringInteger")) {
                      xmlParser.nextTag();
                      key=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                      xmlParser.nextTag();
                      if (xmlParser.isEmptyElement()) {
                        value=null;
                        xmlParser.nextTag();
                      } else {
                        value=PrimitiveUtils.readInteger(xmlParser.getElementAsInt(), null);
                      }
                      xmlParser.nextTag();
                      collection.put(key, value);
                    }
                    instance.valueMapStringInteger=collection;
                    read=false;
                  }
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
      }
    }
