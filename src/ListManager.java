import java.util.ArrayList;
import java.util.List;

public class ListManager {
    private List<Listing> personallists;
    // ber user vasle


    public ListManager() {
        this.personallists = new ArrayList<>();
    }

    public List<Listing> getPersonallists() {
        return personallists;
    }

    public void setPersonallists(List<Listing> personallists) {
        this.personallists = personallists;
    }
    public void addMovieToList(Movie movie, String listname , User user) {
        boolean listExists = false;

        // Check if a list with the given name exists
        for (Listing list : personallists) {
            if (list.getListname().equalsIgnoreCase(listname)) {
                list.addMovie(movie);
                listExists = true;
                break;
            }
        }
        if (!listExists) {
            Listing newList = new Listing(listname, movie);
            user.getUserlists().add(newList);
            personallists.add(newList);
        }
    }


    public void printlist(String listname ){
        for( Listing listing1 : personallists){
            if (listing1.getListname().equals(listname)){
                listing1.showlist();
            }
        }
    }

    public void removemoviefromlist(Movie movie , String listname){
        for( Listing listing : personallists){
            if( listing.getListname().equalsIgnoreCase(listname)){
                listing.removemovie(movie);
                System.out.println("movie removed successfully");
            }
        }
    }

    public void deleteList(String listName , User user) {
        personallists.removeIf(listing -> listing.getListname().equalsIgnoreCase(listName));
    }

}
