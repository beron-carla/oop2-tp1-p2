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

        pedido.agregarItem(new PlatoPrincipal("Pizza", 50));
        pedido.agregarItem(new PlatoPrincipal("Empanada", 50));
        pedido.agregarItem(new Bebida("Cerveza", 50));
        pedido.agregarItem(new Bebida("Gaseosa", 50));

        var dispositivo = new Dispositivo();
        var tarjeta = new Visa();
        Propina propina = Propina.MEDIO;
        double costoTotal = dispositivo.calcularCostoTotal(pedido, tarjeta, propina);

        //cantidad bebidas
        System.out.println(pedido.cantidadItem(Item -> Item.sumBebida()));
        //cantidad platos
        System.out.println(pedido.cantidadItem(Item -> Item.sumPlato()));
        System.out.println(costoTotal);
    }

}