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
    public void setDatamons(List<Datamon> datamons, Datamon datamon) {
        this.datamons = datamons;
        this.currentDatamon = datamon;
    }

    public void setName(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public List<Datamon> getDatamons() {
        return datamons;
    }

    public Datamon getCurrentDatamon() {
        if (datamons != null && !datamons.isEmpty() ) {
            return datamons.get(0);
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



}
