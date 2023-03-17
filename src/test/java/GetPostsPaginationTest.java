import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;

import static org.apache.http.HttpStatus.*;

public class GetPostsPaginationTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }

    @Test
    @DisplayName("Get posts pagination")
    public void putPostTest() {

        Utils.doGetParam(Constants.GET_POSTS_PAGINATION, 1)
                .statusCode(SC_OK);
    }
}