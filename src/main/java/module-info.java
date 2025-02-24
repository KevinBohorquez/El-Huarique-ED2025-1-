module com.example.banquitofeliz {
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires org.controlsfx.controls;
    requires java.desktop;
    requires jdk.compiler;
    requires javafx.controls;

    opens testeos.Controllers.AdminStorage to javafx.fxml;
    opens testeos to javafx.graphics;
    exports testeos;
    exports testeos.Controllers;
    exports testeos.Controllers.Admin;
    exports testeos.Models;
    exports testeos.Views;
    exports testeos.Controllers.Structures;
}