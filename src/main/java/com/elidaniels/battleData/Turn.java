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
        //executes turn for current fighter
        Display.displayFighterTurn(currentFighter.getName());
        Display.displayPlayerBattleStats(currentFighter);

        //gets command using each fighter's type of input 
        String command = currentFighter.fetchCommand();

        //performs command requested
        currentFighter.executeCommand(command, oppFighter);

        if (oppFighter.isDead()) {
            return false;
        }
        return true;
    }

}

