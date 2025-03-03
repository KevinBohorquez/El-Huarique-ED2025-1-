package testeos.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import testeos.Controllers.Admin.MenuController;
import testeos.Controllers.AdminStorage.AlmacenController;
import testeos.Controllers.AdminStorage.AlmacenData;
import testeos.Controllers.AdminStorage.MenuControllerAlmacen;
import testeos.Controllers.Structures.Almacen;
import testeos.Controllers.Structures.Cliente;
import testeos.Controllers.Structures.ColaAlmacen;
import testeos.Controllers.Structures.ColaClientes;
import testeos.Controllers.Structures.ListaClientes;
import testeos.Views.ViewFactory;
import java.sql.ResultSet;

public class Model {

    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;

    public final ObservableList<QueueClient> allClients;
    public final ObservableList<Almacen> allProductsP1;
    public final ObservableList<Almacen> allProductsP2;
    public final ObservableList<Almacen> allProductsP3;

    public final ObservableList<Almacen> allProductsC1;
    public final ObservableList<Almacen> allProductsC2;
    public final ObservableList<Almacen> allProductsC3;

    public final ObservableList<ListClient> allClients;
    private MenuController menuController;
    private final Client client;
    private boolean adminStorageLoginSuccessFlag;
    private boolean adminLoginSuccessFlag;

    private MenuController menuController;
    private MenuControllerAlmacen menuControllerAlmacen;
    private AlmacenController almacenController;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();

        this.allClients = FXCollections.observableArrayList();
        this.allProductsP1 = FXCollections.observableArrayList();
        this.allProductsP2 = FXCollections.observableArrayList();
        this.allProductsP3 = FXCollections.observableArrayList();

        this.allProductsC1 = FXCollections.observableArrayList();
        this.allProductsC2 = FXCollections.observableArrayList();
        this.allProductsC3 = FXCollections.observableArrayList();

        this.adminStorageLoginSuccessFlag = false;
        this.adminLoginSuccessFlag = false;
        this.client = new Client("");
    }

    public static synchronized Model getInstance() {
        if (model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public void setDashboardController(MenuController menuController) {
        this.menuController = menuController;
    }

    public MenuController getDashboardController() {
        return menuController;
    }

    private void prepareClients(ObservableList<ListClient> qclient, MenuController dashboard, int limit) {
        ListaClientes listaClientes = dashboard.getCola();
        Cliente actual = listaClientes.getFrente();
        int count = 0;
        while (actual != null && count < limit) {
            String nombre = actual.nombre;
            String dni = actual.DNI;
            String horaAsignacion = actual.hora_asignacion;
            String mesero = actual.mesero;
            String tiempoEsperando = actual.hora_asignacion;
            String numMesa = String.valueOf(actual.numMesa);
            String costumer_cant = String.valueOf(actual.cant);
            qclient.add(new ListClient(nombre, dni, mesero, horaAsignacion, tiempoEsperando, numMesa, costumer_cant));
            actual = actual.siguiente;
            count++;
        }
    }

    public ObservableList<ListClient> getAllTransactions() {
        return allClients;
    }

    public void setAllTransactions() {
        if (menuController != null) {
            allClients.clear();
            prepareClients(this.allClients, menuController, 30);
        } else {
            System.out.println("Error: DashboardController no está inicializado.");
        }
    }

    /*
     * Client Method Section
     */
    public boolean getAdminLoginSuccessFlag() {
        return this.adminLoginSuccessFlag;
    }

    public void setAdminStorageSuccessFlag(boolean flag) {
        this.adminStorageLoginSuccessFlag = flag;
    }

    public boolean getAdminStorageLoginSuccessFlag() {
        return this.adminStorageLoginSuccessFlag;
    }

    public void setAdminSuccessFlag(boolean flag) {
        this.adminLoginSuccessFlag = flag;
    }

    public Client getClient() {
        return client;
    }

    public void evaluateAdminCred(String pAddress, String password) {
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
        try{
            if (resultSet.isBeforeFirst()){
                this.adminLoginSuccessFlag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void evaluateAdminStorageCred(String username, String password){
        ResultSet resultSet = databaseDriver.getAdminData(username, password);
        try{
            if(resultSet.isBeforeFirst()){
                this.adminStorageLoginSuccessFlag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    * Almacen method section
    * */
    private void prepareAlmacen(ObservableList<Almacen> qalmacen, MenuControllerAlmacen dashboard, int limit, String subcat) {

        ColaAlmacen colaProductos = dashboard.getCola( subcat );


        Almacen actual = colaProductos.tope();

        int count = 0;
        while (actual != null && count < limit) {
            String tipo = actual.tipo;
            Double cantidad = actual.cantidad;
            int numLote = actual.numeroLote;

            qalmacen.add( new Almacen(tipo, cantidad, numLote) );
            actual = actual.siguiente;
            count++;
        }
    }

    public ObservableList<Almacen> getAllProducts(String subcat) {

        switch (subcat){
            case "carne" -> {
                return allProductsC1;
            }
            case "pollo" -> {
                return allProductsC2;
            }
            case "cerdo" -> {
                return allProductsC3;
            }
            case "salada"->{
                return allProductsP1;
            }
            case "dulce"->{
                return allProductsP2;
            }
            case "marisco"->{
                return allProductsP3;
            }
        }

        return null;
    }

    public void setAllProducts(String subCategoria) {


        if (menuControllerAlmacen != null) {
            switch (subCategoria){
                case "carne" -> {
                    allProductsC1.clear();
                    prepareAlmacen(this.allProductsC1, menuControllerAlmacen, 10, subCategoria);
                }
                case "pollo" -> {
                    allProductsC2.clear();
                    prepareAlmacen(this.allProductsC2, menuControllerAlmacen, 10, subCategoria);
                }
                case "cerdo" -> {
                    allProductsC3.clear();
                    prepareAlmacen(this.allProductsC3, menuControllerAlmacen, 10, subCategoria);
                }
                case "salada"->{
                    allProductsP1.clear();
                    prepareAlmacen(this.allProductsP1, menuControllerAlmacen, 10, subCategoria);
                }
                case "dulce"->{
                    allProductsP2.clear();
                    prepareAlmacen(this.allProductsP2, menuControllerAlmacen, 10, subCategoria);
                }
                case "mariscos"->{
                    allProductsP3.clear();
                    prepareAlmacen(this.allProductsP3, menuControllerAlmacen, 10, subCategoria);
                }
            }

        } else {
            System.out.println("Error: menuControllerAlmacen no está inicializado.");
        }
    }
    public void setMenuAlmacenController(MenuControllerAlmacen menuControllerAlmacen) {
        this.menuControllerAlmacen = menuControllerAlmacen;
    }
}