/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto2corte;

import Negocio.Ejercicio;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class RutinaDia {
    private int diaRutina;
    ArrayList<Ejercicio> ejerciciosDia = new ArrayList<>();

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

    public ArrayList<Ejercicio> getEjerciciosDia() {
        return ejerciciosDia;
    }

    public void setEjerciciosDia(ArrayList<Ejercicio> ejerciciosDia) {
        this.ejerciciosDia = ejerciciosDia;
    }
    
}
