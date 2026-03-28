package p2;

public class Bebida implements Item {

    private String nombreBebida;
    private double precio;

    public Bebida(String nombre, double precio) {
        this.nombreBebida = nombre;
        this.precio = precio;
    }

    @Override
    public int sumBebida() {
        return 1;
    }

    @Override
    public int sumPlato() {
        return 0;
    }

    @Override
    public double precioBebida() {
        return this.precio;
    }

    @Override
    public double precioPlato() {
        return 0;
    }
}
