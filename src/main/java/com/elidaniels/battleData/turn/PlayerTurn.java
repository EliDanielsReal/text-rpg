package com.elidaniels.battledata.turn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.elidaniels.Skill;
import com.elidaniels.fighterdata.Fighter;
import com.elidaniels.fighterdata.Player;

public class PlayerTurn extends Turn{
  
    public PlayerTurn(Player currentFighter, Fighter oppFighter) {
        super(currentFighter, oppFighter);
    }

    @Override
    public int calcDamage(String command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcDamage'");
    }

    @Override
    public String getCommandInput() {
        Scanner scn = new Scanner(System.in);

        List<String> validCommands = new ArrayList<>();

        String input;

        while (true) {
            System.out.println("ATTACKS:\n" + 
            validCommands.get(0) + "\n"+
            validCommands.get(1) + "\n"+
            validCommands.get(2) + "\n"+
            validCommands.get(3) + "\n");

            input = scn.nextLine();
            System.out.println(input);

            if (validCommands.contains(input)) {
                break;
            }
        }
        scn.close();
        return input;
    }

    // private int calcDamage(String command) {
    //     Skill selectedSkill = currentFighter.getSkillSetup().getSkill(skillName);
    //     return selectedSkill.getDamage();
    // }

    // private String getInput() {
    //             while (true) {
    //         System.out.println("ATTACKS:\n" + 
    //         validCommands.get(0) + "\n"+
    //         validCommands.get(1) + "\n"+
    //         validCommands.get(2) + "\n"+
    //         validCommands.get(3) + "\n");

    //         fighterInput = scn.nextLine();
    //         System.out.println(fighterInput);

    //         if (validCommands.contains(fighterInput)) {
    //             break;
    //         }
    //     }
    // }
}
