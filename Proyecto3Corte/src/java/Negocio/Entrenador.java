/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;


/**
 *
 * @author sebastian
 */
public class Entrenador {
    private int idEntrenador;
    private String nombreEntrenador;

    public Entrenador() {
    }

    public Entrenador(int idEntrenador, String nombreEntrenador) {
        this.idEntrenador = idEntrenador;
        this.nombreEntrenador = nombreEntrenador;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    @Override
    public String toString() {
        return nombreEntrenador+"-"+idEntrenador;
    }
    
}
