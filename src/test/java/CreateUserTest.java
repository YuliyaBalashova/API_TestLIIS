import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojo.CreateUser;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }

    private  static CreateUser user;

    @Test
    @DisplayName("Cоздание корректного пользователя")
    public void createUserTest() {
        String randomString = Utils.getRandomString(8);
        String randomEmail = Utils.getRandomString(8) + "@" + Utils.getRandomString(6) + "." + Utils.getRandomString(3);
        user = new CreateUser(randomString, randomEmail, randomString);
        Utils.doPost(Constants.CREATE_USER, user)
                .statusCode(SC_CREATED)
                .and()
                .body("username", equalTo(randomString), "email", equalTo(randomEmail), "id", notNullValue(), "password", notNullValue());
    }
}