package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.Argument;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class StoresAssertionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }
    // Verify if the total is equal to 1561
    @Test
    public void test01(){
        response.body("total",equalTo(1561));

    }
    // Verify if the stores of limit is equal to 10
    @Test
    public void test02(){
        response.body("limit",equalTo(10));
    }
    // Check the single 'Name' in the Array list(Inver Grove Heights)

    @Test
    public void test03(){
        response.body("data.name",hasItem("Inver Grove Heights"));
    }
    //Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    @Test
    public void test04(){
         response.body("Citynames",equalTo("citynames"));
    }
    //Verify the storeid=7 inside storeservices of the third store of second services
    @Test
    public void test05(){

        response.body("data[2].services[1].storeservices.storeId", equalTo(7));
    }
    //Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
    @Test
    public void hashMapValues() {
        //response.body("data[2].services",equalTo(7));
        response.body("data[2].services[2].storeservices",hasKey("createdAt"));

    }
    //Verify the state = MN of forth store
    @Test
    public void test07(){
         response.body("data.state", hasItem("MN"));
    }
    //Verify the store name = Rochester of 9th store
    @Test
    public void test08(){
        response.body("data.storename",hasItem("9"));
    }
    @Test
    //Verify the storeId = 11 for the 6th store
    public void test09(){
        response.body("storeId",equalTo("storeId=11"));
    }
    @Test
    //Verify the serviceId = 4 for the 7th store of forth service
    public void test10(){
        response.body("serviceId",equalTo("serviceId=4"));
    }

}
