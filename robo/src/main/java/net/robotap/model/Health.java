package net.robotap.model;

public class Health {

    private String stats;

    public Health(){

    }

    public Health(String stats){
        this.stats = stats;
    }

    public String getStats() {
        return this.stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }
    
}
