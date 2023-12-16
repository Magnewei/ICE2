package com.example.ice;

import javafx.scene.image.ImageView;

public interface Datamon {
    public String getName();
    public int getHP();
    public void setHP(int hp);
    public String getCreatureType();

    public int move1(Datamon Target);
    public int move2(Datamon Target);
    public int move3(Datamon Target);
    public int move4(Datamon Target);
    public String getMove1Name();
    public String getMove2Name();
    public String getMove3Name();
    public String getMove4Name();

    public String introduction();

    public double getPercentageHealth();
    public ImageView getSprite();

}
