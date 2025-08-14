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
     static Response response;
     ResponseSpecification responseBuilder;
     static RequestSpecification requestBuilder;
     TestDataBuild Testdata = new TestDataBuild();
     static String place_id;
     JsonPath jsonPath;


@Given("Add Place with {string}, {string} and {string} Payload")
public void add_place_payload(String name, String language, String address) throws NullPointerException, IOException {
     
        requestBuilder = given().spec(getRequestBuilder()).
        body(Testdata.add_place_payload(name,language,address));
        
}
@When("User calls {string} request {string} HTTPS Request")
public Response user_calls_request_post_https_request(String httpsMethod,String methodType) {
       
        getAPIPath apiPath= getAPIPath.valueOf(httpsMethod);

        if (methodType.equalsIgnoreCase("POST")) {
                response = requestBuilder.when().post(apiPath.getResourse());
                jsonPath = new JsonPath(response.asString());
                place_id=jsonPath.getString("place_id");
                return response;
        }
        else if (methodType.equalsIgnoreCase("GET")) {
                return response = requestBuilder.when().get(apiPath.getResourse());

        }
        else if (methodType.equalsIgnoreCase("DELETE")) {
                return response = requestBuilder.when().delete(apiPath.getResourse());
          }
        return response;
        
   
}
@Then("the API Call got sucess with status code {int}")
public void the_api_call_got_sucess_with_status_code(int status) {
    assertEquals(response.getStatusCode(), status);
    
}

@Then("the response body contains {string} as {string}")
public void user_calls_with_http_request(String key, String value) {
        jsonPath = new JsonPath(response.asString());
        assertEquals(value,jsonPath.getString(key));
}
@Then("Verify Place_Id created maps to {string} using {string}")
public void verify_place_id_created_maps_to_using(String name, String methodType) throws NullPointerException, IOException {
      
    requestBuilder = given().spec(requestBuilder).queryParam("place_id", getJsonPath(response, "place_id")); 
    response= user_calls_request_post_https_request(methodType,"GET");
    assertEquals(getJsonPath(response, "name"),name);



}

@Given("Deleteplace Payload")
public void deleteplace_payload() {
requestBuilder = given().spec(reqBuilder).body(Testdata.deletePayload(place_id));

}
}
