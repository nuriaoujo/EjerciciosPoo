package com.campusdual.Ejercicio3JuanjoV.exceptions;

public class MaxFatsReachedException extends MaxValuedReachedException {

    public MaxFatsReachedException() {
        super("Max fats reached for the actual diet");
    }
}
