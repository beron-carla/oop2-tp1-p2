package p2;

import java.time.LocalDateTime;

public interface RegistroDePedidos {
    void registrarPedido(LocalDateTime fechaPedido, double montoTotal);

}
