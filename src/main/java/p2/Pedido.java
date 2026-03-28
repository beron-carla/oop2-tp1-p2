package p2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.ToDoubleFunction;

public class Pedido {
    int nroMesa;
    private LocalDateTime fechaPedido;
    private ArrayList<Item> items;

    public Pedido(GeneradorDeFechas dateGenerator, int nroMesa) {
        this.fechaPedido = dateGenerator.fecha();
        this.nroMesa = nroMesa;
        this.items = new ArrayList<>();

    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public double total(ToDoubleFunction<Item> funcion) {
        double total = 0;
        for (Item item : items) {
            total += funcion.applyAsDouble(item);
        }
        return total;
    }

    public int cantidadItem(ToDoubleFunction<Item> funcion) {
        int total = 0;
        for (Item item : items) {
            total += funcion.applyAsDouble(item);
        }
        return total;
    }

    public LocalDateTime fechaPedido() {
        return this.fechaPedido;
    }
}