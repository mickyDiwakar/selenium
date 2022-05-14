 package stepDefinations;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restApiclass.Addbook;
import restApiclass.Authrizationrequest;
import restApiclass.Books;
import restApiclass.ISBN;
import restApiclass.baseURI;

public class restAssuredStepdefPOst {
	private static final String baseUri = "http://bookstore.toolsqa.com";
	private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	private static String Token;
	private static Response response;
	private static String ResStr;
	private static String isbn;
	Response resp;

	RequestSpecification request;

	@Given("^Post request URI for registration \"([^\"]*)\"$")
	public void post_request_URI_for_registration(String arg1) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = arg1;
		request = RestAssured.given();

	}

	@SuppressWarnings("unchecked")
	@Given("^Body param is given for registration$")
	public void body_param_is_given_for_registration(DataTable dt) throws Exception {
		List<Map<String, String>> lt = dt.asMaps(String.class, String.class);
		String fname = lt.get(0).get("FirstName");
		String lname = lt.get(0).get("LastName");
		String uname = lt.get(0).get("UserName");
		String pwd = lt.get(0).get("Password");
		String email = lt.get(0).get("Email");
		// HashMap<String,Object>reqparm=new HashMap<String,Object>();
		JSONObject reqparm = new JSONObject();
		// String s="122ram1rf";
		// String email1="123email";
		reqparm.put("FirstName", fname);
		reqparm.put("LastName", lname);
		reqparm.put("UserName", uname);
		reqparm.put("Password", pwd);
		reqparm.put("Email", email);

		request.header("Content-Type", "application/json");
		// resp= request.body(reqparm.toJSONString()).when().post("/register");
		resp = request.pathParam("reg", "register").body(reqparm.toJSONString()).when().post("/{reg}");
		System.out.println(resp.toString());
	}

	@When("^user hit request check (\\d+) as status code$")
	public void user_hit_request_check_as_status_code(int arg1) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		int StatusCode = resp.getStatusCode();
		Assert.assertEquals(StatusCode, arg1);

		byte[] chr = "password".getBytes();
		String encodedpassword = Base64.getEncoder().encodeToString(chr);
		Base64.getDecoder().decode(encodedpassword);
		System.out.println("encrypted password=" + encodedpassword);
	}

	@When("^check the response body message \"([^\"]*)\"$")
	public void check_the_response_body_message(String arg1) throws Exception {
		
		
		System.out.println(resp.getBody().asString());
		String s = (resp.getBody().jsonPath().get("SuccessCode"));
		Assert.assertEquals(s, arg1, "correct message return");

	}

	@Then("^hit the request gain and check the status code (\\d+)$")
	public void hit_the_request_gain_and_check_the_status_code(int arg1) throws Exception {
		resp = request.post("/{reg}");
		Assert.assertEquals(arg1, resp.getStatusCode());

	}

	@Then("^check the response body error message \"([^\"]*)\"$")
	public void check_the_response_body_error_message(String arg1) throws Exception {
		String s = resp.getBody().jsonPath().get("fault");
		Assert.assertEquals(s, arg1);

	}

	@Given("^request URI is given to login \"([^\"]*)\"$")
	public void request_URI_is_given_to_login(String arg1) throws Exception {
		RestAssured.baseURI = arg1;
		request = RestAssured.given();
	}

	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" to login an application$")
	public void enter_and_to_login_an_application(String arg1, String arg2) throws Exception {
		resp = request.auth().basic(arg1, arg2).get("/CheckForAuthentication");
		//this is the way o write for premetive-request.auth().preemptive().basic(username, password).get();
		System.out.println("response=" + resp.getBody().asString());
	}

	@Then("^check user logged in$")
	public void check_user_logged_in() throws Exception {
		// String resFault=resp.getBody().jsonPath().get("Fault");
		String errerFault = resp.getBody().jsonPath().get("fault");
		// Assert.assertEquals(resFault, "Operation completed successfully");
		Assert.assertEquals(errerFault, "Invalid username or password");
	}

	@Given("^A list of book available$")
	public void a_list_of_book_available() throws Exception {
		// below code for authorization check
		Authrizationrequest credential = new Authrizationrequest("TOOLSQA-Test", "Test@@123");
		response = new baseURI().RequestURI(baseUri).body(credential).post("/Account/v1/GenerateToken");
		String strresponse = response.asString();
		String status = response.jsonPath().get("status");
		String result = response.jsonPath().get("result");
		int statuscode = response.getStatusCode();
		if (status.trim().equals("Success") && statuscode == 200) {
			Token = response.jsonPath().get("token");
		}
		String s = response.getStatusLine();
		System.out.println(Token);
		// below code to get the list of book
		response = new baseURI().RequestURI(baseUri).get("/BookStore/v1/Books");
		ObjectMapper mapper = new ObjectMapper();
		//Book[] bookq=response.getBody().as(Book[].class);
		

		ResStr = response.asString();
		String Resobody = response.getBody().asString();

		System.out.println(ResStr);
		List<Map<String, Object>> books = response.getBody().jsonPath().get("books");
		
		List<Object> list = response.getBody().jsonPath().get("books");
		// System.out.println(list.get(0)); //this will give object zeroth postion
		// object
		isbn = books.get(1).get("isbn").toString(); // this will give each element in the firsth position
		System.out.println(isbn);
		// 2nd way by using object mapper
		
		// String res=response.getBody()
		// mapper.writeValueAsString(value)
		// mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.writeValueAsString(Resobody);
		
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		
			

			// List<Book> book1 = mapper.readValue(Resobody, new
			// TypeReference<List<Book>>(){});
			
			  //Book b1=mapper.readValue(Resobody,Book.class);
			  
			// System.out.println(b1.getBooks().toString()); 
			/*
			 * Books b1=mapper.readValue(response.getBody().asString(),Books.class);
			 */
			 

			// TypeReference<List<Book>> tref=new TypeReference<List<Book>>() {};
			// System.out.println(mapper.writeValueAsString(b));

			JsonNode jnode = mapper.readTree(Resobody);
			ArrayNode anode = (ArrayNode) jnode.get("books");

			Iterator<JsonNode> it = anode.elements();
			while (it.hasNext()) {
				JsonNode jn = it.next();

				System.out.println(jn.get("isbn"));

			}
			// or 2nd weay
			JsonNode jnbook = jnode.path("books");
			System.out.println(jnbook.size()+"size of the book");
			
			Iterator<JsonNode> jn = jnbook.elements();
			while (jn.hasNext()) {
				JsonNode node = jn.next();
				System.out.println(node.path("isnb").asText());
				System.out.println(node.get("isbn").asText());

			}
		}

	

	@When("^I Add a book in my reading list$")
	public void i_Add_a_book_in_my_reading_list() throws Exception {

		Addbook addbookreq = new Addbook(USER_ID, new ISBN(isbn));

		request = new baseURI().RequestURI(baseUri).header("Authorization", "Bearer " + Token);

		response = request.body(addbookreq).post("/BookStore/v1/Books");
		String s = response.getBody().asString();
		System.out.println(s);

		int statuscode = response.getStatusCode();
		// Assert.assertEquals(statuscode, 201);
	}

	@Then("^The book is added$")
	public void the_book_is_added() throws Exception {

	}

	@When("^I remove a book from reading list$")
	public void i_remove_a_book_from_reading_list() throws Exception {
		RestAssured.baseURI = baseUri;
		RequestSpecification request = RestAssured.given();
		RemoveBookRequest removeBookRequest = new RemoveBookRequest(USER_ID, isbn);
		request.header("Authorization", "Bearer " + Token).header("Content-Type", "application/json");
		
		response = request.body(removeBookRequest).delete("/BookStore/v1/Book");
		System.out.println(response.getStatusCode());
	}

	@Then("^the book is removed$")
	public void the_book_is_removed() throws Exception {

	}

}
