/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Bus;
import modelo.Chofer;

/**
 *
 * @author eduar
 */
public class ControladorBus {
    
        
    
    private List<Bus> listBus;
    public ControladorBus(){
        listBus = new ArrayList();
    }
    public long generarId(){
        return listBus.isEmpty()? 1: listBus.get(listBus.size()-1).getId()+1;
    }
    public boolean crear(Bus buse){
        return listBus.add(buse);
    }
    public Bus buscar(long id){
        return listBus.stream().filter(a -> a.getId() == id).findFirst().get();
    }
    public boolean eliminar(Bus buse){
        return listBus.remove(buse);
    }
    public boolean actualizar(Bus buse){
        return listBus.set(listBus.indexOf(buscar(buse.getId())), buse) != null;
    }
    public Bus buscarByPlaca(String placa){
        return listBus.stream().filter(c-> c.getPlaca().equals(placa)).findFirst().get();
    }
    public Bus buscarByAsiento(int capacidad){
        return listBus.stream().filter(c-> c.getCapacidad() == (capacidad)).findFirst().get();
    }
    
     public boolean guardarArchivos(String ruta){
        try {
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter buffer = new BufferedWriter(fw);
            
            //buffer.flush();
            for(Bus bus : listBus){
                buffer.append(String.valueOf(bus.getId()));
                buffer.append(bus.getMarca());
                buffer.append(bus.getModelo());
                buffer.append(bus.getPlaca());
                buffer.append(String.valueOf(bus.getAnio()));
                buffer.append(String.valueOf(bus.getCapacidad()));
                
                //fw.write(escavacionesArqueologicas.toString());
                //buffer.append(escavacionesArqueologicas.toString());
                
                System.out.println("Guardado");
            }
            buffer.close();
            //fw.flush();
            //fw.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
     }
    public List<Bus> getListBus() {
        return listBus;
    }
    public void setListBus(List<Bus> listBus) {
        this.listBus = listBus;
    }
    
}
