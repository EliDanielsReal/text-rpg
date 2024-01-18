package com.elidaniels.skilldata;

import java.util.ArrayList;
import java.util.List;

import com.elidaniels.miscdata.IOManager;


public class SkillSetup {

    private ArrayList<Skill> skillList;

    public SkillSetup() {
        initSkillSetup();
    }
    
    private void initSkillSetup() {
        //retrieves skill data from json file and stores it as an ArrayList
        this.skillList = IOManager.readSkillData();
    }

    public List<String> asSkillNameList() {
        //returns a list of skill names
        ArrayList<String> skillNameList = new ArrayList<>();
        for (Skill sk: skillList) {
            skillNameList.add(sk.getName());
        }

        return skillNameList;
    }

    public Skill getSkill(String skillName) {
        //returns a skill via it's name
        for (Skill sk : skillList) {
            if (sk.getName().equals(skillName)) {
                return sk;
            }
        }

        throw new IllegalArgumentException("skill not found");
    }

    public Skill getSkill(int skillNumber) {
        //returns a skill via it's in-game index (1-5)
        if (skillNumber > 0 && skillNumber < 6) {
            return skillList.get(skillNumber-1);
        }

        throw new IllegalArgumentException("skill not found");
    }
}
