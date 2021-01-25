/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dci_mineria.controlador;

import dci_mineria.CreadorArchivoXLS;
import dci_mineria.ManejadorBaseDatos;
import dci_mineria.RecuperacionResultados;
import dci_mineria.vistas.MuestraResultados;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ozburn123
 */



public class ControladorResultados implements ActionListener {
    ManejadorBaseDatos con = new ManejadorBaseDatos ();
    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 30 ? true : false;
        }

    };
    
    DefaultTableModel modeloFactorPorArea = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 30 ? true : false;
        }

    };
    
    DefaultTableModel modeloFactorPorUA = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 30 ? true : false;
        }

    };
    
    DefaultTableModel modeloReactivoFactorPorUA = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 30 ? true : false;
        }

    };
    
    DefaultTableModel modeloReactivoFactorPorArea = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 30 ? true : false;
        }

    };
    
    
    RecuperacionResultados resultados=new RecuperacionResultados();
    JScrollPane scrollPrincipal;
    CreadorArchivoXLS excel=new CreadorArchivoXLS();
    int contadorEntradasPTCCO=0;
    int contadorEntradasECCO=0;
    int contadorEntradasFactorPorAreaECCO=0;
    int contadorEntradasFactorPorUAECCO=0;
    int contadorEntradasGlobalPorAreaECCO=0;
    int contadorEntradasReactivoFactorPorAreaECCO=0;
    int contadorEntradasReactivoFactorPorUAECCO=0;
   
    private MuestraResultados vista;
    
    public ControladorResultados(MuestraResultados vista){
        this.vista=vista;
        this.vista.botonResultadosECCO19.addActionListener(this);
        this.vista.botonResultadosPTCCO.addActionListener(this);
        this.vista.comboArea.addActionListener(this);
        this.vista.comboUA.addActionListener(this);
        this.vista.radioFactorPorArea.addActionListener(this);
        this.vista.radioFactorPorUA.addActionListener(this);
        this.vista.radioGlobalPorArea.addActionListener(this);
        this.vista.radioReactivoFactorPorArea.addActionListener(this);
        this.vista.radioReactivoFactorPorUA.addActionListener(this);
       // this.vista.comboUAPTCCO.addActionListener(this);
        //this.vista.comboUSPTCCO.addActionListener(this);
    }
    
    public void iniciar(){
    vista.setTitle("Mineria IMSS");
    vista.setLocationRelativeTo(null);  
    
    }
    
    
    public void botonResultadosPTCCOMouseClicked(java.awt.event.MouseEvent evt) throws SQLException{
    //resultados.ResultadosGlobalesTabla();
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        vista.tablaResultados.getTableHeader().setReorderingAllowed(false);
        
        
        String evento =e.getActionCommand();
        //DefaultCategoryDataset data1=new DefaultCategoryDataset();
        Object[] agregar = new Object[23];
        System.out.println("Evento"+evento);
        if(evento.equals("Mostrar Resultados PTCCO")){
             DefaultCategoryDataset data=new DefaultCategoryDataset();
            //int columnas=vista.tablaResultados.getColumnCount();
            //vista.tablaResultados.removeColumnSelectionInterval(0, columnas-1);
            
            //vista.tablaResultados.setModel(new DefaultTableModel());
            vista.tablaResultados.setModel(modelo);
            //((AbstractTableModel) modelo).fireTableDataChanged();
            //modelo.fireTableRowsInserted(15,15);
            int numRow = modelo.getRowCount();
            for (int i = numRow - 1; i >= 0; i--) {
            modelo.removeRow(i);
            } 
            //modelo.setColumnCount(columnas);
            if(contadorEntradasPTCCO==0){
                vista.panelGrafica1.removeAll();;
        
        
                vista.tablaResultados.removeAll();
            modelo.setRowCount(0);
            modelo.setColumnCount(0);
               modelo.addColumn("Cluster");
               modelo.addColumn("TipoUnidad");
               modelo.addColumn("UniAdmin");
               modelo.addColumn("UniSeg");
               modelo.addColumn("NumObj");
               modelo.addColumn("InicioPrac");
               modelo.addColumn("TerPrac");
               modelo.addColumn("Precisiones Tiempo");
               modelo.addColumn("Personal Impacta");
               modelo.addColumn("Tipo Accion");
               modelo.addColumn("FactorA1");
               modelo.addColumn("Evidencia");
               modelo.addColumn("Reactivo A1");
               modelo.addColumn("1er Seg");
               modelo.addColumn("2do Seg");
            }
        //precisionesTiempo,personalImpacta,tipoAccion,factorA1,evidenciaPresentar,reactivoA1,evidenciaPrimSeg,evidenciaSegunSeg
            Connection cn = con.conex();
            String[][] valores = new String[15][10];
        RecuperacionResultados res=new RecuperacionResultados();
            try {
               valores= res.ResultadosGlobalesTabla(cn);
              // data1=res.ResultadosGlobalesGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 15; i++) {
                    //System.out.println("VALORES= "+valores[i][j]);
                    agregar[i] = valores[i][j]; 
                }
                    modelo.addRow(agregar);
            }
        //////////////////
        //DefaultCategoryDataset datosGrafica= new DefaultCategoryDataset();
        int[][] valoresGrafica = new int[15][10];
            try {
                valoresGrafica=resultados.ResultadosGlobalesGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i=0; i<10;i++){
                    data.addValue(valoresGrafica[0][i], "Cluster "+i, "tipoUnidad");
                    data.addValue(valoresGrafica[1][i], "Cluster "+i, "unidadAdmin");
                    data.addValue(valoresGrafica[2][i], "Cluster "+i, "unidadSegmentada");
                    data.addValue(valoresGrafica[3][i], "Cluster "+i, "numObjetivo");
                    data.addValue(valoresGrafica[4][i], "Cluster "+i, "inicioPractica");
                    data.addValue(valoresGrafica[5][i], "Cluster "+i, "terminacionPractica");
                    data.addValue(valoresGrafica[6][i], "Cluster "+i, "precisionesTiempo");
                    data.addValue(valoresGrafica[7][i], "Cluster "+i, "personalImpacta");
                    data.addValue(valoresGrafica[8][i], "Cluster "+i, "tipoAccion");
                    data.addValue(valoresGrafica[9][i], "Cluster "+i, "factorA1");
                    data.addValue(valoresGrafica[10][i], "Cluster "+i, "evidenciaPresentar");
                    data.addValue(valoresGrafica[11][i], "Cluster "+i, "reactivoA1");
                    data.addValue(valoresGrafica[12][i], "Cluster "+i, "evidenciaPrimSeg");
                    data.addValue(valoresGrafica[13][i], "Cluster "+i, "evidenciaSegunSeg");
                }        
        JFreeChart grafica1= ChartFactory.createBarChart("Resultados de Mineria PTCCO Global", "Clusters", "Num.Cluster/Num.Total ", data, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
        
        String uniAdmin= vista.comboUAPTCCO.getSelectedItem().toString();
        String uniSeg= vista.comboUSPTCCO.getSelectedItem().toString();
        
        int tipoUnidad=0;
        int idUniAdmin=0;
        int idUniSeg=0;
        int [] clusters=new int[11];
       
            try {
                idUniAdmin=resultados.idUAdminPTCCO(cn, uniAdmin);
                idUniSeg=resultados.idUSegPTCCO(cn, uniSeg);
                tipoUnidad=resultados.tipoUnidadPTCCO(cn, idUniAdmin, idUniSeg);
                clusters=resultados.clustersPTCCO(idUniAdmin, idUniSeg, tipoUnidad, cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error, la Unidad Administrativa: "+uniAdmin+"\n No coincide con la Unidad Segmentada: "+uniSeg);
            }
           
            try {
                //excel.creaXLS();
                excel.creaXLS(uniSeg,uniAdmin,tipoUnidad,clusters);
                JOptionPane.showMessageDialog(null, "Archivo Generado Revisar Escritorio");
            } catch (IOException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al crear el reporte en excel, intente de nuevo");
            }
            
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al cerrar conexión");
            }
        contadorEntradasPTCCO++;
        contadorEntradasECCO=0;
        //contadorEntradasFactorPorAreaECCO=0;
        //contadorEntradasFactorPorUAECCO=0;
 /////////////////////////////////////////////////ECCO/////////////////////////////////////////////
        } else if(evento.equals("Mostrar Resultados ECCO")){
            if(vista.radioFactorPorArea.isSelected()){  
//////////////////////////////FACTOR POR AREA////////////////////////////////////////////////////////
                //int columnas=vista.tablaResultados.getColumnCount();
            //vista.tablaResultados.removeColumnSelectionInterval(0, columnas-1);
             DefaultCategoryDataset data=new DefaultCategoryDataset();
           // vista.tablaResultados.setModel(new DefaultTableModel());
            vista.tablaResultados.setModel(modeloFactorPorArea);
            //modelo.fireTableRowsInserted(7,7);
            //((AbstractTableModel) modelo).fireTableDataChanged();
            int numRow = modeloFactorPorArea.getRowCount();
            for (int i = numRow - 1; i >= 0; i--) {
            modeloFactorPorArea.removeRow(i);
            } 
            //modelo.setColumnCount(columnas);
            if(contadorEntradasECCO==0||contadorEntradasFactorPorAreaECCO==0){
                DefaultCategoryDataset data1=new DefaultCategoryDataset();
                JFreeChart grafica1= ChartFactory.createBarChart("", "", "", data1, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
                
                
                vista.tablaResultados.removeAll();
            modeloFactorPorArea.setRowCount(0);
            modeloFactorPorArea.setColumnCount(0);
               modeloFactorPorArea.addColumn("Cluster");
               modeloFactorPorArea.addColumn("ID_UA");
               modeloFactorPorArea.addColumn("UA");
               modeloFactorPorArea.addColumn("ID_Area");
               modeloFactorPorArea.addColumn("Area");
               modeloFactorPorArea.addColumn("ID_FACTOR");
               modeloFactorPorArea.addColumn("CALIF_PREG");
            }
        //precisionesTiempo,personalImpacta,tipoAccion,factorA1,evidenciaPresentar,reactivoA1,evidenciaPrimSeg,evidenciaSegunSeg
            Connection cn = con.conex();
            String[][] valores = new String[7][10];
        RecuperacionResultados res=new RecuperacionResultados();
            try {
               valores= res.ResultadosFactorPorAreaTabla(cn);
              // data1=res.ResultadosGlobalesGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 7; i++) {
                    //System.out.println("VALORES= "+valores[i][j]);
                    agregar[i] = valores[i][j]; 
                }
                    modeloFactorPorArea.addRow(agregar);
            }
        //////////////////
        //DefaultCategoryDataset datosGrafica= new DefaultCategoryDataset();
        int[][] valoresGrafica = new int[7][10];
            try {
                valoresGrafica=resultados.ResultadosFactorPorAreaGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i=0; i<10;i++){
                    data.addValue(valoresGrafica[0][i], "Cluster "+i, "ID_UA");
                    data.addValue(valoresGrafica[1][i], "Cluster "+i, "UA");
                    data.addValue(valoresGrafica[2][i], "Cluster "+i, "ID_AREA");
                    data.addValue(valoresGrafica[3][i], "Cluster "+i, "AREA");
                    data.addValue(valoresGrafica[4][i], "Cluster "+i, "ID_FACTOR");
                    data.addValue(valoresGrafica[5][i], "Cluster "+i, "CALIF_PREG");
                }        
        JFreeChart grafica1= ChartFactory.createBarChart("Resultados de Mineria ECCO Factor por Area", "Clusters", "Num.Cluster/Num.Total ", data, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
        
        String uniAdmin= vista.comboUA.getSelectedItem().toString();
        String area= vista.comboArea.getSelectedItem().toString();
        
        //int tipoUnidad=0;
        int idUniAdmin=0;
        String tipoArchivo="FactorporArea";
        int idArea=0;
        int [] clusters=new int[11];
       
            try {
                idUniAdmin=resultados.idUAdminECCO(cn, uniAdmin);
 
                idArea=resultados.idAreaECCO(cn, area);
                
                //System.out.println("UNIadmin= "+idUniAdmin);
                //System.out.println("Area= "+ idArea);
                //tipoUnidad=resultados.tipoUnidadPTCCO(cn, idUniAdmin, idArea);
                clusters=resultados.clustersFactorPorAreaECCO(idUniAdmin, idArea, cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error, la Unidad Administrativa: "+uniAdmin+"\n No coincide con el Area: "+area);
            }
           
            try {
                //excel.creaXLS();
                excel.creaXLSECCO(area,uniAdmin,tipoArchivo,clusters);
                JOptionPane.showMessageDialog(null, "Archivo Generado Revisar Escritorio");
            } catch (IOException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al crear el reporte en excel, intente de nuevo");
            }
            
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al cerrar conexión");
            } contadorEntradasECCO++; contadorEntradasFactorPorAreaECCO++; contadorEntradasPTCCO=0;
                
                
/////////////////////////////////////////////////////////////////////////////////////////////////////                
                
            }else if(vista.radioFactorPorUA.isSelected()){
            System.out.println("Factor por UA");
///////////////////////////////////////////////FACTOR POR UA/////////////////////////////////////////
            DefaultCategoryDataset data=new DefaultCategoryDataset();
           // vista.tablaResultados.setModel(new DefaultTableModel());
            vista.tablaResultados.setModel(modeloFactorPorUA);
            //modelo.fireTableRowsInserted(7,7);
            //((AbstractTableModel) modelo).fireTableDataChanged();
            int numRow = modeloFactorPorUA.getRowCount();
            for (int i = numRow - 1; i >= 0; i--) {
            modeloFactorPorUA.removeRow(i);
            } 
            //modelo.setColumnCount(columnas);
            if(contadorEntradasECCO==0||contadorEntradasFactorPorUAECCO==0){
                DefaultCategoryDataset data1=new DefaultCategoryDataset();
                JFreeChart grafica1= ChartFactory.createBarChart("", "", "", data1, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
                
                
                vista.tablaResultados.removeAll();
            modeloFactorPorUA.setRowCount(0);
            modeloFactorPorUA.setColumnCount(0);
               modeloFactorPorUA.addColumn("Cluster");
               modeloFactorPorUA.addColumn("ID_UA");
               modeloFactorPorUA.addColumn("UA");
               modeloFactorPorUA.addColumn("ID_FACTOR");
               modeloFactorPorUA.addColumn("CALIF_PREG");
            }
        //precisionesTiempo,personalImpacta,tipoAccion,factorA1,evidenciaPresentar,reactivoA1,evidenciaPrimSeg,evidenciaSegunSeg
            Connection cn = con.conex();
            String[][] valores = new String[5][10];
        RecuperacionResultados res=new RecuperacionResultados();
            try {
               valores= res.ResultadosFactorPorUATabla(cn);
              // data1=res.ResultadosGlobalesGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 5; i++) {
                    System.out.println("VALORES= "+valores[i][j]);
                    agregar[i] = valores[i][j]; 
                }
                    modeloFactorPorUA.addRow(agregar);
            }
        //////////////////
        //DefaultCategoryDataset datosGrafica= new DefaultCategoryDataset();
        int[][] valoresGrafica = new int[5][10];
            try {
                valoresGrafica=resultados.ResultadosFactorPorUAGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i=0; i<10;i++){
                    data.addValue(valoresGrafica[0][i], "Cluster "+i, "ID_UA");
                    data.addValue(valoresGrafica[1][i], "Cluster "+i, "UA");
                    data.addValue(valoresGrafica[2][i], "Cluster "+i, "ID_FACTOR");
                    data.addValue(valoresGrafica[3][i], "Cluster "+i, "CALIF_PREG");
                   
                }        
        JFreeChart grafica1= ChartFactory.createBarChart("Resultados de Mineria ECCO Factor por UA", "Clusters", "Num.Cluster/Num.Total ", data, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
        
        String uniAdmin= vista.comboUA.getSelectedItem().toString();
        String area= vista.comboArea.getSelectedItem().toString();
        
        //int tipoUnidad=0;
        int idUniAdmin=0;
        String tipoArchivo="FactorxUA";
        //int idArea=0;
        int [] clusters=new int[11];
       
            try {
                idUniAdmin=resultados.idUAdminECCO(cn, uniAdmin);
                clusters=resultados.clustersFactorPorUAECCO(idUniAdmin, cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error, no se encuenta la Unidad Administrativa: "+uniAdmin);
            }
           
            try {
                //excel.creaXLS();
                excel.creaXLSECCO2(uniAdmin,tipoArchivo,clusters);
                JOptionPane.showMessageDialog(null, "Archivo Generado Revisar Escritorio");
            } catch (IOException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al crear el reporte en excel, intente de nuevo");
            }
            
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al cerrar conexión");
            } contadorEntradasECCO++; contadorEntradasPTCCO=0; contadorEntradasFactorPorUAECCO++;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

            
            }else if(vista.radioGlobalPorArea.isSelected()){
            System.out.println("Global por Area");
/////////////////////////////////////Global por Area//////////////////////////////////////////////////////////
DefaultCategoryDataset data=new DefaultCategoryDataset();
           // vista.tablaResultados.setModel(new DefaultTableModel());
            vista.tablaResultados.setModel(modeloFactorPorArea);
            //modelo.fireTableRowsInserted(7,7);
            //((AbstractTableModel) modelo).fireTableDataChanged();
            int numRow = modeloFactorPorArea.getRowCount();
            for (int i = numRow - 1; i >= 0; i--) {
            modeloFactorPorArea.removeRow(i);
            } 
            //modelo.setColumnCount(columnas);
            if(contadorEntradasECCO==0||contadorEntradasGlobalPorAreaECCO==0){
                DefaultCategoryDataset data1=new DefaultCategoryDataset();
                JFreeChart grafica1= ChartFactory.createBarChart("", "", "", data1, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
                
                
                vista.tablaResultados.removeAll();
            modeloFactorPorArea.setRowCount(0);
            modeloFactorPorArea.setColumnCount(0);
               modeloFactorPorArea.addColumn("Cluster");
               modeloFactorPorArea.addColumn("ID_UA");
               modeloFactorPorArea.addColumn("UA");
               modeloFactorPorArea.addColumn("ID_Area");
               modeloFactorPorArea.addColumn("Area");
               modeloFactorPorArea.addColumn("CALIF_PREG");
            }
        //precisionesTiempo,personalImpacta,tipoAccion,factorA1,evidenciaPresentar,reactivoA1,evidenciaPrimSeg,evidenciaSegunSeg
            Connection cn = con.conex();
            String[][] valores = new String[6][10];
        RecuperacionResultados res=new RecuperacionResultados();
            try {
               valores= res.ResultadosFactorPorAreaTabla(cn);
              // data1=res.ResultadosGlobalesGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 6; i++) {
                    //System.out.println("VALORES= "+valores[i][j]);
                    agregar[i] = valores[i][j]; 
                }
                    modeloFactorPorArea.addRow(agregar);
            }
        //////////////////
        //DefaultCategoryDataset datosGrafica= new DefaultCategoryDataset();
        int[][] valoresGrafica = new int[7][10];
            try {
                valoresGrafica=resultados.ResultadosGlobalPorAreaGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i=0; i<10;i++){
                    data.addValue(valoresGrafica[0][i], "Cluster "+i, "ID_UA");
                    data.addValue(valoresGrafica[1][i], "Cluster "+i, "UA");
                    data.addValue(valoresGrafica[2][i], "Cluster "+i, "ID_AREA");
                    data.addValue(valoresGrafica[3][i], "Cluster "+i, "AREA");
                    //data.addValue(valoresGrafica[4][i], "Cluster "+i, "ID_FACTOR");
                    data.addValue(valoresGrafica[4][i], "Cluster "+i, "CALIF_PREG");
                }        
        JFreeChart grafica1= ChartFactory.createBarChart("Resultados de Mineria ECCO Global por Area", "Clusters", "Num.Cluster/Num.Total ", data, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
        
        String uniAdmin= vista.comboUA.getSelectedItem().toString();
        String area= vista.comboArea.getSelectedItem().toString();
        
        //int tipoUnidad=0;
        int idUniAdmin=0;
        String tipoArchivo="GlobalporArea";
        int idArea=0;
        int [] clusters=new int[11];
       
            try {
                idUniAdmin=resultados.idUAdminECCO(cn, uniAdmin);
 
                idArea=resultados.idAreaECCO(cn, area);
                
                //System.out.println("UNIadmin= "+idUniAdmin);
                //System.out.println("Area= "+ idArea);
                //tipoUnidad=resultados.tipoUnidadPTCCO(cn, idUniAdmin, idArea);
                clusters=resultados.clustersGlobalPorAreaECCO(idUniAdmin, idArea, cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error, la Unidad Administrativa: "+uniAdmin+"\n No coincide con el Area: "+area);
            }
           
            try {
                //excel.creaXLS();
                excel.creaXLSECCO(area,uniAdmin,tipoArchivo,clusters);
                JOptionPane.showMessageDialog(null, "Archivo Generado Revisar Escritorio");
            } catch (IOException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al crear el reporte en excel, intente de nuevo");
            }
            
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al cerrar conexión");
            } contadorEntradasECCO++; contadorEntradasGlobalPorAreaECCO++; contadorEntradasPTCCO=0;
            
            
/////////////////////////////////////////////////////////////////////////////////////////////////////////            
            
            }else if(vista.radioReactivoFactorPorArea.isSelected()){
            System.out.println("Reactivo Factor por Area");
////////////////////////////////Reactivo Factor por Area////////////////////////////////////////////////
DefaultCategoryDataset data=new DefaultCategoryDataset();
           // vista.tablaResultados.setModel(new DefaultTableModel());
            vista.tablaResultados.setModel(modeloReactivoFactorPorArea);
            //modelo.fireTableRowsInserted(7,7);
            //((AbstractTableModel) modelo).fireTableDataChanged();
            int numRow = modeloReactivoFactorPorArea.getRowCount();
            for (int i = numRow - 1; i >= 0; i--) {
            modeloReactivoFactorPorArea.removeRow(i);
            } 
            //modelo.setColumnCount(columnas);
            if(contadorEntradasECCO==0||contadorEntradasReactivoFactorPorAreaECCO==0){
                DefaultCategoryDataset data1=new DefaultCategoryDataset();
                JFreeChart grafica1= ChartFactory.createBarChart("", "", "", data1, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
                
                
                vista.tablaResultados.removeAll();
            modeloReactivoFactorPorArea.setRowCount(0);
            modeloReactivoFactorPorArea.setColumnCount(0);
               modeloReactivoFactorPorArea.addColumn("Cluster");
               modeloReactivoFactorPorArea.addColumn("ID_UA");
               modeloReactivoFactorPorArea.addColumn("UA");
               modeloReactivoFactorPorArea.addColumn("ID_Area");
               modeloReactivoFactorPorArea.addColumn("Area");
               modeloReactivoFactorPorArea.addColumn("ID_Factor");
               modeloReactivoFactorPorArea.addColumn("ID_Reactivo");
               modeloReactivoFactorPorArea.addColumn("CALIF_PREG");
            }
        //precisionesTiempo,personalImpacta,tipoAccion,factorA1,evidenciaPresentar,reactivoA1,evidenciaPrimSeg,evidenciaSegunSeg
            Connection cn = con.conex();
            String[][] valores = new String[8][10];
        RecuperacionResultados res=new RecuperacionResultados();
            try {
               valores= res.ResultadosReactivoFactorPorAreaTabla(cn);
              // data1=res.ResultadosGlobalesGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 8; i++) {
                    //System.out.println("VALORES= "+valores[i][j]);
                    agregar[i] = valores[i][j]; 
                }
                    modeloReactivoFactorPorArea.addRow(agregar);
            }
        //////////////////
        //DefaultCategoryDataset datosGrafica= new DefaultCategoryDataset();
        int[][] valoresGrafica = new int[7][10];
            try {
                valoresGrafica=resultados.ResultadosReactivoFactorPorAreaGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i=0; i<10;i++){
                    data.addValue(valoresGrafica[0][i], "Cluster "+i, "ID_UA");
                    data.addValue(valoresGrafica[1][i], "Cluster "+i, "UA");
                    data.addValue(valoresGrafica[2][i], "Cluster "+i, "ID_AREA");
                    data.addValue(valoresGrafica[3][i], "Cluster "+i, "AREA");
                    data.addValue(valoresGrafica[4][i], "Cluster "+i, "ID_FACTOR");
                    data.addValue(valoresGrafica[5][i], "Cluster "+i, "ID_REACTIVO");
                    data.addValue(valoresGrafica[6][i], "Cluster "+i, "CALIF_PREG");
                }        
        JFreeChart grafica1= ChartFactory.createBarChart("Resultados de Mineria ECCO Reactivo Factor por Area", "Clusters", "Num.Cluster/Num.Total ", data, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
        
        String uniAdmin= vista.comboUA.getSelectedItem().toString();
        String area= vista.comboArea.getSelectedItem().toString();
        
        //int tipoUnidad=0;
        int idUniAdmin=0;
        String tipoArchivo="ReactivoFactorporArea";
        int idArea=0;
        int [] clusters=new int[11];
       
            try {
                idUniAdmin=resultados.idUAdminECCO(cn, uniAdmin);
 
                idArea=resultados.idAreaECCO(cn, area);
                
                //System.out.println("UNIadmin= "+idUniAdmin);
                //System.out.println("Area= "+ idArea);
                //tipoUnidad=resultados.tipoUnidadPTCCO(cn, idUniAdmin, idArea);
                clusters=resultados.clustersReactivoFactorPorAreaECCO(idUniAdmin, idArea, cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error, la Unidad Administrativa: "+uniAdmin+"\n No coincide con el Area: "+area);
            }
           
            try {
                //excel.creaXLS();
                excel.creaXLSECCO(area,uniAdmin,tipoArchivo,clusters);
                JOptionPane.showMessageDialog(null, "Archivo Generado Revisar Escritorio");
            } catch (IOException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al crear el reporte en excel, intente de nuevo");
            }
            
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al cerrar conexión");
            } contadorEntradasECCO++; contadorEntradasReactivoFactorPorAreaECCO++; contadorEntradasPTCCO=0;
            
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



            }else if(vista.radioReactivoFactorPorUA.isSelected()){
            System.out.println("Reactivo Factor por UA");
///////////////////////////////////////////Reactivo Factor por UA///////////////////////////////////////////////////////////////////////////////            
            DefaultCategoryDataset data=new DefaultCategoryDataset();
           // vista.tablaResultados.setModel(new DefaultTableModel());
            vista.tablaResultados.setModel(modeloReactivoFactorPorUA);
            //modelo.fireTableRowsInserted(7,7);
            //((AbstractTableModel) modelo).fireTableDataChanged();
            int numRow = modeloReactivoFactorPorUA.getRowCount();
            for (int i = numRow - 1; i >= 0; i--) {
            modeloReactivoFactorPorUA.removeRow(i);
            } 
            //modelo.setColumnCount(columnas);
            if(contadorEntradasECCO==0||contadorEntradasReactivoFactorPorUAECCO==0){
                DefaultCategoryDataset data1=new DefaultCategoryDataset();
                JFreeChart grafica1= ChartFactory.createBarChart("", "", "", data1, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
                
                
                vista.tablaResultados.removeAll();
            modeloReactivoFactorPorUA.setRowCount(0);
            modeloReactivoFactorPorUA.setColumnCount(0);
               modeloReactivoFactorPorUA.addColumn("Cluster");
               modeloReactivoFactorPorUA.addColumn("ID_UA");
               modeloReactivoFactorPorUA.addColumn("UA");
               modeloReactivoFactorPorUA.addColumn("ID_FACTOR");
               modeloReactivoFactorPorUA.addColumn("ID_REACTIVO");
               modeloReactivoFactorPorUA.addColumn("CALIF_PREG");
            }
        //precisionesTiempo,personalImpacta,tipoAccion,factorA1,evidenciaPresentar,reactivoA1,evidenciaPrimSeg,evidenciaSegunSeg
            Connection cn = con.conex();
            String[][] valores = new String[6][10];
        RecuperacionResultados res=new RecuperacionResultados();
            try {
               valores= res.ResultadosReactivoFactorPorUATabla(cn);
              // data1=res.ResultadosGlobalesGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        for (int j = 0; j < 10; j++) {
                for (int i = 0; i < 6; i++) {
                    System.out.println("VALORES= "+valores[i][j]);
                    agregar[i] = valores[i][j]; 
                }
                    modeloReactivoFactorPorUA.addRow(agregar);
            }
        //////////////////
        //DefaultCategoryDataset datosGrafica= new DefaultCategoryDataset();
        int[][] valoresGrafica = new int[5][10];
            try {
                valoresGrafica=resultados.ResultadosReactivoFactorPorUAGrafica(cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i=0; i<10;i++){
                    data.addValue(valoresGrafica[0][i], "Cluster "+i, "ID_UA");
                    data.addValue(valoresGrafica[1][i], "Cluster "+i, "UA");
                    data.addValue(valoresGrafica[2][i], "Cluster "+i, "ID_FACTOR");
                    data.addValue(valoresGrafica[3][i], "Cluster "+i, "ID_REACTIVO");
                    data.addValue(valoresGrafica[4][i], "Cluster "+i, "CALIF_PREG");
                   
                }        
        JFreeChart grafica1= ChartFactory.createBarChart("Resultados de Mineria ECCO Reactivo Factor por UA", "Clusters", "Num.Cluster/Num.Total ", data, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel barPanel=new ChartPanel(grafica1);
        vista.panelGrafica1.removeAll();
        
        vista.panelGrafica1.add(barPanel,BorderLayout.CENTER);
        vista.panelGrafica1.validate(); 
        
        String uniAdmin= vista.comboUA.getSelectedItem().toString();
       // String area= vista.comboArea.getSelectedItem().toString();
        
        //int tipoUnidad=0;
        int idUniAdmin=0;
        String tipoArchivo="ReactivoFactorxUA";
        //int idArea=0;
        int [] clusters=new int[11];
       
            try {
                idUniAdmin=resultados.idUAdminECCO(cn, uniAdmin);
                clusters=resultados.clustersReactivoFactorPorUAECCO(idUniAdmin, cn);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error, no se encuenta la Unidad Administrativa: "+uniAdmin);
            }
           
            try {
                //excel.creaXLS();
                excel.creaXLSECCO2(uniAdmin,tipoArchivo,clusters);
                JOptionPane.showMessageDialog(null, "Archivo Generado Revisar Escritorio");
            } catch (IOException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al crear el reporte en excel, intente de nuevo");
            }
            
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorResultados.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error al cerrar conexión");
            } contadorEntradasECCO++; contadorEntradasPTCCO=0; contadorEntradasReactivoFactorPorUAECCO++;
            
            
            
            }else JOptionPane.showMessageDialog(null, "Favor de seleccionar algún argumento");           
            
        }
      
    }
    
    
}
