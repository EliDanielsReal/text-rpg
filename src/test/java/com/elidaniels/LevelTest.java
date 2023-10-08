package com.elidaniels;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.elidaniels.Level;

public class LevelTest {

    @Test
    public void testInitialLevel() {

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

    @Test
    public void testLevelUPOnce() {

        Level lv = new Level(0);

        lv.gainExp(100);
        lv.checkLevelUP();
        assertEquals(100, lv.getCurrentExp());
        assertEquals(2, lv.getLv());
        assertEquals(150, lv.getExpToNextLevel());

        lv.gainExp(50);
        lv.checkLevelUP();
        assertEquals(150, lv.getCurrentExp());
        assertEquals(2, lv.getLv());
        assertEquals(100, lv.getExpToNextLevel());

        lv.gainExp(120);
        lv.checkLevelUP();
        assertEquals(270, lv.getCurrentExp());
        assertEquals(3, lv.getLv());
        assertEquals(230, lv.getExpToNextLevel());

    }

    @Test
    public void testLevelUPTwice() {
        Level lv = new Level(500);
        assertEquals(500, lv.getCurrentExp());
        assertEquals(4, lv.getLv());
        assertEquals(250, lv.getExpToNextLevel());


        lv.gainExp(500);
        lv.checkLevelUP();
        assertEquals(1000, lv.getCurrentExp());
        assertEquals(6, lv.getLv());
        assertEquals(400, lv.getExpToNextLevel());

        lv.gainExp(50);
        lv.checkLevelUP();
        assertEquals(1050, lv.getCurrentExp());
        assertEquals(6, lv.getLv());
        assertEquals(350, lv.getExpToNextLevel());

    }

    @Test
    public void testMaxLevelUP() {

        Level lv =  new Level(2500);
        assertEquals(9, lv.getLv());
        assertEquals(500, lv.getExpToNextLevel());
        assertFalse(lv.isMaxLevel());

        lv.gainExp(500);
        lv.checkLevelUP();
        assertEquals(3000, lv.getCurrentExp());
        assertEquals(10, lv.getLv());
        assertEquals(0, lv.getExpToNextLevel());
        assertTrue(lv.isMaxLevel());

        lv.gainExp(200);
        assertEquals(3000, lv.getCurrentExp());
        assertEquals(10, lv.getLv());
        assertEquals(0, lv.getExpToNextLevel());
        assertTrue(lv.isMaxLevel());

    }

    @Test
    public void testFastLevelMax() {
        Level lv =  new Level(0);
        assertEquals(1, lv.getLv());
        assertEquals(100, lv.getExpToNextLevel());
        assertFalse(lv.isMaxLevel());

        lv.gainExp(3000);
        lv.checkLevelUP();
        assertEquals(3000, lv.getCurrentExp());
        assertEquals(10, lv.getLv());
        assertEquals(0, lv.getExpToNextLevel());
        assertTrue(lv.isMaxLevel());

        Level lvOver = new Level(0);

        lvOver.gainExp(5000);
        lvOver.checkLevelUP();
        assertEquals(3000, lvOver.getCurrentExp());
        assertEquals(10, lvOver.getLv());
        assertEquals(0, lvOver.getExpToNextLevel());
        assertTrue(lvOver.isMaxLevel());


    }




    

}
