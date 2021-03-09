package view.taxonomia;

public class TaxonomiaForm extends javax.swing.JFrame {

    public TaxonomiaForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        regresarBtn1 = new javax.swing.JButton();
        salir1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        especieTF1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        reinoTF1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ordenTF1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        dominioTF1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        familiaTF1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        claseTF1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        filoTF1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        generoTF1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        alturaTF1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        largoTF1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        pesoTF1 = new javax.swing.JTextField();
        alimentacionTF1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        registradoTF1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        paleantologoTF1 = new javax.swing.JTextField();
        modificarBtn1 = new javax.swing.JButton();
        registrarBtn1 = new javax.swing.JButton();
        eliminarBtn1 = new javax.swing.JButton();
        paleanBtn1 = new javax.swing.JButton();
        refrescarBtn1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaT1 = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        agregarBtn1 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        btnAgrPais = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaPaises = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(12, 156, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regresarBtn1.setBackground(new java.awt.Color(12, 241, 253));
        regresarBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-arrow_icon-icons.com_72866.png"))); // NOI18N
        regresarBtn1.setFocusPainted(false);
        jPanel1.add(regresarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 40, 50));

        salir1.setBackground(new java.awt.Color(12, 241, 253));
        salir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/letterx_83737.png"))); // NOI18N
        salir1.setFocusPainted(false);
        salir1.setFocusable(false);
        salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir1ActionPerformed(evt);
            }
        });
        jPanel1.add(salir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, -1, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/globe_106381.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, 90, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/paintbrush_79604.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 130, 100));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dinosaur-bones_39225.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, 130, 100));

        jLabel1.setBackground(new java.awt.Color(87, 198, 196));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 220, 600));

        jPanel2.setBackground(new java.awt.Color(12, 156, 208));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Especie:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        especieTF1.setBackground(new java.awt.Color(12, 156, 208));
        especieTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        especieTF1.setForeground(new java.awt.Color(255, 255, 255));
        especieTF1.setBorder(null);
        jPanel2.add(especieTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 25));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Reino:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        reinoTF1.setBackground(new java.awt.Color(12, 156, 208));
        reinoTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        reinoTF1.setForeground(new java.awt.Color(255, 255, 255));
        reinoTF1.setBorder(null);
        jPanel2.add(reinoTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 140, 25));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Orden:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        ordenTF1.setBackground(new java.awt.Color(12, 156, 208));
        ordenTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        ordenTF1.setForeground(new java.awt.Color(255, 255, 255));
        ordenTF1.setBorder(null);
        jPanel2.add(ordenTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 25));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Dominio:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        dominioTF1.setBackground(new java.awt.Color(12, 156, 208));
        dominioTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        dominioTF1.setForeground(new java.awt.Color(255, 255, 255));
        dominioTF1.setBorder(null);
        jPanel2.add(dominioTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 140, 25));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Familia:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        familiaTF1.setBackground(new java.awt.Color(12, 156, 208));
        familiaTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        familiaTF1.setForeground(new java.awt.Color(255, 255, 255));
        familiaTF1.setBorder(null);
        jPanel2.add(familiaTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, 25));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Clase:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        claseTF1.setBackground(new java.awt.Color(12, 156, 208));
        claseTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        claseTF1.setForeground(new java.awt.Color(255, 255, 255));
        claseTF1.setBorder(null);
        jPanel2.add(claseTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 140, 25));

        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Filo:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        filoTF1.setBackground(new java.awt.Color(12, 156, 208));
        filoTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        filoTF1.setForeground(new java.awt.Color(255, 255, 255));
        filoTF1.setBorder(null);
        jPanel2.add(filoTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 140, 25));

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Genero:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        generoTF1.setBackground(new java.awt.Color(12, 156, 208));
        generoTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        generoTF1.setForeground(new java.awt.Color(255, 255, 255));
        generoTF1.setBorder(null);
        jPanel2.add(generoTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 140, 25));

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Altura:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        alturaTF1.setBackground(new java.awt.Color(12, 156, 208));
        alturaTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        alturaTF1.setForeground(new java.awt.Color(255, 255, 255));
        alturaTF1.setBorder(null);
        jPanel2.add(alturaTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 140, 25));

        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Largo:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        largoTF1.setBackground(new java.awt.Color(12, 156, 208));
        largoTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        largoTF1.setForeground(new java.awt.Color(255, 255, 255));
        largoTF1.setBorder(null);
        jPanel2.add(largoTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 140, 25));

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Peso:");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        pesoTF1.setBackground(new java.awt.Color(12, 156, 208));
        pesoTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        pesoTF1.setForeground(new java.awt.Color(255, 255, 255));
        pesoTF1.setBorder(null);
        jPanel2.add(pesoTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 140, 25));

        alimentacionTF1.setBackground(new java.awt.Color(12, 156, 208));
        alimentacionTF1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        alimentacionTF1.setForeground(new java.awt.Color(255, 255, 255));
        alimentacionTF1.setBorder(null);
        jPanel2.add(alimentacionTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 140, 25));

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Registrado:");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        registradoTF1.setEditable(false);
        registradoTF1.setBackground(new java.awt.Color(12, 156, 208));
        registradoTF1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(registradoTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, -1));

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Paleantologo:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        paleantologoTF1.setEditable(false);
        paleantologoTF1.setBackground(new java.awt.Color(12, 156, 208));
        paleantologoTF1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(paleantologoTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 150, -1));

        modificarBtn1.setBackground(new java.awt.Color(87, 198, 196));
        modificarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        modificarBtn1.setText("MODIFICAR");
        jPanel2.add(modificarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));

        registrarBtn1.setBackground(new java.awt.Color(87, 198, 196));
        registrarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        registrarBtn1.setText("REGISTRAR");
        jPanel2.add(registrarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 100, -1));

        eliminarBtn1.setBackground(new java.awt.Color(87, 198, 196));
        eliminarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        eliminarBtn1.setText("ELIMINAR");
        jPanel2.add(eliminarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 90, -1));

        paleanBtn1.setBackground(new java.awt.Color(87, 198, 196));
        paleanBtn1.setForeground(new java.awt.Color(255, 255, 255));
        paleanBtn1.setText("Seleccionar");
        jPanel2.add(paleanBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        refrescarBtn1.setBackground(new java.awt.Color(87, 198, 196));
        refrescarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        refrescarBtn1.setText("R");
        jPanel2.add(refrescarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));

        listaT1.setBackground(new java.awt.Color(12, 156, 208));
        listaT1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(listaT1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 160, -1));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tiempo:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        agregarBtn1.setBackground(new java.awt.Color(87, 198, 196));
        agregarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        agregarBtn1.setText("Agregar");
        jPanel2.add(agregarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, -1, -1));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 40));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 40));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 140, 40));

        jSeparator12.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 140, 40));

        jSeparator14.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator14.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 140, 40));

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator15.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 140, 40));

        jSeparator16.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator16.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 140, 40));

        jSeparator17.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator17.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 140, 40));

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Alimentación:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));

        jSeparator20.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator20.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 40));

        jSeparator21.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator21.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 140, 40));

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 140, 40));

        jSeparator18.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator18.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 140, 40));

        btnAgrPais.setBackground(new java.awt.Color(87, 198, 196));
        btnAgrPais.setForeground(new java.awt.Color(255, 255, 255));
        btnAgrPais.setText("Agregar");
        jPanel2.add(btnAgrPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, -1, -1));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Pais:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, -1, -1));

        listaPaises.setBackground(new java.awt.Color(12, 156, 208));
        jScrollPane3.setViewportView(listaPaises);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 170, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salir1ActionPerformed

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
            java.util.logging.Logger.getLogger(TaxonomiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaxonomiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaxonomiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaxonomiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaxonomiaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton agregarBtn1;
    public javax.swing.JTextField alimentacionTF1;
    public javax.swing.JTextField alturaTF1;
    public javax.swing.JButton btnAgrPais;
    public javax.swing.JTextField claseTF1;
    public javax.swing.JTextField dominioTF1;
    public javax.swing.JButton eliminarBtn1;
    public javax.swing.JTextField especieTF1;
    public javax.swing.JTextField familiaTF1;
    public javax.swing.JTextField filoTF1;
    public javax.swing.JTextField generoTF1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JTextField largoTF1;
    public javax.swing.JList<String> listaPaises;
    public javax.swing.JList<String> listaT1;
    public javax.swing.JButton modificarBtn1;
    public javax.swing.JTextField ordenTF1;
    public javax.swing.JButton paleanBtn1;
    public javax.swing.JTextField paleantologoTF1;
    public javax.swing.JTextField pesoTF1;
    public javax.swing.JButton refrescarBtn1;
    public javax.swing.JTextField registradoTF1;
    public javax.swing.JButton registrarBtn1;
    public javax.swing.JButton regresarBtn1;
    public javax.swing.JTextField reinoTF1;
    private javax.swing.JButton salir1;
    // End of variables declaration//GEN-END:variables
}
