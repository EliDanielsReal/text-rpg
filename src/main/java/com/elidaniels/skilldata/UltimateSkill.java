package com.elidaniels.skilldata;

public class UltimateSkill {

    private String name;
    private String description;
    private String type;
    private int damage;
    private float critRate;

    public UltimateSkill(String name, String description, String type, int damage, float critRate) {
        this.name = name;
        this.description = description;
        this.type = type;
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

    public String getType() {
        return type;
    }
}
