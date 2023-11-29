package com.elidaniels.battledata;

import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.miscdata.Display;

public class Turn {

    private Fighter currentFighter;
    private Fighter oppFighter;
    
    public Turn(Fighter currentFighter, Fighter oppFighter) {
        this.currentFighter = currentFighter;
        this.oppFighter = oppFighter;
    }
    
    public boolean executeTurn() {
        Display.displayFighterTurn(currentFighter.getName());
        Display.displayPlayerBattleStats(currentFighter);
        String command = currentFighter.getCommand();

        currentFighter.executeCommand(command, oppFighter);

        // int moveDamage = currentFighter.calcDamage(commandInput);
        // Display.displayDamage(currentFighter.getName(), moveDamage);
        // oppFighter.takeDamage(moveDamage);

        if (oppFighter.isDead()) {
            return false;
        }
        return true;
    }

}

