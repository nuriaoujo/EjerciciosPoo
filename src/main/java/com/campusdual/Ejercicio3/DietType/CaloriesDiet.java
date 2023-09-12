package com.campusdual.Ejercicio3.DietType;

import com.campusdual.Ejercicio3.Food;
import com.campusdual.Ejercicio3.Meals;

public class CaloriesDiet extends Diet {

    public void caloriesDiet(Meals meal){
        if(maxCaloriesDiet < meal.getMealsCalories()) {
            System.out.println("ERROR: el alimento " + meal.getName() + " supera tu límite de calorías");
        } else {
            if(getMaxCalories(meal.getGrams()) <= meal.getMealsCalories()) {
                System.out.println("ERROR: el alimento " + meal.getName() + " supera tu límite de calorías");
            } else {
                dietList.add(meal);
                System.out.println("El alimento " + meal.getName() + " ha sido añadido correctamente");
            }
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
        System.out.println("El número de calorías en tu dieta son : " + maxCaloriesDiet);
    }
}
