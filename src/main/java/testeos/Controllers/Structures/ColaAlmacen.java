package testeos.Controllers.Structures;

import java.awt.*;
import java.util.Objects;
import testeos.Controllers.AdminStorage.MenuControllerAlmacen;
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

    public void actualizarPrimeroCola(TextField actualizar_porLote_flb){
        if(frente != null){
            try{
                double nuevaCantidad = Double.parseDouble(actualizar_porLote_flb.getText());
                frente.cantidad = nuevaCantidad;

            } catch (NumberFormatException e) {
                actualizar_porLote_flb.setText("Número inválido");
                System.out.println("Error: entrada inválida.");
            }
        }else {
            System.out.println("La cola está vacía, no hay elementos para actualizar.");
        }
    }

    public Almacen desencolar() {
        if (frente == null) {
            return  null;
        }
        Almacen auxiliar = frente;
        frente = frente.siguiente;
        return auxiliar;
    }
    public Almacen tope(){
        return frente;
    }

    public ColaAlmacen clonar() {
        ColaAlmacen copia = new ColaAlmacen();
        Almacen actual = frente;

        while (actual != null) {
            copia.EncolarAlmacen(actual.tipo, actual.cantidad, actual.numeroLote);
            actual = actual.siguiente;
        }

        return copia;
    }

}
