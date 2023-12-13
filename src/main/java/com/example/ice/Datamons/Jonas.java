package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Jonas implements Datamon {
    private String name;
    private double hp;
    private String CreatureType;


    public Jonas(){
        this.name = "Jonas";
        this.hp = 50;
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
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move2(Datamon target) {
        String name = "Skift navn på discord";
        int damage = 2;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move3(Datamon target) {
        String name = "Sig vi skal game senere, men glem at dukke op";
        int damage = 10;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move4(Datamon target) {
        String name = "HULK SMASH";
        double damage = hp/10;
        if(hp > 200){
            damage *= 5;
        }
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return (int)damage;
    }


}