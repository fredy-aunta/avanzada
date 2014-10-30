/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author Fredy
 */
public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String alturaCliente;
    private String masaCliente;
    private int edadCliente;
    private String generoCliente;
    private Rutina rutinaCliente;
    private Objetivo objetivo;

    public Cliente(int idCliente, String nombreCliente, String alturaCliente, String masaCliente, int edadCliente, String generoCliente, Rutina rutinaCliente, Objetivo objetivo) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.alturaCliente = alturaCliente;
        this.masaCliente = masaCliente;
        this.edadCliente = edadCliente;
        this.generoCliente = generoCliente;
        this.rutinaCliente = rutinaCliente;
        this.objetivo = objetivo;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getAlturaCliente() {
        return alturaCliente;
    }

    public void setAlturaCliente(String alturaCliente) {
        this.alturaCliente = alturaCliente;
    }

    public String getMasaCliente() {
        return masaCliente;
    }

    public void setMasaCliente(String masaCliente) {
        this.masaCliente = masaCliente;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    public String getGeneroCliente() {
        return generoCliente;
    }

    public void setGeneroCliente(String generoCliente) {
        this.generoCliente = generoCliente;
    }

    public Rutina getRutinaCliente() {
        return rutinaCliente;
    }

    public void setRutinaCliente(Rutina rutinaCliente) {
        this.rutinaCliente = rutinaCliente;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

      
    @Override
    public String toString() {
        if (rutinaCliente == null) {
            return nombreCliente;
        } else {
            return nombreCliente + rutinaCliente.toString();
        }
    }
    
}
