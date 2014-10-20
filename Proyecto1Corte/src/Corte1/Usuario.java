/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Corte1;

import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class Usuario {
    private int id;
    private String nombre;
    private ArrayList<Equipo> equipos = new ArrayList<Equipo>();

    public Usuario() {
    }

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarEquipo(Equipo equipo){
        equipos.add(equipo);
    }

    @Override
    public String toString() {
        return "ID : " + id + " Nombre : " + nombre;
    }
    
    
}
