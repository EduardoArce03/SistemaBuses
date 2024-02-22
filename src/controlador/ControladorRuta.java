/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Bus;
import modelo.Ruta;

/**
 *
 * @author eduar
 */
public class ControladorRuta {
      
    private List<Ruta> listDestino;
    public ControladorRuta(){
        listDestino = new ArrayList();
    }
    public long generarId(){
        return listDestino.isEmpty()? 1: listDestino.get(listDestino.size()-1).getId()+1;
    }
    public boolean crear(Ruta destino){
        return listDestino.add(destino);
    }
    public Ruta buscar(long id){
        return listDestino.stream().filter(a -> a.getId() == id).findFirst().get();
    }
    public boolean eliminar(Ruta destino){
        return listDestino.remove(destino);
    }
    public boolean actualizar(Ruta destino){
        return listDestino.set(listDestino.indexOf(buscar(destino.getId())), destino) != null;
    }
    public Ruta buscarByRuta(String ruta){
        return listDestino.stream().filter(c-> c.getRuta().equals(ruta)).findFirst().get();
    }
    public Ruta buscarByValor(int valor){
        return listDestino.stream().filter(c-> c.getValor() == (valor)).findFirst().get();
    }
    public List<Ruta> getListDestino() {
        return listDestino;
    }
    public void setListDestino(List<Ruta> listDestino) {
        this.listDestino = listDestino;
    }
   
}
