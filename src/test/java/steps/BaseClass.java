package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Root;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BaseClass {
    public static Response response;
    public static List list;
    public static RequestSpecification baseRequest = new RequestSpecBuilder().
            setBaseUri("https://petstore.swagger.io/v2").
            log(LogDetail.ALL).
            build();
    public static RequestSpecification RequestStatus = new RequestSpecBuilder().
            setBaseUri("https://petstore.swagger.io/v2/pet/findByStatus").
            log(LogDetail.ALL).
            build();









}
