package Servicios;

import Entidades.*;
import Excepciones.StockInsuficiente;
import Excepciones.VidaUtilInsuficiente;
import Interfaces.Cocinable;
import Recetas.ArrozConLeche;
import Recetas.HuevoDuro;
import Recetas.TerneraAlHorno;

import java.util.HashMap;
import java.util.Map;

public class CocinaService {
    private static final Map<Integer, Cocinable> recetas = new HashMap<>();

    static {
        recetas.put(1, new ArrozConLeche());
        recetas.put(2, new HuevoDuro());
        recetas.put(3, new TerneraAlHorno());
    }

    public boolean comenzarACocinar(int numeroReceta, Despensa despensa) throws VidaUtilInsuficiente, StockInsuficiente {
        Receta receta = (Receta) recetas.get(numeroReceta);
        if (receta == null) {
            System.out.println("No existe esa receta en el menú.");
            return false;
        } else {
            receta.mostrarReceta();

            boolean ingredientesSuficientes = true;
            for (Ingrediente ingrediente : receta.getIngredientes()) {
                String nombreIngrediente = ingrediente.getNombre();
                int cantidadRequerida = ingrediente.getCantidad();
                try {
                    despensa.checkElemento(nombreIngrediente, cantidadRequerida);
                } catch (StockInsuficiente e) {
                    System.out.println(e.getMessage());
                    ingredientesSuficientes = false;
                    break;
                }
            }


            boolean utensiliosSuficientes = true;
            if (ingredientesSuficientes) {
                for (Utensilio utensilio : receta.getUtensilios()) {
                    String nombreUtensilio = utensilio.getNombre();
                    int vidaUtilRequerida = utensilio.getVidaUtil();
                    try {
                        despensa.checkUtensilio(nombreUtensilio, vidaUtilRequerida);
                    } catch (VidaUtilInsuficiente e) {
                        System.out.println(e.getMessage());
                        utensiliosSuficientes = false;
                        break;
                    }
                }
            }

            if (ingredientesSuficientes && utensiliosSuficientes) {
                ((Cocinable) receta).cocinar();
                for (Ingrediente ingrediente : receta.getIngredientes()) {
                    String nombreIngrediente = ingrediente.getNombre();
                    int cantidadRequerida = ingrediente.getCantidad();
                    despensa.getElemento(nombreIngrediente, cantidadRequerida);
                }
                for (Utensilio utensilio : receta.getUtensilios()) {
                    String nombreUtensilio = utensilio.getNombre();
                    int vidaUtilRequerida = utensilio.getVidaUtil();
                    despensa.getUtensilio(nombreUtensilio, vidaUtilRequerida);
                }

                return true;
            } else {
                System.out.println("No se pueden cocinar la receta.");
                return false;
            }
        }
    }
}