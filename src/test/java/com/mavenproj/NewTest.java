package com.mavenproj;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import resources.BaseRestAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class NewTest extends BaseRestAPI {
	RequestSpecification request;
	Response response;
	String baseURI="https://restcountries.eu";
	@BeforeMethod
	  public void beforeClass() {
		
		request=RequestwithoutToken(baseURI);
	  }
  @Test(priority=1, enabled=true)
  public void assignmnet1() {
	 
	  response=request.pathParam("countrycode", "co").
	  get("rest/v2/alpha/{countrycode}");

	  response.then().log().all();
	  Assert.assertEquals(200, response.getStatusCode());
	  Assert.assertTrue(response.getHeader("Content-Type").contains("application/json"));
	Assert.assertEquals("Colombia", response.getBody().jsonPath().get("name"));
List<String>altSpellings = response.getBody().jsonPath().get("altSpellings");
List<String> list=new ArrayList<String>();
list.add("CO");
list.add("República de Colombia");
list.add("Republic of Colombia");

Assert.assertTrue(altSpellings.containsAll(list));
List<Map<String,Object>> languages=response.getBody().jsonPath().get("languages");
Assert.assertEquals("es",languages.get(0).get("iso639_1"));

Map<String,Object>translations=response.getBody().jsonPath().get("translations");
Assert.assertEquals("Colombie", translations.get("fr"));

 	  
  }
  
  
  @Test(priority=2)
  public void Assignment2() {
	
	  	
	  response=request.get("/rest/v2/currency/cop");

	  response.then().log().all();
	  //response.getBody().jsonPath().g
	 
	  List<Object> obj=response.getBody().jsonPath().getList("");
	  System.out.println("the size of array is "+obj.size());
	//response.getBody().jsonPath().getList("")
 	List<String>callingCodes=response.getBody().jsonPath().get("[0].callingCodes");
	Assert.assertTrue(callingCodes.contains("57"));
	  
  }
  

}
