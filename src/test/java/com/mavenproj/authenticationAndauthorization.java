package com.mavenproj;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class authenticationAndauthorization {
	private static String token=null;
  @Test(priority=1,enabled=false)
  public void Authortization() {
	  RestAssured.baseURI="https://restapi.demoqa.com/authentication/CheckForAuthentication";
	  RestAssured.useRelaxedHTTPSValidation();
	 RequestSpecification request=RestAssured.given().accept(ContentType.JSON);
	 request.auth().preemptive().basic("ToolsQA", "TestPassword");
	 Response response= request.get();
	response.then().log().all();
  }
  @Test(priority=2,enabled =true)
  public void Authoeizationwithtoken() throws JsonProcessingException {
	  RestAssured.baseURI="https://bookstore.toolsqa.com";
	  JSONObject jsobj=new JSONObject();
	  jsobj.put("userName", "TOOLSQA-Test");
	  jsobj.put("password","Test@@123");
	  ObjectMapper m=new ObjectMapper();
	  String s=m.writeValueAsString(jsobj);
	  System.out.println(s);
	 RequestSpecification request=RestAssured.given().header("Content-Type", "application/json").accept(ContentType.JSON);
	 Response response= request.body(jsobj.toJSONString()).post("/Account/v1/GenerateToken");
	response.then().log().all();
	 token= response.jsonPath().get("token");
	 
  }
  @SuppressWarnings("unchecked")
@Test(priority=3,enabled =true)
  public void getbooks() throws JsonMappingException, JsonProcessingException {
	  RestAssured.baseURI="https://bookstore.toolsqa.com";
	  RequestSpecification request=RestAssured.given().header("Content-Type", "application/json").accept(ContentType.JSON);
	  request.header("Authorization", "Bearer " + token)
	     .header("Content-Type", "application/json");
		 JSONObject json=new JSONObject();
		 json.put("isbn", "123");
		// json.put("userId", "9b5f49ab-eea9-45f4-9d66-bcf56a531b85");
		 Response response1=request.body(json.toJSONString()).post("/BookStore/v1/Books");
		
		 System.out.println(response1.getStatusLine());
		System.out.println("token="+token);	
		//*********************************************************
	  Response response= request.get("/BookStore/v1/Books");
	  List<Map<String,String>> books=response.jsonPath().get("books");
	  List<Map<String,String>> books1=response.jsonPath().getList("books");
	 System.out.println( "index isbn value="+books1.get(0).get("isbn"));
	 List<String>isbn=response.getBody().jsonPath().getList("books.isbn");
	
	 System.out.println("anotherway of isbn"+isbn.get(0));
	 ObjectMapper mapper=new ObjectMapper();
	 
	JsonNode jnode= mapper.readTree(response.asString());
	JsonNode booksmapper=jnode.get("books");
	System.out.println("sixe="+booksmapper.size());
	for(JsonNode j:booksmapper) {
		System.out.println(j.get("isbn").asText());
	}
	Iterator<JsonNode>it=booksmapper.iterator();
	while(it.hasNext()) {
		System.out.println(it.next().get("isbn").asText());
		
	}
	 
  }
  @Test(priority=4)
  public void outhtesting() {
	  RestAssured.baseURI="http://coop.apps.symfonycasts.com";
	 Response resp= RestAssured.given().
	  formParam("client_id", "diwakar").
	  formParam("client_secret", "ffb9defbe0f97ba09afe0023b1888128").
	  formParam("grant_type", "client_credentials").post("/token");
	 String token =resp.jsonPath().get("access_token");
	// RestAssured.given().auth().oauth(consumerKey, consumerSecret, accessToken, secretToken)
	 System.out.println(token);
	 Response resp1=RestAssured.given().auth().oauth2(token).
			 post("/api/1126/toiletseat-down");
	 System.out.println(resp1.asString());
	 //negative scenario
	 Response resp2=RestAssured.given().auth().oauth2(token).
	 post("/api/1126/barn-unlock");
	 System.out.println(resp2.getStatusCode());//401
	 
  }
}

