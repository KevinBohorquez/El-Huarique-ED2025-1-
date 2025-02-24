package testeos.Controllers.Admin;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
        import javafx.scene.paint.Color;
import testeos.Controllers.Structures.ColaClientes;
import testeos.Controllers.Structures.Mesa;
import testeos.Models.Model;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MenuController implements Initializable {
    public Label login_date;
    public Button table_btn;

    @FXML public Label[] tableCaps;
    @FXML public FontAwesomeIconView[] tableStatuses;

    public Label table_cap_1;
    public FontAwesomeIconView table_status_1;
    public Label table_cap_2;
    public FontAwesomeIconView table_status_2;
    public Label table_cap_3;
    public FontAwesomeIconView table_status_3;
    public Label table_cap_4;
    public FontAwesomeIconView table_status_4;
    public Label table_cap_5;
    public FontAwesomeIconView table_status_5;
    public Label table_cap_6;
    public FontAwesomeIconView table_status_6;
    public Label table_cap_7;
    public FontAwesomeIconView table_status_7;
    public Label table_cap_8;
    public FontAwesomeIconView table_status_8;
    public Label table_cap_9;
    public FontAwesomeIconView table_status_9;
    public Label table_cap_10;
    public FontAwesomeIconView table_status_10;

    public TextField table_choosen_fld;
    public TextField dni_costumer_fld;
    public TextField name_costumer_fld;
    public TextField name_waiter_fld;
    public Label error_lbl;
    public TextField costumer_cant_fld; // Cantidad de clientes a reservar

    private Mesa[] mesas;
    private ColaClientes colaClientes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableCaps = new Label[]{table_cap_1, table_cap_2, table_cap_3, table_cap_4, table_cap_5,
                table_cap_6, table_cap_7, table_cap_8, table_cap_9, table_cap_10};

        tableStatuses = new FontAwesomeIconView[]{table_status_1, table_status_2, table_status_3,
                table_status_4, table_status_5, table_status_6,
                table_status_7, table_status_8, table_status_9, table_status_10};
        Model.getInstance().setDashboardController(this);
        bindData();
        actualizarColoresDeEstado();
        table_btn.setOnAction(event -> agregarCliente());
    }

    public MenuController() {
        mesas = new Mesa[10];
        colaClientes = new ColaClientes();
        cargarMesasDesdeCSV("src/main/java/testeos/Views/mesasCapacidades.csv");
    }

    private void cargarMesasDesdeCSV(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine(); // Leer la primera línea del CSV
            if (linea != null) {
                String[] valores = linea.split(","); // Separar valores por comas
                for (int i = 0; i < valores.length && i < mesas.length; i++) {
                    int capacidad = Integer.parseInt(valores[i].trim()); // Convertir a entero
                    mesas[i] = new Mesa(capacidad); // Asignar el valor al arreglo
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    private void bindData() {
        login_date.setText("Hoy, " + LocalDate.now());
    }

    private FontAwesomeIconView getTableStatus(int mesaId) {
        return (mesaId >= 1 && mesaId <= 10) ? tableStatuses[mesaId - 1] : null;
    }

    private Label getTableCap(int mesaId) {
        return (mesaId >= 1 && mesaId <= 10) ? tableCaps[mesaId - 1] : null;
    }

    public ColaClientes getCola(){
        return this.colaClientes;
    }

    public void agregarCliente() {
        try {
            int mesaId = Integer.parseInt(table_choosen_fld.getText());
            int cantidadClientes = Integer.parseInt(costumer_cant_fld.getText());

            if (mesaId < 1 || mesaId > mesas.length) {
                error_lbl.setTextFill(Color.RED);
                error_lbl.setText("Número de mesa no encontrado");
                return;
            }

            Mesa numeroDeMesa = mesas[mesaId - 1];

            if (cantidadClientes <= 0) {
                error_lbl.setTextFill(Color.RED);
                error_lbl.setText("Debe ingresar al menos un cliente");
                return;
            }

            if (numeroDeMesa.getCantidad() !=0) {
                error_lbl.setTextFill(Color.RED);
                error_lbl.setText("Mesa ocupada, seleccione otra mesa");
                emptyfields();
                return;
            }

            // Agregar clientes
            colaClientes.Encolar(
                    name_costumer_fld.getText(),
                    dni_costumer_fld.getText(),
                    name_waiter_fld.getText(),
                    mesaId,
                    cantidadClientes
            );

            numeroDeMesa.clientes.agregarLista(
                    name_costumer_fld.getText(),
                    dni_costumer_fld.getText(),
                    name_waiter_fld.getText(),
                    mesaId,
                    cantidadClientes
            );
            numeroDeMesa.clientes.getCabeza().setCant(cantidadClientes);
            numeroDeMesa.setCantidad(numeroDeMesa.getCantidad() + cantidadClientes);
            actualizarEstadoMesa(mesaId);

            emptyfields();
        } catch (NumberFormatException e) {
            error_lbl.setTextFill(Color.RED);
            error_lbl.setText("Ingrese valores numéricos válidos");
        }
    }

    public void eliminarCliente(String dni, String Mesa) {
        Mesa numeroDeMesa = mesas[Integer.parseInt(Mesa) - 1];

        colaClientes.desencolarPorDNI(dni);
        numeroDeMesa.clientes.eliminarLista(dni);
        numeroDeMesa.setCantidad(0);

        actualizarEstadoMesa(Integer.parseInt(Mesa));
    }

    public void emptyfields() {
        table_choosen_fld.setText("");
        dni_costumer_fld.setText("");
        name_costumer_fld.setText("");
        name_waiter_fld.setText("");
        costumer_cant_fld.setText("");
    }

    public void actualizarEstadoMesa(int mesaId) {
        Mesa mesa = mesas[mesaId - 1];

        getTableCap(mesaId).setText(mesa.getCantidad() + "/" + mesa.getCapacidad());

        if (mesa.getCantidad() != 0) {
            getTableStatus(mesaId).setFill(Color.RED);
        } else {
            getTableStatus(mesaId).setFill(Color.GREEN);
        }

        Model.getInstance().setAllTransactions();
    }

    public void actualizarColoresDeEstado() {
        for (int i = 1; i <= mesas.length; i++) {
            actualizarEstadoMesa(i);
        }
    }
}
