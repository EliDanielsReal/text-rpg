package com.elidaniels;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.elidaniels.skilldata.UltimateSkillSetup;

public class SkillTest {


    @Test
    public void testInitSetup() {
        UltimateSkillSetup testSS = new UltimateSkillSetup(); 
        assertArrayEquals(testSS.asSkillNameList().toArray(), new String[]{"Fireball", "Waterblade", "Airspike", "Earthwall"});
    }

    @Test
    public void testSetSkill() {
        UltimateSkillSetup testSS = new UltimateSkillSetup(); 
        testSS.setSkill(3, "Chidori");
        assertArrayEquals(testSS.asSkillNameList().toArray(), new String[]{"Fireball", "Waterblade", "Chidori", "Earthwall"});
    }
}
