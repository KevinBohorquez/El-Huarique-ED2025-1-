package testeos.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import testeos.Controllers.Admin.ListCellController;
import testeos.Models.ListClient;

public class ListCellFactory extends ListCell<ListClient> {
    @Override
    protected void updateItem(ListClient lclient, boolean empty) {
        super.updateItem(lclient, empty);
        if(empty){
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/TransactionCell.fxml"));
            ListCellController controller = new ListCellController(lclient);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
