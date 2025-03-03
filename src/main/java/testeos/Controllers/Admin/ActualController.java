package testeos.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import testeos.Models.ActualClient;
import testeos.Models.Model;
import testeos.Views.ActualCellFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ActualController implements Initializable {
    public ListView<ActualClient> actualClient_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().setAllActualClients();
        actualClient_listview.setItems(Model.getInstance().getAllActualClients());
        actualClient_listview.setCellFactory(event -> new ActualCellFactory());
    }

    /*private void initAllTransactionsList() {
        if(Model.getInstance().getAllTransactions().isEmpty()) {
            Model.getInstance().setAllTransactions();
        }
    }*/
}