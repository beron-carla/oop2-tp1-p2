package p2;

public class PlatoPrincipal implements Item {
    String nombrePlato;
    double precio;

    public PlatoPrincipal(String nombre, double precio) {
        this.nombrePlato = nombre;
        this.precio = precio;
    }

    @Override
    public int sumBebida() {
        return 0;
    }

    @Override
    public int sumPlato() {
        return 1;
    }

    @Override
    public double precioBebida() {
        return 0;
    }

    @Override
    public double precioPlato() {
        return this.precio;
    }
}
