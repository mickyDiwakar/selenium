package com.mavenproj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.internal.HasIdentity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepDefinations.translations;


public class getrequestTest3{
	private RequestSpecification request;
	Response response;
	@BeforeMethod
	public void geturi() {
		//http://restcountries.eu/rest/v1/name/norway
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name";
		request=RestAssured.given().header("ContentType", "application/json").accept(ContentType.JSON);
	}
  @Test(priority=1, enabled =true)
  public void getrequestwithjsonpath() throws JsonMappingException, JsonProcessingException {
	  response=request.pathParam("country", "INDIA").get("/{country}");
	  System.out.println("cookies is="+response.getCookies());
	  response.prettyPrint();
	  System.err.println(response.jsonPath().getString("name"));
	  
	  }

}
