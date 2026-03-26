package p2;

public class Item {
    private String nombre;
    private double precio;

    public Item(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String nombre() {
        return nombre;
    }

    public double precio() {
        return precio;
    }
}
