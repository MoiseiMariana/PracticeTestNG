import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.get;

import static io.restassured.RestAssured.given;
import static java.lang.reflect.Array.get;
import static utils.Steps.*;

import utils.Steps.*;
public class testReq {
    private int userId;
    @BeforeSuite
    public void setUP(){
        baseURI="https://reqres.in/api";
    }
    @Test(priority = 1)

    public void testListUsers() {
        String url = "/users?page=2";
        Allure.addAttachment("URL", url);
        Response response = GET(url);
        isstatuscodevalid(response,200);
    }
    @Test(priority=2)
    public void getSingleUser(){
        String url = "/users/2";
        Allure.addAttachment("URL", url);
        Response response = GET(url);
        isstatuscodevalid(response,200);
    }
    @Test(priority = 3)
    public void testCreate(){
        String url ="/users";
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = POST(body, url);
       isstatuscodevalid(response, 201);
        userId = response.jsonPath().getInt("id");
    }
    @Test(priority = 4, dependsOnMethods = "testCreate")
    public void testUpdateUser() {
        String url = "/users/" + userId;
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = PUT(body, url);
        isstatuscodevalid(response, 200);

    }
    @Test(priority = 5, dependsOnMethods = "testUpdateUser")
    public void testPatchUser() {
        String url = "/users/" + userId;
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = PATCH(body, url);
        isstatuscodevalid(response, 200);
    }

    @Test(priority = 6, dependsOnMethods = "testPatchUser")
    public void testDeleteUser() {
        String url = "/users/" + userId;
        Response response = DELETE(url);
        isstatuscodevalid(response, 204);
    }


}
