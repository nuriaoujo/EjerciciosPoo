package com.campusdual.Ejercicio3JuanjoV;

//--Teniendo en cuenta el programa anterior(ejercicio4):
//--Realiza los cambios necesarios para:
//  -La dieta ya no será única si no que se guardará en una lista de dietas. Esta lista tendrá un nombre para poder ser recuperado. Será necesario cambiar el menú para gestionar esta lista.
//  Ahora en ved de crear/reemplazar dieta lo que haremos será:
//    a- Agregar dieta: Añade una dieta a la lista. Podemos reutilizar el menú antiguo de crear/reemplazar
//    b- Mostrar detalles de dieta: Muestra los detalles de una dieta y permite modificarla
//    c- Eliminar dieta: Elimina una dieta de la lista(Siempre que no la tenga asignada un paciente)
//
//  -Se pueden dar de alta personas: Las personas tendrán los siguientes atributos: nombre, apellidos, peso, altura, edad y sexo.
//    -Las personas podrán tener asignadas una lista de dietas que se catalogarán de lunes a domingo sacadas de la lista de dietas anterior.
//    -Se agregara un apartado nuevo al menú de "Gestión de pacientes" con las siguientes funcionalidades:
//      1- Dar de alta un paciente : Agregará un paciente nuevo a la lista de pacientes
//      2- Mostrar detalles de un paciente : Mostrará el detalle de un paciente así como todas sus dietas listadas de Lunes a domingo
//      3- Asignar una dieta: Muestra la lista de dietas general y puede asignarle una a un día de la semana del paciente.
//      4- Dar de baja un paciente: Elimina los datos de un paciente(No borra sus dietas asignadas dado que pueden estar asignadas a otro paciente)

import com.campusdual.Ejercicio3JuanjoV.Patients.ManagePatients;
import com.campusdual.Ejercicio3JuanjoV.Patients.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Scanner scannerName = new Scanner(System.in);

    ManagePatients managePatients;
    ManageDiets manageDiets;
    public DietProgram dietProgram;

    public List<Diet> dietList = new ArrayList<>();
    public List<Patient> patientsList = new ArrayList<>();

    public Menu() {
        managePatients = new ManagePatients(this);
        manageDiets = new ManageDiets(this);
        dietProgram = new DietProgram(this);

        patientsList.add(new Patient("María", "Álvarez", 67, 168, 43, "Mujer", null));
        patientsList.add(new Patient("Joaquín", "Míguez", 87, 173, 27, "Hombre", null));

    }
    public void startApp() {
        System.out.println("Bienvenido a la Aplicación de Gestión de Dietas,¿qué deseas hacer?");
        System.out.println( "1. Gestionar dietas (1)\n" +
                            "2. Gestionar pacientes (2)\n" +
                            "3. Salir (3)");
        Integer menuSelection = scanner.nextInt();
        switch(menuSelection) {
            case 1:
                System.out.println("Has seleccionado: ");
                System.out.println("GESTIONAR DIETAS ");
                System.out.println("=====================================");
                manageDiets.dietsManager();
                break;
            case 2:
                System.out.println("Has seleccionado: ");
                System.out.println("GESTIONAR PACIENTES ");
                System.out.println("=====================================");
                managePatients.patientManager();
                break;
            case 3:
                System.out.println("¡Hasta la próxima!");
                break;
            default:
                break;
        }
    }

    public void repeatAction() {
        System.out.println("======================================");
        System.out.println("¿Quieres realizar otra operación? SI/NO");
        String repeatAction = scannerName.nextLine();

        if(repeatAction.equalsIgnoreCase("SI")) {
            startApp();
        } else if(repeatAction.equalsIgnoreCase("NO")) {
            System.out.println("¡Hasta la próxima!");
        } else {
            System.out.println("ERROR, no se ha entendido la respuesta");
            repeatAction();
        }
    }



}
