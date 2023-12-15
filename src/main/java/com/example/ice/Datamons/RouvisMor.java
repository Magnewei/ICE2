package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class RouvisMor implements Datamon {

    private String name;
    private int hp;
    private String CreatureType;

    private String move1Name = "Teen Seduction";
    private String move2Name = "Bitch slap";
    private String move3Name = "Blowing kiss";
    private String move4Name = "Life Advice";


    public RouvisMor(){
        this.name = "Henriette";
        this.hp = 300;
        this.CreatureType = "Milf";
    }

    @Override
    public double getPercentageHealth() {
        int maxHealth = 300;
        return (double) (maxHealth - hp) / maxHealth;
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

    public int move1(Datamon target){
        int damage = 7;
        if("Ginger".equals(target.getCreatureType())){
            damage *= 2;
        }
        System.out.println("Angreb: " + move1Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move2(Datamon target){
        int damage = 6;
        if("Ginger".equals(target.getCreatureType())){
            damage *= 2;
        }
        System.out.println("Angreb: " + move2Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;
    }

    public int move3(Datamon target){
        int damage = 1;
        if("Ginger".equals(target.getCreatureType())){
            damage = 100;
        }
        System.out.println("Angreb: " + move3Name + " Dealt : " + damage + " To " + target.getName());
        System.out.println(target.getName() + " hp is now: " + (target.getHP()-damage));
        return damage;

    }

    public int move4(Datamon target){
        int damage = 1;
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

}