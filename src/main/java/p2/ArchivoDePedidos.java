package p2;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class ArchivoDePedidos implements RegistroDePedidos {
    private String path;

    public ArchivoDePedidos(String filePath) {
        this.path = Objects.requireNonNull(filePath);
    }

    @Override
    public void registrarPedido(LocalDateTime fechaPedido, double montoTotal) {

        String linea = formatearFecha(fechaPedido) + " || " + montoTotal;
        final Path path = Paths.get(this.path);
        try {
            Files.write(path, Arrays.asList(linea), StandardCharsets.UTF_8,
                    Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir...", e);
        }
    }

    private String formatearFecha(LocalDateTime fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fecha.format(formatter);
        return fechaFormateada;
    }
}