package mapPOJO;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
public class googleMap {

    @Test()
    public void getMap() throws NullPointerException, FileNotFoundException, IOException{
        placePOJO map = new placePOJO();
        map.setAccuracy(50);
        map.setAddress("29, side layout, cohen 09");
        map.setLanguage("French-IN");
        map.setWebsite("http://google.com");
        List<String> list = new ArrayList<>();
        list.add("shoe park");
        list.add("shop");
        map.setTypes(list);
        locations loc = new locations();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        map.setLocation(loc);
        map.setPhone_number("(+91) 983 893 3937");
        map.setName("Frontline house");

        String response = given().queryParam("key","qaclick123").header("Content-Type", "application/json").
        body(map)
        .when()
        .post("https://rahulshettyacademy.com/maps/api/place/add/json")
        .then().log().all()
        .extract()
        .response()
        .asString();

        
    }


}
