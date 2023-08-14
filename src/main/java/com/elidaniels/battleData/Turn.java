package com.elidaniels.battledata;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.elidaniels.Player;
import com.elidaniels.Skill;

public class Turn {

    Scanner scn = new Scanner(System.in);

    private Player currentPlayer;
    private Player enemyPlayer;

    //converts array to list for improved functionality
    private List<String> validCommands;
    

    public Turn(Player currentPlayer, Player enemyPlayer, Scanner scn) {

        this.currentPlayer = currentPlayer;
        this.enemyPlayer = enemyPlayer;

        validCommands =  Arrays.asList(currentPlayer.getSkillSetup().getSkillNameArray());


    }
    
    public boolean executeTurn() {

        String playerInput;

        System.out.println("Its " + currentPlayer.getName() + "'s turn...\n");

        while (true) {

            System.out.println("ATTACKS:\n" + 
            validCommands.get(0) + "\n"+
            validCommands.get(1) + "\n"+
            validCommands.get(2) + "\n"+
            validCommands.get(3) + "\n");

            playerInput = scn.nextLine();

            System.out.println(playerInput);

            if (validCommands.contains(playerInput)) {

                break;
            }

        }

        int moveDamage = calcDamage(playerInput);

        System.out.println("Player dealt " + Integer.toString(moveDamage) + " damage!\n");

        enemyPlayer.takeDamage(moveDamage);

        if (enemyPlayer.isDead()) {

            return false;

        }

        return true;
        
    }

    private int calcDamage(String skillName) {

        Skill selectedSkill = currentPlayer.getSkillSetup().getSkill(skillName);

        return selectedSkill.getDamage();

    }


}

