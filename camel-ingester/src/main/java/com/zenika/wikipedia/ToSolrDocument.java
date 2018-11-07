package com.zenika.wikipedia;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author lboutros
 */
public class ToSolrDocument implements Processor {
  
  public ToSolrDocument() {
  }

  public void process(Exchange exchange) throws Exception {
    Page page = exchange.getIn().getBody(Page.class);
    
    SolrInputDocument document = new SolrInputDocument();
    document.setField("id", page.getWikibase_item());
    document.setField("title_txt_en", page.getTitle());
    
    exchange.getIn().setBody(document);
  }
  
}
