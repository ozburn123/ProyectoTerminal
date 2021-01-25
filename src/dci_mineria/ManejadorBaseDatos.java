/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dci_mineria;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;

/**
 *
 * @author ozburn123
 */
public class ManejadorBaseDatos {
    
      
    Connection conecta=null;
    public Connection conex() {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            String servidor="jdbc:mysql://localhost:3306/resultadosMineriaECCOPTCCO"; //conectamos a nuestra propia maquina
            String usuario="root";
            String password="2153000074";
            //inicializamos objeto conecta, del tipo connection           
            conecta = DriverManager.getConnection(servidor, usuario, password);

        }catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e) //capturar el resto de exceptions
        {
            System.out.println(e.getMessage());
        }finally{
            return conecta;//como el default de los case, pero se ejecuta si o si
        }

    }
    }

