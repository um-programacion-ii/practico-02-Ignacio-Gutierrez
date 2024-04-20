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

    public void getElemento(String nombre, int cantidad) throws StockInsuficiente {
        if (elementos.containsKey(nombre)) {
            Despensable elemento = elementos.get(nombre);
            if (elemento.getCantidad() < cantidad) {
                throw new StockInsuficiente("No es posible retirar " + cantidad + " de " + nombre + ", no hay en la despensa.");
            }
            elemento.despensar(cantidad);
        } else {
            throw new StockInsuficiente("No es posible retirar " + cantidad + " de " + nombre + ", no hay en la despensa.");
        }
    }

    public boolean checkElemento(String nombre, int cantidad) throws StockInsuficiente {
        if (elementos.containsKey(nombre)) {
            Despensable elemento = elementos.get(nombre);
            if (elemento.getCantidad() >= cantidad) {
                return true;
            } else {
                throw new StockInsuficiente("No hay suficiente cantidad de " + nombre + " en la despensa.");
            }
        } else {
            throw new StockInsuficiente("No es posible retirar " + cantidad + " de " + nombre + ", no hay en la despensa.");
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

    public void getUtensilio(String nombre, int vidaUtil) throws VidaUtilInsuficiente {
        if (utensilios.containsKey(nombre)) {
            Utensilio utensilio = utensilios.get(nombre);
            if (utensilio.getVidaUtil() < vidaUtil) {
                throw new VidaUtilInsuficiente("No hay suficiente vida útil de " + nombre + " en la despensa.");
            }
            utensilio.utilizar(vidaUtil);
        } else {
            throw new VidaUtilInsuficiente("No es posible desgastar " + vidaUtil + " de " + nombre + ", no hay en la despensa.");
        }
    }

    public boolean checkUtensilio(String nombre, int vidaUtil) throws VidaUtilInsuficiente {
        if (utensilios.containsKey(nombre)) {
            Despensable utensilio = utensilios.get(nombre);
            if (((Utensilio) utensilio).getVidaUtil() >= vidaUtil) {
                return true;
            } else {
                throw new VidaUtilInsuficiente("No hay suficiente vida útil de " + nombre + " en la despensa.");
            }
        } else {
            throw new VidaUtilInsuficiente("No es posible retirar " + nombre + ", no hay en la despensa.");
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