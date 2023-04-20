/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Cuisinier;
import Model.Serveur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rindrarolando
 */
@WebServlet(name = "traitementLoginCuisinier", urlPatterns = {"/traitementLoginCuisinier"})
public class traitementLoginCuisinier extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String message = null;
        HttpSession session = request.getSession(true);
        try{
            if(new Cuisinier().treatlogin(login,password)!=null){
                Cuisinier cuisinier = new Cuisinier().treatlogin(login,password);
                session.setAttribute("session_cuisinier", cuisinier);
                this.getServletContext().getRequestDispatcher("/").forward(request, response);
            }else{
                message = "Une erreur s'est produite.";
                request.setAttribute("message_erreur", message);
                this.getServletContext().getRequestDispatcher("/login-cuisinier").forward(request, response);
            }
        }catch(Exception e){
            message = "Une erreur s'est produite.";
            request.setAttribute("message_erreur", message);
            this.getServletContext().getRequestDispatcher("/login-cuisinier").forward(request, response);
        }
    }

    
}
