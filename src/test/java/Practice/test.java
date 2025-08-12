package Practice;
import io.restassured.path.json.JsonPath;

import commonMethods.commonMethods;
import io.restassured.RestAssured;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class test {

    @Test()
    public void addplace() throws IOException {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response;
        response =
                given().queryParam("key", "qaclick123"). //Query parameter
                        header("Contenet-Type", "application/json").body(  //body
                                new String (Files.readAllBytes(Paths.get("src/test/resources/addPlace.json")))).
                        multiPart("file",new File("")).
                        when().post("/maps/api/place/add/json"). //HTTP Method, Resource Path
                        then().assertThat().statusCode(200).//log().all().  //assert status code and Log all
                        body("scope", equalTo("APP")).//assert response body
                        header("Content-Type", "application/json;charset=UTF-8").extract().response().asString(); //assert response header

        String placeID = commonMethods.rawtoJson(response).getString("place_id");
        response = given().queryParam("key", "qaclick123").
                header("Contenet-Type", "application/json").
                body(payloadJson.updatePlace(commonMethods.rawtoJson(response).getString("place_id"))).
                when().put("/maps/api/place/update/json").
                then().assertThat().statusCode(200).
                body("msg", equalTo("Address successfully updated")).
                extract().response().asString();

        response = given().queryParam("key", "qaclick123").
                queryParam("place_id", placeID).
                header("Contenet-Type", "application/json").
                when().get("/maps/api/place/get/json").
                then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(response);
    }

    @Test()
    public void parseJson() {
       JsonPath js = new JsonPath(payloadJson.CoursePrice());
      int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
        String firstCourse = (js.get("courses[0].title"));
        System.out.println(firstCourse);
        int count = js.get("courses.size()");

//        for (int i=0;i<count;i++){
//            String title = js.get("courses["+i+"].title");
//            int price = js.get("courses["+i+"].price");
//            System.out.println(title+" "+price);
//        }

//        for (int i=0;i<count;i++){
//            String title = js.get("courses["+i+"].title");
//            if (title.equalsIgnoreCase("RPA")){
//                int price = js.get("courses["+i+"].price");
//                System.out.println(title+" "+price);
//                break;
//            }
//        }
        int Sum=0;
        for (int i=0;i<count;i++){
           int price = js.get("courses["+i+"].price");
            int copies = js.get("courses["+i+"].copies");
            Sum=Sum+price*copies;
        }

        System.out.println(Sum==totalAmount);


    }

    @Test()
    public void pojoPrint() {
        System.out.println();
    }

}
