package CONTROLADOR;

import DAO.ModeloDAO;
import MODELO.UIDesinger.UIController;
import VISTA.frmPrincipal;
import VISTA.pnlHome;
import java.awt.Cursor;
import javax.swing.JPanel;

public class ControladorFrmPrincipal {

    private final frmPrincipal p;
    public static String rango = ModeloDAO.getRangoEmpleado(ModeloDAO.DNI_EMPLEADO);

    public ControladorFrmPrincipal(frmPrincipal p) {
        this.p = p;
        initDiseño();
    }

    private void initDiseño() {
        initPanel();
        p.setLocationRelativeTo(null);

        UIController.MostrarPanel(p.CONTENEDOR, new pnlHome(), 865, 576);
        UIController.removerBordeBlanco(p.scrollContenedor);
        p.pictureBox1.setCursor(new Cursor(12));
        frmPrincipal.txtRango.setText(rango);
        if (rango.equalsIgnoreCase("empleado")) {
            p.btnTrabajador.setVisible(false);
        }

    }

    private void initPanel() {
        UIController.setPanelBackgroundColors(p.btnTrabajador, "#008853", "#005D53");
        UIController.setPanelBackgroundColors(p.btnProductos, "#008853", "#005D53");
        UIController.setPanelBackgroundColors(p.btnContratos, "#008853", "#005D53");
        UIController.setPanelBackgroundColors(p.btnAutos, "#008853", "#005D53");
    }

    public void cambiarPanel(JPanel panel) {
        p.scrollContenedor.getVerticalScrollBar().setValue(0);
        UIController.MostrarPanel(p.CONTENEDOR, panel, 865, 576);
    }
}
