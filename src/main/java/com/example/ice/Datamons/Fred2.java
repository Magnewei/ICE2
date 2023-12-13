package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Fred2 implements Datamon {

    private String name;
    private int hp;
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
        return  "";
    }



    public int move1(Datamon target){
        String name ="Drik øl med far";
        int damage = 10;
        return damage;

    }

    public int move2(Datamon target){
        String name = "Drik vin med far";
        int damage = 2;
        System.out.println(name);
        return damage;
    }

    public int move3(Datamon target){
        String name ="Drik whisky med far";
        int damage = 11;
        return damage;
    }

public int move4(Datamon target){
        String name = "Drunken uppercut";
        int damage = 11;
        return damage;
}


}