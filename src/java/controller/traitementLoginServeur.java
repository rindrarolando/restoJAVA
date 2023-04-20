/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
@WebServlet(name = "traitementLoginServeur", urlPatterns = {"/traitementLoginServeur"})
public class traitementLoginServeur extends HttpServlet {

    

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
            if(new Serveur().treatlogin(login,password)!=null){
                Serveur serveur = new Serveur().treatlogin(login,password);
                session.setAttribute("session_serveur", serveur);
                this.getServletContext().getRequestDispatcher("/acceuilserveur.jsp").forward(request, response);
            }else{
                message = "Une erreur s'est produite.";
                request.setAttribute("message_erreur", message);
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }catch(Exception e){
                message = "Une erreur s'est produite.";
                request.setAttribute("message_erreur", message);
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

}
