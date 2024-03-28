import Entidades.*;
import Servicios.CocinaService;
public class Main {
    public static void main(String[] args) {

        Despensa despensa = new Despensa();

        Chef chef = new Chef("Francisco Mallmann", 0, despensa);

        despensa.addIngrediente(new Ingrediente("Arroz",5000));  //Arroz con leche
        despensa.addIngrediente(new Ingrediente("Leche",2000));  //Arroz con leche
        despensa.addIngrediente(new Ingrediente("Canela",10));   //Arroz con leche
        despensa.addIngrediente(new Ingrediente("Azucar",500)); //Arroz con leche

        despensa.addIngrediente(new Ingrediente("Huevo",12));   //Huevo duro
        //despensa.addIngrediente(new Ingrediente("Agua",10000)); //Huevo duro

        despensa.addIngrediente(new Ingrediente("Ternera",8)); //Ternera al horno
        despensa.addIngrediente(new Ingrediente("Papa",3));   //Ternera al horno

        //System.out.println("\nPrimer abastecimiento de la despensa");
        //despensa.mostrarIngredientes();

        CocinaService cocinaService = new CocinaService();

        System.out.println("\nArroz con Leche:");
        chef.prepararReceta(1, cocinaService);
        System.out.println("\nHuevo Duro:");
        chef.prepararReceta(2, cocinaService);
        System.out.println("\nTernera al Horno:");
        chef.prepararReceta(3, cocinaService);
        System.out.println("\nNada:");
        chef.prepararReceta(4, cocinaService);


        //System.out.println("\nRetirar ingredientes:");
        //despensa.getIngrediente("Huevo", 11);
        //despensa.getIngrediente("Ternera", 7);
        //despensa.getIngrediente("Arroz", 4999);

        //System.out.println("\nEstado despensa:");
        //despensa.mostrarIngredientes();


    }
}
