package Entidades;

import Interfaces.Despensable;

public class Ingrediente implements Despensable {
    private String nombre;
    private int cantidad;

    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void sacar(int cantidadARetirar) {
        if (this.cantidad >= cantidadARetirar) {
            this.cantidad -= cantidadARetirar;
            System.out.println("Se retiró " + cantidadARetirar + " de " + nombre + ", quedan " + this.cantidad+ ".");
        } else {
            System.out.println("No es posible retirar " + cantidadARetirar + " de " + nombre + ", quedan " + this.cantidad + ".");
        }
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public void getClass(int i) {

    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Quedan " + cantidad + " de " + nombre + ".";
    }
}
