package testeos.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import testeos.Models.Model;
import testeos.Models.ListClient;
import testeos.Views.ListCellFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public ListView<ListClient> transactions_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().setAllTransactions();
        transactions_listview.setItems(Model.getInstance().getAllTransactions());
        transactions_listview.setCellFactory(event -> new ListCellFactory());
    }

    private void initAllTransactionsList() {
        if(Model.getInstance().getAllTransactions().isEmpty()) {
            Model.getInstance().setAllTransactions();
        }
    }
}