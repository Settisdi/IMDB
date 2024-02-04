import java.util.*;

public class PersonDB {
    private List<Person> personList;
    //private Map<Person, List<String>> followersMap ; // userr

    public PersonDB(){
        personList = new ArrayList<>();
        //followersMap = new HashMap<>();
    }

    public void addPerson (Person person){
        personList.add(person);
    }

    public void ListPersons(){
        for (Person person : personList){
            System.out.println(person.getName()  ); /// show followers
        }
    }

    /*public void addFollower(Person person , String username){ ////////
        if (followersMap.getOrDefault(person, List.of()).contains(username)){
            System.out.println(username + " is already following " + person);
        }
        else {
            followersMap.computeIfAbsent(person, k -> new ArrayList<>()).add(username);
            System.out.println(username + " is now following " + person);
        }
    }*/

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    /*public Map<Person, List<String>> getFollowersMap() {
        return followersMap;
    }

    public void setFollowersMap(Map<Person, List<String>> followersMap) {
        this.followersMap = followersMap;
    }
*/
    public void deleteperson(String name){
        for ( Person person : personList){
            if (person.getName().equalsIgnoreCase(name)){
                personList.remove(person);
                System.out.println("person deleted successfully");
            }
        }

    }

    public Person findPerson(String personName){
        for(Person person : personList){
            if(person.getName().equalsIgnoreCase(personName)){
                return person;
            }
        }
        return null;
    }
    public void editperson(Person person , String part , String suggest){
        if(part.equalsIgnoreCase("name")){
            person.setName(suggest);
        } else if (part.equalsIgnoreCase("bioinfo")){
            person.setBioinfo(suggest);
        }else if (part.equalsIgnoreCase("birthdate")) {
            person.setBirthdate(suggest);
        } else {
            System.out.println("there is no such part");
        }
    }

    public Person getperson(String personname){
        for ( Person person : personList){
            if (person.getName().equalsIgnoreCase(personname)){
                return person;
            }
        }
        System.out.println("person doesn't exist");
        return null;
    }
}
