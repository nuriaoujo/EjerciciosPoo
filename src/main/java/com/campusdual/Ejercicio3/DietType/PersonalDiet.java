package com.campusdual.Ejercicio3.DietType;

import com.campusdual.Ejercicio3.DietType.Diet;
import com.campusdual.Ejercicio3.Food;

public class PersonalDiet extends Diet {
    private Integer maxFats;
    private Integer maxCarbs;
    private Integer maxProtein;

    public void setMaxFats(Integer maxFats) { this.maxFats = maxFats; }
    public void setMaxCarbs(Integer maxCarbs) { this.maxCarbs = maxCarbs; }
    public void setMaxProtein(Integer maxProtein) { this.maxProtein = maxProtein; }

    public void personalDiet(Food food) {
        if(food.getProteins() <= maxProtein && food.getCarbos() <= maxCarbs && food.getFats() <= maxFats) {
            if(getTotalProtein(dietList) <= maxProtein && getTotalCarbos(dietList) <= maxCarbs && getTotalFats(dietList) <= maxFats) {
                dietList.add(food);
                System.out.println("El alimento " + food.getName() + " ha sido añadido correctamente");
            } else {
                System.out.println("ERROR, el alimento " + food.getName() + " supera tu límite personal");
            }

        } else {
            System.out.println("ERROR, el alimento " + food.getName() + " supera tu límite personal");
        }
    }
}
