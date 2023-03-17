import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojo.Admin;
import pojo.CreateUser;

import static org.apache.http.HttpStatus.*;

public class CreateAdminTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }

    private static CreateUser user;

    private static Admin admin;

    @Test
    @DisplayName("Grant user admin role")
    public void putPostTest() {

        // создание пользователя
        String randomString = Utils.getRandomString(8);
        String randomEmail = Utils.getRandomString(8) + "@" + Utils.getRandomString(6) + "." + Utils.getRandomString(3);
        user = new CreateUser(randomString, randomEmail, randomString);
        // получение id пользователя
        int author = Utils.doPost(Constants.CREATE_USER_V2, user)
                .extract().body().jsonPath().get("id");

        admin = new Admin(author);
        Utils.doPut(Constants.PUT_ADMIN, admin, randomString, randomString)
                .statusCode(SC_OK);
    }
}