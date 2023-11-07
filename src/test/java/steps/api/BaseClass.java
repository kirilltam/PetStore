package steps.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

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
