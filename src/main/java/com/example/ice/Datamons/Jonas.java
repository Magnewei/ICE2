package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Jonas implements Datamon {
    private String name, CreatureType;
    private int damage;
    private double hp;
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

    /**
     * These 4 methods below , are used to create attacks for the Datamon. Every attack returns damage. Some attacks damage variable is buffed / nerfed depending on which datamon the target is.
     * @param target
     * @return damage
     */
    public int move1(Datamon target){
        damage = 0;
        return damage;
    }

    @Override
    public int move2(Datamon target) {
        damage = 2;
        return damage;
    }

    @Override
    public int move3(Datamon target) {
        damage = 10;
        return damage;
    }

    @Override
    public int move4(Datamon target) {
        double damage = hp/10;
        if(hp > 200){
            damage *= 5;
        }
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


    /**
     * This following method returns the Sprite of the Datamon. Our Sprite is the image of the users/enemy's Datamon, That's being displayed when launching our BattlSim
     * @return image
     */
    @Override
    public Image getSprite() {
        String path = "file:" + "src/main/resources/com/example/ice/JonesSprite.png";

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