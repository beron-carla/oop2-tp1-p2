package p2;

public class Visa implements TarjetaDeCredito {
    @Override
    public Double aplicarDescuento(Double costoBebidas, Double costoPlatos) {
        Double descuentoBebida = costoBebidas * 0.97;
        return (costoPlatos + descuentoBebida);
    }
}
