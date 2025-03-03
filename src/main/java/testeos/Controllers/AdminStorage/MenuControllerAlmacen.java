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


public class MenuControllerAlmacen implements Initializable {

    @FXML
    public TextField input_categoria;
    public TextField input_subCategoria;
    public TextField input_Cantidad;
    public TextField input_numLote;
    public Button boton_almacenar;

    public NodoAlmacen nodoAlmacen;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().setMenuAlmacenController(this);
    }
    public MenuControllerAlmacen(){
    }


    private void limpiar(){
        input_categoria.setText("");
        input_subCategoria.setText("");
        input_Cantidad.setText("") ;
        input_numLote.setText("") ;
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
                        Model.getInstance().setAllProducts("pollo");
                        limpiar();
                    }
                    case "res" -> {
                        almacenData.getRes().EncolarAlmacen(producto, cantidad, lote);
                        limpiar();
                        Model.getInstance().setAllProducts("res");
                    }
                    case "cerdo" -> {
                        almacenData.getCerdo().EncolarAlmacen(producto, cantidad, lote);
                        limpiar();
                        Model.getInstance().setAllProducts("cerdo");
                    }
                }
            }
            case "pescado" -> {
                switch (producto) {
                    case "dulce" -> {
                        almacenData.getDulce().EncolarAlmacen(producto, cantidad, lote);
                        limpiar();
                        Model.getInstance().setAllProducts("dulce");
                    }
                    case "salada" -> {
                        almacenData.getSal().EncolarAlmacen(producto, cantidad, lote);
                        limpiar();
                        Model.getInstance().setAllProducts("salada");
                    }
                    case "mariscos" -> {
                        almacenData.getMarisco().EncolarAlmacen(producto, cantidad, lote);
                        limpiar();
                        Model.getInstance().setAllProducts("mariscos");
                    }
                }

            }
            default -> System.out.println("Error, categoría invalida");
        }


    }

    public ColaAlmacen getCola( String subCat){
        switch (subCat){
            case "carne" -> {
                return AlmacenData.getInstance().getRes();
            }
            case "pollo" -> {
                return AlmacenData.getInstance().getPollo();
            }
            case "cerdo" -> {
                return AlmacenData.getInstance().getCerdo();
            }
            case "salada"->{
                return AlmacenData.getInstance().getSal();
            }
            case "dulce"->{
                return AlmacenData.getInstance().getDulce();
            }
            case "mariscos"->{
                return AlmacenData.getInstance().getMarisco();
            }
        }

        return null;
    }
}
