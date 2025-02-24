package testeos.Controllers.Structures;

public class Mesa {
    private final int capacidad;
    private int cantidad;
    public ListaEnlazadaCliente clientes;

    public Mesa(int capacidad) {
        this.capacidad = capacidad;
        this.cantidad = 0;
        this.clientes = new ListaEnlazadaCliente();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}

