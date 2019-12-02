package com.example.e_tiket.Models;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.io.Serializable;

public class Producto implements Serializable {
    private int idProducto;
    private String nombreProducto;
    private Double precioProducto;

    public Producto(int idProducto, String nombreProducto, Double precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }
}
