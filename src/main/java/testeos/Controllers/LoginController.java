package testeos.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import testeos.Models.Model;
import testeos.Views.AccountType;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_selector;
    public Label payee_address_lbl;
    public TextField payee_address_fld;
    public TextField password_fld;
    public Button login_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.ADMIN, AccountType.STORAGE));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> setAcc_selector());
        login_btn.setOnAction(event -> onLogin());
    }

    private void setAcc_selector() {
        Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue());
        // Cambiar el label acorde al tipo de usuario
        if (acc_selector.getValue() == AccountType.ADMIN) {
            payee_address_lbl.setText("Cuenta del administrador de Clientes:");
        } else{
            payee_address_lbl.setText("Cuenta del administrador del Almacen:");
        }
    }

    private void onLogin() {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.ADMIN) {
            // Evalua las credenciales del admin Clientes
            Model.getInstance().evaluateAdminCred(payee_address_fld.getText(), password_fld.getText());
            if (Model.getInstance().getAdminLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showAdminWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No existen dichas credenciales   ");
            }
        } else {
            // Evalua las credenciales del admin Storage
            Model.getInstance().evaluateAdminStorageCred(payee_address_fld.getText(), password_fld.getText());
            if (Model.getInstance().getAdminStorageLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showAdminStorageWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No existen dichas credenciales   ");
            }
        }
    }

}