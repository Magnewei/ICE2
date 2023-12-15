package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Rouvi implements Datamon {
    private String name;
    private int hp;
    private String CreatureType;

    private String move1Name = "Wingman";
    private String move2Name = "Teemo";
    private String move3Name = "Yappe";
    private String move4Name = "CS goat";


    public Rouvi() {
        this.name = "Rouvi";
        this.hp = 280;
        this.CreatureType = "?";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 280;
        return (double) (maxHealth - hp) / maxHealth;
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
        return "A giant monster apears from the dista..... oh wait its just tiny jonas";
    }


    public int move1(Datamon target){
        String name ="Wingman";
        int damage = 6;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move2(Datamon target){
        String name ="Teemo";
        int damage = 5;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move3(Datamon target){
        String name ="Yappe";
        int damage = 9;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move4(Datamon target){
        String name ="Cs goat";
        int damage = 7;
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

