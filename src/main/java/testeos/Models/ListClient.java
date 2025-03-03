package testeos.Models;

import javafx.beans.property.*;

public class ListClient {
    private final StringProperty costumer;
    private final StringProperty DNI;
    private final StringProperty waiter;
    private final StringProperty hora_asignada;
    private final StringProperty tiempo_esperando;
    private final StringProperty mesa_asignada;
    private final StringProperty costumer_cant;

    public ListClient(String costumer, String DNI, String waiter, String hora_asignada, String tiempo_esperando, String mesa_asignada, String costumer_cant) {
        this.costumer = new SimpleStringProperty(this, "costumer", costumer);
        this.DNI = new SimpleStringProperty(this, "DNI", DNI);
        this.waiter = new SimpleStringProperty(this, "waiter", waiter);
        this.hora_asignada = new SimpleStringProperty(this, "hora_asignada", hora_asignada);
        this.tiempo_esperando = new SimpleStringProperty(this, "tiempo_esperando", tiempo_esperando);
        this.mesa_asignada = new SimpleStringProperty(this, "mesa_asignada", mesa_asignada);
        this.costumer_cant = new SimpleStringProperty(this, "costumer_cant", costumer_cant);
    }

    public StringProperty costumerProperty() {
        return this.costumer;
    }

    public StringProperty dNIProperty() {
        return this.DNI;
    }

    public StringProperty waiterProperty() {
        return this.waiter;
    }

    public StringProperty hora_asignadaProperty() {
        return this.hora_asignada;
    }

    public StringProperty tiempo_esperandoProperty() {
        return this.tiempo_esperando;
    }

    public StringProperty mesa_asignadaProperty() {
        return this.mesa_asignada;
    }

    public StringProperty costumer_cantProperty() {
        return this.costumer_cant;
    }
}
