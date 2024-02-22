/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;

/**
 *
 * @author eduar
 */
public class ControladorReserva {
          
    private List<Reserva> listReserva;
    public ControladorReserva(){
        listReserva = new ArrayList();
    }
    public long generarId(){
        return listReserva.isEmpty()? 1: listReserva.get(listReserva.size()-1).getId()+1;
    }
    public boolean crear(Reserva reserva){
        return listReserva.add(reserva);
    }
    public Reserva buscar(long id){
        return listReserva.stream().filter(a -> a.getId() == id).findFirst().get();
    }
    public boolean eliminar(Reserva reserva){
        return listReserva.remove(reserva);
    }
    public boolean actualizar(Reserva reserva){
        return listReserva.set(listReserva.indexOf(buscar(reserva.getId())), reserva) != null;
    }
    public List<Reserva> getListReserva() {
        return listReserva;
    }
    public void setListReserva(List<Reserva> listReserva) {
        this.listReserva = listReserva;
    }
   
    
}
