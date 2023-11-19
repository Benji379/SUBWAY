package CONTROLADOR;

import DAO.ConexionSQL;
import MODELO.Action.tablasHash;
import MODELO.UIDesinger.UIController;
import VISTA.BoletaVenta;
import VISTA.moduloListaVentas;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class ControladorListaVentas {

    Connection conexion;
    PreparedStatement consulta;
    ResultSet resultado;
    DefaultTableModel modelo;
    int filaSeleccionada = -1;
    String idc;

    private final moduloListaVentas v;

    public ControladorListaVentas(moduloListaVentas v) {
        this.v = v;
    }

    public void initDiseño() {
        consultaDatosVenta();
        UIController.transparentarTxtField(v.txtDniTrabajador, v.txtDniCliente, v.txtMin, v.txtMax);
        tablasHash.setupTableSorting(v.tablaVentas);
        cambiosText();
    }

    private void consultaDatosVenta() {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM venta");
            resultado = consulta.executeQuery();

            Object datos[] = new Object[5];
            modelo = (DefaultTableModel) v.tablaVentas.getModel();
            modelo.setRowCount(0);
            while (resultado.next()) {
                datos[0] = resultado.getString("idVenta");
                datos[1] = resultado.getString("trabajador");
                datos[2] = resultado.getString("cliente");
                datos[3] = resultado.getDouble("total");
                datos[4] = resultado.getDate("fecha");
                modelo.addRow(datos);
            }
            v.tablaVentas.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void tablaVentasMouseClicked(MouseEvent evt) {
        filaSeleccionada = v.tablaVentas.getSelectedRow();
        if (evt.getClickCount() == 2) {
            moduloListaVentas.codigoVenta = v.tablaVentas.getValueAt(filaSeleccionada, 0).toString();
            moduloListaVentas.codigoEmpleado = v.tablaVentas.getValueAt(filaSeleccionada, 1).toString();
            moduloListaVentas.codigoCliente = v.tablaVentas.getValueAt(filaSeleccionada, 2).toString();
            BoletaVenta abrir = new BoletaVenta();
            abrir.setVisible(true);
        }
    }

    private void cambiosText() {
        detectarCambio(v.txtDniTrabajador);
        detectarCambio(v.txtDniCliente);
        detectarCambio(v.txtMin);
        detectarCambio(v.txtMax);
    }

    private void detectarCambio(JTextField textField) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se llama cuando se inserta texto en el JTextField
                tablasHash.filterAndPopulateTable(v.tablaVentas, v.txtDniTrabajador, v.txtDniCliente, v.txtMin, v.txtMax);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se llama cuando se elimina texto del JTextField
                tablasHash.filterAndPopulateTable(v.tablaVentas, v.txtDniTrabajador, v.txtDniCliente, v.txtMin, v.txtMax);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Se llama cuando hay un cambio en atributos del texto (por ejemplo, estilo)
                tablasHash.filterAndPopulateTable(v.tablaVentas, v.txtDniTrabajador, v.txtDniCliente, v.txtMin, v.txtMax);
            }
        });
    }

}
