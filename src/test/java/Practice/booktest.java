package Practice;
import io.restassured.RestAssured;
// import org.testng.annotations.DataProvider;
import static io.restassured.RestAssured.given;
import org.junit.Test;
public class booktest {
    // @Test(dataProvider = "booksData")
    public void addBook(String isbn,String aisle){
        RestAssured.baseURI = "http://216.10.245.166";
       String response;
       response= given().queryParam("Content-Type","application/json").
               body(payloadJson.addBook( isbn,aisle)).
                when().post("Library/Addbook.php").
                then().log().all().extract().response().asString();
        System.out.println(response);
    }

    // @Test(d/ataProvider = "booksData")
    public void deleteBook(String isb,String asile){
       String reponse =given().queryParam("Content-Type","application/json").
               body(payloadJson.delBook("theju2299")).
                when().post("Library/DeleteBook.php").
               then().extract().response().asString();
        System.out.println(reponse);
    }
    // @DataProvider(name="booksData")
    public Object[][] getData(){
        return new Object[][] {{"rahul","1812"},{"theju","2299"},{"roshani","1012"}};
    }

    @Test()
    public void oAuth(){
    RestAssured.baseURI="https://rahulshettyacademy.com";
    String responses = given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
            formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W").
            formParam("grant_type","client_credentials").
            formParam("scope","trust")
            .when().post("oauthapi/oauth2/resourceOwner/token").
            then().log().all().extract().response().asString();
        given().queryParam("access_token", "GaWliE0wsyH6hbB8O7e9fQ==").when().get("oauthapi/getCourseDetails").then().log().all();
                System.out.println(responses);
    }

}
