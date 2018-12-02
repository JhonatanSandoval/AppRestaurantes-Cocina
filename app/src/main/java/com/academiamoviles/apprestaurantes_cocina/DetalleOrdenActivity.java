package com.academiamoviles.apprestaurantes_cocina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.academiamoviles.apprestaurantes_cocina.model.OrdenModel;

public class DetalleOrdenActivity extends AppCompatActivity {

    private static final String TAG = "DetalleOrdenActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_orden);

        obtenerDetalleOrden();

    }

    private void obtenerDetalleOrden() {
        Intent iRecibido = getIntent();
        OrdenModel orden = (OrdenModel) iRecibido.getSerializableExtra("orden");
        Log.i(TAG, "obtenerDetalleOrden: " + orden.toString());
    }
}
