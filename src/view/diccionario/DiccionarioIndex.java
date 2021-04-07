package view.diccionario;

public class DiccionarioIndex extends javax.swing.JFrame {

    public DiccionarioIndex() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTaxonomias2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BienvenidoLbl = new javax.swing.JLabel();
        userLbl = new javax.swing.JLabel();
        todoBtn = new javax.swing.JButton();
        mostrarBtn = new javax.swing.JButton();
        buscarTF = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        regresarBtn = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        paleontologoCB = new javax.swing.JComboBox<>();
        periodoCB = new javax.swing.JComboBox<>();
        paisCB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaTaxonomias2.setBackground(new java.awt.Color(87, 198, 196));
        tablaTaxonomias2.setForeground(new java.awt.Color(255, 255, 255));
        tablaTaxonomias2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ESPECIE", "PALEONTOLOGO", "TIEMPO", "PAIS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTaxonomias2.setRowHeight(25);
        jScrollPane1.setViewportView(tablaTaxonomias2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 700, 330));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dino_dinosaur_icon_153295.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 100, 240, 260));

        BienvenidoLbl.setBackground(new java.awt.Color(87, 198, 196));
        BienvenidoLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        BienvenidoLbl.setForeground(new java.awt.Color(255, 255, 255));
        BienvenidoLbl.setText("Bienvenido");
        jPanel1.add(BienvenidoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        userLbl.setBackground(new java.awt.Color(87, 198, 196));
        userLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        userLbl.setForeground(new java.awt.Color(255, 255, 255));
        userLbl.setToolTipText("");
        jPanel1.add(userLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 160, -1));

        todoBtn.setBackground(new java.awt.Color(223, 122, 19));
        todoBtn.setForeground(new java.awt.Color(255, 255, 255));
        todoBtn.setText("TODO");
        jPanel1.add(todoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        mostrarBtn.setBackground(new java.awt.Color(223, 122, 19));
        mostrarBtn.setForeground(new java.awt.Color(255, 255, 255));
        mostrarBtn.setText("MOSTRAR");
        jPanel1.add(mostrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        buscarTF.setBackground(new java.awt.Color(12, 156, 208));
        buscarTF.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        buscarTF.setForeground(new java.awt.Color(255, 255, 255));
        buscarTF.setBorder(null);
        buscarTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTFActionPerformed(evt);
            }
        });
        jPanel1.add(buscarTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 190, 25));

        buscarBtn.setBackground(new java.awt.Color(223, 122, 19));
        buscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        buscarBtn.setText("BUSCAR");
        jPanel1.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        jLabel2.setBackground(new java.awt.Color(87, 198, 196));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 600));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Especies");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 160, 50));

        regresarBtn.setBackground(new java.awt.Color(12, 241, 253));
        regresarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-arrow_icon-icons.com_72866.png"))); // NOI18N
        regresarBtn.setFocusPainted(false);
        jPanel1.add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 40, 50));

        salir.setBackground(new java.awt.Color(12, 241, 253));
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/letterx_83737.png"))); // NOI18N
        salir.setFocusPainted(false);
        salir.setFocusable(false);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, -1, 50));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 190, 10));

        paleontologoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jPanel1.add(paleontologoCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 150, -1));

        periodoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jPanel1.add(periodoCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 150, -1));

        paisCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        paisCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paisCBActionPerformed(evt);
            }
        });
        jPanel1.add(paisCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 150, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PALEONTOLOGO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PERIODO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PAIS:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        jLabel3.setBackground(new java.awt.Color(12, 156, 208));
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 790, 600));

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

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void buscarTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarTFActionPerformed

    private void paisCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paisCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paisCBActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiccionarioIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiccionarioIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiccionarioIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiccionarioIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiccionarioIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BienvenidoLbl;
    public javax.swing.JButton buscarBtn;
    public javax.swing.JTextField buscarTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JButton mostrarBtn;
    public javax.swing.JComboBox<String> paisCB;
    public javax.swing.JComboBox<String> paleontologoCB;
    public javax.swing.JComboBox<String> periodoCB;
    public javax.swing.JButton regresarBtn;
    private javax.swing.JButton salir;
    public javax.swing.JTable tablaTaxonomias2;
    public javax.swing.JButton todoBtn;
    public javax.swing.JLabel userLbl;
    // End of variables declaration//GEN-END:variables
}
