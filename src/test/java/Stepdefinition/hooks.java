package Stepdefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class hooks {
    @Before("@deletePlace")
    public void beforeScenario() throws NullPointerException, IOException{
      
       PlaceSteps m = new PlaceSteps();

         if(PlaceSteps.place_id==null){
       m.add_place_payload("Thejaswii", "Konkani", "MySuru"); 
       PlaceSteps.response =  m.user_calls_request_post_https_request("AddPlaceAPI", "Post");
       m.verify_place_id_created_maps_to_using("Thejaswii", "getPlaceAPI");
         }



    }

}
