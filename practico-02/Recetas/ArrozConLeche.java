package Recetas;

import Entidades.Ingrediente;
import Entidades.Receta;

public class ArrozConLeche extends Receta {
    public ArrozConLeche() {
        super(45, new Ingrediente[]{new Ingrediente("Arroz", 200), new Ingrediente("Leche", 1000), new Ingrediente("Azucar", 100), new Ingrediente("Canela", 5)}, "Cocinar el arroz con leche, azúcar y canela durante 45 minutos");
    }
}
