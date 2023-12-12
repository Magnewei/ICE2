package com.example.ice.Datamons;

import com.example.ice.Datamon;

public class Kevin implements Datamon {
    private String name;
    private int hp;
    private int BaseDamage;
    private String CreatureType;

    public Kevin(){
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
    public double getHP() {
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
        return "A soulless Datamon appears, and it has.... red hair?";
    }


    public void StrawberryThrow(Datamon target){
        double damageDealt = 1.2*getBaseDamage();
        target.takedamage(damageDealt);
    }


}