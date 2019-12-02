package com.example.e_tiket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_tiket.Adaptadores.AdapterResumenArticulo;
import com.example.e_tiket.Models.Producto;
import com.example.e_tiket.Models.ResumenArticulo;
import com.example.e_tiket.Models.Ticket;

import java.io.Serializable;
import java.util.ArrayList;

public class activity_ResumenArticulo extends AppCompatActivity {

    RecyclerView recyclerView_resumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__resumen_articulo);

        Intent intent = getIntent();
        Serializable resumenArticulo = intent.getSerializableExtra("resumenArticulo");
        Ticket ticket = (Ticket) resumenArticulo;


        recyclerView_resumen = (RecyclerView) findViewById(R.id.reciclerview_resumenArticulo);
        recyclerView_resumen.setLayoutManager(new LinearLayoutManager(activity_ResumenArticulo.this, RecyclerView.VERTICAL,false));

          //  resumenArticulos = new ArrayList<ResumenArticulo>();
        ArrayList<ResumenArticulo> resumenArticulos = (ArrayList<ResumenArticulo>) ((Ticket) resumenArticulo).getListProductosComprados();

        //Producto producto = new Producto(1,"papas",54.3);
        //ResumenArticulo res = new ResumenArticulo(producto,1,2);
        //resumenArticulos.add(res);

        AdapterResumenArticulo adapterResumenArticulo = new AdapterResumenArticulo(resumenArticulos);

        recyclerView_resumen.setAdapter(adapterResumenArticulo);







    }
}
