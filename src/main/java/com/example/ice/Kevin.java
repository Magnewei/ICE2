package com.example.ice;
import java.util.Scanner;

public class Kevin implements Datamon{
    private String name;
    private int hp;
    private int BaseDamage;
    Scanner scanner = new Scanner(System.in);
    private String CreatureType;

    Kevin(){
        this.name = "Kevin";
        this.hp = 100;
        this.BaseDamage = 5;
        this.CreatureType = "Ginger";
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
    public int getBaseDamage() {
        return BaseDamage;
    }

    @Override
    public String getCreatureType() {
        return CreatureType;
    }


    @Override
    public int Dealdamage(){
        return 0;
    }


    @Override
    public int Damagebuff(Datamon target) {
        System.out.println("Chose an attack");
        int choise = Integer.parseInt(scanner.nextLine());
        if("Milf".equals(target.getCreatureType())){
            return getBaseDamage() -4;
        } else {
            return getBaseDamage();
        }
    }

    @Override
    public int takedamage(int damage) {
        return hp-= damage;
    }

    @Override
    public String introduction() {
        return "A soulless Datamon appears, and it has.... red hair?";
    }

    public int straweberrythrow(){
        int damage = 10;
        Damagebuff();
    }


}
