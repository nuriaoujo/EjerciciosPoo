package com.campusdual.Ejercicio3;

public class Food {
    private String name;
    private Integer carbos;
    private Integer fats;
    private Integer proteins;

    //GET y SET
    public String getName() { return name; }
    public Integer getCarbos() { return carbos; }

    public Integer getFats() { return fats; }

    public Integer getProteins() { return proteins; }

    public void setName(String name) { this.name = name; }
    public void setCarbos(Integer carbos) { this.carbos = carbos; }

    public void setFats(Integer fats) { this.fats = fats; }

    public void setProteins(Integer proteins) { this.proteins = proteins; }

    //Constructores
    public Food(String name, Integer carbos, Integer fats, Integer proteins){
        this.name = name;
        this.carbos = carbos;
        this.fats = fats;
        this.proteins = proteins;
    }

    public Integer getCalories(Integer weight) {
        return ((carbos * 4) + (fats * 9) + (proteins * 4) * weight/100);
    }

    public static Integer getCalories(Integer weight, Integer carbos, Integer fats, Integer proteins) {
        return ((carbos * 4) + (fats * 9) + (proteins * 4) * weight/100);
    }

    //Si no es STATIC llama al constructor para operar
    //Si es STATIC NECESITA pedir los atributos para operar, no necesita llamar al constructor
    public Integer sumCalories(Integer weight, Food otherFood) {
        Integer newcarbos = this.carbos + otherFood.carbos;
        Integer newfats = this.fats + otherFood.fats;
        Integer newproteins = this.proteins + otherFood.proteins;
        return((newcarbos * 4) + (newfats * 9) + (newproteins * 4)) * weight/100;
    }

    public static Integer sumCalories(Integer weight, Food otherFood, Food anotherFood) {
        Integer newcarbos = anotherFood.carbos + otherFood.carbos;
        Integer newfats = anotherFood.fats + otherFood.fats;
        Integer newproteins = anotherFood.proteins + otherFood.proteins;
        return((newcarbos * 4) + (newfats * 9) + (newproteins * 4)) * weight/100;
    }
}
