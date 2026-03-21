package p2;

public class ComarcaPlus implements TarjetaDeCredito {

    @Override
    public Double aplicarDescuento(Double costoBebidas, Double costoPlatos) {
        return (costoBebidas + costoPlatos) * 0.98;
    }
}
