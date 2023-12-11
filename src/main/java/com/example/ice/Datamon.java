package com.example.ice;

public interface Datamon {
    public String getName();
    public int getHP();
    public void setHP(int hp);
    public int getBaseDamage();
    public String getCreatureType();
    public int Damagebuff(Datamon target);
    public  int takedamage(int damage);
    public String introduction();

    public int Dealdamage();



}
