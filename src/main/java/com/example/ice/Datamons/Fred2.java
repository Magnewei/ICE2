package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Fred2 implements Datamon {

    private String name;
    private double hp;
    private int BaseDamage;
    private String CreatureType;

    public Fred2(){
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
    public double Damagebuff(Datamon target) {
        return 0;
    }

    @Override
    public double takedamage(double damage) {
        return hp-= damage;
    }

    @Override
    public String introduction() {
        return  "";
    }

    public void oelKastMedFar(Datamon target){
        double damageDealt = 1.5*getBaseDamage();
        target.takedamage(damageDealt);
    }

}