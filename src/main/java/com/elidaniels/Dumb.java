package com.elidaniels;

import java.util.Scanner;

import com.elidaniels.battledata.Turn;
import com.elidaniels.fighterdata.Enemy;
import com.elidaniels.fighterdata.Player;
import com.elidaniels.miscdata.Display;
import com.elidaniels.miscdata.Encounter;

public class Dumb {
    
    public static void main(String[] args) {

        final Player eli = new Player("Eli");
        

        while (!eli.isDead()) {
            Encounter enc = new Encounter(eli);
            Display.displayFullPlayerStats(eli);
            enc.randomEvent();

        }


        
    }



}
