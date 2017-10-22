package org.outsrcd.sample;

import org.apache.camel.CamelContext;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

public class Launcher {

  public static void main(String... args) throws Exception {
    
    if (args.length != 3 ||
        args[0] == null ||
        args[1] == null ||
        args[2] == null ||
        args[0].equals("") ||
        args[1].equals("") ||
        args[2].equals("")) {
      System.out.println("pleae add args publish url, subscribe url and topic in the form some/topic/address");
    }
    
    System.out.println("publishing to " + args[0] + ", subcribing to " + args[1] + ", topic: " + args[2]);
    
    System.setProperty("publish.url", args[0]);
    System.setProperty("subscribe.url", args[1]);
    System.setProperty("topic", args[2]);

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
