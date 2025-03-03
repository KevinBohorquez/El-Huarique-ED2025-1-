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

    public ColaAlmacen mostrarDatos( String categoria, String subCategoria ) {
        ColaAlmacen  colas = new ColaAlmacen();


        for (NodoAlmacen hijo: hijos) {
            if(hijo.nombre.equals(categoria)) {
                System.out.println("categoria encontrada");
                System.out.println(hijo.lotes);
                
                for (ColaAlmacen lote: hijo.lotes) {
                    if (lote.tope().tipo.equals(subCategoria)) {
                        System.out.println("subcategoria encontrada");
                        return lote;
                    }
                }

            }
        }

       return colas;

    }

}

