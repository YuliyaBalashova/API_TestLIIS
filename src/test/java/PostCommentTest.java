import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojo.CreateUser;
import pojo.Post;
import pojo.PostComment;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;

public class PostCommentTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }

    private  static Post post;
    private  static CreateUser user;
    private static PostComment comment;

    @Test
    @DisplayName("Создание комментария пользователем")
    public void postCommentTest() {

        // создание пользователя
        String randomString = Utils.getRandomString(8);
        String randomEmail = Utils.getRandomString(8) + "@" + Utils.getRandomString(6) + "." + Utils.getRandomString(3);
        user = new CreateUser(randomString, randomEmail, randomString);
        // получение id пользователя
        int author = Utils.doPost(Constants.CREATE_USER, user)
                .extract().body().jsonPath().get("id");
        // создание поста
        post = new Post(randomString, randomString);
        // получение id поста
        int id = Utils.doPost(Constants.POST_POST, post, randomString, randomString)
                .extract().body().jsonPath().get("id");

        comment = new PostComment(randomString, randomString, id);
        Utils.doPost(Constants.POST_COMMENT, comment, randomString, randomString)
                .statusCode(SC_CREATED)
                .and()
                .body("title", equalTo(randomString), "content", equalTo(randomString), "author", equalTo(author), "publication_datetime", notNullValue(), "id", notNullValue(), "post", equalTo(id));
    }
}