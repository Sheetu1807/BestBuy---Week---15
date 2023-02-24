package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ProductsExtractionTest_2 {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    // 21. Extract the limit
    @Test
    public void ExtractLimit(){

        int limit = response.extract().path("limit");
        System.out.println("value of limit is : " + limit);
//        Assert.assertEquals(10, limit); //one way of assertion
//        response.body("limit", equalTo(10)); // second way of assertion

    }

    // 22. Extract the total
    @Test
    public void ExtractTotal(){

        int total = response.extract().path("total");
        System.out.println("value of total is : " + total);
//        Assert.assertEquals(51957, total);
//        response.body("total", equalTo(51957));

    }

    // 23. Extract the name of 5th product
    @Test
    public void ExtractName(){
        String name = response.extract().path("data[4].name");
        System.out.println("Duracell - C Batteries (4-Pack)");

    }

    // 24. Extract the names of all the products
    @Test
    public void ExtractNamesofAllProducts(){
        List<Map<String,?>> names = response.extract().path("data.name");
        System.out.println(names);

    }

    // 25. Extract the product ID of all the products
    @Test
    public void ExtractProductID(){
        List<Map<String,?>> productIDs = response.extract().path("data.id");
        System.out.println(productIDs);

    }

    // 26. Print the size of the data list
    @Test
    public void PrintSize(){
        List<Map<String,?>> sizeDataList = response.extract().path("data");
        int size = sizeDataList.size();
        System.out.println("Size of data list is : " + size);

    }

    // 27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void GetAllValue(){
        HashMap<?,?> productValue = response.extract().path("data[3]");
        System.out.println(productValue);

    }

     // 28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void GetModelofProduct(){
        String model = response.extract().path("data[8].model");
        System.out.println("Model of Energizer - N Cell E90 Batteries (2-Pack): " + model);

    }

    // 29. Get all the categories of 8th products
    @Test
    public void GetAllCategories(){
        List<Map<?,?>> product8th = response.extract().path("data[7].categories");
        System.out.println(product8th);

    }

     // 30. Get categories of the store where product ID = 150115
    @Test
    public void GetCategoriesofStore(){
        List<Map<?,?>> productID = response.extract().path("data[3].categories");
        System.out.println(productID);

    }

    // 31. Get all the descriptions of all the products
    @Test
    public void GetAllDescriptions(){
        List<Map<?,?>> descriptionsAllProducts = response.extract().path("data.description");
        System.out.println(descriptionsAllProducts);

    }

    // 32. Get ID of all the all categories of all the products
    @Test
    public void GetIDofAllCategories(){
        List<Map<?,?>> IDsofAllProducts = response.extract().path("data.categories.id");
        System.out.println(IDsofAllProducts);

    }

     // 33. Find the product names Where type = HardGood
    @Test
    public void FindProductName(){
        List<Map<?,?>> productType = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println(productType);

    }

    // 34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void FindTotalNumOfCategories(){
        List<HashMap<?,?>> totalNumCategory = response.extract().path("data[1].categories");
        int totalSize = totalNumCategory.size();
        System.out.println(totalSize);

    }

    // 35. Find the createdAt for all products whose price < 5.49
    @Test
    public void FindCreatedAt(){
        List<HashMap<?,?>> createdAtLessThan = response.extract().path("data.findAll{it.price <= 5.49}.createdAt");
        System.out.println(createdAtLessThan);

    }

    // 36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void FindNameofAllCategories(){
        List<HashMap<?,?>> categoryAllName = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories");
        System.out.println(categoryAllName);

    }

    // 37. Find the manufacturer of all the products
    @Test
    public void FindManufacturer(){
        List<HashMap<?,?>> manufacturerAllProducts = response.extract().path("data.manufacturer");
        System.out.println(manufacturerAllProducts);

    }

    // 38. Find the image of products whose manufacturer is = Energizer
    @Test
    public void FindImage(){
        List<HashMap<?,?>> imageManufacturer = response.extract().path("data.findAll{it.name.startsWith('Energizer')}.image");
        System.out.println(imageManufacturer);

    }

    // 39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void FindCreatedAtforAllCategoriesPrice(){
        List<HashMap<?,?>> createdAtMoreThan = response.extract().path("data.findAll{it.price >= 5.99}.createdAt");
        System.out.println(createdAtMoreThan);

    }

    // 40. Find the URL of all the product
    @Test
    public void FindURL(){
        List<HashMap<?,?>> URLofAllProducts = response.extract().path("data.url");
        System.out.println(URLofAllProducts);

    }
}