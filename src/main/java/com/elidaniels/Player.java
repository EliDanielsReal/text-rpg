package com.elidaniels;

import java.io.IOException;

public class Player {
    
    private String name;
    private int level;

    private int health;
    private int attack;

    private SkillSetup skillSetup;

    
    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.health = 100;
        this.attack = 10;
        this.skillSetup = new SkillSetup();
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
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
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
    
    public SkillSetup getSkillSetup() {
        return skillSetup;
    }
    
    
}
