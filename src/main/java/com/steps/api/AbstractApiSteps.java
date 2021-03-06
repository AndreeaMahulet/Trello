package com.steps.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import com.tools.constants.EnvironmentConstants;
import net.thucydides.core.steps.ScenarioSteps;
import static com.jayway.restassured.RestAssured.given;
import org.apache.http.client.methods.HttpGet;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import java.util.HashMap;
import java.util.Map;


public class AbstractApiSteps extends ScenarioSteps {
    private static final long serialVersionUID = 1L;
    public static RequestSpecification specs = null;

    public static Map<String, String> getCommonBodyParams(){
        Map<String,String> bodyParams=new HashMap<String,String>();
        bodyParams.put("key", EnvironmentConstants.API_KEY);
        bodyParams.put("token",EnvironmentConstants.API_TOKEN);
        return bodyParams;
    }
    public static RequestSpecification getSpecWithExtraHeaders() {
        specs = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(EnvironmentConstants.API_BASE_URL)
                .build();
        return specs;
    }
    protected static <T> T getResource(String path, Class<T> responseClass, Object... params) {
        return given().relaxedHTTPSValidation()
                .spec(getSpecWithExtraHeaders())
                .body(getCommonBodyParams())
                .when().get(path, params)
                .then()
                .assertThat().statusCode(anyOf(is(201), is(200), is(302)))
                .extract().as(responseClass);
    }
    protected static <T> T getResourceParams(String path, Class<T> responseClass, Object param,Object... params) {
        return given().relaxedHTTPSValidation()
                .spec(getSpecWithExtraHeaders())
                .body(getCommonBodyParams())
                .when().get(path, param,params)
                .then()
                .assertThat().statusCode(anyOf(is(201), is(200), is(302)))
                .extract().as(responseClass);
    }
    protected static String getNotFoundResourceMessage(String path, Object requestBody, Object... params) {
        return given().relaxedHTTPSValidation()
                .spec(getSpecWithExtraHeaders())
                .body(requestBody)
                .when().get(path, params)
                .then()
                .assertThat().statusCode(404).extract().asString();
    }
    protected static void updateResource(String path, Object requestBody, Object... params) {
        given().relaxedHTTPSValidation()
                .spec(getSpecWithExtraHeaders())
                .body(requestBody)
                .when().put(path, params)
                .then()
                .assertThat().statusCode(anyOf(is(201), is(200), is(302)));
    }
    protected static void deleteResource(String path, String param){
        given().relaxedHTTPSValidation()
                .spec(getSpecWithExtraHeaders())
                .body(getCommonBodyParams())
                .when().delete(path,param)
                .then()
                .assertThat().statusCode(anyOf(is(201),is(200),is(302)));
    }
    protected static <T> T createResource(String path, Object requestBody, Class<T> responseClass) {
        return given().relaxedHTTPSValidation()
                .spec(getSpecWithExtraHeaders())
                .body(requestBody)
                .when().post(path)
                .then().log().body()
                .assertThat().statusCode(anyOf(is(201), is(200), is(302)))
                .extract().as(responseClass);
    }
    protected static <T> T createResourceParams(String path, Object requestBody, Class<T> responseClass, Object... params) {
        return given().relaxedHTTPSValidation()
                .spec(getSpecWithExtraHeaders())
                .body(requestBody)
                .when().post(path,params)
                .then()
                .assertThat().statusCode(anyOf(is(201), is(200), is(302)))
                .extract().as(responseClass);
    }
}
