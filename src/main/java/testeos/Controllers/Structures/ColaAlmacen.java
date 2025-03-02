package testeos.Controllers.Structures;

import java.util.Objects;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ColaAlmacen {
    private Almacen frente;

    public ColaAlmacen (){
        frente = null;
    }

    public void EncolarAlmacen(String tipo, double cantidad, int numeroLote){
        Almacen nuevoNodoAlmacen = new Almacen(tipo, cantidad, numeroLote);
        if(frente == null){
            frente = nuevoNodoAlmacen;
        }else{
            Almacen actual = frente;
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodoAlmacen;
        }
    }

    public void actualizarPorNumeroLote(int numeroLote){
        Almacen actual = frente;
        while(actual != null){
            if()
        }
    }

    public Almacen getFrente(){
        return frente;
    }
}
