package com.elidaniels;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.elidaniels.battleData.Battle;

public class BattleTest {
    

    @Test
    public void testWinner() throws IOException {

        String automatedInput = "ksjenckj\nFIRE\nFIRE\nFIRE\nTHUNDER\n";
        InputStream inputStream = new ByteArrayInputStream(automatedInput.getBytes());
        System.setIn(inputStream);

        Player testPlayerBlue = new Player("Blue");
        Player testPlayerRed = new Player("Red");

        Battle battle = new Battle(testPlayerBlue, testPlayerRed);

        battle.startBattle();

        assertEquals(testPlayerRed,battle.getWinner()); 

    }
}
