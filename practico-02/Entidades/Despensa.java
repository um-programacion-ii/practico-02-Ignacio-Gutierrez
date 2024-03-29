package Entidades;

import Interfaces.Despensable;

import java.util.ArrayList;
import java.util.List;

public class Despensa {
    private final List<Despensable> elementos;

    public Despensa() {
        this.elementos = new ArrayList<>();
    }

    public void addElemento(Despensable nuevoElemento) {
        boolean encontrado = false;
        for (Despensable elemento: elementos) {
            if (elemento.getNombre().equals(nuevoElemento.getNombre())) {
                elemento.getClass(elemento.getCantidad() + nuevoElemento.getCantidad());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            elementos.add(nuevoElemento);
        }
    }

    public boolean getElemento(String nombre, int cantidad) {
        boolean encontrado = false;
        for (Despensable elemento: elementos) {
            if (elemento.getNombre().equals(nombre)) {
                elemento.sacar(cantidad);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No es posible retirar " + cantidad + " de " + nombre + ", no hay en la despensa.");
            return false;
        } else {
            return true;
        }
    }

    public void mostrarElemento() {
        System.out.println("Elementos en la despensa:");
        for (Despensable elemento : elementos) {
            System.out.println(elemento.getNombre() + ": " + elemento.getCantidad());
        }
    }

}
