package testeos.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import testeos.Models.ActualClient;
import testeos.Models.Model;
import testeos.Models.QueueClient;

import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ActualCellController implements Initializable {

    public Label costumer_lbl;
    public Label DNI_lbl;
    public Label waiter_lbl;
    public Label mesa_asignada_lbl;
    public Label costumer_cant_lbl;
    public Button eliminar_btn;

    private final ActualClient Aclient;

    public ActualCellController(ActualClient Aclient) {
        this.Aclient = Aclient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costumer_lbl.textProperty().bind(Aclient.costumerProperty());
        DNI_lbl.textProperty().bind(Aclient.dNIProperty());
        waiter_lbl.textProperty().bind(Aclient.waiterProperty());
        mesa_asignada_lbl.textProperty().bind(Aclient.mesa_asignadaProperty());
        costumer_cant_lbl.textProperty().bind(Aclient.costumer_cantProperty());
        eliminar_btn.setOnAction(event -> {
            String dniCliente = Aclient.dNIProperty().get();
            String numMesa = Aclient.mesa_asignadaProperty().get();
            Model.getInstance().getDashboardController().eliminarCliente(dniCliente, numMesa);
        });

    }
}