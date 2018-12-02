package com.academiamoviles.apprestaurantes_cocina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

import com.academiamoviles.apprestaurantes_cocina.api.ApiClient;
import com.academiamoviles.apprestaurantes_cocina.api.request.LoginRequest;
import com.academiamoviles.apprestaurantes_cocina.api.response.LoginResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    // edittexts
    @BindView(R.id.etUsuario) EditText etUsuario;
    @BindView(R.id.etContrasena) EditText etContrasena;

    // checkboxes
    @BindView(R.id.cbCocina) CheckBox cbCocina;
    @BindView(R.id.cbCounter) CheckBox cbCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnLogin)
    void login() {
        String usuario = etUsuario.getText().toString();
        String contrasena = etContrasena.getText().toString();
        boolean cocina = cbCocina.isChecked();
        boolean counter = cbCounter.isChecked();

        LoginRequest request = new LoginRequest();
        request.setUsuario(usuario);
        request.setContrasena(contrasena);
        request.setCocina(cocina);
        request.setCounter(counter);

        Log.i(TAG, "login request: " + request.toString());

        ApiClient.getApiService().login(request)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Log.i(TAG, "onResponse");
                        if (response.isSuccessful()) {
                            LoginResponse dataResponse = response.body();
                            Log.i(TAG, "dataResponse: " + dataResponse.toString());

                            abrirPantallaOrdenes();

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.e(TAG, "onFailure: :((");
                    }
                });

    }

    private void abrirPantallaOrdenes() {
        startActivity(new Intent(LoginActivity.this, OrdenesActivity.class));
        finish();
    }

}
