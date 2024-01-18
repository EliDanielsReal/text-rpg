package com.elidaniels.miscdata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.elidaniels.skilldata.BasicSkill;
import com.elidaniels.skilldata.UltimateSkill;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IOManager {
    
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle exceptions as needed
            e.printStackTrace();
        }
    }

    public static boolean confirmPrompt(String str) {
        //prompt user to confirm selection
        Scanner scn = new Scanner(System.in);

        System.out.println(str + ". Is this ok? y/n");
        String confirmInput = scn.nextLine();

        if (confirmInput.equals("y")) {
            return true;
        }

        return false;
    }

    public static ArrayList<BasicSkill> readBasicSkillData() {
        //reads basic skill data from json file and converts it to an array
        ObjectMapper oM = new ObjectMapper();
        
        try {
            //reads from skillData json file
            File skillFile = new File("src/main/java/com/elidaniels/skilldata/basicSkillData.json");
            JsonNode skillTree = oM.readTree(skillFile);
            
            return convertBasicSkillTreeToArrayList(skillTree);
            
        } catch (IOException e) {
            throw new RuntimeException("Could not load basic skills");
        }
    }

    private static ArrayList<BasicSkill> convertBasicSkillTreeToArrayList(JsonNode skillTree) {
        //loops through jsonArray and converts into ArrayList of skills
        ArrayList<BasicSkill> skillList = new ArrayList<>();

        for (JsonNode skill : skillTree ) {
            BasicSkill bSkill = new BasicSkill(
                skill.get("name").asText(), skill.get("description").asText(), 
                skill.get("damage").asInt(), skill.get("critRate").asLong()
            );
            skillList.add(bSkill);
        }

        return skillList;
    }

    public static ArrayList<UltimateSkill> readUltimateSkillData() {
        //reads ultimate skill data from json file and converts it to an array
        ObjectMapper oM = new ObjectMapper();
        
        try {
            //reads from skillData json file
            File skillFile = new File("src/main/java/com/elidaniels/skilldata/UltimateSkillData.json");
            JsonNode skillTree = oM.readTree(skillFile);
            
            return convertUltimateSkillTreeToArrayList(skillTree);
            
        } catch (IOException e) {
            throw new RuntimeException("Could not load ultimate skills");
        }
    }

    private static ArrayList<UltimateSkill> convertUltimateSkillTreeToArrayList(JsonNode skillTree) {
        //loops through jsonArray and converts into ArrayList of skills
        ArrayList<UltimateSkill> skillList = new ArrayList<>();

        for (JsonNode skill : skillTree ) {
            UltimateSkill uSkill = new UltimateSkill(
                skill.get("name").asText(), skill.get("description").asText(), skill.get("type").asText(), 
                skill.get("damage").asInt(), skill.get("critRate").asLong()
            );
            skillList.add(uSkill);
        }

        return skillList;
    }

}

