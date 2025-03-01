package testeos.Controllers.AdminStorage;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import testeos.Models.Model;
import testeos.Views.AdminStorageMenuOptions;

import java.net.URL;
import java.util.ResourceBundle;

public class PescadosController implements Initializable {

    public Button aguadulce_btn;
    public Button mariscos_btn;
    public Button aguasalada_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        aguadulce_btn.setOnAction(event -> onAguaDulce());
        mariscos_btn.setOnAction(event -> onMariscos());
        aguasalada_btn.setOnAction(event -> onAguasalada());
    }

    private void onAguaDulce(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.PESCADOS_AGUADULCE);
    }

    private void onMariscos(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.PESCADOS_MARISCOS);
    }

    private void onAguasalada(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.PESCADOS_AGUASALADA);
    }

}
