package testeos.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import testeos.Controllers.Admin.ActualCellController;
import testeos.Models.ActualClient;

public class ActualCellFactory extends ListCell<ActualClient>{
    @Override
    protected void updateItem(ActualClient Aclient, boolean empty) {
        super.updateItem(Aclient, empty);
        if(empty){
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/ClientesActualesCell.fxml"));
            ActualCellController controller = new ActualCellController(Aclient);
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
