package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Mads implements Datamon {
    private String name;
    private int hp;
    private int BaseDamage;
    private String CreatureType;


    public Mads() {
        this.name = "Mads";
        this.hp = 280;
        this.BaseDamage = 9;
        this.CreatureType = "Bror";
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
        return "A giant monster apears from the dista..... oh wait its just tiny jonas";
    }
}


