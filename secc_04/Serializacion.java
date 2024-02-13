package secc_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author José Antonio
 * @version 1.0.0
 * 
 * Sección 4 - Serialización.
 * Clase principal con main().
 * Enviará y recibirá los objetos a través de la conexión de red.
 * Tendrá implementado tanto: funcionalidad del cliente como del servidor.
 * Al ejecutarla, preguntará si es cliente o servidor.
 */
public class Serializacion {
    
    public static void main(String[] args) {

        BufferedReader entradaDeDatos = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Seleccione Cliente o Servidor");

        try {
            String tipo = entradaDeDatos.readLine();

            if (tipo.equalsIgnoreCase("Cliente")) {
                Cliente cliente = new Cliente();
                cliente.iniciar();
            } else if (tipo.equalsIgnoreCase("Servidor")) {
                Servidor servidor = new Servidor();
                servidor.iniciar();
            } else {
                System.out.println("Tipo no reconocida... saliendo...");
            }
            
        } catch (IOException e) {
            System.out.println("Error clase Serialización: " + e.getMessage());
        }
    }
}
