package com.elidaniels;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.elidaniels.miscdata.SkillSetup;

public class SkillTest {


    @Test
    public void testInitSetup() {
        SkillSetup testSS = new SkillSetup(); 
        assertArrayEquals(testSS.asSkillNameList().toArray(), new String[]{"Fireball", "Waterblade", "Airspike", "Earthwall"});
    }

    @Test
    public void testSetSkill() {
        SkillSetup testSS = new SkillSetup(); 
        testSS.setSkill(3, "Chidori");
        assertArrayEquals(testSS.asSkillNameList().toArray(), new String[]{"Fireball", "Waterblade", "Chidori", "Earthwall"});
    }
}
