package CONTROLADOR;

import DAO.ConexionSQL;
import DAO.ModeloDAO;
import VISTA.BoletaVenta;
import VISTA.moduloListaVentas;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ControladorBoletaVenta {

    Connection conexion;
    ResultSet resultado;
    PreparedStatement consulta;
    DefaultTableModel modelo;

    String CodigoVenta = moduloListaVentas.codigoVenta;
    String codigoEmpleado = moduloListaVentas.codigoEmpleado;
    String codigoCliente = moduloListaVentas.codigoCliente;

    String empleado = ModeloDAO.consultarDato("empleados", "dni", codigoEmpleado, "nombre", "String").toString() + " "
            + ModeloDAO.consultarDato("empleados", "dni", codigoEmpleado, "apellido", "String").toString();

    String nombreCliente = ModeloDAO.consultarDato("cliente", "dniCliente", codigoCliente, "nombre", "String").toString();
    String apellidoCliente = ModeloDAO.consultarDato("cliente", "dniCliente", codigoCliente, "apellido", "String").toString();
    String direccion = ModeloDAO.consultarDato("cliente", "dniCliente", codigoCliente, "direccion", "String").toString();

    private final BoletaVenta b;

    public ControladorBoletaVenta(BoletaVenta b) {
        this.b = b;
    }

    public void initDiseño() {
        b.setLocationRelativeTo(null);
        b.setBackground(new Color(0, 0, 0, 0));
        consultar(CodigoVenta);
//        System.out.println(CodigoVenta);
        double acum = 0;
        for (int i = 0; i < b.tableDark1.getRowCount(); i++) {
            acum = acum + Double.parseDouble(b.tableDark1.getValueAt(i, 3).toString());
        }
        b.txtTotal.setText("" + acum);
    }

    private void consultar(String codigoVenta) {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM ventaProductos ventaP inner join productos prod on ventaP.codigoProducto = prod.codigoProducto WHERE idVenta=?");
            consulta.setString(1, codigoVenta);
            resultado = consulta.executeQuery();
            Object datos[] = new Object[4];
            modelo = (DefaultTableModel) b.tableDark1.getModel();
            modelo.setRowCount(0);
            while (resultado.next()) {
                datos[0] = resultado.getString("nombre");
                datos[1] = resultado.getDouble("precio");
                datos[2] = resultado.getInt("cantidad");
                datos[3] = resultado.getDouble("total");
                modelo.addRow(datos);
            }
            b.txtNombreEmpleado.setText(empleado);

            b.txtNombreCliente.setText(nombreCliente);
            b.txtApellidoCliente.setText(apellidoCliente);
            b.txtDireccionCliente.setText(direccion);

            b.tableDark1.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    int LayoutX;
    int LayoutY;

    public void BarraTituloMouseDragged(java.awt.event.MouseEvent evt) {
        b.setLocation(evt.getXOnScreen() - LayoutX, evt.getYOnScreen() - LayoutY);
    }

    public void BarraTituloMousePressed(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            LayoutX = evt.getX();
            LayoutY = evt.getY();
        }
    }

}
