package com.elidaniels.skilldata;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SkillSetup {

    Skill skill1;
    Skill skill2;
    Skill skill3;
    Skill skill4;
    Skill skill5;


    //object containing all skill data
    JsonNode skillTree;

    public SkillSetup() {
        this.skillTree = readSkillData();
        this.skill1 = new Skill(findSkillData("Standard Smash"));
        this.skill2 = new Skill(findSkillData("Savage Strike"));
        this.skill3 = new Skill(findSkillData("Blitz Barrage"));
        this.skill4 = new Skill(findSkillData("Vicious Assault"));
        this.skill5 = new Skill(findSkillData("Mighty Impact"));
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
            File skillFile = new File("src/main/java/com/elidaniels/skilldata/skills.json");
            JsonNode jsonNode = oM.readTree(skillFile);
            return jsonNode;
            
        } catch (IOException e) {
            throw new RuntimeException("Could not load skills");
        }
    }

    public List<String> asSkillNameList() {
        // List<String> skillList = new ArrayList<>();
        
        // UltimateSkill[] skills = {ultimateskill1, ultimateskill2};
        
        // for (UltimateSkill skill : skills) {
        //     skillList.add(skill.getName());
        // }
    
        // return skillList;

        String[] skillNameList = {skill1.getName(), skill2.getName(), skill3.getName(), skill4.getName(), skill5.getName()};

        return Arrays.asList(skillNameList);
    }

    public Skill getSkill(String skillName) {

        if (skill1.getName().equals(skillName)) {
            return skill1;
        }
        else if (skill2.getName().equals(skillName)) {
            return skill2;
        }
        else if (skill3.getName().equals(skillName)) {
            return skill3;
        }
        else if (skill4.getName().equals(skillName)) {
            return skill4;
        }
        else if (skill5.getName().equals(skillName)) {
            return skill5;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public Skill getSkill(int skillNumber) {

        switch (skillNumber) {
            case 1:
                return skill1;
            case 2:
                return skill2;
            case 3:
                return skill3;
            case 4:
                return skill4;
            case 5:
                return skill5;
            default:
                throw new IllegalArgumentException();

        }
    }
}
