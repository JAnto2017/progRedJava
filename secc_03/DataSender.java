package secc_03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Jose Antonio
 * @version 1.0.0
 * 
 * Sección 3. Comunicación cliente/servidor usando datagramas.
 * Este es el CLIENTE.
 */
public class DataSender {
    public DataSender() {
        
    }

    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            String str = "Hola mundo UDP";
            InetAddress ip = InetAddress.getByName("127.0.0.1");

            DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000); //se especifica: tamaño, IP, puerto y el dato

            ds.send(dp);                                                                    //método enviar
            System.out.println("Datos enviados");
            
            ds.close();
        } catch (Exception e) {
            System.err.println("Error tipo: " + e.getMessage());
        }
    }
}
