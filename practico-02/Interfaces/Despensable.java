package Interfaces;

import Excepciones.StockInsuficiente;

public interface Despensable {
    Object getNombre();

    int getCantidad();

    void getClass(int i);

    void sacar(int cantidad) throws StockInsuficiente, StockInsuficiente;

}
