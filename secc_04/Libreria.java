package secc_04;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author José Antonio
 * @version 1.0.0
 * 
 * Sección 4 - Serialización.
 * Esta clase es la que usaremos para serializar.
 */
public class Libreria implements Serializable {
    //---------------------------------------------------------------- ATRIBUTICS ----------------------------------------------------------------
    private String from;
    private String to;
    private String asunto;
    private String texto;
    private LocalDateTime fecha;
    private int secuencia;

    //---------------------------------------------------------------- CONSTRUCTORS ----------------------------------------------------------------
    public Libreria() {
    }
/*
    public Libreria(String from, String to, String asunto, String texto, LocalDateTime fecha, int secuencia) {
        this.from = from;
        this.to = to;
        this.asunto = asunto;
        this.texto = texto;
        this.fecha = fecha;
        this.secuencia = secuencia;
    }
*/
    public Libreria(String from, String to, String asunto, String texto, int secuencia) {
        this.from = from;
        this.to = to;
        this.asunto = asunto;
        this.texto = texto;
        this.fecha = fecha;
        this.secuencia = secuencia;
    }
    //---------------------------------------------------------------- SETTERS/GETTERS ------------------------------------------------------------
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public int getSecuencia() {
        return secuencia;
    }
    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    //---------------------------------------------------------------- METHOD ----------------------------------------------------------------
    public void mostrar() {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Asunto: " + asunto);
        System.out.println("Texto: \n" + texto);
        System.out.println("Fecha: " + fecha);
    }

    
}
