Feature: Validate Add Place Functionality 

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

Scenario: Delete Place Functionality validation

 Given Deleteplace Payload
 When When User calls "DeletePlaceAPI" request "Post" HTTPS Request   
 Then Then the API Call got sucess with status code 200
 And the response body contains "status" as "OK"