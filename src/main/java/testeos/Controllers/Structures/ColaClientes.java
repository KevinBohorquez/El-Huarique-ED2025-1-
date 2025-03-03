package testeos.Controllers.Structures;

import java.util.Objects;

public class ColaClientes {
    private Cliente cabeza;

    public ColaClientes() {
        cabeza = null;
    }

    public void agregarCliente(String nombre, String DNI, String mesero, int numMesa, int cant) {
        Cliente nuevoCliente = new Cliente(nombre, DNI, mesero, numMesa, cant);
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

    public void eliminarClientePorDNI(String dni) {
        if (cabeza == null) {
            return;
        }

        if (Objects.equals(cabeza.DNI, dni)) {
            cabeza = cabeza.siguiente;
            return;
        }

        Cliente actual = cabeza;
        while (actual.siguiente != null && !Objects.equals(actual.siguiente.DNI, dni)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public Cliente getCabeza() {
        return cabeza;
    }
}
