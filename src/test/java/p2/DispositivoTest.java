package p2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispositivoTest {

    private Pedido pedido;
    private Dispositivo dispositivo;
    private RegistroDePedidos registro;

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

        this.registro = new ArchivoDePedidos("F:\\proyectos\\sistemas\\2026-2028\\archivoDePedidos.txt");
//        this.registro = new PersistenciaPedidos();
    }

    @Test
    public void testTarjetaVisa() {  //VISA
        //setup
        var tarjeta = new Visa();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = this.dispositivo.calcularCostoTotal(this.pedido, tarjeta, propina, registro);
        //verify
        assertEquals(15.2955, costoTotal, 0.1);

    }

    @Test
    public void testTarjetaMastercard() {  //MASTERCARD
        //setup
        var tarjeta = new Mastercard();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = this.dispositivo.calcularCostoTotal(this.pedido, tarjeta, propina, registro);
        //verify
        assertEquals(15.244, costoTotal, 0.1);

    }

    @Test
    public void testTarjetaComarcaPlus() {  //COMARCA PLUS
        //setup
        var tarjeta = new ComarcaPlus();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = this.dispositivo.calcularCostoTotal(this.pedido, tarjeta, propina, registro);
        //verify
        assertEquals(15.141, costoTotal, 0.1);

    }

    @Test
    public void testTarjetaSinDescuento() {  //SIN DESCUENTO
        //setup
        var tarjeta = new TarjetaSinDescuento();
        Propina propina = Propina.MEDIO;
        //excersice
        double costoTotal = this.dispositivo.calcularCostoTotal(this.pedido, tarjeta, propina, registro);
        //verify
        assertEquals(15.45, costoTotal, 0.1);

    }
}
