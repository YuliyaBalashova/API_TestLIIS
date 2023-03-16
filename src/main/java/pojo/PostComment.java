package pojo;

public class PostComment {
    private String title;
    private String content;
    private int post;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public PostComment(String title, String content, int post) {
        this.title = title;
        this.content = content;
        this.post = post;
    }

    public PostComment() {
    }

    @Override
    public String toString() {
        return "User{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", post='" + post +
                '}';
    }
}
