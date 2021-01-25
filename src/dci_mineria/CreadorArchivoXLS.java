/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dci_mineria;


//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.nio.file.Files;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author ozburn123
 */
public class CreadorArchivoXLS {
    
    ManejadorXLS archivo =new ManejadorXLS();
    
    public void creaXLS(String uniSeg,String uniAdmin, int tipoUnidad,int[] clusters) throws FileNotFoundException, IOException{  
    String ruta = System.getProperty("user.home") + "/Desktop/";//\\Desktop\\
    archivo.XLSPTCCO(uniSeg,tipoUnidad);
    FileInputStream inp = new FileInputStream(ruta+uniSeg+"PTCCO.xls"); 
    HSSFWorkbook workbook = (HSSFWorkbook) WorkbookFactory.create(inp);
    HSSFSheet sheet=workbook.getSheetAt(0);
       CellStyle styleT = workbook.createCellStyle();
            HSSFFont font2 = workbook.createFont();
            font2.setBold(true);
            font2.setFontName("Montserrat");
            font2.setFontHeightInPoints((short)16.0); 
            styleT.setFont(font2);
            styleT.setBorderLeft(BorderStyle.THIN);
            styleT.setBorderRight(BorderStyle.THIN);
            styleT.setBorderTop(BorderStyle.THIN);
            styleT.setBorderBottom(BorderStyle.THIN);
            styleT.setAlignment(HorizontalAlignment.CENTER);
       
       sheet.addMergedRegion(new CellRangeAddress(12, 13, 0, 14));
       HSSFRow rowTit1 = sheet.createRow(12);
            HSSFCell cellTit1 = rowTit1.createCell(0);
            HSSFCell cellTit11 = rowTit1.createCell(1);
            HSSFCell cellTit12 = rowTit1.createCell(2);
            HSSFCell cellTit13 = rowTit1.createCell(3);
            HSSFCell cellTit14 = rowTit1.createCell(4);
            HSSFCell cellTit15 = rowTit1.createCell(5);
            HSSFCell cellTit16 = rowTit1.createCell(6);
            HSSFCell cellTit17 = rowTit1.createCell(7);
            HSSFCell cellTit18 = rowTit1.createCell(8);
            HSSFCell cellTit19 = rowTit1.createCell(9);
            HSSFCell cellTit20 = rowTit1.createCell(10);
            HSSFCell cellTit21 = rowTit1.createCell(11);
            HSSFCell cellTit22 = rowTit1.createCell(12);
            HSSFCell cellTit23 = rowTit1.createCell(13);
            HSSFCell cellTit24 = rowTit1.createCell(14);
            
            cellTit11.setCellStyle(styleT);
            cellTit20.setCellStyle(styleT);
            cellTit21.setCellStyle(styleT);
            cellTit12.setCellStyle(styleT);
            cellTit13.setCellStyle(styleT);
            cellTit14.setCellStyle(styleT);
            cellTit15.setCellStyle(styleT);
            cellTit16.setCellStyle(styleT);
            cellTit17.setCellStyle(styleT);
            cellTit18.setCellStyle(styleT);
            cellTit19.setCellStyle(styleT);
            cellTit22.setCellStyle(styleT);
            cellTit23.setCellStyle(styleT);
            cellTit24.setCellStyle(styleT);
            cellTit1.setCellStyle(styleT);
            int numClusters=clusters[0];
            //System.out.println("NumClusters= "+numClusters);
            switch (numClusters){
                    case 1:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Unidad Segmentada: "+uniSeg+", Pertenece al Cluster: "+clusters[1]);
                    break;
                    case 2:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Unidad Segmentada: "+uniSeg+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]);
                    break;
                    case 3:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Unidad Segmentada: "+uniSeg+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]);
                    break;
                    case 4:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Unidad Segmentada: "+uniSeg+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]);
                    break;
                    case 5:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Unidad Segmentada: "+uniSeg+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]);
                    break;
                    case 6:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Unidad Segmentada: "+uniSeg+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]);
                    break;
                    case 7:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Unidad Segmentada: "+uniSeg+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]);
                    break;
                    case 8:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Unidad Segmentada: "+uniSeg+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]+", "+clusters[8]);
                    break;
                    case 9:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Unidad Segmentada: "+uniSeg+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]+", "+clusters[8]+", "+clusters[9]);
                    break;
                    case 10:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Unidad Segmentada: "+uniSeg+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]+", "+clusters[8]+", "+clusters[9]+", "+clusters[10]);      
                    break;
            }
    
    try (FileOutputStream fileOut = new FileOutputStream(ruta+uniSeg+"PTCCO.xls")) {     
        workbook.write(fileOut);  
    } 

    }
    
    public void creaXLSECCO(String area,String uniAdmin, String tipoArchivo,int[] clusters) throws FileNotFoundException, IOException{  
    String ruta = System.getProperty("user.home") + "/Desktop/";//\\Desktop\\
    archivo.XLSECCO(area,tipoArchivo);
    FileInputStream inp = new FileInputStream(ruta+area+"ECCO.xls"); 
    HSSFWorkbook workbook = (HSSFWorkbook) WorkbookFactory.create(inp);
    HSSFSheet sheet=workbook.getSheetAt(0);
       CellStyle styleT = workbook.createCellStyle();
            HSSFFont font2 = workbook.createFont();
            font2.setBold(true);
            font2.setFontName("Montserrat");
            font2.setFontHeightInPoints((short)11); 
            styleT.setFont(font2);
            styleT.setBorderLeft(BorderStyle.THIN);
            styleT.setBorderRight(BorderStyle.THIN);
            styleT.setBorderTop(BorderStyle.THIN);
            styleT.setBorderBottom(BorderStyle.THIN);
            styleT.setAlignment(HorizontalAlignment.CENTER);
       
       sheet.addMergedRegion(new CellRangeAddress(12, 13, 0, 6));
       HSSFRow rowTit1 = sheet.createRow(12);
            HSSFCell cellTit1 = rowTit1.createCell(0);
            HSSFCell cellTit11 = rowTit1.createCell(1);
            HSSFCell cellTit12 = rowTit1.createCell(2);
            HSSFCell cellTit13 = rowTit1.createCell(3);
            HSSFCell cellTit14 = rowTit1.createCell(4);
            HSSFCell cellTit15 = rowTit1.createCell(5);
            HSSFCell cellTit16 = rowTit1.createCell(6);
            HSSFCell cellTit17 = rowTit1.createCell(7);
           
            
            cellTit11.setCellStyle(styleT);
            cellTit12.setCellStyle(styleT);
            cellTit13.setCellStyle(styleT);
            cellTit14.setCellStyle(styleT);
            cellTit15.setCellStyle(styleT);
            cellTit16.setCellStyle(styleT);
            cellTit17.setCellStyle(styleT);
            
            cellTit1.setCellStyle(styleT);
            int numClusters=clusters[0];
            //System.out.println("NumClusters= "+numClusters);
            switch (numClusters){
                    case 1:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Area: "+area+", Pertenece al Cluster: "+clusters[1]);
                    break;
                    case 2:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Area: "+area+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]);
                    break;
                    case 3:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Area: "+area+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]);
                    break;
                    case 4:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Area: "+area+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]);
                    break;
                    case 5:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Area: "+area+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]);
                    break;
                    case 6:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Area: "+area+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]);
                    break;
                    case 7:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Area: "+area+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]);
                    break;
                    case 8:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Area: "+area+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]+", "+clusters[8]);
                    break;
                    case 9:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Area: "+area+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]+", "+clusters[8]+", "+clusters[9]);
                    break;
                    case 10:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Area: "+area+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]+", "+clusters[8]+", "+clusters[9]+", "+clusters[10]);      
                    break;
            }
    
    try (FileOutputStream fileOut = new FileOutputStream(ruta+area+"ECCO.xls")) {     
        workbook.write(fileOut);  
    } 

    }
    
    public void creaXLSECCO2(String uniAdmin, String tipoArchivo,int[] clusters) throws FileNotFoundException, IOException{  
    String ruta = System.getProperty("user.home") + "/Desktop/";//\\Desktop\\
    archivo.XLSECCO2(tipoArchivo,uniAdmin);
    FileInputStream inp = new FileInputStream(ruta+uniAdmin+"ECCO.xls"); 
    HSSFWorkbook workbook = (HSSFWorkbook) WorkbookFactory.create(inp);
    HSSFSheet sheet=workbook.getSheetAt(0);
       CellStyle styleT = workbook.createCellStyle();
            HSSFFont font2 = workbook.createFont();
            font2.setBold(true);
            font2.setFontName("Montserrat");
            font2.setFontHeightInPoints((short)11); 
            styleT.setFont(font2);
            styleT.setBorderLeft(BorderStyle.THIN);
            styleT.setBorderRight(BorderStyle.THIN);
            styleT.setBorderTop(BorderStyle.THIN);
            styleT.setBorderBottom(BorderStyle.THIN);
            styleT.setAlignment(HorizontalAlignment.CENTER);
       
       sheet.addMergedRegion(new CellRangeAddress(12, 13, 0, 5));
       HSSFRow rowTit1 = sheet.createRow(12);
            HSSFCell cellTit1 = rowTit1.createCell(0);
            HSSFCell cellTit11 = rowTit1.createCell(1);
            HSSFCell cellTit12 = rowTit1.createCell(2);
            
            
            
            
            cellTit11.setCellStyle(styleT);
            cellTit12.setCellStyle(styleT);
            

            cellTit1.setCellStyle(styleT);
            int numClusters=clusters[0];
            //System.out.println("NumClusters= "+numClusters);
            switch (numClusters){
                    case 1:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Pertenece al Cluster: "+clusters[1]);
                    break;
                    case 2:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]);
                    break;
                    case 3:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]);
                    break;
                    case 4:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]);
                    break;
                    case 5:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]);
                    break;
                    case 6:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]);
                    break;
                    case 7:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]);
                    break;
                    case 8:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]+", "+clusters[8]);
                    break;
                    case 9:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]+", "+clusters[8]+", "+clusters[9]);
                    break;
                    case 10:cellTit1.setCellValue("La Unidad Administrativa: "+uniAdmin+", Pertenece a los Clusters: "+clusters[1]+", "+clusters[2]+", "+clusters[3]+", "+clusters[4]+", "+clusters[5]+", "+clusters[6]+", "+clusters[7]+", "+clusters[8]+", "+clusters[9]+", "+clusters[10]);      
                    break;
            }
    
    try (FileOutputStream fileOut = new FileOutputStream(ruta+uniAdmin+"ECCO.xls")) {     
        workbook.write(fileOut);  
    } 

    }
    
    
}
