package com.zenika.wikipedia.elasticsearch;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.util.toolbox.FlexibleAggregationStrategy;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author modye
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ElasticsearchRouter extends RouteBuilder {

    public ElasticsearchRouter(CamelContext context) {
        super(context);
    }

    @Autowired
    private CamelContext camelContext;


    @Override
    public void configure() throws SolrServerException, IOException {

        from("direct:es")
                .id("test-ingest")
                .process(new ToElasticsearchDocument())
                .aggregate(new FlexibleAggregationStrategy().accumulateInCollection(ArrayList.class))
                .constant(true)
                .completionSize(1000)
                .completionInterval(5000)
                .to("elasticsearch-rest://elasticsearch?operation=INDEX&indexName=wikitest&indexType=doc")
                .end();
    }
}
