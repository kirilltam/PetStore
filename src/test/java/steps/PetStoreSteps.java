package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojo.Root;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static steps.BaseClass.baseRequest;
import static steps.BaseClass.response;

public class PetStoreSteps {


    @Когда("^GET запрос (.*)$")
    public void sendGet(String url) {
        RequestSpecification request = given(baseRequest);
        response = request.given().
                accept("*/*").
                contentType("application/json")
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    @Когда("^код ответа (.*)$")
    public void statusCode(int expectedCode) {
        Assert.assertEquals(response.getBody().asString(), expectedCode, response.getStatusCode());
    }

    @Когда("^Запрос (.*) соответствует статусу в ответе '(.*)'$")
    public void checkAllstatus(String url, String expectedStatus) {
        List<Root> root = given(baseRequest)
                .when()
                .contentType(ContentType.JSON)
                .get(url)
                .then().log().all()
                .extract().body().jsonPath().getList(".", Root.class);
        for (Root x : root) {
            Assert.assertEquals(expectedStatus, x.getStatus());
        }
    }

    //метод получения списка Json для переиспользования
    @Когда("^GET получение списка в статусе available$")
    public static List<Root> checkList() {
        return given(baseRequest)
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then().log().all()
                .extract().body().jsonPath().getList(".", Root.class);
    }

    @Когда("^Проверка всех полей на соответствия типу данных$")
    public void Check() {
        List<Root> root = PetStoreSteps.checkList();
        root.stream().map(Root::getId).forEach(id -> Assert.assertTrue("У id должен быть тип Long", id instanceof Long));
        root.stream().map(Root::getName).forEach(name -> Assert.assertTrue("У name должен быть тип String", name instanceof String));
        root.stream().map(Root::getPhotoUrls).forEach(photoUrls -> Assert.assertTrue("У photoUrls должен быть тип  List", photoUrls instanceof List));
        root.stream().map(Root::getTags).forEach(tags -> Assert.assertTrue("У tags должен быть тип List", tags instanceof List));

    }

    @Когда("^POST запрос (.*)$")
    public void PostPet(String url, DataTable bodyData) {
        RequestSpecification request = given(baseRequest);
        Map bodyMap = bodyData.asMap(String.class, String.class);
        response = request.given().
                accept("*/*").
                contentType("application/json")
                .body(bodyMap)
                .when()
                .post(url)
                .then()
                .extract()
                .response();

    }
}


