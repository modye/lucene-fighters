package com.zenika.wikipedia;

import java.util.ArrayList;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.solr.SolrConstants;
import org.apache.camel.util.toolbox.FlexibleAggregationStrategy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints
 * to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class MySpringBootRouter extends RouteBuilder {

  @Override
  public void configure() {
    from("file:{{data.input.directory}}?noop=true")
            .split(body().tokenize("\n"))
            .streaming()
            .aggregate(new FlexibleAggregationStrategy().accumulateInCollection(ArrayList.class))
            .constant(true)
            .completionSize(2)
            .process(new ToPage())
            .to("{{ingest.endpoint.name}}");
  }

}
