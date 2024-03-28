package Entidades;

import Servicios.*;
public class Chef {
    private String nombre;
    private int estrellasMichelin;
    private Despensa despensa;

    public Chef(String nombre, int estrellasMichelin, Despensa despensa) {
        this.nombre  = nombre;
        this.estrellasMichelin = estrellasMichelin;
        this.despensa = despensa;
    }

    public void prepararReceta(int numeroReceta, CocinaService cocinaService) {
        boolean recetaPreparada = cocinaService.comenzarACocinar(numeroReceta, despensa);
        if (recetaPreparada) {
            System.out.println("El Chef " + nombre + ", con " + estrellasMichelin + " estrellas Michelin, espera que disfrute su comida.");
        } else {
            System.out.println("El Chef " + nombre + ", con " + estrellasMichelin + " estrellas Michelin, dice que debe pedir algo del menú.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrellasMichelin() {
        return estrellasMichelin;
    }

    public void setEstrellasMichelin(int estrellasMichelin) {
        this.estrellasMichelin = estrellasMichelin;
    }

    public Despensa getDespensa() {
        return despensa;
    }

    public void setDespensa(Despensa despensa) {
        this.despensa = despensa;
    }

    @Override
    public String toString() {
        return "El Chef " + nombre + " tiene " + estrellasMichelin + " estrellas Michelin.";
    }
}