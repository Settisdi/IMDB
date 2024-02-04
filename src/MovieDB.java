import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class MovieDB {
    private List<Movie> movies;

    public MovieDB(){
        movies = new ArrayList<>();

    }
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void showmoviepage(Movie movie){
        System.out.println("title:" + movie.getTitle() +" , Rating:"+movie.getRating() );
        System.out.println("release date:" + movie.getReleaseDate());
        System.out.println("genre:" + movie.getGenre());
        System.out.println("language:" +movie.getLanguage());
        System.out.println("plot summery:" + movie.getPlotsummery());
        System.out.println("details:" + movie.getDetail());
    }

    public void deleteMovie(String title) {
        movies.removeIf(movie -> movie.getTitle().equalsIgnoreCase(title));
    }

    public void listMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " - Rating: " + movie.getRating());
        }
    }
    public Movie findmovie( String moviename){
        for( Movie movie : movies){
            if (movie.getTitle().equals(moviename)){
                return movie;
            }
        }
        System.out.println("there is no such movie");
        return null;
    }

    public void rateMovie(String title, double rating) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                movie.setRating(rating);
                System.out.println("Rating added for " + title);
                return;
            }
        }
        System.out.println("Movie not found!");
    }

    public void listMoviesByGenre(String genre) {
        List<Movie> filteredMovies = movies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());

        if (filteredMovies.isEmpty()) {
            System.out.println("No movies found in the genre: " + genre);
        } else {
            System.out.println("Movies in the genre '" + genre + "':");
            for (Movie movie : filteredMovies) {
                System.out.println(movie.getTitle() + " - Rating: " + movie.getRating());
            }
        }
    }

    public void addpersontomovie(String person , String role , String movietitle){

        for (Movie movie : movies){
            if( movie.getTitle().equals(movietitle)){
                movie.addPersontoMovie(person , role);
            }
        }
    }

    public void listMoviesByLanguage(String language) {
        List<Movie> filteredMovies = movies.stream()
                .filter(movie -> movie.getLanguage().equalsIgnoreCase(language))
                .collect(Collectors.toList());

        if (filteredMovies.isEmpty()) {
            System.out.println("No movies found in the language: " + language);
        } else {
            System.out.println("Movies in the language '" + language + "':");
            for (Movie movie : filteredMovies) {
                System.out.println(movie.getTitle() + " - Rating: " + movie.getRating());
            }
        }
    }

    public void listMoviesByReleaseDate(String releasedate) {
        List<Movie> filteredMovies = movies.stream()
                .filter(movie -> movie.getReleaseDate().equalsIgnoreCase(releasedate))
                .collect(Collectors.toList());

        if (filteredMovies.isEmpty()) {
            System.out.println("No movies found in the release date: " + releasedate);
        } else {
            System.out.println("Movies in the release date " + releasedate + "':");
            for (Movie movie : filteredMovies) {
                System.out.println(movie.getTitle() + " - Rating: " + movie.getRating());
            }
        }
    }

    public void listoffensivemovies(){
        List<Movie> filteredMovies = movies.stream()
                .filter(movie -> movie.isEffensive())
                .collect(Collectors.toList());

        if (filteredMovies.isEmpty()) {
            System.out.println("No movies found");
        } else {
            System.out.println("Movies : " );
            for (Movie movie : filteredMovies) {
                System.out.println(movie.getTitle() + " - Rating: " + movie.getRating());
            }
        }
    }
    public void listMoviesByPerson(String personName) {
        Map<Movie, String> moviesByPerson = new HashMap<>();

        for (Movie movie : movies) {
            for (Map.Entry<Person, String> entry : movie.getActors().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(personName)) {
                    moviesByPerson.put(movie, entry.getValue());
                    break;
                }
            }
        }

        if (moviesByPerson.isEmpty()) {
            System.out.println("No movies found for the person: " + personName);
        } else {
            System.out.println("Movies for the person " + personName + ":");
            for (Map.Entry<Movie, String> entry : moviesByPerson.entrySet()) {
                System.out.println("Movie: " + entry.getKey().getTitle() + ", Role: " + entry.getValue());
            }
        }
    }

    public void editmovie(Movie movie , String part , String edited ){
        if(part.equalsIgnoreCase("title")){
            movie.setTitle(edited);
        }else if ( part.equalsIgnoreCase("language")){
            movie.setLanguage(edited);
        }else if ( part.equalsIgnoreCase("releasedate")){
            movie.setReleaseDate(edited);
        }else if ( part.equalsIgnoreCase("genre")){
            movie.setGenre(edited);
        }else if ( part.equalsIgnoreCase("plotsummery")){
            movie.setPlotsummery(edited);
        }
    }

    public void adddetail(String detail, Movie movie ){
        movie.setDetail(detail);
    }

    public void offensivemovie(Movie movie){
        movie.setEffensive(true);
    }

    /*public void addsuggests(Movie movie , String part , String suggest , boolean approved){
        editmoviesuggests moviesuggest = new editmoviesuggests(part , suggest , approved);
        suggests.put(movie , );
    }*/

}
