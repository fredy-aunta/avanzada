/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;
import DB.*;
import Negocio.*;
import Services.Ejercicios;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author sebastian
 */
public class RutinaCtrl {
    private ArrayList<Rutina> rutinas = new ArrayList<>();
    private Rutina rutina;
    private RutinaDia rutinaDia;
    private RutinaDB rutinaDB = new RutinaDB();
    private RutinaDiaDB rutinaDiaDB = new RutinaDiaDB();
    private ClienteDB clienteDB = new ClienteDB();

    public RutinaCtrl() {
    }

    public RutinaCtrl(Rutina rutina) {
        this.rutina = rutina;
    }

    public ArrayList<Rutina> getRutinas() {
        return rutinas;
    }

    public void setRutinas(ArrayList<Rutina> rutinas) {
        this.rutinas = rutinas;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public RutinaDB getRutinaDB() {
        return rutinaDB;
    }

    public void setRutinaDB(RutinaDB rutinaDB) {
        this.rutinaDB = rutinaDB;
    }
    
    public void crearRutina(){
        this.rutina = new Rutina();
    }
    
    public void adicionarEjercicioDia(int dia, Ejercicio ejercicio) throws Exception{
        if (dia < 1 || dia > 7) {
            new Exception("Dia no valido");
        }
        if (rutina == null) {
            rutina = new Rutina();
        }
        rutinaDia = rutina.getRutinaDia(dia);
        Ejercicios ejercicios = rutinaDia.getEjerciciosDia();
        ejercicios.add(ejercicio);
        rutinaDia.setEjerciciosDia(ejercicios);
        
        rutina.setRutinaDIa(dia, rutinaDia);
    }
    
    public Vector getRutinaDias(int dia){
        return rutina.getRutinasDia().get(dia-1).getEjerciciosDia().getData();
    }
    
    public void grabarRutina(Cliente cliente, int idEntrenador){
        int idRutina = rutinaDB.insert("rutina-" + idEntrenador, idEntrenador);
        ArrayList<RutinaDia> rutinasDias = this.rutina.getRutinasDia();
        Ejercicios ejercicios;
        for (RutinaDia rutinasDia : rutinasDias) {
            ejercicios = rutinasDia.getEjerciciosDia();
            Vector<Ejercicio> ejercicios1 = ejercicios.getData();
            for (Ejercicio ejercicios11 : ejercicios1) {
                rutinaDiaDB.insert(idRutina, rutinasDia.getDiaRutina(), ejercicios11.getIdEjercicio());
            }
        }
        clienteDB.UpdateRutinaId(cliente.getIdCliente(), idRutina);
    }
}
