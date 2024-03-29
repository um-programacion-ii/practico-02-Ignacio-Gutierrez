package Entidades;

import Interfaces.Despensable;

public class Utensilio implements Despensable{
    private String nombre;
    private int cantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void getClass(int i) {

    }

    @Override
    public void sacar(int cantidad) {

    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Utensilio(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Quedan " + cantidad + " de " + nombre + ".";
    }
}
