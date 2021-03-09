package view.usuario;

public class UsuarioForm extends javax.swing.JFrame {

    public UsuarioForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoUsGP = new javax.swing.ButtonGroup();
        tipoUserGB = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        administradorRB = new javax.swing.JRadioButton();
        visitanteRB = new javax.swing.JRadioButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        nicknameTF = new javax.swing.JTextField();
        correoTF = new javax.swing.JTextField();
        registrarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fechaN = new com.toedter.calendar.JDateChooser();
        pass2TF = new javax.swing.JPasswordField();
        passTF = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        regresarBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(12, 156, 208));
        jPanel2.setForeground(new java.awt.Color(12, 156, 208));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        administradorRB.setBackground(new java.awt.Color(12, 156, 208));
        tipoUserGB.add(administradorRB);
        administradorRB.setForeground(new java.awt.Color(255, 255, 255));
        administradorRB.setText("Administrador");
        jPanel2.add(administradorRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        visitanteRB.setBackground(new java.awt.Color(12, 156, 208));
        tipoUserGB.add(visitanteRB);
        visitanteRB.setForeground(new java.awt.Color(255, 255, 255));
        visitanteRB.setText("Visitante");
        jPanel2.add(visitanteRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 190, 40));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 190, 40));

        nicknameTF.setBackground(new java.awt.Color(12, 156, 208));
        nicknameTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        nicknameTF.setForeground(new java.awt.Color(255, 255, 255));
        nicknameTF.setBorder(null);
        jPanel2.add(nicknameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 190, 30));

        correoTF.setBackground(new java.awt.Color(12, 156, 208));
        correoTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        correoTF.setForeground(new java.awt.Color(255, 255, 255));
        correoTF.setBorder(null);
        jPanel2.add(correoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 190, 30));

        registrarBtn.setBackground(new java.awt.Color(87, 198, 196));
        registrarBtn.setForeground(new java.awt.Color(255, 255, 255));
        registrarBtn.setText("Registrar");
        registrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBtnActionPerformed(evt);
            }
        });
        jPanel2.add(registrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 90, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Correo: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nickname: ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de nacimiento");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Confirma Contraseña: ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));
        jPanel2.add(fechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 190, 30));

        pass2TF.setBackground(new java.awt.Color(12, 156, 208));
        pass2TF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        pass2TF.setForeground(new java.awt.Color(255, 255, 255));
        pass2TF.setBorder(null);
        jPanel2.add(pass2TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 180, 30));

        passTF.setBackground(new java.awt.Color(12, 156, 208));
        passTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        passTF.setForeground(new java.awt.Color(255, 255, 255));
        passTF.setBorder(null);
        jPanel2.add(passTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 190, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 210, 40));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 190, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/globe_world_2323_1.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 260, 270));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1000, 430));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DinoBase");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        regresarBtn.setBackground(new java.awt.Color(12, 241, 253));
        regresarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-arrow_icon-icons.com_72866.png"))); // NOI18N
        jPanel1.add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 40, -1));

        jLabel7.setBackground(new java.awt.Color(87, 198, 196));
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton administradorRB;
    public javax.swing.JTextField correoTF;
    public com.toedter.calendar.JDateChooser fechaN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public javax.swing.JTextField nicknameTF;
    public javax.swing.JPasswordField pass2TF;
    public javax.swing.JPasswordField passTF;
    public javax.swing.JButton registrarBtn;
    public javax.swing.JButton regresarBtn;
    private javax.swing.ButtonGroup tipoUsGP;
    public javax.swing.ButtonGroup tipoUserGB;
    public javax.swing.JRadioButton visitanteRB;
    // End of variables declaration//GEN-END:variables
}
