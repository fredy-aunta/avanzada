/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;
import Negocio.Cliente;
import Services.DBManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import Negocio.Rutina;
/**
 *
 * @author sebastian
 */
public class UsuarioDB {
    private final String SQL_INSERT = "INSERT INTO auth_user (username, role_id) VALUES (?,?)";
    private final String SQL_INSERT_ID = "SELECT @@identity AS id";
    private final String SQL_UPDATE = "UPDATE auth_user SET username = ?, password= ? WHERE user_id = ?;";
    private final String SQL_UPDATE_PASSWORD = "UPDATE auth_user SET password= ? WHERE username = ?;";
    private final String SQL_DELETE = "DELETE FROM auth_user WHERE user_id = ?";
    private final String SQL_SELECT = "SELECT * FROM auth_user ORDER BY user_id";
    private final String SQL_SELECT_ID = "SELECT * FROM auth_user WHERE user_id = ?";
    private final String SQL_SELECT_NAME = "SELECT * FROM auth_user WHERE username = ?";

    public UsuarioDB() {
    }
    /**
     * 
     * @param nombre nombre del user 
     * @param role_id id del role del usuario
     * @return idUser id del user insertado
     */
    public int insert(String nombre, int role_id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int rows = 0;
        int idUser = 0;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            int index = 1;
            statement.setString(index++, nombre);
            statement.setInt(index++, role_id);
            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = statement.executeUpdate();
            System.out.println("Registros Afectados :" + rows);
            /**
             * Obtiene el id del cliente que se acabo de insertar
             */
            statement = connection.prepareStatement(SQL_INSERT_ID);
            rs = statement.executeQuery();
            rs.next();
            idUser = rs.getInt(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return idUser;
    }
    public int update(String nombre, String password,int user_id){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            statement = connection.prepareStatement(SQL_UPDATE);
            int index = 1;
            statement.setString(index++, nombre);
            statement.setString(index++, password);
            statement.setInt(index++, user_id);
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
    
    public boolean buscarUser(String username,String password, int roleId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean acierto=false;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NAME);
            statement = connection.prepareStatement(SQL_SELECT_NAME);
            statement.setString(1, username);
            rs = statement.executeQuery();
            rs.next();
            String password1 = rs.getString(3);
            int role = rs.getInt(4);
            if(password1.equals(password) && role==roleId){
                acierto=true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return acierto;
    }
    
    public String getPassword(String username){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String password = "";
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NAME);
            statement = connection.prepareStatement(SQL_SELECT_NAME);
            statement.setString(1, username);
            rs = statement.executeQuery();
            rs.next();
            password = rs.getString(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return password;
    }
    
    public boolean setPassword(String username, String newPassword){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean wasChanged = false;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE_PASSWORD);
            statement = connection.prepareStatement(SQL_UPDATE_PASSWORD);
            int index = 1;
            statement.setString(index++, newPassword);
            statement.setString(index++, username);
            rows = statement.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        if (rows > 0) {
            wasChanged = true;
        }
        return wasChanged;
    }
    public int getId(String username){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int idUser = 0;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NAME);
            statement = connection.prepareStatement(SQL_SELECT_NAME);
            int index = 1;
            statement.setString(index++, username);
            rs = statement.executeQuery();
            rs.next();
            idUser = rs.getInt(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return idUser;
    }
}
