package oAuth;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class oAuth {
    @Test()
    public void getToken(){
        RestAssured.baseURI="https://rahulshettyacademy.com";

        String response =
                given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
                        formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W").
                        formParam("grant_type","client_credentials").
                        formParam("scope","trust").
                when().post("oauthapi/oauth2/resourceOwner/token").
                        then().extract().response().asString();

        System.out.println(response);
    }
}
