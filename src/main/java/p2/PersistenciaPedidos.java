package p2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class PersistenciaPedidos implements RegistroDePedidos {

    public PersistenciaPedidos() {
    }

    @Override
    public void registrarPedido(LocalDateTime fechaPedido, double montoTotal) {

        PreparedStatement statement;
        Connection conn;
        try {
            conn = ConnectionManager.getConnection();

            statement = conn
                    .prepareStatement("INSERT INTO pedidos(fecha_pedido, monto_total)" + "VALUES(?, ?)");


            statement.setDate(1, java.sql.Date.valueOf(fechaPedido.toLocalDate()));
            statement.setDouble(2, montoTotal);

            statement.executeUpdate();

            //ver
        } catch (SQLException e1) {
        } finally {
            try {
                ConnectionManager.disconnect();
            } catch (SQLException e) {

            }
        }
    }
}


