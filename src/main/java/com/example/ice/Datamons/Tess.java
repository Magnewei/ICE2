package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tess implements Datamon {
    private String name, CreatureType;
    private int hp, damage;
    private boolean studerendePræsenterer;
    private String move1Name = "Roast";
    private String move2Name = "Stil spørgsmål til studerendes kode";
    private String move3Name = "Undervis på Zoom";
    private String move4Name = "Få studerende til at præsentere";

    public Tess(){
        this.name = "Tess";
        this.hp = 150;
        this.CreatureType = "Boss";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 300;
        return (double) hp / maxHealth;
    }

    //Getter that retrieve name
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
        return  "";
    }



    /**
     * These 4 methods below , are used to create attacks for the Datamon. Every attack returns damage. Some attacks damage variable is buffed / nerfed depending on which datamon the target is.
     * @param target
     * @return damage
     */
    public int move1(Datamon target){
        damage = 75;
        if (target.getName().equals("Elsket Løve")){
            damage *= 100;
        }
        System.out.println("Angreb: " + move1Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move2(Datamon target){
        damage = 75;
        if(studerendePræsenterer){
            damage *= 2;
            studerendePræsenterer = false;
        }
        System.out.println("Angreb: " + move2Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move3(Datamon target){
        damage = 75;
        System.out.println("Angreb: " + move3Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move4(Datamon target){
        damage = 75;
        studerendePræsenterer = true;
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


    /**
     * This following method returns the Sprite of the Datamon. Our Sprite is the image of the users/enemy's Datamon, That's being displayed when launching our BattlSim
     * @return image
     */
    @Override
    public Image getSprite() {
        String path = "file:" + "src/main/resources/com/example/ice/TessSprite.png";

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
