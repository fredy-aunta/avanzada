/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Negocio.Adelgazar;
import Negocio.Marcar;
import Negocio.Objetivo;
import java.util.ArrayList;

/**
 *
 * @author Fredy
 */
public class ObjetivoCtrl {
    ArrayList<Objetivo> objetivos = new ArrayList<>();

    public ObjetivoCtrl() {
    }

    public ArrayList<Objetivo> getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(ArrayList<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }
    
    public void cargarObjetivos(){
        objetivos = new ArrayList<>();
        objetivos.add(new Adelgazar());
        objetivos.add(new Marcar());
    }
}
