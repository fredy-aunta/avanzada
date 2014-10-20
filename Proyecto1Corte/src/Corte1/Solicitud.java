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
public class Solicitud {
    private int id;
    private String descripcion;
    private int idEmpleado;
    private TipoSolicitud tipo;
    private int idArea;
    private Usuario usuario;

    public Solicitud() {
    }

    public Solicitud(int id, String descripcion, int idEmpleado, TipoSolicitud tipo, int idArea, Usuario usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.idEmpleado = idEmpleado;
        this.tipo = tipo;
        this.idArea = idArea;
        this.usuario = usuario;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "usuario: "+usuario+" descripcion: "+descripcion+" Is: "+id+" tipo: "+tipo+" id empleado asignado: "+idEmpleado+" ID area asignada"+idArea;
    }
    
    
}
