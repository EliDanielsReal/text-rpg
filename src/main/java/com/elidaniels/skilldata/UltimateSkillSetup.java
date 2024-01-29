package com.elidaniels.skilldata;

import java.util.ArrayList;
import java.util.List;

import com.elidaniels.miscdata.IOManager;

public class UltimateSkillSetup {

    ArrayList<UltimateSkill> availableSkillList;
    ArrayList<UltimateSkill> equipedSkillList;


    public UltimateSkillSetup() {
        initSkillSetup();
    }
    
    private void initSkillSetup() {
        //retrieves ultimate skill data from json file and stores it as an ArrayList
        this.availableSkillList = IOManager.readUltimateSkillData();
        this.equipedSkillList = new ArrayList<>();
        UltimateSkill uSkill1 = getSkill("Quasar Quake", false);
        UltimateSkill uSkill2 = getSkill("Skyward Surge", false);
        equipedSkillList.add(uSkill1);
        equipedSkillList.add(uSkill2);
    }

    public List<String> asSkillNameList(boolean equiped) {
        //returns a list of skill names
        ArrayList<UltimateSkill> skillList = selectList(equiped);
        ArrayList<String> skillNameList = new ArrayList<>();

        for (UltimateSkill uSkill: skillList) {
            skillNameList.add(uSkill.getName());
        }

        return skillNameList;
    }

    public UltimateSkill getSkill(String skillName, boolean equiped) {
        //returns a skill via it's name
        ArrayList<UltimateSkill> skillList = selectList(equiped);

        for (UltimateSkill uSkill : skillList) {
            if (uSkill.getName().equals(skillName)) {
                return uSkill;
            }
        }

        throw new IllegalArgumentException("Ultimate skill not found");
    }

    public UltimateSkill getEquipedSkill(int skillNumber) {
        //returns a skill via it's in-game index (1-2)
        if (skillNumber == 1 || skillNumber == 2) {
            return equipedSkillList.get(skillNumber-1);
        }

        throw new IllegalArgumentException("Ultimate skill not found");
    }

    public UltimateSkill getAvailableSkill(int skillNumber) {
        //returns a skill via it's in-game index (1-16)
        if (skillNumber > 0 || skillNumber < 17) {
            return availableSkillList.get(skillNumber-1);
        }

        throw new IllegalArgumentException("Ultimate skill not found");
    }


    private ArrayList<UltimateSkill> selectList(boolean equiped) {
        if (equiped) {
            return equipedSkillList;
        }
        return availableSkillList;
    }
}
