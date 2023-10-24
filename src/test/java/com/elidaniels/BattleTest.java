package com.elidaniels;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.elidaniels.battledata.Battle;
import com.elidaniels.fighterdata.Player;

public class BattleTest {
    

    @Test
    public void testWinner() {

        String automatedInput = "ksjenckj\nFire\nFIRE\nFireball\nFireball\nWaterblade\n";
        InputStream inputStream = new ByteArrayInputStream(automatedInput.getBytes());
        System.setIn(inputStream);

        Player testPlayerBlue = new Player("Blue");
        Player testPlayerRed = new Player("Red");

        Battle battle = new Battle(testPlayerBlue, testPlayerRed);

        // Player winner = battle.startBattle();

        // assertEquals(testPlayerRed,winner); 

    }
}
