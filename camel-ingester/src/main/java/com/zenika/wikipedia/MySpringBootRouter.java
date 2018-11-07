package com.zenika.wikipedia;

import java.util.ArrayList;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.solr.SolrConstants;
import org.apache.camel.util.toolbox.FlexibleAggregationStrategy;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints
 * to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

  @Override
  public void configure() {
    from("file:{{data.input.directory}}?noop=true")
            .split(body().tokenize("\n"))
            .streaming()
            .parallelProcessing()
            .threads(4)
            .filter(new IsNotEsBulkMetaPredicate())
            .process(new ToPage())
            .to("{{ingest.endpoint.name}}");
            
    from("direct:solr")
            .process(new ToSolrDocument())
            .aggregate(new FlexibleAggregationStrategy().accumulateInCollection(ArrayList.class))
            .constant(true)
            .completionSize(1000)
            .completionInterval(5000)
            .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_INSERT))
            .setHeader(SolrConstants.PARAM + "commitWithin", constant(10000))
            .to("{{solr.endpoint.name}}")
            .to("log:foo")
            .end();
  }

}
