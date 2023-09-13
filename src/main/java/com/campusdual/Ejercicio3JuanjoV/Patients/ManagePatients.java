package com.campusdual.Ejercicio3JuanjoV.Patients;

import com.campusdual.Ejercicio3JuanjoV.Diet;
import com.campusdual.Ejercicio3JuanjoV.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagePatients {
    Menu menu;
    Patients patients;
    Scanner scanner = new Scanner(System.in);
    Scanner scannerName = new Scanner(System.in);

    public void patientManager() {
        System.out.println("Selecciona qué deseas hacer:");
        System.out.println("1. Dar de alta a pacientes (1) \n" +
                            "2. Mostrar detalles de los pacientes (2) \n" +
                            "3. Asignar dietas a pacientes (3) \n" +
                            "4. Eliminar dietas a pacientes (4) \n" + //Todo decidir si eliminar todos los datos o solamente uno
                            "5. Dar de baja a pacientes (5) \n" +
                            "6. Volver al menú principal");

        int patientManagerSelected = scanner.nextInt();
        patients = new Patients();
        switch(patientManagerSelected) {
            case 1:
                patients.createPatient();
                repeatAction();
                break;
            case 2:
                patients.showPatientsDetails();
                repeatAction();
                break;
            case 3:
                patients.addDietToPatient();
                repeatAction();
                break;
            case 4:
                patients.removeDietToPatient();
                repeatAction();
                break;
            case 5:
                patients.dischargePatient();
                repeatAction();
                break;
            case 6:
                System.out.println("Estas seguro de que deseas volver a la pantalla de inicio? SI/NO");
                String backToMenu = scannerName.nextLine();

                if(backToMenu.equalsIgnoreCase("SI")) {
                    menu.startApp();
                } else if(backToMenu.equalsIgnoreCase("NO")) {
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

    public void repeatAction() {
        System.out.println("======================================");
        System.out.println("¿Quieres realizar otra operación? SI/NO");
        String repeatAction = scannerName.nextLine();

        if(repeatAction.equalsIgnoreCase("SI")) {
            menu.startApp();
        } else if(repeatAction.equalsIgnoreCase("NO")) {
            System.out.println("Hasta la próxima!");
        } else {
            System.out.println("ERROR, no se ha entendido la respuesta");
            repeatAction();
        }
    }
}