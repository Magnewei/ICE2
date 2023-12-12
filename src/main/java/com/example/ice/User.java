package com.example.ice;

import java.util.ArrayList;
import java.util.List;

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

    public void setCurrentDatamon(Datamon currentDatamon) {
        this.currentDatamon = currentDatamon;
    }

    public void setDatamons(List<Datamon> datamons) {
        this.datamons = datamons;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String username) {
        this.username = username;
    }

    public Datamon getCurrentDatamon() {
        if (datamons != null) {
            return datamons.get(0);
    }
        return currentDatamon;
    }

    public List<Datamon> getDatamons() {
        return datamons;
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



}
