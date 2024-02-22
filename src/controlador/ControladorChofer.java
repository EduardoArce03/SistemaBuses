/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Bus;
import modelo.Chofer;
import modelo.Cliente;

/**
 *
 * @author eduar
 */
public class ControladorChofer {
    private List<Chofer> listChofer;
    public ControladorChofer(){
        listChofer = new ArrayList();
    }
    public long generarId(){
        return listChofer.isEmpty()? 1: listChofer.get(listChofer.size()-1).getId()+1;
    }
    public boolean crear(Chofer chofere){
        return listChofer.add(chofere);
    }
    public Chofer chofercar(long id){
        return listChofer.stream().filter(a -> a.getId() == id).findFirst().get();
    }
    public boolean eliminar(Chofer chofere){
        return listChofer.remove(chofere);
    }
    public boolean actualizar(Chofer chofere){
        return listChofer.set(listChofer.indexOf(chofercar(chofere.getId())), chofere) != null;
    }
    
    public List<Chofer> getListChofer() {
        return listChofer;
    }
    
        public boolean guardarArchivos(String ruta){
        try {
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter buffer = new BufferedWriter(fw);
            
            //buffer.flush();
            for(Chofer chofer : listChofer){
                buffer.append(String.valueOf(chofer.getId()));
                buffer.append(chofer.getCedula());
                buffer.append(chofer.getDomicilio());
                buffer.append(chofer.getNombre());
                buffer.append(chofer.getTelefono());
                buffer.append(String.valueOf(chofer.getFechaNacimiento()));
                buffer.append((CharSequence) chofer.getBus());
                
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
    public void setListChofer(List<Chofer> listChofer) {
        this.listChofer = listChofer;
    }
    
}
