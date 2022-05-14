package stepDefinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import  static org.hamcrest.Matchers.*;

import org.json.simple.JSONArray;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import  io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import restApiclass.Authrizationrequest;
import restApiclass.Book;
import restApiclass.Books;
import restApiclass.Weather;
import restApiclass.weatherLondon;



public class restAssuredStepdefGet{
	Response response;
	//public static Books books;
    @Given("^URI is \"([^\"]*)\"$")
    public void uri_is_something(String strArg1) throws Throwable {
    	RestAssured.baseURI=strArg1;
        
    }

    @When("^user send a request to get wheather of \"([^\"]*)\"$")
    public void user_send_a_request_to_get_wheather_of_something(String strArg1) throws Throwable {
       response= RestAssured.given().request(Method.GET,"/"+strArg1 );
     //  RestAssured.given().auth().preemptive().basic(username, password)
      
    }

    @Then("^user get the response of Weather$")
    public void user_get_the_response_of_weather() throws Throwable {
      System.out.println("contenttype is="+response.getContentType()); //application/json
      System.out.println("headeris="+response.getHeaders()); 
      System.out.println("statuscode is="+response.getStatusCode()); //200
      System.out.println("statusline="+response.getStatusLine()); //HTTP/1/ 200OK
      String s=response.getBody().jsonPath().get("City");
      System.out.println(s);
      response.then().log().all();
      response.then().body("City",hasItem("Bengaluru"));
    //response.then().assertThat().body("City", hasItem("Bengaluru")) ; 
     // String s= response.getBody().asString();
       System.out.println(s);
       
    }
    
    
   

    @When("^user send a request \"([^\"]*)\"$")
    public void user_send_a_request_something(String strArg1) throws Throwable {
    	response=RestAssured.given().request(Method.GET,"/"+strArg1);
    	//RestAssured.given().get()
    	
    }
    
    @Then("^verify the error code in response$")
    public void errorresponse() {
    	String responsebody=response.getBody().asString();
    	  System.out.println("resposne is="+responsebody);
    	
    	
    }

    @Then("^verify the response of country \"([^\"]*)\"$")
    public void verify_the_response_something(String g1) throws Throwable {
       String responsebody=response.getBody().asString();
       
      Map<String,Object>map= response.getBody().jsonPath().get("[0].translations");
      map.get("de");
      int size=map.size();
      System.out.println(size);
      System.out.println( map.get("de"));
      List<String>l=new ArrayList<String>();
      l.add("AFG");
    		    
      List<String>list=response.getBody().jsonPath().get("[1].borders");
      int Listsize=list.size();
      System.out.println(Listsize);
      System.out.println(list.containsAll(l));
    List<String>list1=response.getBody().jsonPath().getList("[1].borders");
     System.out.println(list1.get(0));
		/*
		 * List<translations>
		 * Alltranslations=response.jsonPath().getList("[0].translations",
		 * translations.class); for(translations tr:Alltranslations) { String s=tr.de;
		 * System.out.println("str="+s); }
		 */
       //response.jsonPath().geto
       System.out.println("resposne is="+responsebody);
       System.out.println(response.getStatusCode());
       System.out.println(response.getStatusLine());
       Assert.assertTrue(responsebody.contains(g1));
       
       
    }
    @When("^Check the capital \"([^\"]*)\"$")
    public void check_the_capital_something(String strArg1) throws Throwable {
       // throw new PendingException();
    	//RestAssured.given().auth().preemptive().basic(username, password)
    	//RestAssured.given().auth().oauth(consumerKey, consumerSecret, accessToken, secretToken)
    	//RestAssured.given().auth().oauth2(accessToken)
    	response=RestAssured.given().get("/"+strArg1);
    	
    	
    	//or RestAssured.given().get("/"+strarg1)
    	String str=response.then().extract().asString();
    	ResponseBodyExtractionOptions rbeo=response.then().extract().body();
    	String capital=response.then().extract().body().path("[0].capital");
   
    	Assert.assertEquals(capital, "Oslo");
    	JsonPath jsonpath=rbeo.jsonPath();
    	String str1=jsonpath.get("[0].name");
    	System.out.println("str1="+str1);
    
    	String aalpha=response.jsonPath().get("[0].alpha3Code");
    	System.out.println("aalpha="+aalpha);
    	   	
    	
    }

    @Then("^print the details in commandline$")
    public void print_the_details_in_commandline() throws Throwable {
    	
    	List<String>resp=response.jsonPath().getList("[0].altSpellings");
    	for(String i:resp) {
    		System.out.println(i);
    	}
    	Map<String,String>m1=new HashMap<String,String>();	
    	
		  m1.put("it","Norvegia");
		  m1.put("fr","Norvège");
		 
    	Map<String,String>map=new HashMap<String,String>();
    	map=response.jsonPath().getMap("[0].translations");
    	
    	for(Entry<String, String> m:map.entrySet()) {
    		System.out.println(m);
    	}
       System.out.println(response.then().extract().asString());
    }
    
   
    @Given("url is {string}")
    public void gettesting(String s) throws JsonMappingException, JsonProcessingException {
    	RestAssured.baseURI=s;
    	Authrizationrequest authreq=new Authrizationrequest("TOOLSQA-Test","Test@@123");
    	
   
  Book[] book=RestAssured.given().headers("Content-Type","application/Json")
    	.accept(ContentType.JSON).get("/BookStore/v1/Books").jsonPath().
    	getObject("books", Book[].class);
 //below code will use to get list of [obj1,obj2] 
 // List<Object> obj=response.getBody().jsonPath().getList("");

  //Books b=new Books(Arrays.asList(str1));
		/*
		 * Book[] book1= RestAssured.given().headers("Content-Type","application/Json")
		 * .accept(ContentType.JSON).get("/BookStore/v1/Books").getBody().as(Book[].
		 * class); System.out.println(book1);
		 */
/* for(int i=0;i<book.length;i++) {
	String isbn= book[i].getIsbn();
	String title=book[i].getTitle();
	System.out.println(isbn+title);
 }*/
 // Books b=new Books(Arrays.asList(book));
  
ObjectMapper mapper=new ObjectMapper();
String resbody=RestAssured.given().headers("Content-Type","application/Json")
.accept(ContentType.JSON).get("/BookStore/v1/Books").getBody().asString();
//Book[] book3=mapper.readValue(resbody, Books.class).getBooks();
Books book3= mapper.readValue(resbody, Books.class);
Book[] bokk=book3.getBooks();
for(Book b:bokk) {
	System.out.println(b.getIsbn());
}
//System.out.println(book3[].getIsbn());
//Book boo4=mapper.readValue(resbody, Book.class);

    	 //deserialise the resposne body into book class
    //	ObjectMapper obj=new ObjectMapper();
    //	obj.writerWithDefaultPrettyPrinter().writeValueAsString(value)
    	//System.out.println(str1);
    	//String str= response.getBody().asString();
    	//System.out.println(str1);
   //System.out.println(str);
    
    	 
    }

    @Given("the End point Url is {string}")
    public void getoperationonLOndonwheather(String arg) throws JsonMappingException, JsonProcessingException {
    	RestAssured.baseURI=arg;
    	response=RestAssured.given().header("Content-Type","appliation/json").accept(ContentType.JSON)
    	.pathParam("id", "2.5").queryParam("q", "London").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
    	.get("/data/{id}/weather");
    	//response.getBody().jsonPath()
    //response.then().log().all();// this will log all about response
    	String s=response.getBody().asString();
    	System.out.println(s);
    	//fetching this kind of  {"coord": {
       // "lon": -0.13,
       // "lat": 51.51
     // },
    	//JSONArray array=JSONArray(response.jsonPath().get("weather"));
    	
    	Map<String,Object>map=response.jsonPath().get("coord");
    	response.then().log().all();
		/*
		 * fetching aray or list type "weather": [ { "id": 300, "main": "Drizzle",
		 * "description": "light intensity drizzle", "icon": "09d" } ],
		 */
    	List<Map<String,Object>>wherther=response.jsonPath().get("weather");
    	//response.getBody().jsonpath
    	wherther.size();
    	System.out.println(wherther.get(0).get("id"));
    	//Now using pojo same issue trying to fix
    	
    	weatherLondon wl=RestAssured.given().header("Content-Type","appliation/json").accept(ContentType.JSON)
    	.pathParam("id", "2.5").queryParam("q", "London").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
    	.get("/data/{id}/weather").getBody().as(weatherLondon.class);
    	System.out.println(wl.getBase());
    	System.out.println(wl.getCoord().getLat());
    	Weather[]arr=wl.getWeather();
    	System.out.println("array size of whetehre"+ arr.length);
    	for(int i=0;i<arr.length;i++) {
    		String id=arr[i].getId();
    	String desp=	arr[i].getDescription();
    		System.out.println("id and desp"+id+desp);
    	}
    	//another way of doing using objectmapper
    	String strresp=RestAssured.given().header("Content-Type","appliation/json").accept(ContentType.JSON)
    	    	.pathParam("id", "2.5").queryParam("q", "London").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
    	    	.get("/data/{id}/weather").getBody().asString();
    	ObjectMapper mapper=new ObjectMapper();
    	weatherLondon wd=mapper.readValue(strresp, weatherLondon.class);
    	   
    	System.out.println("pressure is"+wd.getMain().getPressure());
    	
    	JsonNode jsonnode=mapper.readTree(strresp);
    	jsonnode.size();
    	//when readvalue is used when we have pojo classbut readtree we can use where tree stucture we have and it should be as String
    	//jsonnode.path(index)
    	//jsonnode.path(0).get(fieldName)
    	String visibility=jsonnode.get("visibility").asText();
    	System.out.println("visblity is"+visibility);
    	//System.out.println(jsonnode.path(0).get("weather").findValuesAsText("main"));
    	System.out.println(	jsonnode.get("weather").findValue("id"));
    	//for array noded
    	//1st way
    	
    	JsonNode  jn1=jsonnode.path("weather");//jsonnode.get() also do same thing
    	//JsonNode k=jsonnode.get("weather");
    	Iterator<JsonNode> it1=jn1.elements();
    	while(it1.hasNext()) {
    		JsonNode weathers1=it1.next();	
    		String sw=weathers1.path("id").asText();
    		System.out.println("id="+sw);
    	}
    	//2nd way
    	ArrayNode anode=(ArrayNode) jsonnode.get("weather");
    	Iterator<JsonNode>it=anode.elements();
    	while(it.hasNext()) {
    		JsonNode jn=it.next();
    		String idwether=jn.get("id").asText();
    		String iconwheter=jn.get("icon").asText();
    		System.out.println(idwether+iconwheter);
    	}
     	
    	
    }

	private JSONArray JSONArray(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}

