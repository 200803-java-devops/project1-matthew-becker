package net.robotap.model;

public class Repo {
    private String id;
    private String url;
    private String owner;

    public Repo(){

    }

    public Repo(String url, String owner, String id){
        this.url = url;
        this.owner = owner;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String geturl() {
        return this.url;
    }

    public void seturl(String owner) {
        this.owner = owner;
    }

    public String getowner() {
        return this.owner;
    }

    public void setowner(String owner) {
        this.owner = owner;
    }

}