/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.UsuarioDB;
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
public class cambiarPassword extends HttpServlet {
    UsuarioDB usuarioDB = new UsuarioDB();
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
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        String roleId = request.getParameter("roleId");
        int roleIdInt = Integer.parseInt(roleId);
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        int userId = Integer.parseInt(session.getAttribute("auth_user_id").toString());
        String passwordUser = usuarioDB.getPassword(userId);
        if(passwordUser.equals(currentPassword)){
            if(usuarioDB.setPassword(userId, newPassword)){
                request.setAttribute("updatedPass", "Password actualizada");
                switch (roleIdInt){
            case UsuarioDB.ROLE_ENTRENADOR:
                request.getRequestDispatcher("principalEntrenador.jsp").forward(request, response);
                break;
            case UsuarioDB.ROLE_CLIENTE:
                request.getRequestDispatcher("principalCliente.jsp").forward(request, response);
                break;
            }
            }else{
//                no se modifico la contraseña
            }
        }else{
//            la contraseña ingresada no es la que tiene en la DB
        }
//        if (this.validarUser(username, password, roleIdInt)) {
//            switch (roleIdInt){
//            case UsuarioDB.ROLE_ADMIN:
//                response.sendRedirect("principalAdmin.jsp");
//                break;
//            case UsuarioDB.ROLE_ENTRENADOR:
//                response.sendRedirect("principalEntrenador.jsp");
//                break;
//            case UsuarioDB.ROLE_CLIENTE:
//                response.sendRedirect("principalCliente.jsp");
//                break;
//        }
//        }else{
//            response.sendRedirect("usuarioNoValido.jsp");
//        }
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
