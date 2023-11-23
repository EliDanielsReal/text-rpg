package com.elidaniels.miscdata;

public class Level {

    private int[] levelExpRequirements = new int[]{100, 250, 500, 750, 1000, 1400, 1800, 2200, 3000};

    private int currentExp;
    private int expToNextLevel;
    private int lv;

    private boolean isMax;
    
    public Level(int exp) {
        this.currentExp = exp;
        calculateLevelStats();
    }

    /**
     * Calculates the player's level and related statistics based on their current experience points (Exp)
     * and whether or not the player has reached the max level.
     *
     * 3000 Exp = max level
     */
    private void calculateLevelStats() {
        lv = 1;
        isMax = false;

        if (currentExp >= 3000) {
            lv = 10;
            currentExp = 3000;
            expToNextLevel = 0;
            isMax = true;
            return;
        }

        for (int x: levelExpRequirements) {
            if (currentExp >= x) {
                lv ++;
            } else {
                expToNextLevel = (x-currentExp);
                break;
            }
        }
    }

    /**
     * Increases the player's level by one and displays it.
     * If the player's current experience points reach 3000, they are set to level 10,
     * and isMax is set to true. 
     */
    private void increaseLevel() {
        if (currentExp == 3000) {
            lv = 10;
            isMax = true;
            return;
        }

        lv ++;
        Display.displayLevelUP(this); //Call display function to handle level up event
    }

    /**
     * Checks if the player is eligible to level up based on their current experience points (Exp) and level.
     *
     * @return true if the player can level up, false otherwise.
     */
    private boolean canLevelUP() {
        if (isMax) {
            return false;  //Cant level up at max level
        }

        int threshold = levelExpRequirements[lv-1]; //Gets level up requirements from array
        return (currentExp >= threshold);
    }
    
    /**
     * Increases the player's current experience points (Exp) by the specified amount.
     * If the total XP exceeds the maximum limit of 3000, it is capped at 3000 to prevent overflow.
     *
     * @param gainedExp The amount of experience points gained.
     * @see #currentExp The player's current experience points.
     */
    public void gainExp(int gainedExp) {
        currentExp += gainedExp;

        if (currentExp > 3000) {
            currentExp = 3000;
        }
    }

    /**
     * Checks if the player is eligible to level up and performs level-up operations if necessary.
     * This method continuously increases the player's level while they meet the level-up criteria
     * and calculates the experience points needed to reach the next level.
     * If the player has reached the maximum level, it sets the experience points required for the next
     * level to 0.
     */
    public void checkLevelUP() {
        while (canLevelUP()) {
            increaseLevel(); //Performs level up until player cannot level up anymore 
        }

        if (isMax) {
            expToNextLevel = 0; //Sets exp needed to 0 as player has reached max level
        } else {
            expToNextLevel = levelExpRequirements[lv-1] - currentExp;
        }
    }

    public boolean isMaxLevel() {
        return isMax;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public int getExpToNextLevel() {
        return expToNextLevel;
    }

    public int getLv() {
        return lv;
    }
    
    @Override
    public String toString() {
        return "currentExp: " + currentExp + "\nexpToNextLevel: " + expToNextLevel + "\nlv: " + lv;
    }

}
