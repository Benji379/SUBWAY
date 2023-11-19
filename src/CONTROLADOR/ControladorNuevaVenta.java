package CONTROLADOR;

import DAO.ConexionSQL;
import DAO.ModeloDAO;
import MODELO.Action.ActionUtils;
import MODELO.UIDesinger.UIController;
import VISTA.moduloNuevaVenta;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import textfield_suggestion.TextFieldSuggestion;

public class ControladorNuevaVenta {

    Connection conexion;
    PreparedStatement consulta;
    ResultSet resultado;
    DefaultTableModel modelo;
    int filaSeleccionada = -1;
    ArrayList<String> dniClientes;
    int contRowsTb = 0;
    private final moduloNuevaVenta v;

    public ControladorNuevaVenta(moduloNuevaVenta v) {
        this.v = v;
    }

    public void initDiseño() {
        rellenarCombo();
        UIController.transparentarTxtField(v.txtPagoEfectivo);
        v.combobox1.setSelectedIndex(0);
        UIController.removerBordeBlanco(v.jScrollPane2);
        v.jScrollPane2.getViewport().setOpaque(false);
        String nombreEmpleado = ModeloDAO.getDatos(ModeloDAO.DNI_EMPLEADO, "nombre")
                + " " + ModeloDAO.getDatos(ModeloDAO.DNI_EMPLEADO, "apellido");
        v.txtNameEmpleado.setText("Trabajador: " + nombreEmpleado);
        v.txtNombreEmpleado.setText(nombreEmpleado);
        dniClientes = new ArrayList<>();
        rellenarArrayList();
        rellenar(dniClientes, v.txtDniCliente);
    }

    private void añadirBoleta() {
        ArrayList<String> produc, cant, totl;
        produc = new ArrayList<>();
        cant = new ArrayList<>();
        totl = new ArrayList<>();

        for (int i = 0; i < v.tablaCompra.getRowCount(); i++) {
            produc.add(v.tablaCompra.getValueAt(i, 1).toString());
            cant.add(v.tablaCompra.getValueAt(i, 3).toString());
            totl.add(v.tablaCompra.getValueAt(i, 4).toString());
        }

        printPorducto(produc, cant, totl);
    }

    public void rellenarCombo() {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM productos");
            resultado = consulta.executeQuery();
            while (resultado.next()) {
                v.comboProducto.addItem(resultado.getString("nombre"));
            }
        } catch (SQLException | NullPointerException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void rellenar(ArrayList<String> datos, TextFieldSuggestion text) {
        for (int i = 0; i < datos.size(); i++) {
            text.addItemSuggestion(datos.get(i));
        }
    }

    private void printPorducto(
            ArrayList<String> producto,
            ArrayList<String> cantidad,
            ArrayList<String> total) {

        String productos = "";
        String cantidades = "";
        String totales = "";
        for (int i = 0; i < producto.size(); i++) {
            productos = productos + "<br>" + ActionUtils.limitPalabras(producto.get(i), 23);
        }
        for (int i = 0; i < cantidad.size(); i++) {
            cantidades = cantidades + "<br>" + cantidad.get(i);
        }
        for (int i = 0; i < total.size(); i++) {
            totales = totales + "<br>" + total.get(i);

        }
        v.txtProductos.setText("<html>" + productos + "</html>");
        v.txtCantidad.setText("<html>" + cantidades + "</html>");
        v.txtTotal.setText("<html>" + totales + "</html>");
    }

    private void REGISTRAR_VENTA_PRODUCTOS(String idVenta, String codigoProducto, String nombreProducto, int cantidad, double total) {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("INSERT INTO ventaproductos (idVenta,codigoProducto,cantidad,total) VALUES (?,?,?,?)");
            consulta.setString(1, idVenta);
            consulta.setString(2, codigoProducto);
            consulta.setInt(3, cantidad);
            consulta.setDouble(4, total);
            consulta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private String codigoProducto(String nombreProducto) {
        try {
            ResultSet res;
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM productos WHERE nombre=?");
            consulta.setString(1, nombreProducto);
            res = consulta.executeQuery();
            if (res.next()) {
                return res.getString("codigoProducto");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return null;
    }

    private void rellenarArrayList() {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM cliente");
            resultado = consulta.executeQuery();
            while (resultado.next()) {
                String clienteAut = resultado.getString("dniCliente");
                dniClientes.add(clienteAut);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void REGISTRAR_VENTA() {
        try {
            String dniTrabajador = ModeloDAO.DNI_EMPLEADO;
            String dniCliente = v.txtDniCliente.getText();
            double total = Double.parseDouble(v.txtTotalGeneral.getText());
            Date fecha = new SimpleDateFormat("yyy-mm-dd").parse(ActionUtils.FechaActual());
            int valorActualID = Integer.parseInt(valorActualID()) + 1;
            String nuevaID = String.format("%08d", valorActualID);
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("INSERT INTO venta (idVenta,trabajador,cliente,total,fecha) VALUES (?,?,?,?,?)");
            consulta.setString(1, nuevaID);
            consulta.setString(2, dniTrabajador);
            consulta.setString(3, dniCliente);
            consulta.setDouble(4, total);
            consulta.setDate(5, new java.sql.Date(fecha.getTime()));
            consulta.executeUpdate();
        } catch (SQLException | ParseException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private String valorActualID() {
        try {
            ResultSet res;
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM venta ORDER BY idVenta DESC LIMIT 1;");
            res = consulta.executeQuery();
            if (res.next()) {
                return res.getString("idVenta");
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return "00000000";
    }

    private void ACTUALIZAR_STOCK() {
        try {
            for (int i = 0; i < v.tablaCompra.getRowCount(); i++) {
                int cantidadDescontar = Integer.parseInt(v.tablaCompra.getValueAt(i, 3).toString());
                String nombreProducto = v.tablaCompra.getValueAt(i, 1).toString();
                descontarStock(cantidadDescontar, nombreProducto);
            }
        } catch (HeadlessException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("ERRRO: " + e.getMessage());
        }
    }

    private void descontarStock(int cantidadDescontar, String nameproducto) {
        int nuevoStock = obtenerStockProducto(nameproducto) - cantidadDescontar;
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("UPDATE productos set stock=? WHERE nombre=?");
            consulta.setInt(1, nuevoStock);
            consulta.setString(2, nameproducto);
            consulta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private int obtenerStockProducto(String nameProducto) {
        try {
            ResultSet res;
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM productos WHERE nombre=?");
            consulta.setString(1, nameProducto);
            res = consulta.executeQuery();
            if (res.next()) {
                return res.getInt("stock");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return 0;
    }

    private double getTotalGeneral() {
        double sumaTotal = 0;

        for (int i = 0; i < v.tablaCompra.getRowCount(); i++) {
            sumaTotal += Double.parseDouble(v.tablaCompra.getValueAt(i, 4).toString());
        }
        return sumaTotal;
    }

    private boolean stockSuficiente(int pedir, String nameProducto) {
        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM productos WHERE nombre=?");
            consulta.setString(1, nameProducto);
            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                int stockActual = rs.getInt("stock");
                if (pedir <= stockActual) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return false;
    }

    private void generarVuelto() {
        try {
            double vuelto = Double.parseDouble(v.txtPagoEfectivo.getText()) - Double.parseDouble(v.txtTotalGeneral.getText());
            v.txtVuelto.setText("" + vuelto);
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void consultarDatos(String nameTabla, String columnIdentificador,
            String identificador,
            String a, String b, String c,
            JLabel aa, JLabel bb, JLabel cc) {

        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM " + nameTabla + " WHERE " + columnIdentificador + "=?");
            ResultSet res;
            consulta.setString(1, identificador);
            res = consulta.executeQuery();
            if (res.next()) {
                aa.setText(res.getString(a));
                bb.setText(res.getString(b));
                cc.setText(res.getString(c));
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void seleccionar() {
        ResultSet resultadoDatos;

        try {
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM productos WHERE nombre=?");
            consulta.setString(1, (String) v.comboProducto.getSelectedItem());
            resultadoDatos = consulta.executeQuery();

            // Verificar si hay al menos un resultado antes de intentar acceder a los datos
            if (resultadoDatos.next()) {
                // Mover el cursor al primer resultado
                v.txtPrecio.setText("Precio: S/" + resultadoDatos.getDouble("precio"));
            } else {
                // Si no hay resultados, mostrar un mensaje
                System.out.println("No se encontraron resultados.");
            }

            // Cerrar el ResultSet y la conexión cuando hayas terminado
            resultadoDatos.close();
//            consulta.close();
//            conexion.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void btnFinalizarCompraActionPerformed() {
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Confirmar venta", "confirmacion", dialog);
        if (result == 0) {
            boolean todosDatosRellenados = UIController.datosCompletos(
                    v.txtNombreCliente.getText(), v.txtApellidoCliente.getText(), v.txtDireccionCliente.getText());
            if (todosDatosRellenados) {
                if (Double.parseDouble(v.txtPagoEfectivo.getText()) >= Double.parseDouble(v.txtTotalGeneral.getText())) {
                    if (Double.parseDouble(v.txtTotalGeneral.getText()) > 0) {
                        ACTUALIZAR_STOCK();
                        REGISTRAR_VENTA();
                        for (int i = 0; i < v.tablaCompra.getRowCount(); i++) {
                            String nombreProducto = v.tablaCompra.getValueAt(i, 1).toString();
                            int cantidad = Integer.parseInt(v.tablaCompra.getValueAt(i, 3).toString());
                            double total = Double.parseDouble(v.tablaCompra.getValueAt(i, 4).toString());
                            REGISTRAR_VENTA_PRODUCTOS(valorActualID(), codigoProducto(nombreProducto), nombreProducto, cantidad, total);
                        }
                        JOptionPane.showMessageDialog(null, "Venta realizada con exito");

                    } else {
                        JOptionPane.showMessageDialog(null, "Registre un producto");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cancele el pago");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene con datos válidos");
            }

        }
    }

    public void button1ActionPerformed() {
        try {
            int cantidad = Integer.parseInt(v.txtCantidadProducto.getText());
            ResultSet resul;
            String productoElegido = (String) v.comboProducto.getSelectedItem();
            conexion = new ConexionSQL().conexion();
            consulta = conexion.prepareStatement("SELECT * FROM productos WHERE nombre=?");
            consulta.setString(1, productoElegido);
            Object datos[] = new Object[5];
            modelo = (DefaultTableModel) v.tablaCompra.getModel();
            resul = consulta.executeQuery();

            int filaExistente = -1;
            if (stockSuficiente(cantidad, productoElegido)) {
                for (int j = 0; j < v.tablaCompra.getRowCount(); j++) {
                    String nombreTabla = v.tablaCompra.getValueAt(j, 1).toString();
                    if (productoElegido.equals(nombreTabla)) {
                        filaExistente = j;
                        break;
                    }
                }

                if (filaExistente != -1) {
                    int cantidadActualTabla = Integer.parseInt(v.tablaCompra.getValueAt(filaExistente, 3).toString());
                    int totalCantidadActual = cantidadActualTabla + cantidad;
                    if (stockSuficiente(totalCantidadActual, productoElegido)) {
                        v.tablaCompra.setValueAt(totalCantidadActual, filaExistente, 3);
                        double preci = Double.parseDouble(v.tablaCompra.getValueAt(filaExistente, 2).toString());
                        double mont = preci * totalCantidadActual;
//                        System.out.println("Precio: " + preci);
//                        System.out.println("Cantidada actual : " + totalCantidadActual);
                        v.tablaCompra.setValueAt(String.format(Locale.US, "%.2f", mont), filaExistente, 4);
                        v.txtTotalGeneral.setText("" + getTotalGeneral());
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Ah rebasado el stock");
                    }
                } else {
                    if (resul.next()) {
                        contRowsTb++;
                        double precio = resul.getDouble("precio");
                        double total = resul.getDouble("precio") * cantidad;
                        datos[0] = contRowsTb;
                        datos[1] = productoElegido;
                        datos[2] = precio;
                        datos[3] = cantidad;
                        datos[4] = total;
                        modelo.addRow(datos);
                        v.txtTotalGeneral.setText("" + getTotalGeneral());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: No hay stock suficiente");
            }

            v.tablaCompra.setModel(modelo);
        } catch (SQLException | NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        añadirBoleta();
    }

    public void button2ActionPerformed() {
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            modelo.removeRow(filaSeleccionada);
            v.txtTotalGeneral.setText("" + getTotalGeneral());
            actualizarContenidoTabla();
            añadirBoleta();
            filaSeleccionada = -1;
        }
    }

    private void actualizarContenidoTabla() {
        for (int i = 0; i < v.tablaCompra.getRowCount(); i++) {
            v.tablaCompra.setValueAt((i + 1), i, 0);
        }
    }

    public void comboProductoActionPerformed() {
        seleccionar();
    }

    public void combobox1ActionPerformed() {
        try {
            if (v.combobox1.getSelectedIndex() == 0) {
                v.txtPagoEfectivo.setEditable(true);
                v.txtPagoEfectivo.setText("0.0");
            } else {
                v.txtPagoEfectivo.setEditable(false);
                v.txtPagoEfectivo.setText(v.txtTotalGeneral.getText());
            }
            generarVuelto();
        } catch (NullPointerException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void txtPagoEfectivoKeyReleased() {
        generarVuelto();
    }

    public void txtDniClienteKeyReleased() {
        String nTabla = "cliente";
        String c1 = "nombre";
        String c2 = "apellido";
        String c3 = "direccion";
        consultarDatos(nTabla, "dniCliente", v.txtDniCliente.getText(), c1, c2, c3, v.txtNombreCliente, v.txtApellidoCliente, v.txtDireccionCliente);
    }

    public void tablaCompraMouseClicked() {
        filaSeleccionada = v.tablaCompra.getSelectedRow();
    }

    public void txtPagoEfectivoMouseExited() {
        generarVuelto();
    }

    public void txtPagoEfectivoFocusLost() {
        if (v.txtPagoEfectivo.getText().equals("")) {
            v.txtPagoEfectivo.setText("0.0");
        }
    }

}
