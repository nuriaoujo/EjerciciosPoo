package com.campusdual.Ejercicio3JuanjoV;

import com.campusdual.Ejercicio3JuanjoV.Patients.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageDiets {
    Menu menu;
    Scanner scanner = new Scanner(System.in);
    Scanner scannerName = new Scanner(System.in);

    public ManageDiets(Menu menu) {
        this.menu = menu;
    }
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
                menu.repeatAction();
                break;
            case 2:
                showDietList();
                menu.repeatAction();
                break;
            case 3:
                removeDiet();
                menu.repeatAction();
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
        menu.dietProgram.showMenuProgram();
    }

    public void showDietList() {
        System.out.println("BIENVENIDO AL GESTOR DE DATOS DE DIETAS");
        System.out.println("======================================");
        System.out.println("Estas son tus dietas registradas:");

        if(menu.dietList.isEmpty()) {
            System.out.println("ERROR: Todavía no tienes dietas registradas");
        } else {
            for(int i = 0 ; i < menu.dietList.size(); i++ ) {
                System.out.println((i + 1) + ". " + menu.dietList.get(i).getDietName());
            }
            System.out.println("Selecciona la dieta de la que necesitas más información: ");
            int dietSelected = scanner.nextInt();

            System.out.println("INFORMACIÓN DE LA DIETA");
            System.out.println(menu.dietList.get(dietSelected - 1).getDietName());
            System.out.println("======================================");
            for(int i = 0 ; i < menu.dietList.get(dietSelected - 1).intakes.size(); i++ ) {
                System.out.println((i + 1) + ". " +
                        menu.dietList.get(dietSelected - 1).intakes.get(i).getName() + ", " +
                        menu.dietList.get(dietSelected - 1).intakes.get(i).getGrams() + " gramos"
                );
            }
        }
    }

    public void removeDiet() {
        System.out.println("BIENVENIDO AL EDITOR DE DIETAS");
        System.out.println("======================================");
        System.out.println("Estas son tus dietas registradas:");

        if(menu.dietList.isEmpty()) {
            System.out.println("ERROR: Todavía no tienes dietas registradas");
        } else {
            for(int i = 0 ; i < menu.dietList.size(); i++ ) {
                System.out.println((i + 1) + ". " + menu.dietList.get(i).getDietName());
            }
            System.out.println("Selecciona la dieta que deseas eliminar: ");
            int dietSelected = scanner.nextInt();

            List<String> patientsContainingDiet = new ArrayList<>();
            for (Patient p : menu.patientsList) {
                if(p.weeklyDiet != null && p.weeklyDiet.containsValue(menu.dietProgram.diet.getDietName())){
                    patientsContainingDiet.add(p.getName() + ' ' + p.getLastName());
                }
            }

            if (!patientsContainingDiet.isEmpty()) {
                System.out.println("ERROR, debes borrarlo de la lista de dietas de los siguientes pacientes:");
                for (String patient : patientsContainingDiet) {
                    System.out.println(patient);
                }
            } else {
                menu.dietList.remove(dietSelected - 1);
            }

            System.out.println("Quieres visualizar los cambios? SI/NO");
            String showDietChanges = scannerName.nextLine();

            if(showDietChanges.equalsIgnoreCase("SI")) {
                System.out.println("Esta es tu dieta actualizada: ");
                for(int i = 0 ; i < menu.dietList.size(); i++ ) {
                    System.out.println((i + 1) + ". " + menu.dietList.get(i).getDietName());
                }
            }
        }
    }
}
