package com.elidaniels.battledata.turn;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.elidaniels.Skill;
import com.elidaniels.fighterdata.Fighter;

public abstract class Turn {

    private Fighter currentFighter;
    private Fighter oppFighter;
    
    public Turn(Fighter currentFighter, Fighter oppFighter) {
        this.currentFighter = currentFighter;
        this.oppFighter = oppFighter;
    }
    
    public boolean executeTurn() {
        System.out.println("Its " + currentFighter.getName() + "'s turn...\n");

        String commandInput = getCommandInput();

        int moveDamage = calcDamage(commandInput);
        System.out.println(currentFighter.getName() + " dealt " + Integer.toString(moveDamage) + " damage!\n");

        oppFighter.takeDamage(moveDamage);

        if (oppFighter.isDead()) {
            return false;
        }
        return true;
    }

    public abstract int calcDamage(String command);

    public abstract String getCommandInput();


}

