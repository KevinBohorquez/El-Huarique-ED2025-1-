package testeos.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ActualClient {
    private final StringProperty costumer;
    private final StringProperty DNI;
    private final StringProperty waiter;
    private final StringProperty mesa_asignada;
    private final StringProperty costumer_cant;

    public ActualClient(String costumer, String DNI, String waiter, String mesa_asignada, String costumer_cant) {
        this.costumer = new SimpleStringProperty(this, "costumer", costumer);
        this.DNI = new SimpleStringProperty(this, "DNI", DNI);
        this.waiter = new SimpleStringProperty(this, "waiter", waiter);
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

    public StringProperty mesa_asignadaProperty() {
        return this.mesa_asignada;
    }

    public StringProperty costumer_cantProperty() {
        return this.costumer_cant;
    }
}
