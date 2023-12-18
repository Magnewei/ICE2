package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Shrek implements Datamon {
    private String name;
    private int hp, damage;;
    private String CreatureType;
    private String move1Name = "WWE takedown";
    private String move2Name = "Flying Crossbody";
    private String move3Name = "UFO";
    private String move4Name = "Vertical Suplex";

    public Shrek(){
        this.name = "Shrek";
        this.hp = 149;
        this.CreatureType = "Gigablaster";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 149;
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
        return "";
    }

    /**
     * These 4 methods below , are used to create attacks for the Datamon. Every attack returns damage. Some attacks damage variable is buffed / nerfed depending on which datamon the target is.
     * @param target
     * @return damage
     */

    public int move1(Datamon target){
        damage = 50;

        return damage;
    }

    public int move2(Datamon target){
        damage = 45;

        return damage;
    }

    public int move3(Datamon target){
        damage = 35;

        return damage;

    }

    public int move4(Datamon target){
        damage = 60;
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
        String path = "file:" + "src/main/resources/com/example/ice/RouvisMorSprite.png";

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
