package org.tate.yourspace;

import org.springframework.stereotype.Component;

@Component
public class FriendRequestService {
	
	public Response sayRequestMade()
	{
		Response response = new Response();
		response.setMessage("Thank you for your friend request");
		return response;		
	}
	
}
