package com.binus.models;

import java.util.HashMap;
import java.util.Map;

public class Pet {
    private String name;
    private String type;
    private Integer health;

    public Pet() {

    }

    public Pet(String name, String type, Integer health) {
        this.name = name;
        this.type = type;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public boolean getNameConstraint() {
        return name.length() >= 5 && name.length() <=15;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public boolean getTypeConstraint() {
        return type.equals("kit") || type.equals("puppy") || type.equals("kitten");
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHealth() {
        return health;
    }

    public boolean getHealthConstraint() {
        return health >= 1 && health <=90;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    @Override
    public String toString() {
        Map<String, String> typeMap = new HashMap<String, String>() {{
            put("kit", "Rabbit");
            put("puppy", "Dog");
            put("kitten", "Cat");
        }};

        Map<String, String> soundMap = new HashMap<String, String>() {{
            put("kit", "clucking");
            put("puppy", "bark bark");
            put("kitten", "meow meow");
        }};

        return "name='" + name + '\'' +
                ", type='" + typeMap.get(type) + '\'' +
                ", sound='" + soundMap.get(type) + '\'' +
                ", health=" + health;
    }
}
