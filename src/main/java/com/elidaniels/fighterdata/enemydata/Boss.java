package com.elidaniels.fighterdata.enemydata;

import com.elidaniels.fighterdata.ElementType;
import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.fighterdata.FighterType;

public class Boss extends Fighter {

    public Boss(String name, int health, int attack, ElementType elementType) {
        super(name, health, attack, FighterType.BOSS, elementType);
    }
    
}
