package com.mavenproj;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import resources.BaseRestAPI;

public class NewTestPOst extends BaseRestAPI {
	private RequestSpecification request;
	Response response;
	String baseURI="http://dummy.restapiexample.com/api/v1";
	@BeforeMethod
	  public void beforeMethod() {
		
		request=RequestwithoutToken(baseURI);
	  }
	@Test
	public void Assignment3() throws JsonProcessingException {
		
		cutomerRegister cr=new cutomerRegister("diw", "5000", "20");
		ObjectMapper mapper=new ObjectMapper();
		String m=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cr);
		System.out.println(m);
	
		 response=request.body(cr).post("/create");
		System.out.println(response.getBody().asString());
		System.out.println("status code is"+response.getStatusCode());
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	
}
