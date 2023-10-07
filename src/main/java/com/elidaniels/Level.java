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

        for (int x: levelExpRequirements) {
            if (currentExp >= x) {
                lv ++;
            } else {
                expToNextLevel = (x-currentExp);
                break;
            }
        }

        if (lv == 10) {
            currentExp = 3000;
            expToNextLevel = 0;
            isMax = true;
        }
    }


        
        // public void loadLevelStats(int exp) {
            
        //     this.currentExp = exp;
            
        //     boolean shouldLevelUp = true;
            
        //     while (!shouldLevelUp ) {
        //         shouldLevelUp = checkLevelUP();
                
        //     }
        // }
        
        public boolean checkLevelUP() {
            
            if (lv == 10) {
                return false;
            }
            else if (currentExp >= expToNextLevel) {
                
            lv++;

            updateNextLevelExp();

            return true;
        }

        return false;
        
    }
    
    private void updateNextLevelExp() {
        expToNextLevel = levelExpRequirements[lv-1];
    }
    
    public void gainExp(int exp) {
        currentExp += exp;
        if (currentExp > 3000) {
            currentExp = 3000;
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
