package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Kevin implements Datamon {
    private String name;
    private int hp;
    private String CreatureType;

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
        String name ="StrawberryThrow";
        int damage = 7;
        showResult(name,damage,target);
        return damage;
    }

    public int move2(Datamon target){
        String name = "Absorber sjæl";
        int damage = 11;
        showResult(name,damage,target);
        return damage;
    }

    public int move3(Datamon target){
        String name ="Rødhåret blodrus";
        int damage = 8;
        showResult(name,damage,target);
        return damage;
    }

    public int move4(Datamon target){
        String name ="Blændende maveskind";
        int damage = 5;
        showResult(name,damage,target);
        return damage;
    }

    @Override
    public void showResult(String name, int damage, Datamon target){
        System.out.println("Angreb: " + name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
    }

}