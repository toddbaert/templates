package org.outsrcd.sample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

    from("timer:someTimer?period=1000")
    .log("Camel context is running!")
    .bean(TestBean.class, "test");
	
	}
}