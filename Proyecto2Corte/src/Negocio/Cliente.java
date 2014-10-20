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
    private float alturaCliente;
    private float masaCliente;
    private int edadCliente;
    private String generoCliente;
    private Rutina rutinaCliente;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCliente, float alturaCliente, int edadCliente, String generoCliente, float masaCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.alturaCliente = alturaCliente;
        this.edadCliente = edadCliente;
        this.generoCliente = generoCliente;
        this.masaCliente = masaCliente;
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

    public float getAlturaCliente() {
        return alturaCliente;
    }

    public void setAlturaCliente(float alturaCliente) {
        this.alturaCliente = alturaCliente;
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

    public float getMasaCliente() {
        return masaCliente;
    }

    public void setMasaCliente(float masaCliente) {
        this.masaCliente = masaCliente;
    }

    public Rutina getRutinaCliente() {
        return rutinaCliente;
    }

    public void setRutinaCliente(Rutina rutinaCliente) {
        this.rutinaCliente = rutinaCliente;
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
