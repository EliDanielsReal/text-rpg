package com.elidaniels.fighterdata.enemydata;

import java.util.Random;

import com.elidaniels.fighterdata.ElementType;
import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.fighterdata.FighterType;
import com.elidaniels.miscdata.Display;

public class Enemy extends Fighter{

    private ElementType elementType;
    
    private int expDropped;
    private int goldDropped; 
    
    
    public Enemy(String name, int health, int attack, int expDropped, int goldDropped, ElementType elementType) {
        super(name, health, attack, FighterType.ENEMY, elementType);
        this.expDropped = expDropped;
        this.goldDropped = goldDropped;
    }
    
    public int getGoldDropped() {
        return goldDropped;
    }
    
    public int getExpDropped() {
        return expDropped;
    }
    
    public ElementType getElementType() {
        return elementType;
    }

    public int calcDamage(String command) {
        if (command.equals("stab")) {
            return 11 + getAttack();
        } else {
            return 20 + getAttack();
        }
    }

    @Override
    public String getCommand() {
        Random rand = new Random();
        int x = rand.nextInt(2) + 1;
        if (x == 1) {
            return "stab";
        }
        else {
            return "slash";
        }
    }
    @Override
    public void executeCommand(String command, Fighter oppFighter) {
        
        Display.displayAttack(command, getName());
        int damage = calcDamage(command);
        oppFighter.takeDamage(damage);
        Display.displayDamage(damage, getName());
        
    }


    
}
