import java.util.ArrayList;
import java.util.List;

public class Review {
    private String text;
    private boolean spoilers;
    private boolean helpful;
    private User user;
    private long likes = 0;
    private List<Comment> comments;

    public Review(String text, boolean spoilers, boolean helpful, User user) {
        this.text = text;
        this.spoilers = spoilers;
        this.helpful = helpful;
        this.user = user;
        this.comments = new ArrayList<>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getLikes() {
        return likes;
    }

    public void addLikes() {
        this.likes = this.likes + 1;
    }
    public void addcomment(Comment comment){
        this.comments.add(comment);
    }

    public void showcomments(){
        for (Comment comment: comments){
            System.out.println(comment.getUser().getUsername()+":");
            System.out.println(comment.getText());
            System.out.println("likes:"+ comment.getLikes());
        }
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

    public boolean isSpoilers() {
        return spoilers;
    }

    public void setSpoilers(boolean spoilers) {
        this.spoilers = spoilers;
    }

    public boolean isHelpful() {
        return helpful;
    }

    public void setHelpful(boolean helpful) {
        this.helpful = helpful;
    }
}
