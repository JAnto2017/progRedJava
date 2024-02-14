package com.mycompany.seccion_05_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author JAnto
 */
public class hilocliente extends Thread {
    private javax.swing.JTextArea txtmensaje;
    private ServerSocket servidor;
    boolean salir = false;
    Socket cliente;
    
    final String SERVER = "localhost";
    final int PUERTO = 9090;
    
    BufferedReader recibir;
    PrintWriter enviar;

    public hilocliente(JTextArea txtmensaje) {
        
        try {
            cliente = new Socket(SERVER, PUERTO);
            enviar = new PrintWriter(cliente.getOutputStream(), true);
            recibir = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            this.txtmensaje = txtmensaje;
            this.txtmensaje.append("Conexión establecida con el servidor" + System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(hilocliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Método que inicia. Se usa con los hilos.
     */
    public void run() {
        try {
            this.txtmensaje.append("Cliente a la espera..." + System.lineSeparator());
            String comando;
            while(!salir){
                comando=recibir.readLine();
                this.txtmensaje.append("Texto recibido " + comando + System.lineSeparator());
                
            }
        } catch (IOException ex) {
            this.txtmensaje.append("Error en el cliente: " + ex.getMessage());
        }
    }
    
    public void enviar (String Mensaje) {
        enviar.println(Mensaje);
        enviar.flush();
    }
}
