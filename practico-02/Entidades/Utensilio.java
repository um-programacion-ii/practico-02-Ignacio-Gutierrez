package Entidades;

import Interfaces.Despensable;
import Interfaces.Reutilizable;

public class Utensilio implements Despensable, Reutilizable {
    private String nombre;
    private int vidaUtil;

    public Utensilio(String nombre, int vidaUtil) {
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
    }


    public void usar(int vidaUtilNecesaria) {
        if (vidaUtil >= vidaUtilNecesaria) {
            vidaUtil -= vidaUtilNecesaria;
            System.out.println("El utensilio " + nombre + " ha sido utilizado. Vida útil restante: " + vidaUtil);
        } else {
            System.out.println("El utensilio " + nombre + " ha llegado al final de su vida útil.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCantidad() {
        return 0;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    @Override
    public void getClass(int i) {
    }

    @Override
    public void sacar(int cantidad) {

    }


    @Override
    public String toString() {
        return "Quedan " + vidaUtil + " usos de " + nombre + ".";
    }

}
