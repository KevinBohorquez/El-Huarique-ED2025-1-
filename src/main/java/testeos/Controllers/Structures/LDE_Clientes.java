package testeos.Controllers.Structures;

public class LDE_Clientes {
    public Nodo lista;

    public class Nodo {
        public Cliente cliente;
        public Nodo sgte;
        Nodo ante;

        public Nodo(Cliente cliente) {
            this.cliente = cliente;
            this.sgte = null;
            this.ante = null;
        }
    }

    public LDE_Clientes() {
        lista = null;
    }

    public void insertar(String nombre, String DNI, String mesero, int numMesa, int cant) {
        Cliente nuevoCliente = new Cliente(nombre, DNI, mesero, numMesa, cant);
        Nodo nuevoNodo = new Nodo(nuevoCliente);

        if (lista != null) {
            nuevoNodo.sgte = lista;
            lista.ante = nuevoNodo;
        }

        lista = nuevoNodo;
    }

    public void eliminar(String DNI) {
        Nodo actual = lista;

        while (actual != null) {
            if (actual.cliente.DNI.equals(DNI)) {

                if (actual == lista) {
                    lista = actual.sgte;
                    if (lista != null) {
                        lista.ante = null;
                    }
                }

                else {
                    if (actual.sgte != null) {
                        actual.sgte.ante = actual.ante;
                    }
                    if (actual.ante != null) {
                        actual.ante.sgte = actual.sgte;
                    }
                }

                actual = null;
                return;
            }
            actual = actual.sgte;
        }
    }

    public Nodo getLista() {
        return lista;
    }

}
