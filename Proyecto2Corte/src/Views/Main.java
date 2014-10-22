/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import DB.ClienteDB;
import DB.EntrenadorDB;
import DB.RutinaDB;
import Negocio.Cliente;
import Negocio.Entrenador;
import Negocio.Rutina;
import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class Main {
    
    public static void main(String[] args) {
//        ArrayList<Rutina> rutinas = new ArrayList<>();
//        Rutina rutina = null;
//        RutinaDB rutinaDB = new RutinaDB();
//        rutina = rutinaDB.selectById(2);
//        rutinaDB.insert("test1", Integer.);
//        System.out.println(rutina);
        ClienteDB b = new ClienteDB();
        b.insert("nombre_test_2", 2, 60, "1994-03-03", "M");
    }
}
