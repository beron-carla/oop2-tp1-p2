package p2;

public class Dispositivo {

    public double calcularCostoTotal(Pedido pedido, TarjetaDeCredito tarjeta, Propina propina, RegistroDePedidos registroDePedidos) {
        double costoBebidas = pedido.total(Item -> Item.precioBebida());
        double costoPlatos = pedido.total(Item -> Item.precioPlato());
        double descuento = tarjeta.aplicarDescuento(costoBebidas, costoPlatos);
        double montoPropina = (descuento * propina.porcentaje());
        registroDePedidos.registrarPedido(pedido.fechaPedido(), descuento + montoPropina);
        return (descuento + montoPropina);
    }
}
