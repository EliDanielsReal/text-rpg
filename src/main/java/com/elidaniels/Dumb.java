package com.elidaniels;


import com.elidaniels.fighterdata.ElementType;
import com.elidaniels.fighterdata.playerdata.Player;
import com.elidaniels.miscdata.Display;
import com.elidaniels.miscdata.Encounter;
import com.elidaniels.miscdata.IOManager;

public class Dumb {
    
    public static void main(String[] args) {

        // final Player player = CharacterCreation.createCharacter();
        // IOManager.clearConsole();
        // Display.displayFullPlayerStats(player);

        final Player player = new Player("Eli", ElementType.FIRE);

        while (!player.isDead()) {
            Encounter enc = new Encounter(player);
            Display.displayFullPlayerStats(player);
            enc.randomEvent();

        }
        
    }

}
