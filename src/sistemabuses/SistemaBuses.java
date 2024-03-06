/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemabuses;

/**
 * 
 *
 * @author eduar
 */
import controlador.ControladorChofer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Chofer;
public class SistemaBuses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorChofer controladorChofer = new ControladorChofer();
        Chofer chofer = new Chofer();
        chofer.setNombre("Eduardo");
        controladorChofer.crear(chofer);
        
    }
    
}
