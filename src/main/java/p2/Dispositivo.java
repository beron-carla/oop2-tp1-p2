package p2;

public class Dispositivo {
    public float calcularCostoTotal(Pedido pedido, TarjetaDeCredito tarjeta, Propina propina) {

        Double costoBebidas = pedido.costoBebidas();
        Double costoPlatos = pedido.costoPlatos();
        Double descuento = tarjeta.aplicarDescuento(costoBebidas, costoPlatos);
        Double montoPropina = (descuento * propina.porcentaje());
        return (float) (descuento + montoPropina);
    }
}
