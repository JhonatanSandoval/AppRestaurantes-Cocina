package com.academiamoviles.apprestaurantes_cocina.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.academiamoviles.apprestaurantes_cocina.R;
import com.academiamoviles.apprestaurantes_cocina.model.OrdenModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrdenesAdapter extends RecyclerView.Adapter<OrdenesAdapter.OrdenHolder> {

    private List<OrdenModel> ordenes = new ArrayList<>();
    private OrdenClickListener ordenClickListener;

    public void setOrdenClickListener(OrdenClickListener ordenClickListener) {
        this.ordenClickListener = ordenClickListener;
    }

    public void setOrdenes(List<OrdenModel> ordenes) {
        this.ordenes = ordenes;
        notifyDataSetChanged();
    }

    @Override
    public OrdenHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.celda_orden_compra, parent, false);
        return new OrdenHolder(view);
    }

    @Override
    public void onBindViewHolder(OrdenHolder holder, int position) {
        final OrdenModel objOrden = ordenes.get(position);

        holder.tvCliente.setText( objOrden.getCliente_id().getNombres() );
        holder.tvMesa.setText("2");
        holder.tvTiempo.setText(objOrden.getFechaRegistro());

        holder.llOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ordenClickListener.seleccionarOrden(objOrden);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ordenes.size();
    }

    public interface OrdenClickListener {
        void seleccionarOrden(OrdenModel orden);
    }

    class OrdenHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.llOrden) LinearLayout llOrden;
        @BindView(R.id.tvCliente) TextView tvCliente;
        @BindView(R.id.tvMesa) TextView tvMesa;
        @BindView(R.id.tvTiempo) TextView tvTiempo;

        public OrdenHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
