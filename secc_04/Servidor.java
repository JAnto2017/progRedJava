package secc_04;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author José Antonio
 * @version 1.0.0
 * 
 * Servidor para usar en Serialización.
 * Crea los objetos que permite crear el socket de conexión con los clientes.
 * 
 */
public class Servidor {

    public void iniciar() {
        ServerSocket servidor = null;

        try {
            servidor = new ServerSocket(8080);
            boolean salir = false;
            Socket cliente = servidor.accept();

            while (!salir) {
                ObjectInputStream recibir = new ObjectInputStream(cliente.getInputStream());
                ObjectOutputStream enviar = new ObjectOutputStream(cliente.getOutputStream());

                Libreria msg = (Libreria) recibir.readObject();
                msg.mostrar();

                //respuesta automática
                Libreria respuesta = new Libreria(
                    msg.getTo(), 
                    msg.getFrom()+ "Re: ", 
                    msg.getAsunto(),
                    "Mensaje recibido. En breve le enviaremos las respuestas.", 
                    msg.getSecuencia() + 1
                );

                enviar.writeObject(respuesta);
            }

            servidor.close();

        } catch (IOException ioe) {
            System.out.println("Error clase Servidor: " + ioe.getMessage());
        }  catch (ClassNotFoundException cnfe) {
            System.out.println("Error clase Servidor: " + cnfe.getMessage());
        } finally {
            if (servidor != null) {
                try {
                    servidor.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        

        

    }
}
