package framesTaxonomia;

public class TaxonomiaFrame extends javax.swing.JFrame {

    public TaxonomiaFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTaxonomias = new javax.swing.JTable();
        todoBtn = new javax.swing.JButton();
        mostrarBtn = new javax.swing.JButton();
        nuevoBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        buscarTF = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        regresarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaTaxonomias.setBackground(new java.awt.Color(87, 198, 196));
        tablaTaxonomias.setForeground(new java.awt.Color(255, 255, 255));
        tablaTaxonomias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ESPECIE", "REINO", "ORDEN", "DOMINIO", "FAMILIA", "CLASE", "FILO", "GENERO", "ALTURA", "LARGO", "PESO", "ALIMENTACION", "REGISTRADO", "PALEANTOLOGO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTaxonomias.setRowHeight(25);
        jScrollPane1.setViewportView(tablaTaxonomias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 960, 440));

        todoBtn.setBackground(new java.awt.Color(223, 122, 19));
        todoBtn.setForeground(new java.awt.Color(255, 255, 255));
        todoBtn.setText("TODO");
        jPanel1.add(todoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        mostrarBtn.setBackground(new java.awt.Color(223, 122, 19));
        mostrarBtn.setForeground(new java.awt.Color(255, 255, 255));
        mostrarBtn.setText("MOSTRAR");
        jPanel1.add(mostrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        nuevoBtn.setBackground(new java.awt.Color(223, 122, 19));
        nuevoBtn.setForeground(new java.awt.Color(255, 255, 255));
        nuevoBtn.setText("NUEVO");
        jPanel1.add(nuevoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Taxonomias");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 270, 30));

        buscarTF.setBackground(new java.awt.Color(87, 198, 196));
        buscarTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        buscarTF.setForeground(new java.awt.Color(255, 255, 255));
        buscarTF.setBorder(null);
        jPanel1.add(buscarTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 20));

        buscarBtn.setBackground(new java.awt.Color(223, 122, 19));
        buscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        buscarBtn.setText("BUSCAR");
        jPanel1.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        salir.setBackground(new java.awt.Color(12, 241, 253));
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/letterx_83737.png"))); // NOI18N
        salir.setFocusPainted(false);
        salir.setFocusable(false);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, -1));

        regresarBtn.setBackground(new java.awt.Color(12, 241, 253));
        regresarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-arrow_icon-icons.com_72866.png"))); // NOI18N
        regresarBtn.setFocusPainted(false);
        jPanel1.add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 40, -1));

        jLabel2.setBackground(new java.awt.Color(87, 198, 196));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 70));

        jLabel1.setBackground(new java.awt.Color(12, 156, 208));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1000, 530));

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
            java.util.logging.Logger.getLogger(TaxonomiaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaxonomiaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaxonomiaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaxonomiaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaxonomiaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buscarBtn;
    public javax.swing.JTextField buscarTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JButton mostrarBtn;
    public javax.swing.JButton nuevoBtn;
    public javax.swing.JButton regresarBtn;
    public javax.swing.JButton salir;
    public javax.swing.JTable tablaTaxonomias;
    public javax.swing.JButton todoBtn;
    // End of variables declaration//GEN-END:variables
}
