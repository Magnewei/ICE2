package com.example.ice;

import java.util.Objects;

public class Fred2 implements Datamon{

    private String name;
    private int hp;
    private int BaseDamage;
    private String CreatureType;

    Fred2(){
        this.name = "Fred2";
        this.hp = 250;
        this.BaseDamage = 7;
        this.CreatureType = "Drunk";
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
    public int getBaseDamage() {
        return BaseDamage;
    }

    @Override
    public String getCreatureType() {
        return CreatureType;
    }

    @Override
    public int Damagebuff(Datamon target) {
        return 0;
    }

    @Override
    public int takedamage(int damage) {
        return hp-= damage;
    }

    @Override
    public String introduction() {
        return  "";
    }


}
