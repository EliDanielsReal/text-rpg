package com.elidaniels;

public class Level {
    
    private int currentExp;

    private int expToNextLevel;

    private int lv;
    

    public Level() {
        currentExp = 0;
        expToNextLevel = 100;
        lv = 1;
    }

    public boolean checkLevelUP() {

        if (currentExp >= expToNextLevel) {

            lv++;

            updateNextLevelExp();

            return true;
        }

        return false;
        
    }

    private void updateNextLevelExp() {
        expToNextLevel += (int) Math.round(expToNextLevel *1.2);
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

    public void gainExp(int exp) {
        currentExp += exp;
    }

    @Override
    public String toString() {
        return "currentExp: " + currentExp + "\nexpToNextLevel: " + expToNextLevel + "\nlv: " + lv;
    }

}
