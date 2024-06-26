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

public class DespensaService {

    private static final Map<Integer, Cocinable> recetas = new HashMap<>();

    static {
        recetas.put(1, new ArrozConLeche());
        recetas.put(2, new HuevoDuro());
        recetas.put(3, new TerneraAlHorno());
    }


    public static boolean verificarStockYVidaUtil(int numeroReceta, Despensa despensa) {
        Receta receta = (Receta) recetas.get(numeroReceta);

        boolean ingredientesSuficientes = true;
        for (Ingrediente ingrediente : receta.getIngredientes()) {
            String nombreIngrediente = ingrediente.getNombre();
            int cantidadRequerida = ingrediente.getCantidad();
            try {
                despensa.checkElemento(nombreIngrediente, cantidadRequerida);
            } catch (StockInsuficiente e) {
                ingredientesSuficientes = false;
                System.out.println(e.getMessage());
                break;
            }
        }

        boolean utensiliosSuficientes = true;
        if (ingredientesSuficientes) {
            for (Utensilio utensilio : receta.getUtensilios()) {
                String nombreUtensilio = utensilio.getNombre();
                int vidaUtilRequerida = utensilio.getVidaUtil();
                try {
                    utensiliosSuficientes = despensa.checkUtensilio(nombreUtensilio, vidaUtilRequerida);
                } catch (VidaUtilInsuficiente e) {
                    utensiliosSuficientes = false;
                    System.out.println(e.getMessage());
                    break;
                }
            }
        }

        return ingredientesSuficientes && utensiliosSuficientes;
    }

    public static void renovarUtensilios(Despensa despensa) {
        for (Utensilio utensilio : despensa.getUtensilios().values()) {
            if (utensilio.getVidaUtil() <= 0) {
                utensilio.setVidaUtil(500);
            }
        }
    }
}