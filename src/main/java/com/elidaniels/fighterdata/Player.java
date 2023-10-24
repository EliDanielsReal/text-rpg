package com.elidaniels.fighterdata;

import java.io.IOException;

import com.elidaniels.Level;
import com.elidaniels.SkillSetup;

public class Player extends Fighter {
    
    private Level playerLevel;

    private SkillSetup skillSetup;

    public Player(String name) {
        super(name, 100, 10, FighterType.PLAYER);
        this.playerLevel = new Level(0);
        this.skillSetup = new SkillSetup();
    }
    
    public Level getLevel() {
        return playerLevel;
    }
    
    public SkillSetup getSkillSetup() {
        return skillSetup;
    }

    
}
