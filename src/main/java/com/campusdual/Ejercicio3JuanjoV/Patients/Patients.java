package com.campusdual.Ejercicio3JuanjoV.Patients;

import com.campusdual.Ejercicio3JuanjoV.*;

import java.util.*;

public class Patients {
    DietProgram dietProgram;

    List<Patients> patientsList = new ArrayList<>();
    Map <Integer, Diet> weeklyDiet;

    Scanner scanner = new Scanner(System.in);
    Scanner scannerName = new Scanner(System.in);

    private boolean requestDeclined;
    private boolean addNewIntake;
    private boolean badAnswer = true;


    private String name;
    private String lastName;
    private Integer weight;
    private Integer height;
    private Integer age;
    private String genre;
    private String newGenrePatient;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Patients() {
        patientsList.add(new Patients("María", "Álvarez", 67, 168, 43, "Mujer", null));
        patientsList.add(new Patients("Joaquín", "Míguez", 87, 173, 27, "Hombre", null));
    }

    public Patients(String name, String lastName, Integer weight, Integer height, Integer age, String genre, Map weeklyDiet) {
        this.name = name;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.genre = genre;
        this.weeklyDiet = weeklyDiet;
    }

    public void createPatient() {
        this.requestDeclined = true;

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

        while (requestDeclined) {
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

        if (patientsList.size() == 0) {
            System.out.println("ERROR: Todavía no tienes pacientes registrados");
        } else {
            for (int i = 0; i < patientsList.size(); i++) {
                System.out.println((i + 1) + "." + patientsList.get(i).getName() + " " + patientsList.get(i).getLastName());
            }
            System.out.println("Selecciona al paciente del que necesitas más información: ");
            int patientSelected = scanner.nextInt();

            System.out.println("INFORMACIÓN SOBRE EL PACIENTE");
            System.out.println(patientsList.get(patientSelected - 1).getName() + " " + patientsList.get(patientSelected - 1).getLastName());
            System.out.println("======================================");
            if (weeklyDiet == null) {
                System.out.println("Todavía no existen datos del paciente " + patientsList.get(patientSelected - 1).getName());
            } else {
                System.out.println("Estas son las dietas registradas para el paciente " + patientsList.get(patientSelected - 1).getName());
            }
        }
    }

    public void addDietToPatient() {
        System.out.println("BIENVENIDO AL EDITOR DE DIETAS DE PACIENTES");
        System.out.println("======================================");
        System.out.println("Estos son tus pacientes registrados:");

        if (patientsList.size() == 0) {
            System.out.println("ERROR: Todavía no tienes pacientes registrados");
        } else {
            for (int i = 0; i < patientsList.size(); i++) {
                System.out.println((i + 1) + "." + patientsList.get(i).getName() + " " + patientsList.get(i).getLastName());
            }
            System.out.println("Selecciona al que deseas añadirle una dieta: ");
            int patientSelected = scanner.nextInt();

            if (patientsList.get(patientSelected - 1).weeklyDiet == null) {
                patientsList.get(patientSelected - 1).weeklyDiet = new HashMap<>();
            }
            if (patientsList.get(patientSelected - 1).weeklyDiet.containsKey(1)) {
                System.out.println("¿Quieres crear una nueva dieta o utilizar una existente?");
                System.out.println( "1. Dieta nueva (1)\n" +
                                    "2. Dieta existente (2)");
                int newOrExistentDiet = scanner.nextInt();

                if (newOrExistentDiet == 1) {
                    dietProgram.createMenu();
                    System.out.println("¿Quieres añadir un alimento a esta nueva dieta? SI/NO");
                    String newIntaketoDiet = scannerName.nextLine();

                    while(badAnswer) {
                        if (newIntaketoDiet.equalsIgnoreCase("SI")) {
                            addNewIntake = true;
                            badAnswer = false;
                        } else if (newIntaketoDiet.equalsIgnoreCase("NO")) {
                            addNewIntake = false;
                            badAnswer = false;
                        } else {
                            System.out.println("ERROR, no se ha entendido la respuesta");
                            badAnswer = true;
                        }
                    }
                    while (addNewIntake){
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
                        dietProgram.validateAndAddFoodToDiet(newFood,grams);
                        dietProgram.foodList.add(newFood);
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
                    int daySelection = scanner.nextInt();

                    if (daySelection > 7 || daySelection == 0) {
                        System.out.println("ERROR, el valor proporcionado no se encuentra entre 1-7");
                    } else {
                        weeklyDiet.replace(daySelection, null, dietProgram.diet);
                    }
                } else if (newOrExistentDiet == 2) {
                    System.out.println("Selecciona la dieta que quieres añadir"); //TODO en progreso...
                    if(dietProgram.dietList.size() == 0) {
                        System.out.println("ERROR: Todavía no tienes dietas registradas");
                    } else {
                        for(int i = 0 ; i < dietProgram.dietList.size(); i++ ) {
                            System.out.println((i + 1) + ". " + dietProgram.dietList.get(i).getDietName());
                        }
                        System.out.println("Selecciona la dieta que deseas añadir: ");
                        int dietSelected = scanner.nextInt();
                        System.out.println("¿En qué día de la semana quieres insertar la dieta?");
                        System.out.println( "1. Lunes (1) \n" +
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
                            weeklyDiet.replace(daySelection, null, dietProgram.dietList.get(dietSelected));
                        }
                    }
                } else {
                    System.out.println("ERROR, el valor proporcionado no se encuentra entre 1-2. Inténtelo de nuevo");
                }
            } else {
                System.out.println("Todavía no has iniciado la dieta de este paciente, será creada a continuació");
                patientsList.get(patientSelected - 1).weeklyDiet.put(1, null); //Lunes
                patientsList.get(patientSelected - 1).weeklyDiet.put(2, null); //Martes
                patientsList.get(patientSelected - 1).weeklyDiet.put(3, null); //Miércoles
                patientsList.get(patientSelected - 1).weeklyDiet.put(4, null); //Jueves
                patientsList.get(patientSelected - 1).weeklyDiet.put(5, null); //Viernes
                patientsList.get(patientSelected - 1).weeklyDiet.put(6, null); //Sábado
                patientsList.get(patientSelected - 1).weeklyDiet.put(7, null); //Domingo
                System.out.println("La dieta del paciente " + patientsList.get(patientSelected - 1).getName() +
                        " " + patientsList.get(patientSelected - 1).getLastName() + " ha sido creada");
            }
        }
    }

    public void removeDietToPatient () {
        System.out.println("BIENVENIDO AL EDITOR DE DIETAS DE PACIENTES");
        System.out.println("======================================");
        System.out.println("Estos son tus pacientes registrados:");

        if (patientsList.size() == 0) {
            System.out.println("ERROR: Todavía no tienes pacientes registrados");
        } else {
            for (int i = 0; i < patientsList.size(); i++) {
                System.out.println((i + 1) + "." + patientsList.get(i).getName() + " " +
                                    patientsList.get(i).getLastName());
            }
            System.out.println("Selecciona al que deseas eliminarle una dieta: ");
            int patientSelected = scanner.nextInt();

            if(patientsList.get(patientSelected - 1).weeklyDiet == null) {
                System.out.println("ERROR, el paciente elegido todavía no tiene registrada ninguna dieta");
                System.out.println("¿Deseas escoger otro paciente? SI/NO");
                String chooseOtherPatient = scannerName.nextLine();

                if(chooseOtherPatient.equalsIgnoreCase("SI")) {
                    removeDietToPatient();
                } else if (chooseOtherPatient.equalsIgnoreCase("NO")) {
                    System.out.println(" ");
                } else {
                    System.out.println("ERROR, no se ha entendido la respuesta");
                    removeDietToPatient();
                }
            } else {
                System.out.println("Selecciona la dieta que quieres eliminar"); //TODO en progreso...
                for(int i = 0 ; i < weeklyDiet.size() ; i++) {
                    System.out.println((i + 1) + ". " +  patientsList.get(patientSelected - 1).weeklyDiet +
                                        " (" + (i + 1) + ")");
                }
                int removeSelection = scanner.nextInt();
                weeklyDiet.replace(removeSelection, null , null); //TODO repasar como fufa esto
            }
        }
    }

    public void dischargePatient () {
        System.out.println("BIENVENIDO AL PROGRAMA PARA DAR DE BAJA A PACIENTES");
        System.out.println("======================================");
        System.out.println("Estos son tus pacientes registrados:");

        if (patientsList.size() == 0) {
            System.out.println("ERROR: Todavía no tienes pacientes registrados");
        } else {
            for (int i = 0; i < patientsList.size(); i++) {
                System.out.println((i + 1) + "." + patientsList.get(i).getName() + " " +
                                    patientsList.get(i).getLastName());
            }
            System.out.println("Selecciona al paciente que deseas dar de baja: ");
            int patientSelected = scanner.nextInt();

            System.out.println("¿Estás seguro que deseas dar de baja a este paciente? SI/NO");
            System.out.println(patientsList.get(patientSelected - 1).getName() + " " +
                                patientsList.get(patientSelected - 1).getLastName());

            String dischargeOption = scannerName.nextLine();

            if (dischargeOption.equalsIgnoreCase("SI")) {
                System.out.println("El paciente " + patientsList.get(patientSelected - 1).getName()+ " " +
                                patientsList.get(patientSelected - 1).getLastName() + " ha sido eliminado");

                patientsList.remove(patientsList.get(patientSelected - 1));
            } else if (dischargeOption.equalsIgnoreCase("NO")) {
                System.out.println("Operación cancelada");
            } else {
                System.out.println("ERROR, no se ha entendido la respuesta");
                dischargePatient();
            }
        }
    }
}

