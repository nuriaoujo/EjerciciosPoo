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
import com.campusdual.Ejercicio3JuanjoV.Patients.Patients;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    ManagePatients managePatients;
    ManageDiets manageDiets;
    Patients patients;

    public Menu() {
        managePatients = new ManagePatients();
        manageDiets = new ManageDiets();
        patients = new Patients();
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

}
