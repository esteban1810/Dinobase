/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.quiz;

/**
 *
 * @author franc
 */
public class quizIndex extends javax.swing.JFrame {

    /**
     * Creates new form quizIndex
     */
    public quizIndex() {
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

        jPanel1 = new javax.swing.JPanel();
        BienvenidoLbl1 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTaxonomias2 = new javax.swing.JTable();
        BienvenidoLbl = new javax.swing.JLabel();
        dificultadCB = new javax.swing.JComboBox<>();
        userLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jugarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        regresarBtn = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BienvenidoLbl1.setBackground(new java.awt.Color(87, 198, 196));
        BienvenidoLbl1.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        BienvenidoLbl1.setForeground(new java.awt.Color(255, 255, 255));
        BienvenidoLbl1.setText("al quiz");
        jPanel1.add(BienvenidoLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        nombreTxt.setEditable(false);
        nombreTxt.setBackground(new java.awt.Color(87, 198, 196));
        nombreTxt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nombreTxt.setForeground(new java.awt.Color(255, 255, 255));
        nombreTxt.setBorder(null);
        jPanel1.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 140, 40));

        tablaTaxonomias2.setBackground(new java.awt.Color(87, 198, 196));
        tablaTaxonomias2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tablaTaxonomias2.setForeground(new java.awt.Color(255, 255, 255));
        tablaTaxonomias2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Especie"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTaxonomias2.setRowHeight(34);
        jScrollPane1.setViewportView(tablaTaxonomias2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 450, 520));

        BienvenidoLbl.setBackground(new java.awt.Color(87, 198, 196));
        BienvenidoLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        BienvenidoLbl.setForeground(new java.awt.Color(255, 255, 255));
        BienvenidoLbl.setText("Bienvenido");
        jPanel1.add(BienvenidoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        dificultadCB.setBackground(new java.awt.Color(87, 198, 196));
        dificultadCB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dificultadCB.setForeground(new java.awt.Color(255, 255, 255));
        dificultadCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Normal", "Dificil", "Mixta" }));
        jPanel1.add(dificultadCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, -1, -1));

        userLbl.setBackground(new java.awt.Color(87, 198, 196));
        userLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        userLbl.setForeground(new java.awt.Color(255, 255, 255));
        userLbl.setToolTipText("");
        jPanel1.add(userLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 160, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, -1, 130));

        jLabel2.setBackground(new java.awt.Color(87, 198, 196));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 600));

        jugarBtn.setBackground(new java.awt.Color(87, 198, 196));
        jugarBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jugarBtn.setForeground(new java.awt.Color(255, 255, 255));
        jugarBtn.setText("Jugar");
        jPanel1.add(jugarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, -1, -1));

        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 130, 100));

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
            java.util.logging.Logger.getLogger(quizIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quizIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quizIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quizIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quizIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BienvenidoLbl;
    public javax.swing.JLabel BienvenidoLbl1;
    public javax.swing.JComboBox<String> dificultadCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jugarBtn;
    public javax.swing.JTextField nombreTxt;
    public javax.swing.JButton regresarBtn;
    private javax.swing.JButton salir;
    public javax.swing.JTable tablaTaxonomias2;
    public javax.swing.JLabel userLbl;
    // End of variables declaration//GEN-END:variables
}