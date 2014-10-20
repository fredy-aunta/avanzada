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
public class Area {
    private int id;
    private String nombre;
    private ArrayList<Empleado> empleados =new ArrayList<Empleado>();
    

    public Area() {
    }

    public Area(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
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

    public void adicionarIdEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    @Override
    public String toString() {
        return "Id: "+id+" Nombre: "+nombre;
    }
    
}
