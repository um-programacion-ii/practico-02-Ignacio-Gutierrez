package Entidades;

import Interfaces.Despensable;
import Interfaces.Reutilizable;

public class Utensilio implements Despensable, Reutilizable {
    private String nombre;
    private int cantidad;
    private int vidaUtil;

    public Utensilio(String nombre, int cantidad, int vidaUtil) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.vidaUtil = vidaUtil;
    }

    public void sacar(int cantidadARetirar) {
        if (this.cantidad >= cantidadARetirar) {
            this.cantidad -= cantidadARetirar;
            System.out.println("Se retiró " + cantidadARetirar + " de " + nombre + ", quedan " + this.cantidad + ".");
        } else {
            System.out.println("No es posible retirar " + cantidadARetirar + " de " + nombre + ", quedan " + this.cantidad + ".");
        }
    }

    public void usar() {
        if (vidaUtil > 0) {
            vidaUtil--;
            System.out.println("El utensilio " + nombre + " ha sido utilizado. Vida útil restante: " + vidaUtil);
        } else {
            System.out.println("El utensilio " + nombre + " ha llegado al final de su vida útil.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
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

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Quedan " + cantidad + " de " + nombre + ".";
    }
}
