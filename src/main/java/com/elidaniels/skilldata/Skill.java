package com.elidaniels.skilldata;

import com.fasterxml.jackson.databind.JsonNode;

public class Skill {

    private String name;
    private String description;
    private int damage;
    private float critRate;

    public Skill(String name, String description, int damage, float critRate) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.critRate = critRate;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public float getCritRate() {
        return critRate;
    }

}
