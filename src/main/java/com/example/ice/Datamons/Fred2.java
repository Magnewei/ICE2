package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Fred2 implements Datamon {

    private String name;
    private int hp;
    private String CreatureType;
    boolean beerdrunk = false;
    boolean winedrunk = false;
    boolean whiskeydrunk = false;
    private String move1Name = "Drik øl med far";
    private String move2Name = "Drik vin med far";
    private String move3Name = "Drik whiskey med far";
    private String move4Name = "Drunken uppercut";

    public Fred2(){
        this.name = "Fred2";
        this.hp = 30;
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
        int damage = 50;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        beerdrunk = true;
        return damage;

    }

    public int move2(Datamon target){
        int damage = 2;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        winedrunk = true;
        return damage;
    }

    public int move3(Datamon target){
        int damage = 11;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        whiskeydrunk = true;
        return damage;
    }

public int move4(Datamon target){
        int damage = 3;
        if(whiskeydrunk && winedrunk && beerdrunk){
            damage = 20;
        }
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
}

    @Override
    public String getMove1Name() {
        return move1Name;
    }

    @Override
    public String getMove2Name() {
        return move2Name;
    }

    @Override
    public String getMove3Name() {
        return move3Name;
    }

    @Override
    public String getMove4Name() {
        return move4Name;
    }



}