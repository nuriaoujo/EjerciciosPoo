package com.campusdual.Ejercicio3.DietType;

import com.campusdual.Ejercicio3.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diet {
    public List<Food> dietList = new ArrayList<>();
    int dietType;
    private Food food;
    private Integer gr;
    Scanner scanner = new Scanner(System.in);

    //GET-SET
    public int getDietType() { return dietType; }
    public void setDietType(int dietType) {this.dietType = dietType; }

    //Agrega un alimento y una cantidad en gramos
    public void addGrToFood(Food food,Integer gr) {
        this.food = food;
        this.gr = gr;
    }

    //Devuelve el total de calorías
    public Integer getMaxCalories(Integer weightCalo) {
        Integer caloCarbos = getTotalCarbos(dietList) * 4;
        Integer caloFats = getTotalFats(dietList) * 9;
        Integer caloProtes = getTotalProtein(dietList) * 4;
        return (caloCarbos + caloFats + caloProtes) * weightCalo/100;
    }

    //Devuelve el total de carbohidratos
    public Integer getTotalCarbos(List<Food> dietList) {
        Integer sumCarbos = 0;

        for (int i = 0; i < dietList.size(); i++) {
            sumCarbos += dietList.get(i).getCarbos();
        }
        return sumCarbos;
    }

    //Devuelve el total de grasas
    public Integer getTotalFats(List<Food> dietList) {
        Integer sumFats = 0;

        for (int i = 0; i < dietList.size(); i++) {
            sumFats += dietList.get(i).getFats();
        }
        return sumFats;
    }

    //Devuelve el total de proteinas
    public Integer getTotalProtein(List<Food> dietList) {
        Integer sumProtein = 0;

        for (int i = 0; i < dietList.size(); i++) {
            sumProtein += dietList.get(i).getProteins();
        }
        return sumProtein;
    }

    //DIETA SIN LIMITE
    public void noLimitDiet(Food food) {
        dietList.add(food);
        System.out.println("El alimento " + food.getName() + " ha sido añadido correctamente");
    }

    public void showInfo() {

        System.out.println("Esta es su dieta actualmente:");
        for (Food value : dietList) {
            System.out.println(value.getName());
        }//for
        System.out.println("Los macronutrientes de la dieta son: "
                + this.getTotalCarbos(dietList) + " carbohidratos,"
                + this.getTotalFats(dietList) + " grasas y "
                + this.getTotalProtein(dietList) + " proteínas");
        System.out.println("Selecciona el peso para obtener las calorías");
        int weightToCalo = scanner.nextInt();
        System.out.println("El número máximo de calorías son : " + this.getMaxCalories(weightToCalo));
    }
}