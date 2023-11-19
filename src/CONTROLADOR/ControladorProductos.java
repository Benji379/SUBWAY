package CONTROLADOR;

import DAO.ConexionSQL;
import MODELO.Action.ActionUtils;
import MODELO.Action.tablasHash;
import MODELO.UIDesinger.UIController;
import VISTA.moduloProductos;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorProductos {

    private final moduloProductos p;
    Connection conexion;
    PreparedStatement consulta;
    ResultSet resultado;
    DefaultTableModel modelo;
    String idc;
    int filaSeleccionada = -1;

    public ControladorProductos(moduloProductos p) {
        this.p = p;
        mostrar();
    }

    public void initDiseño() {
        initButton();
        if (ControladorFrmPrincipal.rango.equalsIgnoreCase("empleado")) {
            p.panelBotones.setVisible(false);
        }
        tablasHash.setupTableSorting(p.tablaProductos);
    }

    private void mostrar() {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM productos");
            resultado = consulta.executeQuery();
            Object datos[] = new Object[6];
            modelo = (DefaultTableModel) p.tablaProductos.getModel();
            modelo.setRowCount(0);
            while (resultado.next()) {
                datos[0] = resultado.getString("codigoProducto");
                datos[1] = resultado.getString("nombre");
                datos[2] = resultado.getDouble("precio");
                datos[3] = resultado.getInt("stock");
                datos[4] = resultado.getDate("fecha");
                modelo.addRow(datos);
            }
            p.tablaProductos.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void registrar() {
        try {
            String codigo = p.txtCodigo.getText();
            String nombre = p.txtNombre.getText();
            double precio = Double.parseDouble(p.txtPrecio.getText());
            int stock = Integer.parseInt(p.txtStock.getText());
            if (UIController.datosCompletos(codigo, nombre, String.valueOf(precio), String.valueOf(stock))) {
                Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(ActionUtils.FechaActual());
                conexion = new ConexionSQL().conexion();
                consulta = conexion.prepareStatement("INSERT INTO productos (codigoProducto, nombre, precio, stock, fecha) VALUES (?,?,?,?,?)");
                consulta.setString(1, codigo);
                consulta.setString(2, nombre);
                consulta.setDouble(3, precio);
                consulta.setInt(4, stock);
                consulta.setDate(5, new java.sql.Date(fecha.getTime()));
                consulta.executeUpdate();
                filaSeleccionada = -1;
                limpiar();
                mostrar();
            } else {
                JOptionPane.showMessageDialog(null, "Datos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | NumberFormatException | ParseException e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "Error" + JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            String codigo = p.txtCodigo.getText();
            String nombre = p.txtNombre.getText();
            double precio = Double.parseDouble(p.txtPrecio.getText());
            int stock = Integer.parseInt(p.txtStock.getText());
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(ActionUtils.FechaActual());
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("UPDATE productos set nombre=?, precio=?, stock=?, fecha=? WHERE codigoProducto=?");
            consulta.setString(1, nombre);
            consulta.setDouble(2, precio);
            consulta.setInt(3, stock);
            consulta.setDate(4, new java.sql.Date(fecha.getTime()));
            consulta.setString(5, codigo);
            consulta.executeUpdate();
            filaSeleccionada = -1;
            limpiar();
            mostrar();
        } catch (SQLException | NumberFormatException | ParseException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void limpiar() {
        UIController.vaciarTxtField(p.txtCodigo, p.txtNombre, p.txtPrecio, p.txtStock);
    }

    public void btnActualizarActionPerformed() {
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        } else {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirmar actualizacion", "Confirmacion", dialog);
            if (result == 0) {
                actualizar();
            }
        }
    }

    public void btnBorrarActionPerformed() {
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        } else {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirmar eliminacion", "Confirmacion", dialog);
            if (result == 0) {
                try {
                    String codigo = p.txtCodigo.getText();
                    conexion = new ConexionSQL().conexion();
                    consulta = conexion.prepareStatement("DELETE FROM productos WHERE codigoProducto=?");
                    consulta.setString(1, codigo);
                    consulta.executeUpdate();
                    filaSeleccionada = -1;
                    limpiar();
                    mostrar();
                } catch (SQLException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }
    }

    public void tablaProductosMouseClicked() {
        filaSeleccionada = p.tablaProductos.getSelectedRow();

        idc = p.tablaProductos.getValueAt(filaSeleccionada, 0).toString();
        String nombre = p.tablaProductos.getValueAt(filaSeleccionada, 1).toString();
        String precio = p.tablaProductos.getValueAt(filaSeleccionada, 2).toString();
        String stock = p.tablaProductos.getValueAt(filaSeleccionada, 3).toString();
        p.txtCodigo.setText(idc);
        p.txtNombre.setText(nombre);
        p.txtPrecio.setText(precio);
        p.txtStock.setText(stock);
    }

    private void initButton() {
        Cursor cursor = new Cursor(12);
        p.btnRegistrar.setCurrentCursor(cursor);
        p.btnBorrar.setCurrentCursor(cursor);
        p.btnActualizar.setCurrentCursor(cursor);
        p.btnLimpiar.setCurrentCursor(cursor);
    }

}
