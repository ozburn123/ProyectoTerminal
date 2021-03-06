/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dci_mineria.vistas;

import dci_mineria.ManejadorBaseDatos;
import dci_mineria.RecuperacionResultados;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ozburn123
 */
public class MuestraResultados extends javax.swing.JFrame {

    /**
     * Creates new form MuestraResultados
     */
    RecuperacionResultados results= new RecuperacionResultados();
    ManejadorBaseDatos con = new ManejadorBaseDatos ();
    //DefaultCategoryDataset data=new DefaultCategoryDataset();
    RecuperacionResultados res;
    
    public MuestraResultados() throws SQLException {
        
        initComponents();
        String valoresUAECCO[]= new String [100];
        String valoresUAPTCCO[]= new String [100];
        //String valoresAreaECCO[]= new String [1767];
        
        Connection cn = con.conex();
        valoresUAECCO=results.ValoresUAECCO(cn);
        //valoresAreaECCO=results.ValoresAreaECCO(cn);
        valoresUAPTCCO=results.ValoresUAPTCCO(cn);
        //valoresUSPTCCO=results.ValoresUSPTCCO(cn);
        
        this.comboUA.removeAllItems();
        for(int i=0;i<72;i++)
            this.comboUA.addItem(valoresUAECCO[i]);
        /*this.comboArea.removeAllItems();
        for(int i=0;i<1767;i++)
            this.comboArea.addItem(valoresAreaECCO[i]);*/
        this.comboUAPTCCO.removeAllItems();
        for(int i=0;i<72;i++)
            this.comboUAPTCCO.addItem(valoresUAPTCCO[i]);
        
        
        
        cn.close();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        panelGrafica1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        radioFactorPorArea = new javax.swing.JRadioButton();
        radioReactivoFactorPorArea = new javax.swing.JRadioButton();
        radioFactorPorUA = new javax.swing.JRadioButton();
        radioReactivoFactorPorUA = new javax.swing.JRadioButton();
        radioGlobalPorArea = new javax.swing.JRadioButton();
        botonResultadosECCO19 = new javax.swing.JButton();
        comboUA = new javax.swing.JComboBox<>();
        comboArea = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        botonResultadosPTCCO = new javax.swing.JButton();
        comboUAPTCCO = new javax.swing.JComboBox<>();
        comboUSPTCCO = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setAutoscrolls(true);

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaResultados);

        panelGrafica1.setBackground(new java.awt.Color(255, 255, 255));
        panelGrafica1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelGrafica1.setForeground(new java.awt.Color(255, 255, 255));
        panelGrafica1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        radioFactorPorArea.setText("Factor por Area");
        radioFactorPorArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFactorPorAreaActionPerformed(evt);
            }
        });

        radioReactivoFactorPorArea.setText("Reactivo Factor por Area");
        radioReactivoFactorPorArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioReactivoFactorPorAreaActionPerformed(evt);
            }
        });

        radioFactorPorUA.setText("Factor por Unidad Administrativa");
        radioFactorPorUA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFactorPorUAActionPerformed(evt);
            }
        });

        radioReactivoFactorPorUA.setText("Reactivo Factor por Unidad Administrativa");
        radioReactivoFactorPorUA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioReactivoFactorPorUAActionPerformed(evt);
            }
        });

        radioGlobalPorArea.setText("Global por Area");
        radioGlobalPorArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGlobalPorAreaActionPerformed(evt);
            }
        });

        botonResultadosECCO19.setText("Mostrar Resultados ECCO");

        comboUA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboUA.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboUAPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboUA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUAActionPerformed(evt);
            }
        });

        comboArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Unidad Administrativa");

        jLabel4.setText("Area");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioReactivoFactorPorUA)
                .addGap(95, 95, 95))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(botonResultadosECCO19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioGlobalPorArea)
                            .addComponent(radioFactorPorUA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioReactivoFactorPorArea)
                            .addComponent(radioFactorPorArea))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboUA, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioFactorPorArea)
                    .addComponent(radioFactorPorUA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioReactivoFactorPorArea)
                    .addComponent(radioGlobalPorArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioReactivoFactorPorUA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(comboUA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonResultadosECCO19)
                .addGap(15, 15, 15))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botonResultadosPTCCO.setText("Mostrar Resultados PTCCO");
        botonResultadosPTCCO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonResultadosPTCCOMouseClicked(evt);
            }
        });

        comboUAPTCCO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboUAPTCCO.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                comboUAPTCCOPopupMenuWillBecomeVisible(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboUAPTCCOPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboUAPTCCO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboUAPTCCOMouseClicked(evt);
            }
        });
        comboUAPTCCO.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                comboUAPTCCOComponentShown(evt);
            }
        });
        comboUAPTCCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUAPTCCOActionPerformed(evt);
            }
        });

        comboUSPTCCO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboUSPTCCO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboUSPTCCOMouseClicked(evt);
            }
        });
        comboUSPTCCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUSPTCCOActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Unidad Administrativa");

        jLabel2.setText("Unidad Segmentada");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonResultadosPTCCO)
                .addGap(113, 113, 113))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboUSPTCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboUAPTCCO, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboUAPTCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboUSPTCCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(botonResultadosPTCCO)
                .addGap(15, 15, 15))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon("/Users/ozburn123/NetBeansProjects/DCI_Mineria/Imagenes/header.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelGrafica1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelGrafica1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1233, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioFactorPorAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFactorPorAreaActionPerformed
        // TODO add your handling code here:
        if(this.radioFactorPorArea.isEnabled()){
            //this.comboArea.setEnabled(true);
            this.comboArea.setEnabled(true);
            //this.radioFactorPorArea.setEnabled(false);
            this.radioFactorPorUA.setSelected(false);
            this.radioGlobalPorArea.setSelected(false);
            this.radioReactivoFactorPorArea.setSelected(false);
            this.radioReactivoFactorPorUA.setSelected(false);

        }
    }//GEN-LAST:event_radioFactorPorAreaActionPerformed

    private void radioReactivoFactorPorAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioReactivoFactorPorAreaActionPerformed
        // TODO add your handling code here:
        if(this.radioReactivoFactorPorArea.isEnabled()){
            this.comboArea.setEnabled(true);
            this.radioFactorPorArea.setSelected(false);
            this.radioFactorPorUA.setSelected(false);
            this.radioGlobalPorArea.setSelected(false);
            // this.radioReactivoFactorPorArea.setEnabled(false);
            this.radioReactivoFactorPorUA.setSelected(false);
        }
    }//GEN-LAST:event_radioReactivoFactorPorAreaActionPerformed

    private void radioFactorPorUAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFactorPorUAActionPerformed
        // TODO add your handling code here:
        if(this.radioFactorPorUA.isEnabled()){
            //this.comboArea.setEnabled(true);
            this.comboArea.setEnabled(false);
            this.radioFactorPorArea.setSelected(false);
            // this.radioFactorPorUA.setEnabled(false);
            this.radioGlobalPorArea.setSelected(false);
            this.radioReactivoFactorPorArea.setSelected(false);
            this.radioReactivoFactorPorUA.setSelected(false);
        }
    }//GEN-LAST:event_radioFactorPorUAActionPerformed

    private void radioReactivoFactorPorUAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioReactivoFactorPorUAActionPerformed
        // TODO add your handling code here:
        if(this.radioReactivoFactorPorUA.isEnabled()){
            this.comboArea.setEnabled(false);
            this.radioFactorPorArea.setSelected(false);
            this.radioFactorPorUA.setSelected(false);
            this.radioGlobalPorArea.setSelected(false);
            this.radioReactivoFactorPorArea.setSelected(false);
        }
    }//GEN-LAST:event_radioReactivoFactorPorUAActionPerformed

    private void radioGlobalPorAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGlobalPorAreaActionPerformed
        // TODO add your handling code here:
        if(this.radioGlobalPorArea.isEnabled()){
            this.comboArea.setEnabled(true);
            this.radioFactorPorArea.setSelected(false);
            this.radioFactorPorUA.setSelected(false);
            //this.radioGlobalPorArea.setEnabled(false);
            this.radioReactivoFactorPorArea.setSelected(false);
            this.radioReactivoFactorPorUA.setSelected(false);
        }
    }//GEN-LAST:event_radioGlobalPorAreaActionPerformed

    private void comboUAPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboUAPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String valoresAreaECCO[]= new String [1642];
        //System.out.println("CLICK popup");
        Connection cn = con.conex();
        int cuentaValoresAreaECCO=0;
        //Object unidadAdministrativa=null;
        String unidadAdministrativa= this.comboUA.getSelectedItem().toString();
        if(unidadAdministrativa!=null){
            try {
                cuentaValoresAreaECCO= results.CuentaValoresAreaECCO(cn, unidadAdministrativa);
            } catch (SQLException ex) {
                Logger.getLogger(MuestraResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                valoresAreaECCO=results.ValoresAreaECCO(cn,unidadAdministrativa);
            } catch (SQLException ex) {
                Logger.getLogger(MuestraResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.comboArea.removeAllItems();
            for(int i=0;i<cuentaValoresAreaECCO;i++){
                this.comboArea.addItem(valoresAreaECCO[i]);
                // System.out.println("VAlores= "+valoresAreaECCO[i]);
            }
        }
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MuestraResultados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboUAPopupMenuWillBecomeInvisible

    private void comboUAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUAActionPerformed

    private void botonResultadosPTCCOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonResultadosPTCCOMouseClicked
        
    }//GEN-LAST:event_botonResultadosPTCCOMouseClicked

    private void comboUAPTCCOPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboUAPTCCOPopupMenuWillBecomeVisible
        // TODO add your handling code here:
        //System.out.println("click");
    }//GEN-LAST:event_comboUAPTCCOPopupMenuWillBecomeVisible

    private void comboUAPTCCOPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboUAPTCCOPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String valoresUSPTCCO[]= new String [1642];
        System.out.println("CLICK popup");
        Connection cn = con.conex();
        int cuentaValoresUSPTCCO=0;
        //Object unidadAdministrativa=null;
        String unidadAdministrativa= this.comboUAPTCCO.getSelectedItem().toString();
        if(unidadAdministrativa!=null){
            try {
                cuentaValoresUSPTCCO= results.CuentaValoresUSPTCCO(cn, unidadAdministrativa);
            } catch (SQLException ex) {
                Logger.getLogger(MuestraResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                valoresUSPTCCO=results.ValoresUSPTCCO(cn,unidadAdministrativa);
            } catch (SQLException ex) {
                Logger.getLogger(MuestraResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.comboUSPTCCO.removeAllItems();
            for(int i=0;i<cuentaValoresUSPTCCO;i++){
                this.comboUSPTCCO.addItem(valoresUSPTCCO[i]);
                //System.out.println("VAlores= "+valoresUSPTCCO[i]);
            }
        }
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MuestraResultados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboUAPTCCOPopupMenuWillBecomeInvisible

    private void comboUAPTCCOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboUAPTCCOMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUAPTCCOMouseClicked

    private void comboUAPTCCOComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_comboUAPTCCOComponentShown
        // TODO add your handling code here:
        // System.out.println("Se abre combo");
    }//GEN-LAST:event_comboUAPTCCOComponentShown

    private void comboUAPTCCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUAPTCCOActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboUAPTCCOActionPerformed

    private void comboUSPTCCOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboUSPTCCOMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUSPTCCOMouseClicked

    private void comboUSPTCCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUSPTCCOActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboUSPTCCOActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonResultadosECCO19;
    public javax.swing.JButton botonResultadosPTCCO;
    public javax.swing.JComboBox<String> comboArea;
    public javax.swing.JComboBox<String> comboUA;
    public javax.swing.JComboBox<String> comboUAPTCCO;
    public javax.swing.JComboBox<String> comboUSPTCCO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JPanel panelGrafica1;
    public javax.swing.JRadioButton radioFactorPorArea;
    public javax.swing.JRadioButton radioFactorPorUA;
    public javax.swing.JRadioButton radioGlobalPorArea;
    public javax.swing.JRadioButton radioReactivoFactorPorArea;
    public javax.swing.JRadioButton radioReactivoFactorPorUA;
    public javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables
}
