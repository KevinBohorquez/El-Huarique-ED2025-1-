package testeos.Controllers.Structures;

import java.util.Objects;

public class ColaClientes {
    private Cliente frente;

    public ColaClientes() {
        frente = null;
    }

    public void Encolar(String nombre, String DNI, String mesero, int numMesa, int cant) {
        Cliente nuevoNodo = new Cliente(nombre, DNI, mesero, numMesa, cant);
        if (frente == null) {
            frente = nuevoNodo;
        } else {
            Cliente actual = frente;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public Cliente existeClienteEnMesa(int mesaId) {
        if (frente == null) return null;

        if (frente.numMesa == mesaId) {
            Cliente clienteEncontrado = frente;
            frente = frente.siguiente;
            return clienteEncontrado;
        }

        Cliente actual = frente;
        while (actual.siguiente != null) {
            if (actual.siguiente.numMesa == mesaId) {
                Cliente clienteEncontrado = actual.siguiente;
                actual.siguiente = actual.siguiente.siguiente;
                return clienteEncontrado;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public Cliente getFrente(){
        return frente;
    }
}
