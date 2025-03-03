package testeos.Controllers.AdminStorage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import testeos.Controllers.AdminStorage.SubCategorias.Pescados_AS_Controller;
import testeos.Controllers.Structures.Almacen;
import testeos.Controllers.Structures.ColaAlmacen;
import testeos.Controllers.Structures.NodoAlmacen;
import testeos.Models.Model;
import testeos.Views.AdminStorageMenuOptions;
import testeos.Views.ViewFactory;


import java.net.URL;
import java.util.ResourceBundle;

public class PescadosController implements Initializable {


    public Button aguadulce_btn;
    public Button mariscos_btn;
    public Button aguasalada_btn;


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
        Model.getInstance().getViewFactory().getAdminStorageSelectedMenuItem().set(AdminStorageMenuOptions.PESCADOS_AGUASALADA2);

    }


}
