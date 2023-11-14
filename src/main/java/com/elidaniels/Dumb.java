package com.elidaniels;

import java.util.Scanner;

import com.elidaniels.battledata.Turn;
import com.elidaniels.fighterdata.Enemy;
import com.elidaniels.fighterdata.Player;

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
