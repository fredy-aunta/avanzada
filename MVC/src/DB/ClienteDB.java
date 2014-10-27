/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import Negocio.Cliente;
import Services.DBManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class ClienteDB extends DBManager{
    public static ClienteDB mgr = new ClienteDB();

    public ClienteDB() {
    }

    @Override
    protected void addObject(ArrayList v, ResultSet rs) {
        v.add(new Cliente(rs));
    }
    
    public Cliente getItem(String id){
        ArrayList v = executeQuery("SELECT * FROM Cliente WHERE id = " + id + " ");
        if (v.size() > 0) {
            return (Cliente) v.get(0);
        }
        return new Cliente();
    }
    
    public Cliente getCliente(String cedula){
        ArrayList v = executeQuery("SELECT * FROM Cliente WHERE cedula = '" + cedula + "' ");
        if (v.size() > 0) {
            return (Cliente) v.get(0);
        }
        Cliente cliente = null;
        return cliente;
    }
    
    public void save(Cliente cliente, Boolean valor){
        if (valor) {
            mgr.execute("INSERT INTO Cliente (cedula, nombre, direccion, telefono) VALUES ('" + 
                        cliente.getCedula() + "', '" +
                        cliente.getNombre() + "', '" +
                        cliente.getDireccion() + "', '" +
                        cliente.getTelefono() + "')"
                    );
        } else {
            mgr.execute("UPDATE Cliente SET direccion = '" + cliente.getDireccion() + 
                        "', telefono = '" + cliente.getTelefono() +
                        "', nombre = '" + cliente.getNombre() +
                        "', WHERE id = " + cliente.getId() + " "
            );
        }
    }
    
    public void delete(Cliente cliente){
        mgr.execute("DELETE FROM Cliente WHERE id = " + cliente.getId() + " ");
    }
    
    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> v = executeQuery("SELECT id, cedula, nombre, direccion, telefono FROM Cliente");
        return v;
    }
    
    public ArrayList consultarClientes(String campo, String valor){
        ArrayList v = executeQuery("SELECT * FROM Cliente WHERE " + campo + " = " + valor + " ");
        return v;
    }
}