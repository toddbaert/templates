package org.outsrcd.sample;

import org.apache.camel.builder.RouteBuilder;

public class TestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {		

    // subscribe
    from("paho:{{topic}}?brokerUrl={{subscribe.url}}").id("subscriber {{subscribe.url}}")
      .transform(body().convertToString())
      .log("received message: ${body}");

    // publish
    from("timer:mqttRoute?period=2000").id("publisher {{publish.url}}")
      .log("publishing message...")
      .setBody(constant("<<< TEST MESSAGE >>>"))
      .to("paho:{{topic}}?brokerUrl={{publish.url}}");	
	}
}
