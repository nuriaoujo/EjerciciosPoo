package com.campusdual.Ejercicio3;

/*
* Escribe una clase dieta, que teniendo en cuenta una serie de alimentos, vaya sumando cantidades en gramos y
* calcule cuentas calorías, carbohidratos, proteinas y grasas genera la ingesta
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diet {
    public List<Food> dietList = new ArrayList<>();
    int dietType;
    private boolean isWomen;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Integer maxFats;
    private Integer maxCarbs;
    private Integer maxProtein;
    private Integer maxCaloriesDiet;
    private Food food;
    private Integer gr;
    private Double macroCarbo;
    private Double macroProte;
    private Double macroFats;

    Scanner scanner = new Scanner(System.in);

    //GET-SET
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

    public void setMaxFats(Integer maxFats) { this.maxFats = maxFats; }
    public void setMaxCarbs(Integer maxCarbs) { this.maxCarbs = maxCarbs; }
    public void setMaxProtein(Integer maxProtein) { this.maxProtein = maxProtein; }
    public void setMaxCaloriesDiet(Integer maxCaloriesDiet) { this.maxCaloriesDiet = maxCaloriesDiet; }

    //Crea una dieta con un máximo de estos tres valores
    // si se supera alguna de ellos cuando se adjunta un alimento se indicará cual y desplegará un error
public ArrayList<Integer> getMaxValuesDiet() {
    ArrayList<Integer> maxValues = new ArrayList<>();
    maxValues.add(maxProtein);
    maxValues.add(maxCarbs);
    maxValues.add(maxFats);
    return maxValues;
}

//Agrega un alimento y una cantidad en gramos
    public void addGrToFood(Food food,Integer gr) {
        this.food = food;
        this.gr = gr;
    }//addGrToFood

//Calcula el metabolismo basal en la persona y lo asigna como máximo de calorías en la dieta
    public void metabolismDiet (Boolean isWomen, Integer age, Integer height, Integer weight) {
        this.isWomen = isWomen;
        this.age = age;
        this.height = height;
        this.weight = weight;

        if(isWomen) {
            Double metabolismWomen = (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else {
            Double metabolismMan = (10 * weight) + (6.25 * height) - (5 * age) + 161;
        }//if-else
    }//Diet

    //Calcula el metabolismo basal en la persona y lo asigna como máximo de calorías en la dieta
   public void macronutrientesDiet (Boolean isWomen, Integer age, Integer height, Integer weight) {
        this.isWomen = isWomen;
        this.age = age;
        this.height = height;
        this.weight = weight;

        if (isWomen) {
            Double metabolismWomen = (10 * weight) + (6.25 * height) - (5 * age) + 5;
            macroCarbo = metabolismWomen * 45/100;
            macroProte = metabolismWomen * 35/100;
            macroFats = metabolismWomen * 25/100;
        } else {
            Double metabolismMan = (10 * weight) + (6.25 * height) - (5 * age) + 161;
            macroCarbo = metabolismMan * 45/100;
            macroProte = metabolismMan * 35/100;
            macroFats = metabolismMan * 25/100;
        }//if-else
    }

//Devuelve el total de calorías
    public Integer getMaxCalories(Integer weightCalo) {
        Integer caloCarbos = getTotalCarbos(dietList) * 4;
        Integer caloFats = getTotalFats(dietList) * 9;
        Integer caloProtes = getTotalProtein(dietList) * 4;
        return (caloCarbos + caloFats + caloProtes) * weightCalo/100;
    }//getTotalCalories

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
}//getTotalFats

//Devuelve el total de proteinas
    public Integer getTotalProtein(List<Food> dietList) {
        Integer sumProtein = 0;

        for (int i = 0; i < dietList.size(); i++) {
            sumProtein += dietList.get(i).getProteins();
        }
        return sumProtein;
    }//getTotalProtein

    //DIETAS addFood()
    public void noLimitDiet(Food food) {
        dietList.add(food);
        System.out.println("El alimento ha sido añadido correctamente");
    }//noLimitDiet

    public void caloriesDiet(Food food){
        Integer foodCaloriesCase2 = food.getCalories(100);
        if(maxCaloriesDiet <= foodCaloriesCase2) {
            System.out.println("ERROR: este alimento supera tu límite de calorías");
        } else {
            if(getMaxCalories(100) <= food.getCalories(100)) { //Revisar
                dietList.add(food);
                System.out.println("El alimento ha sido añadido correctamente");
            } else {
                System.out.println("ERROR: este alimento supera tu límite de calorías");
            }
        }//if-else
    }//caloriesDiet

    public void macroDiet(Food food) { //Revisar segundo if
        if(food.getCarbos() <= macroCarbo && food.getProteins() <= macroProte && food.getFats() <= macroFats) {
            if(getTotalCarbos(dietList) <= macroCarbo && getTotalProtein(dietList) <= macroProte && getTotalProtein(dietList) < maxFats) {
                dietList.add(food);
                System.out.println("El alimento ha sido añadido correctamente");
            } else {
                System.out.println("ERROR, este alimento supera tu límite de macronutrientes");
            }
        } else {
            System.out.println("ERROR, este alimento supera tu límite de macronutrientes");
        }//if-else
    }//macroDiet

    public void personalDiet(Food food) {
        if(food.getProteins() <= maxProtein && food.getCarbos() <= maxCarbs && food.getFats() <= maxFats) {
            if(getTotalProtein(dietList) <= maxProtein && getTotalCarbos(dietList) <= maxCarbs && getTotalFats(dietList) <= maxFats) {
                dietList.add(food);
                System.out.println("El alimento ha sido añadido correctamente");
            } else {
                System.out.println("ERROR, este alimento supera tu límite personal");
            }

        } else {
            System.out.println("ERROR, este alimento supera tu límite personal");
        }//if-else
    }//personalDiet

    //-2. Mostrar información: muestra calorías y macronutrientes de la dieta
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

    }//showInfo
}//Diet