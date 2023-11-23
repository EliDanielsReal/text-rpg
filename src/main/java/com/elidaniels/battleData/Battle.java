package com.elidaniels.battledata;

import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.miscdata.Display;
public class Battle {

    final Fighter fighterOne; 
    final Fighter fighterTwo;

    public Battle(Fighter fighterOne, Fighter fighterTwo) {
        this.fighterOne = fighterOne;
        this.fighterTwo = fighterTwo;
    }

    public Fighter startBattle() {
        boolean battling = true;
        Turn turn;
        Fighter winner;

        Display.displayStartOfBattle(fighterOne.getName(), fighterTwo.getName());

        while (battling) {
            turn = new Turn(fighterOne, fighterTwo);
            battling = turn.executeTurn();

            if (battling) {
                turn = new Turn(fighterTwo, fighterOne);
                battling = turn.executeTurn();
            }
        }

        if (fighterOne.isDead()) {
            winner = fighterTwo;
        }
        else {
            winner = fighterOne;
        }

        Display.displayWinnner(winner.getName());
        return winner;
    }
}
