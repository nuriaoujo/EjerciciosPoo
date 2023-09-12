package com.campusdual.Ejercicio3.DietType;

import com.campusdual.Ejercicio3.DietType.Diet;
import com.campusdual.Ejercicio3.Food;
import com.campusdual.Ejercicio3.Meals;

public class PersonalDiet extends Diet {

    public void personalDiet(Meals meal) {
        if(meal.getProteins() <= maxProtein && meal.getCarbos() <= maxCarbs && meal.getFats() <= maxFats) {
            if(getTotalProtein(dietList) <= maxProtein && getTotalCarbos(dietList) <= maxCarbs && getTotalFats(dietList) <= maxFats) {
                dietList.add(meal);
                System.out.println("El alimento " + meal.getName() + " ha sido añadido correctamente");
            } else {
                System.out.println("ERROR, el alimento " + meal.getName() + " supera tu límite personal");
            }

        } else {
            System.out.println("ERROR, el alimento " + meal.getName() + " supera tu límite personal");
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
        System.out.println("Estos son tus valores máximos elegidos para tu dieta: \n" +
                "Carbohidratos máximos: " + maxCarbs +
                "\nProteínas máximas: " + maxProtein +
                "\nGrasas máximas: " + maxFats);
    }
}
