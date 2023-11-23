package com.elidaniels.fighterdata;

import java.util.List;
import java.util.Scanner;

import com.elidaniels.miscdata.Display;
import com.elidaniels.miscdata.Level;
import com.elidaniels.miscdata.Skill;
import com.elidaniels.miscdata.SkillSetup;

public class Player extends Fighter {
    
    private Level playerLevel;

    private SkillSetup skillSetup;

    private int maxHP;

    final private Scanner scn;

    public Player(String name) {
        super(name, 100, 10, FighterType.PLAYER);
        this.maxHP = getHealth();
        this.playerLevel = new Level(0);
        this.skillSetup = new SkillSetup();
        this.isPlayer = true;
        this.scn = new Scanner(System.in);
    }
    
    public Level getLevel() {
        return playerLevel;
    }
    
    public SkillSetup getSkillSetup() {
        return skillSetup;
    }

    public void revivePlayer() {
        setHealth(maxHP);
        Display.displayRevivePlayer();
    }

    @Override
    public int calcDamage(String command) {
        Skill sk = skillSetup.getSkill(command);
        return sk.getDamage() + getAttack();
    }

    @Override
    public String getCommandInput() {
        
        // Scanner scn = new Scanner(System.in);

        List<String> validCommands = skillSetup.asSkillNameList();;

        String input;

        while (true) {
            
            Display.displayValidCommands(validCommands);

            input = scn.nextLine();

            if (validCommands.contains(input)) {
                break;
            }
            Display.displayInvalidInput("Not a valid command!\n");
        }
        // scn.close();
        return input;
    }

    
}
