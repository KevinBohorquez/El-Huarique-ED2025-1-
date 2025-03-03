package testeos.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import testeos.Models.Model;
import testeos.Models.ListClient;

import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ListCellController implements Initializable {

    public Label costumer_lbl;
    public Label DNI_lbl;
    public Label waiter_lbl;
    public Label hora_asignada_lbl;
    public Label tiempo_esperando_lbl;
    public Label mesa_asignada_lbl;
    public Label costumer_cant_lbl;
    public Button eliminar_btn;

    private final ListClient lclient;

    public ListCellController(ListClient lclient) {
        this.lclient = lclient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costumer_lbl.textProperty().bind(lclient.costumerProperty());
        DNI_lbl.textProperty().bind(lclient.dNIProperty());
        waiter_lbl.textProperty().bind(lclient.waiterProperty());
        hora_asignada_lbl.textProperty().bind(lclient.hora_asignadaProperty());
        tiempo_esperando_lbl.setText(getTimeDifference(hora_asignada_lbl.getText()));
        mesa_asignada_lbl.textProperty().bind(lclient.mesa_asignadaProperty());
        costumer_cant_lbl.textProperty().bind(lclient.costumer_cantProperty());
        eliminar_btn.setOnAction(event -> {
            String dniCliente = lclient.dNIProperty().get();
            String numMesa = lclient.mesa_asignadaProperty().get();
            Model.getInstance().getDashboardController().eliminarCliente(dniCliente, numMesa);
        });

    }
    public static String getTimeDifference(String inputTime) {
        // Convertimos el string de entrada a LocalTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime inputLocalTime = LocalTime.parse(inputTime, formatter);

        LocalTime currentTime = LocalTime.now();

        Duration duration = Duration.between(currentTime, inputLocalTime);
        if (duration.isNegative()) {
            duration = duration.negated();
        }

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        return hours + " horas " + minutes + " minutos";
    }


}