package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bobby implements Datamon {
    private String name, CreatureType;
    private int hp, damage;
    private String move1Name = "Jeg kommer i morgen gutter";
    private String move2Name = "Ej jeg kommer på torsdag gutter";
    private String move3Name = "Bogstaveligt talt bare dyresex lmao";
    private String move4Name = "Drop ud";

    public Bobby() {
        this.name = "Bobby";
        this.hp = 110;
        this.CreatureType = "Ghost";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 110;
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

    /**
     * These 4 methods below , are used to create attacks for the Datamon. Every attack returns damage. Some attacks damage variable is buffed / nerfed depending on which datamon the target is.
     * @param target
     * @return damage
     */
    @Override
    public int move1(Datamon target){
        damage = 2;
        return damage;
    }

    @Override
    public int move2(Datamon target){
        damage = 4;
        return damage;
    }

    @Override
    public int move3(Datamon target){
        damage = 10;
        return damage;
    }

    @Override
    public int move4(Datamon target){
        this.setHP(0);
        damage = 0;
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
    public String introduction() {
        return "A giant monster apears from the dista..... oh wait its just tiny jonas";
    }


    /**
     * This following method returns the Sprite of the Datamon. Our Sprite is the image of the users/enemy's Datamon, That's being displayed when launching our BattlSim
     * @return image
     */
    @Override
    public Image getSprite() {
        String path = "file:" + "src/main/resources/com/example/ice/BobbySprite.png";

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
