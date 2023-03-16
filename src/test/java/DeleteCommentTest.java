import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pojo.CreateUser;
import pojo.Post;
import pojo.PostComment;

import static org.apache.http.HttpStatus.*;

public class DeleteCommentTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }

    private static Post post;
    private static CreateUser user;
    private static PostComment comment;

    @Test
    @DisplayName("Удаление комментария по id комментария")
    public void deleteCommentTest() {

        // создание пользователя
        String randomString = Utils.getRandomString(8);
        String randomEmail = Utils.getRandomString(8) + "@" + Utils.getRandomString(6) + "." + Utils.getRandomString(3);
        user = new CreateUser(randomString, randomEmail, randomString);
        Utils.doPost(Constants.CREATE_USER, user);
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

        Utils.doDelete(Constants.DELETE_COMMENT, id, randomString, randomString)
                .statusCode(SC_NO_CONTENT);
    }
}