public class Constants {

    private Constants() {
        throw new IllegalAccessError("Utility class");
    }

    public static final String BASE_URL = "https://hr.recruit.liis.su";

    public static final String CREATE_USER = "/qa0/v1/api/yusbalashova@gmail.com/sign-in";
    public static final String CREATE_USER_V2 = "/qa0/v2/api/yusbalashova@gmail.com/sign-in";

    public static final String GET_POSTS = "/qa0/v1/api/yusbalashova@gmail.com/posts";

    public static final String POST_POST = "/qa0/v1/api/yusbalashova@gmail.com/posts";

    public static final String GET_POST = "/qa0/v1/api/yusbalashova@gmail.com/post";

    public static final String PUT_POST = "/qa0/v1/api/yusbalashova@gmail.com/post";

    public static final String DELETE_POST = "/qa0/v1/api/yusbalashova@gmail.com/post";

    public static final String GET_COMMENTS = "/qa0/v1/api/yusbalashova@gmail.com/comments";

    public static final String POST_COMMENT = "/qa0/v1/api/yusbalashova@gmail.com/comments";

    public static final String GET_COMMENT = "/qa0/v1/api/yusbalashova@gmail.com/comment";

    public static final String PUT_COMMENT = "/qa0/v1/api/yusbalashova@gmail.com/comment";

    public static final String DELETE_COMMENT = "/qa0/v1/api/yusbalashova@gmail.com/comment";

    public static final String PUT_ADMIN = "/qa0/v2/api/yusbalashova@gmail.com/make_admin";
    public static final String GET_POSTS_PAGINATION = "/qa0/v2/api/yusbalashova@gmail.com/posts";
    public static final String GET_COMMENTS_PAGINATION = "/qa0/v2/api/yusbalashova@gmail.com/comments";
}
