package com.academiamoviles.apprestaurantes_cocina.api;

import com.academiamoviles.apprestaurantes_cocina.api.request.LoginRequest;
import com.academiamoviles.apprestaurantes_cocina.api.response.LoginResponse;
import com.academiamoviles.apprestaurantes_cocina.api.response.OrdenesCompraResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("auth/usuarios-login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @GET("api/ordenes-de-compra")
    Call<OrdenesCompraResponse> obtenerOrdenesCompra();

}
