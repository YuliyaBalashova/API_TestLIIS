import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojo.CreateUser;
import pojo.Post;

import static org.apache.http.HttpStatus.*;

public class DeletePostTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }

    private static Post post;
    private static CreateUser user;

    @Test
    @DisplayName("Удаление поста по id")
    public void deletePostsTest() {

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

        Utils.doDelete(Constants.DELETE_POST, id, randomString, randomString)
                .statusCode(SC_NO_CONTENT);
    }
}