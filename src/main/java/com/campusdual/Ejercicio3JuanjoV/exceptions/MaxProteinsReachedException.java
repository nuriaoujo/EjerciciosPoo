package com.campusdual.Ejercicio3JuanjoV.exceptions;

public class MaxProteinsReachedException extends MaxValuedReachedException {

    public MaxProteinsReachedException() {
        super("Max proteins reached for the actual diet");
    }
}
