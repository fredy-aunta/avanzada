/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;
import DB.*;
import Negocio.*;
import java.util.ArrayList;
/**
 *
 * @author sebastian
 */
public class EjercicioCtrl {
    ArrayList<Ejercicio> ejercicios = new ArrayList<>();
    Ejercicio ejercicio = new Ejercicio();
    EjercicioDB ejercicioDB = new EjercicioDB();
    
    public void insetar(String nombre,String tipoEjercicio,int repeticiones,int serie){
        ejercicioDB.insert(nombre, tipoEjercicio, repeticiones, serie);
    }
    public ArrayList consultar(){
        ejercicios=ejercicioDB.select();
        return ejercicios;
    }
    public EjercicioCtrl() {
    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public EjercicioDB getEjercicioDB() {
        return ejercicioDB;
    }

    public void setEjercicioDB(EjercicioDB ejercicioDB) {
        this.ejercicioDB = ejercicioDB;
    }
    
}
