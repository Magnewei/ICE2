package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class Tobias implements Datamon {
    private String name;
    private int hp;
    private String CreatureType;

    private String move1Name = "Kod reol";
    private String move2Name = "Print reol";
    private String move3Name = "Byg Reol";
    private String move4Name = "Snak om reol";


    public Tobias() {
        this.name = "Tobias";
        this.hp = 280;
        this.CreatureType = "YapMaster";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 280;
        return (double) hp / maxHealth;
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
        return "A giant monster apears from the dista..... oh wait its just tiny jonas";
    }

    public int move1(Datamon target){
         int damage = 0;
        System.out.println("Angreb: " + move1Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
         return damage;
    }

    public int move2(Datamon target){
        int damage = 0;
        System.out.println("Angreb: " + move2Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move3(Datamon target){
        int damage = 0;
        System.out.println("Angreb: " + move3Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move4(Datamon target){
        int damage = 0;
        System.out.println("Angreb: " + move4Name + " Dealt : " + damage + " To " + target.getName());
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

    @Override
    public Image getSprite() {
        String path = "file:" + "src/main/resources/com/example/ice/TobiasSprite.png";

        // Import image file.
        Image image = new Image(path);

        // Instantiate ImageView and set image.
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        // Return ImageView related to specific Datamon.
        return image;
    }
}
