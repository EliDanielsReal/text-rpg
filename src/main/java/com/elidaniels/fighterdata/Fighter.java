package com.elidaniels.fighterdata;

public class Fighter {

    private String name;
    private int health;
    private int attack;
    private FighterType fighterType;
    private ElementType elementType;
    
    protected boolean isPlayer;
    protected boolean isDefending;
    
    public Fighter(String name, int health, int attack, FighterType fighterType, ElementType elementType) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.fighterType = fighterType;
        this.elementType = elementType;
        this.isPlayer = false;
        this.isDefending = false;
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

    public String getCommand() {
        return "hit";
    }

    public void executeCommand(String command, Fighter oppFighter) {
        return;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public boolean isDefending() {
        return isDefending;
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

    public ElementType getElementType() {
        return elementType;
    }
    
    public void setIsDefending(boolean bool) {
        isDefending = bool;
    }

    
}
