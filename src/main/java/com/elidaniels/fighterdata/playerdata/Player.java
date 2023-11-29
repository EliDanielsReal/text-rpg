package com.elidaniels.fighterdata.playerdata;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


import com.elidaniels.fighterdata.ElementType;
import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.fighterdata.FighterType;
import com.elidaniels.miscdata.Display;
import com.elidaniels.skilldata.Skill;
import com.elidaniels.skilldata.SkillSetup;
import com.elidaniels.skilldata.UltimateSkillSetup;

public class Player extends Fighter {
    
    final private Level playerLevel;

    final private SkillSetup skillSetup;
    final private UltimateSkillSetup ultimateSkillSetup;

    private int maxHP;
    // private int stamina;

    final private Scanner scn;

    public Player(String name, ElementType elementType) {
        super(name, 100, 10, FighterType.PLAYER, elementType);
        this.maxHP = getHealth();
        this.playerLevel = new Level(0);
        // this.stamina = 1;
        this.skillSetup = new SkillSetup();
        this.ultimateSkillSetup = new UltimateSkillSetup();
        this.isPlayer = true;
        this.scn = new Scanner(System.in);
    }
    
    public Level getLevel() {
        return playerLevel;
    }
    
    public SkillSetup getSkillSetup() {
        return skillSetup;
    }
    
    public UltimateSkillSetup getUltimateSkillSetup() {
        return ultimateSkillSetup;
    }

    public void revivePlayer() {
        setHealth(maxHP);
        Display.displayRevivePlayer();
    }

    public int calcDamage(Skill sk) {
        return sk.getDamage() + getAttack();
    }

    public void levelUPStats() {
        //display 
        setAttack(getAttack()+7);
    }

    @Override
    public String getCommand() {
        List<String> validCommands = Arrays.asList("1", "2", "3", "4");
        String input;

        while (true) {
            Display.displayBattleCommands();
            input = scn.nextLine();

            if (validCommands.contains(input)) {
                return input;
            } else {
                Display.displayInvalidInput(input);
            }
        }
    }

    @Override
    public void executeCommand(String command, Fighter oppFighter) {
        switch (command) {
            case "1":
                battle_attack(oppFighter);
                break;
            case "2":
                battle_defend();
                break;
            case "3":
                battle_heal();
                break;
            case "4":
                battle_ultimate_attack(oppFighter);
                break;
            default:
                throw new RuntimeException(command + "is not a valid command!");
        }
    }

    private void battle_attack(Fighter oppFighter) {
        Random rand = new Random();
        int x = rand.nextInt(5) + 1;
        Skill attack = skillSetup.getSkill(x);
        Display.displayAttack(attack.getName(), getName());
        int damage = calcDamage(attack);
        oppFighter.takeDamage(damage);
        Display.displayDamage(damage, getName());


    }

    private void battle_defend() {
        setIsDefending(true);
    }

    private void battle_heal() {

    }

    private void battle_ultimate_attack(Fighter oppFighter) {

    }
}
