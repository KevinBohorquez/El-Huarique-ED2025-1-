package testeos.Models;

import java.sql.*;

public class DatabaseDriver {
    private Connection conn;

    public void createTables() {
        String clientsInTablesQuery = "CREATE TABLE IF NOT EXISTS ClientsInTables (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "dni TEXT NOT NULL, " +
                "mesa_id INTEGER NOT NULL, " +
                "FOREIGN KEY (mesa_id) REFERENCES Mesas(id));";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(clientsInTablesQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:adminsLogin.db");
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getClientData(String pAddress, String password) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM AdminClients WHERE Account='"+pAddress+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getAdminData(String username, String password) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM AdminStorage WHERE Account='"+username+"' AND Password='"+password+"';");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getClientsInTables() {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ClientsInTables;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
