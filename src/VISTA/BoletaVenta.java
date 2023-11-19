package VISTA;

import CONTROLADOR.ControladorBoletaVenta;

public class BoletaVenta extends javax.swing.JFrame {

    private final ControladorBoletaVenta controlador;

    public BoletaVenta() {
        initComponents();
        controlador = new ControladorBoletaVenta(this);
        controlador.initDiseño();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound6 = new MODELO.UIDesinger.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark1 = new MODELO.UIDesinger.TableDark();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtDireccionCliente = new javax.swing.JLabel();
        txtApellidoCliente = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        BarraTitulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Boleta");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/img/icons/factura.png")));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound6.setBackground(new java.awt.Color(0, 129, 93));
        panelRound6.setPreferredSize(new java.awt.Dimension(474, 560));
        panelRound6.setRoundBottomLeft(25);
        panelRound6.setRoundBottomRight(25);
        panelRound6.setRoundTopLeft(25);
        panelRound6.setRoundTopRight(25);
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableDark1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Servicio", "Precio", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDark1);

        panelRound6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 390, 230));

        jLabel23.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Cliente");
        panelRound6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 103, 33));

        jLabel24.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Empleado:");
        panelRound6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 123, 33));

        txtNombreCliente.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound6.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 158, 27));

        jLabel27.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Total: S/.");
        panelRound6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 103, 33));

        txtDireccionCliente.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtDireccionCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccionCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound6.add(txtDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 158, 27));

        txtApellidoCliente.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtApellidoCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtApellidoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound6.add(txtApellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 158, 27));

        txtTotal.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setText("0.0");
        panelRound6.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 158, 30));

        BarraTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BarraTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraTituloMouseDragged(evt);
            }
        });
        BarraTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraTituloMousePressed(evt);
            }
        });
        panelRound6.add(BarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 30));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        panelRound6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 30, -1));

        txtNombreEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtNombreEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        panelRound6.add(txtNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 180, 27));

        getContentPane().add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BarraTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraTituloMouseDragged
        controlador.BarraTituloMouseDragged(evt);
    }//GEN-LAST:event_BarraTituloMouseDragged

    private void BarraTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraTituloMousePressed
        controlador.BarraTituloMousePressed(evt);
    }//GEN-LAST:event_BarraTituloMousePressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoletaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BoletaVenta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BarraTitulo;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel27;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JScrollPane jScrollPane1;
    public MODELO.UIDesinger.PanelRound panelRound6;
    public MODELO.UIDesinger.TableDark tableDark1;
    public javax.swing.JLabel txtApellidoCliente;
    public javax.swing.JLabel txtDireccionCliente;
    public javax.swing.JLabel txtNombreCliente;
    public javax.swing.JLabel txtNombreEmpleado;
    public javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
