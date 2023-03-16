import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojo.CreateUser;
import pojo.Post;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;

public class PutPostTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }

    private static Post post;
    private static Post changePost;
    private static CreateUser user;

    @Test
    @DisplayName("Изменение поста по id")
    public void putPostTest() {

        // создание пользователя
        String randomString = Utils.getRandomString(8);
        String randomEmail = Utils.getRandomString(8) + "@" + Utils.getRandomString(6) + "." + Utils.getRandomString(3);
        user = new CreateUser(randomString, randomEmail, randomString);
        Utils.doPost(Constants.CREATE_USER, user);
        // создание поста
        post = new Post(randomString, randomString);
        // получение id поста
        int id = Utils.doPost(Constants.POST_POST, post, randomString, randomString)
                .extract().body().jsonPath().get("id");

        String randomStringChange = Utils.getRandomString(8);
        changePost = new Post(randomStringChange, randomStringChange);
        Utils.doPut(Constants.PUT_POST, changePost, id, randomString, randomString)
                .statusCode(SC_OK)
                .and()
                .body("message", equalTo("updated"), "type", equalTo("success"));
    }
}