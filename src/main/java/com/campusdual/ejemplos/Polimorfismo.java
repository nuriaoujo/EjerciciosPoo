package com.campusdual.ejemplos;

public class Polimorfismo {
    private Integer numero;
    private String valor;

    //Se pueden hacer varias funciones con el mismo constructor siempre y cuando los tipos de variables sean diferentes
    //Integer
    public Polimorfismo(Integer numero2) {
        this.numero = numero2;
        this.valor = "vacio";
    }
    //String
    public Polimorfismo(String valor) {
        this.valor = valor;
        this.numero = 0;
    }
    //String e Integer
    public Polimorfismo(String valor, Integer numero) {
        this.valor = valor;
        this.numero = numero;
    }
    //Integer y String
    public Polimorfismo(Integer x, String y) {
        this.numero = x + 100;
        this.valor = "cadena " + y;

    }

    //Ejemplo de procedimiento (no devuelve nada)
    public void printValues(){
        System.out.println(this.valor + ":" + this.numero);
    }
}
