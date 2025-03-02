package testeos.Controllers.AdminStorage;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import testeos.Controllers.Structures.ColaAlmacen;
import testeos.Controllers.Structures.NodoAlmacen;
import testeos.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;


public class MenuControllerAlmacen {

    @FXML
    public TextField input_categoria;
    public TextField input_subCategoria;
    public TextField input_Cantidad;
    public TextField input_numLote;
    public Button boton_almacenar;

    public NodoAlmacen nodoAlmacen;



    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public MenuControllerAlmacen(){
        nodoAlmacen = new NodoAlmacen("AlmacenHuarique");
    }

    public void agregarAlmacen(){
        String cat = input_categoria.getText();
        String producto= input_subCategoria.getText();
        int cantidad = Integer.parseInt( input_Cantidad.getText() );
        int lote =  Integer.parseInt( input_numLote.getText()) ;

        //datos almacenados en una clase general para ser accedidos por distintos controladores
        AlmacenData almacenData = AlmacenData.getInstance();

        switch (cat) {
            case "carne" -> {
                switch(producto) {
                    case "pollo" -> {
                        almacenData.getPollo().EncolarAlmacen(producto, cantidad, lote);
                    }
                    case "res" -> {
                        almacenData.getRes().EncolarAlmacen(producto, cantidad, lote);

                    }
                    case "cerdo" -> {
                        almacenData.getCerdo().EncolarAlmacen(producto, cantidad, lote);

                    }
                }
            }
            case "pescado" -> {
                switch (producto) {
                    case "dulce" -> {
                        almacenData.getDulce().EncolarAlmacen(producto, cantidad, lote);

                    }
                    case "salada" -> {
                        almacenData.getSal().EncolarAlmacen(producto, cantidad, lote);

                    }
                    case "mariscos" -> {
                        almacenData.getMarisco().EncolarAlmacen(producto, cantidad, lote);
                    }
                }

            }
            default -> System.out.println("Error, categoría invalida");
        }
    }

}
