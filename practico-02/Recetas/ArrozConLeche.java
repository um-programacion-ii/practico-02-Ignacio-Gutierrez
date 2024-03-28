package Recetas;
import Entidades.*;
import Interfaces.Cocinable;

public class ArrozConLeche extends Receta implements Cocinable {
    public ArrozConLeche() {
        super(45, new Ingrediente[]{new Ingrediente("Arroz", 200),
                        new Ingrediente("Leche", 1000),
                        new Ingrediente("Azucar", 100),
                        new Ingrediente("Canela", 5)},
                "Cocinar el arroz con leche, azúcar y canela durante 45 minutos");
    }
    @Override
    public void cocinar() {
        System.out.println("Cocinando la receta...");
    }
}