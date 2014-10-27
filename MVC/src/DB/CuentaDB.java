/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import Negocio.Cuenta;
import Services.DBManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class CuentaDB extends DBManager{
    public static CuentaDB mgr = new CuentaDB();

    public CuentaDB() {
    }

    @Override
    protected void addObject(ArrayList v, ResultSet rs) {
        v.add(new Cuenta(rs));
    }
    
    public Cuenta getItem(String id){
        ArrayList v = executeQuery("SELECT * FROM Cuenta WHERE id = " + id + " ");
        if (v.size() > 0) {
            return (Cuenta) v.get(0);
        }
        return new Cuenta();
    }
    
    public Cuenta getCuenta(String numeroCuenta){
        ArrayList v = executeQuery("SELECT * FROM Cuenta WHERE numero_cuenta = '" + numeroCuenta + "' ");
        if (v.size() > 0) {
            return (Cuenta) v.get(0);
        }
        Cuenta cuenta = null;
        return cuenta;
    }
    
    public void save(Cuenta cuenta, Boolean valor){
        if (valor) {
            mgr.execute("INSERT INTO Cuenta (numero_cuenta) VALUES ('" + 
                        cuenta.getNumeroCuenta() + "')"
                        );
        } else {
            mgr.execute("UPDATE Cuenta SET numero_cuenta = " + cuenta.getNumeroCuenta() + 
                        " WHERE id = " + cuenta.getId() + " "
                        );
        }
    }
    
    public void delete(Cuenta cuenta){
        mgr.execute("DELETE FROM Cuenta WHERE id = " + cuenta.getId() + " ");
    }
    
    public ArrayList<Cuenta> getCuentas(){
        ArrayList<Cuenta> v = executeQuery("SELECT id, numero_cuenta FROM Cuenta");
        return v;
    }
    
    public ArrayList consultarCuentas(String campo, String valor){
        ArrayList v = executeQuery("SELECT * FROM Cuenta WHERE " + campo + " = " + valor + " ");
        return v;
    }
}
