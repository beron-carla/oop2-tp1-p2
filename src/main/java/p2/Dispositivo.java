package p2;

public class Dispositivo {
    public double calcularCostoTotal(Pedido pedido, TarjetaDeCredito tarjeta, Propina propina) {

        double costoBebidas = pedido.totalPorTipo(TipoItem.BEBIDA);
        double costoPlatos = pedido.totalPorTipo(TipoItem.PLATO_PRICIPAL);
        double descuento = tarjeta.aplicarDescuento(costoBebidas, costoPlatos);
        double montoPropina = (descuento * propina.porcentaje());
        return (descuento + montoPropina);
    }
}
