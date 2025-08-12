package commonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;

public class commonMethods {
    public  static JsonPath rawtoJson(String respone){
        JsonPath js = new JsonPath(respone);
        return js;
    }
    
}
