package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Fred1 implements Datamon{
    private String name;
    private int hp;
    private String CreatureType;

    public Fred1() {
        this.name = "Bobby";
        this.hp= 200;
        this.CreatureType = "Ghost";
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
    public int move1(Datamon target) {
        String name = "Forvir med kompleks matematik";
        int damage = 30;
        return damage;
    }

    @Override
    public int move2(Datamon Target) {
        String name = "Spil Gwen";
        int damage = 5;
        return damage;
    }

    @Override
    public int move3(Datamon Target) {
        String name = "Spil literally alt andet end Gwen";
        int damage = -20;
        return damage;
    }

    @Override
    public int move4(Datamon Target) {
        String name = "";
        int damage = 0;
        return damage;
    }

    @Override
    public String introduction() {
        return null;
    }
}
