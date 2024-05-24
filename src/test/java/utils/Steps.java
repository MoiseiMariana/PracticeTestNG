package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.get;
public class Steps {
    @Step

    public static Response GET(String endpoint) {
        Allure.addAttachment("URL", baseURI + endpoint);
        Response response = get(endpoint);
        Allure.addAttachment("Response body", response.body().prettyPrint());
        Allure.addAttachment("Status code", String.valueOf(response.statusCode()));
        return response;
    }
    @Step
    public static void isstatuscodevalid(Response response, int expectedStatuscode){
        response.then().assertThat().statusCode(expectedStatuscode);
    }
    @Step
    public static Response POST(String body, String endpoint ){
        Allure.addAttachment("URL", baseURI+endpoint);
        Allure.addAttachment("Request body", body);
       Response response=  given().body(body).post(endpoint);
        Allure.addAttachment("Status code", String.valueOf(response.statusCode()));
        Allure.addAttachment("Response body", response.body().prettyPrint());
       return response;
    }
    @Step
    public static Response PUT(String body, String endpoint) {
        Allure.addAttachment("URL", baseURI + endpoint);
        Allure.addAttachment("Request body", body);
        Response response = given().body(body).put(endpoint);
        Allure.addAttachment("Status code", String.valueOf(response.statusCode()));
        Allure.addAttachment("Response body", response.body().prettyPrint());
        return response;
    }

    @Step
    public static Response DELETE(String endpoint) {
        Allure.addAttachment("URL", baseURI + endpoint);
        Response response = delete(endpoint);
        Allure.addAttachment("Status code", String.valueOf(response.statusCode()));
        Allure.addAttachment("Response body", response.body().prettyPrint());
        return response;
    }
    @Step
    public static Response PATCH(String body, String endpoint) {
        Allure.addAttachment("URL", baseURI + endpoint);
        Allure.addAttachment("Request body", body);
        Response response = given().body(body).patch(endpoint);
        Allure.addAttachment("Status code", String.valueOf(response.statusCode()));
        Allure.addAttachment("Response body", response.body().prettyPrint());
        return response;
    }


}
