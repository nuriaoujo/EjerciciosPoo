package com.campusdual.Ejercicio3V2.exceptions;

public class MaxProteinsReachedException extends MaxValuedReachedException{

    public MaxProteinsReachedException() {
        super("Max proteins reached for the actual diet");
    }
}
