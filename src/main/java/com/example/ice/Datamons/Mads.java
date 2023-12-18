package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mads implements Datamon {
    private String name, CreatureType;
    private int hp, damage;
    private String move1Name = "Spil en banger";
    private String move2Name = "Råb bror";
    private String move3Name = "Skal vi i byen?";
    private String move4Name = "Næver forever";

    public Mads() {
        this.name = "Mads";
        this.hp = 123;
        this.CreatureType = "Bror";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 123;
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


    /**
     * These 4 methods below , are used to create attacks for the Datamon. Every attack returns damage. Some attacks damage variable is buffed / nerfed depending on which datamon the target is.
     * @param target
     * @return damage
     */
    public int move1(Datamon target){
        damage = 11;
        return damage;
    }

    public int move2(Datamon target){
        damage = 8;
        return damage;
    }

    public int move3(Datamon target){
        damage = 9;
        if(target.getName().equals("Fred2")){
            damage *= 3;
        }
        return damage;
    }

    public int move4(Datamon target){
        damage = 1;
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


