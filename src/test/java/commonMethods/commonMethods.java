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
    public static void setProperty(String Key, String Value) throws IOException, NullPointerException, FileNotFoundException{
        Properties property = new Properties();
        FileInputStream fis = new FileInputStream(new File("src/test/resources/configure.properties"));
        property.load(fis);
        property.setProperty(Key,Value);
       
        FileOutputStream fos = new FileOutputStream(new File("src/test/resources/configure.properties"));
        // property.save(fos, null);
        fos.close();


    }
    public static String getProperty(String Key) throws IOException, NullPointerException, FileNotFoundException{
        Properties property = new Properties();
        FileInputStream fis = new FileInputStream(new File("src/test/resources/configure.properties"));
        property.load(fis);
        return property.getProperty(Key);
    }
    
}
