package Entidades;

public class Receta {
    protected int tiempoCoccion;
    protected Ingrediente[] ingredientes;
    protected String preparacion;

    public Receta(int tiempoCoccion, Ingrediente[] ingredientes, String preparacion) {
        this.tiempoCoccion = tiempoCoccion;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

    public void mostrarReceta() {
        System.out.println("Tiempo de cocción: " + tiempoCoccion + " minutos");
        System.out.println("Ingredientes:");
        for (Ingrediente ingrediente : ingredientes) {
            System.out.println(ingrediente.getNombre() + ": " + ingrediente.getCantidad());
        }
        System.out.println("Preparación: " + preparacion);
    }

    public Ingrediente[] getIngredientes() {
        return this.ingredientes;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
}