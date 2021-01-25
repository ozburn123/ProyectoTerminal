/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dci_mineria;

//import dci_mineria.vistas.MuestraMineria;
import dci_mineria.controlador.ControladorResultados;
import dci_mineria.vistas.MuestraResultados;
//import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author ozburn123
 */
public class MineriaIMSS {
    
    public static void main(String[] args) throws InterruptedException, SQLException {
          
        MuestraResultados vista = new MuestraResultados();
        ControladorResultados controller= new ControladorResultados(vista);
        controller.iniciar();
        vista.setVisible(true);
    }
    
}
