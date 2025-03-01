package testeos.Controllers.AdminStorage;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import testeos.Models.Model;
import testeos.Views.AdminStorageMenuOptions;

import java.net.URL;
import java.util.ResourceBundle;

public class CarnesController implements Initializable {

    public Button carne_btn;
    public Button cerdo_btn;
    public Button pollo_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        carne_btn.setOnAction(event -> onCarne());
        cerdo_btn.setOnAction(event -> onCerdo());
        pollo_btn.setOnAction(event -> onPollo());
    }

    private void onCarne(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.CARNES_CARNE);
    }

    private void onCerdo(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.CARNES_CERDO);
    }

    private void onPollo(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.CARNES_POLLO);
    }



}
