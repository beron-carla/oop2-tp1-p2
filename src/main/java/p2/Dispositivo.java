package p2;

public class Dispositivo {
    public double calcularCostoTotal(Pedido pedido, TarjetaDeCredito tarjeta, Propina propina) {
        double costoBebidas = pedido.total(Item -> Item.precioBebida());
        double costoPlatos = pedido.total(Item -> Item.precioPlato());
        double descuento = tarjeta.aplicarDescuento(costoBebidas, costoPlatos);
        double montoPropina = (descuento * propina.porcentaje());
        return (descuento + montoPropina);
    }
}
