package com.zenika.wikipedia;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mediawiki")
public class Mediawiki {
    @XmlElement(required = true)
    protected List<Page> records;

    public List<Page> getRecords() {
        if (records == null) {
            records = new ArrayList<Page>();
        }
        return records;
    }

  @Override
  public String toString() {
    return "Mediawiki{" + "records=" + records + '}';
  }
    
    
}