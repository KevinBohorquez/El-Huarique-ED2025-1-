package testeos.Controllers.AdminStorage;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import testeos.Controllers.Structures.Almacen;

import java.net.URL;
import java.util.ResourceBundle;

public class AlmacenCellController implements Initializable {

    public Label tipo;
    public Label cantidad;
    public Label lote;
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
        lote.setText(almacen.diaLlegada);
        /*
                eliminar_btn.setOnAction(event -> {
                    String nombreAlmacen = almacen.tipo;
                    Model.getInstance().eliminarAlmacen(nombreAlmacen);
                });
          */  }
}