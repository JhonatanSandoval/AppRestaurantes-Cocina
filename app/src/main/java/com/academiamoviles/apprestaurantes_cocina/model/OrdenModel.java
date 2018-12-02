package com.academiamoviles.apprestaurantes_cocina.model;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

public class OrdenModel implements Serializable {

    private String fechaRegistro;
    private String _id;
    private double total;
    private ClienteModel cliente_id;
    private List<DetallePlatoModel> detalle;


    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ClienteModel getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(ClienteModel cliente_id) {
        this.cliente_id = cliente_id;
    }

    public List<DetallePlatoModel> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetallePlatoModel> detalle) {
        this.detalle = detalle;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
