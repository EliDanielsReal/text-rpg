package com.elidaniels;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.elidaniels.Level;

public class LevelTest {

    @Test
    public void testLevel() {

        Level testLv = new Level();

        assertEquals(0, testLv.getCurrentExp());
        assertEquals(1, testLv.getLv());

        testLv.gainExp(testLv.getExpToNextLevel());

        assertEquals(100, testLv.getCurrentExp());

        testLv.checkLevelUP();

        assertEquals(2, testLv.getLv());

        testLv.gainExp(testLv.getExpToNextLevel());

        assertEquals(220, testLv.getCurrentExp());

        testLv.checkLevelUP();

        assertEquals(3, testLv.getLv());

        testLv.gainExp(testLv.getExpToNextLevel());

        assertEquals(100, testLv.getCurrentExp());

        testLv.checkLevelUP();

        assertEquals(2, testLv.getLv());

    }


    

}
