package com.academiamoviles.apprestaurantes_cocina.api.response;

import com.google.gson.Gson;

public class DatosUsuarioResponse {

    private String _id;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String imagen;
    private String email;
    private String token;

    public String get_id() {
        return _id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public String getImagen() {
        return imagen;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
