package ecomWebsite;

import org.testng.annotations.Test;

import ecomWebsite.pojoPackages.createOrderRequest;
import ecomWebsite.pojoPackages.createProductResponse;
import ecomWebsite.pojoPackages.loginRequest;
import ecomWebsite.pojoPackages.loginResponse;
import ecomWebsite.pojoPackages.orderRequest;

import static io.restassured.RestAssured.given;
import java.io.File;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ecomWebsite {

    @Test()
    public void getToken() {

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com/")
                .setContentType(ContentType.JSON)
                .build();

        loginRequest lr = new loginRequest();
        lr.setUserEmail("kallu@kaliya.com");
        lr.setUserPassword("Charle@777");

        loginResponse regLogin = given().log().all().spec(req).body(lr).when().post("api/ecom/auth/login").then().log()
                .all().extract().response().as(loginResponse.class);

        req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addHeader("Authorization",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODk4NTkxODZmNTg1ZWI2MGQ2YzE1MzIiLCJ1c2VyRW1haWwiOiJrYWxsdUBrYWxpeWEuY29tIiwidXNlck1vYmlsZSI6Njk1OTE1MjIwNywidXNlclJvbGUiOiJjdXN0b21lciIsImlhdCI6MTc1NDgzNTk1MiwiZXhwIjoxNzg2MzkzNTUyfQ.2jav1zETgefJq_oBHI9XqUIrKUjw1omTXOmdmuQ6USc")
                .setContentType(ContentType.JSON).build();

                createProductResponse cpr  = given().spec(req)
                .param("productName", "Samsung Galaxy S21").param("productAddedBy", "689859186f585eb60d6c1532")
                .param("productCategory", "Electronics").param("productSubCategory", "Mobile Phones")
                .param("productPrice", "799.99")
                .param("productDescription", "Latest Samsung Galaxy S21 with 128GB storage").param("productFor", "Sale")
                .multiPart("productImage", new File("src/test/resources/image.png")).contentType(ContentType.MULTIPART)
                .when().post("api/ecom/product/add-product").then().log().all().extract().response().as(createProductResponse.class);
                 
        createOrderRequest reqOrder = new createOrderRequest();
        reqOrder.setCountry("India");
        reqOrder.setProductOrderedId(cpr.getProductId());   
        orderRequest or = new orderRequest();
        or.setOrders(List.of(reqOrder));
         given().spec(req). 
         body(or). 
         when().post("api/ecom/order/create-order"). 
         then().log().all();       

    }

}
