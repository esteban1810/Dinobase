package view.diccionario;

import view.visitante.*;

public class DiccionarioForm extends javax.swing.JFrame {

    public DiccionarioForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        descripcionTXA = new javax.swing.JTextArea();
        lblFoto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        especieTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        reinoTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ordenTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dominioTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        familiaTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        claseTF = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        filoTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        generoTF = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        alturaTF = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        largoTF = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        climaLbl = new javax.swing.JLabel();
        pesoTF = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        alimentacionTF = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        registradoTF = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        paleantologoTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClimas = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTiempos = new javax.swing.JTable();
        regresarBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        mostrarClimaBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPaises = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(12, 156, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descripcionTXA.setBackground(new java.awt.Color(87, 198, 196));
        descripcionTXA.setColumns(20);
        descripcionTXA.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        descripcionTXA.setRows(5);
        descripcionTXA.setBorder(null);
        jScrollPane5.setViewportView(descripcionTXA);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 250, -1));

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dino_dinosaur_icon_153295.png"))); // NOI18N
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, 260));

        jLabel9.setBackground(new java.awt.Color(87, 198, 196));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Especie:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        especieTF.setEditable(false);
        especieTF.setBackground(new java.awt.Color(12, 156, 208));
        especieTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        especieTF.setForeground(new java.awt.Color(255, 255, 255));
        especieTF.setBorder(null);
        jPanel1.add(especieTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 140, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reino:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        reinoTF.setEditable(false);
        reinoTF.setBackground(new java.awt.Color(12, 156, 208));
        reinoTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        reinoTF.setForeground(new java.awt.Color(255, 255, 255));
        reinoTF.setBorder(null);
        jPanel1.add(reinoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Orden:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        ordenTF.setEditable(false);
        ordenTF.setBackground(new java.awt.Color(12, 156, 208));
        ordenTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        ordenTF.setForeground(new java.awt.Color(255, 255, 255));
        ordenTF.setBorder(null);
        jPanel1.add(ordenTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 140, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dominio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        dominioTF.setEditable(false);
        dominioTF.setBackground(new java.awt.Color(12, 156, 208));
        dominioTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        dominioTF.setForeground(new java.awt.Color(255, 255, 255));
        dominioTF.setBorder(null);
        jPanel1.add(dominioTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Familia:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        familiaTF.setEditable(false);
        familiaTF.setBackground(new java.awt.Color(12, 156, 208));
        familiaTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        familiaTF.setForeground(new java.awt.Color(255, 255, 255));
        familiaTF.setBorder(null);
        jPanel1.add(familiaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 140, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Clase:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        claseTF.setEditable(false);
        claseTF.setBackground(new java.awt.Color(12, 156, 208));
        claseTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        claseTF.setForeground(new java.awt.Color(255, 255, 255));
        claseTF.setBorder(null);
        jPanel1.add(claseTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 140, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Filo:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        filoTF.setEditable(false);
        filoTF.setBackground(new java.awt.Color(12, 156, 208));
        filoTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        filoTF.setForeground(new java.awt.Color(255, 255, 255));
        filoTF.setBorder(null);
        jPanel1.add(filoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 140, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Genero:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        generoTF.setEditable(false);
        generoTF.setBackground(new java.awt.Color(12, 156, 208));
        generoTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        generoTF.setForeground(new java.awt.Color(255, 255, 255));
        generoTF.setBorder(null);
        jPanel1.add(generoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 140, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Altura:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        alturaTF.setEditable(false);
        alturaTF.setBackground(new java.awt.Color(12, 156, 208));
        alturaTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        alturaTF.setForeground(new java.awt.Color(255, 255, 255));
        alturaTF.setBorder(null);
        jPanel1.add(alturaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 140, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Largo:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        largoTF.setEditable(false);
        largoTF.setBackground(new java.awt.Color(12, 156, 208));
        largoTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        largoTF.setForeground(new java.awt.Color(255, 255, 255));
        largoTF.setBorder(null);
        jPanel1.add(largoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 140, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Peso:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, -1, -1));

        climaLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        climaLbl.setForeground(new java.awt.Color(255, 255, 255));
        climaLbl.setText("climas");
        jPanel1.add(climaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, -1, -1));

        pesoTF.setEditable(false);
        pesoTF.setBackground(new java.awt.Color(12, 156, 208));
        pesoTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        pesoTF.setForeground(new java.awt.Color(255, 255, 255));
        pesoTF.setBorder(null);
        jPanel1.add(pesoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 140, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Alimentación:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        alimentacionTF.setEditable(false);
        alimentacionTF.setBackground(new java.awt.Color(12, 156, 208));
        alimentacionTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        alimentacionTF.setForeground(new java.awt.Color(255, 255, 255));
        alimentacionTF.setBorder(null);
        jPanel1.add(alimentacionTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 140, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Registrado:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        registradoTF.setEditable(false);
        registradoTF.setBackground(new java.awt.Color(12, 156, 208));
        registradoTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        registradoTF.setForeground(new java.awt.Color(255, 255, 255));
        registradoTF.setBorder(null);
        jPanel1.add(registradoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 150, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Paleantologo:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        paleantologoTF.setEditable(false);
        paleantologoTF.setBackground(new java.awt.Color(12, 156, 208));
        paleantologoTF.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        paleantologoTF.setForeground(new java.awt.Color(255, 255, 255));
        paleantologoTF.setBorder(null);
        jPanel1.add(paleantologoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, -1, -1));

        tablaClimas.setBackground(new java.awt.Color(87, 198, 196));
        tablaClimas.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        tablaClimas.setForeground(new java.awt.Color(255, 255, 255));
        tablaClimas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Humedad", "Presion", "Temperatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClimas.setRowHeight(25);
        jScrollPane2.setViewportView(tablaClimas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 360, 90));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TIEMPOS:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, -1, -1));

        tablaTiempos.setBackground(new java.awt.Color(87, 198, 196));
        tablaTiempos.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        tablaTiempos.setForeground(new java.awt.Color(255, 255, 255));
        tablaTiempos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PERIODO", "ERA", "EPOCA", "DESCUBIERTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTiempos.setRowHeight(25);
        jScrollPane3.setViewportView(tablaTiempos);
        if (tablaTiempos.getColumnModel().getColumnCount() > 0) {
            tablaTiempos.getColumnModel().getColumn(3).setHeaderValue("DESCUBIERTO");
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 710, 110));

        regresarBtn.setBackground(new java.awt.Color(12, 241, 253));
        regresarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-arrow_icon-icons.com_72866.png"))); // NOI18N
        regresarBtn.setFocusPainted(false);
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 40, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PAISES:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        mostrarClimaBtn.setBackground(new java.awt.Color(87, 198, 196));
        mostrarClimaBtn.setForeground(new java.awt.Color(255, 255, 255));
        mostrarClimaBtn.setText("Mostrar datos del clima");
        jPanel1.add(mostrarClimaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 360, -1));

        tablaPaises.setBackground(new java.awt.Color(87, 198, 196));
        tablaPaises.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        tablaPaises.setForeground(new java.awt.Color(255, 255, 255));
        tablaPaises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PAIS", "CONTINENTE", "EXTENSION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPaises.setRowHeight(25);
        jScrollPane4.setViewportView(tablaPaises);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 360, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regresarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(DiccionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiccionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiccionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiccionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new DiccionarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField alimentacionTF;
    public javax.swing.JTextField alturaTF;
    public javax.swing.JTextField claseTF;
    public javax.swing.JLabel climaLbl;
    public javax.swing.JTextArea descripcionTXA;
    public javax.swing.JTextField dominioTF;
    public javax.swing.JTextField especieTF;
    public javax.swing.JTextField familiaTF;
    public javax.swing.JTextField filoTF;
    public javax.swing.JTextField generoTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JTextField largoTF;
    public javax.swing.JLabel lblFoto;
    public javax.swing.JButton mostrarClimaBtn;
    public javax.swing.JTextField ordenTF;
    public javax.swing.JTextField paleantologoTF;
    public javax.swing.JTextField pesoTF;
    public javax.swing.JTextField registradoTF;
    public javax.swing.JButton regresarBtn;
    public javax.swing.JTextField reinoTF;
    public javax.swing.JTable tablaClimas;
    public javax.swing.JTable tablaPaises;
    public javax.swing.JTable tablaTiempos;
    // End of variables declaration//GEN-END:variables
}
