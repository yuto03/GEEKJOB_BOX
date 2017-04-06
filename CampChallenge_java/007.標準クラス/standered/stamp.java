/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pack;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.*;

/**
 *
 * @author osakayuto
 */
public class stamp extends HttpServlet {

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
        
        Date date = new Date();
        Date past = new Date();
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2016,1,1,0,0,0);
        Date calpast =cal2.getTime();
        
        Calendar cal =  Calendar.getInstance();
        cal.setTime(date);
        //Calendarクラスを使った表示法方
        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH)+1;
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        
        //画面の表示を変えたいときに使う
        SimpleDateFormat sdf = new
        SimpleDateFormat("yyyy年MM月dd日HH:mm:ss:");
        String sdate = sdf.format(date);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet stamp</title>");            
            out.println("</head>");
            out.println("<body>");
            //時刻の表示方法
            out.print("<br>"+date);
            //TimeStamp型で表示1970年からの総ミリ秒数
            out.print("<br>"+"タイムスタンプ"+calpast.getTime());
            out.println("<br>"+"sdf"+sdate);
            out.println("<br>"+calpast);
            out.println("<h1>Servlet stamp at " + request.getContextPath() + "</h1>");
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
