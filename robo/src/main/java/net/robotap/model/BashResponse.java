package net.robotap.model;

public class BashResponse {
    String response;
    String command;
    String statusCode;

    public BashResponse(){

    }

    public BashResponse(String resp, String command, String statusCode){
        this.response = resp;
        this.command = command;
        this.statusCode = statusCode;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    
}
