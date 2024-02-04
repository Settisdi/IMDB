import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewController {
    private List<Review> reviews;

    public ReviewController() {
        this.reviews = new ArrayList<>();
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


}
