package testeos.Controllers.Structures;

public class Mesa {
    private final int capacidad;
    private int cantidad;
    public Cliente cliente;

    public Mesa(int capacidad) {
        this.capacidad = capacidad;
        this.cantidad = 0;
        this.cliente = new Cliente(null, null, null, 0, 0);
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

    public void setCliente(String nombre, String dni, String mesero, int cantidad) {
        this.cliente.nombre = nombre;
        this.cliente.DNI = dni;
        this.cliente.mesero = mesero;
        this.cliente.cant = cantidad;
        this.cliente.numMesa = cantidad;
    }

    public void limpiar() {
        this.cliente.nombre = "";
        this.cliente.DNI = "";
        this.cliente.mesero = "";
        this.cliente.cant = 0;
        this.setCantidad(0);
    }

}
