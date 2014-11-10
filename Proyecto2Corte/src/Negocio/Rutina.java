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
    public static final int DIAS_SEMANA = 7;
    private int idRutina;
    private String nombreRutina;
    private Entrenador entrenador;
    private ArrayList<RutinaDia> rutinasDia = new ArrayList<>();
    private Objetivo objetivo;

    public Rutina() {
        this.rutinasDia = this.crearRutinasDias();
    }

    public Rutina(int idRutina, String nombreRutina, int tiempoRutina) {
        this.rutinasDia = this.crearRutinasDias();
        this.idRutina = idRutina;
        this.nombreRutina = nombreRutina;
    }

    private ArrayList<RutinaDia> crearRutinasDias(){
        ArrayList<RutinaDia> rutinasDia2 = new ArrayList<>();
        for (int i = 0; i < DIAS_SEMANA; i++) {
            rutinasDia2.add(new RutinaDia(i + 1));
        }
        return rutinasDia2;
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
    
    public void setRutinaDIa(int dia, RutinaDia rutinaDia){
        rutinasDia.set(dia - 1, rutinaDia);
    }
    
    public RutinaDia getRutinaDia(int dia){
        return rutinasDia.get(dia - 1);
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
