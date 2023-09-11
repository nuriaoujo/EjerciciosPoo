package com.campusdual.Ejercicio3JuanjoV.exceptions;

public class MaxCarbsReachedException extends MaxValuedReachedException {

    public MaxCarbsReachedException() {
        super("Max carbs reached for the actual diet");
    }
}
