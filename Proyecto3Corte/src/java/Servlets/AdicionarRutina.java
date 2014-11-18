/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.ClienteDB;
import DB.EjercicioDB;
import DB.RutinaDB;
import DB.RutinaDiaDB;
import Negocio.Cliente;
import Negocio.Ejercicio;
import Negocio.Rutina;
import Negocio.RutinaDia;
import Services.Ejercicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
public class AdicionarRutina extends HttpServlet {

    RutinaDB rutinaDB = new RutinaDB();
    Rutina rutina = null;
    RutinaDia rutinaDia = null;
    Ejercicios ejercicios = null;
    Ejercicios todosEjercicios = null;
    ArrayList<Ejercicio> es = new ArrayList<Ejercicio>();
    EjercicioDB ejercicioDB = new EjercicioDB();
    RutinaDiaDB rutinaDiaDB =  new RutinaDiaDB();
    ClienteDB clienteDB = new ClienteDB();
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            rutina = new Rutina();
            this.cargarTodosEjercicios();
            todosEjercicios = new Ejercicios(es);
            for (int i = 1; i <= 7; i++) {
                rutinaDia = new RutinaDia();
                rutinaDia.setDiaRutina(i);
                ejercicios = new Ejercicios();
                
                String[] ejerciciosDias = request.getParameterValues("ejerciciosDia_" + i);
                if (ejerciciosDias != null && ejerciciosDias.length > 0) {
                    for (int j = 0; j < ejerciciosDias.length; j++) {
                        ejercicios.add(todosEjercicios.searchById(Integer.parseInt(ejerciciosDias[j])));
                    }
                }
                rutinaDia.setEjerciciosDia(ejercicios);
                rutina.setRutinaDIa(i, rutinaDia);
            }
            out.println(rutina);
        } finally {
            out.close();
        }
    }
    
    private void cargarTodosEjercicios(){
        es = ejercicioDB.select();
    }
    
    private void grabarRutina(Cliente cliente, int idEntrenador){
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
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
