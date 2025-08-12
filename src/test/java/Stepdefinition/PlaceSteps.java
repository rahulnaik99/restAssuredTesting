package Stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import TestDataBuild.TestDataBuild;
import TestDataBuild.getAPIPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.utils;


public class PlaceSteps extends utils{
     Response response;
     ResponseSpecification resBuilder;
     RequestSpecification request;
     TestDataBuild Testdata = new TestDataBuild();
@Given("Add Place with {string}, {string} and {string} Payload")
public void add_place_payload(String name, String language, String address) throws NullPointerException, IOException {
     
        request = given().spec(getRequestBuilder()).
        body(Testdata.add_place_payload(name,language,address));
    
}
@When("User calls {string} request {string} HTTPS Request")
public Response user_calls_request_post_https_request(String httpsMethod,String methodType) {
       
        getAPIPath apiPath= getAPIPath.valueOf(httpsMethod);

        if (methodType.equalsIgnoreCase("POST")) {
                return response = request.when().post(apiPath.getResourse());
        }
        else if (methodType.equalsIgnoreCase("GET")) {
                return response = request.when().get(apiPath.getResourse());
        }
        else if (methodType.equalsIgnoreCase("DELETE")) {
                return response = request.when().delete(apiPath.getResourse());
          }
        return response;
        
   
}
@Then("the API Call got sucess with status code {int}")
public void the_api_call_got_sucess_with_status_code(int status) {
    assertEquals(response.getStatusCode(), status);
    
}

@Then("the response body contains {string} as {string}")
public void user_calls_with_http_request(String key, String value) {
   String resp = response.asString();
   JsonPath jsonPath = new JsonPath(resp);
    String actualValue = jsonPath.getString(key);  
    assertEquals(value,actualValue);

}
@Then("Verify Place_Id created maps to {string} using {string}")
public void verify_place_id_created_maps_to_using(String name, String methodType) throws NullPointerException, IOException {
      
    request = given().spec(request).queryParam("place_id", getJsonPath(response, "place_id")); 
    user_calls_request_post_https_request(methodType,"GET");
    assertEquals(getJsonPath(response, "name"),name);
      

}


}
