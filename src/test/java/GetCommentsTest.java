import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;

public class GetCommentsTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }

    @Test
    @DisplayName("Получение списка комментариев")
    public void getCommentsTest() {
        Utils.doGet(Constants.GET_COMMENTS)
                .statusCode(SC_OK)
                .and()
                .body("title", notNullValue(), "content", notNullValue(), "author", notNullValue(), "publication_datetime", notNullValue(), "id", notNullValue(), "post", notNullValue());
    }
}
