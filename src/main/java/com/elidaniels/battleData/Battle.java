package com.elidaniels.battledata;

import java.util.Scanner;

import com.elidaniels.battledata.turn.Turn;
import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.fighterdata.Fighter;

public class Battle {

    final Fighter fighterBlue; 
    final Fighter fighterRed;
    // Scanner scn;

    public Battle(Fighter fighterBlue, Fighter fighterRed) {
        this.fighterBlue = fighterBlue;
        this.fighterRed = fighterRed;
        // this.scn = new Scanner(System.in);
    }

    public Fighter startBattle() {
        boolean battling = true;
        Turn turn;
        Fighter winner;

        while (battling) {

            System.out.println("Fighting!\n");


            // turn = new Turn(fighterRed, fighterBlue);
            // battling = turn.executeTurn();

            // if (battling) {
            //     turn = new Turn(fighterBlue, fighterRed);
            //     battling = turn.executeTurn();
            // }

        }

        if (fighterBlue.isDead()) {
            winner = fighterRed;
        }
        else {
            winner = fighterBlue;
        }

        System.out.println(winner.getName() + " has won!");
        return winner;
    }
}
