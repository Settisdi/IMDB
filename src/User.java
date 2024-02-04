import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private String username ;
    private String password;
    private UserRole role;
    //private String email;
    //private LocalDate dateofbirth;
    private List<Listing> userlists;
    private Set<User> followedUsers;
    private Set<Person> followedPersons; // use set to not follow someone twice
    private boolean banned;


    public User(String username, String password, UserRole role , boolean banned) {
        this.username = username;
        this.password = password;
        this.role = role;
        followedUsers = new HashSet<>();
        followedPersons = new HashSet<>();
        this.userlists = new ArrayList<>();
        this.banned = banned;
    }

    public List<Listing> getUserlists() {
        return userlists;
    }

    public void setUserlists(List<Listing> userlists) {
        this.userlists = userlists;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public Set<User> getFollowedUsers() {
        return followedUsers;
    }

    public void setFollowedUsers(Set<User> followedUsers) {
        this.followedUsers = followedUsers;
    }

    public Set<Person> getFollowedPersons() {
        return followedPersons;
    }

    public void setFollowedPersons(Set<Person> followedPersons) {
        this.followedPersons = followedPersons;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void resetpassword(String newpassword){
        this.password = newpassword;
    }

    public void followUser(User userToFollow) {
        if (!this.equals(userToFollow)) {
            followedUsers.add(userToFollow);
            System.out.println(this.getUsername() + " is now following " + userToFollow.getUsername());
        } else {
            System.out.println("Cannot follow yourself.");
        }
        listfollowedusers();
    }

    public void followPerson(Person personToFollow) {
        followedPersons.add(personToFollow);
        System.out.println(this.getUsername() + " is now following " + personToFollow.getName());
        listfollowedperson();
    }

    public void listfollowedperson(){
        for (Person person : followedPersons){
            System.out.println(person.getName()+", " + person.getBioinfo());
        }
    }
    public void listfollowedusers(){
        for (User user : followedUsers){
            System.out.println(user.getUsername());
        }
    }
}
