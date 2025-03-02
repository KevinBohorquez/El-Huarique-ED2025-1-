package testeos.Controllers.Structures;

import java.time.LocalDate;

public class ColaAlmacen {
    private int numeroLote;
    private double cantidad;  // en kg o unidades
    private String tipo;
    private LocalDate diaLlegada;
    private LocalDate horaLlegada;
    private LocalDate tiempoAlmacen;

    public ColaAlmacen(int numeroLote, double cantidad, LocalDate diaLlegada, LocalDate tiempoAlmacen) {
        this.numeroLote = numeroLote;
        this.cantidad = cantidad;
        this.diaLlegada = diaLlegada;
        this.tiempoAlmacen = tiempoAlmacen;
    }


}
