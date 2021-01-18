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
        buscarTF = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(tablaTaxonomias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, -1));

        todoBtn.setText("TODO");
        jPanel1.add(todoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        mostrarBtn.setText("MOSTRAR");
        jPanel1.add(mostrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        nuevoBtn.setText("NUEVO");
        jPanel1.add(nuevoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));
        jPanel1.add(buscarTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, -1));

        buscarBtn.setText("BUSCAR");
        jPanel1.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton mostrarBtn;
    public javax.swing.JButton nuevoBtn;
    public javax.swing.JTable tablaTaxonomias;
    public javax.swing.JButton todoBtn;
    // End of variables declaration//GEN-END:variables
}
