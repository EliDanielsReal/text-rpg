package com.elidaniels;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.elidaniels.fighterdata.ElementType;
import com.elidaniels.fighterdata.playerdata.Player;

public class PlayerTest {
    
    @Test
    public void testPlayerisPlayer() {
        Player player = new Player("Elon", ElementType.EARTH);
        assertTrue(player.isPlayer());
    }
}
