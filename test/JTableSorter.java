import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class JTableSorter {

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

    public static void main(String[] args) {
        // Crear un ejemplo de JTable
        JTable jTable = new JTable(new DefaultTableModel(
                new Object[][]{
                        {"John", 25},
                        {"Alice", 30},
                        {"Bob", 22},
                        // Agrega más filas según sea necesario
                },
                new Object[]{"Name", "Age"}));

        // Antes de ordenar
        System.out.println("Antes de ordenar:");
        printTable(jTable);

        // Ordenar por la segunda columna (índice 1)
        sortJTableByColumn(jTable, 0);

        // Después de ordenar
        System.out.println("\nDespués de ordenar:");
        printTable(jTable);
    }

    // Método auxiliar para imprimir el contenido de la tabla
    private static void printTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                System.out.print(model.getValueAt(i, j) + "\t");
            }
            System.out.println();
        }
    }
}
