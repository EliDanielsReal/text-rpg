package com.elidaniels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.elidaniels.Level;

public class LevelTest {

    @Test
    public void testInitLevel() {

        Level lvExp0 = new Level(0);
        assertEquals(1,lvExp0.getLv());
        assertFalse(lvExp0.isMaxLevel());
        assertEquals(100, lvExp0.getExpToNextLevel());

        Level lvExp10 = new Level(10);
        assertEquals(1,lvExp10.getLv());
        assertEquals(90, lvExp10.getExpToNextLevel());

        Level lvExp100 = new Level(100);
        assertEquals(2,lvExp100.getLv());
        assertFalse(lvExp100.isMaxLevel());
        assertEquals(150, lvExp100.getExpToNextLevel());

        Level lvExp120 = new Level(120);
        assertEquals(2,lvExp120.getLv());

        Level lvExp249 = new Level(249);
        assertEquals(2,lvExp249.getLv());
        assertEquals(1, lvExp249.getExpToNextLevel());

        Level lvExp900 = new Level(900);
        assertEquals(5,lvExp900.getLv());
        assertFalse(lvExp900.isMaxLevel());

        Level lvExp3000 = new Level(3000);
        assertEquals(10,lvExp3000.getLv());
        assertTrue(lvExp3000.isMaxLevel());
        assertEquals(0, lvExp3000.getExpToNextLevel());

        Level lvExp4000 = new Level(4000);
        assertEquals(10,lvExp4000.getLv());
        assertTrue(lvExp4000.isMaxLevel());
        assertEquals(0, lvExp4000.getExpToNextLevel());

    }


    

}
