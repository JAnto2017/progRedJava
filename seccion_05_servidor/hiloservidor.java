package com.mycompany.seccion_05;

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
 * @version 1.0.0
 * 
 * Servidor con ventana gráfica. Sección 5 del curso.
 */
public class hiloservidor extends Thread {
    private javax.swing.JTextArea txtmensaje;
    private ServerSocket servidor;
    boolean salir = false;
    Socket cliente;
    BufferedReader recibir;
    PrintWriter enviar;

    public hiloservidor(JTextArea txtmensaje) {
        this.txtmensaje = txtmensaje;
        this.txtmensaje.append("Hilo creado" + System.lineSeparator());
        try {
            servidor = new ServerSocket (9090);
        } catch (IOException ex) {
            Logger.getLogger(hiloservidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Función principal para el inicio del programa al usar hilos.
     */
    public void run () {
        cliente = null;
        
        try{
            cliente = servidor.accept();
            this.txtmensaje.append("Conectando con el cliente " + System.lineSeparator());
            this.txtmensaje.append(cliente.toString() + System.lineSeparator());
            recibir = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            enviar = new PrintWriter(cliente.getOutputStream(), true);
            
            while (!salir) {
                String comando = recibir.readLine();
                this.txtmensaje.append("Comando recibido: " + comando + System.lineSeparator());
            }
        } catch (IOException ex) {
            Logger.getLogger(hiloservidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviar (String Mensaje) {
        enviar.println(Mensaje);
        enviar.flush();
    }
}
