package com.elidaniels;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SkillSetup {

    Skill skill_1;
    Skill skill_2;
    Skill skill_3;
    Skill skill_4;

    //object containing all skill data
    JsonNode skillTree;

    public SkillSetup() {

        this.skillTree = readSkillData();
        this.skill_1 = new Skill(findSkillData("Fireball"));
        this.skill_2 = new Skill(findSkillData("Waterblade"));
        this.skill_3 = new Skill(findSkillData("Airspike"));
        this.skill_4 = new Skill(findSkillData("Earthwall"));

    }

    private JsonNode findSkillData(String skillName) {

        for (JsonNode jN: skillTree) {
            if (jN.get("name").asText().equals(skillName)) {
                return jN;
            }
        }

        System.out.println("Skill not found");
        throw new NullPointerException();

    }



    private JsonNode readSkillData() {

        ObjectMapper oM = new ObjectMapper();

        try {

            JsonNode jsonNode = oM.readTree(new File("data/skills.json"));
            System.out.println("Skills loaded");
            return jsonNode;
            
        } catch (IOException e) {
            System.out.println("Could not load skills:" + e.getMessage());
            return oM.createObjectNode();
        }

    }

    public String[] getSkillNameArray() {
        return new String[]{skill_1.getName(), skill_2.getName(), skill_3.getName(), skill_4.getName()};
    }

    public Skill getSkill(String skillName) {

        if (skill_1.getName().equals(skillName)) {
            return skill_1;
        }
        else if (skill_2.getName().equals(skillName)) {
            return skill_2;
        }
        else if (skill_3.getName().equals(skillName)) {
            return skill_3;
        }
        else if (skill_4.getName().equals(skillName)) {
            return skill_4;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void setSkill(int skillNum, String newSkill) {

        switch (skillNum) {
            case 1:
                skill_1 = new Skill(findSkillData(newSkill));
                break;

            case 2:
                skill_2 = new Skill(findSkillData(newSkill));
                break;

            case 3:
                skill_3 = new Skill(findSkillData(newSkill));
                break;

            case 4:
                skill_4 = new Skill(findSkillData(newSkill));
                break;

            default:
                break;
        }
    }

}
