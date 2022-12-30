package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
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

    // Extract the limit
    @Test
    public void test01() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    // Extract the total
    @Test
    public void test02() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    // Extract the name of 5th store
    @Test
    public void test03() {
        String storename = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + storename);
        System.out.println("------------------End of Test---------------------------");
    }

    // Extract the names of all the store
    @Test
    public void test04() {
        List<Integer> listofstores = response.extract().path("data.stores");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + listofstores);
        System.out.println("------------------End of Test---------------------------");
    }

    // Extract the StoreID of all the store
    @Test
    public void test05() {
        List<Integer> listofstoreID = response.extract().path("data.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + listofstoreID);
        System.out.println("------------------End of Test---------------------------");
    }

    // Print the size of the data list
    @Test
    public void test06() {
        List<Integer> datalist = response.extract().path("data.datalist");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + datalist.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // Get all the value of the store where store name= St Cloud
    @Test
    public void test07() {
        List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + value);
        System.out.println("------------------End of Test---------------------------");
    }

    // Get all the address of the store where store name = Rochester
    @Test
    public void test08() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name=='Rochester'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + address);
        System.out.println("------------------End of Test---------------------------");
    }

    // Get all the services of 8th store
    @Test
    public void test09() {
        List<HashMap<String, ?>> services = response.extract().path("data.findAll{it.name=='storeId8'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get storeservices of the store where service name = Windows Store
    @Test
    public void test10() {
        List<HashMap<String, ?>> storeservices = response.extract().path("data.findAll{it.name==' Windows Store'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + storeservices);
        System.out.println("------------------End of Test---------------------------");
    }

    // Get all the storeId of all the store
    @Test
    public void test11() {
        List<Integer> storeID = response.extract().path("data.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + storeID);
        System.out.println("------------------End of Test---------------------------");
    }

    // Get id of all the store
    @Test
    public void test12() {
        List<Integer> storeID = response.extract().path("data.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + storeID);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the state names Where state = ND
    @Test
    public void test13() {
        List<Integer> stateName = response.extract().path("data.findAll{it.statename=='ND'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + stateName);
        System.out.println("------------------End of Test---------------------------");
    }

    // Find the Total number of services for the store where store name = Rochester
    @Test
    public void test14() {
        List<Integer> totalservices = response.extract().path("data.findAll{it.storename=='Rochester'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + totalservices);
        System.out.println("------------------End of Test---------------------------");
    }

    // Find the createdAt for all services whose name= Window Store
    @Test
    public void test15() {
        List<Integer> services = response.extract().path("data.findAll{it.createdAt=='Window Store'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    // Find the name of all services Where store name = "Fargo"
    @Test
    public void test16() {
        List<Integer> storename = response.extract().path("data.findAll{it.storename=='Fargo'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + storename);
        System.out.println("------------------End of Test---------------------------");
    }

    // Find the zip of all the store
    @Test
    public void test17() {
        List<Integer> storezip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + storezip);
        System.out.println("------------------End of Test---------------------------");
    }

    // Find the zip of the store name = Roseville
    @Test
    public void test18() {
        int zip = response.extract().path("data.find{it.zip=='Roseville'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + zip);
        System.out.println("------------------End of Test---------------------------");
    }

    // Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test19() {
        List<Integer> storeservices = response.extract().path("data.findAll{it.servicename=='Magnolia Home Theater'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + storeservices);
        System.out.println("------------------End of Test---------------------------");
    }

    // Find the lat of all the stores
    @Test
    public void test20() {
        List<Integer> storelat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + storelat);
        System.out.println("------------------End of Test---------------------------");
    }
}

