package com.campusdual.Ejercicio3JuanjoV;

import com.campusdual.Ejercicio3JuanjoV.exceptions.MaxCaloriesReachedException;
import com.campusdual.Ejercicio3JuanjoV.exceptions.MaxCarbsReachedException;
import com.campusdual.Ejercicio3JuanjoV.exceptions.MaxFatsReachedException;
import com.campusdual.Ejercicio3JuanjoV.exceptions.MaxProteinsReachedException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

public class DietProgram {
    Menu menu;

    public Diet diet = null;

    public List<Food> foodList;

    public DietProgram(Menu menu) {

        foodList = new ArrayList<>();
        this.menu = menu;
    }

    public void showMenuProgram(){
        System.out.println("########################################################");
        System.out.println("################# Programa de dietas ###################");
        System.out.println("########################################################");
        Integer option;
        do{
            System.out.println("Escriba una opción:");
            System.out.println("===================================");
            System.out.println("1-Crear una nueva dieta");
            System.out.println("2-Mostrar información de esta dieta");
            System.out.println("3-Agregar alimento a la dieta actual");
            System.out.println("4-Retroceder a la ventana anterior");
            option = Kb.getOption(1,4);
            switch (option){
                case 1:
                    createMenu();
                    break;
                case 2:
                    showDetailsMenu();
                    break;
                case 3:
                    addFoodMenu();
                    break;
                case 4:
                    System.out.println("Gracias por usar el programa, volverás al Gestor de Dietas");
                    break;
            }
        }while(option != 4);
    }

    public void addFoodMenu() {
        if(this.diet==null){
            System.out.println("Para agregar alimentos hace falta iniciar una dieta");
            return;
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Agregar Alimentos a la dieta");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Escriba una opción:");
        System.out.println("===================================");
        System.out.println("1-Agregar un nuevo alimento");
        System.out.println("2-Agregar un alimento ya existente");

        Integer option = Kb.getOption(1,2);
        switch (option){
            case 1:
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Datos de nuevo alimento");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Nombre del alimento:");
                String name = Kb.nextLine();
                System.out.println("Carbohidratos:");
                Integer carbs = Kb.forceNextInt();
                System.out.println("Grasas:");
                Integer fats = Kb.forceNextInt();
                System.out.println("Proteínas:");
                Integer proteins = Kb.forceNextInt();
                System.out.println("Gramos:");
                Integer grams = Kb.forceNextInt();
                Food newFood = new Food(name,carbs,fats,proteins);
                validateAndAddFoodToDiet(newFood,grams);
                foodList.add(newFood);
                break;
            case 2:
                if(foodList.isEmpty()){
                    System.out.println("Para agregar un alimento existente, tienen que existir alimentos previos");
                    return;
                }
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Escoja un alimento");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                Integer i = 1;
                for(Food food:foodList){
                    System.out.println(i+"- "+food.getName());
                    i++;
                }
                System.out.println(i+"- Cancelar");
                Integer element = Kb.getOption(1,i);
                if(Objects.equals(element, i)){
                    System.out.println("Cancelando alimento");
                    return;
                }
                Food storedFood = foodList.get(element-1);
                System.out.println("indique el número de gramos de "+storedFood.getName());
                Integer foodGrams = Kb.forceNextInt();
                validateAndAddFoodToDiet(storedFood,foodGrams);
                break;
        }
    }

    public void validateAndAddFoodToDiet(Food food, Integer grams){
        try{
            this.diet.addFood(food,grams);
        }catch (MaxCaloriesReachedException ecal){
            System.out.println("Se ha alcanzado el máximo valor de calorías permitido");
        }catch (MaxCarbsReachedException ecar){
            System.out.println("Se ha alcanzado el máximo valor de carbohidratos permitido");
        }catch (MaxFatsReachedException efat){
            System.out.println("Se ha alcanzado el máximo valor de grasas permitido");
        }catch (MaxProteinsReachedException epro){
            System.out.println("Se ha alcanzado el máximo valor de proteínas permitido");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createMenu() {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Crear nueva dieta");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Escriba una opción:");
        System.out.println("===================================");
        System.out.println("1-Dieta sin límite");
        System.out.println("2-Dieta por calorías");
        System.out.println("3-Dieta por macronutrientes");
        System.out.println("4-Dieta por datos personales");
        Integer option = Kb.getOption(1,4);
        switch (option){
            case 1:
                System.out.println("Establece el nombre de la dieta");
                String dietName1 = Kb.nextLine();
                this.diet = new Diet(dietName1);

                System.out.println("Se ha creado una dieta sin límites");
                menu.dietList.add(diet);
                break;
            case 2:
                System.out.println("Establece el nombre de la dieta");
                String dietName2 = Kb.nextLine();

                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Escriba número de calorias");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                Integer calories = Kb.forceNextInt();
                this.diet = new Diet(dietName2, calories);

                System.out.println("Se ha creado una dieta con "+calories+" calorías máximas");
                menu.dietList.add(diet);
                break;
            case 3:
                System.out.println("Establece el nombre de la dieta");
                String dietName3 = Kb.nextLine();

                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Escriba los macronutrientes");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Carbohidratos:");
                Integer carbs = Kb.forceNextInt();
                System.out.println("Grasas:");
                Integer fats = Kb.forceNextInt();
                System.out.println("Proteínas:");
                Integer proteins = Kb.forceNextInt();
                this.diet = new Diet(dietName3,fats,carbs,proteins);

                System.out.println("Se ha creado una dieta con Carbohidratos:"+carbs+", Grasas:"+fats+" ,Proteínas:"+proteins);
                menu.dietList.add(diet);
                break;
            case 4:
                System.out.println("Establece el nombre de la dieta");
                String dietName4 = Kb.nextLine();

                Integer weight;
                Integer height;
                Integer age;
                String sexCharacter;

                System.out.println("¿Deseas obtener automáticamente los datos de un paciente o escribirlos manualmente?");
                System.out.println( "1. Obtener datos del paciente \n" +
                                    "2. Escribir datos manualmente");
                Integer getPatientInfo = Kb.getOption(1,2);

                if(getPatientInfo == 1){
                    System.out.println("Selecciona al paciente");
                    for(int i = 0; i < menu.patientsList.size(); i++) {
                        System.out.println((i + 1) + ". " + menu.patientsList.get(i).getName() + " " + menu.patientsList.get(i).getLastName());
                    }
                    Integer selectPatient = Kb.forceNextInt();
                    weight = menu.patientsList.get(selectPatient - 1).getWeight();
                    height = menu.patientsList.get(selectPatient - 1).getHeight();
                    age = menu.patientsList.get(selectPatient - 1).getAge();

                    if(menu.patientsList.get(selectPatient - 1).getGenre().equalsIgnoreCase("Mujer")){
                        sexCharacter = "m";
                    } else {
                        sexCharacter = "h";
                    }

                    this.diet = new Diet(dietName4,"m".equalsIgnoreCase(sexCharacter),age,height,weight);

                } else {

                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Escriba los datos personales del paciente");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Peso:");
                    weight = Kb.forceNextInt();
                    System.out.println("Altura:");
                    height = Kb.forceNextInt();
                    System.out.println("Edad:");
                    age = Kb.forceNextInt();
                    System.out.println("Mujer u Hombre(m/h):");
                    sexCharacter = Kb.nextLine();
                    this.diet = new Diet(dietName4, "m".equalsIgnoreCase(sexCharacter), age, height, weight);

                    System.out.println("Se ha creado una dieta de " + this.diet.getMaxCalories() + " calorías máximas");
                    menu.dietList.add(diet);
                    break;
                }
        }
    }

    private void showDetailsMenu() {
        if(this.diet!=null){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Detalles de la dieta");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            if(this.diet.getMaxCalories()!=null){
                System.out.println("El número máximo de calorías es:"+this.diet.getMaxCalories());
            }
            if(this.diet.getMaxCarbs() != null || this.diet.getMaxFats() != null || this.diet.getMaxProteins() != null){
                System.out.println("Los valores máximos de macronutrientes son: Carbohidratos:"+this.diet.getMaxCarbs()+" , Grasas:"+this.diet.getMaxFats()+" , Proteinas:"+this.diet.getMaxProteins());
            }
            System.out.println("Número de alimentos de la dieta:"+this.diet.getFoodNumber());
            System.out.println("Calorías:"+this.diet.getTotalCalories());
            System.out.println("Carbohidratos:"+this.diet.getTotalCarbs());
            System.out.println("Grasas:"+this.diet.getTotalFats());
            System.out.println("Proteínas:"+this.diet.getTotalProteins());
            System.out.println("Alimentos de la dieta:"+this.diet.getDietIntakes());
        }else{
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("La dieta no esta iniciada");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }
}
