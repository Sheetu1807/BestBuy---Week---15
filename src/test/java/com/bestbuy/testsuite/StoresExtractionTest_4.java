package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class StoresExtractionTest_4 {
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

    // 1. Extract the limit
    @Test
    public void ExtractLimit() {

        int limit = response.extract().path("limit");
        System.out.println("value of limit is : " + limit);
        Assert.assertEquals(10, limit); //one way of assertion
        response.body("limit", equalTo(10)); // second way of assertion

    }

    // 2. Extract the total
    @Test
    public void ExtractTotal() {
        int total = response.extract().path("total");
        System.out.println("value of total is : " + total);
        Assert.assertEquals(1575, total);
        response.body("total", equalTo(1575));

    }

    //  3. Extract the name of 5th store
    @Test
    public void ExtractName(){
        String name5thStore = response.extract().path("data[4].name");
        System.out.println("Name of 5th store is : " + name5thStore);

    }

    // 4. Extract the names of all the store
    @Test
    public void ExtractNamesOfAllStores(){
        List<String> storeNames = response.extract().path("data.name");
        System.out.println("List of store names : " + storeNames);

    }

    // 5. Extract the storeId of all the store
    @Test
    public void ExtractStoreIDofAllStore(){
        List<String> storeID = response.extract().path("data.id");
        System.out.println("List of ID names : " + storeID);

    }

    // 6. Print the size of the data list
    @Test
    public void PrintSizeofDataList() {
        List<Integer> dataSize = response.extract().path("data");
        int size = dataSize.size();
        System.out.println(size);

    }

    // 7. Get all the value of the store where store name = St Cloud
    @Test
    public void GetAllValueofStore() {
        List<Integer> StCloudStorename = response.extract().path("data.findAll{it.name == 'StCloud'}");
        System.out.println("St Cloud values : " + StCloudStorename);

    }

    // 8. Get the address of the store where store name = Rochester
    @Test
    public void GetAddressOfStore() {
        List<Integer> addressRochester = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("Rochester address : " + addressRochester);

    }

    // 9. Get all the services of 8th store
    @Test
    public void GetAllServices() {
        List<Map<String,?>> service8thStore = response.extract().path("data[7].services");
        System.out.println("8th Store data : " + service8thStore);

    }

    // 10. Get store services of the store where service name = Windows Store
    @Test
    public void GetStoreServices() {
        List<Map<String,?>> windowStore = response.extract().path("data.services.findAll{it.name == 'Windows store'}");
        System.out.println(windowStore);

    }

    // 11. Get all the store ID of all the store
    @Test
    public void GetAllStoreID() {
        List<Map<String,?>> storeID = response.extract().path("data.services.storeservices.storeID");
        System.out.println(storeID);

    }

    // 12. Get id of all the store
    @Test
    public void GetIDofAllStore() {
        List<Map<String,?>> storeIDs = response.extract().path("data.id");
        System.out.println(storeIDs);

    }

    // 13. Find the store names Where state = ND
    @Test
    public void FindStoreNames() {
        List<String> storeNames = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println(storeNames);

    }

    // 14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void FindTotalNumofServices() {
        List<Map<String,?>> serviceRochester = response.extract().path("data[8].services");
        int size = serviceRochester.size();
        System.out.println(size);

    }

    // 15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void FindCreatedAt() {
        List<Map<String,?>> createdAt = response.extract().path("data.services.findAll{it.name == 'Windows Store'}.createdAt");
        System.out.println(createdAt);

    }

    // 16. Find the name of all services Where store name = “Fargo”
    @Test
    public void FindNameofAllServices() {
        List<Map<String,?>> servicesFargo = response.extract().path("data.findAll{it.name == 'Fargo'}.services");
        System.out.println(servicesFargo);

    }

    // 17. Find the zip of all the store
    @Test
    public void FindZipofAllStore() {
        List<Map<String,?>> allZips = response.extract().path("data.zip");
        System.out.println(allZips);

    }

    // 18. Find the zip of store name = Roseville
    @Test
    public void FindZipofStoreName () {
        List<Map<String,?>> zipRoseville = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println(zipRoseville);

    }

    // 19. Find the store services details of the service name = Magnolia Home Theater
    @Test
    public void FindStoreServicesDetails() {
        List<Integer> storeServicesDetails = response.extract().path("data.findAll{it.name='Magnolia Home Theater'}.services");
        System.out.println("The details of store services : " + storeServicesDetails);

    }

    // 20. Find the lat of all the stores
    @Test
    public void FindLat() {
        List<Map<String,?>> storeLat = response.extract().path("data.lat");
        System.out.println(storeLat);

    }

}