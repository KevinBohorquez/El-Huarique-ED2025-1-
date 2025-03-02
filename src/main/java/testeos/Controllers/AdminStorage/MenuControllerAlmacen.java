package testeos.Controllers.AdminStorage;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import testeos.Controllers.Structures.NodoAlmacen;
import testeos.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;


public class MenuControllerAlmacen {

    public TextField category_pro_fld;
    public TextField product_pro_fld;
    public TextField table_choosen_fld;
    public TextField num_customer_fld;
    public Button table_btn;


    public NodoAlmacen nodoAlmacen;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        table_btn.setOnAction(event -> agregarAlmacen());
    }
    public MenuControllerAlmacen(){
        nodoAlmacen = new NodoAlmacen("AlmacenHuarique");

    }

    public void agregarAlmacen(){
        String cat = category_pro_fld.getText();
        String producto= product_pro_fld.getText();
        int cantidad = Integer.parseInt( table_choosen_fld.getText() );
        int lote =  Integer.parseInt( num_customer_fld.getText()) ;

        NodoAlmacen nuevaCat
    }

}
