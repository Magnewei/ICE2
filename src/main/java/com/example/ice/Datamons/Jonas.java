package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class Jonas implements Datamon {
    private String name;
    private double hp;
    private String CreatureType;
    private String move1Name = "Bulk up";
    private String move2Name = "Skift navn på discord";
    private String move3Name = "Sig vi skal game senere, men glem at dukke op";
    private String move4Name = "HULK SMASH";


    public Jonas(){
        this.name = "Elsket Løve";
        this.hp = 20;
        this.CreatureType = "StudieGruppeF";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 20;
        return (double) hp / maxHealth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHP() {
        return (int)hp;
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
        return "A giant monster apears from the dista..... oh wait its just tiny Jonas";
    }


    public int move1(Datamon target){
        int damage = 0;
        System.out.println("Angreb: " + move1Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move2(Datamon target) {
        int damage = 2;
        System.out.println("Angreb: " + move2Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move3(Datamon target) {
        int damage = 10;
        System.out.println("Angreb: " + move3Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    @Override
    public int move4(Datamon target) {
        double damage = hp/10;
        if(hp > 200){
            damage *= 5;
        }
        System.out.println("Angreb: " + move4Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return (int)damage;
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

    @Override
    public Image getSprite() {
        String path = "file:" + "src/main/resources/com/example/ice/Fred2G.png";

        // Import image file.
        Image image = new Image(path);

        // Instantiate ImageView and set image.
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        // Return ImageView related to specific Datamon.
        return image;
    }
}