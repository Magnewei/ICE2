package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Marcus implements Datamon {
    private String name;
    private int hp;
    private String CreatureType;
    boolean opgave1Done = false;
    boolean opgave2Done = false;
    boolean opgave3Done = false;
    private String move1Name = "Lav opgave 1";
    private String move2Name = "Lav opgave 2";
    private String move3Name = "Lav opgave 3";
    private String move4Name = "Opgaver done, I'm gone";


    public Marcus() {
        this.name = "Marcus";
        this.hp = 280;
        this.CreatureType = "Speedy";
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
        int damage = 2;
        opgave1Done = true;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move2(Datamon target){
        String name ="Lav opgave 2";
        int damage = 2;
        opgave2Done = true;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move3(Datamon target){
        String name ="Lav opgave 3";
        int damage = 2;
        opgave3Done = true;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move4(Datamon target){
        String name ="Opgaver done? I'm gone";
        int damage = 2;
        if(opgave1Done && opgave2Done && opgave3Done){
            damage = 1000;
            setHP(0);
            opgave1Done = false;
            opgave2Done = false;
            opgave3Done = false;
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

