/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.ClienteDB;
import DB.UsuarioDB;
import Negocio.Cliente;
import Negocio.Rutina;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fredy
 */
public class ClienteCtrl {
    public static int ROLE_ID = 3;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Cliente cliente;
    private ClienteDB clienteDB = new ClienteDB();
    private UsuarioDB usuarioDB = new UsuarioDB();

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
    
    public void insertarCliente(String nombreCliente, String alturaCliente, String masaCliente, String fechaNacimiento, String generoCliente, String objetivo){
        int idCliente = clienteDB.insert(nombreCliente, alturaCliente, masaCliente, fechaNacimiento, generoCliente, objetivo);
        int idUser = usuarioDB.insert(nombreCliente, ROLE_ID);
        clienteDB.UpdateUserId(idCliente, idUser);
    }
    
    public ArrayList consultarClientes(){
        clientes = clienteDB.select();
        return clientes;
    }
    
    public void clienteActivo(String username){
        int idUser = usuarioDB.getId(username);
        cliente = clienteDB.selectByUserId(idUser);
    }
    
    public void clienteInactivo(){
        cliente = null;
    }
    
    public void eliminarCliente(String id){
        int idCliente;
        try {
            idCliente = Integer.parseInt(id);
            clienteDB.delete(idCliente);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void modificarCliente(int idCliente, String nombreCliente, String alturaCliente, String masaCliente, String generoCliente, String objetivo){
          clienteDB.update(idCliente, nombreCliente, alturaCliente, masaCliente, generoCliente, objetivo);
    }
    
    public Cliente asignarRutina(Cliente cliente, Rutina rutina){
        cliente.setRutinaCliente(rutina);
        return cliente;
    }
//    public Cliente buscarCliente(String valor){
//        return ClienteDB.mgr.getCliente(valor);
//    }
    
//    public ArrayList buscarClientes(String campo, String valor){
//        return ClienteDB.mgr.consultarClientes(campo, valor);
//    }
    
}
