package CONTROLADOR;

import DAO.ConexionSQL;
import MODELO.Action.ActionUtils;
import MODELO.Action.tablasHash;
import MODELO.UIDesinger.UIController;
import VISTA.moduloTrabajador;
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

public class ControladorEmpleado {

    Connection conexion;
    PreparedStatement consulta;
    ResultSet resultado;
    DefaultTableModel modelo;
    String idc;
    int filaSeleccionada = -1;
    private final moduloTrabajador t;

    public ControladorEmpleado(moduloTrabajador t) {
        this.t = t;
    }

    public void initDiseño() {
        t.scrollDatos.getViewport().setOpaque(false);
        initButton();
        mostrar();
        tablasHash.setupTableSorting(t.tablaTrabajadores);
    }

    private void initButton() {
        Cursor cursor = new Cursor(12);
        t.btnRegistrar.setCurrentCursor(cursor);
        t.btnBorrar.setCurrentCursor(cursor);
        t.btnActualizar.setCurrentCursor(cursor);
        t.btnLimpiar.setCurrentCursor(cursor);
    }

    private void mostrar() {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM empleados");
            resultado = consulta.executeQuery();
            Object datos[] = new Object[10];
            modelo = (DefaultTableModel) t.tablaTrabajadores.getModel();
            modelo.setRowCount(0);
            int i = 0;
            while (resultado.next()) {
                i++;
                datos[0] = i;
                datos[1] = resultado.getString("dni");
                datos[2] = resultado.getString("nombre");
                datos[3] = resultado.getString("apellido");
                datos[4] = resultado.getString("sexo");
                datos[5] = resultado.getString("correo");
                datos[6] = resultado.getString("direccion");
                datos[7] = resultado.getString("contraseña");
                datos[8] = resultado.getString("rango");
                datos[9] = resultado.getDate("fecha");
                modelo.addRow(datos);
            }
            t.tablaTrabajadores.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("ERROR:");
        }
    }

    private void registrar() {
        try {
            String dni = t.txtDni.getText();
            String nombre = t.txtNombre.getText();
            String apellido = t.txtApellido.getText();
            String sexo = (String) t.comboSexo.getSelectedItem();
            String correo = t.txtCorreo.getText();
            String direccion = t.txtDireccion.getText();
            String contraseña = t.txtContraseña.getText();
            String rango = (String) t.comboRango.getSelectedItem();
            if (UIController.datosCompletos(dni, nombre, apellido, sexo, correo, direccion, contraseña, rango)) {
                Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(ActionUtils.FechaActual());
                conexion = new ConexionSQL().conexion();
                consulta = conexion.prepareStatement("INSERT INTO empleados (dni,nombre,apellido,sexo,correo,direccion,contraseña,rango, fecha) VALUES (?,?,?,?,?,?,?,?,?)");
                consulta.setString(1, dni);
                consulta.setString(2, nombre);
                consulta.setString(3, apellido);
                consulta.setString(4, sexo);
                consulta.setString(5, correo);
                consulta.setString(6, direccion);
                consulta.setString(7, contraseña);
                consulta.setString(8, rango);
                consulta.setDate(9, new java.sql.Date(fecha.getTime()));
                filaSeleccionada = -1;
                consulta.executeUpdate();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Complete los datos");
            }
        } catch (SQLException | ParseException | NullPointerException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void actualizar() {
        try {
            String dni = t.txtDni.getText();
            String nombre = t.txtNombre.getText();
            String apellido = t.txtApellido.getText();
            String sexo = (String) t.comboSexo.getSelectedItem();
            String correo = t.txtCorreo.getText();
            String direccion = t.txtDireccion.getText();
            String contraseña = t.txtContraseña.getText();
            String rango = (String) t.comboRango.getSelectedItem();
            if (UIController.datosCompletos(dni, nombre, apellido, sexo, correo, direccion, contraseña, rango)) {
                Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(ActionUtils.FechaActual());
                conexion = new ConexionSQL().conexion();
                consulta = conexion.prepareStatement("UPDATE empleados set nombre=?, apellido=?, sexo=?, correo=?, direccion=?, contraseña=?, rango=?, fecha=? WHERE dni=?");
                consulta.setString(1, nombre);
                consulta.setString(2, apellido);
                consulta.setString(3, sexo);
                consulta.setString(4, correo);
                consulta.setString(5, direccion);
                consulta.setString(6, contraseña);
                consulta.setString(7, rango);
                consulta.setDate(8, new java.sql.Date(fecha.getTime()));
                consulta.setString(9, dni);
                consulta.executeUpdate();
                filaSeleccionada = -1;
                mostrar();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Complete los datos");
            }
        } catch (SQLException | ParseException | NullPointerException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void limpiar() {
        UIController.vaciarTxtField(t.txtDni, t.txtNombre, t.txtApellido, t.txtCorreo, t.txtContraseña, t.txtDireccion);
        t.comboSexo.setSelectedIndex(-1);
        t.comboRango.setSelectedIndex(-1);
        filaSeleccionada = -1;
    }

    public void btnRegistrarActionPerformed() {
        registrar();
        mostrar();
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
                    String dni = t.txtDni.getText();
                    conexion = new ConexionSQL().conexion();
                    consulta = conexion.prepareStatement("DELETE FROM empleados WHERE dni=?");
                    consulta.setString(1, dni);
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

    public void btnLimpiarActionPerformed() {
        limpiar();
        t.txtDni.setEditable(true);
    }

    public void tablaTrabajadoresMouseClicked() {
        filaSeleccionada = t.tablaTrabajadores.getSelectedRow();

        idc = t.tablaTrabajadores.getValueAt(filaSeleccionada, 1).toString();
        String nombre = t.tablaTrabajadores.getValueAt(filaSeleccionada, 2).toString();
        String apellido = t.tablaTrabajadores.getValueAt(filaSeleccionada, 3).toString();
        String sexo = t.tablaTrabajadores.getValueAt(filaSeleccionada, 4).toString();
        String correo = t.tablaTrabajadores.getValueAt(filaSeleccionada, 5).toString();
        String direccion = t.tablaTrabajadores.getValueAt(filaSeleccionada, 6).toString();
        String contraseña = t.tablaTrabajadores.getValueAt(filaSeleccionada, 7).toString();
        String rango = t.tablaTrabajadores.getValueAt(filaSeleccionada, 8).toString();

        t.txtDni.setText(idc);
        t.txtDni.setEditable(false);
        t.txtNombre.setText(nombre);
        t.txtApellido.setText(apellido);
        t.comboSexo.setSelectedItem(sexo);
        t.txtCorreo.setText(correo);
        t.txtDireccion.setText(direccion);
        t.txtContraseña.setText(contraseña);
        t.comboRango.setSelectedItem(rango);

    }

}
