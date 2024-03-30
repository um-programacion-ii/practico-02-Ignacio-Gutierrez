package Servicios;

import Entidades.*;
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

    public boolean comenzarACocinar(int numeroReceta, Despensa despensa) {
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
                if (!despensa.checkElemento(nombreIngrediente, cantidadRequerida)) {
                    ingredientesSuficientes = false;
                    break;
                }
            }


            boolean utensiliosSuficientes = true;
            if (ingredientesSuficientes) {
                for (Utensilio utensilio : receta.getUtensilios()) {
                    String nombreUtensilio = utensilio.getNombre();
                    int vidaUtilRequerida = utensilio.getVidaUtil();
                    if (!despensa.checkUtensilio(nombreUtensilio, vidaUtilRequerida)) {
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