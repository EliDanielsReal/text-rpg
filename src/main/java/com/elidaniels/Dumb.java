package com.elidaniels;


import com.elidaniels.fighterdata.ElementType;
import com.elidaniels.fighterdata.playerdata.Player;
import com.elidaniels.miscdata.Display;
import com.elidaniels.miscdata.Encounter;

public class Dumb {
    
    public static void main(String[] args) {

        final Player eli = new Player("Eli", ElementType.FIRE);
        

        while (!eli.isDead()) {
            Encounter enc = new Encounter(eli);
            Display.displayFullPlayerStats(eli);
            enc.randomEvent();

        }


        
    }



}
