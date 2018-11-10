package com.zenika.wikipedia.elasticsearch;

import com.zenika.wikipedia.Page;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author modye
 */
public class ToElasticsearchDocument implements Processor {

    public ToElasticsearchDocument() {
    }

    public void process(Exchange exchange) throws Exception {
        Page page = exchange.getIn().getBody(Page.class);


        Map map = new HashMap();
        map.put("id", page.getId());
        map.put("title", page.getTitle());
        map.put("text", page.getText());
        map.put("wikibase_item", page.getWikibase_item());
        map.put("timestamp", page.getTimestamp());
        map.put("create_timestamp", page.getCreate_timestamp());
        map.put("popularity_score", page.getPopularity_score());
        map.put("template", page.getTemplate());
        map.put("category", page.getCategory());
        map.put("heading", page.getHeading());
        map.put("incoming_links", page.getIncoming_links());
        map.put("external_link", page.getExternal_link());
        map.put("outgoing_link", page.getOutgoing_link());
        map.put("version", page.getVersion());
        map.put("text_bytes", page.getText_bytes());

        exchange.getIn().setBody(map);
    }

}
