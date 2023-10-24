package com.elidaniels;

public class Display {
    
    public static void displayLevelUP(Level lv) {
        System.out.println("Level UP! Lv " + (lv.getLv()-1) + " -> " + lv.getLv());
    }
}
