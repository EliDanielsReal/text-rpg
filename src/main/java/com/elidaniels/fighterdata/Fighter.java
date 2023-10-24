package com.elidaniels.fighterdata;

public class Fighter {

    private String name;
    private int health;
    private int attack;
    private FighterType fighterType;
    
    public Fighter(String name, int health, int attack, FighterType fighterType) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.fighterType = fighterType;
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
}
