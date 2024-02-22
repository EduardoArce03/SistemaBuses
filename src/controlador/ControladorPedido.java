/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

/**
 *
 * @author eduar
 */
public class ControladorPedido {
  
    private List<Pedido> listPedido;
    public ControladorPedido(){
        listPedido = new ArrayList();
    }
    public long generarId(){
        return listPedido.isEmpty()? 1: listPedido.get(listPedido.size()-1).getId()+1;
    }
    public boolean crear(Pedido pedido){
        return listPedido.add(pedido);
    }
    public Pedido buscar(long id){
        return listPedido.stream().filter(a -> a.getId() == id).findFirst().get();
    }
    public boolean eliminar(Pedido pedido){
        return listPedido.remove(pedido);
    }
    public boolean actualizar(Pedido pedido){
        return listPedido.set(listPedido.indexOf(buscar(pedido.getId())), pedido) != null;
    }
    public List<Pedido> getListPedido() {
        return listPedido;
    }
    public void setListPedido(List<Pedido> listPedido) {
        this.listPedido = listPedido;
    }
    
    
}
