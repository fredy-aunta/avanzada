/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import Negocio.Ejercicio;
import Negocio.Entrenador;
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
public class RutinaDiaDB {
    private final String SQL_INSERT = "INSERT INTO rutina_dia_ejercicio(rutina_id, dia, ejercicio_id) VALUES (?,?,?)";
    private final String SQL_UPDATE = "UPDATE rutina_dia_ejercicio SET ejercicio_id = ? WHERE dia = ?, rutina_id = ?;";
    private final String SQL_DELETE = "DELETE FROM rutina_dia_ejercicio  WHERE dia = ?, rutina_id = ?";
    private final String SQL_SELECT_RUTINA_ID = "SELECT * FROM rutina_dia_ejercicio LEFT JOIN ejercicio ON ejercicio.ejercicio_id = rutina_dia_ejercicio.ejercicio_id WHERE rutina_id = ?";

    public RutinaDiaDB() {
    }
    
    public int insert(int rutinaId, int dia, int ejercicio_id){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            int index = 1;
            statement.setInt(index++, rutinaId);
            statement.setInt(index++, dia);
            statement.setInt(index++, ejercicio_id);
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
    
    public int update(int rutinaId, int dia, int ejercicio_id){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            statement = connection.prepareStatement(SQL_UPDATE);
            int index = 1;
            statement.setInt(index++, ejercicio_id);
            statement.setInt(index, dia);
            statement.setInt(index, rutinaId);
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
    
    public int delete(int dia, int rutinaId){
        Connection connection = null;
        PreparedStatement statement = null;
        int rows = 0;
        try {
            connection = DBManager.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1, dia);
            statement.setInt(2, rutinaId);
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
    
    public ArrayList<RutinaDia> selectByRutinaId(int rutinaId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<RutinaDia> rutinaDias = new ArrayList<>();
        rutinaDias = this.crearRutinasDias();
        RutinaDia rutinaDia = null;
        Ejercicios ejercicios = null;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_RUTINA_ID);
            statement.setInt(1, rutinaId);
            rs = statement.executeQuery();
            while(rs.next()){
                int dia = rs.getInt(2);
                int ejercicioId = rs.getInt(3);
                String nombreEjercicio = rs.getString(5);
                String tipoEjercicio = rs.getString(6);
                int repeticiones = rs.getInt(7);
                int serie = rs.getInt(8);
                
                rutinaDia = rutinaDias.get(dia - 1);
                rutinaDia.setDiaRutina(dia);
                
                ejercicios = rutinaDia.getEjerciciosDia();
                ejercicios.add(new Ejercicio(ejercicioId, nombreEjercicio, repeticiones, serie, tipoEjercicio));
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
    
    private ArrayList<RutinaDia> crearRutinasDias(){
        ArrayList<RutinaDia> rutinasDia2 = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            rutinasDia2.set(i, new RutinaDia(i + 1));
        }
        return rutinasDia2;
    }
}
