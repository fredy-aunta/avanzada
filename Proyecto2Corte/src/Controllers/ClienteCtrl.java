/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.ClienteDB;
import Negocio.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class ClienteCtrl {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Cliente cliente;
    ClienteDB clienteDB = new ClienteDB();

    public ClienteCtrl() {
    }

    public ClienteCtrl(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void insertarCliente(String nombreCliente, float alturaCliente, float masaCliente, String fechaNacimiento, String generoCliente){
        clienteDB.insert(nombreCliente, alturaCliente, masaCliente, fechaNacimiento, generoCliente);
    }
    
    public ArrayList consultarClientes(){
//        clientes = ClienteDB.mgr.getClientes();
        return clientes;
    }
    
    public Cliente getCliente(String id){
//        cliente = ClienteDB.mgr.getItem(id);
        return cliente;
    }
    
    public void eliminarCliente(String id){
//        Cliente cliente = new Cliente();
//        cliente.setId(id);
//        ClienteDB.mgr.delete(cliente);
    }
    
    public void modificarCliente(String id, String cedula, String nombre, String direccion, String telefono){
//        Cliente cliente = new Cliente(cedula, nombre, direccion, telefono);
//        cliente.setId(id);
//        ClienteDB.mgr.save(cliente, Boolean.FALSE);
    }
    
//    public Cliente buscarCliente(String valor){
//        return ClienteDB.mgr.getCliente(valor);
//    }
    
//    public ArrayList buscarClientes(String campo, String valor){
//        return ClienteDB.mgr.consultarClientes(campo, valor);
//    }
    
}
