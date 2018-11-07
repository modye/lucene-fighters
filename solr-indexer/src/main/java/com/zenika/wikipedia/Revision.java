package com.zenika.wikipedia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author lboutros
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "revision")
public class Revision {
  @XmlElement(required = true)
  protected String id;

  @XmlElement(required = true)
  protected String timestamp;
  
  @XmlElement()
  protected String text;  

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "Revision{" + "id=" + id + ", timestamp=" + timestamp + '}';
  }
}
