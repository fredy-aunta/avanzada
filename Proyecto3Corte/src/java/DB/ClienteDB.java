/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import Negocio.Cliente;
import Services.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import Negocio.Rutina;

/**
 *
 * @author Fredy
 */
public class ClienteDB {
    private final String SQL_INSERT = "INSERT INTO cliente (nombre_cliente, altura_cliente, masa_cliente, dob_cliente, genero_cliente, objetivo) VALUES (?,?,?,?,?,?)";
    private final String SQL_INSERT_ID = "SELECT @@identity AS id";
    private final String SQL_INSERT_USER = "INSERT INTO auth_user (user_id, username, password, role_id) VALUES (?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE cliente SET nombre_cliente = ?, altura_cliente = ?, masa_cliente = ?, genero_cliente = ?, objetivo = ? WHERE cliente_id = ?;";
    private final String SQL_UPDATE_USER_ID = "UPDATE cliente SET user_id = ? WHERE cliente_id = ?;";
    private final String SQL_UPDATE_RUTINA_ID = "UPDATE cliente SET rutina_id = ? WHERE cliente_id = ?;";
    private final String SQL_DELETE = "DELETE FROM cliente WHERE cliente_id = ?";
    private final String SQL_SELECT = "SELECT * FROM cliente LEFT JOIN rutina ON rutina.rutina_id = cliente.rutina_id ORDER BY cliente_id";
    private final String SQL_SELECT_ID = "SELECT * FROM cliente LEFT JOIN rutina ON rutina.rutina_id = cliente.rutina_id WHERE cliente_id = ?";
    private final String SQL_SELECT_USER_ID = "SELECT * FROM cliente LEFT JOIN rutina ON rutina.rutina_id = cliente.rutina_id WHERE user_id = ?";
    private final String PASSWORD_DEFAULT = "0000"; 
    public ClienteDB() {
    }

    public int insert(String nombre, String altura, String masa, String dob, String genero, String objetivo){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int rows = 0;
        int id = 0;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            int index = 1;
            statement.setString(index++, nombre);
            statement.setString(index++, altura);
            statement.setString(index++, masa);
            statement.setString(index++, dob);
            statement.setString(index++, genero);
            statement.setString(index++, objetivo);
            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = statement.executeUpdate();
            System.out.println("Registros Afectados :" + rows);
            /**
             * Obtiene el id del cliente que se acabo de insertar
             */
            statement = connection.prepareStatement(SQL_INSERT_ID);
            rs = statement.executeQuery();
            rs.next();
            id = rs.getInt(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(statement);
            DBManager.close(connection);
        }
        
        return id;
    }
    
    public int UpdateUserId(int idCliente, int idUser){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_USER_ID);
            int index = 1;
            statement.setInt(index++, idUser);
            statement.setInt(index++, idCliente);
            System.out.println("Ejecutando query: " + SQL_UPDATE_USER_ID);
            rows = statement.executeUpdate();
            System.out.println("Registros Afectados :" + rows);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return rows;
    }
    
    public int update(int id, String nombre, String altura, String masa, String genero, String objetivo){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            statement = connection.prepareStatement(SQL_UPDATE);
            int index = 1;
            statement.setString(index++, nombre);
            statement.setString(index++, altura);
            statement.setString(index++, masa);
            statement.setString(index++, genero);
            statement.setString(index++, objetivo);
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
    
    public ArrayList<Cliente> select(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();
        ArrayList<Cliente> clientes;
        clientes = new ArrayList();
        Rutina rutina = null;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT);
            rs = statement.executeQuery();
            while(rs.next()){
                int idCliente = rs.getInt(1);
                String nombreCliente = rs.getString(3);
                String alturaCliente = rs.getString(4);
                String masaCliente = rs.getString(5);
                String dob = rs.getString(6);
                String genero = rs.getString(7);
                int rutinaId = rs.getInt(8);
                cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                cliente.setNombreCliente(nombreCliente);
                cliente.setAlturaCliente(alturaCliente);
                cliente.setMasaCliente(masaCliente);
                cliente.setEdadCliente(this.getCustomerAge(dob));
                cliente.setGeneroCliente(this.getCustomerGender(genero));
                if (rutinaId != 0) {
                    String nombreRutina = rs.getString(11);
                    rutina = new Rutina();
                    rutina.setIdRutina(rutinaId);
                    rutina.setNombreRutina(nombreRutina);
                }
                cliente.setRutinaCliente(rutina);
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return clientes;
    }
    
    public Cliente selectById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Cliente cliente = null;
        Rutina rutina = null;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            rs.next();
            int idCliente = rs.getInt(1);
            String nombreCliente = rs.getString(3);
            String alturaCliente = rs.getString(4);
            String masaCliente = rs.getString(5);
            String dob = rs.getString(6);
            String genero = rs.getString(7);
            int rutinaId = rs.getInt(8);
            cliente = new Cliente();
            cliente.setIdCliente(idCliente);
            cliente.setNombreCliente(nombreCliente);
            cliente.setAlturaCliente(alturaCliente);
            cliente.setMasaCliente(masaCliente);
            cliente.setEdadCliente(this.getCustomerAge(dob));
            cliente.setGeneroCliente(this.getCustomerGender(genero));
            if (rutinaId != 0) {
                String nombreRutina = rs.getString(11);
                rutina = new Rutina();
                rutina.setIdRutina(rutinaId);
                rutina.setNombreRutina(nombreRutina);
            }
            cliente.setRutinaCliente(rutina);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return cliente;
    }
    
    public Cliente selectByUserId(int userId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Cliente cliente = null;
        Rutina rutina = null;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_USER_ID);
            statement = connection.prepareStatement(SQL_SELECT_USER_ID);
            statement.setInt(1, userId);
            rs = statement.executeQuery();
            rs.next();
            int idCliente = rs.getInt(1);
            String nombreCliente = rs.getString(3);
            String alturaCliente = rs.getString(4);
            String masaCliente = rs.getString(5);
            String dob = rs.getString(6);
            String genero = rs.getString(7);
            int rutinaId = rs.getInt(8);
            cliente = new Cliente();
            cliente.setIdCliente(idCliente);
            cliente.setNombreCliente(nombreCliente);
            cliente.setAlturaCliente(alturaCliente);
            cliente.setMasaCliente(masaCliente);
            cliente.setEdadCliente(this.getCustomerAge(dob));
            cliente.setGeneroCliente(this.getCustomerGender(genero));
            if (rutinaId != 0) {
                String nombreRutina = rs.getString(9);
                rutina = new Rutina();
                rutina.setIdRutina(rutinaId);
                rutina.setNombreRutina(nombreRutina);
            }
            cliente.setRutinaCliente(rutina);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return cliente;
    }
    
    private int getCustomerAge(String dob) throws Exception{
        Calendar fecha = Calendar.getInstance();
        int currentYear = fecha.get(Calendar.YEAR);
        String yearOfBirthString = dob.substring(0,4);
        if (yearOfBirthString.length() != 4) {
            new Exception("Date of Birth Incorrect!!");
            return 0;
        }
        int yearOfBirth = Integer.parseInt(yearOfBirthString);
        int customerAge = currentYear - yearOfBirth;
        return customerAge;
    }
    
    private String getCustomerGender(String gender) throws Exception{
        String customerGender = "";
        if (gender.equals("M")) {
            customerGender = "Masculino";
        } else if (gender.equals("F")) {
            customerGender = "Femenino";
        }else{
            new Exception("Gender Incorrect!!");
        }
        return customerGender;
    }
    
    public int UpdateRutinaId(int idCliente, int idRutina){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_RUTINA_ID);
            int index = 1;
            statement.setInt(index++, idRutina);
            statement.setInt(index++, idCliente);
            System.out.println("Ejecutando query: " + SQL_UPDATE_RUTINA_ID);
            rows = statement.executeUpdate();
            System.out.println("Registros Afectados :" + rows);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return rows;
    }
}