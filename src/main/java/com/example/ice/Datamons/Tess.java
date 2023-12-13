package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Tess implements Datamon {

    private String name;
    private int hp;
    private String CreatureType;
    private boolean studerendePræsenterer;

    public Tess(){
        this.name = "Tess";
        this.hp = 300;
        this.CreatureType = "Boss";
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
        String name ="Roast";
        int damage = 7;
        if (target.getCreatureType().equals("ElsketLøve")){
            damage *= 100;
        }
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move2(Datamon target){
        String name = "Stil spørgsmål til studerendes kode";
        int damage = 12;
        if(studerendePræsenterer){
            damage *= 2;
        }
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move3(Datamon target){
        String name = "Undervis på Zoom";
        int damage = 2;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move4(Datamon target){
        String name = "Få studerende til at præsentere";
        int damage = 3;
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

}
