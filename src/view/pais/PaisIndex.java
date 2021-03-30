/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pais;

/**
 *
 * @author Cesar
 */
public class PaisIndex extends javax.swing.JFrame {

    /**
     * Creates new form PaisTablaFrame
     */
    public PaisIndex() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        listaPaises = new javax.swing.JList<>();
        agregarBtn = new javax.swing.JButton();
        aceptarBtn = new javax.swing.JButton();
        regresarBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        todoBtn = new javax.swing.JButton();
        buscarTF = new javax.swing.JTextField();
        nuevoBtn = new javax.swing.JButton();
        buscarBtn = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        mostrarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPais = new javax.swing.JTable();
        continenteCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setViewportView(listaPaises);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 170, 60));

        agregarBtn.setBackground(new java.awt.Color(223, 122, 19));
        agregarBtn.setForeground(new java.awt.Color(255, 255, 255));
        agregarBtn.setText("Agregar");
        getContentPane().add(agregarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        aceptarBtn.setBackground(new java.awt.Color(223, 122, 19));
        aceptarBtn.setForeground(new java.awt.Color(255, 255, 255));
        aceptarBtn.setText("Aceptar");
        getContentPane().add(aceptarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 80, -1));

        regresarBtn.setBackground(new java.awt.Color(12, 241, 253));
        regresarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-arrow_icon-icons.com_72866.png"))); // NOI18N
        regresarBtn.setFocusPainted(false);
        getContentPane().add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 40, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 10));

        todoBtn.setBackground(new java.awt.Color(223, 122, 19));
        todoBtn.setForeground(new java.awt.Color(255, 255, 255));
        todoBtn.setText("Todo");
        getContentPane().add(todoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        buscarTF.setBackground(new java.awt.Color(87, 198, 196));
        buscarTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        buscarTF.setForeground(new java.awt.Color(255, 255, 255));
        buscarTF.setBorder(null);
        getContentPane().add(buscarTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 20));

        nuevoBtn.setBackground(new java.awt.Color(223, 122, 19));
        nuevoBtn.setForeground(new java.awt.Color(255, 255, 255));
        nuevoBtn.setText("Nuevo");
        nuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(nuevoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        buscarBtn.setBackground(new java.awt.Color(223, 122, 19));
        buscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        salir.setBackground(new java.awt.Color(12, 241, 253));
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/letterx_83737.png"))); // NOI18N
        salir.setFocusPainted(false);
        salir.setFocusable(false);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, -1));

        mostrarBtn.setBackground(new java.awt.Color(223, 122, 19));
        mostrarBtn.setForeground(new java.awt.Color(255, 255, 255));
        mostrarBtn.setText("Mostrar");
        getContentPane().add(mostrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jLabel1.setBackground(new java.awt.Color(87, 198, 196));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Paises");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 160, 40));

        tbPais.setBackground(new java.awt.Color(87, 198, 196));
        tbPais.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        tbPais.setForeground(new java.awt.Color(255, 255, 255));
        tbPais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Continente", "Extension"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPais.setRowHeight(35);
        jScrollPane1.setViewportView(tbPais);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 197, 960, 350));

        continenteCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Africa", "America", "Antartida", "Asia", "Europa", "Oceania" }));
        getContentPane().add(continenteCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 200, -1));

        jLabel2.setBackground(new java.awt.Color(12, 156, 208));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1000, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevoBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PaisIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaisIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaisIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaisIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaisIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptarBtn;
    public javax.swing.JButton agregarBtn;
    public javax.swing.JButton buscarBtn;
    public javax.swing.JTextField buscarTF;
    public javax.swing.JComboBox<String> continenteCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JList<String> listaPaises;
    public javax.swing.JButton mostrarBtn;
    public javax.swing.JButton nuevoBtn;
    public javax.swing.JButton regresarBtn;
    private javax.swing.JButton salir;
    public javax.swing.JTable tbPais;
    public javax.swing.JButton todoBtn;
    // End of variables declaration//GEN-END:variables
}
