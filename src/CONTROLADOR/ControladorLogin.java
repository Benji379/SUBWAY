package CONTROLADOR;

import DAO.ModeloDAO;
import VISTA.frmLogin;
import VISTA.frmPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class ControladorLogin {

    private final frmLogin login;

    public ControladorLogin(frmLogin login) {
        this.login = login;
        initDiseño();
    }
    
    private void initDiseño(){
        login.setLocationRelativeTo(null);
        login.setBackground(new Color(0, 0, 0, 0));
    }
    int LayoutX;
    int LayoutY;
    
    public void BarraTituloMousePressed(MouseEvent evt) {                                         
        if (evt.getButton() == MouseEvent.BUTTON1) {
            LayoutX = evt.getX();
            LayoutY = evt.getY();
        }
    }                                        
    public void BarraTituloMouseDragged(MouseEvent evt) {                                         
        login.setLocation(evt.getXOnScreen() - LayoutX, evt.getYOnScreen() - LayoutY);
    }
    
    public void btnIngresarActionPerformed(ActionEvent evt) {                                            
        if (ModeloDAO.usuarioValido(login.txtUsuario.getText(), login.txtContraseña.getText())) {
            frmPrincipal abrir = new frmPrincipal();
            abrir.setVisible(true);
            login.setVisible(false);
            frmPrincipal.txtRango.setText(ModeloDAO.getRangoEmpleado(ModeloDAO.DNI_EMPLEADO));
        }
    }         
}
