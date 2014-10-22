/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class Cliente {
    private String id;
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList cuentas = new ArrayList();
    
    public Cliente() {
    }

    public Cliente(ResultSet rs) {
        try {
            id = rs.getString("id");
            cedula = rs.getString("cedula");
            nombre = rs.getString("nombre");
            direccion = rs.getString("direccion");
            telefono = rs.getString("telefono");
        } catch (Exception e) {
        }
    }

    public Cliente(String cedula, String nombre, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList cuentas) {
        this.cuentas = cuentas;
    }

    public void adicionarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }
    @Override
    public String toString() {
        return cedula + " - " + nombre;
    }
    
    
}
