package com.elidaniels.battleData;

import java.util.Scanner;

import com.elidaniels.Player;

public class Battle {

    Scanner scn = new Scanner(System.in);

    Player playerBlue; 
    Player playerRed;
    Player winner;

    public Battle(Player playerBlue, Player playerRed) {
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;
    }

    public void startBattle() {

        boolean battling = true;

        Turn turn;

        while (battling) {

            System.out.println("Fighting!\n");

            turn = new Turn(playerRed, playerBlue);
            battling = turn.executeTurn();

            if (battling) {
                turn = new Turn(playerBlue, playerRed);
                battling = turn.executeTurn();
            }

        }

        if (playerBlue.isDead()) {
            winner = playerRed;
        }

        else if (playerRed.isDead()) {
            winner = playerBlue;
        }

        System.out.println(winner.getName() + " has won!");

    }

    public Player getWinner() {
        return winner;
    }
    
}
