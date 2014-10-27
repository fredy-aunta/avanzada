/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import DB.ClienteDB;
import Negocio.Cliente;
import Negocio.Cuenta;
import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class ClienteMgr {
    private ArrayList clientes = new ArrayList();
    Cliente cliente = null;

    public ClienteMgr() {
    }

    public ArrayList getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void agregarCliente(String cedula, String nombre, String direccion, String telefono){
        Cliente cliente = new Cliente(cedula, nombre, direccion, telefono);
        ClienteDB.mgr.save(cliente, Boolean.TRUE);
    }
    
    public ArrayList consultarClientes(){
        clientes = ClienteDB.mgr.getClientes();
        return clientes;
    }
    
    public Cliente getCliente(String id){
        cliente = ClienteDB.mgr.getItem(id);
        return cliente;
    }
    
    public void eliminarCliente(String id){
        Cliente cliente = new Cliente();
        cliente.setId(id);
        ClienteDB.mgr.delete(cliente);
    }
    
    public void modificarCliente(String id, String cedula, String nombre, String direccion, String telefono){
        Cliente cliente = new Cliente(cedula, nombre, direccion, telefono);
        cliente.setId(id);
        ClienteDB.mgr.save(cliente, Boolean.FALSE);
    }
    
    public Cliente buscarCliente(String valor){
        return ClienteDB.mgr.getCliente(valor);
    }
    
    public ArrayList buscarClientes(String campo, String valor){
        return ClienteDB.mgr.consultarClientes(campo, valor);
    }
    
    public void adicionarCuentaCliente(String idCliente, Cuenta cuenta){
        cliente = buscarCliente(idCliente);
        cliente.adicionarCuenta(cuenta);
    }
}
