package com.mavenproj;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;

public class getrequestpost {
  
  @BeforeMethod
  public void beforeMethod() {
  }
  @SuppressWarnings("unchecked")
@Test(priority=1,enabled=true)
  public void postrequestwithjsonpath() throws JsonProcessingException {
	  RestAssured.baseURI="https://restapi.demoqa.com/customer";
		RestAssured.useRelaxedHTTPSValidation();
	  RequestSpecification request=RestAssured.given().header("Content-Type", "application/json").accept(ContentType.JSON);
	  
		  JSONObject requestParams=new JSONObject(); 
		 requestParams.put("UserName", "s1dimpleuser2dd2011");
		 requestParams.put("Email", "s1ample2ee26d9@gmail.com");
		 requestParams.put("FirstName", "Virender1");
		 requestParams.put("LastName", "Singh1");
		 requestParams.put("Password", "password1");
		 
		//uisng object mapper writevalue to check the body of requst
		ObjectMapper mapper=new ObjectMapper();
		String s=mapper.writeValueAsString(requestParams);
		
		System.out.println(s);
		Response response=request.body(requestParams.toJSONString()).pathParam("reg", "register").post("/{reg}");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		response.then().log().all();
		response.getBody().jsonPath().get("FaultId");
	  
  }
  @Test(priority=2)
  public void postrequestwithobjectmapper() throws JsonProcessingException {
	  RestAssured.baseURI="https://restapi.demoqa.com/customer";
	  RestAssured.useRelaxedHTTPSValidation();
	  RequestSpecification request=RestAssured.given().header("Content-Type", "application/json").accept(ContentType.JSON);
	  pojoclassforpostpayload payload=new pojoclassforpostpayload("sim","diwakar@gmail.com","firstname","lastname","paswrd");
	  ObjectMapper mapper=new ObjectMapper();
	 String s1= mapper.writeValueAsString(payload);
	  System.out.println(s1);
//	mapper.writeValue(resultFile, value);
	  
	  
	  //because paylaod field is in PASCAL case not in camel case so added one line setpropertynaming statgey
	 String s= mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE).writeValueAsString(payload);
	 System.out.println(s);
	 
	  Response response=request.body(s).pathParam("reg", "register").post("/{reg}");
	  System.out.println("response of new way"+response.getStatusLine());
	  
  }

}
