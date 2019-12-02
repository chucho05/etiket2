package com.example.e_tiket.conexion_red;


import android.app.Activity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import models.Ticket;

public class ConexionServidor {

    private final PutList putList;
    //private final Context context;
    ServerSocket serverSocket;

    public ConexionServidor(final PutList putList) {
        this.putList = putList;
        Thread miHilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(1399);
                    while(true){
                        //esperara una conexión
                        Socket socket = serverSocket.accept();
                        //DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                        //String data = dataInputStream.readUTF();
                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                        ArrayList<Ticket> listTickets = (ArrayList<Ticket>) objectInputStream.readObject();
                        if(putList!=null){
                            putList.setAdapter(listTickets);
                        }
                        //Toast.makeText(context, "algo recibido", Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        miHilo.setDaemon(true);
        miHilo.start();

    }



}
