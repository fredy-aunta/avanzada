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
public class Ejercicio {
    private int idEjercicio;
    private String nombreEjercicio;
    private int repeticionesEjercicio;
    private int serieEjercicio;
    private String tipoEjercicio;

    public Ejercicio() {
    }

    public Ejercicio(int idEjercicio, String nombreEjercicio, String tipoEjercicio) {
        this.idEjercicio = idEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.tipoEjercicio = tipoEjercicio;
    }

    public Ejercicio(int idEjercicio, String nombreEjercicio, int repeticionesEjercicio, int serieEjercicio, String tipoEjercicio) {
        this.idEjercicio = idEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.repeticionesEjercicio = repeticionesEjercicio;
        this.serieEjercicio = serieEjercicio;
        this.tipoEjercicio = tipoEjercicio;
    }
    
    

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public int getRepeticionesEjercicio() {
        return repeticionesEjercicio;
    }

    public void setRepeticionesEjercicio(int repeticionesEjercicio) {
        this.repeticionesEjercicio = repeticionesEjercicio;
    }

    public int getSerieEjercicio() {
        return serieEjercicio;
    }

    public void setSerieEjercicio(int serieEjercicio) {
        this.serieEjercicio = serieEjercicio;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }
    
    @Override
    public String toString() {
        return idEjercicio + ";" + nombreEjercicio;
    }
    
}
