package MODELO.Action;

import DAO.ConexionSQL;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class tablasHash {

    //SE APLICO LISTAS ENLAZADAS
    public static void filterAndPopulateTable(JTable jTable, JTextField dniTrabajador, JTextField dniCliente, JTextField montoMinimo, JTextField montoMaximo) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);

        ConexionSQL conexionSQL = new ConexionSQL();
        Connection connection = conexionSQL.conexion();

        if (connection != null) {
            try {
                String query = "SELECT * FROM venta WHERE trabajador LIKE ? AND cliente LIKE ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, "%" + dniTrabajador.getText() + "%");
                statement.setString(2, "%" + dniCliente.getText() + "%");

                ResultSet resultSet = statement.executeQuery();

                LinkedList<Object[]> results = new LinkedList<>(); // Lista enlazada para almacenar los resultados

                while (resultSet.next()) {
                    Object[] rowData = new Object[5];
                    rowData[0] = resultSet.getString("idVenta");
                    rowData[1] = resultSet.getString("trabajador");
                    rowData[2] = resultSet.getString("cliente");
                    rowData[3] = resultSet.getDouble("total");
                    rowData[4] = resultSet.getDate("fecha");
                    results.add(rowData); // Almacenar cada fila en la lista enlazada
                }

                double min = montoMinimo.getText().isEmpty() ? 0 : Double.parseDouble(montoMinimo.getText());
                double max = montoMaximo.getText().isEmpty() ? Double.MAX_VALUE : Double.parseDouble(montoMaximo.getText());

                LinkedList<Object[]> filteredResults = new LinkedList<>(); // Lista enlazada para almacenar resultados filtrados

                for (Object[] row : results) {
                    double total = (Double) row[3];
                    if (total >= min && total <= max) {
                        filteredResults.add(row); // Filtrar por rango de monto
                    }
                }

                for (Object[] row : filteredResults) {
                    tableModel.addRow(row);
                }

                jTable.setModel(tableModel);

            } catch (SQLException e) {
                System.out.println("ERROR: " + e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }
    }

    private static boolean ascending = true;

    /**
     * *
     *
     * @param table se implementa un enfoque personalizado de comparación para
     * lograr el ordenamiento deseado en el JTable.
     */
    public static void setupTableSorting(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Creamos un comparador personalizado para manejar diferentes tipos de datos
        Comparator<Object> customComparator = (Object obj1, Object obj2) -> {
            if (obj1 instanceof Integer && obj2 instanceof Integer) {
                Integer int1 = (Integer) obj1;
                Integer int2 = (Integer) obj2;
                return int1.compareTo(int2);
            } else {
                String str1 = obj1.toString();
                String str2 = obj2.toString();
                return str1.compareToIgnoreCase(str2);
            }
        };

        // Asignamos el comparador personalizado para todas las columnas
        for (int i = 0; i < model.getColumnCount(); i++) {
            sorter.setComparator(i, customComparator);
        }

        // Asignamos el listener para detectar clics en los encabezados
        table.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int column = table.getTableHeader().columnAtPoint(evt.getPoint());
                if (column != -1) {
                    if (ascending) {
                        sorter.setComparator(column, Comparator.reverseOrder());
                        ascending = false;
                    } else {
                        sorter.setComparator(column, customComparator);
                        ascending = true;
                    }
                    sorter.sort();
                }
            }
        });
    }

    /**
     * *
     *
     * @param table En la implementación proporcionada, no se está utilizando
     * directamente un árbol binario de búsqueda (BST). En lugar de eso, se está
     * utilizando un TreeSet, que internamente implementa un árbol rojo-negro,
     * una variante de los árboles binarios de búsqueda.
     * @param referenceRow
     */
    // Método para ordenar un JTable por una columna específica
    public static void sortJTableByColumn(JTable table, int referenceRow) {
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Crear un conjunto ordenado (TreeSet) para almacenar las filas con el comparador basado en la columna de referencia
        TreeSet<Object[]> sortedRows = new TreeSet<>(Comparator
                .comparing((Object[] row) -> row[referenceRow] == null ? "" : row[referenceRow].toString()));

        // Agregar todas las filas al conjunto ordenado
        for (int i = 0; i < model.getRowCount(); i++) {
            // Crear un array para representar la fila
            Object[] row = new Object[model.getColumnCount()];
            for (int j = 0; j < model.getColumnCount(); j++) {
                // Obtener el valor de cada celda en la fila
                row[j] = model.getValueAt(i, j);
            }
            // Agregar la fila al conjunto ordenado
            sortedRows.add(row);
        }

        // Limpiar el modelo de la tabla (eliminar todas las filas existentes)
        model.setRowCount(0);

        // Agregar las filas ordenadas de nuevo al modelo de la tabla
        for (Object[] row : sortedRows) {
            model.addRow(row);
        }
    }

    //SE UTILIZARON GRAFOS Y HashMaps
    //SE USARON HASH MAPS PORQUE LOS HASH TABLE SON UNA CLASES EN DESUSO Y LOS HASH MAPS ES LA CLASE ACTUAL
    public static void ordenarTablaPorColumna(JTable tabla, int numeroColumna) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filas = modelo.getRowCount();

        // Crear un grafo ponderado utilizando un mapa
        Map<Integer, List<Integer>> grafo = new HashMap<>();

        // Inicializar el grafo
        for (int i = 0; i < filas; i++) {
            int valorActual = (int) tabla.getValueAt(i, numeroColumna);
            grafo.putIfAbsent(valorActual, new ArrayList<>());
        }

        // Agregar arcos ponderados al grafo
        for (int i = 0; i < filas - 1; i++) {
            int valorActual = (int) tabla.getValueAt(i, numeroColumna);
            int valorSiguiente = (int) tabla.getValueAt(i + 1, numeroColumna);
            grafo.get(valorActual).add(valorSiguiente);
        }

        // Realizar ordenación topológica
        List<Integer> ordenTopologico = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();

        for (int nodo : grafo.keySet()) {
            if (!visitados.contains(nodo)) {
                dfs(nodo, grafo, visitados, ordenTopologico);
            }
        }

        // Crear una nueva tabla ordenada
        DefaultTableModel nuevaTabla = new DefaultTableModel(modelo.getColumnCount(), filas);

        // Llenar la nueva tabla en el orden topológico
        for (int i = 0; i < filas; i++) {
            int filaOriginal = ordenTopologico.get(i);
            for (int j = 0; j < modelo.getColumnCount(); j++) {
                nuevaTabla.setValueAt(tabla.getValueAt(filaOriginal, j), i, j);
            }
        }

        // Establecer el nuevo modelo en la tabla
        tabla.setModel(nuevaTabla);
    }

    private static void dfs(int nodo, Map<Integer, List<Integer>> grafo, Set<Integer> visitados, List<Integer> ordenTopologico) {
        visitados.add(nodo);

        for (int vecino : grafo.getOrDefault(nodo, Collections.emptyList())) {
            if (!visitados.contains(vecino)) {
                dfs(vecino, grafo, visitados, ordenTopologico);
            }
        }

        ordenTopologico.add(0, nodo); // Agregar al inicio de la lista para obtener el orden topológico inverso
    }

}
