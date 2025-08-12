package specBuilder;
import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import POJO.mapPOJO.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class googleMapWithSpecBuilder {

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



        RequestSpecification res = new RequestSpecBuilder()
        .setBaseUri("https://rahulshettyacademy.com/maps/api/place/add/json")
        .addQueryParam("key","qaclick")
        .setContentType(ContentType.JSON).build();
        ResponseSpecification resBuilder = new ResponseSpecBuilder().expectStatusCode(200).build();



        given().spec(res).
        body(map)
        .when()
        .post("maps/api/place/add/json")
        .then().spec(resBuilder).log().all();

        
    }


}
