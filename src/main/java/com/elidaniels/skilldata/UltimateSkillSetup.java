package com.elidaniels.skilldata;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UltimateSkillSetup {

    UltimateSkill ultimateSkill1;
    UltimateSkill ultimateSkill2;


    //object containing all skill data
    JsonNode skillTree;

    public UltimateSkillSetup() {

        this.skillTree = readSkillData();
        this.ultimateSkill1 = new UltimateSkill(findSkillData("Meteor Meltdown"));
        this.ultimateSkill2 = new UltimateSkill(findSkillData("Quasar Quake"));

    }

    private JsonNode findSkillData(String skillName) {

        for (JsonNode jN: skillTree) {
            if (jN.get("name").asText().equals(skillName)) {
                return jN;
            }
        }
        throw new RuntimeException("Skill Not Found.");
    }

    private JsonNode readSkillData() {

        ObjectMapper oM = new ObjectMapper();

        try {
            File skillFile = new File("src/main/java/com/elidaniels/skilldata/ultimateSkills.json");
            JsonNode jsonNode = oM.readTree(skillFile);
            return jsonNode;
            
        } catch (IOException e) {
            throw new RuntimeException("Could not load ultimate skills");
        }
    }

    public List<String> asSkillNameList() {
        // List<String> skillList = new ArrayList<>();
        
        // UltimateSkill[] skills = {ultimateskill1, ultimateskill2};
        
        // for (UltimateSkill skill : skills) {
        //     skillList.add(skill.getName());
        // }
    
        // return skillList;

        String[] skillNameList = {ultimateSkill1.getName(), ultimateSkill2.getName()};

        return Arrays.asList(skillNameList);

    }

    public UltimateSkill getSkill(String skillName) {

        if (ultimateSkill1.getName().equals(skillName)) {
            return ultimateSkill1;
        }
        else if (ultimateSkill2.getName().equals(skillName)) {
            return ultimateSkill2;
        }
        // else if (skill_3.getName().equals(skillName)) {
        //     return skill_3;
        // }
        // else if (skill_4.getName().equals(skillName)) {
        //     return skill_4;
        // }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void setSkill(int skillNum, String newSkill) {

        switch (skillNum) {
            case 1:
                ultimateSkill1 = new UltimateSkill(findSkillData(newSkill));
                break;

            case 2:
                ultimateSkill2 = new UltimateSkill(findSkillData(newSkill));
                break;

            // case 3:
            //     skill_3 = new UltimateSkill(findSkillData(newSkill));
            //     break;

            // case 4:
            //     skill_4 = new UltimateSkill(findSkillData(newSkill));
            //     break;

            default:
                break;
        }
    }

}
