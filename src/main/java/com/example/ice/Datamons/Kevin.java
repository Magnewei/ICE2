package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Kevin implements Datamon {
    private String name;
    private int hp;
    private String CreatureType;
    private String move1Name = "Kast Jordbær";
    private String move2Name = "Absorber sjæl";
    private String move3Name = "Rødhåret blodrus";
    private String move4Name = "Blændende maveskind";

    public Kevin(){
        this.name = "Kevin";
        this.hp = 100;
        this.CreatureType = "Ginger";
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
        return "A soulless Datamon appears, and it has.... red hair?";
    }

    public int move1(Datamon target){
        int damage = 7;
        System.out.println("Angreb: " + move1Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move2(Datamon target){
        int damage = 11;
        System.out.println("Angreb: " + move2Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move3(Datamon target){
        int damage = 8;
        System.out.println("Angreb: " + move3Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move4(Datamon target){
        int damage = 5;
        System.out.println("Angreb: " + move4Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 100;
        return (double) (maxHealth - hp) / maxHealth;
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