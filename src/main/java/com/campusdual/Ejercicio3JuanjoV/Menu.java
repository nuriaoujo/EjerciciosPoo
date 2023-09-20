package com.campusdual.Ejercicio3JuanjoV;
import com.campusdual.Ejercicio3JuanjoV.Patients.ManagePatients;
import com.campusdual.Ejercicio3JuanjoV.Patients.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {
    ManagePatients managePatients;
    ManageDiets manageDiets;
    public DietProgram dietProgram;

    public List<Diet> dietList = new ArrayList<>();
    public List<Patient> patientsList = new ArrayList<>();

    public Menu() {
        managePatients = new ManagePatients(this);
        manageDiets = new ManageDiets(this);
        dietProgram = new DietProgram(this);

        patientsList.add(new Patient("María", "Álvarez", 67, 168, 43, "Mujer", new HashMap<>()));
        patientsList.add(new Patient("Joaquín", "Míguez", 87, 173, 27, "Hombre", new HashMap<>()));

    }
    public void startApp() {
        Integer menuSelection;
        String repeatAction;
        do {
            System.out.println("Bienvenido a la Aplicación de Gestión de Dietas,¿qué deseas hacer?");
            System.out.println("1. Gestionar dietas (1)\n" +
                    "2. Gestionar pacientes (2)\n" +
                    "3. Salir (3)");
            menuSelection = Kb.forceNextInt();

            switch (menuSelection) {
                case 1:
                    System.out.println("Has seleccionado: ");
                    System.out.println("GESTIONAR DIETAS ");
                    System.out.println("=====================================");
                    manageDiets.dietsManager();

                    System.out.println("======================================");
                    System.out.println("¿Quieres realizar otra operación? SI/NO");
                    repeatAction = Kb.nextLine();

                    if(repeatAction.equalsIgnoreCase("SI")) {
                        System.out.println("=====================================");
                    } else if(repeatAction.equalsIgnoreCase("NO")) {
                        System.out.println("¡Hasta la próxima!");
                        menuSelection = 3;
                    } else {
                        System.out.println("ERROR, no se ha entendido la respuesta");
                    }
                    break;
                case 2:
                    System.out.println("Has seleccionado: ");
                    System.out.println("GESTIONAR PACIENTES ");
                    System.out.println("=====================================");
                    managePatients.patientManager();

                    System.out.println("======================================");
                    System.out.println("¿Quieres realizar otra operación? SI/NO");
                    repeatAction = Kb.nextLine();

                    if(repeatAction.equalsIgnoreCase("SI")) {
                        System.out.println("=====================================");
                    } else if(repeatAction.equalsIgnoreCase("NO")) {
                        System.out.println("¡Hasta la próxima!");
                        menuSelection = 3;
                    } else {
                        System.out.println("ERROR, no se ha entendido la respuesta");
                    }
                    break;
                case 3:
                    System.out.println("¡Hasta la próxima!");
                    break;
                default:
                    break;
            }
        }while (menuSelection != 3);
    }

    public void repeatAction() {

    }
}
