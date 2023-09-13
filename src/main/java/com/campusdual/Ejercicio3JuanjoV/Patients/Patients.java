package com.campusdual.Ejercicio3JuanjoV.Patients;

import com.campusdual.Ejercicio3JuanjoV.Diet;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patients {
    List <Patients> patientsList = new ArrayList<>();
    List <Diet> weeklyDiet;
    Scanner scanner =  new Scanner(System.in);
    Scanner scannerName =  new Scanner(System.in);
    private boolean requestDeclined;

    private String name;
    private String lastName;
    private Integer weight;
    private Integer height;
    private Integer age;
    private String genre;
    private String newGenrePatient;

    public String getName() { return name; }
    public String getLastName() { return lastName; }

    public Patients(){
        patientsList.add(new Patients("María", "Álvarez", 67, 168, 43, "Mujer", null));
        patientsList.add(new Patients("Joaquín", "Míguez", 87, 173, 27, "Hombre", null));
    }

    public Patients(String name, String lastName, Integer weight, Integer height, Integer age, String genre, List weeklyDiet) {
        this.name = name;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.genre = genre;
        this.weeklyDiet = weeklyDiet;
    }

    public void createPatient() {
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

        while(requestDeclined) {
            System.out.println("Proporciona el género del paciente:");
            System.out.println("Mujer(1) , Hombre(2)");
            Integer isWomenPatient = scanner.nextInt();
            if(isWomenPatient == 1) {
                newGenrePatient = "Mujer";
                requestDeclined = false;
            } else if(isWomenPatient == 2) {
                newGenrePatient = "Hombre";
                requestDeclined = false;
            } else {
                System.out.println("ERROR, el valor proporcionado no se encuentra entre 1-2. Inténtelo de nuevo");
            }
        }

        Patients newPatient = new Patients(
                newNamePatient,
                newLastNamePatient,
                newWeightPatient,
                newHeightPatient,
                newAgePatient,
                newGenrePatient,
                weeklyDiet
        );
        patientsList.add(newPatient);
    }

    public void showPatientsDetails() {
        System.out.println("BIENVENIDO AL GESTOR DE DATOS DE PACIENTES");
        System.out.println("======================================");
        System.out.println("Estos son tus pacientes registrados:");

        if(patientsList.size() == 0) {
            System.out.println("ERROR: Todavía no tienes pacientes registrados");
        } else {
            for (int i = 0; i < patientsList.size(); i++) {
                System.out.println((i+1) + "." + patientsList.get(i).getName() + " " + patientsList.get(i).getLastName());
            }
            System.out.println("Selecciona al paciente del que necesitas más información: ");
            int patientSelected = scanner.nextInt();

            System.out.println("INFORMACIÓN SOBRE EL PACIENTE");
            System.out.println(patientsList.get(patientSelected-1).getName() + " " + patientsList.get(patientSelected-1).getLastName());
            System.out.println("======================================");
            if(weeklyDiet == null) {
                System.out.println("Todavía no existen datos del paciente " + patientsList.get(patientSelected-1).getName());
            } else {
                System.out.println("Estas son las dietas registradas para el paciente " + patientsList.get(patientSelected-1).getName());
            }
        }
    }

    public void addDietToPatient(){

    }

    public void removeDietToPatient() {

    }

    public void dischargePatient() {
        System.out.println("BIENVENIDO AL PROGRAMA PARA DAR DE BAJA A PACIENTES");
        System.out.println("======================================");
        System.out.println("Estos son tus pacientes registrados:");

        if(patientsList.size() == 0) {
            System.out.println("ERROR: Todavía no tienes pacientes registrados");
        } else {
            for (int i = 0; i < patientsList.size(); i++) {
                System.out.println((i+1) + "." + patientsList.get(i).getName() + " " + patientsList.get(i).getLastName());
            }
            System.out.println("Selecciona al paciente que deseas dar de baja: ");
            int patientSelected = scanner.nextInt();

            System.out.println("¿Estás seguro que deseas dar de baja a este paciente? SI/NO");
            System.out.println(patientsList.get(patientSelected-1).getName() + " " + patientsList.get(patientSelected-1).getLastName());
            String dischargeOption = scannerName.nextLine();

            if(dischargeOption.equalsIgnoreCase("SI")) {
                System.out.println("El paciente " + patientsList.get(patientSelected-1).getName() + " " + patientsList.get(patientSelected-1).getLastName() + " ha sido eliminado");
                patientsList.remove(patientsList.get(patientSelected-1));
            } else if (dischargeOption.equalsIgnoreCase("NO")) {
                System.out.println("Operación cancelada");
            } else {
                System.out.println("ERROR, no se ha entendido la respuesta");
                dischargePatient();
            }
        }

    }
}
