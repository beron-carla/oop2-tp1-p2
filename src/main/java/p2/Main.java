package p2;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Double> bebidas = new HashMap<>();
        bebidas.put("Cerveza", 50.0);
        bebidas.put("Agua", 50.0);


        HashMap<String, Double> platosPrincipales = new HashMap<>();
        platosPrincipales.put("Pizza", 50.0);
        platosPrincipales.put("Empanada", 50.0);

        Pedido pedido = new Pedido(bebidas, platosPrincipales, new GeneradorDeFechas() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        });

        var dispositivo = new Dispositivo();
        var tarjeta = new Visa();
        Propina propina = Propina.MEDIO;
        float costoTotal = dispositivo.calcularCostoTotal(pedido, tarjeta, propina);
    }

}