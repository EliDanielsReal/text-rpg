package com.elidaniels.miscdata;

import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.fighterdata.playerdata.Level;
import com.elidaniels.fighterdata.playerdata.Player;

public class Display {

    public static void displayStartOfBattle(String fighter1, String fighter2) {
        System.out.println("<< " + fighter1 + " vs " + fighter2 + " >>");
    }
    
    public static void displayLevelUP(Level lv) {
        System.out.println("Level UP! Lv " + (lv.getLv()-1) + " -> " + lv.getLv());
    }

    public static void displayRevivePlayer() {
        System.out.println("Player has been revived!");
    }

    public static void displayDamage(int damage, String fighterName) {
        System.out.println(fighterName + " dealt " + damage + " damage!");
    }

    public static void displayBattleCommands() {
        System.out.println(String.format("%-20s%-20s%n%-20s%-20s%n%-20s%-20s%n%-20s%-20s%n",
        "1) Attack", "[1]",
        "2) Defend", "[0]",
        "3) Heal", "[1]",
        "4) Ultimate Attack", "[3]"));
        
    }
    // public static void displayValidCommands(List<String> validCommands) {
    //     System.out.println("ATTACKS:\n\t" + 
    //         validCommands.get(0) + "\n\t"+
    //         validCommands.get(1) + "\n\t"+
    //         validCommands.get(2) + "\n\t"+
    //         validCommands.get(3) + "\n");
    // }

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

    public static void displayFighterTurn(String currentFighter) {
        System.out.flush();
        System.out.println("Its " + currentFighter + "'s turn...\n");
    }

    public static void displayWinnner(String winner) {
        System.out.println(winner + " has won!");
    }

    public static void displayInvalidInput(String invalidString) {
        System.out.println(invalidString);
    }
}
