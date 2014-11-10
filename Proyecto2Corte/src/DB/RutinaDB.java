/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import Negocio.Ejercicio;
import Negocio.Entrenador;
import Negocio.Rutina;
import Negocio.RutinaDia;
import Services.DBManager;
import Services.Ejercicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class RutinaDB {
    private final String TABLE_NAME = "rutina";
    private final String SQL_JOIN_ENTRENADOR = "LEFT JOIN entrenador ON entrenador.entrenador_id = rutina.entrenador_id";
    private final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " (nombre_rutina, entrenador_id) VALUES (?, ?)";
    private final String SQL_INSERT_NAME = "INSERT INTO " + TABLE_NAME + " (nombre_rutina) VALUES (?)";
    private final String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET nombre_rutina = ?, entrenador_id = ? WHERE rutina_id = ?;";
    private final String SQL_DELETE = "DELETE FROM " + TABLE_NAME + " WHERE rutina_id = ?";
    private final String SQL_SELECT = "SELECT * FROM " + TABLE_NAME + " " + SQL_JOIN_ENTRENADOR + " ORDER BY rutina_id";
    private final String SQL_SELECT_ID = "SELECT * FROM " + TABLE_NAME + " " + SQL_JOIN_ENTRENADOR + " WHERE rutina_id = ?";
    private final String SQL_JOIN_RUTINA_DIA_EJERCICIO = "SELECT dia, ejercicio.ejercicio_id, nombre_ejercicio, tipo_ejercicio" +
                                                         " FROM rutina_dia_ejercicio JOIN ejercicio ON ejercicio.ejercicio_id = rutina_dia_ejercicio.ejercicio_id" +
                                                         " WHERE rutina_id = ?";
    private final String SQL_INSERT_ID = "SELECT @@identity AS id";

    public RutinaDB() {
    }

    public int insert(String nombre, int idEntrenador){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int rows = 0;
        int id = 0;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, nombre);
            statement.setInt(2, idEntrenador);
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
    
    public int insert(String nombre){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT_NAME);
            statement.setString(1, nombre);
            System.out.println("Ejecutando query: " + SQL_INSERT_NAME);
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
    
    public int update(int id, String nombre, int idEntrenador){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            statement = connection.prepareStatement(SQL_UPDATE);
            int index = 1;
            statement.setString(index++, nombre);
            statement.setInt(index++, idEntrenador);
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
    
    public ArrayList<Rutina> select(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Rutina rutina = null;
        Entrenador entrenador = null;
        ArrayList<Rutina> rutinas = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT);
            rs = statement.executeQuery();
            while(rs.next()){
                int idRutina = rs.getInt(1);
                String nombreRutina = rs.getString(2);
                int idEntrenador = rs.getInt(3);
                rutina = new Rutina();
                rutina.setIdRutina(idRutina);
                rutina.setNombreRutina(nombreRutina);
                if (idEntrenador != 0) {
                    String nombreEntrenador = rs.getString(5);
                    entrenador = new Entrenador();
                    entrenador.setIdEntrenador(idEntrenador);
                    entrenador.setNombreEntrenador(nombreEntrenador);
                }
                rutina.setEntrenador(entrenador);
                rutina.setRutinasDia(this.getEjerciciosByRutinaId(idRutina));
                rutinas.add(rutina);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return rutinas;
    }
    
    public Rutina selectById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Rutina rutina = null;
        Entrenador entrenador = null;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            rs.next();
            int idRutina = rs.getInt(1);
            String nombreRutina = rs.getString(2);
            int idEntrenador = rs.getInt(3);
            rutina = new Rutina();
            rutina.setIdRutina(idRutina);
            rutina.setNombreRutina(nombreRutina);
            if (idEntrenador != 0) {
                String nombreEntrenador = rs.getString(5);
                entrenador = new Entrenador();
                entrenador.setIdEntrenador(idEntrenador);
                entrenador.setNombreEntrenador(nombreEntrenador);
            }
            rutina.setEntrenador(entrenador);
            rutina.setRutinasDia(this.getEjerciciosByRutinaId(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return rutina;
    }
    /**
     * Obtiene los ejercicios que estan asociados a la rutina separados por dia de la semana
     * @param idRutina El id de la rutina
     * @return ArrayList<RutinaDia> de 7 posiciones una para cada dia de la semana con los ejercicios<br>
     * asociados
     */
    private ArrayList<RutinaDia> getEjerciciosByRutinaId(int idRutina){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Ejercicios ejercicios = null;
        Ejercicio ejercicio = null;
        RutinaDia rutinaDia = null;
        ArrayList<RutinaDia> rutinaDias = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            RutinaDia rutinaDiaTmp = new RutinaDia(i + 1);
            rutinaDiaTmp.setEjerciciosDia(new Ejercicios());
            rutinaDias.add(rutinaDiaTmp);
        }
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_JOIN_RUTINA_DIA_EJERCICIO);
            statement.setInt(1, idRutina);
            rs = statement.executeQuery();
            while(rs.next()){
                int dia = rs.getInt(1);
                int idEjercicio = rs.getInt(2);
                String nombreEjercicio = rs.getString(3);
                String tipoEjercicio = rs.getString(4);
                ejercicios = rutinaDias.get(dia - 1).getEjerciciosDia();
                ejercicio = new Ejercicio(idEjercicio, nombreEjercicio, tipoEjercicio);
                ejercicios.add(ejercicio);
                rutinaDia = rutinaDias.get(dia - 1);
                rutinaDia.setEjerciciosDia(ejercicios);
                rutinaDias.set(dia - 1, rutinaDia);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            DBManager.close(rs);
            DBManager.close(statement);
            DBManager.close(connection);
        }
        return rutinaDias;
    }
}