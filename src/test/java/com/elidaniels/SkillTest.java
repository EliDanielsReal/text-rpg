package com.elidaniels;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SkillTest {

    @Test
    public void testCreatedSetup() {
        SkillSetup testSS = new SkillSetup(); 
        assertArrayEquals(testSS.getSkillNameArray(), new String[]{"Fireball", "Waterblade", "Airspike", "Earthwall"});
    }

    @Test
    public void testSetSkill() {
        SkillSetup testSS = new SkillSetup(); 
        testSS.setSkill(3, "Chidori");
        assertArrayEquals(testSS.getSkillNameArray(), new String[]{"Fireball", "Waterblade", "Chidori", "Earthwall"});
    }
}
