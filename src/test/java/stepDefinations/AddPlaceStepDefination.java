package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;

import Utilities.APIresources;
import Utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.JSONTestBuilder;


public class AddPlaceStepDefination extends Utils{
	
	RequestSpecification request;
	Response response;
	Response response1;
	JSONTestBuilder JSONBuilder = new JSONTestBuilder();
	APIresources apiresource;
	static String place_id;
	
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String accuracy, String address, String language) throws IOException, NumberFormatException, ConfigurationException {
		
		request = given().log().all().spec(requestSpecificationBuilder()).body(JSONBuilder.payload(Integer.parseInt(accuracy),address,language));
	   
	}

	@When("User call {string} using {string} request")
	public void user_call_using_request(String resource, String method) {
		apiresource = APIresources.valueOf(resource);
		if(method.equalsIgnoreCase("POST"))
		    response = request.when().post(apiresource.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response = request.when().get(apiresource.getResource());
		else if(method.equalsIgnoreCase("DELETE"))
			response = request.when().delete(apiresource.getResource());
		
		System.out.println("response==>"+ response.asString());
		
	}

	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {
		
		assertEquals(response.getStatusCode(),200);
	  
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		
		JsonPath js = new JsonPath(response.asString());
		assertEquals(js.get(key),value);
	}
	

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedlanguage, String resource) throws ConfigurationException, IOException {
		
		place_id = getJsonValue(response,"place_id");
		System.out.println("place_id==>" + place_id);
		
		request = given().log().all().spec(requestSpecificationBuilder()).queryParam("place_id", place_id);
		user_call_using_request(resource,"GET");
	
		
		String actuallanguage = getJsonValue(response,"language");
		assertEquals(actuallanguage,expectedlanguage);
		
	}
	
	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws ConfigurationException, IOException {
		
		request = given().log().all().spec(requestSpecificationBuilder()).body(JSONBuilder.deletePayload(place_id));
	    
	}



}
