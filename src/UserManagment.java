import java.util.HashMap;
import java.util.Map;

public class UserManagment {
    private Map<String, User> users;

    public UserManagment() {
        this.users = new HashMap<>();
    }

    public void addUser(String username, String password, UserRole role) {
        User user = new User(username, password, role, false);
        users.put(username, user);
    }

    /*public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }*/

    public void banUser(String username ){
        if(users.containsKey(username)){
            users.get(username).setBanned(true);
        }
        else {
            System.out.println(username + " is not found.");
        }
    }

    public void unbanUser(String username ){
        if(users.containsKey(username)){
            users.get(username).setBanned(false);
        }
        else {
            System.out.println(username + " is not found.");
        }
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public User login(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                return user; // Successfully authenticated
            }
        }
        return null;
    }

    public void deleteuser(String username){
        if( users.containsKey(username)){
            User user = users.get(username);
            users.remove(username);
            System.out.println(username + "removed successfully");
        }
        else {
            System.out.println("there is no such user");
        }
    }

    public void printAllUsers() {
        System.out.println("All Users:");
        for (Map.Entry<String, User> entry : users.entrySet()) {
            String username = entry.getKey();
            User user = entry.getValue();
            System.out.println("Username: " + username + ", User password: " + user.getPassword() + ", role : " + user.getRole());
        }
    }

    public void editUser(String username, String newPassword, UserRole newRole) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            user.setPassword(newPassword);
            user.setRole(newRole);
            System.out.println("User " + username + " updated successfully.");
        } else {
            System.out.println("User does not exist.");
        }
    }

    public User finduser(String username){
        if(users.containsKey(username)){
            User user = users.get(username);
            return user;
        }
        return null;
    }


}
