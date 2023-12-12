package com.example.ice;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private final String password;
    private int xp;
    private List<Datamon> datamons = new ArrayList<>();
    private Datamon currentDatamon;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.currentDatamon = currentDatamon;
        this.datamons = datamons;
    }

    public Datamon getCurrentDatamon() {
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
