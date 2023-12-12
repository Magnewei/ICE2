package com.example.ice;

public interface Datamon {
    public String getName();
    public double getHP();
    public void setHP(int hp);
    public String getCreatureType();

    public int move1(Datamon Target);
    public int move2(Datamon Target);
    public int move3(Datamon Target);
    public int move4(Datamon Target);

    public String introduction();

}
