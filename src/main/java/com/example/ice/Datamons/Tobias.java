package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tobias implements Datamon {
    private String name;
    private int hp;
    private String CreatureType;
    private String move1Name = "Kod reol";
    private String move2Name = "Print reol";
    private String move3Name = "Byg Reol";
    private String move4Name = "Snak om reol";
    private int damage = 0;
    private boolean ReolCode = false;
    private boolean ReolPrint = false;
    private boolean ReolTalk = false;
    private String path = "file:" + "src/main/resources/com/example/ice/TobiasSprite.png";


    public Tobias() {
        this.name = "Tobias";
        this.hp = 101;
        this.CreatureType = "YapMaster";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 101;
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
        ReolCode = true;
        return damage;
    }

    public int move2(Datamon target){
        ReolPrint = true;
        return damage;
    }

    public int move3(Datamon target){
        if((ReolPrint && ReolTalk && ReolCode) == true){
            path = "file:" + "src/main/resources/com/example/ice/ShrekSprite.png";
            // Transform into Shrek
            move1Name = "WWE takedown";
            move2Name = "Flying Crossbody";
            move3Name = "UFO";
            move4Name = "Vertical Suplex";
            CreatureType = "Gigablaster";
            name = "Shrek";
            hp = 149;
            damage = 40;
        }

        return damage;
    }

    public int move4(Datamon target){
        ReolTalk = true;
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
        String path = "file:" + "src/main/resources/com/example/ice/TobiasSprite.png";

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
