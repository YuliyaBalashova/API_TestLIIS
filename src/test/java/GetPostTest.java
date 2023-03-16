import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojo.CreateUser;
import pojo.Post;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;

public class GetPostTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }

    private  static Post post;
    private  static CreateUser user;

    @Test
    @DisplayName("Получение поста по id")
    public void getPostsTest() {
        // создание пользователя
        String randomString = Utils.getRandomString(8);
        String randomEmail = Utils.getRandomString(8) + "@" + Utils.getRandomString(6) + "." + Utils.getRandomString(3);
        user = new CreateUser(randomString, randomEmail, randomString);
        // получение id пользователя
        int author = Utils.doPost(Constants.CREATE_USER, user)
                .extract().body().jsonPath().get("id");
        // создание поста
        String randomStringPost = Utils.getRandomString(8);
        post = new Post(randomStringPost, randomStringPost);
        // получение id поста
        int id = Utils.doPost(Constants.POST_POST, post, randomString, randomString)
                .extract().body().jsonPath().get("id");

        Utils.doGet(Constants.GET_POST, id)
                .statusCode(SC_OK)
                .and()
                .body("author", equalTo(author), "content", equalTo(randomStringPost), "id", equalTo(id), "publication_datetime", notNullValue(), "title", equalTo(randomStringPost));
    }
}