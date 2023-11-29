package com.elidaniels.fighterdata.enemydata;

import java.util.Random;

import com.elidaniels.fighterdata.ElementType;

public class EnemyGenerator {
    
    public static Enemy generateEnemy(int playerLevel) {
        if (playerLevel >= 5) {
            return generateHighEnemy();
        }
        else {
            return generateLowEnemy(); 
        }
    }

    public static Boss generateBoss(int playerLevel) {
        return new Boss("Exams", 200, 57, ElementType.WATER);
    }

    private static Enemy generateLowEnemy() {
        Random rand = new Random();
        int x = rand.nextInt(100);
         
        if (x >= 80) {
            return new Enemy("Goblin Grunt", 60, 15, 50, 10, ElementType.EARTH);
        } else if (x >= 65) {
            return new Enemy("Swamp Slime", 90, 12, 50, 10,  ElementType.WATER);
        } else if (x >= 50) {
            return new Enemy("Skeleton Warrior", 50, 22, 50, 10, ElementType.EARTH);
        } else if (x >= 35) {
            return new Enemy("White Viper", 40, 25, 50, 10, ElementType.WIND);
        } else if (x >= 20) {
            return new Enemy("Venomdread Tarantula", 45, 24, 50, 10, ElementType.FIRE);
        } else if (x >= 10) {
            return new Enemy("Dimension Shifter", 90, 27, 100, 100, ElementType.WIND);
        } else {
            return new Enemy("Moonlit Direwolf", 80, 30, 100, 100, ElementType.WATER);
        }
    }

    private static Enemy generateHighEnemy() {
        Random rand = new Random();
        int x = rand.nextInt(100);
         
        if (x >= 80) {
            return new Enemy("Aetheric Warlock", 90, 75, 10, 10, ElementType.FIRE); //Jaden
        } else if (x >= 65) {
            return new Enemy("Stardust Elf", 110, 66, 10, 10, ElementType.WIND); //Lilike
        } else if (x >= 50) {
            return new Enemy("Obsidian Dragon", 100, 70, 10, 10, ElementType.EARTH); //Kelton
        } else if (x >= 35) {
            return new Enemy("Leviathan Guardian", 105, 69, 10, 10, ElementType.WATER); //Aidan
        } else if (x >= 20) {
            return new Enemy("Sylvan Huntress", 70, 82, 10, 10, ElementType.WIND); //Nichola
        } else if (x >= 10) {
            return new Enemy("Crimson Phoenix", 140, 85, 200, 200, ElementType.FIRE); //
        } else {
            return new Enemy("Centurion Vanguard", 125, 90, 200, 200, ElementType.EARTH); //JJ
        }
    }

}
