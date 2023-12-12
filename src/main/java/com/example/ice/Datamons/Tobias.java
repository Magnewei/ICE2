package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Tobias implements Datamon {
    private String name;
    private int hp;
    private int BaseDamage;
    private String CreatureType;


    public Tobias() {
        this.name = "Tobias";
        this.hp = 280;
        this.BaseDamage = 9;
        this.CreatureType = "YapMaster";
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

    public int move1(Datamon target){
         String name ="Byg reol 1";
         int damage = 0;
         return damage;
    }

    public int move2(Datamon target){
        String name ="Byg reol 2";
        int damage = 0;
        return damage;
    }

    public int move3(Datamon target){
        String name ="Byg reol 3";
        int damage = 0;
        return damage;
    }

    public int move4(Datamon target){
        String name ="Byg reol 4";
        int damage = 0;
        return damage;
    }
}
