package com.elidaniels.fighterdata;

import com.elidaniels.miscdata.Display;

public class Fighter {

    private String name;
    private int health;
    private int maxHealth;
    private int attack;
    private FighterType fighterType;
    private ElementType elementType;

    protected DefendingState defendingState;
    
    
    public Fighter(String name, int health, int attack, FighterType fighterType, ElementType elementType) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.fighterType = fighterType;
        this.elementType = elementType;
        this.defendingState = DefendingState.NONE;
    }
    
    public String fetchCommand() {
        return "hit";
    }

    public void executeCommand(String command, Fighter oppFighter) {
        return;
    }

    public void takeDamage(int damage) {
        int totalDamage;

        switch (defendingState) {
            case BLOCKED:
            totalDamage = (int) (0.1 * damage);
            Display.displayDamageTaken(totalDamage, getName());
            Display.displayDefendBlocked(getName());
            break;

            case DOUBLE_DAMAGE:
            totalDamage = damage * 2;
            Display.displayDamageTaken(totalDamage, getName());
            Display.displayDefendDoubleDamage(getName());
            break;

            case NO_EFFECT:
            totalDamage = damage;
            Display.displayDamageTaken(totalDamage, getName());
            Display.displayDefendNoEffect(getName());
            break;

            default:
            totalDamage = damage;
            Display.displayDamageTaken(totalDamage, name);
            break;
        }

        this.health -= totalDamage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void healFighter(float healPercent) {
        health = (int) (maxHealth * healPercent) + health;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    
    public boolean isDead() {
        return health <= 0;
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

    public DefendingState getDefendingState() {
        return defendingState;
    }
    
    public void setDefendingState(DefendingState defendingState) {
        this.defendingState = defendingState;
    }

    public ElementType getElementType() {
        return elementType;
    }
    

    
}
