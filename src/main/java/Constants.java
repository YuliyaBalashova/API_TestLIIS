public class Constants {

    private Constants() {
        throw new IllegalAccessError("Utility class");
    }

    public static final String BASE_URL = "https://hr.recruit.liis.su";

    public static final String CREATE_USER = "/qa0/v1/api/<tester>/sign-in";

    public static final String GET_POSTS = "/qa0/v1/api/<tester>/posts";

    public static final String POST_POST = "/qa0/v1/api/<tester>/posts";

    public static final String GET_POST = "/qa0/v1/api/<tester>/post";

    public static final String PUT_POST = "/qa0/v1/api/<tester>/post";

    public static final String DELETE_POST = "/qa0/v1/api/<tester>/post";

    public static final String GET_COMMENTS = "/qa0/v1/api/<tester>/comments";

    public static final String POST_COMMENT = "/qa0/v1/api/<tester>/comments";

    public static final String GET_COMMENT = "/qa0/v1/api/<tester>/comment";

    public static final String PUT_COMMENT = "/qa0/v1/api/<tester>/comment";

    public static final String DELETE_COMMENT = "/qa0/v1/api/<tester>/comment";
}
