/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;
import DB.UsuarioDB;
/**
 *
 * @author sebastian
 */
public class UserCtrl {
    UsuarioDB usuarioDB = new UsuarioDB();
    
    public boolean validarUser(String nombre,String password,int roleID){
        return usuarioDB.buscarUser(nombre, password,roleID);
    }
    
    public boolean cambiarPassword(String nombre,String currentPassword, String newPassword){
        boolean wasChanged = false;
        String passwordUser = usuarioDB.getPassword(nombre);
        if (passwordUser.equals(currentPassword)) {
            wasChanged = usuarioDB.setPassword(nombre, newPassword);
        }
        return wasChanged;
    }
}
