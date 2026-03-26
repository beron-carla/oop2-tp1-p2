package p2;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispositivoTest {
    @Test
    public void testTarjetaVisa() {  //VISA
        //setup

        Pedido pedido = new Pedido(new GeneradorDeFechas() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        }, 1);

        pedido.agregarItem(TipoItem.PLATO_PRICIPAL, new Item("Pizza", 10));
        pedido.agregarItem(TipoItem.BEBIDA, new Item("Gaseosa", 5));

        var dispositivo = new Dispositivo();
        var tarjeta = new Visa();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = dispositivo.calcularCostoTotal(pedido, tarjeta, propina);
        //verify
        assertEquals(15.2955, costoTotal, 0.1);

    }

    @Test
    public void testTarjetaMastercard() {  //MASTERCARD
        //setup
        Pedido pedido = new Pedido(new GeneradorDeFechas() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        }, 1);

        pedido.agregarItem(TipoItem.PLATO_PRICIPAL, new Item("Pizza", 10));
        pedido.agregarItem(TipoItem.BEBIDA, new Item("Gaseosa", 5));

        var dispositivo = new Dispositivo();
        var tarjeta = new Mastercard();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = dispositivo.calcularCostoTotal(pedido, tarjeta, propina);
        //verify
        assertEquals(15.244, costoTotal, 0.1);

    }

    @Test
    public void testTarjetaComarcaPlus() {  //COMARCA PLUS
        //setup
        Pedido pedido = new Pedido(new GeneradorDeFechas() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        }, 1);

        pedido.agregarItem(TipoItem.PLATO_PRICIPAL, new Item("Pizza", 10));
        pedido.agregarItem(TipoItem.BEBIDA, new Item("Gaseosa", 5));

        var dispositivo = new Dispositivo();
        var tarjeta = new ComarcaPlus();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = dispositivo.calcularCostoTotal(pedido, tarjeta, propina);
        //verify
        assertEquals(15.141, costoTotal, 0.1);

    }

    @Test
    public void testTarjetaSinDescuento() {  //SIN DESCUENTO
        //setup
        Pedido pedido = new Pedido(new GeneradorDeFechas() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        }, 1);

        pedido.agregarItem(TipoItem.PLATO_PRICIPAL, new Item("Pizza", 10));
        pedido.agregarItem(TipoItem.BEBIDA, new Item("Gaseosa", 5));

        var dispositivo = new Dispositivo();
        var tarjeta = new TarjetaSinDescuento();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = dispositivo.calcularCostoTotal(pedido, tarjeta, propina);
        //verify
        assertEquals(15.45, costoTotal, 0.1);

    }
}
