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
    public String introduction() {
        return "A giant monster apears from the dista..... oh wait its just tiny jonas";
    }
}

