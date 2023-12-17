package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mads implements Datamon {
    private String name;
    private int hp;
    private String CreatureType;
    private String move1Name = "Spil en banger";
    private String move2Name = "Råb bror";
    private String move3Name = "Skal vi i byen?";
    private String move4Name = "Næver forever";
    private int damage;


    public Mads() {
        this.name = "Mads";
        this.hp = 280;
        this.CreatureType = "Bror";
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
        return "You hear the bangers long before he turns the corner... It's Mads!";
    }

    public int move1(Datamon target){
        damage = 11;
        System.out.println("Angreb: " + move1Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move2(Datamon target){
        damage = 8;
        System.out.println("Angreb: " + move2Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move3(Datamon target){
        damage = 9;
        if(target.getName().equals("Fred2")){
            damage *= 3;
        }
        System.out.println("Angreb: " + move3Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move4(Datamon target){
        damage = 1;
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
        String path = "file:" + "src/main/resources/com/example/ice/DJmadsSprite.png";

        // Import image file.
        Image image = new Image(path);

        // Instantiate ImageView and set image.
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        // Return ImageView related to specific Datamon.
        return image;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}


