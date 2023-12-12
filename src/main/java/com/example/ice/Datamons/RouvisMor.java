package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class RouvisMor implements Datamon {

    private String name;
    private double hp;
    private int BaseDamage;
    private String CreatureType;

    public RouvisMor(){
        this.name = "Henriette";
        this.hp = 300;
        this.BaseDamage = 10;
        this.CreatureType = "Milf";
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getHP() {
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
        return "A hot milf appears in the wild. Her soul is kind, and her smile light up the world";
    }

    public int move1(Datamon target){
        String name = "Teen Seduction";
        int damage = 7;
        if("Ginger".equals(target.getCreatureType())){
            damage *= 2;
        }
        return damage;
    }

    public int move2(Datamon target){
        String name = "Bitch Slap";
        int damage = 6;
        return damage;
    }

    public int move3(Datamon target){
        String name = "Blowing kisses";
        int damage = 1;
        if("Ginger".equals(target.getCreatureType())){
            damage = 100;
        }
        return damage;

    }

    public int move4(Datamon target){
        String name ="Life advice";
        int damage = 1;
        return damage;
    }

}