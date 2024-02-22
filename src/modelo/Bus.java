/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author eduar
 */
public class Bus {
    private long id;
    private String placa;
    private String marca;
    private int anio;
    private int capacidad;
    private String modelo;

    public Bus(long id, String placa, String marca, int anio, int capacidad, String modelo) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.anio = anio;
        this.capacidad = capacidad;
        this.modelo = modelo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Bus{" + "id=" + id + ", placa=" + placa + ", marca=" + marca + ", anio=" + anio + ", capacidad=" + capacidad + ", modelo=" + modelo + '}';
    }
    
    
    


}
