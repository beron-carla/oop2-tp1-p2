package p2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispositivoTest {

    private Pedido pedido;
    private Dispositivo dispositivo;
    private RegistroDePedidosFake registro;

    @BeforeEach
    void SetUp() {
        this.pedido = new Pedido(new GeneradorDeFechas() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        }, 1);

        pedido.agregarItem(new PlatoPrincipal("Pizza", 10));
        pedido.agregarItem(new Bebida("Gaseosa", 5));
        this.dispositivo = new Dispositivo();

        this.registro = new RegistroDePedidosFake("");
    }

    @Test
    public void testTarjetaVisa() {  //VISA
        //setup
        String esperado = "29/03/2026 || 15.295499990042298\n";
        var tarjeta = new Visa();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = this.dispositivo.calcularCostoTotal(this.pedido, tarjeta, propina, registro);
        //verify
        assertEquals(15.2955, costoTotal, 0.1);
        assertEquals(esperado.replace("\n", System.lineSeparator()), registro.data());

    }

    @Test
    public void testTarjetaMastercard() {  //MASTERCARD
        //setup
        String esperado = "29/03/2026 || 15.243999990075828\n";
        var tarjeta = new Mastercard();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = this.dispositivo.calcularCostoTotal(this.pedido, tarjeta, propina, registro);
        //verify
        assertEquals(15.244, costoTotal, 0.1);
        assertEquals(esperado.replace("\n", System.lineSeparator()), registro.data());

    }

    @Test
    public void testTarjetaComarcaPlus() {  //COMARCA PLUS
        //setup
        String esperado = "29/03/2026 || 15.14099999014288\n";
        var tarjeta = new ComarcaPlus();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = this.dispositivo.calcularCostoTotal(this.pedido, tarjeta, propina, registro);
        //verify
        assertEquals(15.141, costoTotal, 0.1);
        assertEquals(esperado.replace("\n", System.lineSeparator()), registro.data());

    }

    @Test
    public void testTarjetaSinDescuento() {  //SIN DESCUENTO
        //setup
        String esperado = "29/03/2026 || 15.449999989941716\n";
        var tarjeta = new TarjetaSinDescuento();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = this.dispositivo.calcularCostoTotal(this.pedido, tarjeta, propina, registro);

        //verify
        assertEquals(15.45, costoTotal, 0.1);
        assertEquals(esperado.replace("\n", System.lineSeparator()), registro.data());

    }
}
