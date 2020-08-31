package net.robotap.model;

public class Repo {
    private String httpsUrl;

    public Repo(){

    }

    public Repo(String httpUrl){
        this.httpsUrl = httpUrl;
    }

    public String getHttpsUrl() {
        return this.httpsUrl;
    }

    public void setHttpsUrl(String httpsUrl) {
        this.httpsUrl = httpsUrl;
    }

}