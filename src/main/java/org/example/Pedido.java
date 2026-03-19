package org.example;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Pedido {
    LocalDateTime fechaPedido;
    HashMap<String, Double> bebidas;
    HashMap<String, Double> platosPrincipales;
    int nroMesa;

    public Pedido(HashMap<String, Double> bebidas, HashMap<String, Double> platosPrincipales, GeneradorDeFechas dateGenerator) {
        this.fechaPedido = dateGenerator.fecha();
        this.bebidas = bebidas;
        this.platosPrincipales = platosPrincipales;
    }

    public Double costoBebidas() {
        Double costoBebidas = 0.0;
        for (Double precios : bebidas.values()) {
            costoBebidas += precios;
        }
        return costoBebidas;
    }

    public Double costoPlatos() {
        Double costoPlatos = 0.0;
        for (Double precios : platosPrincipales.values()) {
            costoPlatos += precios;
        }
        return costoPlatos;
    }

    public LocalDateTime fechaPedido() {
        return this.fechaPedido;
    }
}