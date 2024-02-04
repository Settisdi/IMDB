import java.util.List;
import java.util.ArrayList;
public class Listing {
    private String listname;
    private List<Movie> movieList;
    private Person person;

    public Listing(String listname, Person person) {
        this.listname = listname;
        this.movieList = new ArrayList<>();
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Listing(String listname, Movie movie) {
        this.listname = listname;
        this.movieList = new ArrayList<>(); // Initialize the movieList
        this.movieList.add(movie);
    }


    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public void showlist(){
        System.out.println(listname + ":");
        for( Movie movie : movieList){
            System.out.println(movie.getTitle() + "  genre:" + movie.getGenre());
        }
    }

    public void removemovie(Movie movie){
        movieList.remove(movie);
    }
}
