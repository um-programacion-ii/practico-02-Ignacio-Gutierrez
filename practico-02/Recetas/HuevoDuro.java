package Recetas;

import Entidades.Ingrediente;
import Entidades.Receta;

public class HuevoDuro extends Receta {
    public HuevoDuro() {
        super(10, new Ingrediente[]{new Ingrediente("Huevo", 1), new Ingrediente("Agua", 400)}, "Hervir el huevo durante 10 minutos");
    }
}
