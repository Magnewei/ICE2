package com.example.ice.Datamons;

import com.example.ice.Datamon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RouvisMor implements Datamon {
    private String name, CreatureType;
    private int hp, damage;
    private String move1Name = "Teen Seduction";
    private String move2Name = "Bitch slap";
    private String move3Name = "Blowing kiss";
    private String move4Name = "Life Advice";

    public RouvisMor(){
        this.name = "Henriette";
        this.hp = 149;
        this.CreatureType = "MILF";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 300;
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
        return "A hot milf appears in the wild. Her soul is kind, and her smile light up the world";
    }

    /**
     * These 4 methods below , are used to create attacks for the Datamon. Every attack returns damage. Some attacks damage variable is buffed / nerfed depending on which datamon the target is.
     * @param target
     * @return damage
     */

    public int move1(Datamon target){
        damage = 7;
        if("Ginger".equals(target.getCreatureType())){
            damage *= 2;
        }
        System.out.println("Angreb: " + move1Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move2(Datamon target){
        damage = 6;
        if("Ginger".equals(target.getCreatureType())){
            damage *= 2;
        }
        System.out.println("Angreb: " + move2Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move3(Datamon target){
        damage = 1;
        if("Ginger".equals(target.getCreatureType())){
            damage = 100;
        }
        System.out.println("Angreb: " + move3Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;

    }

    public int move4(Datamon target){
        damage = 1;
        if("Ginger".equals(target.getCreatureType())){
            damage *= 2;
        }
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
