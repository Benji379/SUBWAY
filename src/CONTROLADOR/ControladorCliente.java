package CONTROLADOR;

import DAO.ConexionSQL;
import DAO.ModeloDAO;
import MODELO.Action.tablasHash;
import MODELO.UIDesinger.UIController;
import VISTA.moduloCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import textfield_suggestion.TextFieldSuggestion;

public class ControladorCliente {

    Connection conexion;
    PreparedStatement consulta;
    ResultSet resultado;

    DefaultTableModel cliente_modelo;
    String cliente_idc;
    int cliente_filaSeleccionada = -1;

    ArrayList<String> clientesAutos;

    private final moduloCliente c;

    public ControladorCliente(moduloCliente c) {
        this.c = c;
        cliente_consultar();
        clientesAutos = new ArrayList<>();
        rellenarArrayList();
        tablasHash.setupTableSorting(c.tablaCliente);
    }

    private void cliente_consultar() {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM cliente");
            resultado = consulta.executeQuery();
            Object datos[] = new Object[4];
            cliente_modelo = (DefaultTableModel) c.tablaCliente.getModel();
            cliente_modelo.setRowCount(0);
            while (resultado.next()) {
                datos[0] = resultado.getString("dniCliente");
                datos[1] = resultado.getString("nombre");
                datos[2] = resultado.getString("apellido");
                datos[3] = resultado.getString("direccion");
                cliente_modelo.addRow(datos);
            }
            c.tablaCliente.setModel(cliente_modelo);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void rellenarArrayList() {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM cliente");
            resultado = consulta.executeQuery();
            while (resultado.next()) {
                String clienteAut = resultado.getString("dniCliente");
                clientesAutos.add(clienteAut);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void cliente_registrar() {
        try {
            String dni = c.cliente_txtDni.getText();
            String nombre = c.cliente_txtNombre.getText();
            String apellido = c.cliente_txtApellido.getText();
            String direccion = c.cliente_txtDireccion.getText();

            if (UIController.datosCompletos(dni, nombre, apellido, direccion)) {
                if (!ModeloDAO.existe("cliente", "dniCliente", dni)) {
                    conexion = new ConexionSQL().conexion();
                    consulta = conexion.prepareStatement("INSERT INTO cliente (dniCliente, nombre, apellido, direccion) VALUES (?,?,?,?)");
                    consulta.setString(1, dni);
                    consulta.setString(2, nombre);
                    consulta.setString(3, apellido);
                    consulta.setString(4, direccion);
                    consulta.executeUpdate();
                    cliente_consultar();
                    cliente_limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: Cliente existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Datos incompletos", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void cliente_modificar() {
        try {
            String nombre = c.cliente_txtNombre.getText();
            String apellido = c.cliente_txtApellido.getText();
            String direccion = c.cliente_txtDireccion.getText();

            if (UIController.datosCompletos(nombre, apellido, direccion)) {
                conexion = new ConexionSQL().conexion();
                consulta = conexion.prepareStatement("UPDATE cliente set nombre=?, apellido=?, direccion=? WHERE dniCliente=?");
                consulta.setString(1, nombre);
                consulta.setString(2, apellido);
                consulta.setString(3, direccion);
                consulta.setString(4, cliente_idc);
                consulta.executeUpdate();
                cliente_consultar();
                cliente_limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Datos incompletos", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void cliente_borrar() {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("DELETE FROM cliente WHERE dniCliente=?");
            consulta.setString(1, cliente_idc);
            consulta.executeUpdate();
            cliente_consultar();
            cliente_limpiar();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void cliente_limpiar() {
        UIController.vaciarTxtField(
                c.cliente_txtDni, c.cliente_txtNombre,
                c.cliente_txtApellido, c.cliente_txtDireccion
        );
        cliente_filaSeleccionada = -1;
        c.cliente_txtDni.setEditable(true);
    }

    public void rellenar(ArrayList<String> datos, TextFieldSuggestion text) {
        for (int i = 0; i < datos.size(); i++) {
            text.addItemSuggestion(datos.get(i));
        }
    }

    public void cliente_btnRegistrarActionPerformed() {
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Confirmar ingreso", "Confirmacion", dialog);
        if (result == 0) {
            cliente_registrar();
        }
    }

    public void cliente_btnBorrarActionPerformed() {
        if (cliente_filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        } else {
            int dialogo = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirmar eliminacion", "Confirmacion", dialogo);
            if (result == 0) {
                cliente_borrar();
            }
        }
    }

    public void cliente_btnActualizarActionPerformed() {
        if (cliente_filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirmar actualizacion", "Confirmacion", dialog);
            if (result == 0) {
                cliente_modificar();
            }
        }
    }

    public void tablaClienteMouseClicked() {
        cliente_filaSeleccionada = c.tablaCliente.getSelectedRow();

        cliente_idc = c.tablaCliente.getValueAt(cliente_filaSeleccionada, 0).toString();
        String nombre = c.tablaCliente.getValueAt(cliente_filaSeleccionada, 1).toString();
        String apellido = c.tablaCliente.getValueAt(cliente_filaSeleccionada, 2).toString();
        String direccion = c.tablaCliente.getValueAt(cliente_filaSeleccionada, 3).toString();

        c.cliente_txtDni.setText(cliente_idc);
        c.cliente_txtDni.setEditable(false);
        c.cliente_txtNombre.setText(nombre);
        c.cliente_txtApellido.setText(apellido);
        c.cliente_txtDireccion.setText(direccion);
    }

}
