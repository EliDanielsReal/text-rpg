package com.elidaniels.skilldata;

import com.fasterxml.jackson.databind.JsonNode;

public class Skill {

    private String name;
    private String description;
    
    private int damage;

    private float critRate;

    public Skill(JsonNode newSkill) {

        this.name = newSkill.get("name").asText();
        this.description = newSkill.get("description").asText();
        this.damage = newSkill.get("damage").asInt();
        this.critRate = (float) newSkill.get("critRate").asDouble();
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
