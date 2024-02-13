package secc_04;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author José Antonio
 * @version 1.0.0
 * 
 * Los objetos para crear el socket permite conectar con el servidor.
 * Importante la IP y el puerto de conexión.
 * 
 */
public class Cliente {
    //---------------------------------------------------------------- ATRIBUTS ----------------------------------------------------------------
    String servidor = "127.0.0.1";
    int puerto = 8080;
    Socket cliente;
    BufferedReader entradaDeDatos = new BufferedReader(new InputStreamReader(System.in));
    
    //---------------------------------------------------------------- METHODS ----------------------------------------------------------------
    public void iniciar() {
        try {
            String comando = "";
            while (!comando.equalsIgnoreCase("salir")) {
                System.out.println("\nEscribir el comando a realizar (configurar | mensaje | salir): ");
                comando = entradaDeDatos.readLine();

                switch (comando) {
                    case "salir":
                        System.out.println("Hasta la próxima:");
                        break;
                    case "configurar":
                        this.configurarServidor();
                        break;
                    case "mensaje":
                        this.enviarMensaje();
                        break;
                    default:
                        System.out.println("Comando no reconocido");
                        break;
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error clase Cliente: " + ioe.getMessage());
        }     
    }

    //---------------------------------------------------------------------------------------------------------------
    private void enviarMensaje() {
        try {
            System.out.println("De: ");
            String from = entradaDeDatos.readLine();

            System.out.println("Para: ");
            String to = entradaDeDatos.readLine();

            System.out.println("Asunto: ");
            String asunto = entradaDeDatos.readLine();

            System.out.println("Mensaje (Escribir .. en una línea nueva para finalizar):");
            String texto = "";
            String linea = "";

            while (!linea.equals("..")) {
                texto += linea + "\n";
                linea = entradaDeDatos.readLine();
            }

            //Libreria(String from, String to, String asunto, String texto, int secuencia)
            Libreria mensaje = new Libreria(from, to, asunto, texto, 1);

            ObjectOutputStream salidaAServidor = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream entradaDeServidor = new ObjectInputStream(cliente.getInputStream());

            salidaAServidor.writeObject(mensaje);
            
            Libreria respuesta = (Libreria) entradaDeServidor.readObject();
            respuesta.mostrar();
            
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
    }

    //---------------------------------------------------------------------------------------------------------------
    private void configurarServidor() {
        try {
            System.out.println("Introduzca la dirección de servidor [127.0.0.1]: ");
            String direccion = entradaDeDatos.readLine();
            if (!direccion.equals("")) {
                servidor = direccion;
            }

            System.out.println("Introduzca el puerto de conexión [8080]: ");
            String puertoDestino = entradaDeDatos.readLine();
            if (!puertoDestino.equals("")) {
                puerto = parseInt(puertoDestino);
            }

            cliente = new Socket(servidor, puerto);
            System.out.println("Conexión establecida con el servidor. \n ---------- \n\n");

        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.toString());
        }
    }

}
