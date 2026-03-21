package p2;

public class TarjetaSinDescuento implements TarjetaDeCredito {
    @Override
    public Double aplicarDescuento(Double costoBebidas, Double costoPlatos) {
        return (costoBebidas + costoPlatos);
    }
}
