package framesUsuario;

public class UsuarioFrame extends javax.swing.JFrame {

    public UsuarioFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoUsGP = new javax.swing.ButtonGroup();
        tipoUserGB = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        administradorRB = new javax.swing.JRadioButton();
        visitanteRB = new javax.swing.JRadioButton();
        nicknameTF = new javax.swing.JTextField();
        passTF = new javax.swing.JTextField();
        correoTF = new javax.swing.JTextField();
        pass2TF = new javax.swing.JTextField();
        registrarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        modificarBtn = new javax.swing.JButton();
        buscarBtn = new javax.swing.JButton();
        limpiarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        fechaN = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("DinoBase");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 23, -1, -1));

        tipoUserGB.add(administradorRB);
        administradorRB.setText("Administrador");
        jPanel2.add(administradorRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        tipoUserGB.add(visitanteRB);
        visitanteRB.setText("Visitante");
        jPanel2.add(visitanteRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));
        jPanel2.add(nicknameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 110, -1));
        jPanel2.add(passTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 190, -1));
        jPanel2.add(correoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 190, -1));
        jPanel2.add(pass2TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 190, -1));

        registrarBtn.setText("Registrar");
        registrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBtnActionPerformed(evt);
            }
        });
        jPanel2.add(registrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, -1));

        jLabel2.setText("Correo");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        jLabel3.setText("Nickname");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel4.setText("Fecha de nacimiento");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        jLabel5.setText("Contraseña");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        jLabel6.setText("Contraseña");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        modificarBtn.setText("Modificar");
        jPanel2.add(modificarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 90, -1));

        buscarBtn.setText("Buscar");
        jPanel2.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 90, -1));

        limpiarBtn.setText("Limpiar");
        jPanel2.add(limpiarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 80, -1));

        eliminarBtn.setText("Eliminar");
        jPanel2.add(eliminarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 90, -1));
        jPanel2.add(fechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 140, 140, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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

    private void registrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBtnActionPerformed

    }//GEN-LAST:event_registrarBtnActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(UsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton administradorRB;
    public javax.swing.JButton buscarBtn;
    public javax.swing.JTextField correoTF;
    public javax.swing.JButton eliminarBtn;
    public com.toedter.calendar.JDateChooser fechaN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JButton limpiarBtn;
    public javax.swing.JButton modificarBtn;
    public javax.swing.JTextField nicknameTF;
    public javax.swing.JTextField pass2TF;
    public javax.swing.JTextField passTF;
    public javax.swing.JButton registrarBtn;
    private javax.swing.ButtonGroup tipoUsGP;
    public javax.swing.ButtonGroup tipoUserGB;
    public javax.swing.JRadioButton visitanteRB;
    // End of variables declaration//GEN-END:variables
}
