package testeos.Controllers.Admin;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import testeos.Controllers.Structures.Cliente;
import testeos.Controllers.Structures.ColaClientes;
import testeos.Controllers.Structures.LDE_Clientes;
import testeos.Controllers.Structures.Mesa;
import testeos.Models.Model;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MenuController implements Initializable {
    @FXML public Label login_date, error_lbl;
    @FXML public Button table_btn;
    @FXML public TextField table_choosen_fld, dni_costumer_fld, name_costumer_fld, costumer_cant_fld;
    @FXML public ComboBox<String> waiter_cbb;
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

    private Mesa[] mesas = new Mesa[10];
    private ColaClientes colaClientes = new ColaClientes();
    private LDE_Clientes actualClientes = new LDE_Clientes();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().setDashboardController(this);
        tableCaps = new Label[]{table_cap_1, table_cap_2, table_cap_3, table_cap_4, table_cap_5,
                table_cap_6, table_cap_7, table_cap_8, table_cap_9, table_cap_10};
        tableStatuses = new FontAwesomeIconView[]{table_status_1, table_status_2, table_status_3,
                table_status_4, table_status_5, table_status_6, table_status_7, table_status_8, table_status_9, table_status_10};

        login_date.setText("Hoy, " + LocalDate.now());
        try {
            cargarArchivosCSV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actualizarColoresDeEstado();

        table_btn.setOnAction(event -> agregarCliente());
    }

    private void cargarArchivosCSV() throws IOException {
        BufferedReader bn = new BufferedReader(new FileReader("src/main/java/testeos/Views/waitersNames.csv"));
        BufferedReader bm = new BufferedReader(new FileReader("src/main/java/testeos/Views/mesasCapacidades.csv"));

        String linea;
        while ((linea = bn.readLine()) != null) {
            waiter_cbb.getItems().add(linea.trim());
        }

        int i = 0;
        while ((linea = bm.readLine()) != null && i < mesas.length) {
            mesas[i] = new Mesa(Integer.parseInt(linea.trim()));
            i++;
        }
        bn.close();
        bm.close();
    }

    public ColaClientes getCola() { return colaClientes; }
    public LDE_Clientes getActual() { return actualClientes; }

    public void agregarCliente() {
        try {
            int mesaId = Integer.parseInt(table_choosen_fld.getText());
            int cantidadClientes = Integer.parseInt(costumer_cant_fld.getText());

            if (!verificarMesaDisponible(mesaId, cantidadClientes)) return;

            Mesa mesa = mesas[mesaId - 1];

            if(mesaOcupada(mesaId)){
                colaClientes.Encolar(name_costumer_fld.getText(), dni_costumer_fld.getText(), waiter_cbb.getValue(), mesaId, cantidadClientes);
            } else {
                actualClientes.insertar(name_costumer_fld.getText(), dni_costumer_fld.getText(), waiter_cbb.getValue(), mesaId, cantidadClientes);
            }

            mesa.setCliente(name_costumer_fld.getText(), dni_costumer_fld.getText(), waiter_cbb.getValue(), cantidadClientes);
            mesa.setCantidad(cantidadClientes);

            actualizarEstadoMesa(mesaId);
            emptyFields();
        } catch (NumberFormatException e) {
            mostrarError("Ingrese valores numéricos válidos.");
        }
    }

    public void eliminarCliente(String dni, String mesaIdStr) {
        try {
            int mesaId = Integer.parseInt(mesaIdStr);
            Mesa mesa = mesas[mesaId - 1];

            actualClientes.eliminar(dni);

            Cliente clienteEnCola = colaClientes.existeClienteEnMesa(mesaId);
            if (clienteEnCola != null) {
                actualClientes.insertar(clienteEnCola.nombre, clienteEnCola.DNI, clienteEnCola.mesero, clienteEnCola.numMesa, clienteEnCola.cant);
                mesa.setCliente(clienteEnCola.nombre, clienteEnCola.DNI, clienteEnCola.mesero, clienteEnCola.cant);
                mesa.setCantidad(clienteEnCola.cant);
            } else {
                mesa.limpiar();
            }

            actualizarEstadoMesa(mesaId);
        } catch (NumberFormatException e) {
            mostrarError("Error al eliminar cliente: Datos inválidos.");
        }
    }


    private boolean verificarMesaDisponible(int mesaId, int cantidadClientes) {
        if (mesaId < 1 || mesaId > mesas.length) {
            mostrarError("Número de mesa no válido.");
            return false;
        }
        if (cantidadClientes <= 0) {
            mostrarError("Debe ingresar al menos un cliente.");
            return false;
        }
        return true;
    }

    private void emptyFields() {
        table_choosen_fld.clear();
        dni_costumer_fld.clear();
        name_costumer_fld.clear();
        costumer_cant_fld.clear();
        waiter_cbb.setValue(null);
    }

    private void mostrarError(String mensaje) {
        error_lbl.setTextFill(Color.RED);
        error_lbl.setText(mensaje);
    }

    private void actualizarEstadoMesa(int mesaId) {
        Mesa mesa = mesas[mesaId - 1];
        tableCaps[mesaId - 1].setText(mesa.getCantidad() + "/" + mesa.getCapacidad());
        tableStatuses[mesaId - 1].setFill(mesa.getCantidad() != 0 ? Color.RED : Color.GREEN);

        Model.getInstance().setAllQueueClients();
        Model.getInstance().setAllActualClients();
    }

    public void actualizarColoresDeEstado() {
        for (int i = 1; i <= mesas.length; i++) {
            actualizarEstadoMesa(i);
        }
    }

    private boolean mesaOcupada(int mesaId) {
        if (mesaId < 1 || mesaId > mesas.length) {
            return false;
        }
        return mesas[mesaId - 1].getCantidad() > 0;
    }
}
