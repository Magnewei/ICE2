package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Bobby implements Datamon {
    private String name;
    private int hp;
    private String CreatureType;


    public Bobby() {
        this.name = "Bobby";
        this.hp = 310;
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
    public int move1(Datamon target){
        String name = "Jeg kommer i morgen gutter";
        int damage = 2;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move2(Datamon target){
        String name = "Ej jeg kommer på torsdag gutter";
        int damage = 4;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move3(Datamon target){
        String name = "Bogstaveligt talt bare dyresex lmao";
        int damage = 10;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move4(Datamon target){
        String name = "Drop ud";
        setHP(0);
        int damage = 0;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public String introduction() {
        return "A giant monster apears from the dista..... oh wait its just tiny jonas";
    }
}
