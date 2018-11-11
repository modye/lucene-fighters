package com.zenika.wikipedia.elasticsearch;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.util.toolbox.FlexibleAggregationStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Router used to ingest document in Elasticsearch.
 *
 * @author modye
 */
@Component
@Profile("elasticsearch")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ElasticsearchRouter extends RouteBuilder {

    private String ingestEndpoint;
    private String indexName;
    private String documentType;

    /**
     * Constructor, inject Spring beans.
     */
    public ElasticsearchRouter(CamelContext context,
                               @Value("${ingest.endpoint.name}") String ingestEndpoint,
                               @Value("${ingest.index.name}") String indexName,
                               @Value("${ingest.document.type}") String documentType) {
        super(context);
        this.ingestEndpoint = ingestEndpoint;
        this.indexName = indexName;
        this.documentType = documentType;
    }

    @Override
    public void configure() {
        from(ingestEndpoint)
                .process(new ToElasticsearchDocumentProcessor())
                .aggregate(new FlexibleAggregationStrategy().accumulateInCollection(ArrayList.class))
                .constant(true)
                .completionSize(1000)
                .completionInterval(5000)
                .to("elasticsearch-rest://elasticsearch?operation=BULK&indexName=" + indexName + "&indexType=" + documentType)
                .end();
    }
}
