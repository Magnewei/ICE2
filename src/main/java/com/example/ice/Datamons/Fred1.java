package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Fred1 implements Datamon{
    private String name;
    private int hp;
    private String CreatureType;

    public Fred1() {
        this.name = "Bobby";
        this.hp= 200;
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
    public int move1(Datamon target) {
        String name = "Forvir med kompleks matematik";
        int damage = 30;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move2(Datamon target) {
        String name = "Spil Gwen";
        int damage = 5;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move3(Datamon target) {
        String name = "Spil literally alt andet end Gwen";
        int damage = -20;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move4(Datamon target) {
        String name = "";
        int damage = 0;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public String introduction() {
        return null;
    }
}
