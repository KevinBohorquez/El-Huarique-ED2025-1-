package testeos.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import testeos.Models.Model;
import testeos.Views.ClientMenuOptions;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminOptionsController implements Initializable {
    public Button menu_btn;
    public Button queue_btn;
    public Button logout_btn;
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addListeners();
    }

    private void addListeners() {
        menu_btn.setOnAction(event -> onMenu());
        queue_btn.setOnAction(event -> onCola());
        logout_btn.setOnAction(event -> onLogout());
    }

    private void onCola() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.COLA);
        Model.getInstance().getDashboardController().actualizarColoresDeEstado();
    }

    private void onMenu() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.MENU);
    }

    private void onLogout(){
        Stage stage = (Stage) menu_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setAdminSuccessFlag(false);
        Model.getInstance().setAdminStorageSuccessFlag(false);
    }
}