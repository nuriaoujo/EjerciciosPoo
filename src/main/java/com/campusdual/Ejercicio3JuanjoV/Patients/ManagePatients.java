package com.campusdual.Ejercicio3JuanjoV.Patients;

import com.campusdual.Ejercicio3JuanjoV.Food;
import com.campusdual.Ejercicio3JuanjoV.Kb;
import com.campusdual.Ejercicio3JuanjoV.Menu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ManagePatients {
    Menu menu;
    List<String> weekDay = Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves" , "Viernes" , "Sábado" , "Domingo");

    public ManagePatients(Menu menu) {
        this.menu = menu;
    }

    public void patientManager() {
        System.out.println("Selecciona qué deseas hacer:");
        System.out.println( "1. Dar de alta a pacientes (1) \n" +
                            "2. Mostrar detalles de los pacientes (2) \n" +
                            "3. Asignar dietas a pacientes (3) \n" +
                            "4. Eliminar dietas a pacientes (4) \n" +
                            "5. Dar de baja a pacientes (5) \n" +
                            "6. Volver al menú principal");

        int patientManagerSelected = Kb.forceNextInt();

        switch (patientManagerSelected) {
            case 1:
                createPatient();
                break;
            case 2:
                showPatientsDetails();
                break;
            case 3:
                addDietToPatient();
                break;
            case 4:
                removeDietToPatient();
                break;
            case 5:
                dischargePatient();
                break;
            case 6:
                System.out.println("Estas seguro de que deseas volver a la pantalla de inicio? SI/NO");
                String backToMenu = Kb.nextLine();

                if (backToMenu.equalsIgnoreCase("SI")) {
                    menu.startApp();
                } else if (backToMenu.equalsIgnoreCase("NO")) {
                    patientManager();
                } else {
                    System.out.println("ERROR, no se ha entendido la respuesta");
                    patientManager();
                }
                break;
            default:
                System.out.println("ERROR, no has seleccionado una opción válida");
                patientManager();
                break;
        }
    }

    public void createPatient() {
        String newGenrePatient;

        System.out.println("BIENVENIDO AL REGISTRO DE PACIENTES");
        System.out.println("======================================");
        System.out.println("Escribe el nombre del paciente:");
        String newNamePatient = Kb.nextLine();

        System.out.println("Escribe los apellidos del paciente:");
        String newLastNamePatient = Kb.nextLine();

        System.out.println("Escribe el peso del paciente:");
        Integer newWeightPatient = Kb.forceNextInt();

        System.out.println("Escribe la altura del paciente:");
        Integer newHeightPatient = Kb.forceNextInt();

        System.out.println("Escribe la edad del paciente:");
        Integer newAgePatient = Kb.forceNextInt();

        System.out.println("Proporciona el género del paciente:");
        System.out.println("Mujer(1) , Hombre(2)");
        Integer isWomenPatient = Kb.getOption(1,2);
        if (isWomenPatient == 1) {
            newGenrePatient = "Mujer";
        } else {
            newGenrePatient = "Hombre";
        }

        Patient newPatient = new Patient(
                newNamePatient,
                newLastNamePatient,
                newWeightPatient,
                newHeightPatient,
                newAgePatient,
                newGenrePatient,
                new HashMap<>()
        );
        menu.patientsList.add(newPatient);
    }

    public void showPatientsDetails() {
        System.out.println("BIENVENIDO AL GESTOR DE DATOS DE PACIENTES");
        System.out.println("======================================");
        System.out.println("Estos son tus pacientes registrados:");

        if (menu.patientsList.isEmpty()) {
            System.out.println("ERROR: Todavía no tienes pacientes registrados");
        } else {
            for (int i = 0; i < menu.patientsList.size(); i++) {
                System.out.println((i + 1) + "." + menu.patientsList.get(i).getName() + " " + menu.patientsList.get(i).getLastName());
            }
            System.out.println("Selecciona al paciente del que necesitas más información: ");
            int patientSelected = Kb.forceNextInt();

            System.out.println("INFORMACIÓN SOBRE EL PACIENTE");
            System.out.println(menu.patientsList.get(patientSelected - 1).getName() + " " + menu.patientsList.get(patientSelected - 1).getLastName());
            System.out.println("======================================");
            if (menu.patientsList.get(patientSelected - 1).weeklyDiet.isEmpty()) {
                System.out.println("Todavía no existen datos del paciente " + menu.patientsList.get(patientSelected - 1).getName());
            } else {
                System.out.println("Estas son las dietas registradas para el paciente "
                        + menu.patientsList.get(patientSelected - 1).getName());

                System.out.println(menu.patientsList.get(patientSelected - 1).weeklyDiet);
            }
        }
    }

    public void addDietToPatient() {
        System.out.println("BIENVENIDO AL EDITOR DE DIETAS DE PACIENTES");
        System.out.println("======================================");
        System.out.println("Estos son tus pacientes registrados:");

        if (menu.patientsList.isEmpty()) {
            System.out.println("ERROR: Todavía no tienes pacientes registrados");
        } else {
            for (int i = 0; i < menu.patientsList.size(); i++) {
                System.out.println((i + 1) + "." + menu.patientsList.get(i).getName() + " " + menu.patientsList.get(i).getLastName());
            }
            System.out.println("Selecciona al que deseas añadirle una dieta: ");
            int patientSelected = Kb.forceNextInt();

            if (!menu.patientsList.get(patientSelected - 1).weeklyDiet.isEmpty()) {
                System.out.println("¿Quieres crear una nueva dieta o utilizar una existente?");
                System.out.println( "1. Dieta nueva (1)\n" +
                                    "2. Dieta existente (2)");
                int newOrExistentDiet = Kb.getOption(1,2);

                if (newOrExistentDiet == 1) {
                    menu.dietProgram.createMenu();
                    System.out.println("¿Quieres añadir un alimento a esta nueva dieta? SI/NO");
                    String newIntaketoDiet = Kb.nextLine();

                    boolean badAnswer;
                    boolean addNewIntake = true;

                    do {
                        if (newIntaketoDiet.equalsIgnoreCase("SI")) {
                            badAnswer = false;
                        } else if (newIntaketoDiet.equalsIgnoreCase("NO")) {
                            addNewIntake = false;
                            badAnswer = false;
                        } else {
                            System.out.println("ERROR, no se ha entendido la respuesta");
                            badAnswer = true;
                        }
                    } while (badAnswer);

                    while (addNewIntake) {
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
                        Food newFood = new Food(name, carbs, fats, proteins);
                        menu.dietProgram.validateAndAddFoodToDiet(newFood, grams);
                        menu.dietProgram.foodList.add(newFood);

                        System.out.println("¿Quieres añadir otro alimento? SI/NO");
                        String newQuestionIntaketoDiet = Kb.nextLine();
                        do {
                            if (newQuestionIntaketoDiet.equalsIgnoreCase("SI")) {
                                badAnswer = false;
                            } else if (newQuestionIntaketoDiet.equalsIgnoreCase("NO")) {
                                addNewIntake = false;
                                badAnswer = false;
                            } else {
                                System.out.println("ERROR, no se ha entendido la respuesta");
                                badAnswer = true;
                            }
                        } while (badAnswer);
                    }

                    System.out.println("======================================");
                    System.out.println("La nueva dieta ha sido creada");
                    System.out.println("¿En qué día de la semana quieres insertar la dieta?");
                    System.out.println( "1. Lunes (1) \n" +
                                        "2. Martes (2) \n" +
                                        "3. Miércoles (3) \n" +
                                        "4. Jueves (4) \n" +
                                        "5. Viernes (5) \n" +
                                        "6. Sábado (6) \n" +
                                        "7. Domingo (7) \n");
                    int daySelection = Kb.getOption(1,7);
                    menu.patientsList.get(patientSelected - 1).weeklyDiet.replace(weekDay.get(daySelection - 1), null, menu.dietProgram.diet.getDietName());

                } else {

                    System.out.println("Selecciona la dieta que quieres añadir");
                    if (menu.dietList.isEmpty()) {
                        System.out.println("ERROR: Todavía no tienes dietas registradas");
                    } else {
                        for (int i = 0; i < menu.dietList.size(); i++) {
                            System.out.println((i + 1) + ". " + menu.dietList.get(i).getDietName());
                        }
                        System.out.println("Selecciona la dieta que deseas añadir: ");
                        int dietSelected = Kb.forceNextInt();
                        System.out.println("¿En qué día de la semana quieres insertar la dieta?");
                        System.out.println("1. Lunes (1) \n" +
                                "2. Martes (2) \n" +
                                "3. Miércoles (3) \n" +
                                "4. Jueves (4) \n" +
                                "5. Viernes (5) \n" +
                                "6. Sábado (6) \n" +
                                "7. Domingo (7) \n");
                        int daySelection = Kb.getOption(1, 7);
                        menu.patientsList.get(patientSelected - 1).weeklyDiet.replace(weekDay.get(daySelection - 1), null, menu.dietList.get(dietSelected - 1).getDietName());

                    }
                }
            } else {
                System.out.println("Todavía no has iniciado la dieta de este paciente, será creada a continuación");
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(weekDay.get(0), null); //Lunes
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(weekDay.get(1), null); //Martes
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(weekDay.get(2), null); //Miércoles
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(weekDay.get(3), null); //Jueves
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(weekDay.get(4), null); //Viernes
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(weekDay.get(5), null); //Sábado
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(weekDay.get(6), null); //Domingo
                System.out.println("La dieta del paciente " + menu.patientsList.get(patientSelected - 1).getName() +
                        " " + menu.patientsList.get(patientSelected - 1).getLastName() + " ha sido creada");
            }
        }
    }

    public void removeDietToPatient() {
        System.out.println("BIENVENIDO AL EDITOR DE DIETAS DE PACIENTES");
        System.out.println("======================================");
        System.out.println("Estos son tus pacientes registrados:");

        if (menu.patientsList.isEmpty()) {
            System.out.println("ERROR: Todavía no tienes pacientes registrados");
        } else {
            for (int i = 0; i < menu.patientsList.size(); i++) {
                System.out.println((i + 1) + "." + menu.patientsList.get(i).getName() + " " +
                        menu.patientsList.get(i).getLastName());
            }
            System.out.println("Selecciona al que deseas eliminarle una dieta: ");
            int patientSelected = Kb.forceNextInt();

            if (menu.patientsList.get(patientSelected - 1).weeklyDiet.isEmpty()) {
                System.out.println("ERROR, el paciente elegido todavía no tiene registrada ninguna dieta");
                System.out.println("¿Deseas escoger otro paciente? SI/NO");
                String chooseOtherPatient = Kb.nextLine();

                if (chooseOtherPatient.equalsIgnoreCase("SI")) {
                    removeDietToPatient();
                } else if (chooseOtherPatient.equalsIgnoreCase("NO")) {
                    System.out.println(" ");
                } else {
                    System.out.println("ERROR, no se ha entendido la respuesta");
                    removeDietToPatient();
                }
            } else {
                System.out.println("Selecciona la dieta que quieres eliminar");
                System.out.println(menu.patientsList.get(patientSelected - 1).weeklyDiet);

                int removeSelection = Kb.forceNextInt();
                menu.patientsList.get(patientSelected - 1).weeklyDiet.replace(weekDay.get(removeSelection - 1), menu.dietProgram.diet.getDietName(), null);
            }
        }
    }

    public void dischargePatient() {
        System.out.println("BIENVENIDO AL PROGRAMA PARA DAR DE BAJA A PACIENTES");
        System.out.println("======================================");
        System.out.println("Estos son tus pacientes registrados:");

        if (menu.patientsList.isEmpty()) {
            System.out.println("ERROR: Todavía no tienes pacientes registrados");
        } else {
            for (int i = 0; i < menu.patientsList.size(); i++) {
                System.out.println((i + 1) + "." + menu.patientsList.get(i).getName() + " " +
                        menu.patientsList.get(i).getLastName());
            }
            System.out.println("Selecciona al paciente que deseas dar de baja: ");
            int patientSelected = Kb.forceNextInt();

            System.out.println("¿Estás seguro que deseas dar de baja a este paciente? SI/NO");
            System.out.println(menu.patientsList.get(patientSelected - 1).getName() + " " +
                    menu.patientsList.get(patientSelected - 1).getLastName());

            String dischargeOption = Kb.nextLine();

            if (dischargeOption.equalsIgnoreCase("SI")) {
                System.out.println("El paciente " + menu.patientsList.get(patientSelected - 1).getName() + " " +
                        menu.patientsList.get(patientSelected - 1).getLastName() + " ha sido eliminado");

                menu.patientsList.remove(menu.patientsList.get(patientSelected - 1));
            } else if (dischargeOption.equalsIgnoreCase("NO")) {
                System.out.println("Operación cancelada");
            } else {
                System.out.println("ERROR, no se ha entendido la respuesta");
                dischargePatient();
            }
        }
    }
}
