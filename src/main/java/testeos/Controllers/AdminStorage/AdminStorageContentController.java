package testeos.Controllers.AdminStorage;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import testeos.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminStorageContentController implements Initializable {

    public BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().addListener((observable, old_val, new_val) -> {
            switch (new_val) {
                case CARNES -> client_parent.setCenter(Model.getInstance().getViewFactory().getCarnesView());
                case CARNES_CARNE -> client_parent.setCenter(Model.getInstance().getViewFactory().getCarnesCarneView());
                case CARNES_CERDO -> client_parent.setCenter(Model.getInstance().getViewFactory().getCarnesCerdoView());
                case CARNES_POLLO -> client_parent.setCenter(Model.getInstance().getViewFactory().getCarnesPolloView());
                case PESCADOS -> client_parent.setCenter(Model.getInstance().getViewFactory().getPescadosView());
                case PESCADOS_AGUADULCE -> client_parent.setCenter(Model.getInstance().getViewFactory().getPescados_aguadulceView());
                case PESCADOS_AGUASALADA -> client_parent.setCenter(Model.getInstance().getViewFactory().getPescados_aguasaladaView());
                case PESCADOS_AGUASALADA2 -> client_parent.setCenter(Model.getInstance().getViewFactory().getPescados_aguasalada2View());
                case PESCADOS_MARISCOS -> client_parent.setCenter(Model.getInstance().getViewFactory().getPescados_mariscosView());
                default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardAlmaView());
            }
        });
    }
}