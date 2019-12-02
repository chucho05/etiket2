package com.example.e_tiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_tiket.Models.Ticket;


public class MainActivity extends AppCompatActivity {
    EditText editText_usuario;
    EditText editText_contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_usuario = (EditText) findViewById(R.id.editText_usuario);
        editText_contraseña = (EditText) findViewById(R.id.editText_contraseña);


    }
Ticket ticket;
    public void activity2(View view){
            if(editText_usuario.getText().toString().equals("17040085") && editText_contraseña.getText().toString().equals("vick")){
                Intent intent = new Intent(this, e_Tiket_Activity2.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(),"contraseña incorrecta o campos vacíos", Toast.LENGTH_SHORT).show();
            }

    }

}
