package secc_03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author José Antonio
 * @version 1.0.0
 * @category   
 * 
 * Sección 3 comunicación cliente/servidor usando datagramas
 * Socket UDP
 * DatagramPacket
 * 
 * Este es el SERVIDOR
 */
public class DataReceiver {
    public DataReceiver() {
        
    }

    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(3000);               //puerto 3000
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, 1024);          //define tamaño paquete a recibir

            System.out.println("Esperando datos...");
            ds.receive(dp);                                             //método recibir

            String str = new String(dp.getData(), 0, dp.getLength());   //transformación en string para visualizar
            System.out.println(str);

            ds.close();
        } catch (Exception e) {
            System.err.println("Error tipo: " + e.getMessage());
        }
        
    }
}
