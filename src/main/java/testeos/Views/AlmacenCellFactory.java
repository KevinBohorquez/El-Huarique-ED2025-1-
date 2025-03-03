// AlmacenCellFactory.java
package testeos.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import testeos.Controllers.AdminStorage.AlmacenCellController;
import testeos.Controllers.Structures.Almacen;

public class AlmacenCellFactory extends ListCell<Almacen> {
    @Override
    protected void updateItem(Almacen qalmacen, boolean empty) {

        super.updateItem(qalmacen, empty);

        if(empty){
            setText(null);
            setGraphic(null);
        } else {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/TransactionCellStore.fxml"));
            AlmacenCellController controller = new AlmacenCellController(qalmacen);
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