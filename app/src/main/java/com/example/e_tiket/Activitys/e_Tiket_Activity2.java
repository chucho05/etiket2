package com.example.e_tiket.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_tiket.Adaptadores.AdapterDatos;
import com.example.e_tiket.Models.Producto;
import com.example.e_tiket.Models.ResumenArticulo;
import com.example.e_tiket.Models.Ticket;
import com.example.e_tiket.R;

import java.util.ArrayList;

public class e_Tiket_Activity2 extends AppCompatActivity {
    //se definen variables
    RecyclerView recyclerView_tikets;   //nos mostrara la informacion de los tickets
    ArrayList<Ticket> arrayList_listaDatos;     //el adaptador lo recibe de parametro para distribuir la informacion en cada textview
    ArrayList<ResumenArticulo> arrayList_resumenArticulo;       //el ticket recibe como parametro un arraylist de tipo resumenarticulo

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e__tiket_2);
        this.setTitle(R.string.Activity_2);     //cambiamos el titulo

        recyclerView_tikets = (RecyclerView) findViewById(R.id.reciclerview);       // se enlaza el recycler view con el de el activity
        recyclerView_tikets.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));       // le mandamos un layout al recycler

        //inicializamos los array list
        arrayList_listaDatos = new ArrayList<Ticket>();
        arrayList_resumenArticulo = new ArrayList<ResumenArticulo>();

        //creamos objetos para darles valores
            Producto producto_1 = new Producto(1, "quesadilla", 30.45);
            Producto producto_2 = new Producto(2,"amburguesa",35.8);
            Producto producto_3 = new Producto(3,"quesadilla cc",45.1);

            //se le asigna un objeto de tipo resumenarticulo a nuestro arraylist
            arrayList_resumenArticulo.add(new ResumenArticulo(producto_1, 1, 2));
            arrayList_resumenArticulo.add(new ResumenArticulo(producto_2,2,3));
            arrayList_resumenArticulo.add(new ResumenArticulo(producto_3,3,4));

            //se crea objeto de ticket
            // se asigna un objeto de tipo ticket a nuestro arraylist
            arrayList_listaDatos.add(new Ticket(1,1, "10/5/15", "01:51",30.85,arrayList_resumenArticulo));
            arrayList_listaDatos.add(new Ticket(2,1, "11/5/12", "01:51",50.85,arrayList_resumenArticulo));
            arrayList_listaDatos.add(new Ticket(3,1, "12/5/05", "01:51",980.85,arrayList_resumenArticulo));
            arrayList_listaDatos.add(new Ticket(4,1, "1/5/5", "01:51",310.85,arrayList_resumenArticulo));
            arrayList_listaDatos.add(new Ticket(5,1, "2/5/6", "01:51",302.85,arrayList_resumenArticulo));

            //creamos un nuevo item con los valores del ticket
            AdapterDatos adapter = new AdapterDatos(arrayList_listaDatos);
            //final Ticket ticket = null;
                    adapter.setOnClickListener(new View.OnClickListener() {
                     @Override
                        public void onClick(View v) {
                           //ArrayList<ResumenArticulo> resumenArticulos;
                           // resumenArticulos = new ArrayList<ResumenArticulo>(arrayList_listaDatos.get(recyclerView_tikets.getChildAdapterPosition(v)).getListProductosComprados());

                           Intent intent = new Intent(e_Tiket_Activity2.this,  activity_ResumenArticulo.class);
                            Ticket t1 = arrayList_listaDatos.get(recyclerView_tikets.getChildAdapterPosition(v));
                             Toast.makeText(getApplicationContext(),t1.getIdTiket()+"",Toast.LENGTH_SHORT).show();

                          intent.putExtra("resumenArticulo",t1);
                          startActivity(intent);
                     }
                 });

            //le mandamos el adaptador a nuestro recycler
            recyclerView_tikets.setAdapter(adapter);
        }
}
