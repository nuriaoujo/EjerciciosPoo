package com.campusdual.Ejercicio1;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Crear un programa que con un swich nos indique si un año es bisiesto o no

        //Año bisiesto es el divisible entre 4, salvo que sea año secular -último de cada siglo,
        // terminado en «00»-, en cuyo caso también ha de ser divisible entre 400.
        Integer anio = 1999;
        //Con IF-ELSE
        if (anio % 4 == 0) {
            if ( anio % 100 == 0) {
                if (anio % 400 == 0) {
                    System.out.println("El año " + anio + " es bisiesto");
                } else {
                    System.out.println("El año " + anio + " no es bisiesto");
                }
            } else {
                System.out.println("El año " + anio + " es bisiesto");
            }
        } else {
            System.out.println("El año " + anio + " no es bisiesto");
        }

        //Con SWITCH
        int op4 = anio % 4;
        int op100 = anio % 100;
        int op400 = anio % 400;

        switch (op4) {
            case (0):
                switch (op100) {
                    case (0):
                        switch (op400) {
                            case (0):
                                System.out.println("El año " + anio + " es bisiesto");
                                break;
                            default:
                                System.out.println("El año " + anio + " no es bisiesto");
                                break;
                        } //op400
                        break;
                    default:
                        System.out.println("El año " + anio + " es bisiesto");
                        break;
                }//op100
                break;
            default:
                System.out.println("El año " + anio + " no es bisiesto");
                break;
        }//op4
    }
}
