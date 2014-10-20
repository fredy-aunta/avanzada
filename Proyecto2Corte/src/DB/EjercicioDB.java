/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import Negocio.Ejercicio;
import Services.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class EjercicioDB {
    private final String SQL_INSERT = "INSERT INTO ejercicio(nombre_ejercicio, tipo_ejercicio) VALUES (?,?)";
    private final String SQL_UPDATE = "UPDATE ejercicio SET nombre_ejercicio = ?, tipo_ejercicio = ? WHERE ejercicio_id = ?;";
    private final String SQL_DELETE = "DELETE FROM ejercicio WHERE ejercicio_id = ?";
    private final String SQL_SELECT = "SELECT * FROM ejercicio ORDER BY ejercicio_id";
    private final String SQL_SELECT_ID = "SELECT * FROM ejercicio WHERE ejercicio_id = ?";
    private final String SQL_SELECT_TIPO = "SELECT * FROM ejercicio WHERE tipo_ejercicio = ?";

    public EjercicioDB() {
    }

    public int insert(String nombre, String tipoEjercicio){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            int index = 1;
            statement.setString(index++, nombre);
            statement.setString(index++, tipoEjercicio);
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
    public int update(int id, String nombre, String tipo){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            statement = connection.prepareStatement(SQL_UPDATE);
            int index = 1;
            statement.setString(index++, nombre);
            statement.setString(index++, tipo);
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
            int index = 1;
            statement.setInt(index, id);
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
    
    public ArrayList<Ejercicio> select(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Ejercicio ejercicio = null;
        ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT);
            rs = statement.executeQuery();
            while(rs.next()){
                int idEjercicio = rs.getInt(1);
                String nombreEjercicio = rs.getString(2);
                String tipoEjercicio = rs.getString(3);
                ejercicio = new Ejercicio();
                ejercicio.setIdEjercicio(idEjercicio);
                ejercicio.setNombreEjercicio(nombreEjercicio);
                ejercicio.setTipoEjercicio(tipoEjercicio);
                ejercicios.add(ejercicio);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return ejercicios;
    }
    
    public Ejercicio selectById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Ejercicio ejercicio = null;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            rs.next();
            int idEjercicioRes = rs.getInt(1);
            String nombreEjercicio = rs.getString(2);
            String tipoEjercicio = rs.getString(3);
            ejercicio = new Ejercicio();
            ejercicio.setIdEjercicio(idEjercicioRes);
            ejercicio.setNombreEjercicio(nombreEjercicio);
            ejercicio.setTipoEjercicio(tipoEjercicio);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return ejercicio;
    }
    
    public ArrayList<Ejercicio> selectByTipo(String tipo){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Ejercicio ejercicio = null;
        ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_TIPO);
            statement.setString(1, tipo);
            rs = statement.executeQuery();
            while(rs.next()){
                int id_ejercicio = rs.getInt(1);
                String nombreEjercicio = rs.getString(2);
                String tipoEjercicio = rs.getString(3);
                ejercicio = new Ejercicio();
                ejercicio.setIdEjercicio(id_ejercicio);
                ejercicio.setNombreEjercicio(nombreEjercicio);
                ejercicio.setTipoEjercicio(tipoEjercicio);
                ejercicios.add(ejercicio);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return ejercicios;
    }
}
