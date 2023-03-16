import java.util.Random;
import java.util.stream.Collectors;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Utils {

    private Utils() {
        throw new IllegalAccessError("Utility class");
    }

    // POST без авторизации
    public static ValidatableResponse doPost(String endpoint, Object body) {
        return given()
                .log().all()
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all();
    }

    // POST с авторизацией
    public static ValidatableResponse doPost(String endpoint, Object body, String username, String password) {
        return given()
                .log().all()
                .auth().basic(username, password)
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all();
    }

    // GET
    public static ValidatableResponse doGet(String endpoint) {
        return given()
                .log().all()
                .header("Content-type", "application/json")
                .get(endpoint)
                .then()
                .log().all();
    }

    // GET
    public static ValidatableResponse doGet(String endpoint, int id) {
        return given()
                .log().all()
                .header("Content-type", "application/json")
                .get(endpoint + "/" + id)
                .then()
                .log().all();
    }

    // PUT с авторизацией
    public static ValidatableResponse doPut(String endpoint, Object body, int id, String username, String password) {
        return given()
                .log().all()
                .auth().basic(username, password)
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .put(endpoint + "/" + id)
                .then()
                .log().all();
    }

    // DELETE
    public static ValidatableResponse doDelete(String endpoint, int id, String username, String password) {
        return given()
                .log().all()
                .auth().basic(username, password)
                .header("Content-type", "application/json")
                .delete(endpoint + "/" + id)
                .then()
                .log().all();
    }

    /**
     * Получение рандомной строки
     * @param size - длина строки
     * @return - рандомная строка
     */
    public static String getRandomString(long size) {
        String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return new Random().ints(size, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}