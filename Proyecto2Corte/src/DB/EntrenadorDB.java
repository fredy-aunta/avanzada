/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import Negocio.Entrenador;
import Services.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class EntrenadorDB {
    private final String SQL_INSERT = "INSERT INTO entrenador(nombre_entrenador) VALUES (?)";
    private final String SQL_UPDATE = "UPDATE entrenador SET nombre_entrenador = ? WHERE entrenador_id = ?;";
    private final String SQL_DELETE = "DELETE FROM entrenador WHERE entrenador_id = ?";
    private final String SQL_SELECT = "SELECT * FROM entrenador ORDER BY entrenador_id";
    private final String SQL_SELECT_ID = "SELECT * FROM entrenador WHERE entrenador_id = ?";

    public EntrenadorDB() {
    }

    public int insert(String nombre){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, nombre);
            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = statement.executeUpdate();
            System.out.println("Registros Afectados :" + rows);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return rows;
    }
    
    public int update(int id, String nombre){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            statement = connection.prepareStatement(SQL_UPDATE);
            int index = 1;
            statement.setString(index++, nombre);
            statement.setInt(index, id);
            rows = statement.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return rows;
    }
    public int delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1, id);
            rows = statement.executeUpdate();
            System.out.println("Registros borrados:" + rows);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return rows;
    }
    
    public ArrayList<Entrenador> select(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Entrenador entrenador = new Entrenador();
        ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT);
            rs = statement.executeQuery();
            while(rs.next()){
                int idEntrenador = rs.getInt(1);
                String nombreEntrenador = rs.getString(2);
                entrenador = new Entrenador();
                entrenador.setIdEntrenador(idEntrenador);
                entrenador.setNombreEntrenador(nombreEntrenador);
                entrenadores.add(entrenador);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return entrenadores;
    }
    
    public Entrenador selectById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Entrenador entrenador = null;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            rs.next();
            int idEntrenador = rs.getInt(1);
            String nombreEntrenador = rs.getString(2);
            entrenador = new Entrenador();
            entrenador.setIdEntrenador(idEntrenador);
            entrenador.setNombreEntrenador(nombreEntrenador);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return entrenador;
    }
}
