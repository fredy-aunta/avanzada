/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.sql.ResultSet;

/**
 *
 * @author Fredy
 */
public class Cuenta {
    private String id;
    private String numeroCuenta;

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    public Cuenta(ResultSet rs){
        try {
            id = rs.getString("Id");
            numeroCuenta = rs.getString("numeroCuenta");
        } catch (Exception e) {
            
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    
}
