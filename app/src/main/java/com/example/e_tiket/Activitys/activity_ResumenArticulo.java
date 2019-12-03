package com.example.e_tiket.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_tiket.Adaptadores.AdapterResumenArticulo;

import com.example.e_tiket.R;

import java.io.Serializable;
import java.util.ArrayList;

import models.ResumenArticulo;
import models.Ticket;

public class activity_ResumenArticulo extends AppCompatActivity {

    RecyclerView recyclerView_resumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__resumen_articulo);

        Intent intent = getIntent();
        Serializable resumenArticulo = intent.getSerializableExtra("ticket_seleccion");
        Ticket ticket = (Ticket) resumenArticulo;

        recyclerView_resumen = (RecyclerView) findViewById(R.id.reciclerview_resumenArticulo);
        recyclerView_resumen.setLayoutManager(new LinearLayoutManager(activity_ResumenArticulo.this, RecyclerView.VERTICAL,false));

        ArrayList<ResumenArticulo> resumenArticulos = ticket.getListProductosComprados();
        AdapterResumenArticulo adapterResumenArticulo = new AdapterResumenArticulo(resumenArticulos);

        recyclerView_resumen.setAdapter(adapterResumenArticulo);

    }
}
