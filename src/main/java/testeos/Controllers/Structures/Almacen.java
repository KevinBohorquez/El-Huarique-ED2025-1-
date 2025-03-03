package testeos.Controllers.Structures;

import java.time.LocalDateTime;

public class Almacen {
    public String tipo;
    public double cantidad;
    public String horaLlegada;
    public Almacen siguiente;
    public int numeroLote;
    public String diaLlegada;


    public Almacen(String tipo, double cantidad, int numeroLote) {
        this.numeroLote = numeroLote;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.siguiente = null;
        this.diaLlegada = String.format("%02d/%02d/%04d",
                LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getYear());
        this.horaLlegada = String.format("%02d:%02d", LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
    }

    @Override
    public String toString() {
        return String.format("📦 %s \t Lote: %d \t Cant: %.2f kg \t Llegada: %s %s",
                tipo, numeroLote, cantidad, diaLlegada, horaLlegada);
    }

}
