package testeos.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import testeos.Controllers.Admin.QueueCellController;
import testeos.Models.QueueClient;

public class QueueCellFactory extends ListCell<QueueClient> {
    @Override
    protected void updateItem(QueueClient aClient, boolean empty) {
        super.updateItem(aClient, empty);
        if (empty || aClient == null) {
            setText(null);
            setGraphic(null);
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/AssignedCell.fxml"));
                QueueCellController controller = new QueueCellController();
                loader.setController(controller);
                setText(null);
                setGraphic(loader.load());

                // Enlaza los datos con el controlador
                controller.setAssignedClient(aClient);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
