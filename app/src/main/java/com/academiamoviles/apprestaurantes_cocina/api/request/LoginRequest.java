package com.academiamoviles.apprestaurantes_cocina.api.request;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("email")
    private String usuario;

    @SerializedName("password")
    private String contrasena;

    private boolean cocina;
    private boolean counter;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isCocina() {
        return cocina;
    }

    public void setCocina(boolean cocina) {
        this.cocina = cocina;
    }

    public boolean isCounter() {
        return counter;
    }

    public void setCounter(boolean counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
