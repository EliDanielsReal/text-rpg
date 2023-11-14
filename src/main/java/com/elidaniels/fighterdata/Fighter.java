package com.elidaniels.fighterdata;

import java.util.ArrayList;
import java.util.List;

public class Fighter {

    private String name;
    private int health;
    private int attack;
    private FighterType fighterType;
    protected boolean isPlayer;
    
    public Fighter(String name, int health, int attack, FighterType fighterType) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.fighterType = fighterType;
        this.isPlayer = false;
    }

    public boolean isDead() {
        return health <= 0;
    }
    
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public int calcDamage(String command) {
        return attack;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public FighterType getFighterType() {
        return fighterType;
    }

    public void setFighterType(FighterType fighterType) {
        this.fighterType = fighterType;
    }

    // public List<String> getValidCommands() {
    //     return new ArrayList<>();
    // }

    public String getCommandInput() {
        return "stab";
    }

    public boolean isPlayer() {
        return isPlayer;
    }
    
}
