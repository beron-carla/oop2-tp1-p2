package p2;

import java.time.LocalDateTime;

public class GeneradorDeFechasFake implements GeneradorDeFechas {
    @Override
    public LocalDateTime fecha() {
        return LocalDateTime.of(2027, 03, 27, 10, 9, 8);
    }
}
