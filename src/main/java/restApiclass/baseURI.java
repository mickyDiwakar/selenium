package restApiclass;
import  io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class baseURI {
	public String BaseUri;
	public RequestSpecification RequestURI(String BaseUri) {
		RestAssured.baseURI=BaseUri;
		
		RequestSpecification requestwithToken=RestAssured.given();
		requestwithToken.headers("Content-Type", "application/json");
		return requestwithToken;
	}
	
	
}
