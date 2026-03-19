package org.example;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Double> bebidas = new HashMap<>();
        bebidas.put("Cerveza", 2000.0);
        bebidas.put("Agua", 1000.0);


        HashMap<String, Double> platosPrincipales = new HashMap<>();
        platosPrincipales.put("Pizza", 100.0);
        platosPrincipales.put("Empanada", 100.0);

        Pedido pedido = new Pedido(bebidas, platosPrincipales, new GeneradorDeFechas() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }
        });

        System.out.print("bebidas total= " + pedido.costoBebidas());
        System.out.print("platos total=" + pedido.costoPlatos());
    }

}