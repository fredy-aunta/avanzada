/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.ClienteDB;
import DB.UsuarioDB;
import Negocio.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fredy
 */
public class User extends HttpServlet {
    UsuarioDB usuarioDB = new UsuarioDB();
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
        HttpSession session = request.getSession();
        String roleId = request.getParameter("roleId");
        int roleIdInt = Integer.parseInt(roleId);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (this.validarUser(username, password, roleIdInt)) {
            int userId = usuarioDB.getId(username);
            session.setAttribute("auth_user_id", userId);
            switch (roleIdInt){
            case UsuarioDB.ROLE_ADMIN:
                request.getRequestDispatcher("principalAdmin.jsp").forward(request, response);
                break;
            case UsuarioDB.ROLE_ENTRENADOR:
                request.getRequestDispatcher("principalEntrenador.jsp").forward(request, response);
                break;
            case UsuarioDB.ROLE_CLIENTE:
                request.getRequestDispatcher("principalCliente.jsp").forward(request, response);
                break;
            }
        }else{
            request.setAttribute("errorLogin", "Usuario no valido");
            switch (roleIdInt){
            case UsuarioDB.ROLE_ADMIN:
                request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
                break;
            case UsuarioDB.ROLE_ENTRENADOR:
                request.getRequestDispatcher("loginEntrenador.jsp").forward(request, response);
                break;
            case UsuarioDB.ROLE_CLIENTE:
                request.getRequestDispatcher("loginCliente.jsp").forward(request, response);
                break;
        }
        }
    }
    
    public boolean validarUser(String nombre, String password, int roleID){
        return usuarioDB.buscarUser(nombre, password, roleID);
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
