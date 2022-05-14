package stepDefinations;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class restAssuredstepdefPUT {
	private static RequestSpecification request;
	private static  JSONObject reqparam;
	private static Response response;
	@Given("^URI for Put is given$")
	public void uri_for_Put_is_given() throws Exception {
	    RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	    request=RestAssured.given();
	}

	@When("^user enter the body and hit the response$")
	public void user_enter_the_body_and_hit_the_response() throws Exception {
		int empid=15410;
		
		response=request.delete("/delete/"+ empid);
		System.out.println(response.getStatusCode());
		String str=response.getBody().jsonPath().get("status");
		String message=response.getBody().jsonPath().get("message");
		System.out.println("status="+str+"message="+message);
		
		 reqparam=new JSONObject();
		reqparam.put("name", "test1");
		reqparam.put("age", "1123");
		reqparam.put("salary","23");
		//reqparam.put("sex", "M");
		
		response=request.contentType("application/json").body(reqparam.toJSONString()).put("/update/"+ empid);
	}

	@Then("^check the rsponse of the body$")
	public void check_the_rsponse_of_the_body() throws Exception {
	    System.out.println("Statuscode="+response.getStatusCode());
	    System.out.println("StatusLine:"+response.getStatusLine());
	    System.out.println("resposne="+response.getBody().jsonPath().get("data.name"));
	}

}
