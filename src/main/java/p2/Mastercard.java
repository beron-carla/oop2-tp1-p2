package p2;

public class Mastercard implements TarjetaDeCredito {
    @Override
    public Double aplicarDescuento(Double costoBebidas, Double costoPlatos) {
        Double descuentoPlatosPrincipal = (costoPlatos * 0.98);
        return (costoBebidas + descuentoPlatosPrincipal);
    }
}
