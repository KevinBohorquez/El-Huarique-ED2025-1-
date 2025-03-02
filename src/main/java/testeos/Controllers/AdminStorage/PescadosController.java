package testeos.Controllers.AdminStorage;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import testeos.Controllers.Structures.ColaAlmacen;
import testeos.Controllers.Structures.NodoAlmacen;
import testeos.Models.Model;
import testeos.Views.AdminStorageMenuOptions;

import java.net.URL;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ResourceBundle;

public class PescadosController implements Initializable {

    public Button aguadulce_btn;
    public Button mariscos_btn;
    public Button aguasalada_btn;
    public ListView listView_pescadosAD;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        aguadulce_btn.setOnAction(event -> onAguaDulce());
        mariscos_btn.setOnAction(event -> onMariscos());
        aguasalada_btn.setOnAction(event -> onAguasalada());
    }

    private void onAguaDulce(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.PESCADOS_AGUADULCE);
    }

    private void onMariscos(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.PESCADOS_MARISCOS);
    }

    private void onAguasalada(){
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.PESCADOS_AGUASALADA);
    }

    public void initialize() {
        // Obtener la instancia del Singleton
        AlmacenData almacenData = AlmacenData.getInstance();
        NodoAlmacen almacenGeneralHuarique = almacenData.obtenerArbol();

        //retorna un array de "colas"
        ArrayList<Queue<ColaAlmacen>> x = almacenGeneralHuarique.mostrarDatos("carne");

        // Mostrar los lotes de pescado en la lista
        for (Queue<ColaAlmacen> colaSubcategoria : x) {
            for (ColaAlmacen item: colaSubcategoria) {
                listView_pescadosAD.getItems().add(item.toString());
            }
        }
    }

}
