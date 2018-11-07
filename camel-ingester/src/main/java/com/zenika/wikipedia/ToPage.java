package com.zenika.wikipedia;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author lboutros
 */
public class ToPage implements Processor {
  private final static ObjectMapper MAPPER = new ObjectMapper();
  
  static {
    MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public ToPage() {
  }

  public void process(Exchange exchange) throws Exception {
    String json = exchange.getIn().getBody(String.class);
    
    Page page = MAPPER.readValue(json, Page.class);
    
    exchange.getIn().setBody(page);    
  }
  
}
