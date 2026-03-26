package p2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispositivoTest {
    @Test
    public void testTarjetaVisa() {  //VISA
        //setup
        var dispositivo = new Dispositivo();
        HashMap<String, Double> bebidas = new HashMap<>();
        bebidas.put("Gaseosa", 5.0);
        HashMap<String, Double> platosPrincipales = new HashMap<>();
        platosPrincipales.put("Pizza", 10.0);
        Pedido nuevoPedido = new Pedido(bebidas, platosPrincipales, new GeneradorDeFechasFake());
        var tarjeta = new Visa();
        Propina propina = Propina.MEDIO;

        //verify
        //excersice
        float costoTotal = dispositivo.calcularCostoTotal(nuevoPedido, tarjeta, propina);
        //verify
        assertEquals(15.2955, costoTotal, 0.1);

    }

    @Test
    public void testTarjetaMastercard() {  //MASTERCARD
        //setup
        var dispositivo = new Dispositivo();
        HashMap<String, Double> bebidas = new HashMap<>();
        bebidas.put("Gaseosa", 5.0);
        HashMap<String, Double> platosPrincipales = new HashMap<>();
        platosPrincipales.put("Pizza", 10.0);
        Pedido nuevoPedido = new Pedido(bebidas, platosPrincipales, new GeneradorDeFechasFake());
        var tarjeta = new Mastercard();
        Propina propina = Propina.MEDIO;
        //excersice
        float costoTotal = dispositivo.calcularCostoTotal(nuevoPedido, tarjeta, propina);
        //verify
        assertEquals(15.244, costoTotal, 0.1);

    }

    @Test
    public void testTarjetaComarcaPlus() {  //COMARCA PLUS
        //setup
        var dispositivo = new Dispositivo();
        HashMap<String, Double> bebidas = new HashMap<>();
        bebidas.put("Gaseosa", 5.0);
        HashMap<String, Double> platosPrincipales = new HashMap<>();
        platosPrincipales.put("Pizza", 10.0);
        Pedido nuevoPedido = new Pedido(bebidas, platosPrincipales, new GeneradorDeFechasFake());
        var tarjeta = new ComarcaPlus();
        Propina propina = Propina.MEDIO;
        //excersice
        float costoTotal = dispositivo.calcularCostoTotal(nuevoPedido, tarjeta, propina);
        //verify
        assertEquals(15.141, costoTotal, 0.1);

    }

    @Test
    public void testTarjetaSinDescuento() {  //SIN DESCUENTO
        //setup
        var dispositivo = new Dispositivo();
        HashMap<String, Double> bebidas = new HashMap<>();
        bebidas.put("Gaseosa", 5.0);
        HashMap<String, Double> platosPrincipales = new HashMap<>();
        platosPrincipales.put("Pizza", 10.0);
        Pedido nuevoPedido = new Pedido(bebidas, platosPrincipales, new GeneradorDeFechasFake());
        var tarjeta = new TarjetaSinDescuento();
        Propina propina = Propina.MEDIO;
        //excersice
        float costoTotal = dispositivo.calcularCostoTotal(nuevoPedido, tarjeta, propina);
        //verify
        assertEquals(15.45, costoTotal, 0.1);


    }
}
