package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Mads implements Datamon {
    private String name;
    private int hp;
    private String CreatureType;


    public Mads() {
        this.name = "Mads";
        this.hp = 280;
        this.CreatureType = "Bror";
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
        return "You hear the bangers long before he turns the corner... It's Mads!";
    }

    public int move1(Datamon target){
        String name ="Spil en banger";
        int damage = 11;
        if(target.getName().equals("Rouvi")){
            damage *= 2;
        }
        showResult(name,damage,target);
        return damage;
    }

    public int move2(Datamon target){
        String name ="Råb bror";
        int damage = 8;
        showResult(name,damage,target);
        return damage;
    }

    public int move3(Datamon target){
        String name ="Skal vi i byen";
        int damage = 9;
        if(target.getName().equals("Fred2")){
            damage *= 3;
        }
        showResult(name,damage,target);
        return damage;
    }

    public int move4(Datamon target){
        String name ="Næver forever";
        int damage = 1;
        showResult(name,damage,target);
        return damage;
    }

    public void showResult(String name, int damage, Datamon target){
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
    }

}


