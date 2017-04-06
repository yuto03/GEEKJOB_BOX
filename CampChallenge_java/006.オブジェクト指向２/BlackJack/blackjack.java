package org.pack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 *
 * @author osakayuto
 */
public class blackjack extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Dealer De =new Dealer();
        De.setCard(De.deal());
        De.checkSum();
        while(De.checkSum()==true){
            if(De.open()<21){
                De.setCard(De.hit());
            }
        }
        De.open();
        
        User user = new User();
        user.setCard(user.deal());
        user.checkSum();
        while(user.checkSum()==true){
            if(user.open()<21){
                user.setCard(De.hit());
            }
        } 
        user.open();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet blackjack</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("ユーザー" + user.open());
            out.println("ディーラー" + De.open());
            
            if(user.open()>21){
                out.print("<br>"+"User/Burst/LOSE");
            }else if(De.open()>21){
                out.print("<br>"+"Dealer/Burst/WIN");
            }else if(user.open() == De.open()){
                out.println("<br>"+"EVEN");
            }else if(user.open() > De.open()){
                out.print("<br>"+"WIN");
            }else if(user.open() < De.open()){
                out.print("LOSE");
            }
            out.println("<h1>Servlet blackjack at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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

