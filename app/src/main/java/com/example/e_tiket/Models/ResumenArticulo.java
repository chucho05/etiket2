package com.example.e_tiket.Models;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.io.Serializable;

public class ResumenArticulo implements Serializable {
    private Producto producto;
    private int idTicket;
    private int cantidadProductos;
    private double totalProducto;

    public ResumenArticulo(Producto producto, int idTicket, int cantidadProductos) {
        this.producto = producto;
        this.idTicket = idTicket;
        this.cantidadProductos = cantidadProductos;
        this.totalProducto = cantidadProductos * getPrecioIndividualProducto();
    }

    public int getCantidadProductos(){
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public double getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(double totalProducto) {
        this.totalProducto = totalProducto;
    }

    public Double getPrecioIndividualProducto() {
        return this.producto.getPrecioProducto();
    }

    public String getNombreProducto() {
        return this.producto.getNombreProducto();
    }

    public int getIdArticulo(){
        return this.producto.getIdProducto();
    }

    public int getIdTicket(){
        return idTicket;
    }

    public void setIdTicket(int idTicket){
        this.idTicket=idTicket;
    }

    public Producto getProducto(){
        return producto;
    }

    public void setProducto(Producto producto){
        this.producto = producto;
    }


}
