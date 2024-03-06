/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author eduar
 */
public class Pedido {
    private long id;
    private LocalDate fecha;
    private LocalTime hora;
    private Ruta ruta;
    private Cliente cliente;
    private double valor;
    private boolean[][] asiento;
    private Bus bus;

    public Pedido(long id, LocalDate fecha, LocalTime hora, Ruta ruta, Cliente cliente, double valor) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.ruta = ruta;
        this.cliente = cliente;
        this.valor = valor;
        this.asiento = new boolean[4][15];
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

  
    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", ruta=" + ruta + ", cliente=" + cliente + ", valor=" + valor + ", asiento=" + asiento + '}';
    }
    
    

 
}
