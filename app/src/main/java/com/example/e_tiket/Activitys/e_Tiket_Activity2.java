package com.example.e_tiket.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_tiket.Adaptadores.AdapterDatos;

import com.example.e_tiket.R;
import com.example.e_tiket.conexion_red.ConexionCliente;
import com.example.e_tiket.conexion_red.PutList;

import java.util.ArrayList;

import models.ResumenArticulo;
import models.Ticket;

public class e_Tiket_Activity2 extends AppCompatActivity implements PutList {
    //se definen variables
    RecyclerView recyclerView_tikets;   //nos mostrara la informacion de los tickets
    ArrayList<Ticket> arrayList_listaTickets;     //el adaptador lo recibe de parametro para distribuir la informacion en cada textview
    ArrayList<ResumenArticulo> arrayList_resumenArticulo;       //el ticket recibe como parametro un arraylist de tipo resumenarticulo
    TextView txtTitulo;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e__tiket_2);
        this.setTitle(R.string.Activity_2);     //cambiamos el titulo
        //ConexionServidor conexionServidor = new ConexionServidor(e_Tiket_Activity2.this);
        this.txtTitulo = findViewById(R.id.titulo_activity2);

            String user_id = getIntent().getStringExtra("user_id");
            //manda el id al Servidor
            ConexionCliente conexionCliente = new ConexionCliente(user_id,this);
            //ServidorPrueba servidorPrueba = new ServidorPrueba(txtTitulo);

            recyclerView_tikets = (RecyclerView) findViewById(R.id.reciclerview);       // se enlaza el recycler view con el de el activity
            recyclerView_tikets.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));       // le mandamos un layout al recycler

            arrayList_listaTickets = new ArrayList<Ticket>();
            arrayList_resumenArticulo = new ArrayList<ResumenArticulo>();
/*
            Producto producto_1 = new Producto(1, "Error", 30.45);
            Producto producto_2 = new Producto(2,"Error 2",35.8);
            Producto producto_3 = new Producto(3,"Error 3",45.1);

            arrayList_resumenArticulo.add(new ResumenArticulo(producto_1, 1, 2));
            arrayList_resumenArticulo.add(new ResumenArticulo(producto_2,2,3));
            arrayList_resumenArticulo.add(new ResumenArticulo(producto_3,3,4));


            arrayList_listaTickets.add(new Ticket(1,1, "10/5/15", "01:51",30.85,arrayList_resumenArticulo));
            arrayList_listaTickets.add(new Ticket(2,1, "11/5/12", "01:51",50.85,arrayList_resumenArticulo));
            arrayList_listaTickets.add(new Ticket(3,1, "12/5/05", "01:51",980.85,arrayList_resumenArticulo));
            arrayList_listaTickets.add(new Ticket(4,1, "1/5/5", "01:51",310.85,arrayList_resumenArticulo));
            arrayList_listaTickets.add(new Ticket(5,1, "2/5/6", "01:51",302.85,arrayList_resumenArticulo));
*/

        }

    @Override
    protected void onResume() {
        super.onResume();
      //  ConexionServidor conexionServidor = new ConexionServidor(e_Tiket_Activity2.this);
    }

    @Override
    public void setAdapter(ArrayList<Ticket> lista) {

        final AdapterDatos adapter = new AdapterDatos(lista);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {

                           Intent intent = new Intent(e_Tiket_Activity2.this,  activity_ResumenArticulo.class);
                           Ticket t1 = arrayList_listaTickets.get(recyclerView_tikets.getChildAdapterPosition(v));
                           Toast.makeText(getApplicationContext(),t1.getIdTicket()+"",Toast.LENGTH_SHORT).show();

                           intent.putExtra("resumenArticulo",t1);
                           startActivity(intent);
                       }
                   }
                );

                recyclerView_tikets.setAdapter(adapter);
            }
        });

    }

}
