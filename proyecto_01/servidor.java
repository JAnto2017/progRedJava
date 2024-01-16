package proyecto_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author Jose
 * @version 1.0
 */
public class servidor {
    public static void main(String[] args) throws IOException {
        boolean salir = false;

        //creamos socket servidor
        ServerSocket servidor = new ServerSocket(9090);

        try {
            //esperamos a que entre algún cliente
            Socket cliente = servidor.accept();
            System.out.println(cliente.toString());
            BufferedReader recibir = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter enviar = new PrintWriter(cliente.getOutputStream(), true);

            while (!salir) {
                String comando = recibir.readLine();
                System.out.println("Comando recibido: " + comando);
                switch (comando) {
                    case "salir":
                        salir = true;
                        break;
                    case "fecha":
                        enviar.println(new Date().toString());
                        break;
                    default:
                        enviar.println("Los comandos a usar son: " + "salir o fecha");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
