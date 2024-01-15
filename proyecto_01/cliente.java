
package proyecto_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.net.Socket;

/**
 * cliente
 * @author Jose
 * @version 1.0
 */
public class cliente {

    public static void main(String[] args) throws IOException {
        String comando;
        comando = "";

        //variable para leer los comandos del usuario
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduce la dirección IP del servidor [127.0.0.1]: ");
        String address = buffer.readLine();
        if (address.equals("")) {
            address = "127.0.0.1";    
        }

        System.out.println("Introduce el puerto al que conectarse [9090]: "); 
        String puerto = buffer.readLine();
        if (puerto.equals("")) {
            puerto = "9090";
        }

        Socket cliente = new Socket(address, parseInt(puerto)); //SOCKET CLIENTE

        //obtenemos el writer para poder enviar información al servidor
        PrintWriter enviar = new PrintWriter(cliente.getOutputStream(), true);

        //obtenemos el lector que recibirá la información del servidor
        BufferedReader recibir = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

        System.out.println("Conexión establecida con el servidor.");

        while (!comando.contains("salir")) {
            System.out.println("");
            System.out.println("Introduce un comando");
            comando = buffer.readLine();

            System.out.println("");

            enviar.println(comando);
            System.out.println(recibir.readLine());
        }

        System.exit(0);
    }
}