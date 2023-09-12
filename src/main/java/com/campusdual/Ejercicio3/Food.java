package com.campusdual.Ejercicio3;

public class Food {
    private String name;
    private Double carbos;
    private Double fats;
    private Double proteins;

    public Food(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public Double getCarbos() { return carbos; }
    public Double getFats() { return fats; }
    public Double getProteins() { return proteins; }

    //CONSTRUCTOR
    public Food(String name, Double carbos, Double fats, Double proteins){
        this.name = name;
        this.carbos = carbos;
        this.fats = fats;
        this.proteins = proteins;
    }

    public Double getCalories(Integer weight) {
        return ((carbos * 4) + (fats * 9) + (proteins * 4) * weight/100);
    }

    public Double sumCalories(Integer weight, Food otherFood) {
        Double newcarbos = this.carbos + otherFood.carbos;
        Double newfats = this.fats + otherFood.fats;
        Double newproteins = this.proteins + otherFood.proteins;
        return((newcarbos * 4) + (newfats * 9) + (newproteins * 4)) * weight/100;
    }

    public static Double sumCalories(Integer weight, Food otherFood, Food anotherFood) {
        Double newcarbos = anotherFood.carbos + otherFood.carbos;
        Double newfats = anotherFood.fats + otherFood.fats;
        Double newproteins = anotherFood.proteins + otherFood.proteins;
        return((newcarbos * 4) + (newfats * 9) + (newproteins * 4)) * weight/100;
    }
}
