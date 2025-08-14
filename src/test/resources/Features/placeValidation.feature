Feature: Validate Add Place Functionality 
@addPlace
Scenario Outline: Validate Add Place Functionality 
 Given Add Place with "name", "language" and "address" Payload
 When User calls "AddPlaceAPI" request "Post" HTTPS Request
 Then the API Call got sucess with status code 200
 And the response body contains "status" as "OK"
 And Verify Place_Id created maps to "name" using "getPlaceAPI"


Examples:  
         | name   | Language | address |
         | Rahul  | Java     | India   |
         |Roshani | Python   | USA     |
@deletePlace
Scenario: Delete Place Functionality validation
 Given Deleteplace Payload
 When User calls "deletePlaceAPI" request "Post" HTTPS Request   
 Then the API Call got sucess with status code 200
 And the response body contains "status" as "OK"