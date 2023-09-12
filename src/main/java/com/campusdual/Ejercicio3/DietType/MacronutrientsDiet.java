package com.campusdual.Ejercicio3.DietType;

import com.campusdual.Ejercicio3.DietType.Diet;
import com.campusdual.Ejercicio3.Food;
import com.campusdual.Ejercicio3.Meals;

public class MacronutrientsDiet extends Diet {

    private Double macroCarbo;
    private Double macroProte;
    private Double macroFats;
    private String genre;

    public void macroDiet(Meals meal) {
        Double calc = (10 * weight) + (6.25 * height) - (5 * age);

        if (isWomen) {
            Double metabolismWomen = calc + 5;
            macroCarbo = metabolismWomen * 45/100;
            macroProte = metabolismWomen * 35/100;
            macroFats = metabolismWomen * 25/100;
        } else {
            Double metabolismMan = calc + 161;
            macroCarbo = metabolismMan * 45/100;
            macroProte = metabolismMan * 35/100;
            macroFats = metabolismMan * 25/100;
        }

        if(meal.getCarbos() <= macroCarbo && meal.getProteins() <= macroProte && meal.getFats() <= macroFats) {
            if(getTotalCarbos(dietList) <= macroCarbo && getTotalProtein(dietList) <= macroProte && getTotalProtein(dietList) < macroFats) {
                dietList.add(meal);
                System.out.println("El alimento " + meal.getName() + " ha sido añadido correctamente");
            } else {
                System.out.println("ERROR, el alimento " + meal.getName() + " supera tu límite de macronutrientes");
            }
        } else {
            System.out.println("ERROR, el alimento " + meal.getName() + " supera tu límite de macronutrientes");
        }
    }

    public void showInfo() {

        System.out.println("Esta es su dieta actualmente:");
        for (Meals value : dietList) {
            System.out.println(value.getName() + ", " + value.getGrams() + " gramos");
        }//for
        System.out.println("Los macronutrientes de la dieta son: "
                + this.getTotalCarbos(dietList) + " carbohidratos,"
                + this.getTotalFats(dietList) + " grasas y "
                + this.getTotalProtein(dietList) + " proteínas");
        if(isWomen) {
            this.genre = "Mujer";
        } else {
            this.genre = "Hombre";
        }
        System.out.println("Los datos proporcionados al sistema son: \n"
                + "Género: " + genre
                + "\nEdad: " + age
                + "\nAltura: " + height
                + "\nPeso: " + weight);
    }
}
