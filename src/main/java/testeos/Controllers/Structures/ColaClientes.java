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
    public void desencolarPorDNI(String dni) {
        if (frente == null) {
            return;
        }

        if (Objects.equals(frente.DNI, dni)) {
            frente = frente.siguiente;
            return;
        }

        Cliente actual = frente;
        while (actual.siguiente != null && !Objects.equals(actual.siguiente.DNI, dni)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }


    public Cliente getFrente(){
        return frente;
    }
}
