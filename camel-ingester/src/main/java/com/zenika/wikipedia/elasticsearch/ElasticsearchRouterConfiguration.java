package com.zenika.wikipedia.elasticsearch;

import org.apache.camel.CamelContext;
import org.apache.camel.component.elasticsearch.ElasticsearchComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configure {@link ElasticsearchComponent} used in the application.
 * Could be done using Srpong Boot properties.
 *
 * @author modye
 */
@Configuration
@Profile("elasticsearch")
public class ElasticsearchRouterConfiguration {

    @Bean
    public ElasticsearchComponent elasticsearchComponent(@Autowired CamelContext context) {
        ElasticsearchComponent elasticsearchComponent = new ElasticsearchComponent();
        elasticsearchComponent.setHostAddresses("localhost:9200");
        context.addComponent("elasticsearch-rest", elasticsearchComponent);
        return elasticsearchComponent;
    }
}


