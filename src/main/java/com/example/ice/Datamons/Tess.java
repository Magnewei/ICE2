package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Tess implements Datamon {

    private String name;
    private int hp;
    private String CreatureType;
    private boolean studerendePræsenterer;

    private String move1Name = "Roast";
    private String move2Name = "Stil spørgsmål til studerendes kode";
    private String move3Name = "Undervis på Zoom";
    private String move4Name = "Få studerende til at præsentere";

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
