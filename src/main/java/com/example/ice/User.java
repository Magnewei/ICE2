package com.example.ice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class User {
    private String username;
    private String password;
    private int xp;
    private List<Datamon> datamons = new ArrayList<>();
    private Datamon currentDatamon;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
    public User() {

    }

    public List<Datamon> getDatamons() {
        return datamons;
    }

    public Datamon getCurrentDatamon() {
        if (datamons != null && !datamons.isEmpty() ) {
            Random random = new Random();
            return datamons.get(random.nextInt(getDatamons().size()));
    }
        return currentDatamon;
    }
    public void addDatamon(Datamon mon){
        datamons.add(mon);
    }
    public void removeDatamon(Datamon mon){
        datamons.remove(mon);
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setCurrentDatamon(Datamon datamon){
        this.currentDatamon = datamon;
    }

}
