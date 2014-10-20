/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Negocio.Ejercicio;
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
}
