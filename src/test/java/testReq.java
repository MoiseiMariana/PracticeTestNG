import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.get;

import static io.restassured.RestAssured.given;
import static java.lang.reflect.Array.get;
import static utils.Steps.GET;
import static utils.Steps.POST;
import static utils.Steps.isstatuscodevalid;

import utils.Steps.*;
public class testReq {
    @BeforeSuite
    public void setUP(){
        baseURI="https://reqres.in/api";
    }
    @Test

    public void testListUsers() {
        String url = "/users?page=2";
        Allure.addAttachment("URL", url);
        Response response = GET(url);
        isstatuscodevalid(response,200);
    }
    @Test
    public void getSingleUser(){
        String url = "/users/2";
        Allure.addAttachment("URL", url);
        Response response = GET(url);
        isstatuscodevalid(response,200);
    }
    @Test
    public void testCreate(){
        String url ="/users";
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = POST(body, url);
       isstatuscodevalid(response, 201);
    }

}
