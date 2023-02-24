package com.bestbuy.testsuite;


import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class StoresAssertionTest_3 {

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

    // 1. Verify the if the total is equal to 1561
    @Test
    public void VerifyTotal() {
        response.body("total", equalTo(1575));
    }

    // 2. Verify the if the stores of limit is equal to 10
    @Test
    public void VerifyStores() {
        response.body("limit", equalTo(10));
    }

    // 3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void CheckSingleName() {
        response.body("data[1].name", equalTo("Inver Grove Heights"));

    }

    // 4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    @Test
    public void CheckMultipleNames() {
        response.body("data.name", hasItem("Roseville"));
        response.body("data[3].name", equalTo("Burnsville"));
        response.body("data[4].name", equalTo("Northtown"));

    }

    // 5. Verify the store ID = 7 inside store services of the third store of second services
    @Test
    public void VerifyStore() {
        response.body("data[2].services[2].storeservices.storeId", equalTo(7));

    }

    // 6. Check hash map values ‘createdAt’ inside store services map where store name = Roseville
    @Test
    public void CheckHashMapValues() {
        response.body("data[2].createdAt", equalTo("2016-11-17T17:57:05.853Z"));

    }

    // 7. Verify the state = MN of forth store
    @Test
    public void VerifyState() {
     response.body("data[3].state", equalTo("MN"));

    }

    // 8. Verify the store name = Rochester of 9th store
    @Test
    public void VerifyStoreName() {
        response.body("data[8].name", equalTo("Oakdale"));

    }

    // 9. Verify the store ID = 11 for the 6th store
    @Test
    public void VerifyStoreID() {
        response.body("data[5].id", equalTo(12));
    }

    // 10. Verify the service ID = 4 for the 7th store of forth service
    @Test
    public void VerifyServiceID() {
        response.body("data[6].services[3].id", equalTo(4));

    }

}
