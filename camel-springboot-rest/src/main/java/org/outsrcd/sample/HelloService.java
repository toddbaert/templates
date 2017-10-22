package org.outsrcd.sample;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
	
	public Response sayHello()
	{
		Response response = new Response();
		response.setMessage("hello");
		return response;		
	}
	
}
