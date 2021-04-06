package view.visitante;

public class VisitanteIndex extends javax.swing.JFrame {

    public VisitanteIndex() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BienvenidoLbl = new javax.swing.JLabel();
        userLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        regresarBtn = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        estadisticasBtn = new javax.swing.JButton();
        consultarBtn = new javax.swing.JButton();
        jugarBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreTxt.setEditable(false);
        nombreTxt.setBackground(new java.awt.Color(87, 198, 196));
        nombreTxt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nombreTxt.setForeground(new java.awt.Color(255, 255, 255));
        nombreTxt.setBorder(null);
        jPanel1.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 140, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dino_dinosaur_icon_153295.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 220));

        BienvenidoLbl.setBackground(new java.awt.Color(87, 198, 196));
        BienvenidoLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        BienvenidoLbl.setForeground(new java.awt.Color(255, 255, 255));
        BienvenidoLbl.setText("Bienvenido");
        jPanel1.add(BienvenidoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        userLbl.setBackground(new java.awt.Color(87, 198, 196));
        userLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        userLbl.setForeground(new java.awt.Color(255, 255, 255));
        userLbl.setToolTipText("");
        jPanel1.add(userLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 160, -1));

        jLabel2.setBackground(new java.awt.Color(87, 198, 196));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 600));

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

        estadisticasBtn.setBackground(new java.awt.Color(87, 198, 196));
        estadisticasBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        estadisticasBtn.setForeground(new java.awt.Color(255, 255, 255));
        estadisticasBtn.setText("Estadisticas");
        jPanel1.add(estadisticasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, -1, -1));

        consultarBtn.setBackground(new java.awt.Color(87, 198, 196));
        consultarBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        consultarBtn.setForeground(new java.awt.Color(255, 255, 255));
        consultarBtn.setText("Consultar");
        jPanel1.add(consultarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        jugarBtn.setBackground(new java.awt.Color(87, 198, 196));
        jugarBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jugarBtn.setForeground(new java.awt.Color(255, 255, 255));
        jugarBtn.setText("Jugar");
        jugarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(jugarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/games-machine_icon-icons.com_73015.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 130, 130));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/statistics-report-for-business_icon-icons.com_70370.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 130, 130));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/book_icon-icons.com_73655 (1).png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 130, 130));

        jLabel3.setBackground(new java.awt.Color(12, 156, 208));
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 760, 600));

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

    private void jugarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jugarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(VisitanteIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisitanteIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisitanteIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisitanteIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisitanteIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BienvenidoLbl;
    public javax.swing.JButton consultarBtn;
    public javax.swing.JButton estadisticasBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jugarBtn;
    public javax.swing.JTextField nombreTxt;
    public javax.swing.JButton regresarBtn;
    private javax.swing.JButton salir;
    public javax.swing.JLabel userLbl;
    // End of variables declaration//GEN-END:variables
}
