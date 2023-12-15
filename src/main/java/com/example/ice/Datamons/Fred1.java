package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Fred1 implements Datamon{
    private String name;
    private int hp;
    private String CreatureType;
    private String move1Name = "Forvir med kompleks matematik";
    private String move2Name = "Spil Gwen";
    private String move3Name = "Spil literally alt andet end Gwen";
    private String move4Name = "Jeg gider ikke være Tauren!";

    public Fred1() {
        this.name = "Fred1";
        this.hp= 200;
        this.CreatureType = "StudieGruppeF";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 200;
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
    public int move1(Datamon target) {
        int damage = 30;
        System.out.println("Angreb: " + move1Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move2(Datamon target) {
        int damage = 5;
        System.out.println("Angreb: " + move2Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move3(Datamon target) {
        int damage = -20;
        System.out.println("Angreb: " + move3Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move4(Datamon target) {
        int damage = 0;
        System.out.println("Angreb: " + move4Name + " Dealt : " + damage + " To " + target.getName());
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

    @Override
    public String introduction() {
        return null;
    }
}
