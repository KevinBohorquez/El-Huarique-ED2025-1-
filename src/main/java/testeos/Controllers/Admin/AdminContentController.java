package testeos.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import testeos.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminContentController implements Initializable {

    public BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observable, old_val, new_val) -> {
            switch (new_val) {
                case MENU -> client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
                default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
}