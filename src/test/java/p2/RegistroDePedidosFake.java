package p2;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroDePedidosFake implements RegistroDePedidos {
    private String data;

    public RegistroDePedidosFake(String data) {
        this.data = data;
    }

    @Override
    public void registrarPedido(LocalDateTime fechaPedido, double montoTotal) {
        StringBuilder sb = new StringBuilder();
        sb.append(formatearFecha(fechaPedido)).append(" || ").append(montoTotal).append(System.lineSeparator());
        this.data += sb.toString();
    }

    private String formatearFecha(LocalDateTime fechaInscripcion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaInscripcion.format(formatter);
        return fechaFormateada;
    }

    public String data() {
        return this.data;
    }
}