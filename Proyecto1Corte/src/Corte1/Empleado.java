/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Corte1;

/**
 *
 * @author Fredy
 */
public class Empleado {
    private int id;
    private String nombre;
    private TipoSolicitud tipo;
    private String tipoSolicitud;

    public Empleado() {
    }

    public Empleado(int id, String nombre, String tipoSolicitud) {
        this.id = id;
        this.nombre = nombre;
        this.tipoSolicitud = tipoSolicitud;
    }

    public Empleado(int id, String nombre, TipoSolicitud tipo, String tipoSolicitud) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tipoSolicitud = tipoSolicitud;
    }

    public TipoSolicitud getTipo() {
        return tipo;
    }

    public void setTipo(TipoSolicitud tipo) {
        this.tipo = tipo;
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

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    @Override
    public String toString() {
        return "Id: "+id+" Nombre : " + nombre + " Tipo Solicitud : " + tipoSolicitud;
    }
    
    
}
