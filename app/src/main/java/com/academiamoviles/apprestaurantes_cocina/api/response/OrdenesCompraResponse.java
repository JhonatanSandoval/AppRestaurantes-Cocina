package com.academiamoviles.apprestaurantes_cocina.api.response;

import com.academiamoviles.apprestaurantes_cocina.model.OrdenModel;

import java.util.List;

public class OrdenesCompraResponse {

    private String message;
    private List<OrdenModel> data;

    public String getMessage() {
        return message;
    }

    public List<OrdenModel> getData() {
        return data;
    }
}
