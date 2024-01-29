package com.elidaniels.miscdata;

import java.util.List;

import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.fighterdata.playerdata.Level;
import com.elidaniels.fighterdata.playerdata.Player;

public class Display {

    String reset = "\u001B[0m";
    String RED_TEXT = "\u001B[31m";
    String GREEN_TEXT = "\u001B[32m";
    String YELLOW_TEXT = "\u001B[33m";
    String BLUE_TEXT = "\u001B[34m";

    public static void displayChooseName() {
        System.out.println("Choose a name for your character:");
    }

    public static void displayChooseElementType() {
        System.out.println("Choose an element for your character:" 
        +"\nWATER \nFIRE \nEARTH \nWIND");
    }

    public static void displayStartOfBattle(String fighter1, String fighter2) {
        System.out.println("<< " + fighter1 + " vs " + fighter2 + " >>");
    }
    
    public static void displayLevelUP(Level lv) {
        System.out.println("Level UP! Lv " + (lv.getLv()-1) + " -> " + lv.getLv());
    }

    public static void displayRevivePlayer() {
        System.out.println("Player has been revived!");
    }

    public static void displayDamageTaken(int damage, String fighterName) {
        System.out.println(fighterName + " took " + damage + " damage!");
    }

    public static void displayUltimateSelection(List<String> ultimateSkills) { 
        System.out.println(String.format("%-20s%-20s%n%-20s%-20s%n%",
        "1) " +ultimateSkills.get(1)+
        "2) " + ultimateSkills.get(2)));


    }

    public static void displayBattleCommands() {
        System.out.println(String.format("%-20s%-20s%n%-20s%-20s%n%-20s%-20s%n%-20s%-20s%n",
        "1) Attack", "[1]",
        "2) Defend", "[0]",
        "3) Heal", "[1]",
        "4) Ultimate Attack", "[3]"));
        
    }

    public static void displayPlayerBattleStats(Fighter player) {
        System.out.println(
            "HP: " + player.getHealth()
        );
    }

    public static void displayFullPlayerStats(Player player) {
        System.out.println(
            "HP: " + player.getHealth() + "\n"+
            "Level: " + player.getLevel().getLv() +"\n"+
            "Exp: " + player.getLevel().getCurrentExp() +"\n"
        );
    }

    public static void displayAttack(String attackName, String currentFighter) {
        System.out.println(currentFighter + " used " + attackName + ".");
    }

    public static void displayDefend(String currentFighter) {
        System.out.println(currentFighter + " is defending...");
    }

    public static void displayDefendNoEffect(String currentFighter) {
        System.out.println(currentFighter + " could not defend the attack.");
    }

    public static void displayDefendDoubleDamage(String currentFighter) {
        System.out.println(currentFighter + " could not defend and took double the damage!");
    }

    public static void displayDefendBlocked(String currentFighter) {
        System.out.println(currentFighter + " blocked some of the attack!");
    }

    public static void displayHealSuccess(String currentFighter, int healPercent) {
        System.out.println(currentFighter + " drank a potion and healed " + healPercent + "%");
    }

    public static void displayHealFail(String currentFighter) {
        System.out.println(currentFighter + " drank a potion but it had no effect.");
    }

    public static void displayFighterTurn(String currentFighter) {
        System.out.flush();
        System.out.println("Its " + currentFighter + "'s turn...\n");
    }

    public static void displayWinnner(String winner) {
        System.out.println(winner + " has won!");
    }

    public static void displayInvalidInput(String invalidString) {
        System.out.println("'" + invalidString + "' " + "is not a valid input.");
    }
}
