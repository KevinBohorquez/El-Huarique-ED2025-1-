package testeos.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import testeos.Controllers.Admin.MenuController;
import testeos.Controllers.Structures.Cliente;
import testeos.Controllers.Structures.ColaClientes;
import testeos.Views.ViewFactory;
import java.sql.ResultSet;

public class Model {

    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    public final ObservableList<QueueClient> allClients;
    private MenuController menuController;
    private final Client client;
    private boolean adminStorageLoginSuccessFlag;
    private boolean adminLoginSuccessFlag;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        this.allClients = FXCollections.observableArrayList();
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

    private void prepareClients(ObservableList<QueueClient> qclient, MenuController dashboard, int limit) {
        ColaClientes colaClientes = dashboard.getCola();
        Cliente actual = colaClientes.getFrente();
        int count = 0;
        while (actual != null && count < limit) {
            String nombre = actual.nombre;
            String dni = actual.DNI;
            String horaAsignacion = actual.hora_asignacion;
            String mesero = actual.mesero;
            String tiempoEsperando = actual.hora_asignacion;
            String numMesa = String.valueOf(actual.numMesa);
            String costumer_cant = String.valueOf(actual.cant);
            qclient.add(new QueueClient(nombre, dni, mesero, horaAsignacion, tiempoEsperando, numMesa, costumer_cant));
            actual = actual.siguiente;
            count++;
        }
    }

    public ObservableList<QueueClient> getAllTransactions() {
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
}