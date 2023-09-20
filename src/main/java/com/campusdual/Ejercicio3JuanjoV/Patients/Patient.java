package com.campusdual.Ejercicio3JuanjoV.Patients;

import java.util.*;

public class Patient {

    public Map <String,String> weeklyDiet;

    private final String name;
    private final String lastName;
    private final Integer weight;
    private final Integer height;
    private final Integer age;
    private final String genre;

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getWeight() {return weight;}
    public Integer getHeight() {return height;}
    public Integer getAge() {return age;}
    public String getGenre() {return genre;}

    public Patient(String name, String lastName, Integer weight, Integer height, Integer age, String genre, Map <String,String> weeklyDiet) {
        this.name = name;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.genre = genre;
        this.weeklyDiet = weeklyDiet;
    }
}

