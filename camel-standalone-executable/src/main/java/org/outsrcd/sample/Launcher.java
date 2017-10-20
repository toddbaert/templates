package org.outsrcd.sample;

import org.apache.camel.CamelContext;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

public class Launcher {

  public static void main(String... args) throws Exception {

    SimpleRegistry reg = new SimpleRegistry();

    // get properties file so we can add it to the context
    PropertiesComponent props = new PropertiesComponent();
    props.setLocation("classpath:config.properties");

    // start the context, passing in the replay directory to scan
    CamelContext context = new DefaultCamelContext(reg);
    context.addComponent("properties", props);
    context.addRoutes(new TestRoute());
    context.start();

    // wait
    Thread.currentThread().join();
  }
}
