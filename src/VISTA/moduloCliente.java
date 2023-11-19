package VISTA;

import CONTROLADOR.ControladorCliente;
import MODELO.UIDesinger.UIController;

public final class moduloCliente extends javax.swing.JPanel {

    private final ControladorCliente controlador;

    public moduloCliente() {
        initComponents();
        controlador = new ControladorCliente(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound3 = new MODELO.UIDesinger.PanelRound();
        pictureBox1 = new MODELO.UIDesinger.PictureBox();
        panelRound4 = new MODELO.UIDesinger.PanelRound();
        jLabel12 = new javax.swing.JLabel();
        panelRound5 = new MODELO.UIDesinger.PanelRound();
        jLabel13 = new javax.swing.JLabel();
        cliente_txtDni = new textfield_suggestion.TextFieldSuggestion();
        cliente_txtNombre = new textfield_suggestion.TextFieldSuggestion();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cliente_txtApellido = new textfield_suggestion.TextFieldSuggestion();
        cliente_txtDireccion = new textfield_suggestion.TextFieldSuggestion();
        jLabel17 = new javax.swing.JLabel();
        panelRound6 = new MODELO.UIDesinger.PanelRound();
        cliente_btnRegistrar = new button.Button();
        cliente_btnActualizar = new button.Button();
        cliente_btnLimpiar = new button.Button();
        cliente_btnBorrar = new button.Button();
        jScrollPane1 = new MODELO.UIDesinger.Scroll.ScrollPaneWin11();
        tablaCliente = new MODELO.UIDesinger.TableDark();
        jLabel14 = new javax.swing.JLabel();

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(233, 181, 30));

        panelRound4.setBackground(new java.awt.Color(0, 129, 93));
        panelRound4.setRoundBottomLeft(15);
        panelRound4.setRoundBottomRight(15);
        panelRound4.setRoundTopLeft(15);
        panelRound4.setRoundTopRight(15);

        jLabel12.setFont(new java.awt.Font("Century", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Datos");

        panelRound5.setBackground(new java.awt.Color(0, 129, 93));
        panelRound5.setRoundBottomLeft(15);
        panelRound5.setRoundBottomRight(15);
        panelRound5.setRoundTopLeft(15);
        panelRound5.setRoundTopRight(15);

        jLabel13.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Dni");

        cliente_txtDni.setForeground(new java.awt.Color(255, 255, 255));
        cliente_txtDni.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cliente_txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cliente_txtDniKeyTyped(evt);
            }
        });

        cliente_txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        cliente_txtNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cliente_txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cliente_txtNombreKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nombre");

        jLabel16.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Apellido");

        cliente_txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        cliente_txtApellido.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cliente_txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cliente_txtApellidoKeyTyped(evt);
            }
        });

        cliente_txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        cliente_txtDireccion.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cliente_txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cliente_txtDireccionKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Direccion");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cliente_txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cliente_txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cliente_txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cliente_txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(cliente_txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(cliente_txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(cliente_txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(cliente_txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelRound6.setBackground(new java.awt.Color(0, 129, 93));

        cliente_btnRegistrar.setBackground(new java.awt.Color(0, 93, 83));
        cliente_btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        cliente_btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/agregar.png"))); // NOI18N
        cliente_btnRegistrar.setText("REGISTRAR");
        cliente_btnRegistrar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cliente_btnRegistrar.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        cliente_btnRegistrar.setShadowColor(new java.awt.Color(0, 0, 0));
        cliente_btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliente_btnRegistrarActionPerformed(evt);
            }
        });

        cliente_btnActualizar.setBackground(new java.awt.Color(0, 93, 83));
        cliente_btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        cliente_btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/actualizar.png"))); // NOI18N
        cliente_btnActualizar.setText("ACTUALIZAR");
        cliente_btnActualizar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cliente_btnActualizar.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        cliente_btnActualizar.setShadowColor(new java.awt.Color(0, 0, 0));
        cliente_btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliente_btnActualizarActionPerformed(evt);
            }
        });

        cliente_btnLimpiar.setBackground(new java.awt.Color(0, 93, 83));
        cliente_btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        cliente_btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/limpiar.png"))); // NOI18N
        cliente_btnLimpiar.setText("LIMPIAR");
        cliente_btnLimpiar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cliente_btnLimpiar.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        cliente_btnLimpiar.setShadowColor(new java.awt.Color(0, 0, 0));
        cliente_btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliente_btnLimpiarActionPerformed(evt);
            }
        });

        cliente_btnBorrar.setBackground(new java.awt.Color(0, 93, 83));
        cliente_btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        cliente_btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/icons/eliminar.png"))); // NOI18N
        cliente_btnBorrar.setText("BORRAR");
        cliente_btnBorrar.setCurrentCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cliente_btnBorrar.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        cliente_btnBorrar.setShadowColor(new java.awt.Color(0, 0, 0));
        cliente_btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliente_btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cliente_btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cliente_btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cliente_btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cliente_btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente_btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cliente_btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cliente_btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cliente_btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dni", "Nombre", "Apellido", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCliente);

        jLabel14.setFont(new java.awt.Font("Century", 0, 55)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Clientes");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330))))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(43, 43, 43)
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cliente_btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliente_btnRegistrarActionPerformed
        controlador.cliente_btnRegistrarActionPerformed();
    }//GEN-LAST:event_cliente_btnRegistrarActionPerformed

    private void cliente_btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliente_btnBorrarActionPerformed
        controlador.cliente_btnBorrarActionPerformed();
    }//GEN-LAST:event_cliente_btnBorrarActionPerformed

    private void cliente_btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliente_btnActualizarActionPerformed
        controlador.cliente_btnActualizarActionPerformed();
    }//GEN-LAST:event_cliente_btnActualizarActionPerformed

    private void cliente_btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliente_btnLimpiarActionPerformed
        controlador.cliente_limpiar();
    }//GEN-LAST:event_cliente_btnLimpiarActionPerformed

    private void tablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseClicked
        controlador.tablaClienteMouseClicked();
    }//GEN-LAST:event_tablaClienteMouseClicked

    private void cliente_txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cliente_txtDniKeyTyped
        UIController.limitacionNumeros(cliente_txtDni, evt, 8);
    }//GEN-LAST:event_cliente_txtDniKeyTyped

    private void cliente_txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cliente_txtNombreKeyTyped
        UIController.limitacionCaracteres(cliente_txtNombre, evt, 50, true);
    }//GEN-LAST:event_cliente_txtNombreKeyTyped

    private void cliente_txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cliente_txtApellidoKeyTyped
        UIController.limitacionCaracteres(cliente_txtApellido, evt, 50, true);
    }//GEN-LAST:event_cliente_txtApellidoKeyTyped

    private void cliente_txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cliente_txtDireccionKeyTyped
        UIController.limitacionCaracteres(cliente_txtDireccion, evt, 100, true);
    }//GEN-LAST:event_cliente_txtDireccionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public button.Button cliente_btnActualizar;
    public button.Button cliente_btnBorrar;
    public button.Button cliente_btnLimpiar;
    public button.Button cliente_btnRegistrar;
    public textfield_suggestion.TextFieldSuggestion cliente_txtApellido;
    public textfield_suggestion.TextFieldSuggestion cliente_txtDireccion;
    public textfield_suggestion.TextFieldSuggestion cliente_txtDni;
    public textfield_suggestion.TextFieldSuggestion cliente_txtNombre;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JScrollPane jScrollPane1;
    public MODELO.UIDesinger.PanelRound panelRound3;
    public MODELO.UIDesinger.PanelRound panelRound4;
    public MODELO.UIDesinger.PanelRound panelRound5;
    public MODELO.UIDesinger.PanelRound panelRound6;
    public MODELO.UIDesinger.PictureBox pictureBox1;
    public MODELO.UIDesinger.TableDark tablaCliente;
    // End of variables declaration//GEN-END:variables
}
