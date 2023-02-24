package com.bestbuy.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase_Products {

    @BeforeClass
    public static void inIt2() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
    }
}
