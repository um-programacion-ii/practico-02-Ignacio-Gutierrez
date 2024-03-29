package Entidades;

import Interfaces.Despensable;

public class Utensilio {
    private String nombre;
    private int cantidad;

    public Utensilio(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Quedan " + cantidad + " de " + nombre + ".";
    }
}
