import java.util.*;

public class Movie {
    private String title ;
    private String releaseDate;
    private String plotsummery;
    private String language;
    private String genre;
    private double rating;
    private Map< Person ,String > actors;
    private List<Person> personList;
    private List<Review> reviews;
    private String detail;
    private boolean effensive;
    private List<editmoviesuggests> suggests = new ArrayList<>();


    public Map<Person, String> getActors() {
        return actors;
    }

    public void setActors(Map<Person, String> actors) {
        this.actors = actors;
    }

    int tedad=0;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        tedad++;
        this.rating =( this.rating + rating)/ tedad;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detaill) {
        this.detail = this.detail+ " , "+ detaill;
    }

    public Movie(String title, String releaseDate, String plotsummery, String language, String genre, double rating, Map<Person, String> actors , String detail , boolean effensive) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.plotsummery = plotsummery;
        this.language = language;
        this.genre = genre;
        this.rating = rating;
        this.actors = actors != null ? actors : new HashMap<>();
        this.personList = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.detail =detail;
        this.effensive = effensive;
    }

    public boolean isEffensive() {
        return effensive;
    }

    public void setEffensive(boolean effensive) {
        this.effensive = effensive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlotsummery() {
        return plotsummery;
    }

    public void setPlotsummery(String plotsummery) {
        this.plotsummery = plotsummery;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void addPersontoMovie(String person , String role ){
        for (Person persoon :personList){
            if( persoon.getName().equals(person)){
                this.actors = new HashMap<>();
                actors.put(persoon , role);
                System.out.print(getTitle() + " persons: "  );
                for (Map.Entry<Person , String> entry : actors.entrySet() ){
                    System.out.print(entry.getKey().getName()+" " + entry.getValue() +" ");
                    System.out.println();
                }
            }
        }

    }

    public void addreview(Review review){
        reviews.add(review);

    }

    public void removerevies(Review review){
        reviews.remove(review);
    }
    public Review findreview(User user){
        for (Review review: reviews){
            if(review.getUser() == user){
                return review;
            }
        }
        return null;
    }


    public void showreviews(){
        System.out.println(getTitle());
        for (Review review : reviews){
            System.out.println(review.getUser().getUsername()+":");
            System.out.println(review.getText());
            System.out.println("is it helpful: "+review.isHelpful());
            System.out.println("spoiler alart: " + review.isSpoilers());
            System.out.println("likes:" + review.getLikes());
            System.out.println("comments:");
            review.showcomments();
        }
        System.out.println();
    }

    public void addsuggest(String part , String suggest , boolean approved){
        editmoviesuggests moviesuggest = new editmoviesuggests(part , suggest , approved);
        suggests.add(moviesuggest);
    }
    public void showsuggests(){
        int n = 0 ;
        for ( editmoviesuggests suggest : suggests){
            System.out.println(n+":" +getTitle()+ " ,"+ suggest.getPart()+" : "+ suggest.getSuggest());
        }
    }


    public List<editmoviesuggests> getSuggests() {
        return suggests;
    }

    public void setSuggests(List<editmoviesuggests> suggests) {
        this.suggests = suggests;
    }
}
