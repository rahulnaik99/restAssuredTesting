package Stepdefinition;
import static io.restassured.RestAssured.given;
import org.junit.Test;

public class OauthII {

    @Test()
    public void Oauth(){
        given().queryParam("code" ,""). 
        queryParam("client_secret", ""). 
        queryParam("redirect_uri", ""). 
        queryParam("grant_type", "") . 
        when(). 
        post("");

        given().queryParam("access_token", "").  
        when() . 
        get("getCourse.php") ;

    }

}
