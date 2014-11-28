/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import DB.EjercicioDB;
import Negocio.Ejercicio;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 *
 * @author sebastian
 */
public class Ejercicios implements Iterator{
    private Vector data;
    private Enumeration ec;
    private Ejercicio nextEjercicio;
    
    public Ejercicios() {
        inicialize();
        ec = data.elements();
    }
    
    public Ejercicios(ArrayList<Ejercicio> arrayList) {
//        data = ;
        data = new Vector(arrayList);
        ec = data.elements();
    }

    private void inicialize() {
        data = new Vector();
        
    }
    public  boolean hasNext(){
        nextEjercicio=null;
        while(ec.hasMoreElements()){
            Ejercicio tempObj = (Ejercicio) ec.nextElement();
            nextEjercicio = tempObj;
            break;
        }
        return (nextEjercicio != null);
    }
    public Object next(){
        if(nextEjercicio == null){
            throw new NoSuchElementException();
        }else{
            return nextEjercicio;
        }
    }
    public void remove (){
        
    };
    
    public void add(Ejercicio ejercicio){
        data.add(ejercicio);
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }

    public Enumeration getEc() {
        return ec;
    }

    public void setEc(Enumeration ec) {
        this.ec = ec;
    }

    public Ejercicio getNextEjercicio() {
        return nextEjercicio;
    }

    public void setNextEjercicio(Ejercicio nextEjercicio) {
        this.nextEjercicio = nextEjercicio;
    }
    
    public Ejercicio searchById(int idEjercicio){
        EjercicioDB edb = new EjercicioDB();
        Ejercicio e = null;
        e = edb.selectById(idEjercicio);
            
        return e;
    }
    
    
}
