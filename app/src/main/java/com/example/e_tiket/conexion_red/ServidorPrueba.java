package com.example.e_tiket.conexion_red;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPrueba {

    private final TextView textVieww;

    public ServidorPrueba(  TextView textView) {
        this.textVieww = textView;
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    ServerSocket serverSocket = new ServerSocket(1399);
                    Socket socket = serverSocket.accept();
                    DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                    String s = inputStream.readUTF();
                    textVieww.setText(s);
                    //Toast.makeText(context, s, Toast.LENGTH_LONG);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        hilo.setDaemon(true);
        hilo.start();


    }
}
