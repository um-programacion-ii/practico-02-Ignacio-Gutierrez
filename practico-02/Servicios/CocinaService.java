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
                if (!despensa.getIngrediente(nombreIngrediente, cantidadRequerida)) {
                    ingredientesSuficientes = false;
                    break;
                }
            }

            if (ingredientesSuficientes) {
                recetas.get(numeroReceta).cocinar();
                System.out.println("¡La receta ha sido preparada!");
                return true;
            } else {
                System.out.println("No hay suficientes ingredientes para preparar la receta.");
                return false;
            }
        }
    }
}