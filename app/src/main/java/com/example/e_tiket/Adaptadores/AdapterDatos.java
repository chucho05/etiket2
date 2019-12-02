package com.example.e_tiket.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.e_tiket.Models.Ticket;
import com.example.e_tiket.R;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> implements View.OnClickListener {

    ArrayList<Ticket> arrayList_datos;
    private View.OnClickListener listener;

    public AdapterDatos(ArrayList<Ticket> arrayList_datos) {
        this.arrayList_datos = arrayList_datos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,null,false);

        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        Ticket ticket = arrayList_datos.get(position);
        //holder.asignarDatos(ticket);

        holder.noTicket.setText(String.valueOf(ticket.getIdTiket()));
        holder.idCliente.setText(String.valueOf(ticket.getIdCliente()));
        holder.fecha.setText(ticket.getFecha());
        holder.hora.setText(ticket.getHora());
        holder.total.setText(String.valueOf(ticket.getTotalTicket()));

    }

    @Override
    public int getItemCount() {

        return arrayList_datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }

    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView noTicket;
        TextView idCliente;
        TextView fecha;
        TextView hora;
        TextView total;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            noTicket = (TextView) itemView.findViewById(R.id.textView_noTiket);
            idCliente = (TextView) itemView.findViewById(R.id.textView_idCliente);
            fecha = (TextView) itemView.findViewById(R.id.textView_fecha);
            hora = (TextView) itemView.findViewById(R.id.textView_hora);
            total = (TextView) itemView.findViewById(R.id.textView_total);
        }


    }

}
