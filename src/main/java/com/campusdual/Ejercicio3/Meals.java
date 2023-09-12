package com.campusdual.Ejercicio3;

import java.util.Scanner;
import com.campusdual.Ejercicio3.DietType.Diet;

public class Meals {
    private String name;
    private Double proteins;
    private Double fats;
    private Double carbos;
    private Integer grams;
    public String getName() { return name; }
    public Double getProteins() { return proteins; }
    public Double getFats() { return fats; }
    public Double getCarbos() { return carbos; }

    public Integer getGrams() { return grams; }
    public void setGrams(Integer grams) { this.grams = grams; }

    public Meals(){}
    public Meals (String name, Double proteins, Double fats, Double carbos, Integer grams) {
        this.name = name;
        this.proteins = proteins;
        this.fats = fats;
        this.carbos = carbos;
        this.grams = grams;
    }

    public Double getMealsCalories() {
        return ((carbos * 4) + (fats * 9) + (proteins * 4) * grams/100);
    }

}
