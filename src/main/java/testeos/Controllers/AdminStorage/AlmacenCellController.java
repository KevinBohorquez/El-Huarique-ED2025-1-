package testeos.Controllers.AdminStorage;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import testeos.Controllers.Structures.Almacen;
import testeos.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class AlmacenCellController implements Initializable {

    public Label tipo;
    public Label cantidad;
    public Label lote;
    public Label hour_arrival_lbl;
    public Label time_store_lbl;
    public Label num_lot_lbl;
    public Button eliminar_btn;

    private final Almacen almacen;

    public AlmacenCellController(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //nombre_lbl.textProperty().bind(almacen.tipo);
        //ubicacion_lbl.textProperty().bind(almacen.cantidad());
        //capacidad_lbl.textProperty().bind(almacen.capacidadProperty());

        tipo.setText(almacen.tipo);
        cantidad.setText( String.valueOf( almacen.cantidad ));
        lote.setText(String.valueOf(almacen.numeroLote));
        hour_arrival_lbl.setText(almacen.horaLlegada);
        time_store_lbl.setText(almacen.diaLlegada);
        num_lot_lbl.setText(" ");
        /*
        eliminar_btn.setOnAction(event -> {
            String nombreAlmacen = almacen.tipo;
            Model.getInstance().eliminarAlmacen(almacen.tipo);
        });
        */
    }
}