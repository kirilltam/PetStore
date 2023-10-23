package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojo.Category;
import pojo.Root;
import pojo.Tag;

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
        root.stream().map(Root::getCategory).forEach(category -> {
            Assert.assertTrue("У category должен быть тип Category", category instanceof Category);
            Assert.assertTrue("Значение поля id в category должен быть тип Long", category.getId() instanceof Long);
            Assert.assertNotNull("Значение поля name в category должен быть тип String", category.getName() instanceof String);
        });
        root.stream().map(Root::getPhotoUrls).forEach(photo -> Assert.assertTrue("У PhotoUrls Должен быть тип List", photo instanceof List));
        root.stream().map(Root::getTags).forEach(tags -> {
            Assert.assertTrue("У tags должен быть тип List", tags instanceof List);
            Assert.assertFalse("Список tags не должен быть пустым", tags.isEmpty());
            tags.forEach(tag -> {
                Assert.assertTrue("У каждого элемента списка tags должен быть тип Tag", tag instanceof Tag);
                Assert.assertFalse("Значение поля id в tag должно быть тип Long", tag.getId() instanceof Long);
                Assert.assertNotNull("Значение поля name в tag должно быть тип String", tag.getName() instanceof String);
            });
        });
        root.stream().map(Root::getStatus).forEach(status -> Assert.assertTrue("У статус должен быть тип String", status instanceof String));

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
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

    }
}



