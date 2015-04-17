package com.mockqu.client;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MockquClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			 
			Client client = Client.create();
	 
			WebResource webResource = client
			   .resource("http://mockqu-noqu.rhcloud.com/rest/checkusers/login");
	 
			
			JSONObject jObj = new JSONObject();
			
			
			jObj.put("name", "Nitish");
			jObj.put("password", "xyz");
			
			//String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
	 
			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
			   .post(ClientResponse.class, jObj.toJSONString());
			
			/*ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
	 */
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}
	 
			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
	 
		  }
		
	}

}
