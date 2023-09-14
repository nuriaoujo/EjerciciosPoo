package com.campusdual.Ejercicio3JuanjoV;

import com.campusdual.Ejercicio3JuanjoV.Patients.ManagePatients;
import com.campusdual.Ejercicio3JuanjoV.Patients.Patients;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageDiets {
    Menu menu;
    DietProgram dietProgram;
    ManagePatients managePatients;
    Scanner scanner = new Scanner(System.in);
    Scanner scannerName = new Scanner(System.in);

    public void dietsManager() {
        System.out.println("Selecciona qué deseas hacer: ");
        System.out.println( "1. Agregar una dieta nueva (1) \n" +
                            "2. Mostrar detalles de las dietas (2) \n" +
                            "3. Eliminar una dieta (3) \n" +
                            "4. Volver al menú principal");

        int dietManagerSelected = scanner.nextInt();

        switch (dietManagerSelected) {
            case 1:
                newDiet();
                repeatAction();
                break;
            case 2:
                showDietList();
                repeatAction();
                break;
            case 3:
                removeDiet();
                repeatAction();
                break;
            case 4:
                System.out.println("Estas seguro de que deseas volver a la pantalla de inicio? SI/NO");
                String backToMenu = scannerName.nextLine();

                if(backToMenu.equalsIgnoreCase("SI")) {
                    menu.startApp();
                } else if(backToMenu.equalsIgnoreCase("NO")) {
                    dietsManager();
                } else {
                    System.out.println("ERROR, no se ha entendido la respuesta");
                    dietsManager();
                }
                break;
            default:
                System.out.println("ERROR, no has seleccionado una opción válida");
                dietsManager();
                break;
        }
    }
    public void newDiet() {
        if(dietProgram == null) {
            dietProgram = new DietProgram();
        }
        dietProgram.showMenuProgram();
    }

    public void showDietList() {
        System.out.println("BIENVENIDO AL GESTOR DE DATOS DE DIETAS");
        System.out.println("======================================");
        System.out.println("Estas son tus dietas registradas:");

        if(dietProgram.dietList.size() == 0) {
            System.out.println("ERROR: Todavía no tienes dietas registradas");
        } else {
            for(int i = 0 ; i < dietProgram.dietList.size(); i++ ) {
                System.out.println((i + 1) + ". " + dietProgram.dietList.get(i).getDietName());
            }
            System.out.println("Selecciona la dieta de la que necesitas más información: ");
            int dietSelected = scanner.nextInt();

            System.out.println("INFORMACIÓN DE LA DIETA");
            System.out.println(dietProgram.dietList.get(dietSelected - 1).getDietName());
            System.out.println("======================================");
            for(int i = 0 ; i < dietProgram.dietList.get(dietSelected - 1).intakes.size(); i++ ) {
                System.out.println((i + 1) + ". " +
                        dietProgram.dietList.get(dietSelected - 1).intakes.get(i).getName() + ", " +
                        dietProgram.dietList.get(dietSelected - 1).intakes.get(i).getGrams() + " gramos"
                );
            }
        }
    }

    public void removeDiet() {
        System.out.println("BIENVENIDO AL EDITOR DE DIETAS");
        System.out.println("======================================");
        System.out.println("Estas son tus dietas registradas:");

        if(dietProgram.dietList.size() == 0) {
            System.out.println("ERROR: Todavía no tienes dietas registradas");
        } else {
            for(int i = 0 ; i < dietProgram.dietList.size(); i++ ) {
                System.out.println((i + 1) + ". " + dietProgram.dietList.get(i).getDietName());
            }
            System.out.println("Selecciona la dieta que deseas eliminar: ");
            int dietSelected = scanner.nextInt();

            dietProgram.dietList.remove(dietSelected - 1);
            //TODO si la dieta esta asignada a un paciente NO se puede borrar aqui
            System.out.println("Quieres visualizar los cambios? SI/NO");
            String showDietChanges = scannerName.nextLine();

            if(showDietChanges.equalsIgnoreCase("SI")) {
                System.out.println("Esta es tu dieta actualizada: ");
                for(int i = 0 ; i < dietProgram.dietList.size(); i++ ) {
                    System.out.println((i + 1) + ". " + dietProgram.dietList.get(i).getDietName());
                }
            }
        }
    }

    public void repeatAction() {
        System.out.println("======================================");
        System.out.println("¿Quieres realizar otra operación? SI/NO");
        String repeatAction = scannerName.nextLine();

        if(repeatAction.equalsIgnoreCase("SI")) {
            System.out.println("Elige qué operación deseas hacer:");
            System.out.println("1. Gestionar dietas (1) \n" +
                    "2. Gestionar pacientes (2)");
            int continueOption = scanner.nextInt();
            switch (continueOption) {
                case 1:
                    dietsManager();
                    break;
                case 2:
                    managePatients.patientManager();
                    break;
                default:
                    System.out.println("ERROR, no se ha excogido una opción válida");
                    repeatAction();
                    break;
            }
        } else if(repeatAction.equalsIgnoreCase("NO")) {
            System.out.println("¡Hasta la próxima!");
        } else {
            System.out.println("ERROR, no se ha entendido la respuesta");
            repeatAction();
        }
    }

}
