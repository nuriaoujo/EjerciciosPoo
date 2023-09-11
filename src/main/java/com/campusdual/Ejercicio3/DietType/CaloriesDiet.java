package com.campusdual.Ejercicio3.DietType;

import com.campusdual.Ejercicio3.Food;

public class CaloriesDiet extends Diet {
    private Integer maxCaloriesDiet;
    public void setMaxCaloriesDiet(Integer maxCaloriesDiet) { this.maxCaloriesDiet = maxCaloriesDiet; }

    public void caloriesDiet(Food food){
        Integer foodCaloriesCase2 = food.getCalories(100);
        if(maxCaloriesDiet <= foodCaloriesCase2) {
            System.out.println("ERROR: el alimento " + food.getName() + " supera tu límite de calorías");
        } else {
            if(getMaxCalories(100) <= food.getCalories(100)) {
                dietList.add(food);
                System.out.println("El alimento " + food.getName() + " ha sido añadido correctamente");
            } else {
                System.out.println("ERROR: el alimento " + food.getName() + " supera tu límite de calorías");
            }
        }
    }
}
