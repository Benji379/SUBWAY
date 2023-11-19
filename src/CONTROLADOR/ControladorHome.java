package CONTROLADOR;

import DAO.ModeloDAO;
import MODELO.Action.ActionUtils;
import MODELO.Action.HoraActual;
import VISTA.pnlHome;
import javax.swing.Timer;

public class ControladorHome {

    private final pnlHome h;

    public ControladorHome(pnlHome h) {
        this.h = h;
        initDiseño();
    }

    private void initDiseño() {
        initTiempo();
        pnlHome.txtRango.setText(ModeloDAO.getRangoEmpleado(ModeloDAO.DNI_EMPLEADO));
    }

    public void initTiempo() {
        ActualizarHora();
        h.txtFecha.setText(ActionUtils.FechaActual());
        h.txtDia.setText(ActionUtils.getDiaSemana());
    }

    public void ActualizarHora() {
        Timer tiempo = new Timer(100, new HoraActual());
        tiempo.start();
    }
}
