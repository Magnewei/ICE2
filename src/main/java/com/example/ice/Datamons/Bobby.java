package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Bobby implements Datamon {
    private String name;
    private int hp;
    private int BaseDamage;
    private String CreatureType;


    public Bobby() {
        this.name = "Bobby";
        this.hp = 310;
        this.BaseDamage = 7;
        this.CreatureType = "Ghost";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getHP() {
        return hp;
    }

    @Override
    public void setHP(int hp) {
        this.hp = hp;
    }

    @Override
    public double getBaseDamage() {
        return BaseDamage;
    }

    @Override
    public String getCreatureType() {
        return CreatureType;
    }

    @Override
    public int move1(Datamon target){
        String name = "Jeg kommer i morgen gutter";
        int damage = 2;
        return damage;
    }

    @Override
    public int move2(Datamon target){
        String name = "Ej jeg kommer på torsdag gutter";
        int damage = 4;
        return damage;
    }

    @Override
    public int move3(Datamon target){
        String name = "Bogstaveligt talt bare dyresex lmao";
        int damage = 10;
        return damage;
    }

    @Override
    public int move4(Datamon target){
        String name = "Drop ud";
        setHP(0);
        int damage = 0;
        return damage;
    }

    @Override
    public String introduction() {
        return "A giant monster apears from the dista..... oh wait its just tiny jonas";
    }
}
