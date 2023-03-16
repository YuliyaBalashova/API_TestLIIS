import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojo.CreateUser;
import pojo.Post;
import pojo.PostComment;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;

public class GetCommentTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }

    private  static Post post;
    private  static CreateUser user;
    private static PostComment comment;

    @Test
    @DisplayName("Получение комментария по id комментария")
    public void postCommentTest() {

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
        int postID = Utils.doPost(Constants.POST_POST, post, randomString, randomString)
                .extract().body().jsonPath().get("id");
        // создание комментария
        String randomStringComment = Utils.getRandomString(8);
        comment = new PostComment(randomStringComment, randomStringComment, postID);
        // получение id комментария
        int id = Utils.doPost(Constants.POST_COMMENT, comment, randomString, randomString)
                .extract().body().jsonPath().get("id");

        Utils.doGet(Constants.GET_COMMENT, id)
                .statusCode(SC_OK)
                .and()
                .body("title", equalTo(randomStringComment), "content", equalTo(randomStringComment), "author", equalTo(author), "publication_datetime", notNullValue(), "id", equalTo(id), "post", equalTo(postID));
    }
}