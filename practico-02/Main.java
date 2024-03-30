import Entidades.*;
import Servicios.CocinaService;
public class Main {
    public static void main(String[] args) {

        Despensa despensa = new Despensa();

        Chef chef = new Chef("Francisco Mallmann", 0, despensa);

        despensa.addElemento(new Ingrediente("Arroz",5000));  //Arroz con leche
        despensa.addElemento(new Ingrediente("Leche",2000));  //Arroz con leche
        despensa.addElemento(new Ingrediente("Canela",10));   //Arroz con leche
        despensa.addElemento(new Ingrediente("Azucar",500)); //Arroz con leche

        despensa.addElemento(new Ingrediente("Huevo",12));   //Huevo duro
        //despensa.addIngrediente(new Ingrediente("Agua",10000)); //Huevo duro

        despensa.addElemento(new Ingrediente("Ternera",8)); //Ternera al horno
        despensa.addElemento(new Ingrediente("Papa",3));   //Ternera al horno

        despensa.addUtensilio(new Utensilio("Olla",0));
        despensa.addUtensilio(new Utensilio("Olla",500));
        despensa.addUtensilio(new Utensilio("Cuchara",500));
        despensa.addUtensilio(new Utensilio("Bandeja",500));
        despensa.addUtensilio(new Utensilio("Cuchillo",500));
        despensa.addUtensilio(new Utensilio("Tenedor",500));

        CocinaService cocinaService = new CocinaService();

        System.out.println("\nArroz con Leche:");
        chef.prepararReceta(1, cocinaService);
        System.out.println("\nHuevo Duro:");
        chef.prepararReceta(2, cocinaService);
        System.out.println("\nTernera al Horno:");
        chef.prepararReceta(3, cocinaService);
        System.out.println("\nNada:");
        chef.prepararReceta(4, cocinaService);

    }
}