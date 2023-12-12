package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Nicolai implements Datamon {
    private String name;
    private int hp;
    private int BaseDamage;
    private String CreatureType;


    public Nicolai() {
        this.name = "Nicolai";
        this.hp = 280;
        this.BaseDamage = 9;
        this.CreatureType = "Muren";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public void setHP(int hp) {
        this.hp = hp;
    }

    @Override
    public String getCreatureType() {
        return CreatureType;
    }

    @Override
    public String introduction() {
        return "A giant monster apears from the dista..... oh wait its just tiny jonas";
    }


    public int move1(Datamon target){
        String name ="Build that wall";
        int damage = 7;
        return damage;
    }

    public int move2(Datamon target){
        String name ="Murstens kast";
        int damage = 8;
        return damage;
    }

    public int move3(Datamon target){
        String name ="Cs flæk";
        int damage = 6;
        return damage;
    }

    public int move4(Datamon target){
        String name ="?";
        int damage = 2;
        return damage;
    }

}

