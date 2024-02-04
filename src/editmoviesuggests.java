public class editmoviesuggests {
    private String part;
    private String suggest;
    private boolean approved ;

    public editmoviesuggests( String part, String suggest, boolean approved ) {
        this.part = part;
        this.suggest = suggest;
        this.approved = approved;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
