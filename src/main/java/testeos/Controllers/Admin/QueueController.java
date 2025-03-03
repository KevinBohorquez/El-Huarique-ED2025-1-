package testeos.Controllers.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import testeos.Models.QueueClient;
import testeos.Models.DatabaseDriver;
import testeos.Views.QueueCellFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueueController {

    @FXML
    private ListView<QueueClient> assignedListView;

    private ObservableList<QueueClient> queueClients;
    private DatabaseDriver databaseDriver;

    public QueueController() {
        this.databaseDriver = new DatabaseDriver();
        this.queueClients = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        assignedListView.setCellFactory(param -> new QueueCellFactory());
        loadAssignedClients();

        if (assignedListView != null) {
            assignedListView.setItems(queueClients);
        } else {
            System.out.println("⚠️ assignedListView es NULL. Revisa el FXML.");
        }
    }

    private void loadAssignedClients() {
        queueClients.clear();
        ResultSet resultSet = databaseDriver.getClientsInTables();

        try {
            while (resultSet.next()) {
                QueueClient client = new QueueClient(
                        resultSet.getString("costumer"),
                        resultSet.getString("DNI"),
                        resultSet.getString("waiter"),
                        resultSet.getString("hora_asignada"),
                        resultSet.getString("mesa_asignada"),
                        resultSet.getString("costumer_cant")
                );
                queueClients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assignedListView.setItems(queueClients);
    }
}
