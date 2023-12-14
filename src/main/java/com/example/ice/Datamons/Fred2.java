package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Fred2 implements Datamon {

    private String name;
    private int hp;
    private String CreatureType;
    int promille;

    public Fred2(){
        this.name = "Fred2";
        this.hp = 250;
        this.CreatureType = "StudyGroup F";
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
        String name ="Drik øl med far";
        int damage = 8;
        promille += 3;
        showResult(name,damage,target);
        return damage;

    }

    public int move2(Datamon target){
        String name = "Drik vin med far";
        int damage = 6;
        promille += 6;
        showResult(name,damage,target);
        return damage;
    }

    public int move3(Datamon target){
        String name ="Drik whisky med far";
        int damage = 4;
        promille += 10;
        showResult(name,damage,target);
        return damage;
    }

    public int move4(Datamon target){
        String name = "Drunken uppercut";
        int damage = 3;
        damage += promille;
        showResult(name,damage,target);
        return damage;
    }

    @Override
    public void showResult(String name, int damage, Datamon target){
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println("Freds promille is now at: " + promille);
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
    }



}