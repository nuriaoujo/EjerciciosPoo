package com.campusdual.Ejercicio3;

import com.campusdual.Ejercicio3.DietType.CaloriesDiet;
import com.campusdual.Ejercicio3.DietType.Diet;
import com.campusdual.Ejercicio3.DietType.MacronutrientsDiet;
import com.campusdual.Ejercicio3.DietType.PersonalDiet;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Meals meal;
    Diet diet;
    PersonalDiet personalDiet;
    CaloriesDiet caloriesDiet;
    MacronutrientsDiet macronutrientsDiet;

    public ArrayList<Food> arrayFoods = new ArrayList<>();
    boolean isRunning = true;
    boolean dietCreated;
    Scanner scanner = new Scanner(System.in);
    Scanner scannerName = new Scanner(System.in);

public Menu(){
    diet = null;

    arrayFoods.add(new Food("zanahoria",12.0,0.0,1.0));
    arrayFoods.add(new Food("bistec",0.0,15.0,27.0));
    arrayFoods.add(new Food("lechuga",1.0,0.0,0.0));
    arrayFoods.add(new Food("queso fresco",1.0,23.0,24.0));
    arrayFoods.add(new Food("huevo",0.0,11.0,13.0));
    arrayFoods.add(new Food("boquerón",1.0,2.0,16.0));
    arrayFoods.add(new Food("salmón",0.0,12.0,18.0));
    arrayFoods.add(new Food("trufa",0.0,0.0,6.0));
    arrayFoods.add(new Food("lenteja",54.0,2.0,25.0));
}

public void startApp() {
    while (isRunning) {
        System.out.println("Hola! Selecciona qué quieres hacer");
        System.out.println( "1.Crear dieta (1)\n" +
                            "2.Añadir alimentos (2)\n" +
                            "3.Enseña información (3)\n" +
                            "4.Crear nuevo alimento(4)\n" +
                            "5.Salir(5)");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                createDiet();
                break;
            case 2:
                System.out.println ("Deseas añadir un alimento existente o crear uno?\n" +
                        "Añadir uno existente (1)\n" +
                        "Añadir uno nuevo (2)");
                int selectTypeAdd = scanner.nextInt();
                if(selectTypeAdd == 1) {
                    System.out.println("Estas son tus opciones (escoge un número):");
                    for (int i = 0; i < arrayFoods.size(); i++) {
                        System.out.println(i + ": " + arrayFoods.get(i).getName());
                    }

                    int foodSelected = scanner.nextInt();
                    if (foodSelected >= 0 && foodSelected < arrayFoods.size()) {
                        Food food = arrayFoods.get(foodSelected);
                        addFood(food);
                    } else {
                        System.out.println("Opción no válida. Por favor, selecciona una opción válida del 0 al 9.");
                    }
                } else if (selectTypeAdd == 2) {
                    System.out.println("Escribe el nombre del alimento nuevo");
                    String newFoodName = scannerName.nextLine();

                    System.out.println("Añade la cantidad de carbohidratos");
                    Double newFoodCarbo = scanner.nextDouble();

                    System.out.println("Añade la cantidad de grasas");
                    Double newFoodFat = scanner.nextDouble();

                    System.out.println("Añade la cantidad de proteínas");
                    Double newFoodProte = scanner.nextDouble();

                    Food newFood = new Food(newFoodName,newFoodCarbo,newFoodFat,newFoodProte);
                    arrayFoods.add(newFood);

                    int newFoodAdded = arrayFoods.size() - 1;
                    Food food = arrayFoods.get(newFoodAdded);
                    addFood(food);
                } else {
                    System.out.println("ERROR, no has seleccionado una opción válida");
                }

                break;
            case 3:
                if (diet == null) {
                    System.out.println("No hay una dieta creada");
                } else {
                    switch(diet.getDietType()) {
                        case 1:
                            System.out.println("Has escogido:");
                            System.out.println("DIETA SIN LÍMITES");
                            System.out.println("================================");
                            diet.showInfo();
                            break;
                        case 2:
                            System.out.println("Has escogido:");
                            System.out.println("DIETA POR CALORÍAS");
                            System.out.println("================================");
                            diet.showInfo();
                            break;
                        case 3:
                            System.out.println("Has escogido:");
                            System.out.println("DIETA POR MACRONUTRIENTES");
                            System.out.println("================================");
                            diet.showInfo();
                            break;
                        case 4:
                            System.out.println("Has escogido:");
                            System.out.println("DIETA PERSONALIZADA");
                            System.out.println("================================");
                            diet.showInfo();
                            break;
                    }
                }
                break;
            case 4:
                System.out.println("Escribe el nombre del alimento nuevo");
                String newFoodName = scannerName.nextLine();

                System.out.println("Añade la cantidad de carbohidratos");
                Double newFoodCarbo = scanner.nextDouble();

                System.out.println("Añade la cantidad de grasas");
                Double newFoodFat = scanner.nextDouble();

                System.out.println("Añade la cantidad de proteínas");
                Double newFoodProte = scanner.nextDouble();

                Food newFood = new Food(newFoodName,newFoodCarbo,newFoodFat,newFoodProte);
                arrayFoods.add(newFood);
                break;
            case 5:
                System.out.println("Hasta la próxima!");
                isRunning = false;
                break;
            default:
                System.out.println("Opción no válida. Por favor,selecciona otra");
        }
        if (isRunning) {
            System.out.println("Quieres realizar otra operación? (SI/NO)");
            String anotherOpAnswer = scannerName.nextLine();

            if (anotherOpAnswer.equalsIgnoreCase("NO")) {
                isRunning = false;
                System.out.println("Hasta la próxima!");
            }
        }
    }
}

//CREAR/REINICIAR DIETA
    public void createDiet() {
        if (diet != null) {
            System.out.println("Ya tienes una dieta creada");
            System.out.println("¿Quieres eliminar la dieta creada? (SI/NO)");
            String deleteAnswer = scannerName.nextLine();

            if (deleteAnswer.toUpperCase().equals("SI")) {
                System.out.println("La dieta ha sido eliminada.");
                diet = null;
                dietCreated = false;
            } else if (deleteAnswer.toUpperCase().equals("NO")) {
                System.out.println("El borrado de la dieta ha sido cancelado.");
            } else {
                System.out.println("Respuesta no válida");
            }
        } else {
            System.out.println("La dieta ha sido creada");
            diet = new Diet();

            System.out.println(
                    "Elige tu plan de dieta: \n" +
                    "1.Sin límite (1)\n" +
                    "2.Por calorías (2)\n" +
                    "3.por macronutrientes (3)\n" +
                    "4.Por datos personales(4)");
            int dietType = scanner.nextInt();
            diet.setDietType(dietType);

            switch (dietType) {
                case 1:
                    System.out.println("Has escogido: Sin límite");
                    break;

                case 2:
                    caloriesDiet = new CaloriesDiet();
                    System.out.println("Has escogido: Por calorías");

                    System.out.println("Establece tu máximo de calorías");
                    diet.setMaxCaloriesDiet(scanner.nextInt());
                    break;

                case 3:
                    macronutrientsDiet = new MacronutrientsDiet();
                    System.out.println("Has escogido: Por macronutrientes");
                    System.out.println("Selecciona tu género: mujer(1), hombre(2)");
                    int genero = scanner.nextInt();
                    if (genero == 1) {
                        System.out.println("Tu género se ha guardado correctamente");
                        diet.setWomen(true);
                    } else if (genero == 2) {
                        System.out.println("Tu género se ha guardado correctamente");
                        diet.setWomen(false);
                    } else {
                    System.out.println("ERROR, número no válido");
                    }//else-if

                    System.out.println("Escribe tu edad:");
                    diet.setAge(scanner.nextInt());

                    System.out.println("Escribe tu altura (en cm):");
                    diet.setHeight(scanner.nextInt());

                    System.out.println("Escribe tu peso (en kg):");
                    diet.setWeight(scanner.nextInt());

                    break;

                case 4:
                    personalDiet = new PersonalDiet();
                    System.out.println("Has escogido: Por datos personales");

                    System.out.println("Establece tu máximo de proteínas");
                    diet.setMaxProtein(scanner.nextInt());

                    System.out.println("Establece tu máximo de carbohidratos");
                    diet.setMaxCarbs(scanner.nextInt());

                    System.out.println("Establece tu máximo de grasas");
                    diet.setMaxFats(scanner.nextInt());
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

//AÑADIR UN ELEMENTO
    public void addFood(Food food) {
        meal = new Meals();

        System.out.println("Selecciona la cantidad de ingesta del alimento " + food.getName());
        meal.setGrams(scanner.nextInt());
        if (diet != null) {
            String newMealName = food.getName();

            Double protesMeals = (food.getProteins()/100) * meal.getGrams();
            Double fatsMeals = (food.getFats()/100) * meal.getGrams();
            Double carbosMeals = (food.getCarbos()/100) * meal.getGrams();

            Meals newMeal = new Meals(newMealName, protesMeals, fatsMeals, carbosMeals, meal.getGrams());
            switch (diet.getDietType()) {
                case 1:
                    diet.noLimitDiet(newMeal);
                    break;

                case 2:
                    caloriesDiet.caloriesDiet(newMeal);
                    break;

                case 3:
                    macronutrientsDiet.macroDiet(newMeal);
                    break;

                case 4:
                    personalDiet.personalDiet(newMeal);
                    break;

                default:
                    System.out.println("ERROR, reinicie su dieta");
                    break;
            }
        } else {
            System.out.println("ERROR: no puedes introducir alimentos en una dieta si crear");
        }
    }
}

