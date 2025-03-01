package testeos.Controllers.AdminStorage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import testeos.Models.Model;
import testeos.Views.AdminStorageMenuOptions;

public class AdminStorageOptionsController {

    @FXML
    public Button utensilios_btn;
    public Button verduras_btn;
    public Button carnes_btn;
    public Button pescados_btn;
    public Button inicio_btn;
    public Button logout_btn;

    @FXML
    private void initialize() {
        addListeners();
    }

    private void addListeners() {
        inicio_btn.setOnAction(event -> onMenu());
        verduras_btn.setOnAction(event -> {});
        carnes_btn.setOnAction(event -> onCarnes());
        pescados_btn.setOnAction(event -> onPescados());
        utensilios_btn.setOnAction(event -> {});
        logout_btn.setOnAction(event -> onLogout());
    }

    private void onMenu(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.MENU);
    }

    private void onCarnes(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.CARNES);
    }

    private void onPescados(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.PESCADOS);
    }

    private void onLogout(){
        Stage stage = (Stage) inicio_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setAdminSuccessFlag(false);
        Model.getInstance().setAdminStorageSuccessFlag(false);
    }
}
