package Recetas;

import Entidades.Ingrediente;
import Entidades.Receta;

public class TerneraAlHorno extends Receta {
    public TerneraAlHorno() {
        super(60, new Ingrediente[]{new Ingrediente("Ternera", 1), new Ingrediente("Papa", 4)}, "Cortar las papas a gusto y cocinar junto a la ternera en el horno por 60 minutos");
    }
}
