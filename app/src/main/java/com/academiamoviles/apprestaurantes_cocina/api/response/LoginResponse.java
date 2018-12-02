package com.academiamoviles.apprestaurantes_cocina.api.response;

import com.google.gson.Gson;

public class LoginResponse {

    private String message;
    private DatosUsuarioResponse data;

    public String getMessage() {
        return message;
    }

    public DatosUsuarioResponse getData() {
        return data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
