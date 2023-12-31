package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Nicolai implements Datamon {
    private String name, CreatureType;
    private int hp, damage;
    private String move1Name = "Build that wall";
    private String move2Name = "Murstens kast";
    private String move3Name = "CS Flick";
    private String move4Name = "Clutch kongen";

    public Nicolai() {
        this.name = "Nicolai";
        this.hp = 140;
        this.CreatureType = "Mur";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 140;
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


    /**
     * These 4 methods below , are used to create attacks for the Datamon. Every attack returns damage. Some attacks damage variable is buffed / nerfed depending on which datamon the target is.
     * @param target
     * @return damage
     */
    public int move1(Datamon target){
        damage = 7;
        return damage;
    }

    public int move2(Datamon target){
        damage = 8;
        return damage;
    }

    public int move3(Datamon target){
        damage = 6;
        return damage;
    }

    public int move4(Datamon target){
        damage = 15;
        if(target.getHP() > hp){
            damage *= 2;
        }

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


    /**
     * This following method returns the Sprite of the Datamon. Our Sprite is the image of the users/enemy's Datamon, That's being displayed when launching our BattlSim
     * @return image
     */
    @Override
    public Image getSprite() {
        String path = "file:" + "src/main/resources/com/example/ice/NicolaiSprite.png";

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

