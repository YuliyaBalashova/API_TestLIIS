package pojo;

public class Post {

    private String title;
    private String content;

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

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "User{" +
                "title='" + title + '\'' +
                ", content='" + content +
                '}';
    }
}

