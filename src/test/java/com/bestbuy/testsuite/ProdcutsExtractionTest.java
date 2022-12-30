package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProdcutsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="http://localhost";
        RestAssured.port =3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }
    // Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : "+limit);
        System.out.println("------------------End of Test---------------------------");

    }
    // Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : "+total);
        System.out.println("------------------End of Test---------------------------");

    }
    // Extract the name of 5th product
    @Test
    public void test003() {
       String productname  = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : "+productname);
        System.out.println("------------------End of Test---------------------------");

    }
    // Extract the names of all the products
    @Test
    public void test004(){
        List<String>listofproducts = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : "+listofproducts);
        System.out.println("------------------End of Test---------------------------");

    }
    // Extract the productId of all the products
    @Test
    public void test005(){
        List<String>listofproductId = response.extract().path("data.productId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : "+listofproductId);
        System.out.println("------------------End of Test---------------------------");
    }
    //Print the size of the data list
    @Test
    public void test006(){
        List<String>sizeofdatalist= response.extract().path("data.datalist");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : "+sizeofdatalist.size());
        System.out.println("------------------End of Test---------------------------");
    }
   //Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
   @Test
   public void test007() {
       List<HashMap<String,?>>values = response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'} ");

       System.out.println("------------------StartingTest---------------------------");
       System.out.println("The values for product name 'Energizer - MAX Batteries AA (4-Pack)' are: "+values);
       System.out.println("------------------End of Test---------------------------");
   }
   //Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
   @Test
   public void test008() {
       String productmodel = response.extract().path("data[8].model");

       System.out.println("------------------StartingTest---------------------------");
       System.out.println("The product where productname 'Energizer - N Cell E90 Batteries (2-Pack)'are :"+productmodel );
       System.out.println("------------------End of Test---------------------------");
   }
   //29. Get all the categories of 8th products
   @Test
   public void test009() {
       List<HashMap<String,?>>list0fcategories = response.extract().path("data[7].categories");

       System.out.println("------------------StartingTest---------------------------");
       System.out.println("List of categories are : "+list0fcategories);
       System.out.println("------------------End of Test---------------------------");

   }
  //Get categories of the store where product id = 150115

    @Test
    public void test010() {
        List<Integer>categoriesofproductid = response.extract().path("data[3].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of categoriesofproductid are : "+categoriesofproductid);
        System.out.println("------------------End of Test---------------------------");

    }
  //Get all the descriptions of all the products
  @Test
  public void test011() {
      List<HashMap<String, ?>> descriptionsofallproducts = response.extract().path("data.findAll{it.name=='description'}");

      System.out.println("------------------StartingTest---------------------------");
      System.out.println("List of descriptionofallproducts are : " + descriptionsofallproducts);
      System.out.println("------------------End of Test---------------------------");
  }

  //32. Get id of all the all categories of all the products
      @Test
      public void test012() {
          List<HashMap<String, ?>> categoriesofallproducts = response.extract().path("data.findAll{it.name=='categories of all the products'}");

          System.out.println("------------------StartingTest---------------------------");
          System.out.println("List of descriptionofallproducts are : " + categoriesofallproducts);
          System.out.println("------------------End of Test---------------------------");
      }
  //Find the product names Where type = HardGood
@Test
    public void test013(){
        String productnames = response.extract().path("data.findAll{it.names=='HardGood'}");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List of productnames are : " + productnames);
    System.out.println("------------------End of Test---------------------------");
}
  //34. Find the Total number of categories for the product where product name = Duracell - AA
  //1.5V CopperTop Batteries (4-Pack)
  @Test
  public void test014() {
      List<HashMap<String, ?>> numberofcategories = response.extract().path("data.findAll{it.name=='Duracell - AA" +
              "  //1.5V CopperTop Batteries (4-Pack)'}");

      System.out.println("------------------StartingTest---------------------------");
      System.out.println("List of descriptionofallproducts are : " + numberofcategories);
      System.out.println("------------------End of Test---------------------------");
  }
//35. Find the createdAt for all products whose price < 5.49
@Test
public void test015() {
    List<String> productname = response.extract().path("data.findAll{it.price<5.49}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("find the createdAt for all products price is less than 5.99are: "+productname);
    System.out.println("------------------End of Test---------------------------");
}
//36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)"
@Test
public void test016() {
    List<HashMap<String,?>>categories= response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'} ");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The values for product name 'Duracell - AA Batteries (8-Pack)' are: "+categories);
    System.out.println("------------------End of Test---------------------------");
}
//Find the manufacturer of all the products
@Test
public void test017() {
    List<?>manuList = response.extract().path("data.findAll{it.name=='manufacturer'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The manufacturer of all the products  are: "+manuList);
    System.out.println("------------------End of Test---------------------------");
}
//Find the image of products whose manufacturer is = Energizer
@Test
public void test018() {
    String productimage = response.extract().path("data[8].image");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The product image of  'Energizer ' are :" + productimage);
    System.out.println("------------------End of Test---------------------------");
}
//Find the createdAt for all categories products whose price > 5.99
@Test
public void test019() {
    List<String> productname = response.extract().path("data.findAll{it.price>5.49}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("find the createdAt for all products price is more than 5.99are: " + productname);
    System.out.println("------------------End of Test---------------------------");
}
//Find the uri of all the products
    @Test
    public void test020() {
        List<String> productsurl = response.extract().path("data.findAll{it.proucts=='url'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("find the createdAt for all products price is more than 5.99are: " + productsurl);
        System.out.println("------------------End of Test---------------------------");
    }
}


