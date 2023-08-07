package com.elidaniels.battleData;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.elidaniels.Player;

public class Turn {

    Scanner scn = new Scanner(System.in);

    private Player currentPlayer;
    private Player enemyPlayer;

    private List<String> validCommands = Arrays.asList("FIRE", "WATER", "EARTH", "AIR", "THUNDER");

    public Turn(Player currentPlayer, Player enemyPlayer) {
        this.currentPlayer = currentPlayer;
        this.enemyPlayer = enemyPlayer;
    }
    
    public boolean executeTurn() {

        String playerInput;

        System.out.println("Its " + currentPlayer.getName() + "'s turn...\n");

        while (true) {

            System.out.println("Enter a command:\n\tFIRE\n\tWATER\n\tEARTH\n\tAIR\n");

            playerInput = scn.nextLine().toUpperCase();

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

    private int calcDamage(String element) {

        switch (element) {
            case "FIRE":
                
                return 9;

            case "WATER":

                return 9;
        
            case "EARTH":

                return 8;
            
            case "AIR":

                return 6;

            case "THUNDER":
                return 100;

            default:

            return -1;

        }
    }


}

