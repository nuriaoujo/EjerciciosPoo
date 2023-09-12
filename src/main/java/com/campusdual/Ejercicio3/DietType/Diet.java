package com.campusdual.Ejercicio3.DietType;

import com.campusdual.Ejercicio3.Food;
import com.campusdual.Ejercicio3.Meals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diet {
    Meals meal;
    public List<Meals> dietList = new ArrayList<>();
    int dietType;
    boolean isWomen;
    Integer age;
    Integer height;
    Integer weight;
    Integer maxFats;
    Integer maxCarbs;
    Integer maxProtein;

    public void setMaxFats(Integer maxFats) { this.maxFats = maxFats; }
    public void setMaxCarbs(Integer maxCarbs) { this.maxCarbs = maxCarbs; }
    public void setMaxProtein(Integer maxProtein) { this.maxProtein = maxProtein; }


    public int getDietType() { return dietType; }
    public void setDietType(int dietType) {this.dietType = dietType; }

    public boolean isWomen() { return isWomen; }
    public void setWomen(boolean isWomen) { this.isWomen = isWomen; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Integer getHeight() { return height; }
    public void setHeight(Integer height) { this.height = height; }

    public Integer getWeight() { return weight; }
    public void setWeight(Integer weight) { this.weight = weight; }

    protected Integer maxCaloriesDiet; //se establece el valor en Menu
    public void setMaxCaloriesDiet(Integer maxCaloriesDiet) { this.maxCaloriesDiet = maxCaloriesDiet; }


    //Devuelve el total de calorías
    public Double getMaxCalories(Integer weightCalo) {
        Double caloCarbos = getTotalCarbos(dietList) * 4;
        Double caloFats = getTotalFats(dietList) * 9;
        Double caloProtes = getTotalProtein(dietList) * 4;
        return (caloCarbos + caloFats + caloProtes) * weightCalo/100;
    }

    //Devuelve el total de carbohidratos
    public Double getTotalCarbos(List<Meals> dietList) {
        Double sumCarbos = 0.0;

        for (int i = 0; i < dietList.size(); i++) {
            sumCarbos += dietList.get(i).getCarbos();
        }
        return sumCarbos;
    }

    //Devuelve el total de grasas
    public Double getTotalFats(List<Meals> dietList) {
        Double sumFats = 0.0;

        for (int i = 0; i < dietList.size(); i++) {
            sumFats += dietList.get(i).getFats();
        }
        return sumFats;
    }

    //Devuelve el total de proteinas
    public Double getTotalProtein(List<Meals> dietList) {
        Double sumProtein = 0.0;

        for (int i = 0; i < dietList.size(); i++) {
            sumProtein += dietList.get(i).getProteins();
        }
        return sumProtein;
    }

    //DIETA SIN LIMITE
    public void noLimitDiet(Meals meal) {
        dietList.add(meal);
        System.out.println("El alimento " + meal.getName() + " ha sido añadido correctamente");
    }

    public void showInfo() {
        System.out.println("Esta es su dieta actualmente:");
        for (Meals value : dietList) {
            System.out.println(value.getName() + ", " + value.getGrams() + " gramos");
            System.out.println("Grasas: " + value.getFats() + "g, Carbohidratos: " + value.getCarbos() + "g, Proteínas: " + value.getProteins() + "g");
        }//for

        Double totalCarbos = this.getTotalCarbos(dietList);
        Double totalFats = this.getTotalFats(dietList);
        Double totalProteins = this.getTotalProtein(dietList);

        System.out.println("Los macronutrientes de la dieta son: " +
                "Grasas: " + totalFats +"g, " +
                "Carbohidratos: " + totalCarbos + "g, " +
                "Proteínas: " +  totalProteins +"g");

    }
}