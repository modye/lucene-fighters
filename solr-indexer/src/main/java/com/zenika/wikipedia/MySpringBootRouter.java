package com.zenika.wikipedia;

import java.util.ArrayList;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.solr.SolrConstants;
import static org.apache.camel.component.stax.StAXBuilder.stax;
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
    from("file:/projets/tests/documents/big?noop=true")
            .split(stax(Page.class,false))
            .streaming()
            
            .process(new ToSolrDocument())
            .aggregate(new FlexibleAggregationStrategy().accumulateInCollection(ArrayList.class))
              .constant(true)
              .completionSize(1000)
              .completionInterval(5000)

            .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_INSERT))
            .setHeader(SolrConstants.PARAM + "commitWithin", constant(10000))
            .to("solrCloud:localhost:8983/solr?zkHost=localhost:9983&collection=wikipedia")
            .to("log:foo")
            .end();
  }

}
