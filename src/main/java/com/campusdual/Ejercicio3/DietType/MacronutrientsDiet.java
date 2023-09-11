package com.campusdual.Ejercicio3.DietType;

import com.campusdual.Ejercicio3.DietType.Diet;
import com.campusdual.Ejercicio3.Food;

public class MacronutrientsDiet extends Diet {

    private boolean isWomen;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Double macroCarbo;
    private Double macroProte;
    private Double macroFats;

    public boolean isWomen() { return isWomen; }
    public void setWomen(boolean isWomen) { this.isWomen = isWomen; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Integer getHeight() { return height; }
    public void setHeight(Integer height) { this.height = height; }

    public Integer getWeight() { return weight; }
    public void setWeight(Integer weight) { this.weight = weight; }

    public void macronutrientsDiet (Boolean isWomen, Integer age, Integer height, Integer weight) {
        this.isWomen = isWomen;
        this.age = age;
        this.height = height;
        this.weight = weight;
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
    }

    public void macroDiet(Food food) {
        if(food.getCarbos() <= macroCarbo && food.getProteins() <= macroProte && food.getFats() <= macroFats) {
            if(getTotalCarbos(dietList) <= macroCarbo && getTotalProtein(dietList) <= macroProte && getTotalProtein(dietList) < macroFats) {
                dietList.add(food);
                System.out.println("El alimento " + food.getName() + " ha sido añadido correctamente");
            } else {
                System.out.println("ERROR, el alimento " + food.getName() + " supera tu límite de macronutrientes");
            }
        } else {
            System.out.println("ERROR, el alimento " + food.getName() + " supera tu límite de macronutrientes");
        }
    }
}
