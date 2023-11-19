package VISTA;

import CONTROLADOR.ControladorHome;
import MODELO.Action.ActionUtils;

public final class pnlHome extends javax.swing.JPanel {

    private final ControladorHome controlador;

    public pnlHome() {
        initComponents();
        controlador = new ControladorHome(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtHora = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pictureBox1 = new MODELO.UIDesinger.PictureBox();
        txtRango = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        txtDia = new javax.swing.JLabel();
        panelRound1 = new MODELO.UIDesinger.PanelRound();
        btnExcel = new button.Button();
        btnArchivos = new button.Button();
        btnCalculadora = new button.Button();
        btnBlockNotas = new button.Button();
        btnNavegador = new button.Button();

        setBackground(new java.awt.Color(0, 129, 93));
        setPreferredSize(new java.awt.Dimension(865, 588));

        txtHora.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel1.setBackground(new java.awt.Color(0, 129, 93));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/iconUsuario.png"))); // NOI18N

        txtRango.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        txtRango.setForeground(new java.awt.Color(255, 255, 255));
        txtRango.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRango.setText("Admin");

        jLabel2.setFont(new java.awt.Font("Century", 0, 55)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bienvenido");

        txtFecha.setFont(new java.awt.Font("Comic Sans MS", 0, 30)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtDia.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        txtDia.setForeground(new java.awt.Color(255, 255, 255));
        txtDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                            .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRango, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRango)
                .addGap(51, 51, 51)
                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        panelRound1.setBackground(new java.awt.Color(0, 129, 93));

        btnExcel.setBackground(new java.awt.Color(0, 129, 93));
        btnExcel.setForeground(new java.awt.Color(51, 51, 51));
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/excel.png"))); // NOI18N
        btnExcel.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcel.setShadowColor(new java.awt.Color(0, 0, 0));
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        btnArchivos.setBackground(new java.awt.Color(0, 129, 93));
        btnArchivos.setForeground(new java.awt.Color(51, 51, 51));
        btnArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/carpeta.png"))); // NOI18N
        btnArchivos.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnArchivos.setShadowColor(new java.awt.Color(0, 0, 0));
        btnArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivosActionPerformed(evt);
            }
        });

        btnCalculadora.setBackground(new java.awt.Color(0, 129, 93));
        btnCalculadora.setForeground(new java.awt.Color(51, 51, 51));
        btnCalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/calculadora.png"))); // NOI18N
        btnCalculadora.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalculadora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCalculadora.setShadowColor(new java.awt.Color(0, 0, 0));
        btnCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculadoraActionPerformed(evt);
            }
        });

        btnBlockNotas.setBackground(new java.awt.Color(0, 129, 93));
        btnBlockNotas.setForeground(new java.awt.Color(51, 51, 51));
        btnBlockNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/notas.png"))); // NOI18N
        btnBlockNotas.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBlockNotas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBlockNotas.setShadowColor(new java.awt.Color(0, 0, 0));
        btnBlockNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlockNotasActionPerformed(evt);
            }
        });

        btnNavegador.setBackground(new java.awt.Color(0, 129, 93));
        btnNavegador.setForeground(new java.awt.Color(51, 51, 51));
        btnNavegador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/web.png"))); // NOI18N
        btnNavegador.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNavegador.setShadowColor(new java.awt.Color(0, 0, 0));
        btnNavegador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavegadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBlockNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNavegador, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBlockNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNavegador, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavegadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavegadorActionPerformed
        ActionUtils.AccederEnlace("chrome");
    }//GEN-LAST:event_btnNavegadorActionPerformed

    private void btnBlockNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlockNotasActionPerformed
        ActionUtils.AccederEnlace("notepad");
    }//GEN-LAST:event_btnBlockNotasActionPerformed

    private void btnCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculadoraActionPerformed
        ActionUtils.AccederEnlace("calc");
    }//GEN-LAST:event_btnCalculadoraActionPerformed

    private void btnArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivosActionPerformed
        ActionUtils.AccederEnlace("explorer");
    }//GEN-LAST:event_btnArchivosActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        ActionUtils.AccederEnlace("excel");
    }//GEN-LAST:event_btnExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public button.Button btnArchivos;
    public button.Button btnBlockNotas;
    public button.Button btnCalculadora;
    public button.Button btnExcel;
    public button.Button btnNavegador;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public MODELO.UIDesinger.PanelRound panelRound1;
    public MODELO.UIDesinger.PictureBox pictureBox1;
    public javax.swing.JLabel txtDia;
    public javax.swing.JLabel txtFecha;
    public static javax.swing.JLabel txtHora;
    public static javax.swing.JLabel txtRango;
    // End of variables declaration//GEN-END:variables
}
