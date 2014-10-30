/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class Rutina {
    private int idRutina;
    private String nombreRutina;
    private int tiempoRutina;
    private Entrenador entrenador;
    private ArrayList<RutinaDia> rutinasDia = new ArrayList<>();
    private Objetivo objetivo;

    public Rutina() {
    }

    public Rutina(int idRutina, String nombreRutina, int tiempoRutina) {
        this.idRutina = idRutina;
        this.nombreRutina = nombreRutina;
        this.tiempoRutina = tiempoRutina;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }

    public String getNombreRutina() {
        return nombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }

    public int getTiempoRutina() {
        return tiempoRutina;
    }

    public void setTiempoRutina(int tiempoRutina) {
        this.tiempoRutina = tiempoRutina;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public ArrayList<RutinaDia> getRutinasDia() {
        return rutinasDia;
    }

    public void setRutinasDia(ArrayList<RutinaDia> rutinasDia) {
        this.rutinasDia = rutinasDia;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String toString() {
        return nombreRutina;
    }
    
    
}
