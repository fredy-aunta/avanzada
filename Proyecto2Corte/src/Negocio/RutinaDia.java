/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Services.Ejercicios;

/**
 *
 * @author sebastian
 */
public class RutinaDia {
    private int diaRutina;
    Ejercicios ejerciciosDia = new Ejercicios();

    public RutinaDia() {
    }

    public RutinaDia(int diaRutina) {
        this.diaRutina = diaRutina;
    }

    public int getDiaRutina() {
        return diaRutina;
    }

    public void setDiaRutina(int diaRutina) {
        this.diaRutina = diaRutina;
    }

    public Ejercicios getEjerciciosDia() {
        return ejerciciosDia;
    }

    public void setEjerciciosDia(Ejercicios ejerciciosDia) {
        this.ejerciciosDia = ejerciciosDia;
    }

}
