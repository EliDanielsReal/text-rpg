package com.elidaniels.skilldata;

import java.util.ArrayList;
import java.util.List;

import com.elidaniels.miscdata.IOManager;

public class UltimateSkillSetup {

    ArrayList<UltimateSkill> skillList;


    public UltimateSkillSetup() {
        initSkillSetup();
    }
    
    private void initSkillSetup() {
        //retrieves ultimate skill data from json file and stores it as an ArrayList
        this.skillList = IOManager.readUltimateSkillData();
    }

    public List<String> asSkillNameList() {
        //returns a list of skill names
        ArrayList<String> skillNameList = new ArrayList<>();
        for (UltimateSkill uSkill: skillList) {
            skillNameList.add(uSkill.getName());
        }

        return skillNameList;
    }

    public UltimateSkill getSkill(String skillName) {
        //returns a skill via it's name
        for (UltimateSkill uSkill : skillList) {
            if (uSkill.getName().equals(skillName)) {
                return uSkill;
            }
        }

        throw new IllegalArgumentException("Ultimate skill not found");
    }

    public UltimateSkill getSkill(int skillNumber) {
        //returns a skill via it's in-game index (1-2)
        if (skillNumber == 1 || skillNumber == 2) {
            return skillList.get(skillNumber-1);
        }

        throw new IllegalArgumentException("Ultimate skill not found");
    }
}
