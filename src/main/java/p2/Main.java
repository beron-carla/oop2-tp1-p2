package p2;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido(new GeneradorDeFechas() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        }, 1);

        pedido.agregarItem(TipoItem.PLATO_PRICIPAL, new Item("Pizza", 50));
        pedido.agregarItem(TipoItem.PLATO_PRICIPAL, new Item("Empanada", 50));
        pedido.agregarItem(TipoItem.BEBIDA, new Item("Cerveza", 50));
        pedido.agregarItem(TipoItem.BEBIDA, new Item("Gaseosa", 50));

        var dispositivo = new Dispositivo();
        var tarjeta = new Visa();
        Propina propina = Propina.MEDIO;
        double costoTotal = dispositivo.calcularCostoTotal(pedido, tarjeta, propina);

        System.out.println(pedido.contarItems(TipoItem.BEBIDA));
        System.out.println(costoTotal);
    }

}