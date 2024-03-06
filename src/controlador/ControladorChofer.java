/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import modelo.Bus;
import modelo.Chofer;
import modelo.Cliente;
import modelo.Conexion;
import java.sql.Connection;
import java.util.Date;

/**
 *
 * @author eduar
 */
public class ControladorChofer {
    
    Conexion conexion = Conexion.getInstance();
    
    private List<Chofer> listChofer;
    
    public ControladorChofer(){
        listChofer = new ArrayList();
    }
    
    public boolean crear(Chofer chofer){
        try {
            Connection c = conexion.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO choferes (nombre, apellido, `grupoSanguineo`, cedula, telefono, domicilio, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, chofer.getNombre());
            ps.setString(2, chofer.getApellido());
            ps.setString(3, chofer.getGrupoSanguineo());
            ps.setString(4, chofer.getCedula());
            ps.setString(5, chofer.getTelefono());
            ps.setString(6, chofer.getDomicilio());
            java.util.Date fechaUtil = chofer.getFechaNacimiento(); // Obtén la fecha java.util.Date
            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime()); // Conviértela a java.sql.Date

// Ahora puedes establecer la fechaSQL en el PreparedStatement
            ps.setDate(7, fechaSQL);
            System.out.println("Agregado exitosamente");
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el chofer ");
            System.out.println(ex);
            return false;
        }
    }
    public Chofer chofercar(long id){
        return listChofer.stream().filter(a -> a.getId() == id).findFirst().get();
    }
    public boolean eliminar(int choferId){
        Connection c;
        try {
            c = conexion.getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM choferes WHERE chofer_id ="+choferId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean actualizar(int chofer_id, String nombre, String apellido, String grupoSanguineo, String cedula, String telefono, String domicilio, Date fechaNacimiento) {
    Connection c;
    try {
        c = conexion.getConnection();
        PreparedStatement ps = c.prepareStatement("UPDATE choferes SET nombre = ?, apellido = ?, grupoSanguineo = ?, cedula = ?, telefono = ?, domicilio = ?, fechaNacimiento = ? WHERE chofer_id = ?");
        
        // Establecer los valores de los parámetros
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, grupoSanguineo);
        ps.setString(4, cedula);
        ps.setString(5, telefono);
        ps.setString(6, domicilio);
        ps.setDate(7, new java.sql.Date(fechaNacimiento.getTime())); // Convertir Date a java.sql.Date
        ps.setInt(8, chofer_id);
        
        // Ejecutar la consulta
        ps.executeUpdate();
        
        return true;
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return false;
}

    
    public ResultSet llenarCampos(int chofer_id){
        Connection c;
        try {
            c = conexion.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM choferes WHERE chofer_id ="+chofer_id);
            while (rs.next()) {                
                int id = rs.getInt("chofer_id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String grupoSanguineo = rs.getString("grupoSanguineo");
                String cedula = rs.getString("cedula");
                String telefono = rs.getString("telefono");
                String domicilio = rs.getString("domicilio");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                System.out.println(nombre + apellido + grupoSanguineo + cedula + telefono + domicilio + fechaNacimiento);
                return rs; 
            }
            rs.close();
            s.close();
             
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
        
    }
    
    public ResultSet getListChofer() {
         Connection c;
        try {
            c = conexion.getConnection();
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM choferes");
            while (rs.next()) {                
                int id = rs.getInt("chofer_id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String grupoSanguineo = rs.getString("grupoSanguineo");
                String cedula = rs.getString("cedula");
                String telefono = rs.getString("telefono");
                String domicilio = rs.getString("domicilio");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                //System.out.println(nombre + apellido + grupoSanguineo + cedula + telefono + domicilio + fechaNacimiento);
                return rs;
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorChofer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR AL LISTAR CHOFERES " + ex.getMessage());
            
        }
        return null;
         
    }

    
    
    
     
}
