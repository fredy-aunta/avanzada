/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.ArrayList;
import org.postgresql.Driver;

/**
 *
 * @author Fredy
 */
public class DBManager {
    
    private static String DB = "Avanzada_2";
    private static String URL = "jdbc:postgresql://localhost:5432/" + DB;
    private static String DRIVER = "org.postgresql.Driver";
    private static String USER = "postgres";
    private static String PASSWORD = "03032011";

    public DBManager() {
    }
    
    protected void addObject(ArrayList v, ResultSet rs){
        
    }
    protected ArrayList executeQuery(String s){
        ArrayList v = new ArrayList();
        try {
            Class.forName(DRIVER);
            System.out.println("\nEstableciendo conexion ...");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (con == null) {
                System.out.println("DataBase conection not working");
                return v;
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(s);
            while (rs.next()) {                
                addObject(v, rs);
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("-------ERROR--------");
            System.out.println("SQL : " + s);
            System.out.println("Exception : " + e.getMessage());
        } catch (SQLException e){
            System.out.println("-------ERROR--------");
            System.out.println("SQL : " + s);
            System.out.println("Exception : " + e.getMessage());
        }
        return v;
    }
    protected void execute(String s){
        try {
            Class.forName(DRIVER);
            System.out.println("\nEstableciendo conexion ...");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (con == null) {
                System.out.println("DataBase conection not working");
                return;
            }
            Statement stm = con.createStatement();
            stm.execute(s);
            con.close();
        } catch (Exception e){
            System.out.println("-------ERROR--------");
            System.out.println("SQL : " + s);
            System.out.println("Exception : " + e.getMessage());
        }
    }
}
