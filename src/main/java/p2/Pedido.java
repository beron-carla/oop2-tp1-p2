package p2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {
    int nroMesa;
    private LocalDateTime fechaPedido;
    private Map<TipoItem, List<Item>> items;

    public Pedido(GeneradorDeFechas dateGenerator, int nroMesa) {
        this.fechaPedido = dateGenerator.fecha();
        this.nroMesa = nroMesa;
        this.items = new HashMap<>();
        this.items.put(TipoItem.BEBIDA, new ArrayList<>());
        this.items.put(TipoItem.PLATO_PRICIPAL, new ArrayList<>());

    }

    public void agregarItem(TipoItem tipo, Item item) {
        this.items.get(tipo).add(item);
    }

    public int contarItems(TipoItem tipo) {
        return items.get(tipo).size();
    }

    public double totalPorTipo(TipoItem tipo) {
        return items.get(tipo)
                .stream()
                .mapToDouble(Item::precio)
                .sum();
    }

    public double totalPedido() {
        return items.values()
                .stream()
                .flatMap(List::stream)
                .mapToDouble(Item::precio)
                .sum();
    }

    public LocalDateTime fechaPedido() {
        return this.fechaPedido;
    }
}