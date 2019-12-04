package com.example.e_tiket.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_tiket.R;

import java.util.ArrayList;

import models.ResumenArticulo;

public class AdapterResumenArticulo extends RecyclerView.Adapter<AdapterResumenArticulo.ViewHolderDatos> {

    ArrayList<ResumenArticulo>  arrayList_resumenArticulo;

    public AdapterResumenArticulo(ArrayList<ResumenArticulo> arrayList_resumenArticulo) {
        this.arrayList_resumenArticulo = arrayList_resumenArticulo;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resumen,parent,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterResumenArticulo.ViewHolderDatos holder, int position) {
        ResumenArticulo resumenArticulo = arrayList_resumenArticulo.get(position);

        holder.textView_idArticulo.setText(String.valueOf(resumenArticulo.getIDArticulo()));
        holder.textView_nombre.setText(resumenArticulo.getNombreProducto());
        holder.textView_cantidad.setText(String.valueOf(resumenArticulo.getCantidad()));
        holder.textView_$individual.setText(String.valueOf(resumenArticulo.getPrecioIndividualProducto()));
        holder.textView_total.setText(String.valueOf(resumenArticulo.getTotalProducto()));
    }

    @Override
    public int getItemCount() {
        return arrayList_resumenArticulo.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView textView_idArticulo;
        TextView textView_nombre;
        TextView textView_cantidad;
        TextView textView_$individual;
        TextView textView_total;




        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            textView_idArticulo = (TextView) itemView.findViewById(R.id.id_articulo);
            textView_nombre = (TextView) itemView.findViewById(R.id.nombre_articulo);
            textView_cantidad = (TextView) itemView.findViewById(R.id.cantidad);
            textView_$individual = (TextView) itemView.findViewById(R.id.precion_individual);
            textView_total = (TextView) itemView.findViewById(R.id.total);


        }
    }
}
