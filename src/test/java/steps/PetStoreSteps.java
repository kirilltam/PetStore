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

public class PetStoreSteps extends BaseClass {


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

    @Когда("^Проверка всех полей в статусе (.*)$")
    public void CheckList(String url) {
        List<Root> root = given(RequestStatus)
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then().log().all()
                .extract().body().jsonPath().getList(".", Root.class);
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
        root.stream().map(Root::getId).forEach(id -> Assert.assertNotNull("id не может быть пустым", id));
        root.stream().map(Root::getName).forEach(name -> Assert.assertNotNull(" name не может быть пустым", name));
        root.stream().map(Root::getCategory).forEach(category -> {
            Assert.assertNotNull("У category должен быть тип Category", category);
            Assert.assertNotNull("Значение поля id в category не может быть пустым", category.getId());
            Assert.assertNotNull("Значение поля name в category не может быть пустым", category.getName());
        });
        root.stream().map(Root::getPhotoUrls).forEach(photo -> Assert.assertNotNull("У PhotoUrls не может быть пустым", photo));
        root.stream().map(Root::getTags).forEach(tags -> {
            Assert.assertNotNull("tags не может быть пустым", tags);
            tags.forEach(tag -> {
                Assert.assertNotNull("Значение поля id в tag не может быть пустым", tag.getId());
                Assert.assertNotNull("Значение поля name в tag не может быть пустым", tag.getName());
            });
        });
        root.stream().map(Root::getStatus).forEach(status -> Assert.assertTrue("У статус должен быть тип String", status instanceof String));
    }


    @Когда("^POST запрос (.*)$")
    public void PostPet(String url, DataTable bodyJson) {
        RequestSpecification request = given(baseRequest);
        Map bodyMap = bodyJson.asMap(String.class, String.class);
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

    @Когда("^Удалить  (.*)$")
    public void Delete(String url) {
        RequestSpecification request = given(baseRequest);
        response = request.given().
                accept("*/*").
                contentType("application/json")
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }
    @Когда("^Delete удалить заказать (.*)$")
    public void DeleteOrderPet(String url, DataTable bodyJson) {
        RequestSpecification request = given(baseRequest);
        Map bodyMap = bodyJson.asMap(String.class, String.class);
        response = request.given().
                accept("*/*").
                contentType("application/json")
                .body(bodyMap)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();


    }


}



