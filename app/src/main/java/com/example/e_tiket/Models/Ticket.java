package com.example.e_tiket.Models;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;


public class Ticket implements Serializable {

    private int idTiket;
    private int idCliente;
    private String fecha;
    private String hora;
    private double totalTicket;
    ArrayList<ResumenArticulo> listProductosComprados;

    public Ticket(int idTiket, int idCliente, String fecha, String hora, double totalTicket, ArrayList<ResumenArticulo> listProductosComprados) {
        this.idTiket = idTiket;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.hora = hora;
        this.totalTicket = totalTicket;
        this.listProductosComprados = listProductosComprados;
    }

    public int getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(int idTiket) {
        this.idTiket = idTiket;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha.toString();
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora.toString();
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(double totalTicket) {
        this.totalTicket = totalTicket;
    }

    public ArrayList<ResumenArticulo> getListProductosComprados() {
        return listProductosComprados;
    }

    public void setListProductosComprados(ArrayList<ResumenArticulo> listProductosComprados) {
        this.listProductosComprados = listProductosComprados;
    }
}
