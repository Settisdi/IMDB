import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name ;
    private String birthdate;
    private String bioinfo ;
    private List<EditPersonSuggest> suggests = new ArrayList<>();

    public Person(String name, String birthdate, String bioinfo) {
        this.name = name;
        this.birthdate = birthdate;
        this.bioinfo = bioinfo;
    }

    public List<EditPersonSuggest> getSuggests() {
        return suggests;
    }

    public void setSuggests(List<EditPersonSuggest> suggests) {
        this.suggests = suggests;
    }

    public void addsuggest(String part , String suggest , boolean status){
        EditPersonSuggest personSuggest = new EditPersonSuggest(part , suggest , status);
        suggests.add(personSuggest);
        System.out.println("suggest has been sent");
    }

    public void showSuggest(){
        int n=0;
        for(EditPersonSuggest editPersonSuggest : suggests){
            System.out.println(n +": "+ getName()+ " ,"+ editPersonSuggest.getPart()+" : "+ editPersonSuggest.getSuggest());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBioinfo() {
        return bioinfo;
    }

    public void setBioinfo(String bioinfo) {
        this.bioinfo = bioinfo;
    }
}
