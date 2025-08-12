package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonParseException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {
    protected RequestSpecification reqBuilder;

    public RequestSpecification  getRequestBuilder() throws NullPointerException, IOException {

        if(reqBuilder == null) {
                PrintStream log = new PrintStream(new FileOutputStream("target/Logging.txt"));
                reqBuilder = new RequestSpecBuilder()
                .setBaseUri(getProperty("baseURL"))
                .addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build();
              return reqBuilder;
        }
        else {
            return reqBuilder;
        }
    }

    public static void setProperty(String Key, String Value) throws IOException, NullPointerException, FileNotFoundException{
        Properties property = new Properties();
        FileInputStream fis = new FileInputStream(new File("src/main/resourses/configure.properties"));
        property.load(fis);
        property.setProperty(Key,Value);
       
        FileOutputStream fos = new FileOutputStream(new File("src/main/resourses/configure.properties"));
        fos.close();


    }
    public static String getProperty(String Key) throws IOException, NullPointerException, FileNotFoundException{
        Properties property = new Properties();
        FileInputStream fis = new FileInputStream(new File("src/main/resourses/configure.properties"));
        property.load(fis);
        return property.getProperty(Key);
    }

    public String getJsonPath(Response response,String key){
        JsonPath js = new JsonPath(response.asString());
        return  js.get(key).toString();

    }
    

}
