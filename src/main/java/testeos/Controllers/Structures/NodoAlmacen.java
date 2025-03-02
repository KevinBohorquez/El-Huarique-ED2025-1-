package testeos.Controllers.Structures;

import java.util.*;

public class NodoAlmacen {
    private String nombre;
    private List<NodoAlmacen> hijos;  // Para subcategorías
    private Queue<ColaAlmacen> lotes; // Cola FIFO para los lotes del producto

    public NodoAlmacen(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
        this.lotes = new LinkedList<>(); // FIFO
    }

    public void agregarHijo(NodoAlmacen hijo) {
        hijos.add(hijo);
    }

    public void agregarLote(ColaAlmacen lote) {
        lotes.offer(lote); // Agrega al final de la cola
    }

    public ColaAlmacen extraerLote() {
        return lotes.poll(); // Remueve el lote más antiguo (FIFO)
    }

    public ArrayList< Queue<ColaAlmacen> > mostrarDatos( String categoria ) {
        ColaAlmacen[] cola =  new ColaAlmacen[hijos.size()];
        ArrayList< Queue<ColaAlmacen> > colas = new ArrayList<>();

        if (this.nombre.equalsIgnoreCase(categoria)) {
            //recorrer cada subcategoria
           for (NodoAlmacen hijo : hijos) {
               colas.add(hijo.lotes);
           }
           return colas;
        } else {
            return null;
        }
    }

}

