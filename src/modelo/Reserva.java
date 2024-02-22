/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author eduar
 */
public class Reserva {
    private long id;
    private Cliente cliente;
    private Ruta ruta;
    private Bus bus;
    private double valor;

    public Reserva(long id, Cliente cliente, Ruta ruta, Bus bus, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.ruta = ruta;
        this.bus = bus;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", cliente=" + cliente + ", ruta=" + ruta + ", bus=" + bus + ", valor=" + valor + '}';
    }
    
    
    
}
