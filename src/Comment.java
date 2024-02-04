public class Comment {
    private User user;
    private String text;
    private long likes = 0;

    public Comment(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getLikes() {
        return likes;
    }

    public void addLikes() {
        this.likes = this.likes + 1;
    }
}
