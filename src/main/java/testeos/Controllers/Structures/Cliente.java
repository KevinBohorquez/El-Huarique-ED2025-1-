package testeos.Controllers.Structures;

import java.time.LocalDateTime;

public class Cliente {
    public String nombre;
    public String DNI;
    public String mesero;
    public Cliente siguiente;
    public String hora_asignacion;
    public int numMesa;
    public int cant;

    Cliente(String nombre, String DNI, String mesero, int numMesa, int cant) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.mesero = mesero;
        this.siguiente = null;
        this.hora_asignacion = String.format("%02d:%02d", LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
        this.numMesa = numMesa;
        this.cant = cant;
    }

}

