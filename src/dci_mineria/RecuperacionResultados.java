/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dci_mineria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;
/**
 *
 * @author ozburn123
 */
public class RecuperacionResultados {
    
    
    //    public DefaultCategoryDataset
    public String [][] ResultadosGlobalesTabla(Connection cn) throws SQLException{
        String[][] valores = new String[15][10];
    PreparedStatement consulta=cn.prepareStatement("SELECT cluster,tipoUnidad,unidadAdmin,unidadSegmentada,numObjetivo,inicioPractica,terminacionPractica,precisionesTiempo,personalImpacta,tipoAccion,factorA1,evidenciaPresentar,reactivoA1,evidenciaPrimSeg,evidenciaSegunSeg FROM resultadosMineriaECCOPTCCO.AnalisisResultadosGlobalesPTCCO where tipoResultado=1;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 15; i++) {
                    valores[i][aux] = rs.getString(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
     public String [][] ResultadosFactorPorAreaTabla(Connection cn) throws SQLException{
        String[][] valores = new String[7][10];
    PreparedStatement consulta=cn.prepareStatement("SELECT CLUSTER,ID_UA,UA,ID_AREA,AREA,ID_FACTOR,CALIF_PREG FROM resultadosMineriaECCOPTCCO.AnalisisFactorPorAreaECCO where TIPO_RESULTADO=1;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    valores[i][aux] = rs.getString(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
     public String [][] ResultadosReactivoFactorPorAreaTabla(Connection cn) throws SQLException{
        String[][] valores = new String[8][10];
    PreparedStatement consulta=cn.prepareStatement("SELECT CLUSTER,ID_UA,UA,ID_AREA,AREA,ID_FACTOR,ID_REACTIVO,CALIF_PREG FROM resultadosMineriaECCOPTCCO.AnalisisReactivoFactorPorAreaECCO where TIPO_RESULTADO=1;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 8; i++) {
                    valores[i][aux] = rs.getString(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
     
     public String [][] ResultadosGlobalPorAreaTabla(Connection cn) throws SQLException{
        String[][] valores = new String[7][10];
    PreparedStatement consulta=cn.prepareStatement("SELECT CLUSTER,ID_UA,UA,ID_AREA,AREA,CALIF_PREG FROM resultadosMineriaECCOPTCCO.AnalisisGlobalPorAreaECCO where TIPO_RESULTADO=1;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    valores[i][aux] = rs.getString(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
     
      public String [][] ResultadosFactorPorUATabla(Connection cn) throws SQLException{
        String[][] valores = new String[5][10];
    PreparedStatement consulta=cn.prepareStatement("SELECT CLUSTER,ID_UA,UA,ID_FACTOR,CALIF_PREG FROM resultadosMineriaECCOPTCCO.AnalisisFactorPorUAECCO where TIPO_RESULTADO=1;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    valores[i][aux] = rs.getString(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
      
      public String [][] ResultadosReactivoFactorPorUATabla(Connection cn) throws SQLException{
        String[][] valores = new String[6][10];
    PreparedStatement consulta=cn.prepareStatement("SELECT CLUSTER,ID_UA,UA,ID_FACTOR,ID_REACTIVO,CALIF_PREG FROM resultadosMineriaECCOPTCCO.AnalisisReactivoFactorPorUAECCO where TIPO_RESULTADO=1;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    valores[i][aux] = rs.getString(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
     
    public int [][] ResultadosGlobalesGrafica(Connection cn) throws SQLException{
        int[][] valores = new int[15][10];
    //DefaultCategoryDataset a= new DefaultCategoryDataset();
    PreparedStatement consulta=cn.prepareStatement("SELECT tipoUnidad,unidadAdmin,unidadSegmentada,numObjetivo,inicioPractica,terminacionPractica,precisionesTiempo,personalImpacta,tipoAccion,factorA1,evidenciaPresentar,reactivoA1,evidenciaPrimSeg,evidenciaSegunSeg FROM resultadosMineriaECCOPTCCO.AnalisisResultadosGlobalesPTCCO where tipoResultado=2;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 14; i++) {
                    valores[i][aux] = rs.getInt(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
    public int [][] ResultadosFactorPorAreaGrafica(Connection cn) throws SQLException{
        int[][] valores = new int[7][10];
    //DefaultCategoryDataset a= new DefaultCategoryDataset();
    PreparedStatement consulta=cn.prepareStatement("SELECT ID_UA,UA,ID_AREA,AREA,ID_FACTOR,CALIF_PREG FROM resultadosMineriaECCOPTCCO.AnalisisFactorPorAreaECCO where TIPO_RESULTADO=2;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    valores[i][aux] = rs.getInt(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
     public int [][] ResultadosGlobalPorAreaGrafica(Connection cn) throws SQLException{
        int[][] valores = new int[7][10];
    //DefaultCategoryDataset a= new DefaultCategoryDataset();
    PreparedStatement consulta=cn.prepareStatement("SELECT ID_UA,UA,ID_AREA,AREA,CALIF_PREG FROM resultadosMineriaECCOPTCCO.AnalisisGlobalPorAreaECCO where TIPO_RESULTADO=2;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    valores[i][aux] = rs.getInt(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
     
     public int [][] ResultadosReactivoFactorPorAreaGrafica(Connection cn) throws SQLException{
        int[][] valores = new int[7][10];
    //DefaultCategoryDataset a= new DefaultCategoryDataset();
    PreparedStatement consulta=cn.prepareStatement("SELECT ID_UA,UA,ID_AREA,AREA,ID_FACTOR,ID_REACTIVO,CALIF_PREG FROM resultadosMineriaECCOPTCCO.AnalisisReactivoFactorPorAreaECCO where TIPO_RESULTADO=2;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    valores[i][aux] = rs.getInt(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
    
    
     public int [][] ResultadosFactorPorUAGrafica(Connection cn) throws SQLException{
        int[][] valores = new int[7][10];
    //DefaultCategoryDataset a= new DefaultCategoryDataset();
    PreparedStatement consulta=cn.prepareStatement("SELECT ID_UA,UA,ID_FACTOR,CALIF_PREG FROM resultadosMineriaECCOPTCCO.AnalisisFactorPorUAECCO where TIPO_RESULTADO=2;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    valores[i][aux] = rs.getInt(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    } 
      public int [][] ResultadosReactivoFactorPorUAGrafica(Connection cn) throws SQLException{
        int[][] valores = new int[7][10];
    //DefaultCategoryDataset a= new DefaultCategoryDataset();
    PreparedStatement consulta=cn.prepareStatement("SELECT ID_UA,UA,ID_FACTOR,ID_REACTIVO,CALIF_PREG FROM resultadosMineriaECCOPTCCO.AnalisisReactivoFactorPorUAECCO where TIPO_RESULTADO=2;");///FALTA CREAR EN LA BD
    ResultSet rs = consulta.executeQuery();
            int aux = 0;
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    valores[i][aux] = rs.getInt(i + 1);
                    //System.out.println(valores[i][aux]);
                }

                aux++;
            }
           // System.out.println("VALORES= " + valores[0][0]);
    //cn.close();
    return valores;
    }
   
    
    public String [] ValoresUAECCO(Connection cn) throws SQLException{
    String [] valores = new String [100];
        PreparedStatement consulta=cn.prepareStatement("Select Unidad_Administrativa From UnidadAdministrativaECCO");
 ResultSet rs = consulta.executeQuery();
 int i=0;
    while(rs.next()){
   valores[i]=rs.getString(1);
   i++;
    }
        return valores;
    }
    
    
    public String [] ValoresUAPTCCO(Connection cn) throws SQLException{
    String [] valores = new String [2000];
        PreparedStatement consulta=cn.prepareStatement("Select UnidadAdministrativaPTCCO From UnidadAdministrativaPTCCO");
 ResultSet rs = consulta.executeQuery();
 int i=0;
    while(rs.next()){
   valores[i]=rs.getString(1);
   i++;
    }
        return valores;
    }
    
    public String [] ValoresUSPTCCO(Connection cn,String unidadAdmin) throws SQLException{
    String [] valores = new String [2000];
        PreparedStatement consulta=cn.prepareStatement("Select distinct US.UnidadSegmentadaPTCCO from UnidadSegmentadaPTCCO as US join (Select distinct RSG.UnidadSegmentada from UnidadAdministrativaPTCCO as UA join \n" +
"UnidadSegmentadaPTCCO as US on US.idUnidadSegmentadaPTCCO=UA.idUnidadAdministrativaPTCCO join\n" +
"ResultadosGlobalesPTCCO as RSG on UA.idUnidadAdministrativaPTCCO=RSG.UnidadAdministrativa  where UA.UnidadAdministrativaPTCCO=?) as RES on RES.UnidadSegmentada=US.idUnidadSegmentadaPTCCO;");
        consulta.setString(1, unidadAdmin);
 ResultSet rs = consulta.executeQuery();
 int i=0;
    while(rs.next()){
   valores[i]=rs.getString(1);
   i++;
    }
        return valores;
    }
    
    public String [] ValoresAreaECCO(Connection cn,String unidadAdmin) throws SQLException{
    String [] valores = new String [2000];
        PreparedStatement consulta=cn.prepareStatement("Select distinct AE.AreaECCO from AreaECCO as AE join (Select distinct GPA.Area from GlobalPorAreaECCO as GPA join\n" +
"UnidadAdministrativaECCO as UAE on UAE.idUnidad_Administrativa=GPA.UA join\n" +
"AreaECCO as AE1 on AE1.idAreaECCO=GPA.Area where UAE.Unidad_Administrativa=?) as RES on RES.Area=AE.idAreaECCO;");
        consulta.setString(1, unidadAdmin);
 ResultSet rs = consulta.executeQuery();
 int i=0;
    while(rs.next()){
   valores[i]=rs.getString(1);
   i++;
    }
        return valores;
    }
    
    public int CuentaValoresUSPTCCO(Connection cn,String unidadAdmin) throws SQLException{
    //String [] valores = new String [2000];
    int cuenta=0;
        PreparedStatement consulta=cn.prepareStatement("Select count(*) from UnidadSegmentadaPTCCO as US join (Select distinct RSG.UnidadSegmentada from UnidadAdministrativaPTCCO as UA join \n" +
"UnidadSegmentadaPTCCO as US on US.idUnidadSegmentadaPTCCO=UA.idUnidadAdministrativaPTCCO join\n" +
"ResultadosGlobalesPTCCO as RSG on UA.idUnidadAdministrativaPTCCO=RSG.UnidadAdministrativa  where UA.UnidadAdministrativaPTCCO=?) as RES on RES.UnidadSegmentada=US.idUnidadSegmentadaPTCCO;");
         consulta.setString(1, unidadAdmin);
 ResultSet rs = consulta.executeQuery();
 //int i=0;
    rs.next();
   cuenta=rs.getInt(1);
        return cuenta;
    }
    
    public int CuentaValoresAreaECCO(Connection cn,String unidadAdmin) throws SQLException{
    //String [] valores = new String [2000];
    int cuenta=0;
        PreparedStatement consulta=cn.prepareStatement("Select count(*) from AreaECCO as AE join (Select distinct GPA.Area from GlobalPorAreaECCO as GPA join\n" +
"UnidadAdministrativaECCO as UAE on UAE.idUnidad_Administrativa=GPA.UA join\n" +
"AreaECCO as AE1 on AE1.idAreaECCO=GPA.Area where UAE.Unidad_Administrativa=?) as RES on RES.Area=AE.idAreaECCO;");
         consulta.setString(1, unidadAdmin);
 ResultSet rs = consulta.executeQuery();
 //int i=0;
    rs.next();
   cuenta=rs.getInt(1);
        return cuenta;
    }
    
    public int idUAdminPTCCO(Connection cn,String unidadAdmin) throws SQLException{
    int valores=0;
        PreparedStatement consulta= cn.prepareStatement("Select idUnidadAdministrativaPTCCO from UnidadAdministrativaPTCCO where UnidadAdministrativaPTCCO=?");
 consulta.setString(1, unidadAdmin);
        ResultSet rs = consulta.executeQuery();
    rs.next();
   valores=rs.getInt(1);
        return valores;
    }
    
     public int idUAdminECCO(Connection cn,String unidadAdmin) throws SQLException{
    int valores=0;
        PreparedStatement consulta= cn.prepareStatement("Select idUnidad_Administrativa from UnidadAdministrativaECCO where Unidad_Administrativa=?");
 consulta.setString(1, unidadAdmin);
        ResultSet rs = consulta.executeQuery();
    rs.next();
   valores=rs.getInt(1);
        return valores;
    }
    
    
    
    public int idUSegPTCCO(Connection cn,String uniSeg) throws SQLException{
    int valores = 0;
        PreparedStatement consulta= cn.prepareStatement("Select idUnidadSegmentadaPTCCO from UnidadSegmentadaPTCCO  where UnidadSegmentadaPTCCO=?");
 consulta.setString(1, uniSeg);
        ResultSet rs = consulta.executeQuery();
    rs.next();
   valores=rs.getInt(1);
        return valores;
    }
    
    public int idAreaECCO(Connection cn,String area) throws SQLException{
    int valores = 0;
        PreparedStatement consulta= cn.prepareStatement("Select idAreaECCO from AreaECCO  where AreaECCO=?");
 consulta.setString(1, area);
        ResultSet rs = consulta.executeQuery();
    rs.next();
   valores=rs.getInt(1);
        return valores;
    }
    
     public int tipoUnidadPTCCO(Connection cn,int idUnidadAdmin,int idUnidadSeg) throws SQLException{
        int valores=0;
         System.out.println("ID's= "+idUnidadAdmin+idUnidadSeg);
        PreparedStatement consulta=cn.prepareStatement("Select TipoUnidad from ResultadosGlobalesPTCCO where UnidadSegmentada= ? and UnidadAdministrativa= ?");
        consulta.setInt(1, idUnidadSeg);
        consulta.setInt(2, idUnidadAdmin);
 ResultSet rs = consulta.executeQuery();
   rs.next();
   valores=rs.getInt(1);
   return valores;  
    }
    
   public int [] clustersPTCCO(int idUniAdmin,int idUniSeg,int tipoUnidad,Connection cn) throws SQLException{
    int [] valores = new int [11];
    
    if(tipoUnidad==1){
        System.out.println("Pertenece a 1");
        PreparedStatement consulta=cn.prepareStatement("Select distinct Cluster From ResultadosTipoUnidad1PTCCO where UnidadAdministrativa=? and UnidadSegmentada=?");
        consulta.setInt(1, idUniAdmin);
        consulta.setInt(2, idUniSeg);
 ResultSet rs = consulta.executeQuery();
 int i=1;
    while(rs.next()){
   valores[i]=rs.getInt(1);
   i++;
    } valores[0]=i-1;
    } else if (tipoUnidad==2){
        System.out.println("Pertenece a 2");
     PreparedStatement consulta=cn.prepareStatement("Select distinct Cluster From ResultadosTipoUnidad2PTCCO where UnidadAdministrativa=? and UnidadSegmentada=?");
     consulta.setInt(1, idUniAdmin);
     consulta.setInt(2, idUniSeg);
 ResultSet rs = consulta.executeQuery();
 int i=1;
    while(rs.next()){
   valores[i]=rs.getInt(1);
   i++;
    }valores[0]=i-1;
    } else if(tipoUnidad==3){
        System.out.println("Pertenece a 3");
     PreparedStatement consulta=cn.prepareStatement("Select distinct Cluster From ResultadosTipoUnidad3PTCCO where UnidadAdministrativa=? and UnidadSegmentada=?");
     consulta.setInt(1, idUniAdmin);
     consulta.setInt(2, idUniSeg);
 ResultSet rs = consulta.executeQuery();
 int i=1;
    while(rs.next()){
   valores[i]=rs.getInt(1);
   i++;
    }valores[0]=i-1;
    }
    
    for(int i=0;i<10;i++)
           System.out.println("Clusters= "+valores[i]);
    
        return valores;
    }
   
   
    public int [] clustersFactorPorAreaECCO(int idUA,int idArea,Connection cn) throws SQLException{
    int [] valores = new int [11];   
        System.out.println("UA y Area= "+idUA);
        System.out.println("UA y Area= "+idArea);
        PreparedStatement consulta=cn.prepareStatement("Select distinct Cluster From FactorPorAreaECCO where UA=? and Area=?");
        consulta.setInt(1, idUA);
        consulta.setInt(2, idArea);
 ResultSet rs = consulta.executeQuery();
 int i=1;
    while(rs.next()){
   valores[i]=rs.getInt(1);
   i++;
    } valores[0]=i-1;
    
    return valores;
}
    
    public int [] clustersGlobalPorAreaECCO(int idUA,int idArea,Connection cn) throws SQLException{
    int [] valores = new int [11];   
        System.out.println("UA y Area= "+idUA);
        System.out.println("UA y Area= "+idArea);
        PreparedStatement consulta=cn.prepareStatement("Select distinct Cluster From GlobalPorAreaECCO where UA=? and Area=?");
        consulta.setInt(1, idUA);
        consulta.setInt(2, idArea);
 ResultSet rs = consulta.executeQuery();
 int i=1;
    while(rs.next()){
   valores[i]=rs.getInt(1);
   i++;
    } valores[0]=i-1;
    
    return valores;
}
    
    public int [] clustersReactivoFactorPorAreaECCO(int idUA,int idArea,Connection cn) throws SQLException{
    int [] valores = new int [11];   
        System.out.println("UA y Area= "+idUA);
        System.out.println("UA y Area= "+idArea);
        PreparedStatement consulta=cn.prepareStatement("Select distinct Cluster From ReactivoFactorPorAreaECCO where UA=? and Area=?");
        consulta.setInt(1, idUA);
        consulta.setInt(2, idArea);
 ResultSet rs = consulta.executeQuery();
 int i=1;
    while(rs.next()){
   valores[i]=rs.getInt(1);
   i++;
    } valores[0]=i-1;
    
    return valores;
}
    
    
    public int [] clustersFactorPorUAECCO(int idUA,Connection cn) throws SQLException{
    int [] valores = new int [11];   
        System.out.println("UA y Area= "+idUA);
        //System.out.println("UA y Area= "+idArea);
        PreparedStatement consulta=cn.prepareStatement("Select distinct Cluster From FactorPorUAECCO where UA=?");
        consulta.setInt(1, idUA);
        //consulta.setInt(2, idArea);
 ResultSet rs = consulta.executeQuery();
 int i=1;
    while(rs.next()){
   valores[i]=rs.getInt(1);
   i++;
    } valores[0]=i-1;
    
    return valores;
}
    public int [] clustersReactivoFactorPorUAECCO(int idUA,Connection cn) throws SQLException{
    int [] valores = new int [11];   
        System.out.println("UA y Area= "+idUA);
        //System.out.println("UA y Area= "+idArea);
        PreparedStatement consulta=cn.prepareStatement("Select distinct Cluster From ReactivoFactorPorUAECCO where UA=?");
        consulta.setInt(1, idUA);
        //consulta.setInt(2, idArea);
 ResultSet rs = consulta.executeQuery();
 int i=1;
    while(rs.next()){
   valores[i]=rs.getInt(1);
   i++;
    } valores[0]=i-1;
    
    return valores;
}
    
   
    
}
