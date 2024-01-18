package com.elidaniels.skilldata;

import java.util.ArrayList;
import java.util.List;

import com.elidaniels.miscdata.IOManager;


public class BasicSkillSetup {

    private ArrayList<BasicSkill> skillList;

    public BasicSkillSetup() {
        initSkillSetup();
    }
    
    private void initSkillSetup() {
        //retrieves basic skill data from json file and stores it as an ArrayList
        this.skillList = IOManager.readBasicSkillData();
    }

    public List<String> asSkillNameList() {
        //returns a list of skill names
        ArrayList<String> skillNameList = new ArrayList<>();
        for (BasicSkill bSkill: skillList) {
            skillNameList.add(bSkill.getName());
        }

        return skillNameList;
    }

    public BasicSkill getSkill(String skillName) {
        //returns a skill via it's name
        for (BasicSkill bSkill : skillList) {
            if (bSkill.getName().equals(skillName)) {
                return bSkill;
            }
        }

        throw new IllegalArgumentException("Basic skill not found");
    }

    public BasicSkill getSkill(int skillNumber) {
        //returns a skill via it's in-game index (1-5)
        if (skillNumber > 0 && skillNumber < 6) {
            return skillList.get(skillNumber-1);
        }

        throw new IllegalArgumentException("Basic skill not found");
    }
}
