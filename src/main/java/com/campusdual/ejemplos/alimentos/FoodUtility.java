package com.campusdual.ejemplos.alimentos;

public class FoodUtility{
    public static void main(String[] args) {
        Food zanahoria = new Food(12,0,1);
        System.out.println("100 g Zanahoria: " + zanahoria.getCalories(100));

        Food bistec = new Food(0,15,27);
        System.out.println("100 g Bistec: " + bistec.getCalories(100));

        Food lechuga = new Food(1,0,0);
        lechuga.setCarbos(1);
        lechuga.setProteins(0);
        lechuga.setFats(0);
        System.out.println("100g Lechuga: " + lechuga.getCalories(100));

        System.out.println("100g de filete con patatas: " + Food.sumCalories(200,bistec,lechuga));
    }


}

