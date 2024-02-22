/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import java.sql.*;

/**
 *
 * @author eduar
 */
public class ControladorCliente {
    private List<Cliente> listCliente;
    public ControladorCliente(){
        listCliente = new ArrayList();
    }
    
    public long generarId(){
        return listCliente.isEmpty()? 1: listCliente.get(listCliente.size()-1).getId()+1;
    }
    
    public boolean crear(Cliente cliente){
        return listCliente.add(cliente);
    }
    
    public Cliente buscar(long id){
       return listCliente.stream().filter(c-> c.getId() == id).findFirst().get();
    }
    public boolean eliminar(Cliente registro){
        return listCliente.remove(registro);
    }
    public boolean actualizar(Cliente registro){
        return listCliente.set(listCliente.indexOf(buscar(registro.getId())), registro) != null;
    }
    
    public Cliente buscarByNombre(String nombre){
        return listCliente.stream().filter(c-> c.getNombre().equals(nombre)).findFirst().get();
    }
    public List<Cliente> getListCliente() {
        return listCliente;
    }

    public void setListCliente(List<Cliente> listCliente) {
        this.listCliente = listCliente;
    }
    
    
}
