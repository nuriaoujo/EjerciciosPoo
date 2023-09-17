package com.campusdual.Ejercicio3JuanjoV.Patients;

import com.campusdual.Ejercicio3JuanjoV.*;

import java.util.*;

public class Patient {

    public Map<Integer, String> weeklyDiet;

    private String name;
    private String lastName;
    private Integer weight;
    private Integer height;
    private Integer age;
    private String genre;

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }

    public Patient(String name, String lastName, Integer weight, Integer height, Integer age, String genre, Map weeklyDiet) {
        this.name = name;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.genre = genre;
        this.weeklyDiet = weeklyDiet;
    }
}

