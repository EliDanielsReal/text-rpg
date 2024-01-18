package com.elidaniels.battledata;

import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.miscdata.Display;

public class Battle {

    Fighter fighterOne; 
    Fighter fighterTwo;
    
    boolean isBattling = true;

    public Battle(Fighter fighterOne, Fighter fighterTwo) {
        this.fighterOne = fighterOne;
        this.fighterTwo = fighterTwo;
    }
    
    public void startBattle() {
        Turn turn;
        
        Display.displayStartOfBattle(fighterOne.getName(), fighterTwo.getName());
        
        //Main battle loop
        while (isBattling) {
            //turn for fighterOne
            turn = new Turn(fighterOne, fighterTwo);
            isBattling = turn.executeTurn();

            if (isBattling) {
                //turn for fighterTwo if battle has not ended
                turn = new Turn(fighterTwo, fighterOne);
                isBattling = turn.executeTurn();
            }
        }
    }
    
    public Fighter getResult() {
        Fighter winner;

        //Determine winner
        if (fighterOne.isDead()) {
            winner = fighterTwo;
        }
        else {
            winner = fighterOne;
        }
        
        //Display result
        Display.displayWinnner(winner.getName());
        
        return winner;
    }
}
