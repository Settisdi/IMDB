import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MovieDB database = new MovieDB();
        Scanner scanner = new Scanner(System.in);
        PersonDB personDB = new PersonDB();
        ListManager listDB = new ListManager();
        UserManagment userManagement = new UserManagment();
        // Adding movies
        Movie movie1 = new Movie("Inception", "2012","cmplex movie !" , "English" , "Si Fi" , 0 ,null  , "" , false);
        Movie movie2 = new Movie("The Matrix" , "2008" , "matriiiix" , "English" , "drama" , 2,null , "", false);
        Movie movie3 = new Movie("hello" , "2008" , "hihi" , "French" , "drama" , 2,null , "", false);

        database.addMovie(movie1);
        database.addMovie(movie2);
        Person person1 = new Person("leo" , "1999" , "it's leonardo dicaprio") ;
        Person person2 = new Person("margo" , "2020" , "margo rohby") ;
        personDB.addPerson(person1);
        personDB.addPerson(person2);
        database.addpersontomovie("leo" , "actor" , "Inception");
        userManagement.addUser("user1", "password", UserRole.MEMBER);
        userManagement.addUser("member", "password", UserRole.MEMBER);
        userManagement.addUser("user2", "password", UserRole.ADMIN);
        userManagement.addUser("user3", "password" , UserRole.EDITOR);
        Review review00 = new Review("good", false , false ,userManagement.finduser("user1"));
        database.findmovie("Inception").addreview(review00);



        int sign= 0;
        do {
            String username = null;
            String password = null;
            System.out.println("Welcome to my imdb!");
            System.out.println("enter 1 for sign in enter 2 for sign up or enter 0 to exit:");
            sign = scanner.nextInt();
            scanner.nextLine();
            if (sign == 1) {
                System.out.println("please enter your username:");
                username = scanner.nextLine();
                System.out.println("please enter your password:");
                password = scanner.nextLine();
            } else if (sign == 2) {
                System.out.println("enter your desired username:");
                username = scanner.nextLine();
                System.out.println("enter your desired passwored:");
                password = scanner.nextLine();
                userManagement.addUser(username, password, UserRole.MEMBER);
            }


            User loggedInUser = userManagement.login(username, password);

            if (loggedInUser != null) {
                if (!loggedInUser.isBanned()) {
                    System.out.println("Login successful! Welcome, " + loggedInUser.getUsername());

                    if (loggedInUser.getRole() == UserRole.ADMIN) {
                        System.out.println("1. add movie");
                        System.out.println("2. delete movie");
                        System.out.println("3. add an actor,director,...");
                        System.out.println("4. add a person to movie");
                        System.out.println("5. add review");
                        System.out.println("6. add user");
                        System.out.println("7. delete review ");
                        System.out.println("8. delete user");
                        System.out.println("9. delete person ");
                        System.out.println("10. show users");
                        System.out.println("11. edit users");
                        System.out.println("12. ban a user");
                        System.out.println("13. unban user");
                        System.out.println("14. review offensive movie list");
                        System.out.println("15. show edit suggestions for movie");
                        System.out.println("16. show edit suggestions for person");
                        System.out.println("17. edit movie");
                        System.out.println("18. edit person");
                        //System.out.println("19. show following users status");
                        //System.out.println("20. show following persons status");
                        System.out.println("21. logout");
                        int choiceadmin;
                        do {
                            System.out.println("Enter choice :");
                            choiceadmin = scanner.nextInt();
                            switch (choiceadmin) {
                                case 1:
                                    scanner.nextLine();
                                    System.out.println("Enter movie title: ");
                                    String Title = scanner.nextLine();
                                    System.out.println("Enter movie release date:");
                                    String date = scanner.nextLine();
                                    System.out.println("Enter Plot summery");
                                    String plotsummery = scanner.nextLine();
                                    System.out.println("Enter movie language: ");
                                    String language = scanner.nextLine();
                                    System.out.println("Enter movie genre: ");
                                    String genre = scanner.nextLine();
                                    Movie movien = new Movie(Title, date, plotsummery, language, genre, 0, null, "" , false);
                                    database.addMovie(movien);
                                    break;
                                case 2:
                                    scanner.nextLine();
                                    System.out.println("Enter movie title: ");
                                    String tItle = scanner.nextLine();
                                    database.deleteMovie(tItle);
                                    break;
                                case 3:
                                    scanner.nextLine();
                                    System.out.println("Enter your person info:");
                                    System.out.println("name : ");
                                    String name = scanner.nextLine();
                                    System.out.println("birthdate:");
                                    String birthdate = scanner.nextLine();
                                    System.out.println("bio info: ");
                                    String bioinfo = scanner.nextLine();
                                    Person personn = new Person(name, birthdate, bioinfo);
                                    personDB.addPerson(personn);
                                    System.out.println("persons:");
                                    personDB.ListPersons();
                                    break;
                                case 4:
                                    scanner.nextLine();
                                    System.out.println("Enter person name: ");
                                    String namee = scanner.nextLine();
                                    System.out.println("Enter movie title :");
                                    String movietitle = scanner.nextLine();
                                    System.out.println("Enter person role in movie:");
                                    String role = scanner.nextLine();
                                    database.addpersontomovie(namee, role, movietitle);
                                    break;
                                case 5:
                                    scanner.nextLine();
                                    System.out.println("Enter movie title");
                                    String movieti = scanner.nextLine();
                                    System.out.println("Enter your opinion about this movie");
                                    String text = scanner.nextLine();
                                    System.out.println("Enter true if it has spoiler content otherwise false:");
                                    boolean spoiler = scanner.nextBoolean();
                                    System.out.println("Enter true if it is a helpful content for others otherwise false:");
                                    boolean helpful = scanner.nextBoolean();
                                    Review review = new Review(text, spoiler, helpful, userManagement.finduser(username));
                                    database.findmovie(movieti).addreview(review);
                                    database.findmovie(movieti).showreviews();
                                    break;
                                case 6:
                                    scanner.nextLine();
                                    System.out.println("enter username:");
                                    String username1 = scanner.nextLine();
                                    System.out.println("enter password:");
                                    String password1 = scanner.nextLine();
                                    System.out.println("enter user role (admin or member or editor):");
                                    String role1 = scanner.nextLine();
                                    if (role1.equals("admin")) {
                                        userManagement.addUser(username1, password1, UserRole.ADMIN);
                                    } else if (role1.equals("member")) {
                                        userManagement.addUser(username1, password1, UserRole.MEMBER);
                                    } else if (role1.equals("editor")) {
                                        userManagement.addUser(username1, password1, UserRole.EDITOR);
                                    } else {
                                        System.out.println("you enter a wrong role!");
                                        break;
                                    }
                                    break;
                                case 7:
                                    scanner.nextLine();
                                    System.out.println("enter movie title of review :");
                                    String moviemovie = scanner.nextLine();
                                    System.out.println("enter username of the review :");
                                    String userreview = scanner.nextLine();
                                    database.findmovie(moviemovie).removerevies(database.findmovie(moviemovie).findreview(userManagement.finduser(userreview)));
                                    break;
                                case 8:
                                    scanner.nextLine();
                                    System.out.println("enter username:");
                                    String username2 = scanner.nextLine();
                                    userManagement.deleteuser(username2);
                                    break;
                                case 9:
                                    scanner.nextLine();
                                    System.out.println("enter person name :");
                                    String personname = scanner.nextLine();
                                    personDB.deleteperson(personname);
                                    break;
                                case 10:
                                    scanner.nextLine();
                                    userManagement.printAllUsers();
                                    break;
                                case 11:
                                    scanner.nextLine();
                                    System.out.println("enter username :");
                                    String usernamee = scanner.nextLine();
                                    System.out.println("enter new password:");
                                    String pass = scanner.nextLine();
                                    System.out.println("enter new role:");
                                    String newrole = scanner.nextLine();
                                    if (newrole.equalsIgnoreCase("admin")) {
                                        userManagement.editUser(usernamee, pass, UserRole.ADMIN);
                                    } else if (newrole.equalsIgnoreCase("member")) {
                                        userManagement.editUser(usernamee, pass, UserRole.MEMBER);
                                    } else if (newrole.equalsIgnoreCase("editor")) {
                                        userManagement.editUser(usernamee, pass, UserRole.EDITOR);
                                    } else {
                                        System.out.println("invalid role");
                                    }
                                    break;
                                case 15:
                                    scanner.nextLine();
                                    System.out.println("enter movie suggests that want to see:");
                                    String moviesuggest = scanner.nextLine();
                                    database.findmovie(moviesuggest).showsuggests();
                                    System.out.println("enter movie suggest number:");
                                    int n = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("enter true for approve edit otherwise false:");
                                    boolean approve = scanner.nextBoolean();
                                    if (database.findmovie(moviesuggest).getSuggests()!= null) {
                                        if (approve) {
                                            database.editmovie(database.findmovie(moviesuggest), database.findmovie(moviesuggest).getSuggests().get(n).getPart().toLowerCase(), database.findmovie(moviesuggest).getSuggests().get(n).getSuggest() );
                                            database.findmovie(moviesuggest).getSuggests().get(n).setApproved(true);
                                        }
                                    }
                                    else {
                                        System.out.println("there is no suggests");
                                    }
                                    break;
                                case 12:
                                    scanner.nextLine();
                                    System.out.println("enter username:");
                                    String usernameban = scanner.nextLine();
                                    userManagement.banUser(usernameban);
                                    break;
                                case 13:
                                    scanner.nextLine();
                                    System.out.println("enter username:");
                                    String userunban = scanner.nextLine();
                                    userManagement.unbanUser(userunban);
                                    break;
                                case 14:
                                    scanner.nextLine();
                                    database.listoffensivemovies();
                                    int select = 0;
                                    do {
                                        System.out.println("enter 1 to delete a movie 0 to exit");
                                        select = scanner.nextInt();
                                        scanner.nextLine();
                                        if (select == 1){
                                            System.out.println("enter movie title:");
                                            String offensivemov = scanner.nextLine();
                                            database.deleteMovie(offensivemov);
                                        }
                                    }while (select != 0);
                                    break;
                                case 16:
                                    scanner.nextLine();
                                    System.out.println("enter person name suggests that want to see:");
                                    String personsuggest = scanner.nextLine();
                                    personDB.findPerson(personsuggest).showSuggest();
                                    System.out.println("enter person suggest number:");
                                    int m = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("enter true for approve edit otherwise false:");
                                    boolean approved = scanner.nextBoolean();
                                    if(personDB.findPerson(personsuggest).getSuggests()!= null){
                                        if(approved){
                                            personDB.editperson(personDB.findPerson(personsuggest) , personDB.findPerson(personsuggest).getSuggests().get(m).getPart().toLowerCase() , personDB.findPerson(personsuggest).getSuggests().get(m).getSuggest());
                                            personDB.findPerson(personsuggest).getSuggests().get(m).setApproved(true);
                                        }
                                    }
                                case 17 :
                                    scanner.nextLine();
                                    System.out.println("enter movie title :");
                                    String editmovie= scanner.nextLine();
                                    System.out.println("enter movie part to edit(title , language , releasedate , plotsummery , genre)");
                                    String partMovie = scanner.nextLine();
                                    System.out.println("enter your edit");
                                    String edit = scanner.nextLine();
                                    database.editmovie(database.findmovie(editmovie) , partMovie.toLowerCase() , edit);
                                    break;
                                case 18 :
                                    scanner.nextLine();
                                    System.out.println("enter person name");
                                    String editperson = scanner.nextLine();
                                    System.out.println("enter person part to edit( name , birthdate , bioinfo)");
                                    String partperson = scanner.nextLine();
                                    System.out.println("enter your edit");
                                    String edits = scanner.nextLine();
                                    personDB.editperson(personDB.findPerson(editperson) , partperson , edits);
                                    break;
                                /*case 19:
                                    scanner.nextLine();
                                    System.out.println("enter username:");
                                    String followingUsername = scanner.nextLine();
                                    if(userManagement.finduser(followingUsername) != null && userManagement.finduser(username).getFollowedUsers().contains(userManagement.finduser(followingUsername))){
                                    }
                                    // if it was existed and in her followings
                                    //show lists of person
                                    //show his review and ratings

                                    break;
                                case 20 :
                                    scanner.nextLine();
                                    System.out.println("enter person name:");
                                    String followingPerson = scanner.nextLine();
                                    if(personDB.findPerson(followingPerson)!= null && userManagement.finduser(username).getFollowedPersons().contains(personDB.findPerson(followingPerson))){

                                    }
                                    break;*/
                                case 21:
                                    break;
                                default:
                                    System.out.println("invalid choice");
                            }
                        }while (choiceadmin != 21);


                    } else if (loggedInUser.getRole() == UserRole.MEMBER) {
                        // Perform member actions
                        int choice;
                        System.out.println("1. List movies with their rating");
                        System.out.println("2. rate movie");
                        System.out.println("3. show categorized movies");
                        System.out.println("4. personal lists");
                        System.out.println("5. add review to movie");
                        System.out.println("6. show reviews");
                        System.out.println("7. rest password");
                        System.out.println("8. edit personal info");
                        System.out.println("9. follow other members");
                        System.out.println("10. follow actors,directors,...");
                        System.out.println("11. show followings");
                        System.out.println("12. add Contribute trivia");
                        System.out.println("13. show movie page");
                        System.out.println("14. report offensive content");
                        System.out.println("15. repost an review");
                        System.out.println("16. like a review");
                        System.out.println("17. add comment");
                        // like comment
                        System.out.println("18. logout");
                        do {
                            System.out.print("Enter choice: ");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    database.listMovies();
                                    break;
                                case 2:
                                    scanner.nextLine(); // Consume newline
                                    System.out.print("Enter movie title: ");
                                    String title = scanner.nextLine();
                                    System.out.print("Enter rating: ");
                                    double rating = scanner.nextDouble();
                                    database.rateMovie(title, rating);
                                    break;
                                case 3:
                                    scanner.nextLine();
                                    System.out.println("choose you way to categorize");
                                    System.out.println("1.genre  2. language  3.release year  4.actor,director...");
                                    int by = scanner.nextInt();
                                    scanner.nextLine();
                                    if (by == 1) {
                                        System.out.println("Enter your desire genre: ");
                                        String gen = scanner.nextLine();
                                        database.listMoviesByGenre(gen);
                                        break;
                                    } else if (by == 2) {
                                        System.out.println("Enter your desire language: ");
                                        String lan = scanner.nextLine();
                                        database.listMoviesByLanguage(lan);
                                        break;
                                    } else if (by == 3) {
                                        System.out.println("Enter your desire release date: ");
                                        String daterelease = scanner.nextLine();
                                        database.listMoviesByReleaseDate(daterelease);
                                        break;
                                    } else if (by == 4) {
                                        System.out.println("Enter your desire Person: ");
                                        String actor = scanner.nextLine();
                                        database.listMoviesByPerson(actor);
                                        break;
                                    } else {
                                        System.out.println("invalid number");
                                        break;
                                    }
                                case 4:
                                    scanner.nextLine();
                                    System.out.println("choose what you wanna do with your lists:");
                                    System.out.println("1.show my list  2.add movie to existed list or new list  3. remove a movie from list  4. remove a personal list");
                                    int which = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (which) {
                                        case 1:
                                            scanner.nextLine();
                                            System.out.println("Enter list name :");
                                            String lisstname = scanner.nextLine();
                                            listDB.printlist(lisstname);
                                            break;
                                        case 2:
                                            scanner.nextLine();
                                            System.out.println("Enter list name:");
                                            String listname = scanner.nextLine();
                                            System.out.println("Enter movie name ");
                                            String movieetitle = scanner.nextLine();
                                            listDB.addMovieToList(database.findmovie(movieetitle), listname , userManagement.finduser(username));
                                            listDB.printlist(listname);
                                            break;
                                        case 3:
                                            scanner.nextLine();
                                            System.out.println("Enter list name :");
                                            String liistname = scanner.nextLine();
                                            System.out.println("Enter movie name : ");
                                            String moviet = scanner.nextLine();
                                            listDB.removemoviefromlist(database.findmovie(moviet), liistname);
                                            listDB.printlist(liistname);
                                            break;
                                        case 4:
                                            scanner.nextLine();
                                            System.out.println("Enter list name : ");
                                            String list = scanner.nextLine();
                                            listDB.deleteList(list , userManagement.finduser(username));
                                            System.out.println("list deleted successfully");
                                            break;
                                        default:
                                            System.out.println("invalid choice");
                                    }
                                    break;
                                case 5:
                                    scanner.nextLine();
                                    System.out.println("Enter movie title");
                                    String movieti = scanner.nextLine();
                                    System.out.println("Enter your opinion about this movie");
                                    String text = scanner.nextLine();
                                    System.out.println("Enter true if it has spoiler content otherwise false:");
                                    boolean spoiler = scanner.nextBoolean();
                                    System.out.println("Enter true if it is a helpful content for others otherwise false:");
                                    boolean helpful = scanner.nextBoolean();
                                    Review review = new Review(text, spoiler, helpful , userManagement.finduser(username));
                                    database.findmovie(movieti).addreview(review);
                                    database.findmovie(movieti).showreviews();
                                    break;
                                case 6:
                                    scanner.nextLine();
                                    System.out.println("Enter movie title");
                                    String movietitlE = scanner.nextLine();
                                    database.findmovie(movietitlE).showreviews();
                                    break;
                                case 7:
                                    scanner.nextLine();
                                    System.out.println("enter your new password:");
                                    String newpassword = scanner.nextLine();
                                    userManagement.getUser(username).resetpassword(newpassword);
                                    break;
                                case 8:
                                    scanner.nextLine();
                                    System.out.println("enter your username :");
                                    String yourusername = scanner.nextLine();
                                    System.out.println("enter your new password :");
                                    String newpasswordd = scanner.nextLine();
                                    userManagement.editUser(yourusername, newpasswordd, UserRole.MEMBER);
                                    break;
                                case 9:
                                    scanner.nextLine();
                                    System.out.println("enter username :");
                                    String usertofollow = scanner.nextLine();
                                    userManagement.getUser(username).followUser(userManagement.getUser(usertofollow));
                                    break;
                                case 10:
                                    scanner.nextLine();
                                    System.out.println("enter person name:");
                                    String persontofollow = scanner.nextLine();
                                    userManagement.getUser(username).followPerson(personDB.getperson(persontofollow));
                                    break;
                                case 11:
                                    scanner.nextLine();
                                    System.out.println("persons:");
                                    userManagement.getUser(username).listfollowedperson();
                                    System.out.println("users:");
                                    userManagement.getUser(username).listfollowedusers();
                                    break;
                                case 12:
                                    scanner.nextLine();
                                    System.out.println("Enter movie title:");
                                    String moviename = scanner.nextLine();
                                    System.out.println("enter your added details:");
                                    String detail = scanner.nextLine();
                                    database.adddetail(detail, database.findmovie(moviename));
                                    break;
                                case 13:
                                    scanner.nextLine();
                                    System.out.println("enter movie title :");
                                    String movien = scanner.nextLine();
                                    database.showmoviepage(database.findmovie(movien));
                                    System.out.println("casts:");
                                    database.findmovie(movien).getActors();
                                    for (Map.Entry<Person, String> entry : database.findmovie(movien).getActors().entrySet()) {
                                        System.out.println(entry.getKey().getName() + " : " + entry.getValue());
                                    }
                                    System.out.println("reviews:");
                                    database.findmovie(movien).showreviews();
                                    break;
                                case 14:
                                    scanner.nextLine();
                                    System.out.println("enter movie title:");
                                    String offensivemovie = scanner.nextLine();
                                    database.offensivemovie(database.findmovie(offensivemovie));
                                    break;
                                case 15:
                                    scanner.nextLine();
                                    System.out.println("enter movie title:");
                                    String rpostmovie = scanner.nextLine();
                                    System.out.println("enter review username:");
                                    String userreview = scanner.nextLine();
                                    Review review1 = database.findmovie(rpostmovie).findreview(userManagement.finduser(userreview));
                                    Review review0 = new Review(review1.getText() , review1.isSpoilers() , review1.isHelpful() , userManagement.getUser(username));
                                    database.findmovie(rpostmovie).addreview(review0);
                                    database.findmovie(rpostmovie).showreviews();
                                    break;
                                case 16:
                                    scanner.nextLine();
                                    System.out.println("enter movie title:");
                                    String likemovie = scanner.nextLine();
                                    System.out.println("enter review username :");
                                    String userlike = scanner.nextLine();
                                    database.findmovie(likemovie).findreview(userManagement.finduser(userlike)).addLikes();
                                    database.findmovie(likemovie).showreviews();
                                    break;
                                case 17:
                                    scanner.nextLine();
                                    System.out.println("enter movie title");
                                    String movietitle = scanner.nextLine();
                                    System.out.println("enter  review user:");
                                    String userrevieww = scanner.nextLine();
                                    System.out.println("enter your comment text:");
                                    String commenettext = scanner.nextLine();
                                    Comment comment1 = new Comment(userManagement.finduser(userrevieww) , commenettext );
                                    database.findmovie(movietitle).findreview(userManagement.finduser(userrevieww)).addcomment(comment1);
                                    database.findmovie(movietitle).showreviews();
                                    break;
                                case 18:
                                    break;
                                default:
                                    System.out.println("invalid choice");
                            }
                        } while (choice != 18);
                    } else if (loggedInUser.getRole() == UserRole.EDITOR) {
                        int choice;
                        System.out.println("1. add person ");
                        System.out.println("2. add movie");
                        System.out.println("3. add detial to movie");
                        System.out.println("4. report offensive movie");
                        System.out.println("5. suggest edit for movie");
                        System.out.println("6. suggest edit for person");
                        System.out.println("7. logout");
                        do {
                            System.out.println("enter choice :");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    scanner.nextLine();
                                    System.out.println("Enter your person info:");
                                    System.out.println("name : ");
                                    String name = scanner.nextLine();
                                    System.out.println("birthdate:");
                                    String birthdate = scanner.nextLine();
                                    System.out.println("bio info: ");
                                    String bioinfo = scanner.nextLine();
                                    Person personn = new Person(name, birthdate, bioinfo);
                                    personDB.addPerson(personn);
                                    System.out.println("persons:");
                                    personDB.ListPersons();
                                    break;
                                case 2:
                                    scanner.nextLine();
                                    System.out.println("Enter movie title: ");
                                    String Title = scanner.nextLine();
                                    System.out.println("Enter movie release date:");
                                    String date = scanner.nextLine();
                                    System.out.println("Enter Plot summery");
                                    String plotsummery = scanner.nextLine();
                                    System.out.println("Enter movie language: ");
                                    String language = scanner.nextLine();
                                    System.out.println("Enter movie genre: ");
                                    String genre = scanner.nextLine();
                                    Movie movien = new Movie(Title, date, plotsummery, language, genre, 0, null, "" ,false);
                                    database.addMovie(movien);
                                    break;
                                case 5:
                                    scanner.nextLine();
                                    System.out.println("enter movie title:");
                                    String editmovie = scanner.nextLine();
                                    System.out.println("enter 1.edit title  2.edit release date  3. plot summery  4. genre  5. language");
                                    int editpart =scanner.nextInt();
                                    scanner.nextLine();
                                    if(editpart == 1){
                                        System.out.println("enter your suggest");
                                        String suggest = scanner.nextLine();
                                        database.findmovie(editmovie).addsuggest("title" , suggest , false );
                                    }
                                    else if (editpart == 2){
                                        System.out.println("enter your suggest");
                                        String suggest = scanner.nextLine();
                                        database.findmovie(editmovie).addsuggest("releasedate" ,suggest , false);
                                    }
                                    else if (editpart == 3){
                                        System.out.println("enter your suggest");
                                        String suggest = scanner.nextLine();
                                        database.findmovie(editmovie).addsuggest("plotsummery" ,suggest , false );
                                    }
                                    else if(editpart == 4){
                                        System.out.println("enter your suggest");
                                        String suggest = scanner.nextLine();
                                        database.findmovie(editmovie).addsuggest("genre" ,suggest , false );
                                    }
                                    else if (editpart == 5){
                                        System.out.println("enter your suggest");
                                        String suggest = scanner.nextLine();
                                        database.findmovie(editmovie).addsuggest("language" ,suggest , false );
                                    }
                                    else {
                                        System.out.println("entered wrong number");
                                    }
                                    System.out.println("your suggest has been sent ");
                                    break;
                                case 3:
                                    scanner.nextLine();
                                    System.out.println("Enter movie title:");
                                    String moviename = scanner.nextLine();
                                    System.out.println("enter your added details:");
                                    String detail = scanner.nextLine();
                                    database.adddetail(detail, database.findmovie(moviename));
                                    break;
                                case 4:
                                    System.out.println("enter movie title:");
                                    String offensivemovie = scanner.nextLine();
                                    database.offensivemovie(database.findmovie(offensivemovie));
                                    break;
                                case 6:
                                    System.out.println("enter person name:");
                                    String editPersonName= scanner.nextLine();
                                    System.out.println("enter 1.edit name 2. edit bioinfo 3. edit birth date");
                                    int option = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("enter your suggest");
                                    String suggest = scanner.nextLine();
                                    if(option == 1){
                                        personDB.findPerson(editPersonName).addsuggest("name" , suggest , false);
                                    }
                                    else if ( option ==2){
                                        personDB.findPerson(editPersonName).addsuggest("bioibfo" , suggest , false);
                                    }
                                    else if ( option == 3){
                                        personDB.findPerson(editPersonName).addsuggest("birthdate" , suggest , false);
                                    }
                                    else {
                                        System.out.println("entered wrong number");
                                    }
                                    break;
                                case 7:
                                    break;
                                default:
                                    System.out.println("invalid choice");
                            }

                        } while (choice != 7);

                    }
                } else {
                    System.out.println("you are banned by admin");
                }
            } else {
                if (sign != 0 )
                    System.out.println("Invalid username or password. Please try again.");
            }
        }while (sign != 0);
        scanner.close();
    }
}

