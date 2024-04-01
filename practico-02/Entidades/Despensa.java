package Entidades;

import Excepciones.StockInsuficiente;
import Excepciones.VidaUtilInsuficiente;
import Interfaces.Despensable;

import java.util.HashMap;
import java.util.Map;

public class Despensa {
    private Map<String, Despensable> elementos = new HashMap<>();
    private Map<String, Utensilio> utensilios = new HashMap<>();


    public void addElemento(Despensable nuevoElemento) {
        String nombre = nuevoElemento.getNombre().toString();
        if (elementos.containsKey(nombre)) {
            Despensable existente = elementos.get(nombre);
            existente.getClass(existente.getCantidad() + nuevoElemento.getCantidad());
        } else {
            elementos.put(nombre, nuevoElemento);
        }
    }

    public boolean getElemento(String nombre, int cantidad) throws StockInsuficiente {
        if (elementos.containsKey(nombre)) {
            Despensable elemento = elementos.get(nombre);
            elemento.sacar(cantidad);
            return true;
        } else {
            System.out.println("No es posible retirar " + cantidad + " de " + nombre + ", no hay en la despensa.");
            return false;
        }
    }

    public  boolean checkElemento(String nombre, int cantidad) throws StockInsuficiente {
        if (elementos.containsKey(nombre)) {
            Despensable elemento = elementos.get(nombre);
            if (elemento.getCantidad() >= cantidad) {
                return true;
            } else {
                System.out.println("No hay suficiente cantidad de " + nombre + " en la despensa.");
                return false;
            }
        } else {
            System.out.println("No es posible retirar " + cantidad + " de " + nombre + ", no hay en la despensa.");
            return false;
        }
    }

    public void mostrarElemento() {
        System.out.println("Elementos en la despensa:");
        for (Map.Entry<String, Despensable> entry : elementos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getCantidad());
        }
    }


    public void addUtensilio(Utensilio nuevoUtensilio) {
        String nombre = nuevoUtensilio.getNombre().toString();
        utensilios.put(nombre, nuevoUtensilio);
    }

    public boolean getUtensilio(String nombre, int vidaUtil) throws VidaUtilInsuficiente {
        if (utensilios.containsKey(nombre)) {
            Utensilio utensilio = utensilios.get(nombre);
            utensilio.usar(vidaUtil);
            return true;
        } else {
            System.out.println("No es posible desgastar " + vidaUtil + " de " + nombre + ", no hay en la despensa.");
            return false;
        }
    }

    public  boolean checkUtensilio(String nombre, int vidaUtil) throws VidaUtilInsuficiente{
        if (utensilios.containsKey(nombre)) {
            Despensable utensilio = utensilios.get(nombre);
            if (((Utensilio) utensilio).getVidaUtil() >= vidaUtil) {
                return true;
            } else {
                System.out.println("No hay suficiente cantidad de " + nombre + " en la despensa.");
                return false;
            }
        } else {
            System.out.println("No es posible retirar " + nombre + ", no hay en la despensa.");
            return false;
        }
    }

    public void mostrarUtensilios() {
        System.out.println("Utensilios en la despensa:");
        for (Map.Entry<String, Utensilio> entry : utensilios.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getVidaUtil());
        }
    }

    public Map<String, Utensilio> getUtensilios() {
        return utensilios;
    }

}