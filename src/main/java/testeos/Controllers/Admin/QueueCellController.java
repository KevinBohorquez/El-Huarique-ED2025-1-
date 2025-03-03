package testeos.Controllers.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import testeos.Models.QueueClient;
import testeos.Models.Model;

import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class QueueCellController implements Initializable {

    @FXML
    public Label costumer_lbl;
    @FXML
    public Label DNI_lbl;
    @FXML
    public Label waiter_lbl;
    @FXML
    public Label hora_asignada_lbl;
    @FXML
    public Label tiempo_esperando_lbl;
    @FXML
    public Label mesa_asignada_lbl;
    @FXML
    public Label costumer_cant_lbl;
    @FXML
    public Button eliminar_btn;

    private QueueClient queueClient;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // La lógica de inicialización se ejecuta después de setAssignedClient()
    }

    public void setAssignedClient(QueueClient queueClient) {
        this.queueClient = queueClient;

        costumer_lbl.textProperty().bind(queueClient.costumerProperty());
        DNI_lbl.textProperty().bind(queueClient.dNIProperty());
        waiter_lbl.textProperty().bind(queueClient.waiterProperty());
        hora_asignada_lbl.textProperty().bind(queueClient.hora_asignadaProperty());
        mesa_asignada_lbl.textProperty().bind(queueClient.mesa_asignadaProperty());
        costumer_cant_lbl.textProperty().bind(queueClient.costumer_cantProperty());

        // Se actualiza después de enlazar `hora_asignada`
        tiempo_esperando_lbl.setText(getTimeDifference(queueClient.hora_asignadaProperty().get()));

        eliminar_btn.setOnAction(event -> {
            String dniCliente = queueClient.dNIProperty().get();
            String numMesa = queueClient.mesa_asignadaProperty().get();
            Model.getInstance().getDashboardController().eliminarCliente(dniCliente, numMesa);
        });
    }

    public static String getTimeDifference(String inputTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            LocalTime inputLocalTime = LocalTime.parse(inputTime, formatter);
            LocalTime currentTime = LocalTime.now();

            if (inputLocalTime.isAfter(currentTime)) {
                return "Hora inválida";
            }

            Duration duration = Duration.between(inputLocalTime, currentTime);
            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;

            return hours + " horas " + minutes + " minutos";
        } catch (Exception e) {
            return "Tiempo inválido";
        }
    }
}

