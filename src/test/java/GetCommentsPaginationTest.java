import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;

import static org.apache.http.HttpStatus.*;

public class GetCommentsPaginationTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
    }
    @Test
    @DisplayName("Get comments pagination")
    public void putPostTest() {

        Utils.doGetParam(Constants.GET_COMMENTS_PAGINATION, 1)
                .statusCode(SC_OK);
    }
}