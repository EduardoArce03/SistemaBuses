/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Bus;
import modelo.Conexion;
import modelo.Ruta;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduar
 */
public class ControladorRuta {
    Conexion conexion = Conexion.getInstance();
      
    private List<Ruta> listDestino;
    public ControladorRuta(){
        listDestino = new ArrayList();
    }
    
    public boolean crear(Ruta ruta){
        Connection c;
        
        try {
            c = conexion.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO rutas (ruta, valor) VALUES (?,?)");
            ps.setString(1, ruta.getRuta());
            ps.setDouble(2, ruta.getValor());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorRuta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public ResultSet listarAll(){
        Connection c;
        try {
            c = conexion.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM rutas");
            while (rs.next()) {                
               rs.getInt("id_ruta");
               rs.getString("ruta");
               rs.getDouble("valor");
               return rs;
               
            }
        } catch (Exception e) {
            
        }
        return null;
    }
   
}
