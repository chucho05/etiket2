package com.example.e_tiket.conexion_red;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConexionCliente   {


    private final PutList putListLista;

    public ConexionCliente(final String user_id, PutList putListlis) {

            this.putListLista = putListlis;

            Thread miHilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket = null;
                    try {
                        socket = new Socket("192.168.43.177",1399);
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        dataOutputStream.writeUTF(user_id+";user_id");
                        dataOutputStream.close();

                        ConexionServidor conexionServidor = new ConexionServidor(putListLista);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

            miHilo.setDaemon(true);
            miHilo.start();

    }

    public void prepararInputDatos(){



    }

}
