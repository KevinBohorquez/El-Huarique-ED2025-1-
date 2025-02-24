package testeos.Controllers.Structures;

import java.util.Objects;

public class ListaEnlazadaCliente {
    public Cliente cabeza;

    public ListaEnlazadaCliente() {
        cabeza = null;
    }

    public Cliente getCabeza() {
        return cabeza;
    }

    public void agregarLista(String nombre, String DNI, String mesero, int numMesa, int cant){
        Cliente nuevoCliente = new Cliente(nombre, DNI, mesero, numMesa, cant);
        nuevoCliente.setCant(cant);

        if (cabeza == null) {
            cabeza = nuevoCliente;
        } else {
            Cliente actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoCliente;
        }
    }

    public void eliminarLista(String dni) {
        if (cabeza == null) {
            return;
        }

        if (Objects.equals(cabeza.DNI, dni)) {
            cabeza = cabeza.siguiente;
            return;
        }

        Cliente actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.DNI.equals(dni)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}
