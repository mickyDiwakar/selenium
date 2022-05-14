package utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hamcrest.MatcherAssert;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.messages.internal.com.google.gson.JsonArray;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class roughapi {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		RestAssured.baseURI="https://samples.openweathermap.org";
		Response resp=RestAssured.given().accept(ContentType.JSON).pathParam("id", "2.5")
		.queryParam("q", "London").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8").get("/data/{id}/weather");
//	Map<String,Object> map=resp.getBody().jsonPath().getMap("coord");
	//System.out.println(map.get("lon"));
		
		
	List<Map<String,Object>>l=resp.getBody().jsonPath().get("weather");
	for(int i=0;i<l.size();i++) {
		System.out.println(l.get(0).get("main").toString());
		ObjectMapper mapper=new ObjectMapper();
		JsonNode jnode=mapper.readTree(resp.asString());
		JsonNode j=jnode.get("weather");
		System.out.println(j.size());
		Iterator<JsonNode>it=j.iterator();
		while(it.hasNext()) {
			JsonNode jn1=it.next();
			System.out.println(jn1.get("id").asInt());
		}
	}
	//********************************************
	RestAssured.baseURI="http://coop.apps.symfonycasts.com";
	RequestSpecification request=RestAssured.given().contentType(ContentType.JSON)
			.when().formParam("x", "y").auth().preemptive()
			.basic("useranme", "pass");
	
	JSONArray jsonarray=new JSONArray();
	jsonarray.add("employee");
	
	JSONObject j=new JSONObject();
	JSONObject t=new JSONObject();
	t.put("name","kumar");
	t.put("n1", "k1");
	j.put("firstName", "diwakar");
	j.put("employee", t);
	
	request.body(j);
	ObjectMapper map=new ObjectMapper();
	System.out.println(map.writeValueAsString(j));
	
	}

}
