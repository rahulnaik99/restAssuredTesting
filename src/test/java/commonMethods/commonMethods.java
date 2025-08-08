package Practice;

import io.restassured.path.json.JsonPath;

public class commonMethods {
    public  static JsonPath rawtoJson(String respone){
        JsonPath js = new JsonPath(respone);
        return js;
    }
}
