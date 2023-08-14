package com.elidaniels.battledata;

import java.util.Scanner;

import com.elidaniels.Player;

public class Battle {

    Player playerBlue; 
    Player playerRed;
    Scanner scn;


    public Battle(Player playerBlue, Player playerRed) {
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;

        this.scn = new Scanner(System.in);

    }

    public Player startBattle() {

        boolean battling = true;

        Turn turn;

        Player winner;

        while (battling) {

            System.out.println("Fighting!\n");

            turn = new Turn(playerRed, playerBlue, scn);
            battling = turn.executeTurn();

            if (battling) {
                turn = new Turn(playerBlue, playerRed, scn);
                battling = turn.executeTurn();
            }

        }

        if (playerBlue.isDead()) {
            winner = playerRed;
        }

        else {

            winner = playerBlue;
        }

        System.out.println(winner.getName() + " has won!");

        return winner;

    }

}
