package com.binus.models;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    @Override
    public String toString() {
        Map<String, String> typeMap = Stream.of(new String[][] {
                { "kit", "Rabbit" },
                { "puppy", "Dog" },
                { "kitten", "Cat" },
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        type = typeMap.get(type);

        return "Pet{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", health=" + health +
                '}';
    }
}
