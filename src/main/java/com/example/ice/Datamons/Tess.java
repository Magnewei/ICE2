package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Tess implements Datamon {

    private String name;
    private int hp;
    private int BaseDamage;
    private String CreatureType;

    public Tess(){
        this.name = "Tess";
        this.hp = 300;
        this.BaseDamage = 9;
        this.CreatureType = "Boss";
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
    public double DamageBuff(Datamon target) {
        return 0;
    }

    @Override
    public double takedamage(double damage) {
        return 0;
    }


    @Override
    public String introduction() {
        return  "";
    }
}
