package com.example.ice;

public interface Datamon {
    public String getName();
    public double getHP();
    public void setHP(int hp);
    public double getBaseDamage();
    public String getCreatureType();
    public double Damagebuff(Datamon target);
    public double takedamage(double damage);
    public String introduction();



}
