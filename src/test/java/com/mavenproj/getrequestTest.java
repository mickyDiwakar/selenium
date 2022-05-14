package com.mavenproj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.RequestBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.internal.HasIdentity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import stepDefinations.translations;


public class getrequestTest{
	private RequestSpecification request;
	Response response;
	@BeforeMethod
	public void geturi() {
		
		//http://restcountries.eu/rest/v1/name/norway
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name";
		request=RestAssured.given().header("ContentType", "application/json").accept(ContentType.JSON);
	}
  @SuppressWarnings("unchecked")
@Test(priority=0, enabled =true)
  public void getrequestwithjsonpath() throws FileNotFoundException, IOException, ParseException {
	 //if credendial req= request.auth().preemptive().basic(username, password).
	//System.out.println("sessionid"+ response.getSessionId());
	 
	 response=request.pathParam("country", "INDIA").when().get("/{country}");
	 JSONParser parser=new JSONParser();
	Object obj= parser.parse(new FileReader("C:\\selenium\\mavenproj\\src\\test\\java\\com\\mavenproj\\test.json"));
	 JSONObject jsonobject=(JSONObject) obj;
	 jsonobject.replace("name","sam");
	  System.out.println(jsonobject.toString());
	  System.out.println("cookies is="+response.getCookies());
	   //response.then().log().all();
	 // String strresp=response.getBody().asString();
	 // ObjectMapper mapper=new ObjectMapper();
	 // mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
	 // mainpojoOFCountries[] wd=mapper.readValue(strresp, mainpojoOFCountries[].class);
	  
	  mainpojoOFCountries[] countriesresponse= response.getBody().as(mainpojoOFCountries[].class);
	  //if u want to use list then below method
	  //int size=response.getBody().jsonPath().getList("").size();
	 // response.getBody().jsonPath().getObject("", mainpojoOFCountries.class);
	  
	//  System.out.println("size is"+size);
	  System.out.println("no of data featched="+countriesresponse.length);
	  System.out.println();
	  for(int i=0;i<countriesresponse.length;i++) {
		  System.out.println("coun name="+ countriesresponse[i].getName());
		  //toplevelDomain
		  List<String>listtoplevelDomain=Arrays.asList(countriesresponse[i].getTopLevelDomain());
		//Assert.assertTrue(listtoplevelDomain.containsAll(comaprelistdomain));
		// listtoplevelDomain.get(index)
		// List<String>comaprelistdomain=new ArrayList<String>();
		 //comaprelistdomain.add(".io");
		//Assert.assertTrue(listtoplevelDomain.containsAll(comaprelistdomain));
		  System.out.println("aplh2code="+countriesresponse[i].getAlpha2Code());
		  System.out.println("aplh3code="+countriesresponse[i].getAlpha3Code());
		  List<String>callingcode=Arrays.asList(countriesresponse[i].getCallingCodes());
		  
		 // Assert.Assertrue(callingcode.containsAll(c))
		 List<String>latlang= Arrays.asList(countriesresponse[i].getLatlng());
		 System.out.println("latlang conatins  item"+latlang.size());
		// response.getBody().jsonPath().getMap(path)
		 
		 System.out.println("gini is "+countriesresponse[i].getGini());
		 TranslationsBlockOfCountries trans=countriesresponse[i].getTranslations();
		// Map<String,String>map=new HashMap<String,String>();
		System.out.println("de="+trans.getDe()); ;
		System.out.println("ES="+trans.getEs());
		
	  
	  } //this will take all capital in a list like if 2 nodes are there ten al 2nodes captial
	  List<String>capital=response.getBody().jsonPath().getList("capital");
	  //response.then().extract().response();
	  for(String i:capital) {
		  System.out.println("the capitalof "+i);
	  }
	  response.then().log().all();
	  Map<String, String> translations = response.jsonPath().getMap("translations[1]");
	  System.out.println("new way dede="+translations.get("de"));
	  List<Map<String, String>> transalation=response.jsonPath().getList("translations");
	  System.out.println("de is="+transalation.get(0).get("de"));
  }
  @Test(priority=1,groups= {"Smoke","reg"})
  public void getrequestwithobjectMapper() throws JsonMappingException, JsonProcessingException {
	  //in mapper two ways either isng JsonNode(jsontree) or by pojo(readvalue)
	  response=request.pathParam("country", "INDIA").get("/{country}");
	 
	 String strresponse=request.pathParam("country", "INDIA").get("/{country}").asString();
	 
	  ObjectMapper mapper=new ObjectMapper();
	  mainpojoOFCountries[] mainpojo= mapper.readValue(strresponse, mainpojoOFCountries[].class);
	  System.out.println("gini is"+mainpojo[0].getGini());
	  Object arr[]=mainpojo[0].getLatlng();
	  System.out.println("array == latlang"+arr[0]);
	 // System.out.println(mainpojo.getGini()+"gini is");
	 JsonNode jnode= mapper.readTree(strresponse);
	 System.out.println("size of jnode="+jnode.size());
	 
	String s= jnode.get(0).get("translations").get("de").asText();
	System.out.println("jsnonode using trans"+s);
	  for(JsonNode j:jnode) {
		  String name=j.get("name").asText();
		   System.out.println("name="+name);
		  JsonNode jsonlang =j.get("languages");
		  Iterator<JsonNode>it=jsonlang.iterator();
		  while(it.hasNext()) {
			 
			 System.out.println("lang array"+ it.next().asText());
		  }
			JsonNode jsontrasnMap=  j.get("translations");
			System.out.println("trasn value"+jsontrasnMap.get("de"));
			
		  }
	  	
	  	  }

}
