package testeos.Views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import testeos.Controllers.Admin.AdminContentController;
import testeos.Controllers.AdminStorage.AdminStorageContentController;
import testeos.Controllers.AdminStorage.SubCategorias.Pescados_AS_Controller;

import java.io.IOException;

import java.io.IOException;

public class ViewFactory {
    private AccountType loginAccountType;

    //Admin views
    private final ObjectProperty<AdminMenuOptions> AdminSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane assignedView;
    private AnchorPane transactionsView;

    //Admin Storage views
    private final ObjectProperty<AdminStorageMenuOptions> AdminStorageSelectedMenuItem;
    private AnchorPane carnesView;
    private AnchorPane carnesCarneView;
    private AnchorPane carnesPolloView;
    private AnchorPane carnesCerdoView;
    private AnchorPane pescadosView;
    private AnchorPane pescados_aguadulceView;
    private AnchorPane pescados_mariscosView;
    private AnchorPane pescados_aguasaladaView;
    private AnchorPane dashboardAlma;


    public ViewFactory() {
        this.loginAccountType = AccountType.ADMIN;
        this.AdminSelectedMenuItem = new SimpleObjectProperty<>();
        this.AdminStorageSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem() {
        return AdminSelectedMenuItem;
    }

    public ObjectProperty<AdminStorageMenuOptions> getAdminStorageSelectedMenuItem() {
        return AdminStorageSelectedMenuItem;
    }

    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public Parent getAssignedView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Assigned.fxml"));
        try {
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AnchorPane getDashboardAlmaView(){
        if (dashboardAlma == null) {
            try {
                dashboardAlma = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/DashboardAlma.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dashboardAlma;
    }

    public AnchorPane getTransactionsView() {
        if (transactionsView == null) {
            try {
                transactionsView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Transactions.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return transactionsView;
    }

    public AnchorPane getCarnesView() {
        if (carnesView == null) {
            try {
                carnesView = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/principalAlmaCarne.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return carnesView;
    }

    public AnchorPane getCarnesCarneView() {
        if (carnesCarneView == null) {
            try {
                carnesCarneView = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/SubCategorias/adminAlmaCarneCarne.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return carnesCarneView;
    }

    public AnchorPane getCarnesPolloView() {
        if (carnesPolloView == null) {
            try {
                carnesPolloView = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/SubCategorias/adminAlmaCarnePollo.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return carnesPolloView;
    }

    public AnchorPane getCarnesCerdoView() {
        if (carnesCerdoView == null) {
            try {
                carnesCerdoView = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/SubCategorias/adminAlmaCarneCerdo.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return carnesCerdoView;
    }

    public AnchorPane getPescadosView() {
        if (pescadosView == null) {
            try {
                pescadosView = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/principalAlmaPescado.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pescadosView;
    }

    public AnchorPane getPescados_aguadulceView() {
        if (pescados_aguadulceView == null) {
            try {
                pescados_aguadulceView = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/SubCategorias/adminAlmaPescadosAguaDulce.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pescados_aguadulceView;
    }

    public AnchorPane getPescados_mariscosView() {
        if (pescados_mariscosView == null) {
            try {
                pescados_mariscosView = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/SubCategorias/adminAlmaPescadosMariscos.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pescados_mariscosView;
    }

    public Pescados_AS_Controller getPescadosASController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/SubCategorias/adminAlmaPescadosAguaSalada.fxml"));
        try {
            loader.load();
            return loader.getController(); // Retorna el controlador asociado al FXML
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public AnchorPane getPescados_aguasaladaView() {
        if (pescados_aguasaladaView == null) {
            try {
                pescados_aguasaladaView = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/SubCategorias/adminAlmaPescadosAguaSalada.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pescados_aguasaladaView;
    }

    public AnchorPane getPescados_aguasalada2View() {
        if (pescados_aguasaladaView == null) {
            try {
                pescados_aguasaladaView = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/SubCategorias/almacenPS.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pescados_aguasaladaView;
    }

    public void showAdminWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminContentController adminContentController = new AdminContentController();
        loader.setController(adminContentController);
        createStage(loader);
    }

    public void showAdminStorageWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/AdminStorage/Admin.fxml"));
        AdminStorageContentController adminStorageContentController = new AdminStorageContentController();
        loader.setController(adminStorageContentController);
        createStage(loader);
    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/icon.png"))));
        stage.setResizable(false);
        stage.setTitle("El Huarique");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }

}
