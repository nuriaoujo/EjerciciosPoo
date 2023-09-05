package com.campusdual.Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Ejercicio con SWITCH
        /*Utilizando switch, escribir un programa que revise un número y diga si es primo o no
         * el número tiene que estar entre 1 y 20*/
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escriba un número del 1 al 20");
        Integer primo = teclado.nextInt();
        switch(primo) {
            case(2):
            case(3):
            case(5):
            case(7):
            case(11):
            case(13):
            case(17):
            case(19):
                System.out.println("El número " + primo + " es primo");
                break;
            default:
                System.out.println("El número " + primo + " no es primo");
                break;
        }//switch
    }//main
}//class
