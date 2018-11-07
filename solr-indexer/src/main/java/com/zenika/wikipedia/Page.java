package com.zenika.wikipedia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "page")
/**
 *
 * @author lboutros
 */
public class Page {

  @XmlElement(required = true)
  protected String id;

  @XmlElement(required = true)
  protected String title;

  @XmlElement()
  protected Revision revision;

  @Override
  public String toString() {
    return "Page{" + "id=" + id + ", title=" + title + ", revision=" + revision + '}';
  }


  public Revision getRevision() {
    return revision;
  }

  public void setRevision(Revision revision) {
    this.revision = revision;
  }

  
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  
}
