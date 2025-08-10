package Course_POJO;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import commonMethods.commonMethods;


import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;

public class oAuth {
    @Test()
    public void getToken() throws NullPointerException, FileNotFoundException, IOException{
        RestAssured.baseURI="https://rahulshettyacademy.com";

        String response =
                given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
                        formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W").
                        formParam("grant_type","client_credentials").
                        formParam("scope","trust").
                when().post("oauthapi/oauth2/resourceOwner/token").
                        then().extract().response().asString();
            System.out.println(commonMethods.rawtoJson(response).getString("access_token"));
        commonMethods.setProperty("token", commonMethods.rawtoJson(response).getString("access_token"));
    }


    @Test()
    public void valdateToken() throws NullPointerException, FileNotFoundException, IOException{

        GetCourse GetCourse= given().log().all().queryParam("access_token", commonMethods.getProperty("token")). 
        when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
        System.out.println(GetCourse.getCourses().getWebAutomation().get(2).getPrice());
    }



}
