/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;
import DB.EntrenadorDB;
import DB.UsuarioDB;
import Negocio.Entrenador;
import java.util.ArrayList;
/**
 *
 * @author sebastian
 */
public class EntrenadorCtrl {
    public static int ROLE_ID = 2;
    
    EntrenadorDB entrenadorDB = new EntrenadorDB();
    Entrenador entrenador = new Entrenador();
    ArrayList<Entrenador> entrenadores= new ArrayList<>();
    UsuarioDB usuarioDB = new UsuarioDB();
    
    public void insertarEntrenador (String nombre){
        int idEntrenador = entrenadorDB.insert(nombre);
        int idUser = usuarioDB.insert(nombre, ROLE_ID);
        entrenadorDB.UpdateUserId(idEntrenador, idUser);
    }
    public void cargarEntrenadores(){
        entrenadores = entrenadorDB.select();
    }

    public void entrenadorActivo(String username){
        int idUser = usuarioDB.getId(username);
        entrenador = entrenadorDB.selectByUserId(idUser);
    }
    
    public void entrenadorInactivo(){
        entrenador = null;
    }
    
    public EntrenadorDB getEntrenadorDB() {
        return entrenadorDB;
    }

    public void setEntrenadorDB(EntrenadorDB entrenadorDB) {
        this.entrenadorDB = entrenadorDB;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }
    
}
