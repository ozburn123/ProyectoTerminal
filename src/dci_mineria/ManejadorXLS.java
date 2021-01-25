/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dci_mineria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author ozburn123
 */
public class ManejadorXLS {
    
    public void XLSPTCCO(String nombreArchivo,int tipoUnidad) throws FileNotFoundException, IOException{
     String ruta = System.getProperty("user.home") + "/Desktop/";//\\Desktop\\
        //String ruta = System.getProperty("user.home") + "\\Desktop\\";
  // URL url = Thread.currentThread().getContextClassLoader().getResource("template1.xls");
         //File file = new File("templates/PTCCO/TemplatePTCCOTipoUni"+tipoUnidad+".xls"); //url.getPath()
         File file = new File(ruta+"dist/lib/templates/PTCCO/TemplatePTCCOTipoUni"+tipoUnidad+".xls"); //url.getPath()
        System.out.println("RUTA"+ruta);
    try (FileOutputStream fileOutputStream = new FileOutputStream(ruta+nombreArchivo+"PTCCO.xls")) { 
        Files.copy(file.toPath(), fileOutputStream); 
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.write(fileOutputStream); 
    } 
    }
     public void XLSECCO(String area,String tipoTemplate) throws FileNotFoundException, IOException{
     String ruta = System.getProperty("user.home") + "/Desktop/";//\\Desktop\\
        //String ruta = System.getProperty("user.home") + "\\Desktop\\";
  // URL url = Thread.currentThread().getContextClassLoader().getResource("template1.xls");
     //File file = new File("templates/ECCO/TemplateECCO"+tipoTemplate+".xls"); //url.getPath()
     File file = new File(ruta+"dist/lib/templates/ECCO/TemplateECCO"+tipoTemplate+".xls"); //url.getPath()
        System.out.println("RUTA"+ruta);
    try (FileOutputStream fileOutputStream = new FileOutputStream(ruta+area+"ECCO.xls")) { 
        Files.copy(file.toPath(), fileOutputStream); 
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.write(fileOutputStream); 
    } 
    }
     public void XLSECCO2(String tipoTemplate,String ua) throws FileNotFoundException, IOException{
     String ruta = System.getProperty("user.home") + "/Desktop/";//\\Desktop\\
        //String ruta = System.getProperty("user.home") + "\\Desktop\\";
  // URL url = Thread.currentThread().getContextClassLoader().getResource("template1.xls");
     //File file = new File("templates/ECCO/TemplateECCO"+tipoTemplate+".xls"); //url.getPath()
     File file = new File(ruta+"dist/lib/templates/ECCO/TemplateECCO"+tipoTemplate+".xls"); //url.getPath()
        System.out.println("RUTA"+ruta);
    try (FileOutputStream fileOutputStream = new FileOutputStream(ruta+ua+"ECCO.xls")) { 
        Files.copy(file.toPath(), fileOutputStream); 
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.write(fileOutputStream); 
    } 
    }
    
}
