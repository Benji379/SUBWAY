package VISTA;

import CONTROLADOR.ControladorFrmPrincipal;

public class frmPrincipal extends javax.swing.JFrame {

    private final ControladorFrmPrincipal controlador;

    public frmPrincipal() {
        initComponents();
        controlador = new ControladorFrmPrincipal(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new MODELO.UIDesinger.PanelRound();
        btnTrabajador = new MODELO.UIDesinger.PanelRound();
        pictureBox2 = new MODELO.UIDesinger.PictureBox();
        jLabel1 = new javax.swing.JLabel();
        btnProductos = new MODELO.UIDesinger.PanelRound();
        pictureBox3 = new MODELO.UIDesinger.PictureBox();
        jLabel2 = new javax.swing.JLabel();
        btnAutos = new MODELO.UIDesinger.PanelRound();
        pictureBox5 = new MODELO.UIDesinger.PictureBox();
        jLabel4 = new javax.swing.JLabel();
        btnContratos = new MODELO.UIDesinger.PanelRound();
        pictureBox4 = new MODELO.UIDesinger.PictureBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pictureBox1 = new MODELO.UIDesinger.PictureBox();
        txtRango = new javax.swing.JLabel();
        scrollContenedor = new MODELO.UIDesinger.Scroll.ScrollPaneWin11();
        CONTENEDOR = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SubWay");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/img/icons/icon.png")));

        jPanel1.setBackground(new java.awt.Color(233, 181, 30));
        jPanel1.setToolTipText("");

        panelRound1.setBackground(new java.awt.Color(0, 129, 93));
        panelRound1.setRoundBottomLeft(15);
        panelRound1.setRoundBottomRight(15);
        panelRound1.setRoundTopLeft(15);
        panelRound1.setRoundTopRight(15);

        btnTrabajador.setBackground(new java.awt.Color(0, 129, 93));
        btnTrabajador.setCustomCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrabajador.setRoundBottomLeft(10);
        btnTrabajador.setRoundBottomRight(10);
        btnTrabajador.setRoundTopLeft(10);
        btnTrabajador.setRoundTopRight(10);
        btnTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrabajadorMouseClicked(evt);
            }
        });
        btnTrabajador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/trabajador.png"))); // NOI18N
        btnTrabajador.add(pictureBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trabajador");
        btnTrabajador.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        btnProductos.setBackground(new java.awt.Color(0, 129, 93));
        btnProductos.setCustomCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setRoundBottomLeft(10);
        btnProductos.setRoundBottomRight(10);
        btnProductos.setRoundTopLeft(10);
        btnProductos.setRoundTopRight(10);
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosMouseClicked(evt);
            }
        });
        btnProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/productos.png"))); // NOI18N
        btnProductos.add(pictureBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Productos");
        btnProductos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 30));

        btnAutos.setBackground(new java.awt.Color(0, 129, 93));
        btnAutos.setCustomCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAutos.setRoundBottomLeft(10);
        btnAutos.setRoundBottomRight(10);
        btnAutos.setRoundTopLeft(10);
        btnAutos.setRoundTopRight(10);
        btnAutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAutosMouseClicked(evt);
            }
        });
        btnAutos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/cliente.png"))); // NOI18N
        btnAutos.add(pictureBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Clientes");
        btnAutos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        btnContratos.setBackground(new java.awt.Color(0, 129, 93));
        btnContratos.setCustomCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnContratos.setRoundBottomLeft(10);
        btnContratos.setRoundBottomRight(10);
        btnContratos.setRoundTopLeft(10);
        btnContratos.setRoundTopRight(10);
        btnContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContratosMouseClicked(evt);
            }
        });
        btnContratos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pictureBox4.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/contrato.png"))); // NOI18N
        btnContratos.add(pictureBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ventas");
        btnContratos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 30));

        jPanel2.setBackground(new java.awt.Color(0, 129, 93));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/iconoUsuario.png"))); // NOI18N
        pictureBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox1MouseClicked(evt);
            }
        });

        txtRango.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txtRango.setForeground(new java.awt.Color(255, 255, 255));
        txtRango.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRango.setText("Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRango, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRango)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContratos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnAutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnContratos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        CONTENEDOR.setBackground(new java.awt.Color(0, 129, 93));
        CONTENEDOR.setLayout(new java.awt.CardLayout());
        scrollContenedor.setViewportView(CONTENEDOR);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollContenedor)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadorMouseClicked
        controlador.cambiarPanel(new moduloTrabajador());
    }//GEN-LAST:event_btnTrabajadorMouseClicked

    private void btnProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseClicked
        controlador.cambiarPanel(new moduloProductos());
    }//GEN-LAST:event_btnProductosMouseClicked

    private void btnAutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAutosMouseClicked
        controlador.cambiarPanel(new moduloCliente());
    }//GEN-LAST:event_btnAutosMouseClicked

    private void btnContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContratosMouseClicked
        controlador.cambiarPanel(new moduloVentas());
    }//GEN-LAST:event_btnContratosMouseClicked

    private void pictureBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseClicked
        controlador.cambiarPanel(new pnlHome());
    }//GEN-LAST:event_pictureBox1MouseClicked

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel CONTENEDOR;
    public MODELO.UIDesinger.PanelRound btnAutos;
    public MODELO.UIDesinger.PanelRound btnContratos;
    public MODELO.UIDesinger.PanelRound btnProductos;
    public MODELO.UIDesinger.PanelRound btnTrabajador;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public MODELO.UIDesinger.PanelRound panelRound1;
    public MODELO.UIDesinger.PictureBox pictureBox1;
    public MODELO.UIDesinger.PictureBox pictureBox2;
    public MODELO.UIDesinger.PictureBox pictureBox3;
    public MODELO.UIDesinger.PictureBox pictureBox4;
    public MODELO.UIDesinger.PictureBox pictureBox5;
    public javax.swing.JScrollPane scrollContenedor;
    public static javax.swing.JLabel txtRango;
    // End of variables declaration//GEN-END:variables
}
