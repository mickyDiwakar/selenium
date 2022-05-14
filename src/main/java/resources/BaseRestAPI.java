package resources;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRestAPI {
	String baseURI;
	public static RequestSpecification RequestwithoutToken(String baseURI) {
		RestAssured.baseURI=baseURI;
			
		return RestAssured.given().headers("Content-Type","application/json").accept(ContentType.JSON);
		
	}
	
}
