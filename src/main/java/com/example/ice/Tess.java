package com.example.ice;

public class Tess implements Datamon{

    private String name;
    private int hp;
    private int BaseDamage;
    private String CreatureType;

    Tess(){
        this.name = "Tess";
        this.hp = 300;
        this.BaseDamage = 9;
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
    public int getBaseDamage() {
        return BaseDamage;
    }

    @Override
    public String getCreatureType() {
        return CreatureType;
    }

    @Override
    public int Damagebuff(Datamon target) {
        return 0;
    }

    @Override
    public int takedamage(int damage) {
        return hp-= damage;
    }

    @Override
    public String introduction() {
        return  "";
    }
}
