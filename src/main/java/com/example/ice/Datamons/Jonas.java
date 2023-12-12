package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Jonas implements Datamon {
    private String name;
    private double hp;
    private int BaseDamage;
    private String CreatureType;


    public Jonas(){
        this.name = "Jonas";
        this.hp = 50;
        this.BaseDamage = 3;
        this.CreatureType = "ElsketLøve";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHP() {
        return (int)hp;
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
        return "A giant monster apears from the dista..... oh wait its just tiny Jonas";
    }


    public int move1(Datamon target){
        String name = "Bulk up";
        setHP((int)hp + 50);
        int damage = 0;
        return damage;
    }

    @Override
    public int move2(Datamon Target) {
        String name = "Skift navn på discord";
        int damage = 2;
        return damage;
    }

    @Override
    public int move3(Datamon Target) {
        String name = "Sig vi skal game senere, men glem at dukke op";
        int damage = 10;
        return damage;
    }

    @Override
    public int move4(Datamon Target) {
        String name = "HULK SMASH";
        double damage = hp/10;
        if(hp > 200){
            damage *= 5;
        }
        return (int)damage;
    }


}