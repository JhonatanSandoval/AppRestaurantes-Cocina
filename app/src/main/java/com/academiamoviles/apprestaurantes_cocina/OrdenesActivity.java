package com.academiamoviles.apprestaurantes_cocina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.academiamoviles.apprestaurantes_cocina.adapter.OrdenesAdapter;
import com.academiamoviles.apprestaurantes_cocina.api.ApiClient;
import com.academiamoviles.apprestaurantes_cocina.api.response.OrdenesCompraResponse;
import com.academiamoviles.apprestaurantes_cocina.model.OrdenModel;
import com.academiamoviles.apprestaurantes_cocina.util.Constantes;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdenesActivity extends AppCompatActivity implements OrdenesAdapter.OrdenClickListener {

    private static final String TAG = "OrdenesActivity";

    // textviews
    @BindView(R.id.tvTitulo1) TextView tvTitulo1;
    @BindView(R.id.tvTitulo2) TextView tvTitulo2;
    private Socket socket;

    @BindView(R.id.rvOrdenes) RecyclerView rvOrdenes;
    private OrdenesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenes);
        ButterKnife.bind(this);

        configurarSocket();

        configurarRecyclerView();
        obtenerOrdenesCompra();
    }

    private void obtenerOrdenesCompra() {
        ApiClient.getApiService().obtenerOrdenesCompra()
                .enqueue(new Callback<OrdenesCompraResponse>() {
                    @Override
                    public void onResponse(Call<OrdenesCompraResponse> call, Response<OrdenesCompraResponse> response) {
                        if (response.isSuccessful()) {
                            OrdenesCompraResponse dataResponse = response.body();
                            if (dataResponse != null && dataResponse.getData() != null) {
                                adapter.setOrdenes(dataResponse.getData());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<OrdenesCompraResponse> call, Throwable t) {

                    }
                });
    }

    private void configurarRecyclerView() {
        rvOrdenes.setLayoutManager(new LinearLayoutManager(OrdenesActivity.this));

        adapter = new OrdenesAdapter();
        adapter.setOrdenClickListener(this);

        rvOrdenes.setAdapter(adapter);
    }

    private void configurarSocket() {
        conectarSocket();
        configurarEventos();
        socket.connect();
    }

    private void configurarEventos() {
        socket.on("configuracion_titulos", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject json = (JSONObject) args[0];
                try {
                    final String titulo_1 = json.getString("titulo_1");
                    final String titulo_2 = json.getString("titulo_2");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvTitulo1.setText(titulo_1);
                            tvTitulo2.setText(titulo_2);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void conectarSocket() {
        try {
            socket = IO.socket(Constantes.BASE_URL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void seleccionarOrden(OrdenModel orden) {
        Log.i(TAG, "orden seleccionada: " + orden.toString());

        Intent iDetalleOrden = new Intent(OrdenesActivity.this, DetalleOrdenActivity.class);
        iDetalleOrden.putExtra("orden", orden);
        startActivity(iDetalleOrden);

    }
}
