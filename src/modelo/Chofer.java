/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author eduar
 */
public class Chofer {
    private long id;
    private String cedula;
    private String nombre;
    private String domicilio;
    private String telefono;
    private LocalDate fechaNacimiento;
    private Bus bus;

    public Chofer(long id, String cedula, String nombre, String domicilio, String telefono, LocalDate fechaNacimiento, Bus bus) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.bus = bus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Chofer{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", domicilio=" + domicilio + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", bus=" + bus + '}';
    }
    
    
    
}
