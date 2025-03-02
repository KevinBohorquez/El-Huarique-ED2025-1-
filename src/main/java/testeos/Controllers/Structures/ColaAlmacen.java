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
        if (actual != null){
            try{
                int nuevaCantidad = Integer.parseInt(txtCantidad.getText());
                x

            }catch(NumberFormatException e) {
                txtCantidad.setText("Número inválido");
            }

        }
    }
    public void desencolarPorLote(int numeroLote) {
        if (frente == null) {
            return;
        }

        if (Objects.equals(frente.numeroLote, numeroLote)) {
            frente = frente.siguiente;
            return;
        }

        Almacen actual = frente;
        while (actual.siguiente != null && !Objects.equals(actual.siguiente.numeroLote, numeroLote)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public Almacen getFrente(){
        return frente;
    }
}
