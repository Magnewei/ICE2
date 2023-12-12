package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Rouvi implements Datamon {
    private String name;
    private int hp;
    private int BaseDamage;
    private String CreatureType;


    public Rouvi() {
        this.name = "Rouvi";
        this.hp = 280;
        this.BaseDamage = 9;
        this.CreatureType = "?";
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
        String name ="Wingman";
        int damage = 6;
        return damage;
    }

    public int move2(Datamon target){
        String name ="Teemo";
        int damage = 5;
        return damage;
    }

    public int move3(Datamon target){
        String name ="Yappe";
        int damage = 9;
        return damage;
    }

    public int move4(Datamon target){
        String name ="Cs goat";
        int damage = 7;
        return damage;
    }

}

