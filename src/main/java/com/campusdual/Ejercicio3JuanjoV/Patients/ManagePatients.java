package com.campusdual.Ejercicio3JuanjoV.Patients;

import com.campusdual.Ejercicio3JuanjoV.*;

import java.util.HashMap;
import java.util.Scanner;

public class ManagePatients {
    Menu menu;

    Scanner scanner = new Scanner(System.in);
    Scanner scannerName = new Scanner(System.in);

    public ManagePatients(Menu menu) {
        this.menu = menu;
    }

    public void patientManager() {
        System.out.println("Selecciona qué deseas hacer:");
        System.out.println("1. Dar de alta a pacientes (1) \n" +
                "2. Mostrar detalles de los pacientes (2) \n" +
                "3. Asignar dietas a pacientes (3) \n" +
                "4. Eliminar dietas a pacientes (4) \n" +
                "5. Dar de baja a pacientes (5) \n" +
                "6. Volver al menú principal");

        int patientManagerSelected = scanner.nextInt();

        switch (patientManagerSelected) {
            case 1:
                createPatient();
                menu.repeatAction();
                break;
            case 2:
                showPatientsDetails();
                menu.repeatAction();
                break;
            case 3:
                addDietToPatient();
                menu.repeatAction();
                break;
            case 4:
                removeDietToPatient();
                menu.repeatAction();
                break;
            case 5:
                dischargePatient();
                menu.repeatAction();
                break;
            case 6:
                System.out.println("Estas seguro de que deseas volver a la pantalla de inicio? SI/NO");
                String backToMenu = scannerName.nextLine();

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
        String newGenrePatient = null;
        boolean requestDeclined = true;

        System.out.println("BIENVENIDO AL REGISTRO DE PACIENTES");
        System.out.println("======================================");
        System.out.println("Escribe el nombre del paciente:");
        String newNamePatient = scannerName.nextLine();

        System.out.println("Escribe los apellidos del paciente:");
        String newLastNamePatient = scannerName.nextLine();

        System.out.println("Escribe el peso del paciente:");
        Integer newWeightPatient = scanner.nextInt();

        System.out.println("Escribe la altura del paciente:");
        Integer newHeightPatient = scanner.nextInt();

        System.out.println("Escribe la edad del paciente:");
        Integer newAgePatient = scanner.nextInt();

        do {
            System.out.println("Proporciona el género del paciente:");
            System.out.println("Mujer(1) , Hombre(2)");
            Integer isWomenPatient = scanner.nextInt();
            if (isWomenPatient == 1) {
                newGenrePatient = "Mujer";
                requestDeclined = false;
            } else if (isWomenPatient == 2) {
                newGenrePatient = "Hombre";
                requestDeclined = false;
            } else {
                System.out.println("ERROR, el valor proporcionado no se encuentra entre 1-2. Inténtelo de nuevo");
            }
        } while (requestDeclined);

        Patient newPatient = new Patient(
                newNamePatient,
                newLastNamePatient,
                newWeightPatient,
                newHeightPatient,
                newAgePatient,
                newGenrePatient,
                null
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
            int patientSelected = scanner.nextInt();

            System.out.println("INFORMACIÓN SOBRE EL PACIENTE");
            System.out.println(menu.patientsList.get(patientSelected - 1).getName() + " " + menu.patientsList.get(patientSelected - 1).getLastName());
            System.out.println("======================================");
            if (menu.patientsList.get(patientSelected - 1).weeklyDiet == null) {
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
            int patientSelected = scanner.nextInt();

            if (menu.patientsList.get(patientSelected - 1).weeklyDiet == null) {
                menu.patientsList.get(patientSelected - 1).weeklyDiet = new HashMap<>();
            }
            if (menu.patientsList.get(patientSelected - 1).weeklyDiet.containsKey(1)) {
                System.out.println("¿Quieres crear una nueva dieta o utilizar una existente?");
                System.out.println("1. Dieta nueva (1)\n" +
                        "2. Dieta existente (2)");
                int newOrExistentDiet = scanner.nextInt();

                if (newOrExistentDiet == 1) {
                    menu.dietProgram.createMenu();
                    System.out.println("¿Quieres añadir un alimento a esta nueva dieta? SI/NO");
                    String newIntaketoDiet = scannerName.nextLine();

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
                        String newQuestionIntaketoDiet = scannerName.nextLine();
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
                    System.out.println("1. Lunes (1) \n" +
                            "2. Martes (2) \n" +
                            "3. Miércoles (3) \n" +
                            "4. Jueves (4) \n" +
                            "5. Viernes (5) \n" +
                            "6. Sábado (6) \n" +
                            "7. Domingo (7) \n");
                    int daySelection = scanner.nextInt();

                    if (daySelection > 7 || daySelection == 0) {
                        System.out.println("ERROR, el valor proporcionado no se encuentra entre 1-7");
                    } else {
                        menu.patientsList.get(patientSelected - 1).weeklyDiet.replace(daySelection, null, menu.dietProgram.diet.getDietName());
                    }
                } else if (newOrExistentDiet == 2) {
                    System.out.println("Selecciona la dieta que quieres añadir");
                    if (menu.dietList.isEmpty()) {
                        System.out.println("ERROR: Todavía no tienes dietas registradas");
                    } else {
                        for (int i = 0; i < menu.dietList.size(); i++) {
                            System.out.println((i + 1) + ". " + menu.dietList.get(i).getDietName());
                        }
                        System.out.println("Selecciona la dieta que deseas añadir: ");
                        int dietSelected = scanner.nextInt();
                        System.out.println("¿En qué día de la semana quieres insertar la dieta?");
                        System.out.println("1. Lunes (1) \n" +
                                "2. Martes (2) \n" +
                                "3. Miércoles (3) \n" +
                                "4. Jueves (4) \n" +
                                "5. Viernes (5) \n" +
                                "6. Sábado (6) \n" +
                                "7. Domingo (7) \n");
                        int daySelection = scanner.nextInt();

                        if (daySelection > 7 || daySelection == 0) {
                            System.out.println("ERROR, el valor proporcionado no se encuentra entre 1-7");
                        } else {
                            menu.patientsList.get(patientSelected - 1).weeklyDiet.replace(daySelection, null, menu.dietList.get(dietSelected - 1).getDietName());
                        }
                    }
                } else {
                    System.out.println("ERROR, el valor proporcionado no se encuentra entre 1-2. Inténtelo de nuevo");
                }
            } else {
                System.out.println("Todavía no has iniciado la dieta de este paciente, será creada a continuación");
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(1, null); //Lunes
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(2, null); //Martes
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(3, null); //Miércoles
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(4, null); //Jueves
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(5, null); //Viernes
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(6, null); //Sábado
                menu.patientsList.get(patientSelected - 1).weeklyDiet.put(7, null); //Domingo
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
            int patientSelected = scanner.nextInt();

            if (menu.patientsList.get(patientSelected - 1).weeklyDiet.isEmpty()) {
                System.out.println("ERROR, el paciente elegido todavía no tiene registrada ninguna dieta");
                System.out.println("¿Deseas escoger otro paciente? SI/NO");
                String chooseOtherPatient = scannerName.nextLine();

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

                int removeSelection = scanner.nextInt();
                menu.patientsList.get(patientSelected - 1).weeklyDiet.replace(removeSelection, menu.dietProgram.diet.getDietName(), null);
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
            int patientSelected = scanner.nextInt();

            System.out.println("¿Estás seguro que deseas dar de baja a este paciente? SI/NO");
            System.out.println(menu.patientsList.get(patientSelected - 1).getName() + " " +
                    menu.patientsList.get(patientSelected - 1).getLastName());

            String dischargeOption = scannerName.nextLine();

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
