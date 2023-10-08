package com.elidaniels;

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

    public void increaseLevel() {

        if (currentExp == 3000) {
            lv = 10;
            isMax = true;
            return;
        }

        lv ++;

        Display.displayLevelUP(this);

    }

    public boolean canLevelUP() {

        if (isMax) {
            return false;
        }

        int threshold = levelExpRequirements[lv-1];

        return (currentExp >= threshold);
    }

    public boolean isMaxLevel() {
        return isMax;
    }

    public void gainExp(int gainedExp) {
        currentExp += gainedExp;

        if (currentExp > 3000) {
            currentExp = 3000;
        }

    }

    public void checkLevelUP() {

        while (canLevelUP()) {
            increaseLevel();
        }

        if (isMax) {
            expToNextLevel = 0;
        } else {
            expToNextLevel = levelExpRequirements[lv-1] - currentExp;
        }
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
