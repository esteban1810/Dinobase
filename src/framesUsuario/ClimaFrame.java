package framesUsuario;

public class ClimaFrame extends javax.swing.JFrame {

    public ClimaFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regresarBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtHumedad = new javax.swing.JTextField();
        txtPresion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTemp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        regresarBtn1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regresarBtn.setBackground(new java.awt.Color(12, 241, 253));
        regresarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-arrow_icon-icons.com_72866.png"))); // NOI18N
        getContentPane().add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 40, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Climas");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 150, 60));

        jLabel6.setBackground(new java.awt.Color(87, 198, 196));
        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 103));

        txtNombre.setBackground(new java.awt.Color(12, 156, 208));
        txtNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, 25));

        txtHumedad.setBackground(new java.awt.Color(12, 156, 208));
        txtHumedad.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtHumedad.setForeground(new java.awt.Color(255, 255, 255));
        txtHumedad.setBorder(null);
        getContentPane().add(txtHumedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 150, 25));

        txtPresion.setBackground(new java.awt.Color(12, 156, 208));
        txtPresion.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtPresion.setForeground(new java.awt.Color(255, 255, 255));
        txtPresion.setBorder(null);
        getContentPane().add(txtPresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 150, 25));

        btnGuardar.setBackground(new java.awt.Color(87, 198, 196));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Registrar");
        btnGuardar.setToolTipText("");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        btnModificar.setBackground(new java.awt.Color(87, 198, 196));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(87, 198, 196));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, -1, -1));

        btnEliminar1.setBackground(new java.awt.Color(87, 198, 196));
        btnEliminar1.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar1.setText("Limpiar");
        btnEliminar1.setToolTipText("");
        getContentPane().add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Humedad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 140, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Presion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 140, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Temperatura");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 140, 30));

        txtTemp.setBackground(new java.awt.Color(12, 156, 208));
        txtTemp.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtTemp.setForeground(new java.awt.Color(255, 255, 255));
        txtTemp.setBorder(null);
        getContentPane().add(txtTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 150, 25));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sun-and-rain_icon-icons.com_54243.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 150, 170));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clouds-outlined-weather-symbol_icon-icons.com_54695_1.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 100, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wind-weather-lines-group-symbol_icon-icons.com_54629.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 100, 110));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sun-day-weather-symbol_icon-icons.com_73146.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 100, 110));

        jLabel7.setBackground(new java.awt.Color(87, 198, 196));
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 103));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 150, 10));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 150, 10));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 150, 10));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 150, 10));

        regresarBtn1.setBackground(new java.awt.Color(12, 241, 253));
        regresarBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-arrow_icon-icons.com_72866.png"))); // NOI18N
        getContentPane().add(regresarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 40, -1));

        jLabel9.setBackground(new java.awt.Color(12, 156, 208));
        jLabel9.setToolTipText("");
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1000, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(ClimaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClimaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClimaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClimaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClimaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnEliminar1;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    public javax.swing.JButton regresarBtn;
    public javax.swing.JButton regresarBtn1;
    public javax.swing.JTextField txtHumedad;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPresion;
    public javax.swing.JTextField txtTemp;
    // End of variables declaration//GEN-END:variables
}
