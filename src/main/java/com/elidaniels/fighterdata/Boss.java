package com.elidaniels.fighterdata;

public class Boss extends Fighter {

    public Boss(String name, int health, int attack) {
        super(name, health, attack, FighterType.BOSS);
    }
    
}
