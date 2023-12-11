package com.example.ice;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private final String password;
    private int xp;
    private List<Datamon> datamons = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;


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
