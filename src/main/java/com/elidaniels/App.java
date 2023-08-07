package com.elidaniels;

import java.io.IOException;
import java.util.Arrays;

import com.elidaniels.battleData.Battle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {

        // Player testPlayerBlue = new Player("Blue", 1, 100, 12);
        // Player testPlayerRed = new Player("Red", 1, 100, 12);

        // Battle battle = new Battle(testPlayerBlue, testPlayerRed);

        // battle.startBattle();

        // Player eli = new Player("Eli");
        // Player yash = new Player("Yash");

        // Battle battle = new Battle(eli, yash);

        // battle.startBattle();


    
        // Level testLv = new Level();

        // System.out.println(testLv.toString() + "\n\n");

        // for (int i=0; i<=10; i++) {

        //     testLv.gainExp(testLv.getExpToNextLevel());

        //     boolean x = testLv.checkLevelUP();

            
        //     System.out.println(testLv.toString() + "\n\n");

            
            
        // }

        SkillSetup ss = new SkillSetup();
        System.out.println(Arrays.toString(ss.getSkillNameArray()));
    }
}
