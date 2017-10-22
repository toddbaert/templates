package org.outsrcd.sample;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class HelloRestRoute extends RouteBuilder {
  
  @Override
  public void configure() throws Exception {       
      
      // configure rest, context path is optional
      restConfiguration()
        .component("jetty")
        .port(1337)
        .contextPath("api")
        .bindingMode(RestBindingMode.json);
      
      // "say" is optional here.
      rest("/say").get("/hello")
        .to("bean:helloService?method=sayHello");   

  }
}
