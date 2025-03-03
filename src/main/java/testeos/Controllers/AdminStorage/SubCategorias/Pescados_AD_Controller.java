package testeos.Controllers.AdminStorage.SubCategorias;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import testeos.Controllers.AdminStorage.AlmacenData;
import testeos.Controllers.Structures.Almacen;
import testeos.Controllers.Structures.ColaAlmacen;
import testeos.Controllers.Structures.NodoAlmacen;

public class Pescados_AD_Controller {

    @FXML
    public ListView listView_pescadoAguaDulce;
    ObservableList list= FXCollections.observableArrayList();

    public void initialize(){
        mostrarPescados();
    }

    public void mostrarPescados(){

        AlmacenData almacenData = AlmacenData.getInstance();
        NodoAlmacen almacenGeneralHuarique = almacenData.obtenerArbol();

        ColaAlmacen loteDulces= almacenData.getDulce().clonar();
        System.out.println(loteDulces);

        list.clear();

        while (true) {
            Almacen item = loteDulces.desencolar();
            if (item == null) {
                System.out.println("Cola sin items");
                break;
            }

            list.add(item.toString());
            System.out.println("VISUALIZANDO: " + item.toString());
        }
        listView_pescadoAguaDulce.setItems(list);
    }

}
