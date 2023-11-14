package com.elidaniels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.elidaniels.fighterdata.Player;

public class PlayerTest {
    
    @Test
    public void testPlayerisPlayer() {
        Player player = new Player("Elon");
        assertTrue(player.isPlayer());
    }
}
