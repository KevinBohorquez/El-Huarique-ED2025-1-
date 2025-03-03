package testeos.Controllers.AdminStorage;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import testeos.Models.Model;
import testeos.Controllers.Structures.Almacen;
import testeos.Views.AdminStorageMenuOptions;
import testeos.Views.AlmacenCellFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AlmacenController implements Initializable {
    public ListView<Almacen> almacen_listviewPS;
    public ListView almacen_listviewPD;
    public ListView almacen_listviewPM;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AdminStorageMenuOptions selectedOption = Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().get();
        if (selectedOption == AdminStorageMenuOptions.PESCADOS_AGUASALADA2) {
            Model.getInstance().setAllProducts("salada");
            almacen_listviewPS.setItems(Model.getInstance().getAllProducts("salada"));
            almacen_listviewPS.setCellFactory(event -> new AlmacenCellFactory());

        }else if (selectedOption == AdminStorageMenuOptions.PESCADOS_AGUADULCE) {
            Model.getInstance().setAllProducts("dulce");
            almacen_listviewPD.setItems(Model.getInstance().getAllProducts("dulce"));
            almacen_listviewPD.setCellFactory(event -> new AlmacenCellFactory());

        }else if (selectedOption == AdminStorageMenuOptions.PESCADOS_MARISCOS) {
            Model.getInstance().setAllProducts("mariscos");
            almacen_listviewPM.setItems(Model.getInstance().getAllProducts("mariscos"));
            almacen_listviewPM.setCellFactory(event -> new AlmacenCellFactory());
        }



    }
}
